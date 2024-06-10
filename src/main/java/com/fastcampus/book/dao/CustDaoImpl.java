package com.fastcampus.book.dao;

import com.fastcampus.book.domain.MemberDto;
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
public class CustDaoImpl implements CustDao {
    @Autowired
    CustService custService;

    @Autowired
    DataSource ds;

    final int FAIL = 0;
//    @Autowired
//    SqlSession session;

    @Override
    public Integer insertCust(MemberDto memberDto) {
        int rowCnt = FAIL;

        Connection conn = null;
        PreparedStatement pstmt = null;
//        INSERT INTO member_tbl
//        VALUES (100005, "김행복", "010-1111-1115", "2023-04-15", "bit05@naver.com", 'G');
        String sql = "insert into member_tbl values (?, ?, ?, now(), ?, ?) ";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
            pstmt.setInt(1, memberDto.getCust_no());
            pstmt.setString(2, memberDto.getCust_name());
            pstmt.setString(3, memberDto.getPhone());
            pstmt.setString(4, memberDto.getCust_email());
            pstmt.setString(5, memberDto.getGrade());

            return pstmt.executeUpdate(); //  insert, delete, update;
        } catch (SQLException e) {
            e.printStackTrace();
            return FAIL;
        }
    }

    @Override
    public Integer updateCust(MemberDto memberDto) {
        int rowCnt = FAIL;

        Connection conn = null;
        PreparedStatement pstmt = null;
//        INSERT INTO member_tbl
//        VALUES (100005, "김행복", "010-1111-1115", "2023-04-15", "bit05@naver.com", 'G');
        String sql = "update member_tbl set cust_name = ?, phone = ?, cust_email= ?, grade= ? where cust_no = ?";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
            pstmt.setString(1, memberDto.getCust_name());
            pstmt.setString(2, memberDto.getPhone());
            pstmt.setString(3, memberDto.getCust_email());
            pstmt.setString(4, memberDto.getGrade());
            pstmt.setInt(5, memberDto.getCust_no());

            return pstmt.executeUpdate(); //  insert, delete, update;
        } catch (SQLException e) {
            e.printStackTrace();
            return FAIL;
        }
    }

    @Override
    public Integer delectCust(Integer cust_no) {
        int rowCnt = FAIL;
        try {
            Connection conn = ds.getConnection();

            String sql = "delete from member_tbl where cust_no = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
            pstmt.setInt(1, cust_no);
            return pstmt.executeUpdate(); //  insert, delete, update
        } catch (SQLException e) {
            e.printStackTrace();
            return FAIL;
        }
    }

    @Override
    public Integer selectLastCustNo() {
        int lastCustNo = 0;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT max(cust_no) as cust_no from member_tbl;";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상

            rs = pstmt.executeQuery(); //  select

            if(rs.next()) {
                lastCustNo = (rs.getInt("cust_no"))+1; // 마지막 고객번호+1
            }
        } catch (SQLException e) {
            return null;
        }

        return lastCustNo;
    }

    @Override
    public List<MemberDto> selectCustList() {
        List<MemberDto> list = new ArrayList<MemberDto>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from member_tbl";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상

            rs = pstmt.executeQuery(); //  select

            while(rs.next()) {
                MemberDto memberDto = new MemberDto();
                memberDto.setCust_no(rs.getInt("cust_no"));
                memberDto.setCust_name(rs.getString("cust_name"));
                memberDto.setPhone(rs.getString("phone"));
                memberDto.setJoin_date(new Date(rs.getDate("join_date").getTime()));
                memberDto.setCust_email(rs.getString("cust_email"));
                memberDto.setGrade(rs.getString("grade"));
                list.add(memberDto);
            }
        } catch (SQLException e) {
            return null;
        }
        return list;
    }

    @Override
    public MemberDto selectCustInfo(Integer cust_no) {
        MemberDto memberDto = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from member_tbl where cust_no = ?";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
            pstmt.setInt(1, cust_no);

            rs = pstmt.executeQuery(); //  select

            if(rs.next()) {
                memberDto = new MemberDto();
                memberDto.setCust_no(rs.getInt("cust_no"));
                memberDto.setCust_name(rs.getString("cust_name"));
                memberDto.setPhone(rs.getString("phone"));
                memberDto.setJoin_date(new Date(rs.getDate("join_date").getTime()));
                memberDto.setCust_email(rs.getString("cust_email"));
                memberDto.setGrade(rs.getString("grade"));
            }
        } catch (SQLException e) {
            return null;
        }
        return memberDto;
    }
}
