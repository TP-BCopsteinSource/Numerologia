package com.bcopstein;

public class Formatador{
    // Formata uma palavra da língua inglesa
    // A palavra recebida so pode conter letras ou dígitos
    // Se a palavra contiver qualquer outro tipo de símbolo deve retornar IllegalArgumentException
    public String formataPalavra(String palavra){
        String newPal = "";
        for(int i=0;i<palavra.length();i++){
            char c = palavra.charAt(i);
            c = Character.toUpperCase(c);
            if (!Character.isAlphabetic(c) && !Character.isDigit(c)){
                throw new IllegalArgumentException("Caracter invalido: ["+c+"]");
            }else{
                newPal += c;
            }
        }
        return newPal;
    }

    // Formata frases compostas por palavras separadas por espaços em branco e/ou símbolos de pontuacao
    // As palavras da frase devem ser convertidas pelo metodo formataPalavra
    // Qualquer outro símbolo gera IllegalArgumentException
    // Retorna uma frase com palavras separadas por um único espaço em branco cada 
    public String formataFrase(String frase){
        return null;
    }
/*
    // Usou tabela: https://utf8-chartable.de/unicode-utf8-table.pl
    private char converteChar(char caracter){
        caracter = Character.toUpperCase(caracter);
        switch(caracter){
            case '\u00C0': 
            case '\u00C1':
            case '\u00C2':
            case '\u00C3':
            case '\u00C4':
            case '\u00C5':
                return 'A';
            case '\u00C8':
            case '\u00C9':
            case '\u00CA':
            case '\u00CB':
                 return 'E';
            case '\u00CC':
            case '\u00CD':
            case '\u00CE':
            case '\u00CF':
                 return 'I';
            case '\u00D2':
            case '\u00D3':
            case '\u00D4':
            case '\u00D5':
            case '\u00D6':
                return'O';
            case '\u00D9':
            case '\u00DA':
            case '\u00DB':
            case '\u00DC':
                return 'U';
            case '\u00C7':
                return 'C';
            default:
                return caracter;
        }
    }
    */
}