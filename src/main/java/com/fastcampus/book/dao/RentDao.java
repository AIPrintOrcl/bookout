package com.fastcampus.book.dao;

import com.fastcampus.book.domain.RentDto;
import com.fastcampus.book.domain.RentPriceDto;

import java.util.List;

public interface RentDao {
    List<RentDto> selectRentList();

    List<RentPriceDto> selectRentPriceList();
}
