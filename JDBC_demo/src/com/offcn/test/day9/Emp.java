package com.offcn.test.day9;

import java.util.Date;

public class Emp {
    private Integer eid;
    private String ename;
    private String job;
    private Date hiredate;
    private Double sal;

    public Emp() {
    }

    public Emp(Integer eid, String ename, String job, Date hiredate, Double sal) {
        this.eid = eid;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Users{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                '}';
    }
}
