package principal;
import java.util.Scanner;
public class historyTelling{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(dados.titulo);

        personagem sobrevivente = new personagem( "protagonista", "humano" ,10,1,"masculino",100);
        capitulo introducao = new capitulo("introducao",dados.capitulos.cap1, dados.escolhas.escolha_A +"\n" + dados.escolhas.escolha_B,sobrevivente, 0);
        introducao.mostrarCap();
        
        //Caminho A
        if(introducao.escolha == 1){

            capitulo capituloA = new capitulo("CapituloA",dados.capitulos.cap2,dados.escolhas.escolha_A1 + "\n" + dados.escolhas.escolha_A2,sobrevivente,0);
            end finalA2 = new end(dados.finais.final_A2,sobrevivente,sobrevivente.vida,-100);
            end finalA1 = new end(dados.finais.final_A1,sobrevivente,sobrevivente.vida,-100);
            
            capituloA.mostrarCap();
            //Finais A
            if(capituloA.escolha == 1){
                finalA1.mostrar();
            }
            else if(capituloA.escolha == 2){
                finalA2.mostrar();
            }
        }

        //Caminho B
         else if (introducao.escolha == 2){

            //capitlo B
            capitulo capituloB = new capitulo("CapituloB",dados.capitulos.cap2, dados.escolhas.escolha_B1 + "\n" + dados.escolhas.escolha_B2, sobrevivente, 0);
            end finalB2 = new end(dados.finais.final_B2,sobrevivente,sobrevivente.vida,-100);
            
            capituloB.mostrarCap();
            
            //Finais B
            if(capituloB.escolha == 2){
                finalB2.mostrar();
            }
            
            //Única continuação certa para a continuação da história
            else{
                
                personagem carangueijo = new personagem("carangueijo gigante","animal marinho",-100,50);
                capitulo capituloC = new capitulo("CapituloC", dados.finais.final_B1 + dados.capitulos.cap3,dados.escolhas.escolha_C1+ dados.escolhas.escolha_C2,sobrevivente, 0);
                end finalC1 = new end(dados.finais.final_C1,sobrevivente,sobrevivente.vida,0,-3);
                end finalC2 =new end(dados.finais.final_C2,sobrevivente,sobrevivente.vida,carangueijo.dano);
                
                capituloC.mostrarCapResumido();
             
                
                System.out.println("Digite seu nome: ");
                String name = input.nextLine(); //entrada do nome desejado
                sobrevivente.setName(name);

                System.out.println("\nAo ler o seu nome " + sobrevivente.nome + " você se lembra de como foi parar lá, mas percebe que um"+ 
                " carangueijo gigante está vindo em sua direção, o que você faz?\n");
                
                capituloC.mostrarEscolhas();
                
                if (capituloC.escolha == 1) {
                    finalC1.mostrar();
                    sobrevivente.getEstamina();
                } 
                else{
                    finalC2.mostrar();
                }      
            } 
        }
    input.close();   
    }
}
    
