package com.aegisa.beans;

import java.util.*;

public class Customer {
    private Integer cid;
    private String nickname;
    private String mobile;
    private String address;
    private String name;

    private String idNumber;

    private Date firstAdd;
    private String gender;
    private String cnote;
    private String special;

    private String inUse;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCnote() {
        return cnote;
    }

    public void setCnote(String cnote) {
        this.cnote = cnote;
    }

    public String getNickname() {
        return nickname;
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse(String inUse) {
        this.inUse = inUse;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getFirstAdd() {
        return firstAdd;
    }

    public void setFirstAdd(Date firstAdd) {
        this.firstAdd = firstAdd;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", nickname='" + nickname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", firstAdd=" + firstAdd +
                ", gender='" + gender + '\'' +
                ", cnote='" + cnote + '\'' +
                ", special='" + special + '\'' +
                '}';
    }
}