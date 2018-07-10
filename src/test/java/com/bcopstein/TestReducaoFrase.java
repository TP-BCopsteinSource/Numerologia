package com.bcopstein;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestReducaoFrase{
    private String frase;
    private int resEsp;
    private TipoTabela tipoTabela;

    public TestReducaoFrase(String frase,int resEsp,TipoTabela tipoTabela){
        this.frase = frase;
        this.resEsp = resEsp;
        this.tipoTabela = tipoTabela;        
    }

    @Parameters 
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
            {"PALAVRA",8,TipoTabela.PITAGORICA},
            {"DUAS PALAVRAS",9,TipoTabela.PITAGORICA},
            {"MUITAS PALAVRAS FORMAM UMA FRASE GRANDE",3,TipoTabela.PITAGORICA},
        });
    }

    @Test
    public void testaReducao(){
        Reducao reducao = new Reducao();
        reducao.setTipoTabela(tipoTabela);
        assertEquals(resEsp,reducao.reducaoFrase(frase));
    }
}