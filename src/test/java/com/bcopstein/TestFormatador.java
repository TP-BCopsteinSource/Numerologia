package com.bcopstein;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFormatador {

	@Test
	public void testBasicoPalavra() {
        Formatador f = new Formatador();
        String rEsp = "ATENCAO";
        String rObs = f.formataPalavra("Atencao");
		assertEquals(rEsp,rObs);
	}

	@Test
	public void testLetrasNumerosPalavra() {
        Formatador f = new Formatador();
        String rEsp = "BRAVO12";
        String rObs = f.formataPalavra("BrAVo12");
		assertEquals(rEsp,rObs);
	}

    @Test(expected = IllegalArgumentException.class)
    public void testCaracterInvalidoPalavra(){
        Formatador f = new Formatador();
        f.formataPalavra("Banana ");
    }
}
