package com.bcopstein;

import java.util.regex.Pattern;

// Todas as palavras só podem conter letras maiúsculas não acentudas e dígitos
// Todas as frases devem ser formadas por palavras separadas por um espaço em branco cada
// As datas devem seguir o formato dd/mm/aaaa
// Qualquer quebra destas regras deve retornar "IllegalArgumentExpression"
//
// Veja os tipos de tabelas na wiki do projeto
public class Reducao{
    private TipoTabela tipoTab;

    public Reducao(){
        tipoTab = TipoTabela.PITAGORICA;
    }

    // Decodifica um caracter segundo a tabela Pitagorica
    private int tabPitagorica(char c){
        switch(c){
            case 'A':
            case 'J':
            case 'S':
                return(1);
            case 'B':
            case 'K':
            case 'T':
                return(2);
            case 'C':
            case 'L':
            case 'U':
                return(3);
            case 'D':
            case 'M':
            case 'V':
                return(4);
            case 'E':
            case 'N':
            case 'W':
                return(5);
            case 'F':
            case 'O':
            case 'X':
                return(6);
            case 'G':
            case 'P':
            case 'Y':
                return(7);
            case 'H':
            case 'Q':
            case 'Z':
                return(8);
            case 'I':
            case 'R':
                return(9);
            default:
                throw new IllegalArgumentException("Caracter: "+c);
        }
    }

    // Decodifica um caracter segundo a tabela Chaldean
    private int tabChaldean(char c){
        switch(c){
            case 'A':
            case 'I':
            case 'J':
            case 'Q':
            case 'Y':
                return(1);
            case 'B':
            case 'K':
            case 'R':
                return(2);
            case 'C':
            case 'G':
            case 'L':
            case 'S':
                return(3);
            case 'D':
            case 'M':
            case 'T':
                return(4);
            case 'E':
            case 'H':
            case 'N':
            case 'X':
                return(5);
            case 'U':
            case 'V':
            case 'W':
                return(6);
            case 'O':
            case 'Z':
                return(7);
            case 'F':
            case 'P':
                return(8);
            default:
                throw new IllegalArgumentException("Caracter: "+c);
        }
    }

    // Decodifica um caracter segundo a tabela selecionada
    private int decodChar(char c){
        if (Character.isDigit(c)){
            return Character.getNumericValue(c);
        }else{
            switch(tipoTab){
                case PITAGORICA:
                    return tabPitagorica(c);
                case CHALDEAN:
                    return tabChaldean(c);
                default:
                    throw new IllegalArgumentException("Tabela de conversao invalida!");
            }
        }
    }

    private String reducaoSimples(String str){
        int soma = 0;
        for(int i=0;i<str.length();i++){
            soma += decodChar(str.charAt(i));
        }
        return soma + "";
    }

    // Define o tipo de tabela da tabela corrente
    public void setTipoTabela(TipoTabela tipo){
        tipoTab = tipo;
    }

    // Calcula a reducao de palavra usando a tabela corrente
    public int reducaoPalavra(String palavra){
        String reducao = palavra;
        do{
            reducao = reducaoSimples(reducao);
        }while(reducao.length() > 1);
        return Character.getNumericValue(reducao.charAt(0));
    }

    // Calcula a reducao de frase usando a tabela corrente
    public int reducaoFrase(String frase){
        String[] lstPal = frase.split(" ");
        int soma = 0;
        for(int i=0;i<lstPal.length;i++){
            soma += reducaoPalavra(lstPal[i]);
        }
        return soma;
    }

    // Calcula a redução de uma data no formato dd/mm/aaaa
    // Se estiver fora do formato lança IllegalArgumentException
    public int reducaoData(String data){
        if (!Pattern.matches("\\d{2}/\\d{2}/\\d{4}",data)){
            throw new IllegalArgumentException("Formato de data inválido!!");
        }else{
            int soma = Character.getNumericValue(data.charAt(0));
            soma += Character.getNumericValue(data.charAt(1));
            soma += Character.getNumericValue(data.charAt(3));
            soma += Character.getNumericValue(data.charAt(4));
            soma += Character.getNumericValue(data.charAt(6));
            soma += Character.getNumericValue(data.charAt(7));
            soma += Character.getNumericValue(data.charAt(8));
            soma += Character.getNumericValue(data.charAt(9));
            return reducaoPalavra(soma+"");
        }
    }
}