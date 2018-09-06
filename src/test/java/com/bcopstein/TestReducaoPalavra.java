package com.bcopstein;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestReducaoPalavra{
    private String palavra;
    private int resEsp;
    private TipoTabela tipoTabela;

    public TestReducaoPalavra(String palavra,int resEsp,TipoTabela tipoTabela){
        this.palavra = palavra;
        this.resEsp = resEsp;
        this.tipoTabela = tipoTabela;        
    }

    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
            {"OLA",1,TipoTabela.PITAGORICA},
            {"TESTE12",9,TipoTabela.PITAGORICA},
            {"A",1,TipoTabela.PITAGORICA},
            {"Z",8,TipoTabela.PITAGORICA},
            {"ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890B",2,TipoTabela.PITAGORICA},
            {"OLA",2,TipoTabela.CHALDEAN},
            {"TESTE12",6,TipoTabela.CHALDEAN},
            {"A",1,TipoTabela.CHALDEAN},
            {"Z",7,TipoTabela.CHALDEAN}
        });
    }

    @Test
    public void testaReducao(){
        Redutor reducao = new RedutorImpl();
        reducao.setTipoTabela(tipoTabela);
        assertEquals(resEsp,reducao.reducaoPalavra(palavra));
    }
}