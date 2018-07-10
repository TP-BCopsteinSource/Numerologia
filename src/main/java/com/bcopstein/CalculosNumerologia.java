package com.bcopstein;

// Ver os algoritmos de calculo na wiki do projeto
// Todos os métodos geram IllegalArgumentException em caso de caracter ilegal
public class CalculosNumerologia{
    private Formatador formatador;
    private Reducao reducao;

    // Recebe o redutor e o formatador a serem usados em todos os cálculos
    // por injeção de dependencia
    public CalculosNumerologia(Reducao reducao, Formatador formatador){
        this.reducao = reducao;
        this.formatador = formatador;
    }

    public int calculaNumeroDaVida(String data){
        int numero = reducao.reducaoData(data);
        return numero;
    }

    public int calculaNumeroDestino(String nomeCompleto){
        String nomeFormatado = formatador.formataFrase(nomeCompleto);
        int numero = reducao.reducaoFrase(nomeFormatado);
        return numero;
    }

    public int calculaNumeroDesejosDaAlma(String nomeCompleto){
        return 0;
    }
}