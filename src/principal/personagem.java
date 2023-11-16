package principal;

public class personagem{

    String nome;
    int Estamina;
    int dano;
    String especie;
    String sexo;
    int vida;
 
    public personagem(String nome, String especie, int Estamina, int dano, String sexo, int vida) {
        this.nome = nome;
        this.Estamina = Estamina;
        this.dano = dano;
        this.especie = especie;
        this.sexo = sexo;
        this.vida = vida;

    }

    public personagem(String nome, String especie, int dano,int vida) {
        this.nome = nome;
        this.dano = dano;
        this.especie = especie;
        this.vida = vida;

    }

    public void addEstamina(int Estamina){
        this.Estamina += Estamina;
        if (Estamina<0) {
            System.out.println("Você perdeu " + Estamina + " de estamina.");
        }
        else{
            System.out.println("Você ganhou " + Estamina + " de estamina.");
        }
    }

    public void setEstamina(int Estamina){
        this.Estamina = Estamina;
    }

    public void getEstamina(){
        
        if (this.Estamina == 1) {//correçao de escrita
            System.out.println("Você tem atualmente " + this.Estamina + " ponto de estamina.\n");
        }
        else{
            System.out.println("Você tem atualmente " + this.Estamina + " pontos de estamina.\n");
        }
    }
    
    public void endGame(){
        System.out.println("\n------Você morreu, fim de jogo.------\n");
        System.exit(0);
        
    }

    public void verificaVida(){
        if (this.vida <= 0) {
            endGame();
        }
    }

    public void getVida(){
        System.out.println("Você tem atualmente " + this.vida + " pontos de vida.");
    }
 
    public void addVida(int vidaPoints){
        this.vida += vidaPoints;
        if (vidaPoints<0) {
            System.out.println("Você perdeu " + vidaPoints + " pontos de vida.");
            getVida();
        }
        else if(vidaPoints == 0){
            System.out.println("Não houve alteração na sua vida.");
        }
        
        else{
            System.out.println("Você ganhou " + vidaPoints + "pontos de vida.");
            getVida();
        }
        verificaVida();
    }

    public void setName(String nome){
        this.nome = nome;
    }
}

