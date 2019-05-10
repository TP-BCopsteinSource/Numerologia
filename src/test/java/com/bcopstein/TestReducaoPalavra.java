package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestReducaoPalavra {
    @DisplayName("Testa  para reducao")
    @ParameterizedTest
    @CsvSource({
            "OLA,1,PITAGORICA",
            "TESTE12,9,PITAGORICA",
            "A,1,PITAGORICA",
            "Z,8,PITAGORICA",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890B,2,PITAGORICA",
            "OLA,2,CHALDEAN",
            "TESTE12,6,CHALDEAN",
            "A,1,CHALDEAN",
            "Z,7,CHALDEAN"
    })
    public void testaReducao(String palavra, int resEsp, TipoTabela tipoTabela){
        Redutor reducao = new RedutorImpl();
        reducao.setTipoTabela(tipoTabela);
        assertEquals(resEsp,reducao.reducaoPalavra(palavra));
    }
}