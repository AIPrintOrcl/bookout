package com.fastcampus.book.service;

import com.fastcampus.book.controller.CustController;
import com.fastcampus.book.dao.CustDao;
import com.fastcampus.book.domain.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustServiceImpl implements CustService {

    @Autowired
    CustController custController;

    @Autowired
    CustDao custDao;

    @Override
    public Integer writeCust(MemberDto memberDto) {
        return custDao.insertCust(memberDto);
    }

    @Override
    public Integer modifyCust(MemberDto memberDto) {
        return custDao.updateCust(memberDto);
    }

    @Override
    public Integer removeCust(Integer cust_no) {
        return custDao.delectCust(cust_no);
    }

    @Override
    public Integer getLastCustNo() {
        return custDao.selectLastCustNo();
    }

    @Override
    public List<MemberDto> getCustList() {
        return custDao.selectCustList();
    }

    @Override
    public MemberDto getCustInfo(Integer cust_no) {
        return custDao.selectCustInfo(cust_no);
    }
}
