package com.bcopstein;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestFormatador {
    private Formatador f;

    @Before
    public void setup(){
        f = new Formatador();
    }
	@Test
	public void testBasicoPalavra() {
        String rEsp = "ATENCAO";
        String rObs = f.formataPalavra("Atencao");
		assertEquals(rEsp,rObs);
	}

	@Test
	public void testLetrasNumerosPalavra() {
        String rEsp = "BRAVO12";
        String rObs = f.formataPalavra("BrAVo12");
		assertEquals(rEsp,rObs);
	}

    @Test(expected = IllegalArgumentException.class)
    public void testCaracterInvalidoPalavra(){
        f.formataPalavra("Banana ");
    }

    @Test
    public void testaFraseSimples(){
        String[] rEsp = {"HOJE","E","DIA","1"};
        String frase = "Hoje e dia 1";
        String[] rObs = f.formataFrase(frase);
        assertEquals(rEsp.length,rObs.length);
        for(int i=0;i<rEsp.length;i++){
            assertEquals(rEsp[i],rObs[i]);
        }
    }

    @Test
    public void testaFraseUmaPalavra(){
        String[] rEsp = {"HOJE"};
        String frase = "Hoje";
        String[] rObs = f.formataFrase(frase);
        assertEquals(rEsp.length,rObs.length);
        for(int i=0;i<rEsp.length;i++){
            assertEquals(rEsp[i],rObs[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaFraseVazia(){
        f.formataFrase("");
    }

    @Test
    public void testaFraseComplexa(){
        String[] rEsp = {"HOJE","E","DIA","12","E","AMANHA","E","TERCA","DIA","DE","SALARIO"};
        String frase = "Hoje e dia 12, e AmaNHa e Terca dia de SAlario !!!";
        String[] rObs = f.formataFrase(frase);
        assertEquals(rEsp.length,rObs.length);
        for(int i=0;i<rEsp.length;i++){
            assertEquals(rEsp[i],rObs[i]);
        }
    }
}
