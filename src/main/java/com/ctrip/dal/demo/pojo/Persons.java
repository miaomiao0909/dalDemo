package com.ctrip.dal.demo.pojo;

import com.ctrip.platform.dal.dao.annotation.Database;
import com.ctrip.platform.dal.dao.annotation.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.sql.Types;

/**
 * @author zh
 * Created on 2022/12/28
 */
@Entity
@Database(name = "fxdaltestdb_dalcluster")
@Table(name = "persons")
public class Persons{

    /**
     * 编号
     */
    @Id
    @Column(name = "Id_P")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(value = Types.INTEGER)
    private Integer idP;

    /**
     * 名字
     */
    @Column(name = "LastName")
    @Type(value = Types.VARCHAR)
    private String lastName;

    /**
     * 姓
     */
    @Column(name = "FirstName")
    @Type(value = Types.VARCHAR)
    private String firstName;

    /**
     * 城市
     */
    @Column(name = "City")
    @Type(value = Types.VARCHAR)
    private String city;

    /**
     * 地址
     */
    @Column(name = "Address")
    @Type(value = Types.VARCHAR)
    private String address;


    /**
     * 更新时间
     */
    @Column(name = "datachange_lasttime", insertable = false, updatable = false)
    @Type(value = Types.TIMESTAMP)
    private Timestamp datachangeLasttime;

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getDatachangeLasttime() {
        return datachangeLasttime;
    }

    public void setDatachangeLasttime(Timestamp datachangeLasttime) {
        this.datachangeLasttime = datachangeLasttime;
    }

    public Persons(String lastName, String firstName, String city, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.address = address;
    }


    public Persons() {
    }
}
