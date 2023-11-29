package principal;

import java.util.Scanner;



public class capitulo{
    
    private String texto;
    private String pergunta;
    private personagem personagem;
    
    private int dano;
    private int estamina;
    private boolean diferencial;
    private escolha[] arrayEscolhas;

    
    static Scanner input = new Scanner(System.in);

    public capitulo(String texto) {
        
        this.texto = texto;
        
        pergunta = "Escolha uma opção: ";
    }

    //construtor capitulo final
    public capitulo(String texto,personagem personagem,int dano, int estamina){
        this.texto =texto;
        this.personagem = personagem;
        
        this.dano= dano;
        this.estamina=estamina;

    }
    public capitulo(String texto, personagem personagem, boolean diferencial) {
        
        this.texto = texto;
        this.personagem = personagem;
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
            System.out.println("\nAo ler o seu nome '" + this.personagem.getNome() + "' você se lembra de como foi parar lá, mas percebe que um"+ 
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
            this.personagem.setVida(this.dano);
            this.personagem.setEstamina(this.estamina);
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