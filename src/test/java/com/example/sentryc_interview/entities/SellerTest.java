package com.example.sentryc_interview.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import com.example.sentryc_interview.enums.State;

import java.sql.Timestamp;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class SellerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Seller}
     *   <li>{@link Seller#setId(UUID)}
     *   <li>{@link Seller#setProducer(Producer)}
     *   <li>{@link Seller#setSellerInfo(SellerInfo)}
     *   <li>{@link Seller#setState(State)}
     *   <li>{@link Seller#getId()}
     *   <li>{@link Seller#getProducer()}
     *   <li>{@link Seller#getSellerInfo()}
     *   <li>{@link Seller#getState()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Seller actualSeller = new Seller();
        UUID randomUUIDResult = UUID.randomUUID();
        actualSeller.setId(randomUUIDResult);
        Producer producer = new Producer();
        producer.setCreatedAt(mock(Timestamp.class));
        producer.setId(UUID.randomUUID());
        producer.setName("Name");
        actualSeller.setProducer(producer);
        Marketplace marketplace = new Marketplace();
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("Name");
        sellerInfo.setUrl("https://example.org/example");
        actualSeller.setSellerInfo(sellerInfo);
        actualSeller.setState(State.REGULAR);
        assertSame(randomUUIDResult, actualSeller.getId());
        assertSame(producer, actualSeller.getProducer());
        assertSame(sellerInfo, actualSeller.getSellerInfo());
        assertEquals(State.REGULAR, actualSeller.getState());
    }
}

