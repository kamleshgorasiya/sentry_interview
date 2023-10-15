package com.example.sentryc_interview.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PageInputTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PageInput}
     *   <li>{@link PageInput#setPage(Integer)}
     *   <li>{@link PageInput#setSize(Integer)}
     *   <li>{@link PageInput#getPage()}
     *   <li>{@link PageInput#getSize()}
     * </ul>
     */
    @Test
    void testConstructor() {
        PageInput actualPageInput = new PageInput();
        actualPageInput.setPage(1);
        actualPageInput.setSize(3);
        assertEquals(1, actualPageInput.getPage().intValue());
        assertEquals(3, actualPageInput.getSize().intValue());
    }
}

