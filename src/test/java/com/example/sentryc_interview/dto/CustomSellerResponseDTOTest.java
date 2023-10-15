package com.example.sentryc_interview.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CustomSellerResponseDTOTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link CustomSellerResponseDTO}
     *   <li>{@link CustomSellerResponseDTO#setExternalId(String)}
     *   <li>{@link CustomSellerResponseDTO#setMarketplaceId(String)}
     *   <li>{@link CustomSellerResponseDTO#setProducerSellerStates(List)}
     *   <li>{@link CustomSellerResponseDTO#setSellerName(String)}
     *   <li>{@link CustomSellerResponseDTO#getExternalId()}
     *   <li>{@link CustomSellerResponseDTO#getMarketplaceId()}
     *   <li>{@link CustomSellerResponseDTO#getProducerSellerStates()}
     *   <li>{@link CustomSellerResponseDTO#getSellerName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CustomSellerResponseDTO actualCustomSellerResponseDTO = new CustomSellerResponseDTO();
        actualCustomSellerResponseDTO.setExternalId("42");
        actualCustomSellerResponseDTO.setMarketplaceId("42");
        ArrayList<ProducerSellerStateDTO> producerSellerStateDTOList = new ArrayList<>();
        actualCustomSellerResponseDTO.setProducerSellerStates(producerSellerStateDTOList);
        actualCustomSellerResponseDTO.setSellerName("Seller Name");
        assertEquals("42", actualCustomSellerResponseDTO.getExternalId());
        assertEquals("42", actualCustomSellerResponseDTO.getMarketplaceId());
        assertSame(producerSellerStateDTOList, actualCustomSellerResponseDTO.getProducerSellerStates());
        assertEquals("Seller Name", actualCustomSellerResponseDTO.getSellerName());
    }
}

