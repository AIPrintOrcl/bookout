package com.fastcampus.book.domain;

import java.util.Date;

public class RentDto {
    private Integer cust_no;
    private Integer rent_no;
    private String book_code;
    private Integer rent_price;
    private Date rent_date;

    public RentDto() {
    }

    public RentDto(Integer cust_no, Integer rent_no, String book_code, Integer rent_price, Date rent_date) {
        this.cust_no = cust_no;
        this.rent_no = rent_no;
        this.book_code = book_code;
        this.rent_price = rent_price;
        this.rent_date = rent_date;
    }

    public Integer getCust_no() {
        return cust_no;
    }

    public void setCust_no(Integer cust_no) {
        this.cust_no = cust_no;
    }

    public Integer getRent_no() {
        return rent_no;
    }

    public void setRent_no(Integer rent_no) {
        this.rent_no = rent_no;
    }

    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

    public Integer getRent_price() {
        return rent_price;
    }

    public void setRent_price(Integer rent_price) {
        this.rent_price = rent_price;
    }

    public Date getRent_date() {
        return rent_date;
    }

    public void setRent_date(Date rent_date) {
        this.rent_date = rent_date;
    }

    @Override
    public String toString() {
        return "rentDto{" +
                "cust_no=" + cust_no +
                ", rent_no=" + rent_no +
                ", book_code='" + book_code + '\'' +
                ", rent_price=" + rent_price +
                ", rent_date=" + rent_date +
                '}';
    }
}
