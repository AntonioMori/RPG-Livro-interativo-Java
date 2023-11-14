package principal;
import java.util.Scanner;

import principal.dados.escolhas;

public class historyTelling{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(dados.titulo);

        personagem sobrevivente = new personagem( "protagonista", "humano" ,10,1,"masculino",100);
        
        capitulo introducao = new capitulo(
            "introducao", //nome
            dados.capitulos.cap1,//texto
            new String[] {dados.escolhas.escolha_A,dados.escolhas.escolha_B},//array de escolhas
            sobrevivente,//personagem
             0);//int escolha


        introducao.mostrarCap();
        
        
        //Caminho A
        if(introducao.escolha == 1){
            
            capitulo capituloA = new capitulo(
                "CapituloA", //nome 
                dados.capitulos.cap2, //texto
                new String[]{dados.escolhas.escolha_A1,dados.escolhas.escolha_A2},//array de escolhas
                sobrevivente,//personagem
                0  //int escolha
            );
            capitulo finalA2 = new capitulo(dados.finais.final_A2,sobrevivente,sobrevivente.vida,-100,10);
            capitulo finalA1 = new capitulo(dados.finais.final_A1,sobrevivente,sobrevivente.vida,-100,10);
            
            
            capituloA.mostrarCap();
            //Finais A
            if(capituloA.escolha == 1){
                finalA1.mostrarFinal();
            }
            else if(capituloA.escolha == 2){
                finalA2.mostrarFinal();
            }
        }

        //Caminho B
         else if (introducao.escolha == 2){

            //capitlo B
            capitulo capituloB = new capitulo(
                "CapituloB", //nome do capitulo
                dados.capitulos.cap2, //texto
                new String[]{ dados.escolhas.escolha_B1,dados.escolhas.escolha_B2}, //array de escolhas
                 sobrevivente, //personagem
                 0 //int escolhas
            );

            capitulo finalB2 = new capitulo(dados.finais.final_B2, sobrevivente, sobrevivente.vida,-100, 10);
            
            capituloB.mostrarCap();
            
            //Finais B
            if(capituloB.escolha == 2){
                finalB2.mostrarFinal();
            }
            
            //Única continuação certa para a continuação da história
            else{
                
                personagem carangueijo = new personagem("carangueijo gigante","animal marinho",-100,50);
                capitulo capituloC = new capitulo(
                    "CapituloC", //titulo
                     dados.finais.final_B1 + dados.capitulos.cap3, //texto
                        new String[]{dados.escolhas.escolha_C1,dados.escolhas.escolha_C2}, //array de escolhas
                        sobrevivente, //personagem
                        0 //int escolha
                );
                

                capitulo finalC1 = new capitulo(dados.finais.final_C1, sobrevivente, sobrevivente.vida,0,-3);
                capitulo finalC2 = new capitulo(dados.finais.final_C2,sobrevivente,sobrevivente.vida,carangueijo.dano,10);
                
                capituloC.mostrarCapResumido();
             
                
                System.out.println("Digite seu nome: ");
                String name = input.nextLine(); //entrada do nome desejado
                sobrevivente.setName(name);

                System.out.println("\nAo ler o seu nome " + sobrevivente.nome + " você se lembra de como foi parar lá, mas percebe que um"+ 
                " carangueijo gigante está vindo em sua direção, o que você faz?\n");
                
                capituloC.mostrarEscolhas(); // 
                
                if (capituloC.escolha == 1) {
                    finalC1.mostrarFinal();
                    sobrevivente.getEstamina();
                } 
                else{
                    finalC2.mostrarFinal();
                }      
            } 
        }
    input.close();   
    }
}
    
