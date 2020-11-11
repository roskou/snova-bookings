package com.snovarent.app.application.domain.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cost")
public class DiscountEntity {
    private long id;
    private Date starDate;
    private Date endDate;
    private String description;
    private Integer nBookings;
    private Integer nPax;
    private Integer action;
    private Integer days;
    private Double factor;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "starDate")
    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    @Basic
    @Column(name = "endDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "nbookings")
    public Integer getnBookings() {
        return nBookings;
    }

    public void setnBookings(Integer nBookings) {
        this.nBookings = nBookings;
    }

    @Basic
    @Column(name = "npax")
    public Integer getnPax() {
        return nPax;
    }

    public void setnPax(Integer nPax) {
        this.nPax = nPax;
    }

    @Basic
    @Column(name = "action")
    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    @Basic
    @Column(name = "days")
    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Basic
    @Column(name = "factor")
    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }


}
