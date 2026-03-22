package com.example.springbootdemo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Retailer {

@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
   private int retid;
   private double reItemPrice;
   private LocalDateTime purchaseDate;
   @ManyToOne
   @JoinColumn(name = "cusid")
   private Customers customer;

   public Retailer(int retid, double reItemPrice, LocalDateTime purchaseDate, Customers customer) {
      this.retid = retid;
      this.reItemPrice = reItemPrice;
      this.purchaseDate = purchaseDate;
      this.customer = customer;
   }

   public int getRetid() {
      return retid;
   }

   public void setRetid(int retid) {
      this.retid = retid;
   }

   public double getReItemPrice() {
      return reItemPrice;
   }

   public void setReItemPrice(double reItemPrice) {
      this.reItemPrice = reItemPrice;
   }

   public LocalDateTime getPurchaseDate() {
      return purchaseDate;
   }

   public void setPurchaseDate(LocalDateTime purchaseDate) {
      this.purchaseDate = purchaseDate;
   }

   public Customers getCustomer() {
      return customer;
   }

   public void setCustomer(Customers customer) {
      this.customer = customer;
   }
}
