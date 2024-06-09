package com.fastcampus.book.domain;

import java.util.Date;

public class RentPriceDto {
    private Integer cust_no;
    private String cust_name;
    private String grade;
    private Integer sum_rent_price;

    public RentPriceDto() {
    }

    public RentPriceDto(Integer cust_no, String cust_name, String grade, Integer sum_rent_price) {
        this.cust_no = cust_no;
        this.cust_name = cust_name;
        this.grade = grade;
        this.sum_rent_price = sum_rent_price;
    }

    public Integer getCust_no() {
        return cust_no;
    }

    public void setCust_no(Integer cust_no) {
        this.cust_no = cust_no;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getSum_rent_price() {
        return sum_rent_price;
    }

    public void setSum_rent_price(Integer sum_rent_price) {
        this.sum_rent_price = sum_rent_price;
    }

    @Override
    public String toString() {
        return "RentPriceDto{" +
                "cust_no=" + cust_no +
                ", cust_name='" + cust_name + '\'' +
                ", grade='" + grade + '\'' +
                ", sum_rent_price=" + sum_rent_price +
                '}';
    }
}
