package com.snovarent.app.application.domain.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cost", schema = "hotel")
public class CostEntity {
    private long id;
    private Date starDate;
    private Date endDate;
    private String description;
    private Integer nbookings;
    private Integer npax;
    private Integer action;
    private Integer days;
    private double factor;

    public CostEntity(long id, Date starDate, Date endDate, String description, Integer nbookings, Integer npax, Integer action, Integer days, double factor) {
        this.id = id;
        this.starDate = starDate;
        this.endDate = endDate;
        this.description = description;
        this.nbookings = nbookings;
        this.npax = npax;
        this.action = action;
        this.days = days;
        this.factor = factor;
    }

    public CostEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public Integer getNbookings() {
        return nbookings;
    }

    public void setNbookings(Integer nbookings) {
        this.nbookings = nbookings;
    }

    @Basic
    @Column(name = "npax")
    public Integer getNpax() {
        return npax;
    }

    public void setNpax(Integer npax) {
        this.npax = npax;
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
    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CostEntity that = (CostEntity) o;

        if (id != that.id) return false;
        if (starDate != null ? !starDate.equals(that.starDate) : that.starDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (nbookings != null ? !nbookings.equals(that.nbookings) : that.nbookings != null) return false;
        if (npax != null ? !npax.equals(that.npax) : that.npax != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (days != null ? !days.equals(that.days) : that.days != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (starDate != null ? starDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (nbookings != null ? nbookings.hashCode() : 0);
        result = 31 * result + (npax != null ? npax.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);

        return result;
    }
}
