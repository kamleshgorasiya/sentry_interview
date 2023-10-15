package com.example.sentryc_interview.repository;

import com.example.sentryc_interview.entities.Marketplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketPlacesRepository extends JpaRepository<Marketplace,String> {
}
