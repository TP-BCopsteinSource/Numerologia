package com.bcopstein;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFormatador {

	@Test
	public void testBasicoPalavra() {
        Formatador f = new Formatador();
        String rEsp = "ATENCAO";
        String rObs = f.formataPalavra("Atenção");
		assertEquals(rEsp,rObs);
	}

	@Test
	public void testTodosAcentosMinusculosPalavra() {
        Formatador f = new Formatador();
        String rEsp = "AAAAEEEIIOOOOUUUC";
        String rObs = f.formataPalavra("áàãâéèêíìóòõôúùûç");
		assertEquals(rEsp,rObs);
	}

    @Test
	public void testTodosAcentosMaiusculosPalavra() {
        Formatador f = new Formatador();
        String rEsp = "AAAAEEEIIOOOOUUUC";
        String rObs = f.formataPalavra("ÁÀÃÂÉÈÊÍÌÓÒÕÔÚÙÛÇ");
		assertEquals(rEsp,rObs);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCaracterInvalidoPalavra(){
        Formatador f = new Formatador();
        f.formataPalavra("Banana ");
    }
}
