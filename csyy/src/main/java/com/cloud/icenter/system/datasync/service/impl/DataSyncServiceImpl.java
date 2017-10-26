package com.cloud.icenter.system.datasync.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cloud.icenter.common.utils.DESUtil;
import com.cloud.icenter.common.utils.DateUtil;
import com.cloud.icenter.common.utils.Md5Util;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.common.utils.WebServiceClient;
import com.cloud.icenter.system.datasync.service.DataSyncService;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.system.organ.dao.OrganDao;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.role.dao.RoleDao;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.user.dao.UserDao;
import com.cloud.icenter.system.user.pojo.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Logging
@Service
@Transactional
public class DataSyncServiceImpl implements DataSyncService {

	private final String URL = SystemConfig.getProperty("sync.url");
	private final String method = SystemConfig.getProperty("sync.method");
	private final String mqname = SystemConfig.getProperty("sync.mqname");
	private final String key = SystemConfig.getProperty("sync.key");
	private final String dev=SystemConfig.getProperty("system.role.developer");
	private final String flagOne = "1";// 新增数据
	private final String flagTwo = "2";// 修改数据
	private final String flagThree = "3";// 删除数据
	private final String orgRootID = "-1";// 删除数据

	@Autowired
	private UserDao userDao;
	@Autowired
	private OrganDao organDao;
	@Autowired
	private RoleDao roleDao;
	@Override
	public void syncUsers(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Role devRole= roleDao.getRoleByName(dev);
		// 允许出现特殊字符和转义符
		mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		try {
			List<Map> list = mapper.readValue(json, List.class);
			for (Map map : list) {
				//System.out.println(map);
//				if (map.get("flag").toString().equals(flagOne)) {
//					//多次同步添加用户时，去除重复同步用户
//					User users = userDao.getUserByName(map.get("uid").toString());
//					if (users!=null) {
//						userDao.delete(users.getUserId());
//						organDao.deleteByUserID(users.getUserId());
//					}
//					User user = new User();
//					user.setUsername(map.get("uid").toString());
//					user.setNickname(map.get("name").toString());
//					user.setCreatedAt(new Date());
//					user.setStatus(User.STATUS_DEFAULT);
//					//user.setUserId(map.get("uid").toString());
//					user.setPassword(map.get("uid").toString()+"88888888");
//					user.setSalt(map.get("uid").toString());
//					if ("0".equals(map.get("orgId").toString()) && devRole!=null) {
//						user.setCheckedRoleId(new String[]{devRole.getRoleId()});
//					}
//					userDao.add(user);
//					if (!StringUtil.isEmpty(map.get("orgId").toString()) && !"0".equals(map.get("orgId").toString())) {
//						String[] orgid = map.get("orgId").toString().split(",");
//						for (String org : orgid) {
//							Organ pOrgan = organDao.get(org);
//							if (pOrgan != null) {
//								Organ organ = new Organ();
//								organ.setOrgId(Md5Util.randomUUID());
//								organ.setParentId(org);
//								organ.setUserId(user.getUserId());
//								organ.setName(map.get("name").toString());
//								organ.setType(Organ.TYPE_EMPLOYEE);
//								organ.setStatus(Organ.STATUS_DEFAULT);
//								organ.setMain(Organ.MAIN_NO);
//								organDao.add(organ);
//							}
//						}
//					}
//
//				} else 
				if (map.get("flag").toString().equals(flagTwo) || map.get("flag").toString().equals(flagOne)) {
					User user = userDao
							.getUserByName(map.get("uid").toString());
					if (user != null) {
						user.setNickname(map.containsKey("name") ? map.get(
								"name").toString() : map.get("uid").toString());
						userDao.update(user);
						String userOrgan = organDao.getOrganByUserId(user
								.getUserId());
						if (map.containsKey("orgId")
								&& !StringUtil.isEmpty(map.get("orgId")
										.toString())) {
							System.out.println("userOrgan:"+userOrgan);
							String addOrgan = "";
							if (!StringUtil.isEmpty(userOrgan)) {
								addOrgan = StringUtil.getExist(
										userOrgan.split(","), map.get("orgId")
												.toString().split(","));
							}
							String delOrgan = StringUtil.getExist(
									map.get("orgId").toString().split(","),
									userOrgan.split(","));
							//System.out.println("addOrgan:"+addOrgan);
							//System.out.println("delOrgan:"+delOrgan);
							if (!StringUtil.isEmpty(addOrgan)) {
								String[] orgid = addOrgan.split(",");
								for (String org : orgid) {
									Organ pOrgan = organDao.get(org);
									if (pOrgan != null) {
										Organ organ = new Organ();
										organ.setOrgId(Md5Util.randomUUID());
										organ.setParentId(org);
										organ.setUserId(user.getUserId());
										organ.setName(map.get("name")
												.toString());
										organ.setType(Organ.TYPE_EMPLOYEE);
										organ.setStatus(Organ.STATUS_DEFAULT);
										organ.setMain(Organ.MAIN_NO);
										organDao.add(organ);
									}
								}
							}
							if (!StringUtil.isEmpty(delOrgan)) {
								organDao.deleteByUserAndParent(
										user.getUserId(), delOrgan.split(","));
							}
							//更新组织机构关联用户名
							organDao.updateOrganNameByUserID(user.getUserId(), user.getNickname());
						} 
						if (map.containsKey("orgId")
								&& StringUtil.isEmpty(map.get("orgId")
										.toString())) {
							organDao.deleteByUserAndParent(user.getUserId(),
									userOrgan.split(","));
						}
					} else {
						User users = new User();
						users.setUsername(map.get("uid").toString());
						users.setNickname(map.containsKey("name") ? map.get(
								"name").toString() : map.get("uid").toString());
						users.setCreatedAt(new Date());
						users.setStatus(User.STATUS_DEFAULT);
						users.setPassword(map.get("uid").toString()+"88888888");
						users.setSalt(map.get("uid").toString());
						userDao.add(users);
						if (map.containsKey("orgId")
								&& !StringUtil.isEmpty(map.get("orgId")
										.toString())) {
							String[] orgid = map.get("orgId").toString()
									.split(",");
							for (String org : orgid) {
								Organ pOrgan = organDao.get(org);
								if (pOrgan != null) {
									Organ organ = new Organ();
									organ.setOrgId(Md5Util.randomUUID());
									organ.setParentId(org);
									organ.setUserId(users.getUserId());
									organ.setName(map.get("name").toString());
									organ.setType(Organ.TYPE_EMPLOYEE);
									organ.setStatus(Organ.STATUS_DEFAULT);
									organ.setMain(Organ.MAIN_NO);
									organDao.add(organ);
								}
							}
						}
					}

				} else if (map.get("flag").toString().equals(flagThree)) {
					User users = userDao.getUserByName(map.get("uid").toString());
					if (users!=null) {
						userDao.delete(users.getUserId());
						organDao.deleteByUserID(users.getUserId());
					}
					
				}
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void syncOrgan(String json) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		// 允许出现特殊字符和转义符
		mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		try {
			List<Map> list = mapper.readValue(json, List.class);
			for (Map map : list) {
				if (map.get("flag").toString().equals(flagTwo)
						|| map.get("flag").toString().equals(flagOne)) {
					Organ organ = organDao.get(map.get("orgId").toString());
					if (organ == null) {
						organ = new Organ();
						if (!map.get("parentId").toString().equals(orgRootID)) {
							organ.setParentId(map.get("parentId").toString());
						}
						organ.setOrgId(map.get("orgId").toString());
						organ.setName(map.get("orgName").toString());
						organ.setType(Organ.TYPE_DEPARTMENT);// 企业
						organ.setStatus(Organ.STATUS_DEFAULT);
						organDao.add(organ);
					} else {
						if (map.containsKey("parentId") && !map.get("parentId").toString().equals(orgRootID)) {
							organ.setParentId(map.get("parentId").toString());
						}
						organ.setName(map.get("orgName").toString());
						organDao.update(organ);
					}
				} else if (map.get("flag").toString().equals(flagThree)) {
					organDao.delete(map.get("orgId").toString());
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public String sync() {
		String msg = "OK";
		WebServiceClient client = new WebServiceClient();
		Object str = client.connect(URL).send(method, new Object[] { mqname });
		if (null != str && !StringUtil.isEmpty(str.toString())) {
			JSONArray array = JSON.parseArray(str.toString());
			for (Object object : array) {
				String xmlString;
				try {
					xmlString = DESUtil.decrypt(object.toString(), key);
					String typeString = StringUtil.getParameter(xmlString,
							"ServiceName");
					String jsonString = StringUtil.getParameter(xmlString,
							"Body");
					System.out.println("typeString："+typeString +"  "+DateUtil.date2String(new Date()));
					System.out.println("jsonString："+jsonString);
					if ("ZZJG_YHTB".equals(typeString)
							&& !StringUtil.isEmpty(jsonString)) {
						syncUsers(jsonString);
					} else if ("ZZJG_ZZTB".equals(typeString)
							&& !StringUtil.isEmpty(jsonString)) {
						syncOrgan(jsonString);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			msg = "报文为空！";
			System.out.println("报文为空！");
		}
		return msg;
	}

	@Override
	public void syncAllOrganData(String json) {
		ObjectMapper mapper = new ObjectMapper();
		// 允许出现特殊字符和转义符
		mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		try {
			List<Map> list = mapper.readValue(json, List.class);
			boolean flag = false;
			for (Map map : list) {
				Organ organ = organDao.get(map.get("orgId").toString()); //
				if (organ == null) {
					organ = new Organ();
					flag = true;
				}
				organ.setParentId(map.get("parentId").toString());
				organ.setOrgId(map.get("orgId").toString());
				organ.setName(map.get("orgName").toString());
				// organ.setShortName(map.get("orgName").toString());
				organ.setType(Organ.TYPE_DEPARTMENT);// 部门
				organ.setStatus(Organ.STATUS_DEFAULT);
				if (flag) {
					organDao.add(organ);
				} else {
					organDao.update(organ);
				}
			}

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
