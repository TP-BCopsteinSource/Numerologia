package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestReducaoPalavra {
    @DisplayName("Testa valores para reducao")
    @ParameterizedTest
    @CsvSource({
            "OLA,1,TipoTabela.PITAGORICA",
            "TESTE12,9,TipoTabela.PITAGORICA",
            "A,1,TipoTabela.PITAGORICA",
            "Z,8,TipoTabela.PITAGORICA",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890B,2,TipoTabela.PITAGORICA",
            "OLA,2,TipoTabela.CHALDEAN",
            "TESTE12,6,TipoTabela.CHALDEAN",
            "A,1,TipoTabela.CHALDEAN",
            "Z,7,TipoTabela.CHALDEAN"
    })
    public void testaReducao(String palavra, int resEsp, TipoTabela tipoTabela){
        Redutor reducao = new RedutorImpl();
        reducao.setTipoTabela(tipoTabela);
        assertEquals(resEsp,reducao.reducaoPalavra(palavra));
    }
}