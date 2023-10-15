package com.example.sentryc_interview.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class SellerFilter {
    public String searchByName;
    public Set<UUID> producerIds;
    public Set<String> marketplaceIds;
}
