package principal;

import java.util.Scanner;

public class capitulo{
    String nome;
    String texto;
    String[] escolhas;
    String pergunta;
    personagem personagem;
    personagem personagem2;
    int escolha;
    int vida;
    int dano;
    int estamina;

    
    static Scanner input = new Scanner(System.in);

    public capitulo(String nome, String texto, String[] escolhas, personagem personagem, int escolha) {
        this.nome = nome;
        this.texto = texto;
        this.escolhas = escolhas;
        this.personagem = personagem;
        this.escolha = escolha;
        pergunta = "Escolha uma opção: ";
    }

    //construtor capitulo final
    public capitulo(String texto,personagem personagem,int vida,int dano, int estamina){
        this.texto =texto;
        this.personagem=personagem;
        this.vida = vida;
        this.dano= dano;
        this.estamina=estamina;

    }

    public void mostrarFinal(){
        System.out.println(texto);
        this.personagem.addVida(this.dano);
        this.personagem.addEstamina(this.estamina);
        
    }

    public void mostrarEscolhas(){
        for (int i = 0; i < escolhas.length; i++) {
            System.out.println("escolha - "+ (i+1)+" : "+ escolhas[i]);
            
        }
        escolher();
        
    }  

    public void mostrarCapResumido(){
        System.out.println(texto);
    }

    public void mostrarCap(){
        System.out.println(texto);
        for (int i = 0; i < escolhas.length; i++) {
            System.out.println("escolha - "+ (i+1)+" : "+ escolhas[i]);
            
        }
        System.out.println("\n"+pergunta);
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