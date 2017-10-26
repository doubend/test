package com.cloud.icenter.yyzx.cszc.tjfx.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;
/**
 * 教育分析--文化程度分析
 * @date 2017年10月11日
 * @author dxliug
 */
@Entity
@Table(name = "t_cszc_jyfzfx_whcd")
public class WhcdPojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String areas = "桓台县";

	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
	
	@Column(name="total")
	private Float total = 0f;//总人口
	
	@Column(name="sjy_total")
	private Float sjyTotal = 0f;//受教育总人口
	
	@Column(name="sjy_t_zb")
	private Float sjyTZb = 0f;//受教育总人口占比
	
	@Column(name="xx_total")
	private Float xxTotal = 0f;//小学学历人口
	
	@Column(name="xx_t_zb")//小学学历占比
	private Float xxTZb = 0f;
	
	@Column(name="cz_total")
	private Float czTotal = 0f;//初中学历人口
	
	@Column(name="cz_t_zb")
	private Float czTZb = 0f;
	
	@Column(name="gz_total")
	private Float gzTotal = 0f;//高中人口
	
	@Column(name="gz_t_zb")
	private Float gzTZb = 0f;//高中占比
	
	@Column(name="dx_total")
	private Float dxTotal = 0f;//大学
	
	@Column(name="dx_t_zb")
	private Float dxTZb = 0f;
	
	 @Column(name = "tyear",length = 1)
	 private Integer tyear;//统计年份
	 
	 @Column(name = "area")
	 private String area;//区域
	 
	 @Column(name="xxss_total")
	 private Float xxssTotal = 0f;//小学师生数
	 
	 @Column(name="czss_total")
	 private Float czssTotal = 0f;//初中师生数
	 
	 @Column(name="gzss_total")
	 private Float gzssTotal = 0f;//高中师生数
	 
	 @Column(name="xxsc_total")
	 private Float xxscTotal = 0f;//小学数量
	 
	 @Column(name="czsc_total")
	 private Float czscTotal = 0f;//初中数量
	 
	 @Column(name="gzsc_total")//高中数量
	 private Float gzscTotal = 0f;
	 
	 @Column(name="man")
	 private Float man;//受教育男
	 
	 @Column(name="woman")
	 private Float woman;
	 
	 @Column(name = "create_time")
     private Timestamp createTime;
	 @Column(name = "update_time")
     private Timestamp updateTime;
	 @Column(name = "delete_time")
     private Timestamp deleteTime;
	 @Column(name = "delete_state", length = 32 )
     private String deleteState;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Float getSjyTotal() {
		return sjyTotal;
	}
	public void setSjyTotal(Float sjyTotal) {
		this.sjyTotal = sjyTotal;
	}
	public Float getSjyTZb() {
		return sjyTZb;
	}
	public void setSjyTZb(Float sjyTZb) {
		this.sjyTZb = sjyTZb;
	}
	public Float getXxTotal() {
		return xxTotal;
	}
	public void setXxTotal(Float xxTotal) {
		this.xxTotal = xxTotal;
	}
	public Float getXxTZb() {
		return xxTZb;
	}
	public void setXxTZb(Float xxTZb) {
		this.xxTZb = xxTZb;
	}
	public Float getCzTotal() {
		return czTotal;
	}
	public void setCzTotal(Float czTotal) {
		this.czTotal = czTotal;
	}
	public Float getCzTZb() {
		return czTZb;
	}
	public void setCzTZb(Float czTZb) {
		this.czTZb = czTZb;
	}
	public Float getGzTotal() {
		return gzTotal;
	}
	public void setGzTotal(Float gzTotal) {
		this.gzTotal = gzTotal;
	}
	public Float getGzTZb() {
		return gzTZb;
	}
	public void setGzTZb(Float gzTZb) {
		this.gzTZb = gzTZb;
	}
	public Float getDxTotal() {
		return dxTotal;
	}
	public void setDxTotal(Float dxTotal) {
		this.dxTotal = dxTotal;
	}
	public Float getDxTZb() {
		return dxTZb;
	}
	public void setDxTZb(Float dxTZb) {
		this.dxTZb = dxTZb;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Timestamp getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getTyear() {
		return tyear;
	}
	public void setTyear(Integer tyear) {
		this.tyear = tyear;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Float getXxssTotal() {
		return xxssTotal;
	}
	public void setXxssTotal(Float xxssTotal) {
		this.xxssTotal = xxssTotal;
	}
	public Float getCzssTotal() {
		return czssTotal;
	}
	public void setCzssTotal(Float czssTotal) {
		this.czssTotal = czssTotal;
	}
	public Float getGzssTotal() {
		return gzssTotal;
	}
	public void setGzssTotal(Float gzssTotal) {
		this.gzssTotal = gzssTotal;
	}
	public Float getXxscTotal() {
		return xxscTotal;
	}
	public void setXxscTotal(Float xxscTotal) {
		this.xxscTotal = xxscTotal;
	}
	public Float getCzscTotal() {
		return czscTotal;
	}
	public void setCzscTotal(Float czscTotal) {
		this.czscTotal = czscTotal;
	}
	public Float getGzscTotal() {
		return gzscTotal;
	}
	public void setGzscTotal(Float gzscTotal) {
		this.gzscTotal = gzscTotal;
	}
	public Float getMan() {
		return man;
	}
	public void setMan(Float man) {
		this.man = man;
	}
	public Float getWoman() {
		return woman;
	}
	public void setWoman(Float woman) {
		this.woman = woman;
	}
	public static String getAreas() {
		return areas;
	}
	 
	 
}
