package com.cloud.icenter.base.pojo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.persistence.Id;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 域模型基础类
 * @author zhangle
 */
public abstract class Pojo implements Serializable,Comparable<Pojo> {

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37).append(getId(this)).build();
	}

	@Override
	public boolean equals(Object domain) {
		if(domain==null) return false;
		if(this.getClass()!=domain.getClass()) return false;
		return new EqualsBuilder().append(getId(this), getId(domain)).build();
	}

	@Override
	public int compareTo(Pojo domain) {
		if(domain==null) return 1;
		if(this.getClass()!=domain.getClass()) return 1;
		return new CompareToBuilder().append(getCompareValue(this), getCompareValue(domain)).build();
	}
	
	private Object getId(Object domain) {
		try {
			for(Field f:domain.getClass().getDeclaredFields()) {
				if(f.getAnnotation(Id.class)!=null) {
					f.setAccessible(true);
					return f.get(domain);
				}
			}
			for(Method m:domain.getClass().getDeclaredMethods()) {
				if(m.getAnnotation(Id.class)!=null) {
					return m.invoke(domain);
				}
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException("获取主键值失败!",e);
		}
	}
	
	private Object getCompareValue(Pojo domain) {
		try {
			Field compareField=domain.getClass().getDeclaredField("seqNum");
			compareField.setAccessible(true);
			return compareField.get(domain);
		} catch (Exception e) {
			return getId(domain);
		}
	}
}
