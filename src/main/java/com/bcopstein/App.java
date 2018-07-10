package com.bcopstein;

public class App{
    public static void main(String args[]){
        char letra = '\u00C0';
        System.out.println(letra);
        letra = '\u00E0';
        System.out.println(letra+" : "+Character.toUpperCase(letra));

        //String regex = "[\\s.,;!?]";
        String regex = "[\\p{Punct}\\p{Blank}]";
        String frase = "Hoje e dia 1";
        String[] palavras = frase.split(regex);
        for(int i=0;i<palavras.length;i++){
            System.out.println(palavras[i]);
        }

        Reducao r = new Reducao();
        System.out.println(r.reducaoPalavra("TESTE12"));
    }
}