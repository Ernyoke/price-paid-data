package dev.esz.pricepaiddata;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

import java.time.LocalDate;

public class PricePaid {
    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private Integer price;

    @CsvCustomBindByPosition(position = 2, converter = DateConverter.class)
    private LocalDate dateOfTransfer;

    @CsvBindByPosition(position = 3)
    private String postCode;

    @CsvBindByPosition(position = 4)
    private String propertyType;

    @CsvBindByPosition(position = 5)
    private String oldNew;

    @CsvBindByPosition(position = 6)
    private String duration;

    @CsvBindByPosition(position = 7)
    private String paon;

    @CsvBindByPosition(position = 8)
    private String saon;

    @CsvBindByPosition(position = 9)
    private String street;

    @CsvBindByPosition(position = 10)
    private String locality;

    @CsvBindByPosition(position = 11)
    private String city;

    @CsvBindByPosition(position = 12)
    private String district;

    @CsvBindByPosition(position = 13)
    private String county;

    @CsvBindByPosition(position = 14)
    private String ppd;

    @CsvBindByPosition(position = 15)
    private String recordStatus;

    public PricePaid() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getDateOfTransfer() {
        return dateOfTransfer;
    }

    public void setDateOfTransfer(LocalDate dateOfTransfer) {
        this.dateOfTransfer = dateOfTransfer;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getOldNew() {
        return oldNew;
    }

    public void setOldNew(String oldNew) {
        this.oldNew = oldNew;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPaon() {
        return paon;
    }

    public void setPaon(String paon) {
        this.paon = paon;
    }

    public String getSaon() {
        return saon;
    }

    public void setSaon(String saon) {
        this.saon = saon;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPpd() {
        return ppd;
    }

    public void setPpd(String ppd) {
        this.ppd = ppd;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
}
