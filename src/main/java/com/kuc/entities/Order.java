package com.kuc.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Order {
    @Id @GeneratedValue 
    private Long id;

    private int price;
    private int area;
    private BuildType buildType;
    private Long userId;
    private String fullName;
    private Date createdAt;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArea() {
        return this.area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public BuildType getBuildType() {
        return this.buildType;
    }

    public void setBuildType(BuildType buildType) {
        this.buildType = buildType;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", price='" + getPrice() + "'" +
            ", area='" + getArea() + "'" +
            ", buildType='" + getBuildType() + "'" +
            ", userId='" + getUserId() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            "}";
    }

}
