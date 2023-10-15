package com.example.sentryc_interview.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "marketplaces")
public class Marketplace {

    @Id
    private String id;
    private String description;
}
