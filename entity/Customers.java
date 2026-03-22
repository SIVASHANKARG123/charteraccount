package com.example.springbootdemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cusid;
    private String cusname;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Retailer> retailer;

    public Customers(int cusid, String cusname, List<Retailer> retailer) {
        this.cusid = cusid;
        this.cusname = cusname;
        this.retailer = retailer;
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public List<Retailer> getTransactions() {
        return retailer;
    }

    public void setTransactions(List<Retailer> transactions) {
        this.retailer = retailer;
    }
}
