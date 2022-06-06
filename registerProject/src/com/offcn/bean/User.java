package com.offcn.bean;

public class User {
    private Integer uid ;//INT PRIMARY KEY AUTO_INCREMENT,#用户编号
    private String name ;//VARCHAR(50),#姓名
    private Integer age ;//INT,#年龄
    private String gender ;// CHAR(1),#性别
    private String address ;// VARCHAR(50)#地址

    public User() {
    }

    public User(Integer uid, String name, Integer age, String gender, String address) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
