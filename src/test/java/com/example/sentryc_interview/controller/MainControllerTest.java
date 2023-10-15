package com.example.sentryc_interview.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.sentryc_interview.dto.CustomSellerResponseDTO;
import com.example.sentryc_interview.dto.PageInput;
import com.example.sentryc_interview.dto.SellerFilter;
import com.example.sentryc_interview.enums.SellerSortBy;
import com.example.sentryc_interview.repository.ProducersRepository;
import com.example.sentryc_interview.service.SellerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MainController.class})
@ExtendWith(SpringExtension.class)
class MainControllerTest {
    @Autowired
    private MainController mainController;

    @MockBean
    private ProducersRepository producersRepository;

    @MockBean
    private SellerService sellerService;

    /**
     * Method under test: {@link MainController#getAllSellersBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellersBySellerName() {
        ArrayList<CustomSellerResponseDTO> customSellerResponseDTOList = new ArrayList<>();
        when(sellerService.getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any()))
                .thenReturn(customSellerResponseDTOList);

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        List<CustomSellerResponseDTO> actualAllSellersBySellerName = mainController.getAllSellersBySellerName(sellerFilter,
                SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC, pageInput);
        assertSame(customSellerResponseDTOList, actualAllSellersBySellerName);
        assertTrue(actualAllSellersBySellerName.isEmpty());
        verify(sellerService).getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any());
    }

    /**
     * Method under test: {@link MainController#getAllSellersBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellersBySellerName2() {
        ArrayList<CustomSellerResponseDTO> customSellerResponseDTOList = new ArrayList<>();
        when(sellerService.getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any()))
                .thenReturn(customSellerResponseDTOList);

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        List<CustomSellerResponseDTO> actualAllSellersBySellerName = mainController
                .getAllSellersBySellerName(sellerFilter, SellerSortBy.SELLER_INFO_EXTERNAL_ID_DESC, pageInput);
        assertSame(customSellerResponseDTOList, actualAllSellersBySellerName);
        assertTrue(actualAllSellersBySellerName.isEmpty());
        verify(sellerService).getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any());
    }

    /**
     * Method under test: {@link MainController#getAllSellersBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellersBySellerName3() {
        ArrayList<CustomSellerResponseDTO> customSellerResponseDTOList = new ArrayList<>();
        when(sellerService.getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any()))
                .thenReturn(customSellerResponseDTOList);

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        List<CustomSellerResponseDTO> actualAllSellersBySellerName = mainController
                .getAllSellersBySellerName(sellerFilter, SellerSortBy.NAME_ASC, pageInput);
        assertSame(customSellerResponseDTOList, actualAllSellersBySellerName);
        assertTrue(actualAllSellersBySellerName.isEmpty());
        verify(sellerService).getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any());
    }

    /**
     * Method under test: {@link MainController#getAllSellersBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellersBySellerName4() {
        ArrayList<CustomSellerResponseDTO> customSellerResponseDTOList = new ArrayList<>();
        when(sellerService.getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any()))
                .thenReturn(customSellerResponseDTOList);

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        List<CustomSellerResponseDTO> actualAllSellersBySellerName = mainController
                .getAllSellersBySellerName(sellerFilter, SellerSortBy.NAME_DESC, pageInput);
        assertSame(customSellerResponseDTOList, actualAllSellersBySellerName);
        assertTrue(actualAllSellersBySellerName.isEmpty());
        verify(sellerService).getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any());
    }

    /**
     * Method under test: {@link MainController#getAllSellersBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellersBySellerName5() {
        ArrayList<CustomSellerResponseDTO> customSellerResponseDTOList = new ArrayList<>();
        when(sellerService.getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any()))
                .thenReturn(customSellerResponseDTOList);

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        List<CustomSellerResponseDTO> actualAllSellersBySellerName = mainController
                .getAllSellersBySellerName(sellerFilter, SellerSortBy.MARKETPLACE_ID_ASC, pageInput);
        assertSame(customSellerResponseDTOList, actualAllSellersBySellerName);
        assertTrue(actualAllSellersBySellerName.isEmpty());
        verify(sellerService).getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any());
    }

    /**
     * Method under test: {@link MainController#getAllSellersBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellersBySellerName6() {
        ArrayList<CustomSellerResponseDTO> customSellerResponseDTOList = new ArrayList<>();
        when(sellerService.getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any()))
                .thenReturn(customSellerResponseDTOList);

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        List<CustomSellerResponseDTO> actualAllSellersBySellerName = mainController
                .getAllSellersBySellerName(sellerFilter, SellerSortBy.MARKETPLACE_ID_DESC, pageInput);
        assertSame(customSellerResponseDTOList, actualAllSellersBySellerName);
        assertTrue(actualAllSellersBySellerName.isEmpty());
        verify(sellerService).getAllSellerBySellerName((SellerFilter) any(), (SellerSortBy) any(), (PageInput) any());
    }
}

