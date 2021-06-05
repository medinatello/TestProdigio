package com.medinatello.testprodigio.dto;

import java.util.Calendar;

public class VehicleSampleDTO {

    private Long id;

    private Integer fips;
    private String country;
    private String state;
    private Calendar date;
    private Integer vmt;
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

    public Integer getFips() {
        return fips;
    }

    public void setFips(Integer fips) {
        this.fips = fips;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Integer getVmt() {
        return vmt;
    }

    public void setVmt(Integer vmt) {
        this.vmt = vmt;
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
