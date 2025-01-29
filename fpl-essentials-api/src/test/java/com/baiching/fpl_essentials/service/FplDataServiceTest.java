package com.baiching.fpl_essentials.service;

import com.baiching.fpl_essentials.model.Gameweek;
import com.baiching.fpl_essentials.service.impl.EmailServiceImpl;
import com.baiching.fpl_essentials.service.impl.FplDataSeriveImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FplDataServiceTest {

    @InjectMocks FplDataSerive fplDataSerive = new FplDataSeriveImpl();

    @Mock ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void isDataThere() throws IOException {

        String mockJson = """
        {
            "events": [
                {
                    "id": 1,
                    "name": "Gameweek 1",
                    "deadline_time": "2024-08-16T17:30:00Z"
                },
                {
                    "id": 2,
                    "name": "Gameweek 2",
                    "deadline_time": "2024-08-24T10:00:00Z"
                }
            ]
        }
        """;

        ObjectMapper objectMapper = new ObjectMapper();
        List<Gameweek> mockGameweeks = objectMapper.readValue(
                objectMapper.readTree(mockJson).get("events").toString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Gameweek.class)
        );

        assertNotNull(mockGameweeks);
        assertFalse(mockGameweeks.isEmpty());

        //Gameweek 1
        assertEquals(1, mockGameweeks.get(0).getId());
        assertEquals("Gameweek 1", mockGameweeks.get(0).getName());
        assertEquals("2024-08-16T17:30:00Z", mockGameweeks.get(0).getDeadline_time());

    }
}
