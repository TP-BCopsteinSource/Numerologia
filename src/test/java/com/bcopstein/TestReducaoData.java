package com.bcopstein;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestReducaoData{
    private Reducao reducao;

    @Before
    public void setup(){
        reducao = new Reducao();
    }

    @Test
    public void testeDataSimples(){
        String data = "10/07/2018";
        int resEsp = 1;
        assertEquals(resEsp,reducao.reducaoData(data));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestaDataInvalida(){
        assertEquals(0,reducao.reducaoData("02-12-2018"));
    }
}