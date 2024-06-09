package com.fastcampus.book.domain;

import java.util.Date;

public class MemberDto {
    private Integer cust_no;
    private String cust_name;
    private String phone;
    private Date join_date;
    private String cust_email;
    private String grade;

    public MemberDto() {
    }

    public MemberDto(Integer cust_no, String cust_name, String phone, String cust_email, String grade) {
        this.cust_no = cust_no;
        this.cust_name = cust_name;
        this.phone = phone;
        this.cust_email = cust_email;
        this.grade = grade;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "memberDto{" +
                "cust_no=" + cust_no +
                ", cust_name='" + cust_name + '\'' +
                ", phone='" + phone + '\'' +
                ", join_date=" + join_date +
                ", cust_email='" + cust_email + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
