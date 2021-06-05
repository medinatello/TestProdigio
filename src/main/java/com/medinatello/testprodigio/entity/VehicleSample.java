package com.medinatello.testprodigio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Calendar;

@Entity(name = "Vehiclesample")
@JsonIgnoreProperties(ignoreUnknown=true)
public class VehicleSample implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer countyFips;
    private String countyName;
    private String stateName;
    private Calendar date;
    private Integer countyVmt;
    private Integer baselineJanVmt;
    private Long percentChangeFromJan;
    private Long mean7CountyVmt;
    private Long mean7PercentChangeFromJan;
    private Calendar dateAtLow;
    private Long mean7CountyVmtAtLow;
    private Long percentChangeFromLow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCountyFips() {
        return countyFips;
    }

    public void setCountyFips(Integer countyFips) {
        this.countyFips = countyFips;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Integer getCountyVmt() {
        return countyVmt;
    }

    public void setCountyVmt(Integer countyVmt) {
        this.countyVmt = countyVmt;
    }

    public Integer getBaselineJanVmt() {
        return baselineJanVmt;
    }

    public void setBaselineJanVmt(Integer baselineJanVmt) {
        this.baselineJanVmt = baselineJanVmt;
    }

    public Long getPercentChangeFromJan() {
        return percentChangeFromJan;
    }

    public void setPercentChangeFromJan(Long percentChangeFromJan) {
        this.percentChangeFromJan = percentChangeFromJan;
    }

    public Long getMean7CountyVmt() {
        return mean7CountyVmt;
    }

    public void setMean7CountyVmt(Long mean7CountyVmt) {
        this.mean7CountyVmt = mean7CountyVmt;
    }

    public Long getMean7PercentChangeFromJan() {
        return mean7PercentChangeFromJan;
    }

    public void setMean7PercentChangeFromJan(Long mean7PercentChangeFromJan) {
        this.mean7PercentChangeFromJan = mean7PercentChangeFromJan;
    }

    public Calendar getDateAtLow() {
        return dateAtLow;
    }

    public void setDateAtLow(Calendar dateAtLow) {
        this.dateAtLow = dateAtLow;
    }

    public Long getMean7CountyVmtAtLow() {
        return mean7CountyVmtAtLow;
    }

    public void setMean7CountyVmtAtLow(Long mean7CountyVmtAtLow) {
        this.mean7CountyVmtAtLow = mean7CountyVmtAtLow;
    }

    public Long getPercentChangeFromLow() {
        return percentChangeFromLow;
    }

    public void setPercentChangeFromLow(Long percentChangeFromLow) {
        this.percentChangeFromLow = percentChangeFromLow;
    }
}
