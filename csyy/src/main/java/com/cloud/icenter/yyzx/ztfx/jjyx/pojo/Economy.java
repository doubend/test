package com.cloud.icenter.yyzx.ztfx.jjyx.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 工业经济总体表
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_jjfz_jjyx_gail")
public class Economy extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)       主键
	
	@Column(name = "tyear", length = 4)
	private Integer tyear;//                     char(4)           年份
	
	@Column(name = "zxzj_je")
	private BigDecimal zxzj_je;//					  float             专项资金，申请金额（万元）
	
	@Column(name = "zxzj_xms")
	private Integer zxzj_xms;//                  int               专项资金，项目数
	
	@Column(name = "gy_zysr")
	private BigDecimal gy_zysr;//                  float             主营收入
	
	@Column(name = "gy_gyscz")
	private BigDecimal gy_gyscz;//                  float             工业生产值
	
	@Column(name = "gy_cyzjz")
	private BigDecimal gy_cyzjz;//                float             产业增加值
	
	@Column(name = "gy_qys")
	private Integer gy_qys;//                    int               企业数
	
	@Column(name = "zz_zcz")
	private BigDecimal zz_zcz;//                    float             支柱产业总产值
	
	@Column(name = "zz_zs")
	private BigDecimal zz_zs;//                     float             支柱产业增速
	
	@Column(name = "zz_cyzs")
	private BigDecimal zz_cyzs;//                   float             产业增速
	
	@Column(name = "zz_zczzb")
	private BigDecimal zz_zczzb;//                 float             工业总产值占比
	
	@Column(name = "ttlhqy")
	private Integer ttlhqy;//                    int               淘汰落后企业
	
	@Column(name = "azry")
	private Integer azry;//                     int               安置人员
	
	@Column(name = "azry_qs")
	private String azry_qs;//                   char(1)           0下降，1上升
	
	@Column(name = "gbgnqys")
	private Integer gbgnqys;//                   int               关闭高能企业数
	
	@Column(name = "sqzxjz")
	private BigDecimal sqzxjz;//                    float             申请专项资金
	
	@Column(name = "sqzxzj_qs")
	private String sqzxzj_qs;//                 char(1)           0下降，1上升
	
	@Column(name = "create_time")
	private Timestamp create_time;//               timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//               timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//               timestamp         删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//              char(1)           1已删除，0正常

	public Integer getTyear() {
		return tyear;
	}

	public BigDecimal getZxzj_je() {
		return zxzj_je;
	}

	public Integer getZxzj_xms() {
		return zxzj_xms;
	}

	public BigDecimal getGy_zysr() {
		return gy_zysr;
	}

	public BigDecimal getGy_gyscz() {
		return gy_gyscz;
	}

	public BigDecimal getGy_cyzjz() {
		return gy_cyzjz;
	}

	public Integer getGy_qys() {
		return gy_qys;
	}

	public BigDecimal getZz_zcz() {
		return zz_zcz;
	}

	public BigDecimal getZz_zs() {
		return zz_zs;
	}

	public BigDecimal getZz_cyzs() {
		return zz_cyzs;
	}

	public BigDecimal getZz_zczzb() {
		return zz_zczzb;
	}

	public Integer getTtlhqy() {
		return ttlhqy;
	}

	public Integer getAzry() {
		return azry;
	}

	public String getAzry_qs() {
		return azry_qs;
	}

	public Integer getGbgnqys() {
		return gbgnqys;
	}

	public BigDecimal getSqzxjz() {
		return sqzxjz;
	}

	public String getSqzxzj_qs() {
		return sqzxzj_qs;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Timestamp getCreate_time() {
		return create_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Timestamp getUpdate_time() {
		return update_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Timestamp getDelete_time() {
		return delete_time;
	}

	public Integer getDelete_state() {
		return delete_state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTyear(Integer tyear) {
		this.tyear = tyear;
	}

	public void setZxzj_je(BigDecimal zxzj_je) {
		this.zxzj_je = zxzj_je;
	}

	public void setZxzj_xms(Integer zxzj_xms) {
		this.zxzj_xms = zxzj_xms;
	}

	public void setGy_zysr(BigDecimal gy_zysr) {
		this.gy_zysr = gy_zysr;
	}

	public void setGy_gyscz(BigDecimal gy_gyscz) {
		this.gy_gyscz = gy_gyscz;
	}

	public void setGy_cyzjz(BigDecimal gy_cyzjz) {
		this.gy_cyzjz = gy_cyzjz;
	}

	public void setGy_qys(Integer gy_qys) {
		this.gy_qys = gy_qys;
	}

	public void setZz_zcz(BigDecimal zz_zcz) {
		this.zz_zcz = zz_zcz;
	}

	public void setZz_zs(BigDecimal zz_zs) {
		this.zz_zs = zz_zs;
	}

	public void setZz_cyzs(BigDecimal zz_cyzs) {
		this.zz_cyzs = zz_cyzs;
	}

	public void setZz_zczzb(BigDecimal zz_zczzb) {
		this.zz_zczzb = zz_zczzb;
	}

	public void setTtlhqy(Integer ttlhqy) {
		this.ttlhqy = ttlhqy;
	}

	public void setAzry(Integer azry) {
		this.azry = azry;
	}

	public void setAzry_qs(String azry_qs) {
		this.azry_qs = azry_qs;
	}

	public void setGbgnqys(Integer gbgnqys) {
		this.gbgnqys = gbgnqys;
	}

	public void setSqzxjz(BigDecimal sqzxjz) {
		this.sqzxjz = sqzxjz;
	}

	public void setSqzxzj_qs(String sqzxzj_qs) {
		this.sqzxzj_qs = sqzxzj_qs;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public void setDelete_time(Timestamp delete_time) {
		this.delete_time = delete_time;
	}

	public void setDelete_state(Integer delete_state) {
		this.delete_state = delete_state;
	}
	

}
