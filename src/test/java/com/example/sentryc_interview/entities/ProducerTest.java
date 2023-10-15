package com.example.sentryc_interview.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class ProducerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Producer}
     *   <li>{@link Producer#setCreatedAt(Timestamp)}
     *   <li>{@link Producer#setId(UUID)}
     *   <li>{@link Producer#setName(String)}
     *   <li>{@link Producer#getId()}
     *   <li>{@link Producer#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Producer actualProducer = new Producer();
        actualProducer.setCreatedAt(mock(Timestamp.class));
        UUID randomUUIDResult = UUID.randomUUID();
        actualProducer.setId(randomUUIDResult);
        actualProducer.setName("Name");
        assertSame(randomUUIDResult, actualProducer.getId());
        assertEquals("Name", actualProducer.getName());
    }
}

