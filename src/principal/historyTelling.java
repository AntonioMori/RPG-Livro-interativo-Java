package principal;
import java.util.Scanner;



public class historyTelling{
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        personagem carangueijo = new personagem(10,-100,50);
        personagem sobrevivente = new personagem(10,1,100);
       
        //raiz
        capitulo introducao = new capitulo(dados.capitulos.cap1,0);
        capitulo capituloA = new capitulo( dados.capitulos.cap2,0 );
        capitulo capituloB = new capitulo(dados.capitulos.cap2,0 );
        capitulo capituloC = new capitulo(dados.finais.final_B1 + dados.capitulos.cap3,sobrevivente,0, true);
        capitulo finalA2 = new capitulo(dados.finais.final_A2,sobrevivente,-100,10);
        capitulo finalA1 = new capitulo(dados.finais.final_A1,sobrevivente,-100,10);
        capitulo finalB2 = new capitulo(dados.finais.final_B2, sobrevivente,-100, 10);
        capitulo finalC1 = new capitulo(dados.finais.final_C1, sobrevivente,0,-3);
        capitulo finalC2 = new capitulo(dados.finais.final_C2,sobrevivente,carangueijo.getDano(),10);

        // array de escolhas para cada capitulo
        escolha[] introducaoCap = new escolha[2]; 
        introducaoCap[0] = new escolha(dados.escolhas.escolha_A, capituloA); // A
        introducaoCap[1] = new escolha(dados.escolhas.escolha_B, capituloB); // B

        introducao.setArray(introducaoCap);// Escolhas da introdução


        
        escolha[] escolhasCapA = new escolha[2];
        escolhasCapA[0] = new escolha(dados.escolhas.escolha_A1, finalA1); //A , morrer
        escolhasCapA[1] = new escolha(dados.escolhas.escolha_A2, finalA2); //A , morrer   
        
        capituloA.setArray(escolhasCapA); //capitulo B aponta para escolhas do capitulo C



        escolha[] escolhasCapB = new escolha[2];
        escolhasCapB[0] = new escolha(dados.escolhas.escolha_B1, capituloC);// B, sobreviver
        escolhasCapB[1] = new escolha(dados.escolhas.escolha_B2, finalB2); //B , morrer

        capituloB.setArray(escolhasCapB); // escolhas do cap B



        escolha[] escolhasCapC = new escolha[2];
        escolhasCapC[0] = new escolha(dados.escolhas.escolha_C1, finalC1); // correr 
        escolhasCapC[1] = new escolha(dados.escolhas.escolha_C2, finalC2); // morrer

        capituloC.setArray(escolhasCapC);

  
        introducao.executar();    
           
        input.close();   
    }
}
    
