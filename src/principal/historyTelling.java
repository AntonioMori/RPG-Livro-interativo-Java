package principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



public class historyTelling extends Application implements Serializable{
    public static void main(String[] args) {
        
        launch(args);

    
        
        Scanner input = new Scanner(System.in);
        //Lista de personagens
        List<personagem> listaPersonagens = lerPersonagens("data/personagens.json");
        
        //mapa dos capitulos
        Map<String, capitulo> mapCapitulos = lerCapitulos("data/capitulos.json", listaPersonagens);
        
        //mapa das escolhas
        Map<String, escolha> mapEscolhas = lerEscolhasjson("data/escolhas.json", mapCapitulos);
        
        capitulo introducao = mapCapitulos.get("Introdução");  
        capitulo capituloA = mapCapitulos.get("Capitulo A");
        capitulo capituloB = mapCapitulos.get("Capitulo B");
        capitulo capituloC = mapCapitulos.get("Capitulo C");
        capitulo finalA2 = mapCapitulos.get("Final A2");
        capitulo finalA1 = mapCapitulos.get("Final A1");
        capitulo finalB2 = mapCapitulos.get("Final B2");
        capitulo finalC1 = mapCapitulos.get("Final C1");
        capitulo finalC2 = mapCapitulos.get("Final C2");
        
        
        
        // array de escolhas para cada capitulo
        escolha[] introducaoCap = new escolha[2]; 
        introducaoCap[0] = mapEscolhas.get("escolha_A"); // A
        introducaoCap[1] = mapEscolhas.get("escolha_B"); // B
        introducao.setArray(introducaoCap);// Escolhas da introdução
        
        
        escolha[] escolhasCapA = new escolha[2];
        escolhasCapA[0] = mapEscolhas.get("escolha_A1"); //A , morrer
        escolhasCapA[1] = mapEscolhas.get("escolha_A2"); //A , morrer   
        
        capituloA.setArray(escolhasCapA); //capitulo B aponta para escolhas do capitulo C

        
        escolha[] escolhasCapB = new escolha[2];
        escolhasCapB[0] = mapEscolhas.get("escolha_B1");// B, sobreviver
        escolhasCapB[1] = mapEscolhas.get("escolha_B2"); //B , morrer
        
        capituloB.setArray(escolhasCapB); // escolhas do cap B
            
        
        escolha[] escolhasCapC = new escolha[2];
        escolhasCapC[0] = mapEscolhas.get("escolha_C1"); // correr 
        escolhasCapC[1] = mapEscolhas.get("escolha_C2"); // morrer
        
        capituloC.setArray(escolhasCapC);
        
        
        capitulo capAtual = carregarProgresso(mapCapitulos,"data/capitulo_atual.txt");
        
        if (capAtual == null) {
            // Se não houver progresso salvo, começa do início
            capAtual = mapCapitulos.get("Introdução");
        }
    
        
        capituloC.setDiferencial();
        capAtual.executar();    
        input.close();    
        
        
    }
    
    //Função para criar um mapa de personagens a partir de um arquivo .json
    private static List<personagem> lerPersonagens(String filePath) {
        try (FileReader fileReader = new FileReader(filePath)) {
            Gson gson = new Gson();
            return gson.fromJson(fileReader, new TypeToken<List<personagem>>() {}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


//Função para criar um mapa de capitulos a partir de um arquivo .json
    private static Map<String, capitulo> lerCapitulos(String filePath, List<personagem> listaPersonagens) {
        try (FileReader fileReaderCapitulos = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type listaCapitulosType = new TypeToken<List<capitulo>>() {}.getType();
            List<capitulo> listaCapitulos = gson.fromJson(fileReaderCapitulos, listaCapitulosType); //cria cada um dos capítulos e armazena em
            //uma lista de capítulos
    
            //cria um mapa de capítulos a partir da lista de capítulos
            // Criando um mapa de capítulos com o nome como chave
            Map<String, capitulo> mapCapitulos = new HashMap<>(); 
            
            for (capitulo cap : listaCapitulos) {
                cap.setPersonagem(listaPersonagens); //seta o personagem associado ao capitulo 
                // Adicionando ao mapa de capítulos
                mapCapitulos.put(cap.getNome(), cap);
            }
    
            return mapCapitulos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




//Função para criar um mapa de escolhas a partir de um arquivo .json
// criado o mapa eu preciso criar um array de escolhas para cada capitulo
    private static Map<String, escolha> lerEscolhasjson(String filePath, Map<String, capitulo> mapCapitulos) {
        try (FileReader fileReaderEscolhas = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type listaEscolhasType = new TypeToken<List<escolha>>() {}.getType();
            List<escolha> listaEscolhas = gson.fromJson(fileReaderEscolhas, listaEscolhasType);

            // Criando um mapa de escolhas com o nome como chave
            Map<String, escolha> mapEscolhas = new HashMap<>();
            
            for (escolha escolha : listaEscolhas) {
                
    
                for (capitulo cap : mapCapitulos.values()) {
                    if (cap.getNome().equals(escolha.getProximoCapNome())) {
                        escolha.setProximo(cap);
                    }
                }
                
                mapEscolhas.put(escolha.getNome(), escolha);
            }

            return mapEscolhas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }   

    public static capitulo carregarProgresso(Map<String, capitulo> mapCapitulos,String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String nomeCapituloAtual = reader.readLine();
            System.out.println("Dev teste - cap: "+ nomeCapituloAtual+"\n");
            return mapCapitulos.get(nomeCapituloAtual);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    // JAVA FX IMPLEMENTATION
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layoutTeste.fxml"));
        
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("The Florest");
        primaryStage.setScene(tela);
        primaryStage.show();
    }

}
    
