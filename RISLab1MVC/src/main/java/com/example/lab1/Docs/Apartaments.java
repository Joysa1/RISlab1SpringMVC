package com.example.lab1.Docs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Apartaments")
public class Apartaments {
    @Id
    private String _Id;
    private String owner;
    private boolean allowAnimals;
    private String address;
    private String region;
    private Integer counter = 0;

    public Apartaments(String owner, boolean allowAnimals, String address, String region) {
        this.owner = owner;
        this.allowAnimals = allowAnimals;
        this.address = address;
        this.region = region;
    }

    public String getId() {
        return _Id;
    }

    public void setId(String id) {
        _Id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isAllowAnimals() {
        return allowAnimals;
    }

    public void setAllowAnimals(boolean allowAnimals) {
        this.allowAnimals = allowAnimals;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getCounter() {
        return counter;
    }
    public void incrementCounter(){
        counter = counter+1;
    }

    @Override
    public String toString() {
        return "Apartaments{" +
                "owner='" + owner + '\'' +
                ", allowAnimals=" + allowAnimals +
                ", address='" + address + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}