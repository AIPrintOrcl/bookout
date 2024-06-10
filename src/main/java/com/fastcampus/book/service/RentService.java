package com.fastcampus.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.book.controller.RentController;
import com.fastcampus.book.dao.RentDao;
import com.fastcampus.book.domain.RentDto;
import com.fastcampus.book.domain.RentPriceDto;

@Service
public class RentService {

    @Autowired
    RentController rentController;

    @Autowired
    RentDao rentDao;

    public List<RentDto> getRentList() {
        return rentDao.selectRentList();
    }

    public List<RentPriceDto> getRentPriceList() {
        return rentDao.selectRentPriceList();
    }

}
