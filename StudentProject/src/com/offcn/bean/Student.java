package com.offcn.bean;


import java.sql.Date;

public class Student {

    private Integer sid; //INT PRIMARY KEY AUTO_INCREMENT,
    private String sname; //VARCHAR(50),
    private String gender; //VARCHAR(2),
    private Date sbir;//DATE,
    private  String hobby; //VARCHAR(200),
    private  String photo;//VARCHAR(200)

    public Student() {
    }

    public Student(Integer sid, String sname, String gender, Date sbir, String hobby, String photo) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.sbir = sbir;
        this.hobby = hobby;
        this.photo = photo;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getSbir() {
        return sbir;
    }

    public void setSbir(Date sbir) {
        this.sbir = sbir;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", sbir=" + sbir +
                ", hobby='" + hobby + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
