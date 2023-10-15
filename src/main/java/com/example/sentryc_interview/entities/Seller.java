package com.example.sentryc_interview.entities;

import com.example.sentryc_interview.enums.State;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "sellers", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"producer_id", "seller_info_id", "state"})
})
public class Seller {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "seller_info_id")
    //@JsonIgnore
    private SellerInfo sellerInfo;

    private State state;

}
