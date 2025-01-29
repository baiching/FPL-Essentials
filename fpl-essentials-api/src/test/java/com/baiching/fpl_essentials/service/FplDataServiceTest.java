package com.baiching.fpl_essentials.service;

import com.baiching.fpl_essentials.service.impl.EmailServiceImpl;
import com.baiching.fpl_essentials.service.impl.FplDataSeriveImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FplDataServiceTest {

    @Test
    public void isDataThere() throws IOException {

        FplDataSerive service = new FplDataSeriveImpl();
        assertEquals(true, service.getGameweekData());

    }
}
