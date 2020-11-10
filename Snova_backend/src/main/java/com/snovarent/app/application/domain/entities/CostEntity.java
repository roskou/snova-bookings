package com.snovarent.app.application.domain.entities;

import javax.persistence.*;
import java.sql.Date;

    @Entity
    @Table(name="discount")
    public class CostEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private Date starDate;
        private Date endDate;
        private String description;
        private int n_bookings;
        private int n_pax;
        private int actions;
        private int days;
        private double factor;



        public CostEntity(long id, Date starDate, Date endDate, String description, int n_bookings, int n_pax, int actions, int days, double factor) {
            setId (id);
            setStarDate (starDate);
            setEndDate (endDate);
            setDescription (description);
            setN_bookings (n_bookings);
            setN_pax (n_pax);
            setActions (actions);
            setDays (days);
            setFactor (factor);
        }


        public CostEntity(Date starDate, Date endDate, String description, int n_bookings, int n_pax, int actions, int days, double factor) {

            setStarDate (starDate);
            setEndDate (endDate);
            setDescription (description);
            setN_bookings (n_bookings);
            setN_pax (n_pax);
            setActions (actions);
            setDays (days);
            setFactor (factor);
        }

        public CostEntity() {
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

        public int getN_bookings() {
            return n_bookings;
        }

        public void setN_bookings(int n_bookings) {
            this.n_bookings = n_bookings;
        }

        public int getN_pax() {
            return n_pax;
        }

        public void setN_pax(int n_pax) {
            this.n_pax = n_pax;
        }

        public int getActions() {
            return actions;
        }

        public void setActions(int actions) {
            this.actions = actions;
        }

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
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
            return "CostEntity{" +
                    "id=" + id +
                    ", starDate=" + starDate +
                    ", endDate=" + endDate +
                    ", description='" + description + '\'' +
                    ", n_bookings=" + n_bookings +
                    ", n_pax=" + n_pax +
                    ", actions=" + actions +
                    ", days=" + days +
                    ", factor=" + factor +
                    '}';
        }
    }
