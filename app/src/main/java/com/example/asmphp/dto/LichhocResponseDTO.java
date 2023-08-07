package com.example.asmphp.dto;

import java.util.Date;

public class LichhocResponseDTO {
    private int id;
    private String name;
    private Date ngay;
    private String gio;
    private String lop;
    private String phong;
    private String ca;
    private String hinh;
    private String giangvien;
    private String mamon;

    public LichhocResponseDTO() {
    }

    public LichhocResponseDTO(int id, String name, Date ngay, String gio, String lop, String phong, String ca, String hinh, String giangvien, String mamon) {
        this.id = id;
        this.name = name;
        this.ngay = ngay;
        this.gio = gio;
        this.lop = lop;
        this.phong = phong;
        this.ca = ca;
        this.hinh = hinh;
        this.giangvien = giangvien;
        this.mamon = mamon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(String giangvien) {
        this.giangvien = giangvien;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }
}
