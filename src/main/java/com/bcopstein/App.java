package com.bcopstein;

public class App{
    public static void main(String args[]){
        char letra = '\u00C0';
        System.out.println(letra);
        letra = '\u00E0';
        System.out.println(letra+" : "+Character.toUpperCase(letra));
        Formatador f = new Formatador();
        System.out.println(f.formataPalavra("Pão"));
    }
}