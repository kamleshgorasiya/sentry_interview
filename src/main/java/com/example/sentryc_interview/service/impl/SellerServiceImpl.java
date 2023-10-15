package com.example.sentryc_interview.service.impl;

import com.example.sentryc_interview.dto.CustomSellerResponseDTO;
import com.example.sentryc_interview.dto.PageInput;
import com.example.sentryc_interview.dto.ProducerSellerStateDTO;
import com.example.sentryc_interview.dto.SellerFilter;
import com.example.sentryc_interview.entities.Seller;
import com.example.sentryc_interview.entities.SellerInfo;
import com.example.sentryc_interview.enums.SellerSortBy;
import com.example.sentryc_interview.repository.SellerInfoRepository;
import com.example.sentryc_interview.repository.SellersRepository;
import com.example.sentryc_interview.service.SellerService;
import com.example.sentryc_interview.utility.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {

    private SellersRepository sellersRepository;
    private final SellerInfoRepository sellerInfoRepository;

    @Autowired
    public SellerServiceImpl(SellersRepository sellersRepository,
                             SellerInfoRepository sellerInfoRepository) {
        this.sellersRepository = sellersRepository;
        this.sellerInfoRepository = sellerInfoRepository;
    }

    @Override
    public List<CustomSellerResponseDTO> getAllSellerBySellerName(SellerFilter sellerFilter, SellerSortBy sellerSortBy, PageInput pageInput) {

        List<CustomSellerResponseDTO> customSellerResponseDTOS = new ArrayList<>();
        Pageable pageable;
        if (pageInput != null)
            pageable = PageRequest.of(pageInput.getPage(), pageInput.getSize(), getSortSellerInfo(sellerSortBy));
        else
            pageable = PageRequest.of(0, AppConstants.PAGE_SIZE, getSortSellerInfo(sellerSortBy));

        Set<SellerInfo> sellerInfos;
        if ((!sellerFilter.marketplaceIds.isEmpty()) && !sellerFilter.searchByName.isEmpty()) {

            sellerInfos =
                    new LinkedHashSet<>(this.sellerInfoRepository.findByNameContainingAndMarketplaceIdIn(sellerFilter.getSearchByName(),
                            sellerFilter.getMarketplaceIds(), pageable));
        } else if (!sellerFilter.producerIds.isEmpty() && sellerFilter.marketplaceIds.isEmpty() && sellerFilter.searchByName.isEmpty()) {
            if (pageInput != null)
                pageable = PageRequest.of(pageInput.getPage(), pageInput.getSize(), getSortSeller(sellerSortBy));
            else
                pageable = PageRequest.of(0, AppConstants.PAGE_SIZE, getSortSeller(sellerSortBy));

            sellerInfos = new LinkedHashSet<>(sellersRepository.findByProducerIdIn(sellerFilter.getProducerIds(),
                    pageable).stream().map(Seller::getSellerInfo).collect(Collectors.toList()));
        } else if (!sellerFilter.searchByName.isEmpty())
            sellerInfos =
                    new LinkedHashSet<>(this.sellerInfoRepository.findByNameContaining(sellerFilter.getSearchByName(), pageable));
        else if (!sellerFilter.marketplaceIds.isEmpty())
            sellerInfos =
                    new LinkedHashSet<>(this.sellerInfoRepository.findByMarketplaceIdIn(sellerFilter.getMarketplaceIds(), pageable));
        else
            sellerInfos =
                    new LinkedHashSet<>(this.sellerInfoRepository.findAll(pageable).stream().collect(Collectors.toList()));

        sellerInfos.forEach(sellerInfo -> {
            CustomSellerResponseDTO obj = new CustomSellerResponseDTO();
            obj.setSellerName(sellerInfo.getName());
            obj.setExternalId(sellerInfo.getExternalId());
            obj.setMarketplaceId(sellerInfo.getMarketplace().getId());

            List<Seller> sellers;
            if (!sellerFilter.producerIds.isEmpty())
                sellers = this.sellersRepository.findBySellerInfoIdAndProducerIdIn(sellerInfo.getId(), sellerFilter.getProducerIds());
            else
                sellers = this.sellersRepository.findBySellerInfoId(sellerInfo.getId());

            List<ProducerSellerStateDTO> producerSellerStateDTOList = new ArrayList<>();
            sellers.forEach(seller1 -> {
                ProducerSellerStateDTO producerSellerStateDTO = new ProducerSellerStateDTO();
                producerSellerStateDTO.setSellerId(seller1.getId());
                producerSellerStateDTO.setSellerState(seller1.getState());
                producerSellerStateDTO.setProducerId(seller1.getProducer().getId());
                producerSellerStateDTO.setProducerName(seller1.getProducer().getName());
                producerSellerStateDTOList.add(producerSellerStateDTO);
            });
            obj.setProducerSellerStates(producerSellerStateDTOList);

            customSellerResponseDTOS.add(obj);
        });
        return customSellerResponseDTOS;
    }

    public Sort getSortSeller(SellerSortBy sellerSortBy) {
        switch (sellerSortBy) {
            case SELLER_INFO_EXTERNAL_ID_ASC:
                return Sort.by(Sort.Order.asc("sellerInfo.externalId"));
            case SELLER_INFO_EXTERNAL_ID_DESC:
                return Sort.by(Sort.Order.desc("sellerInfo.externalId"));
            case NAME_ASC:
                return Sort.by(Sort.Order.asc("sellerInfo.name"));
            case NAME_DESC:
                return Sort.by(Sort.Order.desc("sellerInfo.name"));
            case MARKETPLACE_ID_ASC:
                return Sort.by(Sort.Order.asc("sellerInfo.marketplace.id"));
            case MARKETPLACE_ID_DESC:
                return Sort.by(Sort.Order.desc("sellerInfo.marketplace.id"));
            default:
                return Sort.unsorted();
        }
    }

    public Sort getSortSellerInfo(SellerSortBy sellerSortBy) {
        switch (sellerSortBy) {
            case SELLER_INFO_EXTERNAL_ID_ASC:
                return Sort.by(Sort.Order.asc("externalId"));
            case SELLER_INFO_EXTERNAL_ID_DESC:
                return Sort.by(Sort.Order.desc("externalId"));
            case NAME_ASC:
                return Sort.by(Sort.Order.asc("name"));
            case NAME_DESC:
                return Sort.by(Sort.Order.desc("name"));
            case MARKETPLACE_ID_ASC:
                return Sort.by(Sort.Order.asc("marketplace.id"));
            case MARKETPLACE_ID_DESC:
                return Sort.by(Sort.Order.desc("marketplace.id"));
            default:
                return Sort.unsorted();
        }
    }
}

