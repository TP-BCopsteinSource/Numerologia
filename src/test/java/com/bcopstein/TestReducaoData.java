package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReducaoData{
    private Redutor reducao;

    @BeforeEach
    public void setup(){
        reducao = new RedutorImpl();
    }

    @Test
    public void testeDataSimples(){
        String data = "10/07/2018";
        int resEsp = 1;
        assertEquals(resEsp,reducao.reducaoData(data));
    }

    /*
    @Test(expected = IllegalArgumentException.class)
    public void TestaDataInvalida(){
        assertEquals(0,reducao.reducaoData("02-12-2018"));
    }
    */
}