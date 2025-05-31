package com.tenpo.challengeBackend.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="percentage")
public class Percentage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;


    @Column(name="percentage_value")
    private double value;

    private Date date;

    public Percentage() {
    }

    public Percentage(long id, double value, Date date) {
        this.id = id;
        this.value = value;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
