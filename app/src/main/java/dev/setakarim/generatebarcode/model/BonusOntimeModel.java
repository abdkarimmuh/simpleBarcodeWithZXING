package dev.setakarim.generatebarcode.model;

import com.google.gson.annotations.SerializedName;

public class BonusOntimeModel {

    @SerializedName("rowid")
    private Integer id;

    @SerializedName("voucher_ont")
    private String voucherOnt;

    @SerializedName("fk_user")
    private Integer fkUser;

    public BonusOntimeModel(Integer id, String voucherOnt, Integer fkUser) {
        this.id = id;
        this.voucherOnt = voucherOnt;
        this.fkUser = fkUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoucherOnt() {
        return voucherOnt;
    }

    public void setVoucherOnt(String voucherOnt) {
        this.voucherOnt = voucherOnt;
    }

    public Integer getFkUser() {
        return fkUser;
    }

    public void setFkUser(Integer fkUser) {
        this.fkUser = fkUser;
    }
}
