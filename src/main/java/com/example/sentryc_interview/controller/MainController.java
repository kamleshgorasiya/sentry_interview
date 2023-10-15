package com.example.sentryc_interview.controller;

import com.example.sentryc_interview.dto.CustomSellerResponseDTO;
import com.example.sentryc_interview.dto.PageInput;
import com.example.sentryc_interview.dto.SellerFilter;
import com.example.sentryc_interview.repository.ProducersRepository;
import com.example.sentryc_interview.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import com.example.sentryc_interview.enums.SellerSortBy;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private SellerService sellerService;
    private final ProducersRepository producersRepository;

    @Autowired
    public MainController(SellerService sellerService,
                          ProducersRepository producersRepository) {
        this.sellerService = sellerService;
        this.producersRepository = producersRepository;
    }

    @MutationMapping(name = "sellersByAllFilters")
    public List<CustomSellerResponseDTO> getAllSellersBySellerName(@Argument("filter") SellerFilter sellerFilter,
                                                                   @Argument SellerSortBy sortBy,
                                                                   @Argument("page") PageInput pageInput) {

        return this.sellerService.getAllSellerBySellerName(sellerFilter,sortBy, pageInput);
    }

}



