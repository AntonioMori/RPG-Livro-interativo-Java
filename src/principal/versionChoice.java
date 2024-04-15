package principal;

import java.util.Scanner;

public class versionChoice {
    String pergunta = "Olá!"+
    "\nSeja bem vindo ao meu jogo feito inteiramente em java, espero que goste! \nAtualemente este jogo possue a versão "+
    "de texto e a versão gráfica, qual você deseja jogar?";
    Scanner input;

    public versionChoice(Scanner input){
        this.input = input;
    }

    public int chooseVersion(Scanner input){
        System.out.println(this.pergunta);
        System.out.println("Digite 1 para a versão de texto\nDigite 2 para a versão gráfica\n");
        String version = input.nextLine();
        verificaVersaoInput(version);
        return Integer.parseInt(version);

    }

    private void verificaVersaoInput(String version){ // verifica se o input é valido
        while(!version.equals("1") && !version.equals("2")){
            System.out.println("Opção inválida, tente novamente\n");
            System.out.println("Digite 1 para a versão de texto\nDigite 2 para a versão gráfica\n");
            version = input.nextLine();
        }
    }
    
    
}
