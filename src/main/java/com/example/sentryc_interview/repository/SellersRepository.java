package com.example.sentryc_interview.repository;

import com.example.sentryc_interview.entities.Seller;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface SellersRepository extends JpaRepository<Seller, UUID> {

    List<Seller> findBySellerInfoId(UUID id);
    List<Seller> findBySellerInfoIdAndProducerIdIn(UUID id, Set<UUID> producerIds);
    List<Seller> findByProducerIdIn(Set<UUID> producerIds, Pageable pageable);
}



