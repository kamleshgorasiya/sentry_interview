package com.example.sentryc_interview.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.example.sentryc_interview.enums.State;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class ProducerSellerStateDTOTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ProducerSellerStateDTO}
     *   <li>{@link ProducerSellerStateDTO#setProducerId(UUID)}
     *   <li>{@link ProducerSellerStateDTO#setProducerName(String)}
     *   <li>{@link ProducerSellerStateDTO#setSellerId(UUID)}
     *   <li>{@link ProducerSellerStateDTO#setSellerState(State)}
     *   <li>{@link ProducerSellerStateDTO#getProducerId()}
     *   <li>{@link ProducerSellerStateDTO#getProducerName()}
     *   <li>{@link ProducerSellerStateDTO#getSellerId()}
     *   <li>{@link ProducerSellerStateDTO#getSellerState()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ProducerSellerStateDTO actualProducerSellerStateDTO = new ProducerSellerStateDTO();
        UUID randomUUIDResult = UUID.randomUUID();
        actualProducerSellerStateDTO.setProducerId(randomUUIDResult);
        actualProducerSellerStateDTO.setProducerName("Producer Name");
        UUID randomUUIDResult1 = UUID.randomUUID();
        actualProducerSellerStateDTO.setSellerId(randomUUIDResult1);
        actualProducerSellerStateDTO.setSellerState(State.REGULAR);
        assertSame(randomUUIDResult, actualProducerSellerStateDTO.getProducerId());
        assertEquals("Producer Name", actualProducerSellerStateDTO.getProducerName());
        assertSame(randomUUIDResult1, actualProducerSellerStateDTO.getSellerId());
        assertEquals(State.REGULAR, actualProducerSellerStateDTO.getSellerState());
    }
}

