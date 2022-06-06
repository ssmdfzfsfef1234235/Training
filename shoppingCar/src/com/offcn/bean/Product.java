package com.offcn.bean;

import java.sql.Date;

public class Product {
    private Integer pid;// int(11) NOT NULL,
    private String pname;// varchar(200) DEFAULT NULL,
    private Integer price;// INT DEFAULT NULL,
    private String pdesc;// varchar(200) DEFAULT NULL,
    private Date pdate;// date DEFAULT NULL,

    public Product() {
    }

    public Product(Integer pid, String pname, Integer price, String pdesc, Date pdate) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.pdesc = pdesc;
        this.pdate = pdate;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", pdesc='" + pdesc + '\'' +
                ", pdate=" + pdate +
                '}';
    }
}
