package com.fastcampus.book.service;

import com.fastcampus.book.controller.CustController;
import com.fastcampus.book.dao.CustDao;
import com.fastcampus.book.domain.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustService {

    @Autowired
    CustController custController;

    @Autowired
    CustDao custDao;

    public Integer writeCust(MemberDto memberDto) {
        return custDao.insertCust(memberDto);
    }

    public Integer modifyCust(MemberDto memberDto) {
        return custDao.updateCust(memberDto);
    }

    public Integer removeCust(Integer cust_no) {
        return custDao.delectCust(cust_no);
    }

    public Integer getLastCustNo() {
        return custDao.selectLastCustNo();
    }

    public List<MemberDto> getCustList() {
        return custDao.selectCustList();
    }

    public MemberDto getCustInfo(Integer cust_no) {
        return custDao.selectCustInfo(cust_no);
    }
}
