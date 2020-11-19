package com.snovarent.app.application.models;


import java.sql.Date;

public class CostModel {


        private long id;
        private Date starDate;
        private Date endDate;
        private String description;
        private Integer nbookings;
        private Integer npax;
        private Integer action;
        private Integer days;
        private double factor;



        public CostModel(long id, Date starDate, Date endDate, String description, Integer nbookings, Integer npax, Integer action, Integer days, double factor) {
            setId (id);
            setStarDate (starDate);
            setEndDate (endDate);
            setDescription (description);
            setNbookings (nbookings);
            setNpax (npax);
            setAction (action);
            setDays (days);
            setFactor (factor);
        }


        public CostModel(Date starDate, Date endDate, String description, Integer nbookings, Integer npax, Integer action, Integer days, double factor) {

            setStarDate (starDate);
            setEndDate (endDate);
            setDescription (description);
            setNbookings (nbookings);
            setNpax (npax);
            setAction (action);
            setDays (days);
            setFactor (factor);
        }

        public CostModel() {
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
        return nbookings;
    }

    public void setNbookings(Integer nBookings) {
        this.nbookings = nbookings;
    }

    public Integer getNpax() {
        return npax;
    }

    public void setNpax(Integer npax) {
        this.npax = npax;
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

    public double getFactor() {
        return factor;
    }



    public void setFactor(double factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return "CostModel{" +
                "starDate=" + starDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", nbookings=" + nbookings +
                ", npax=" + npax +
                ", action=" + action +
                ", days=" + days +
                ", factor=" + factor +
                '}';
    }
}



