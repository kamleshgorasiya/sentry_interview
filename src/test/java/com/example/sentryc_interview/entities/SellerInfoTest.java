package com.example.sentryc_interview.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class SellerInfoTest {
    /**
     * Method under test: {@link SellerInfo#equals(Object)}
     */
    @Test
    void testEquals() {
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
        assertNotEquals(sellerInfo, null);
    }

    /**
     * Method under test: {@link SellerInfo#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        assertNotEquals(sellerInfo, "Different type to SellerInfo");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SellerInfo#equals(Object)}
     *   <li>{@link SellerInfo#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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
        assertEquals(sellerInfo, sellerInfo);
        int expectedHashCodeResult = sellerInfo.hashCode();
        assertEquals(expectedHashCodeResult, sellerInfo.hashCode());
    }

    /**
     * Method under test: {@link SellerInfo#equals(Object)}
     */
    @Test
    void testEquals4() {
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

        Marketplace marketplace1 = new Marketplace();
        marketplace1.setDescription("The characteristics of someone or something");
        marketplace1.setId("42");

        SellerInfo sellerInfo1 = new SellerInfo();
        sellerInfo1.setCountry("GB");
        sellerInfo1.setExternalId("42");
        sellerInfo1.setId(UUID.randomUUID());
        sellerInfo1.setMarketplace(marketplace1);
        sellerInfo1.setName("Name");
        sellerInfo1.setUrl("https://example.org/example");
        assertNotEquals(sellerInfo, sellerInfo1);
    }

    /**
     * Method under test: {@link SellerInfo#equals(Object)}
     */
    @Test
    void testEquals5() {
        Marketplace marketplace = mock(Marketplace.class);
        doNothing().when(marketplace).setDescription((String) any());
        doNothing().when(marketplace).setId((String) any());
        marketplace.setDescription("The characteristics of someone or something");
        marketplace.setId("42");

        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setCountry("GB");
        sellerInfo.setExternalId("42");
        sellerInfo.setId(UUID.randomUUID());
        sellerInfo.setMarketplace(marketplace);
        sellerInfo.setName("Name");
        sellerInfo.setUrl("https://example.org/example");

        Marketplace marketplace1 = new Marketplace();
        marketplace1.setDescription("The characteristics of someone or something");
        marketplace1.setId("42");

        SellerInfo sellerInfo1 = new SellerInfo();
        sellerInfo1.setCountry("GB");
        sellerInfo1.setExternalId("42");
        sellerInfo1.setId(UUID.randomUUID());
        sellerInfo1.setMarketplace(marketplace1);
        sellerInfo1.setName("Name");
        sellerInfo1.setUrl("https://example.org/example");
        assertNotEquals(sellerInfo, sellerInfo1);
    }
}

