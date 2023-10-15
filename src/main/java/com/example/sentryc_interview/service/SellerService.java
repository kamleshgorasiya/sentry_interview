package com.example.sentryc_interview.service;

import com.example.sentryc_interview.dto.CustomSellerResponseDTO;
import com.example.sentryc_interview.dto.PageInput;
import com.example.sentryc_interview.dto.SellerFilter;
import com.example.sentryc_interview.enums.SellerSortBy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SellerService {

    List<CustomSellerResponseDTO> getAllSellerBySellerName(SellerFilter sellerFilter, SellerSortBy sellerSortBy, PageInput pageInput);
}
