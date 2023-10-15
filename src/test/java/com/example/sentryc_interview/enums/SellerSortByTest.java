package com.example.sentryc_interview.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SellerSortByTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SellerSortBy#valueOf(String)}
     *   <li>{@link SellerSortBy#getDisplayName()}
     * </ul>
     */
    @Test
    void testValueOf() {
        assertEquals("externalId_asc", SellerSortBy.valueOf("SELLER_INFO_EXTERNAL_ID_ASC").getDisplayName());
    }
}

