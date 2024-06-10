package com.fastcampus.book.service;

import com.fastcampus.book.domain.MemberDto;

import java.util.List;

public interface CustService {
    Integer writeCust(MemberDto memberDto);

    Integer modifyCust(MemberDto memberDto);

    Integer removeCust(Integer cust_no);

    Integer getLastCustNo();

    List<MemberDto> getCustList();

    MemberDto getCustInfo(Integer cust_no);
}
