package principal;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.InputMismatchException;




public class capitulo{
    
    private String texto;
    private String pergunta = dados.escolhas.escolhaPergunta;
    private personagem personagem;
    private int dano;
    private int estamina;
    private boolean diferencial;
    private escolha[] arrayEscolhas;

    
    static Scanner input = new Scanner(System.in);

    public capitulo(String texto) {
        this.texto = texto;
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

        if (diferencial==true) { // se for um capitulo diferencial, ele precisa de um nome
                
            System.out.println("Digite seu nome: ");
            String name = input.next();
            String verifyedName = verificaNome(name);
            

            this.personagem.setName(verifyedName);
            System.out.println("\nAo ler o seu nome '" + this.personagem.getNome() + "' você se lembra de como foi parar lá, mas percebe que um"+ 
            " carangueijo gigante está vindo em sua direção, o que você faz?\n");
            diferencial =false;
            
        }
        if (arrayEscolhas != null) {
            for (int i = 0; i < arrayEscolhas.length; i++) {
             
            System.out.println(i+" - "+ arrayEscolhas[i].getTexto()); 
            
            }
            System.out.println("\n"+pergunta);
        
        }else{ // se nao houver um array de escolhas entao é um capitulo final logo, 
            //é visto as consequencias das suas escolhas
            this.personagem.setVida(this.dano);
            this.personagem.setEstamina(this.estamina);
        }
        


        
    }

    private boolean buscaIndice(int indice)
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

    private void escolher() {
        int resposta;

        do {
            try {
                
                resposta = input.nextInt();

                if (buscaIndice(resposta) != true) {
                    System.out.println("Opção inválida, por favor digite novamente.");
                }
            } catch (InputMismatchException e) {
                // Limpa o buffer do scanner em caso de entrada inválida
                input.nextLine();
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                resposta = -1; // Define resposta como -1 para continuar no loop
            }
        } while (!buscaIndice(resposta));


        
        // Executa a escolha válida
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
        
        
    }

    public void inicializarArray(escolha[] arrayEscolhas){
        this.arrayEscolhas = arrayEscolhas;
    }

    public void setArray(escolha[] arrayEscolhas){
        this.arrayEscolhas = arrayEscolhas;
    }

    private String verificaNome(String name){
        int n = 1;
        while (isValidName(name)==false) {
                if (n>2) {
                    System.out.println("\nVocê se esforçou tanto para tentar se lembrar do seu nome que voce desmaiou.");
                    this.personagem.setVida(-100);
                }
                else{
                    System.out.println("\n Nome inválido, por favor digite novamente: ");
                    name = input.next();
                    n++;
                }
            }
            return name;
    }


    //verifica se o nome é valido
    private boolean isValidName(String name) {
        return name != null && Pattern.matches("^[a-zA-Z\\s]+$", name) && name.length() <= 36 && name.length() >= 4;
    }
}