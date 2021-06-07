package com.medinatello.testprodigio.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

@XmlRootElement(name = "vehiculo")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleDTO {

    private Long id;
    @NotNull
    private Integer countryId;

    private String country;
    private String state;
    private Calendar date;
    private Integer vmt;
    private Integer baselineJanVmt;
    private Long percentJan;
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

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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

    public Long getPercentJan() {
        return percentJan;
    }

    public void setPercentJan(Long percentJan) {
        this.percentJan = percentJan;
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
