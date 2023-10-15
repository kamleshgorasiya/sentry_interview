package com.example.sentryc_interview.repository;

import com.example.sentryc_interview.entities.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProducersRepository extends JpaRepository<Producer, UUID> {
}