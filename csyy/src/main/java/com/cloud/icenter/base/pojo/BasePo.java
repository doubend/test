package com.cloud.icenter.base.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 实例公用父级对象
 * 
 * @author 刘磊
 * @version 2016年9月2日14:36:38
 */
@MappedSuperclass
public class BasePo implements Serializable, Cloneable {
    private static final long serialVersionUID = -6548095214083881384L;

    /**
     * 主键
     */
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    private String id;

    /**
     * 创建人
     */
    @Column(name = "CREATE_USER", length = 32)
    private String createUser;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * 更新人
     */
    @Column(name = "UPDATE_USER", length = 32)
    private String updateUser;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
