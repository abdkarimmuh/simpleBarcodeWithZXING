package dev.setakarim.generatebarcode.model;

import com.google.gson.annotations.SerializedName;

public class BonusViralModel {

    @SerializedName("rowid")
    private Integer id;

    @SerializedName("fk_user")
    private Integer fkUser;

    @SerializedName("voucher_ref")
    private String voucherRef;

    @SerializedName("phone_afi")
    private String phoneAfi;

    @SerializedName("datec")
    private String datec;

    @SerializedName("tms")
    private String tms;


    public BonusViralModel(Integer id, Integer fkUser, String voucherRef, String phoneAfi, String datec, String tms) {
        this.id = id;
        this.fkUser = fkUser;
        this.voucherRef = voucherRef;
        this.phoneAfi = phoneAfi;
        this.datec = datec;
        this.tms = tms;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkUser() {
        return fkUser;
    }

    public void setFkUser(Integer fkUser) {
        this.fkUser = fkUser;
    }

    public String getVoucherRef() {
        return voucherRef;
    }

    public void setVoucherRef(String voucherRef) {
        this.voucherRef = voucherRef;
    }

    public String getPhoneAfi() {
        return phoneAfi;
    }

    public void setPhoneAfi(String phoneAfi) {
        this.phoneAfi = phoneAfi;
    }

    public String getDatec() {
        return datec;
    }

    public void setDatec(String datec) {
        this.datec = datec;
    }

    public String getTms() {
        return tms;
    }

    public void setTms(String tms) {
        this.tms = tms;
    }
}