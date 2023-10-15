package com.example.sentryc_interview.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "seller_infos")
public class SellerInfo {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String url;
    private String country;
    private String externalId;

    @ManyToOne
    @JoinColumn(name = "marketplace_id")
    private Marketplace marketplace;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerInfo sellerInfo = (SellerInfo) o;
        return Objects.equals(id, sellerInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}