package principal;
import java.util.Scanner;

public class historyTelling{
     
    //função saida de texto
    public static void output(String texto){
        System.out.println(texto);
    }
    
    public static int inputInt(String text){
        output(text);
        Scanner input = new Scanner(System.in);
        int entrada = input.nextInt();
        return entrada;
    }

    public static String input(String text){
        output(text);
        Scanner input = new Scanner(System.in);
        String entrada = input.nextLine();
        return entrada;
    }
  
    public static void main(String[] args) {
        
        personagem sobrevivente = new personagem( "protagonista", "humano" ,10,1,"masculino",100);
        
        // capitulo 1 e introdução
        output(dados.capitulos.titulo);
        output(dados.capitulos.cap1);
        output(dados.escolhas.escolha_A +"\n" + dados.escolhas.escolha_B);
        int escolha = inputInt("Escolha uma opção:");
        

        //verificacao se a escolha é valida
        while(escolha != 1 && escolha != 2){
            output("Opção inválida, digite novamente.");
            escolha = inputInt("Escolha uma opção: ");
        }

        //Caminho A
        if(escolha == 1){

            //capitulo A-2
            output(dados.capitulos.cap2);
            escolha = 0;

            output(dados.escolhas.escolha_A1 + "\n" + dados.escolhas.escolha_A2);
            escolha = inputInt("Escolha uma opção: ");
           
            //verificacao se a escolha é valida
            while(escolha != 1 && escolha != 2){
                output("Opção inválida, digite novamente.");
                escolha = inputInt("Escolha uma opção: ");
            }
            
            //Finais A
            if(escolha == 1){
                output(dados.finais.final_A1);
                sobrevivente.addVida(-100);

            }
            else if(escolha == 2){
                output(dados.finais.final_A2);
                sobrevivente.addVida(-100);
            }

        }

        //Caminho B
         else if (escolha == 2){

            //capitlo B-2
            output(dados.capitulos.cap2);
            escolha = 0;
            
            output(dados.escolhas.escolha_B1 + "\n" + dados.escolhas.escolha_B2);
            escolha = inputInt("Escolha uma opção: ");
            
            //verificacao se a escolha é valida
            while(escolha != 1 && escolha != 2){
                output("Opção inválida, digite novamente.");
                escolha = inputInt("Escolha uma opção: ");
            }

            //Finais B
            if(escolha == 2){
                output(dados.finais.final_B2);         
                sobrevivente.addVida(-100);
            }
            
            //Única continuação certa para a continuação da história
            else if(escolha == 1){
                output(dados.finais.final_B1);
               
                output("\nAo retomar consciência você acorda rodeado de destroços de avião em uma ilha" +
                " e não consegue se lembrar de nada.\nAo verificar os seus bolsos voce encontra uma carteira com"+
                " um documento, ao ler o documento você descobre que o seu nome é...");
               
                
                String name = input(""); //entrada do nome desejado
                sobrevivente.setName(name);

                output("\nAo ler o seu nome " + sobrevivente.nome + " você se lembra de como foi parar lá, mas percebe que um"+ 
                " carangueijo gigante está vindo em sua direção, o que você faz?");
                output("\n1 - Correr para a floresta\n2 - jogar uma pedra nele\n");
                
                 escolha = inputInt("Escolha uma opção: ");//recebendo escolha do jogador

                if (escolha == 1) {
                    
                    output("\nVocê corre para a floresta e consegue fugir dele, mas agora você está com fadiga.");
                    sobrevivente.addEstamina(-3);
                    sobrevivente.getEstamina();
                    output("\n");
               
                } 
                else{
    
                    //criando um personagem carangueijo gigante 
                    personagem carangueijo = new personagem("carangueijo gigante","animal marinho",100,50);
                    int danoCarangueijo = carangueijo.dano;//pegando o valor do dano do carangueijo
                    
                    output("\nVocê joga uma pedra nele e ele se assusta, se tornando mais agressivo ainda,"+
                    " ele se aproxima e te ataca.");
                    
                    sobrevivente.addVida(-danoCarangueijo);//tirando a vida do sobrevivente de acordo com o dano do carangueijo
                }      

            } 
                
        }
    }

}
    
