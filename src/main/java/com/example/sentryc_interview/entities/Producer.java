package com.example.sentryc_interview.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "producers")
public class Producer {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private Timestamp createdAt;
}