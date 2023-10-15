package com.example.sentryc_interview.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class CustomSellerResponseDTO {

    String sellerName;
    String externalId;
    List<ProducerSellerStateDTO> producerSellerStates;
    String marketplaceId;

}
