package principal;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.io.Serializable;




public class capitulo implements Serializable{
    private String nome;
    private String texto;
    private String nomePersonagem;
    private int dano;
    private int estamina;
    private boolean diferencial;
    private escolha[] arrayEscolhas;
    private personagem personagemAssociado;
    

    
    static Scanner input = new Scanner(System.in);

    public capitulo(String nome,String texto) {
        this.nome = nome;
        this.texto = texto;
    }

    //construtor capitulo final
    public capitulo(String nome, String texto,String nomePersonagem,int dano, int estamina){
        this.nome = nome;
        this.texto =texto;
        this.nomePersonagem = nomePersonagem;
        this.dano= dano;
        this.estamina=estamina;

    }
    public capitulo(String nome, String texto, String nomePersonagem, boolean diferencial) {
        this.nome = nome;
        this.texto = texto;
        this.nomePersonagem = nomePersonagem;
        this.diferencial = diferencial;
    }

    public String getTexto(){
        return this.texto;
    } 

    public int getDano(){
        return this.dano;
    }
    public int getEstamina(){
        return this.estamina;
    }
    //introducao
    public void mostrar(){
        
        System.out.println(texto);//mostrar texto

        if (diferencial==true) { // se for um capitulo diferencial, ele precisa de um nome
                
            System.out.println("Digite seu nome: ");
            String name = input.next();
            String verifyedName = verificaNome(name);
            

            this.personagemAssociado.setName(verifyedName);
            System.out.println("\nAo ler o seu nome '" + this.personagemAssociado.getNome() + "' você se lembra de como foi parar lá, mas percebe que um"+ 
            " carangueijo gigante está vindo em sua direção, o que você faz?\n");
            diferencial =false;
            
        }
        if (arrayEscolhas != null) {
            
            for (int i = 0; i < arrayEscolhas.length; i++) { 
            System.out.println(i+" - "+ arrayEscolhas[i].getTexto()); 
            
            }
            
            System.out.println("Escolha uma opção: ");
        
        }else{ // se nao houver um array de escolhas entao é um capitulo final logo, 
            //é visto as consequencias das suas escolhas
            
            resetProgresso("data/capitulo_atual.txt");
            this.personagemAssociado.setVida(this.dano);
            this.personagemAssociado.setEstamina(this.estamina);
            
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
        salvarProgresso("data/capitulo_atual.txt");
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
                    resetProgresso("data/capitulo_atual.txt");
                    this.personagemAssociado.setVida(-100);

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

    public String getNome() {
        return this.nome;
    }

  public void setPersonagem(List<personagem> listaPersonagens) {
        for (personagem personagem : listaPersonagens) {
            if (personagem.getNome().equals(this.nomePersonagem)) {
                this.personagemAssociado = personagem;
                break;
            }
        }
    }

    public personagem getPersonagem() {
        return this.personagemAssociado;
    }

    public String getNomePersonagem() {
        return this.nomePersonagem;
    }

    public String getEscolhas() {
        String escolhas = "";
        for (int i = 0; i < arrayEscolhas.length; i++) {
            escolhas += arrayEscolhas[i].getTexto() + "\n";
        }
        return escolhas;
    }

    public void setDiferencial(){
        this.diferencial = true;
    }

    
    public void salvarProgresso(String filePath) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(this.nome);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void resetProgresso(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Introdução");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}