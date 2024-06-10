package com.fastcampus.book.dao;

import com.fastcampus.book.domain.MemberDto;

import java.util.List;

public interface CustDao {
    Integer insertCust(MemberDto memberDto);

    Integer updateCust(MemberDto memberDto);

    Integer delectCust(Integer cust_no);

    Integer selectLastCustNo();

    List<MemberDto> selectCustList();

    MemberDto selectCustInfo(Integer cust_no);
}
