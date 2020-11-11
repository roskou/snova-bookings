package com.snovarent.app.application.models;


import java.sql.Date;

public class DiscountModel {


        private long id;
        private Date starDate;
        private Date endDate;
        private String description;
        private Integer nBookings;
        private Integer nPax;
        private Integer action;
        private Integer days;
        private Double factor;



        public DiscountModel(long id, Date starDate, Date endDate, String description, Integer nBookings, Integer nPax, Integer action, Integer days, Double factor) {
            setId (id);
            setStarDate (starDate);
            setEndDate (endDate);
            setDescription (description);
            setnBookings (nBookings);
            setnPax (nPax);
            setAction (action);
            setDays (days);
            setFactor (factor);
        }


        public DiscountModel(Date starDate, Date endDate, String description, Integer nBookings, Integer nPax, Integer action, Integer days, Double factor) {

            setStarDate (starDate);
            setEndDate (endDate);
            setDescription (description);
            setnBookings (nBookings);
            setnPax (nPax);
            setAction (action);
            setDays (days);
            setFactor (factor);
        }

        public DiscountModel() {
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getnBookings() {
        return nBookings;
    }

    public void setnBookings(Integer nBookings) {
        this.nBookings = nBookings;
    }

    public Integer getnPax() {
        return nPax;
    }

    public void setnPax(Integer nPax) {
        this.nPax = nPax;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getFactor() {
        return factor;
    }

    @Override
    public String toString() {
        return "DiscountModel{" +
                "id=" + id +
                ", starDate=" + starDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", nBookings=" + nBookings +
                ", nPax=" + nPax +
                ", action=" + action +
                ", days=" + days +
                ", factor=" + factor +
                '}';
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }
}



