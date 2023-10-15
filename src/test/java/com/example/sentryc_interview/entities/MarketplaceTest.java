package com.example.sentryc_interview.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MarketplaceTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Marketplace}
     *   <li>{@link Marketplace#setDescription(String)}
     *   <li>{@link Marketplace#setId(String)}
     *   <li>{@link Marketplace#getDescription()}
     *   <li>{@link Marketplace#getId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Marketplace actualMarketplace = new Marketplace();
        actualMarketplace.setDescription("The characteristics of someone or something");
        actualMarketplace.setId("42");
        assertEquals("The characteristics of someone or something", actualMarketplace.getDescription());
        assertEquals("42", actualMarketplace.getId());
    }
}

