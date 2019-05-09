package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteCalculosNumerologia {
    // http://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html
    private Calculador calcN;
    private Formatador mockFormatador = mock(Formatador.class);
    private Redutor mockReducao = mock(Redutor.class); 
    
	@BeforeEach
	public void setUp() throws Exception {
        when(mockFormatador.formataFrase("Carlos Alberto Silveira da Silva")).thenReturn("CARLOS ALBERTO SIVEIRA DA SILVA");
        
		when(mockReducao.reducaoFrase("CARLOS ALBERTO SIVEIRA DA SILVA")).thenReturn(7);
		when(mockReducao.reducaoData("11/04/2002")).thenReturn(1);
        
        calcN = new Calculador(mockReducao, mockFormatador);
    }
    
    @Test
    public void testCalcNroVida(){
        int resEsp = 1;
        int resObs = calcN.calculaNumeroDaVida("11/04/2002");
        assertEquals(resEsp,resObs);
    }

    @Test
    public void testCalcNroDestino(){
        int resEsp = 7;
        int resObs = calcN.calculaNumeroDestino("Carlos Alberto Silveira da Silva");
        assertEquals(resEsp,resObs);
    }
}