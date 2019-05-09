package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFormatador {
    private Formatador f;

    @BeforeEach
    public void setup(){
        f = new FormatadorImpl();
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

    /*
    @Test(expected = IllegalArgumentException.class)
    public void testCaracterInvalidoPalavra(){
        f.formataPalavra("Banana ");
    }
    */

    @Test
    public void testaFraseSimples(){
        String rEsp = "HOJE E DIA 1";
        String frase = "Hoje e dia 1";
        String rObs = f.formataFrase(frase);
        
        assertEquals(rEsp,rObs);
    }

    @Test
    public void testaFraseUmaPalavra(){
        String rEsp = "HOJE";
        String frase = "Hoje";
        String rObs = f.formataFrase(frase);
        assertEquals(rEsp,rObs);
    }

    /*
    @Test(expected = IllegalArgumentException.class)
    public void testaFraseVazia(){
        f.formataFrase("");
    }
    */
    
    @Test
    public void testaFraseComplexa(){
        String rEsp = "HOJE E DIA 12 E AMANHA E TERCA DIA DE SALARIO";
        String frase = "Hoje e dia 12, e AmaNHa e Terca dia de  SAlario !!!";
        String rObs = f.formataFrase(frase);
        assertEquals(rEsp,rObs);
    }
}
