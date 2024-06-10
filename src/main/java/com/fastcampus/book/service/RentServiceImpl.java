package com.fastcampus.book.service;

import com.fastcampus.book.domain.RentDto;
import com.fastcampus.book.domain.RentPriceDto;

import java.util.List;

public interface RentServiceImpl {
    List<RentDto> getRentList();

    List<RentPriceDto> getRentPriceList();
}
