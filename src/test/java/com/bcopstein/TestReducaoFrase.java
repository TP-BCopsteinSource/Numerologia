package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.Collection;

public class TestReducaoFrase {
    private String frase;
    private int resEsp;
    private TipoTabela tipoTabela;

    public TestReducaoFrase(String frase, int resEsp, TipoTabela tipoTabela) {
        this.frase = frase;
        this.resEsp = resEsp;
        this.tipoTabela = tipoTabela;
    }
/*
    @ParameterizedTest
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
            {"PALAVRA",8,TipoTabela.PITAGORICA},
            {"DUAS PALAVRAS",9,TipoTabela.PITAGORICA},
            {"MUITAS PALAVRAS FORMAM UMA FRASE GRANDE",3,TipoTabela.PITAGORICA},
        });
    }

    @Test
    public void testaReducao(){
        Redutor reducao = new RedutorImpl();
        reducao.setTipoTabela(tipoTabela);
        assertEquals(resEsp,reducao.reducaoFrase(frase));
    }
    */
}