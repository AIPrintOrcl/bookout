package com.fastcampus.book.dao;

import com.fastcampus.book.domain.MemberDto;
import com.fastcampus.book.domain.RentDto;
import com.fastcampus.book.domain.RentPriceDto;
import com.fastcampus.book.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class RentDao {
    @Autowired
    CustService custService;

    @Autowired
    DataSource ds;

    final int FAIL = 0;

    public List<RentDto> selectRentList() {
        List<RentDto> list = new ArrayList<RentDto>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from rent_tbl";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상

            rs = pstmt.executeQuery(); //  select

            while(rs.next()) {
                RentDto rentDto = new RentDto();
                rentDto.setCust_no(rs.getInt("cust_no"));
                rentDto.setRent_no(rs.getInt("rent_no"));
                rentDto.setBook_code(rs.getString("book_code"));
                rentDto.setRent_price(rs.getInt("rent_price"));
                rentDto.setRent_date(new Date(rs.getDate("rent_date").getTime()));
                list.add(rentDto);
            }
        } catch (SQLException e) {
            return null;
        }
        return list;
    }

    public List<RentPriceDto> selectRentPriceList() {
        List<RentPriceDto> list = new ArrayList<RentPriceDto>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        StringBuilder sql = new StringBuilder();

        sql.append("        SELECT m.cust_no as cust_no, m.cust_name as cust_name, m.grade as grade, sum(r.rent_price) as sum_rent_price")
                .append("   FROM member_tbl m INNER JOIN rent_tbl r")
                .append("   ON m.cust_no = r.cust_no")
                .append("   GROUP BY m.cust_no")
                .append("   ORDER BY sum_rent_price DESC");

        System.out.println("sql.toString() = " + sql.toString());

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql.toString()); // SQL Injection공격, 성능향상

            rs = pstmt.executeQuery(); //  select

            while(rs.next()) {
                RentPriceDto rentPriceDto = new RentPriceDto();
                rentPriceDto.setCust_no(rs.getInt("cust_no"));
                rentPriceDto.setCust_name(rs.getString("cust_name"));
                rentPriceDto.setGrade(rs.getString("grade"));
                rentPriceDto.setSum_rent_price(rs.getInt("sum_rent_price"));
                list.add(rentPriceDto);
            }
        } catch (SQLException e) {
            return null;
        }
        System.out.println("list = " + list);
        return list;
    }
}
