package com.bcopstein;

import java.util.regex.Pattern;

public class Formatador{
    // Formata uma palavra da língua inglesa
    // A palavra recebida so pode conter letras ou dígitos
    // Se a palavra contiver qualquer outro tipo de símbolo deve retornar IllegalArgumentException
    // Se a palavra estiver vazia também retorna a exceção
    // Retorna a palavra em maíusculas 
    public String formataPalavra(String palavra){
		String newPal = palavra.toUpperCase();
        if (Pattern.matches("[A-Z0-9]+", newPal)){
            return newPal;
        }else{
            throw new IllegalArgumentException("Caracter invalido: ["+newPal+"]");
        }
    }

    // Formata frases compostas por palavras separadas por espaços em branco e/ou símbolos de pontuacao
    // Frases vazias geram IllegalArgumentException
    // As palavras da frase devem ser convertidas pelo metodo formataPalavra
    // Qualquer outro símbolo gera IllegalArgumentException
    // Retorna um array de palavras válidas 
    public String[] formataFrase(String frase){
        String regex = "[\\p{Punct}\\p{Blank}]+";
        String[] palavras = frase.split(regex);
        for(int i=0;i<palavras.length;i++){
            palavras[i] = formataPalavra(palavras[i]);
        }
        return palavras;
    }
}