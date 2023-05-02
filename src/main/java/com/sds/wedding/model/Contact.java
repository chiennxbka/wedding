package com.sds.wedding.model;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String aliasName;

    private double amount;

    private String address;

    public Contact() {

    }

    public Contact(String name, double amount, String address) {
        this.aliasName = name.substring(0, (name.indexOf(" ")));
        this.name = name.substring(name.indexOf(" "));
        this.amount = amount;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return aliasName.concat(" " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAmount() {
        return amount;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
