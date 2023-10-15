package com.example.sentryc_interview.repository;

import com.example.sentryc_interview.entities.SellerInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface SellerInfoRepository extends JpaRepository<SellerInfo, UUID> {

    List<SellerInfo> findByNameContainingAndMarketplaceIdIn(String searchByName, Set<String> marketplaceIds,
                                                            Pageable pageable);

    List<SellerInfo> findByNameContaining(String searchByName, Pageable pageable);

    List<SellerInfo> findByMarketplaceIdIn(Set<String> marketplaceIds, Pageable pageable);
    Page<SellerInfo> findAll(Pageable pageable);
}