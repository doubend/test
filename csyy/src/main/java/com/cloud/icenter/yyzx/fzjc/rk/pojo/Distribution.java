package com.cloud.icenter.yyzx.fzjc.rk.pojo;

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
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_renk_rkfb_rkfb")
public class Distribution extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)       主键
	
	@Column(name = "city", length = 20)
	private String city;//

	@Column(name = "tyear")
	private Integer tyear;//					  char(4)           年份     
	
	@Column(name = "age_group_one")
	private BigDecimal data1;//				  smallint          年龄段(最小值)
	
	@Column(name = "age_group_tow")
	private BigDecimal data2;//              smallint          年龄段(最大值)
	
	@Column(name = "age_group_three")
	private BigDecimal data3;

	@Column(name = "proportion")
	private BigDecimal proportion;//               float             占总人口比例
	
	@Column(name = "mwb")
	private BigDecimal mwb; //男女比例
	
	@Column(name = "density")
	private Integer density;//                  int               人口密度（人／k㎡）
	
	@Column(name = "man_val")
	private BigDecimal man_val;//                   decimal(10,2)     男性数量
	
	@Column(name = "wom_val")
	private BigDecimal wom_val;//                   decimal(10,2)     女性数量
	
	@Column(name = "xsye_man")
	private BigDecimal xsye_man;//                 decimal(10,2)     新生婴儿男人数量
	
	@Column(name = "xsye_wom")
	private BigDecimal xsye_wom;//                  decimal(10,2)     新生婴儿女人数量
	
	@Column(name = "ldrk_man")
	private BigDecimal ldrk_man;//                 decimal(10,2)     流动人口男人数量
	
	@Column(name = "ldrk_wom")
	private BigDecimal ldrk_wom;//                  decimal(10,2)     流动人口女人数量
	
	@Column(name = "nyrk_man")
	private BigDecimal nyrk_man;//                  decimal(10,2)     农业人口男人数量
	
	@Column(name = "nyrk_wom")
	private BigDecimal nyrk_wom;//                  decimal(10,2)     农业人口女人数量
	
	@Column(name = "age_group_one_man")
	private BigDecimal data1_man;//                 decimal(10,2)     0~14岁男人数量
	
	@Column(name = "age_group_one_wom")
	private BigDecimal data1_wom;//                 decimal(10,2)     0~14岁女人数量
	
	@Column(name = "age_group_tow_man")
	private BigDecimal data2_man;//                 decimal(10,2)     15~64岁男人数量
	
	@Column(name = "age_group_tow_wom")
	private BigDecimal data2_wom;//                 decimal(10,2)     15~64岁女人数量
	
	@Column(name = "age_group_three_man")
	private BigDecimal data3_man;//                 decimal(10,2)     64岁以上男人数量
	
	@Column(name = "age_group_three_wom")
	private BigDecimal data3_wom;//                 decimal(10,2)     64岁以上女人数量
	
	@Column(name = "create_time")
	private Timestamp create_time;//               timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp  update_time;//              timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp  delete_time;//            timestamp         删除时间
	
	@Column(name = "delete_state",length = 1)
	private Integer  delete_state;//            char(1)           1已删除，0正常

	public String getCity() {
		return city;
	}

	public Integer getTyear() {
		return tyear;
	}

	

	public BigDecimal getProportion() {
		return proportion;
	}

	public BigDecimal getMwb() {
		return mwb;
	}

	public Integer getDensity() {
		return density;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Timestamp getCreate_time() {
		return create_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Timestamp getUpdate_time() {
		return update_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

	public void setCity(String city) {
		this.city = city;
	}

	public void setTyear(Integer tyear) {
		this.tyear = tyear;
	}

	

	public BigDecimal getData1() {
		return data1;
	}

	public void setData1(BigDecimal data1) {
		this.data1 = data1;
	}

	public BigDecimal getData2() {
		return data2;
	}

	public void setData2(BigDecimal data2) {
		this.data2 = data2;
	}

	public BigDecimal getData3() {
		return data3;
	}

	public void setData3(BigDecimal data3) {
		this.data3 = data3;
	}

	public void setProportion(BigDecimal proportion) {
		this.proportion = proportion;
	}

	public void setMwb(BigDecimal mwb) {
		this.mwb = mwb;
	}

	public void setDensity(Integer density) {
		this.density = density;
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

	public BigDecimal getMan_val() {
		return man_val;
	}

	public BigDecimal getWom_val() {
		return wom_val;
	}

	public BigDecimal getXsye_man() {
		return xsye_man;
	}

	public BigDecimal getXsye_wom() {
		return xsye_wom;
	}

	public BigDecimal getLdrk_man() {
		return ldrk_man;
	}

	public BigDecimal getLdrk_wom() {
		return ldrk_wom;
	}

	public BigDecimal getNyrk_man() {
		return nyrk_man;
	}

	public BigDecimal getNyrk_wom() {
		return nyrk_wom;
	}

	public BigDecimal getData1_man() {
		return data1_man;
	}

	public BigDecimal getData1_wom() {
		return data1_wom;
	}

	public BigDecimal getData2_man() {
		return data2_man;
	}

	public BigDecimal getData2_wom() {
		return data2_wom;
	}

	public BigDecimal getData3_man() {
		return data3_man;
	}

	public BigDecimal getData3_wom() {
		return data3_wom;
	}

	public void setMan_val(BigDecimal man_val) {
		this.man_val = man_val;
	}

	public void setWom_val(BigDecimal wom_val) {
		this.wom_val = wom_val;
	}

	public void setXsye_man(BigDecimal xsye_man) {
		this.xsye_man = xsye_man;
	}

	public void setXsye_wom(BigDecimal xsye_wom) {
		this.xsye_wom = xsye_wom;
	}

	public void setLdrk_man(BigDecimal ldrk_man) {
		this.ldrk_man = ldrk_man;
	}

	public void setLdrk_wom(BigDecimal ldrk_wom) {
		this.ldrk_wom = ldrk_wom;
	}

	public void setNyrk_man(BigDecimal nyrk_man) {
		this.nyrk_man = nyrk_man;
	}

	public void setNyrk_wom(BigDecimal nyrk_wom) {
		this.nyrk_wom = nyrk_wom;
	}

	public void setData1_man(BigDecimal data1_man) {
		this.data1_man = data1_man;
	}

	public void setData1_wom(BigDecimal data1_wom) {
		this.data1_wom = data1_wom;
	}

	public void setData2_man(BigDecimal data2_man) {
		this.data2_man = data2_man;
	}

	public void setData2_wom(BigDecimal data2_wom) {
		this.data2_wom = data2_wom;
	}

	public void setData3_man(BigDecimal data3_man) {
		this.data3_man = data3_man;
	}

	public void setData3_wom(BigDecimal data3_wom) {
		this.data3_wom = data3_wom;
	}

	
}
