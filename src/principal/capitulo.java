package principal;

import java.util.Scanner;

public class capitulo{
    String nome;
    String texto;
    String escolhas;
    String pergunta;
    personagem personagem;
    personagem personagem2;
    int escolha;
    static Scanner input = new Scanner(System.in);

    public capitulo(String nome, String texto, String escolhas, personagem personagem, int escolha) {
        this.nome = nome;
        this.texto = texto;
        this.escolhas = escolhas;
        this.personagem = personagem;
        this.escolha = escolha;
        pergunta = "Escolha uma opção: ";
    }


    public void mostrarEscolhas(){
        System.out.println(escolhas);
        escolher();
        
    }  

    public void mostrarCapResumido(){
        System.out.println(texto);
    }

    public void mostrarCap(){
        System.out.println(texto);
        System.out.println(escolhas);
        System.out.println(pergunta);
        escolher();
    }
    

    public void escolher(){
        this.escolha = input.nextInt();
        while(escolha != 1 && escolha != 2){
            System.out.println("Opção inválida, digite novamente.");
            System.out.println(pergunta); 
            escolha = input.nextInt();
        }
    }

}