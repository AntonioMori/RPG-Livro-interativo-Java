package principal;

import java.util.Scanner;



public class capitulo{
    String nome;
    String texto;
    String pergunta;
    personagem personagem;
    personagem personagem2;
    int escolhaRespo;
    int vida;
    int dano;
    int estamina;
    boolean diferencial;
    escolha[] arrayEscolhas;

    
    static Scanner input = new Scanner(System.in);

    public capitulo(String nome, String texto, personagem personagem, int escolhaRespo) {
        this.nome = nome;
        this.texto = texto;
        this.personagem = personagem;
        this.escolhaRespo = escolhaRespo;
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
    public capitulo(String nome, String texto, personagem personagem, int escolhaRespo, boolean diferencial) {
        this.nome = nome;
        this.texto = texto;
        this.personagem = personagem;
        this.escolhaRespo = escolhaRespo;
        pergunta = "Escolha uma opção: ";
        this.diferencial = diferencial;
    }

    //introducao
    public void mostrar(){
        
        System.out.println(texto);//mostrar texto

        if (diferencial==true) {
                
            System.out.println("Digite seu nome: ");
            
            
            String name = input.next();
            this.personagem.setName(name);
            System.out.println("\nAo ler o seu nome " + this.personagem.nome + " você se lembra de como foi parar lá, mas percebe que um"+ 
            " carangueijo gigante está vindo em sua direção, o que você faz?\n");
            diferencial =false;
            
        }
        if (arrayEscolhas != null) {
            for (int i = 0; i < arrayEscolhas.length; i++) {
            String escolhaPrint = arrayEscolhas[i].getTexto();
            System.out.println(i+" - "+escolhaPrint); 
            
            }
            System.out.println("\n"+pergunta);
        
        }else{
            this.personagem.addVida(this.dano);
            this.personagem.addEstamina(this.estamina);
            this.personagem.verificaVida();
        }
        


        
    }

    public boolean buscaIndice(int indice)
    {
        
        for (int i = 0; i < arrayEscolhas.length; i++) 
        {
            if (i==indice) 
            {
                return true;
                
            }
        }
        return false;
        
    }

    

    public void escolher(){ // ele precisa
        
        int resposta = input.nextInt(); //entrada do usuario
        while (buscaIndice(resposta)==false) {
            System.out.println("\nOpção inválida, por favor digite novamente:");
            resposta = input.nextInt();
        }       

            for (int i = 0; i < arrayEscolhas.length; i++) {
                if (resposta == i) {
                    
                    capitulo proximo = arrayEscolhas[i].getProximo();
                    proximo.executar();
                    
                }
            }

    } 
    

    public void executar(){
        mostrar();
        escolher();
        executar();
        
    }

    public void inicializarArray(escolha[] arrayEscolhas){
        this.arrayEscolhas = arrayEscolhas;
    }

    public void setArray(escolha[] arrayEscolhas){
        this.arrayEscolhas = arrayEscolhas;
    }
}