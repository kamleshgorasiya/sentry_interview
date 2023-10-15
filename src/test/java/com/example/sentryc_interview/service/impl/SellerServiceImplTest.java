package com.example.sentryc_interview.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.sentryc_interview.dto.CustomSellerResponseDTO;
import com.example.sentryc_interview.dto.PageInput;
import com.example.sentryc_interview.dto.ProducerSellerStateDTO;
import com.example.sentryc_interview.dto.SellerFilter;
import com.example.sentryc_interview.entities.Marketplace;
import com.example.sentryc_interview.entities.Producer;
import com.example.sentryc_interview.entities.Seller;
import com.example.sentryc_interview.entities.SellerInfo;
import com.example.sentryc_interview.enums.SellerSortBy;
import com.example.sentryc_interview.enums.State;
import com.example.sentryc_interview.repository.SellerInfoRepository;
import com.example.sentryc_interview.repository.SellersRepository;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SellerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SellerServiceImplTest {
    @MockBean
    private SellerInfoRepository sellerInfoRepository;

    @Autowired
    private SellerServiceImpl sellerServiceImpl;

    @MockBean
    private SellersRepository sellersRepository;

    /**
     * Method under test: {@link SellerServiceImpl#getAllSellerBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellerBySellerName() {
        when(sellerInfoRepository.findByNameContaining((String) any(), (Pageable) any())).thenReturn(new ArrayList<>());

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        assertTrue(
                sellerServiceImpl.getAllSellerBySellerName(sellerFilter, SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC, pageInput)
                        .isEmpty());
        verify(sellerInfoRepository).findByNameContaining((String) any(), (Pageable) any());
    }

    /**
     * Method under test: {@link SellerServiceImpl#getAllSellerBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellerBySellerName2() {
        ArrayList<Seller> sellerList = new ArrayList<>();
        when(sellersRepository.findBySellerInfoId((UUID) any())).thenReturn(sellerList);

        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("externalId");
        sellerInfo.setUrl("https://example.org/example");

        ArrayList<SellerInfo> sellerInfoList = new ArrayList<>();
        sellerInfoList.add(sellerInfo);
        when(sellerInfoRepository.findByNameContaining((String) any(), (Pageable) any())).thenReturn(sellerInfoList);

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        List<CustomSellerResponseDTO> actualAllSellerBySellerName = sellerServiceImpl
                .getAllSellerBySellerName(sellerFilter, SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC, pageInput);
        assertEquals(1, actualAllSellerBySellerName.size());
        CustomSellerResponseDTO getResult = actualAllSellerBySellerName.get(0);
        assertEquals("42", getResult.getExternalId());
        assertEquals("externalId", getResult.getSellerName());
        assertEquals(sellerList, getResult.getProducerSellerStates());
        assertEquals("42", getResult.getMarketplaceId());
        verify(sellersRepository).findBySellerInfoId((UUID) any());
        verify(sellerInfoRepository).findByNameContaining((String) any(), (Pageable) any());
    }

    /**
     * Method under test: {@link SellerServiceImpl#getAllSellerBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellerBySellerName3() {
        Producer producer = new Producer();
        producer.setCreatedAt(mock(Timestamp.class));
        UUID randomUUIDResult = UUID.randomUUID();
        producer.setId(randomUUIDResult);
        producer.setName("externalId");

        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("externalId");
        sellerInfo.setUrl("https://example.org/example");

        Seller seller = new Seller();
        UUID randomUUIDResult1 = UUID.randomUUID();
        seller.setId(randomUUIDResult1);
        seller.setProducer(producer);
        seller.setSellerInfo(sellerInfo);
        seller.setState(State.REGULAR);

        ArrayList<Seller> sellerList = new ArrayList<>();
        sellerList.add(seller);
        when(sellersRepository.findBySellerInfoId((UUID) any())).thenReturn(sellerList);

        Marketplace marketplace1 = new Marketplace();
        marketplace1.setDescription("The characteristics of someone or something");
        marketplace1.setId("42");

        SellerInfo sellerInfo1 = new SellerInfo();
        sellerInfo1.setCountry("GB");
        sellerInfo1.setExternalId("42");
        sellerInfo1.setId(UUID.randomUUID());
        sellerInfo1.setMarketplace(marketplace1);
        sellerInfo1.setName("externalId");
        sellerInfo1.setUrl("https://example.org/example");

        ArrayList<SellerInfo> sellerInfoList = new ArrayList<>();
        sellerInfoList.add(sellerInfo1);
        when(sellerInfoRepository.findByNameContaining((String) any(), (Pageable) any())).thenReturn(sellerInfoList);

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        List<CustomSellerResponseDTO> actualAllSellerBySellerName = sellerServiceImpl
                .getAllSellerBySellerName(sellerFilter, SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC, pageInput);
        assertEquals(1, actualAllSellerBySellerName.size());
        CustomSellerResponseDTO getResult = actualAllSellerBySellerName.get(0);
        assertEquals("42", getResult.getExternalId());
        assertEquals("externalId", getResult.getSellerName());
        List<ProducerSellerStateDTO> producerSellerStates = getResult.getProducerSellerStates();
        assertEquals(1, producerSellerStates.size());
        assertEquals("42", getResult.getMarketplaceId());
        ProducerSellerStateDTO getResult1 = producerSellerStates.get(0);
        assertSame(randomUUIDResult, getResult1.getProducerId());
        assertEquals(State.REGULAR, getResult1.getSellerState());
        assertEquals("externalId", getResult1.getProducerName());
        assertSame(randomUUIDResult1, getResult1.getSellerId());
        verify(sellersRepository).findBySellerInfoId((UUID) any());
        verify(sellerInfoRepository).findByNameContaining((String) any(), (Pageable) any());
    }

    /**
     * Method under test: {@link SellerServiceImpl#getAllSellerBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellerBySellerName4() {
        Producer producer = new Producer();
        producer.setCreatedAt(mock(Timestamp.class));
        UUID randomUUIDResult = UUID.randomUUID();
        producer.setId(randomUUIDResult);
        producer.setName("externalId");

        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("externalId");
        sellerInfo.setUrl("https://example.org/example");

        Seller seller = new Seller();
        UUID randomUUIDResult1 = UUID.randomUUID();
        seller.setId(randomUUIDResult1);
        seller.setProducer(producer);
        seller.setSellerInfo(sellerInfo);
        seller.setState(State.REGULAR);

        Producer producer1 = new Producer();
        producer1.setCreatedAt(mock(Timestamp.class));
        UUID randomUUIDResult2 = UUID.randomUUID();
        producer1.setId(randomUUIDResult2);
        producer1.setName("externalId");

        Marketplace marketplace1 = new Marketplace();
        marketplace1.setDescription("The characteristics of someone or something");
        marketplace1.setId("42");

        SellerInfo sellerInfo1 = new SellerInfo();
        sellerInfo1.setCountry("GB");
        sellerInfo1.setExternalId("42");
        sellerInfo1.setId(UUID.randomUUID());
        sellerInfo1.setMarketplace(marketplace1);
        sellerInfo1.setName("externalId");
        sellerInfo1.setUrl("https://example.org/example");

        Seller seller1 = new Seller();
        UUID randomUUIDResult3 = UUID.randomUUID();
        seller1.setId(randomUUIDResult3);
        seller1.setProducer(producer1);
        seller1.setSellerInfo(sellerInfo1);
        seller1.setState(State.REGULAR);

        ArrayList<Seller> sellerList = new ArrayList<>();
        sellerList.add(seller1);
        sellerList.add(seller);
        when(sellersRepository.findBySellerInfoId((UUID) any())).thenReturn(sellerList);

        Marketplace marketplace2 = new Marketplace();
        marketplace2.setDescription("The characteristics of someone or something");
        marketplace2.setId("42");

        SellerInfo sellerInfo2 = new SellerInfo();
        sellerInfo2.setCountry("GB");
        sellerInfo2.setExternalId("42");
        sellerInfo2.setId(UUID.randomUUID());
        sellerInfo2.setMarketplace(marketplace2);
        sellerInfo2.setName("externalId");
        sellerInfo2.setUrl("https://example.org/example");

        ArrayList<SellerInfo> sellerInfoList = new ArrayList<>();
        sellerInfoList.add(sellerInfo2);
        when(sellerInfoRepository.findByNameContaining((String) any(), (Pageable) any())).thenReturn(sellerInfoList);

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        List<CustomSellerResponseDTO> actualAllSellerBySellerName = sellerServiceImpl
                .getAllSellerBySellerName(sellerFilter, SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC, pageInput);
        assertEquals(1, actualAllSellerBySellerName.size());
        CustomSellerResponseDTO getResult = actualAllSellerBySellerName.get(0);
        assertEquals("42", getResult.getExternalId());
        assertEquals("externalId", getResult.getSellerName());
        List<ProducerSellerStateDTO> producerSellerStates = getResult.getProducerSellerStates();
        assertEquals(2, producerSellerStates.size());
        assertEquals("42", getResult.getMarketplaceId());
        ProducerSellerStateDTO getResult1 = producerSellerStates.get(1);
        assertEquals(State.REGULAR, getResult1.getSellerState());
        ProducerSellerStateDTO getResult2 = producerSellerStates.get(0);
        assertEquals(State.REGULAR, getResult2.getSellerState());
        assertSame(randomUUIDResult3, getResult2.getSellerId());
        assertEquals("externalId", getResult2.getProducerName());
        assertSame(randomUUIDResult, getResult1.getProducerId());
        assertSame(randomUUIDResult1, getResult1.getSellerId());
        assertSame(randomUUIDResult2, getResult2.getProducerId());
        assertEquals("externalId", getResult1.getProducerName());
        verify(sellersRepository).findBySellerInfoId((UUID) any());
        verify(sellerInfoRepository).findByNameContaining((String) any(), (Pageable) any());
    }

    /**
     * Method under test: {@link SellerServiceImpl#getAllSellerBySellerName(SellerFilter, SellerSortBy, PageInput)}
     */
    @Test
    void testGetAllSellerBySellerName5() {
        ArrayList<Seller> sellerList = new ArrayList<>();
        when(sellersRepository.findBySellerInfoId((UUID) any())).thenReturn(sellerList);

        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("externalId");
        sellerInfo.setUrl("https://example.org/example");

        Marketplace marketplace1 = new Marketplace();
        marketplace1.setDescription("The characteristics of someone or something");
        marketplace1.setId("42");

        SellerInfo sellerInfo1 = new SellerInfo();
        sellerInfo1.setCountry("GB");
        sellerInfo1.setExternalId("42");
        sellerInfo1.setId(UUID.randomUUID());
        sellerInfo1.setMarketplace(marketplace1);
        sellerInfo1.setName("externalId");
        sellerInfo1.setUrl("https://example.org/example");

        ArrayList<SellerInfo> sellerInfoList = new ArrayList<>();
        sellerInfoList.add(sellerInfo1);
        sellerInfoList.add(sellerInfo);
        when(sellerInfoRepository.findByNameContaining((String) any(), (Pageable) any())).thenReturn(sellerInfoList);

        SellerFilter sellerFilter = new SellerFilter();
        sellerFilter.setMarketplaceIds(new HashSet<>());
        sellerFilter.setProducerIds(new HashSet<>());
        sellerFilter.setSearchByName("Search By Name");

        PageInput pageInput = new PageInput();
        pageInput.setPage(1);
        pageInput.setSize(3);
        List<CustomSellerResponseDTO> actualAllSellerBySellerName = sellerServiceImpl
                .getAllSellerBySellerName(sellerFilter, SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC, pageInput);
        assertEquals(2, actualAllSellerBySellerName.size());
        CustomSellerResponseDTO getResult = actualAllSellerBySellerName.get(0);
        assertEquals("externalId", getResult.getSellerName());
        CustomSellerResponseDTO getResult1 = actualAllSellerBySellerName.get(1);
        assertEquals("externalId", getResult1.getSellerName());
        assertEquals(sellerList, getResult1.getProducerSellerStates());
        assertEquals("42", getResult1.getMarketplaceId());
        assertEquals("42", getResult1.getExternalId());
        assertEquals(sellerList, getResult.getProducerSellerStates());
        assertEquals("42", getResult.getMarketplaceId());
        assertEquals("42", getResult.getExternalId());
        verify(sellersRepository, atLeast(1)).findBySellerInfoId((UUID) any());
        verify(sellerInfoRepository).findByNameContaining((String) any(), (Pageable) any());
    }


    /**
     * Method under test: {@link SellerServiceImpl#getSortSeller(SellerSortBy)}
     */
    @Test
    void testGetSortSeller() {
        assertEquals(1, sellerServiceImpl.getSortSeller(SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC).toList().size());
        assertEquals(1, sellerServiceImpl.getSortSeller(SellerSortBy.SELLER_INFO_EXTERNAL_ID_DESC).toList().size());
        assertEquals(1, sellerServiceImpl.getSortSeller(SellerSortBy.NAME_ASC).toList().size());
        assertEquals(1, sellerServiceImpl.getSortSeller(SellerSortBy.NAME_DESC).toList().size());
        assertEquals(1, sellerServiceImpl.getSortSeller(SellerSortBy.MARKETPLACE_ID_ASC).toList().size());
        assertEquals(1, sellerServiceImpl.getSortSeller(SellerSortBy.MARKETPLACE_ID_DESC).toList().size());
    }

    /**
     * Method under test: {@link SellerServiceImpl#getSortSellerInfo(SellerSortBy)}
     */
    @Test
    void testGetSortSellerInfo() {
        assertEquals(1, sellerServiceImpl.getSortSellerInfo(SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC).toList().size());
        assertEquals(1, sellerServiceImpl.getSortSellerInfo(SellerSortBy.SELLER_INFO_EXTERNAL_ID_DESC).toList().size());
        assertEquals(1, sellerServiceImpl.getSortSellerInfo(SellerSortBy.NAME_ASC).toList().size());
        assertEquals(1, sellerServiceImpl.getSortSellerInfo(SellerSortBy.NAME_DESC).toList().size());
        assertEquals(1, sellerServiceImpl.getSortSellerInfo(SellerSortBy.MARKETPLACE_ID_ASC).toList().size());
        assertEquals(1, sellerServiceImpl.getSortSellerInfo(SellerSortBy.MARKETPLACE_ID_DESC).toList().size());
    }
}

