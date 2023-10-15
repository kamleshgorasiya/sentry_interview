package com.example.sentryc_interview.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class SellerFilterTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link SellerFilter}
     *   <li>{@link SellerFilter#setMarketplaceIds(Set)}
     *   <li>{@link SellerFilter#setProducerIds(Set)}
     *   <li>{@link SellerFilter#setSearchByName(String)}
     *   <li>{@link SellerFilter#getMarketplaceIds()}
     *   <li>{@link SellerFilter#getProducerIds()}
     *   <li>{@link SellerFilter#getSearchByName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        SellerFilter actualSellerFilter = new SellerFilter();
        HashSet<String> stringSet = new HashSet<>();
        actualSellerFilter.setMarketplaceIds(stringSet);
        HashSet<UUID> uuidSet = new HashSet<>();
        actualSellerFilter.setProducerIds(uuidSet);
        actualSellerFilter.setSearchByName("Search By Name");
        assertSame(stringSet, actualSellerFilter.getMarketplaceIds());
        assertSame(uuidSet, actualSellerFilter.getProducerIds());
        assertEquals("Search By Name", actualSellerFilter.getSearchByName());
    }
}

