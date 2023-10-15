package com.example.sentryc_interview.dto;

import com.example.sentryc_interview.enums.State;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProducerSellerStateDTO {

    UUID producerId;
    String producerName;
    State sellerState;
    UUID sellerId;

}
