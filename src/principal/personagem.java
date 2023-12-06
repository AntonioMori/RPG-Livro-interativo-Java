package principal;

public class personagem{
    private String nome;
    private int dano;
    private int vida;
    private int estamina;
 
    public personagem(String nome, int estamina, int dano, int vida) {
        this.nome = nome;
        this.dano = dano;
        this.vida = vida;
        this.estamina = estamina;
    }

    //getters
    
    public void printGetVida(){
        System.out.println("Você tem atualmente " + this.vida + " pontos de vida.");
    }
    
    private int getEstamina(){
        return this.estamina;
    }

    public int getVida(){
        return this.vida;
    }

    public int getDano() {
        return this.dano;
    }

    public String getNome() {
        return this.nome;
    }


    //setters

    public void setEstamina(int estaminaPoints){
        this.estamina += estaminaPoints;
        if (estaminaPoints<0) {
            System.out.println("Você perdeu " + estaminaPoints + " de estamina.");
        }
        else if (estaminaPoints==0) {
            System.out.println("Error stamina - 'setEstamina(null)'");
        }else{
            System.out.println("Você ganhou " + estaminaPoints + " de estamina.");
        }
        System.out.println("Sua estamina atual é: "+ getEstamina());
    }

    
    public void setName(String nome){
        //to do (add a verification to the name)
        this.nome = nome;
    }
    
    

    public void setVida(int vidaPoints){
        this.vida += vidaPoints;
        if (vidaPoints<0) {
            System.out.println("Você perdeu " + vidaPoints + " pontos de vida.");
            printGetVida();
        }
        else if(vidaPoints == 0){
            System.out.println("Não houve alteração na sua vida.");
        }
        
        else{
            System.out.println("Você ganhou " + vidaPoints + "pontos de vida.");
            printGetVida();
        }
       
        if (this.vida <= 0) {
            endGame();
        }
    }

    //others
    
    private void endGame(){
        System.out.println("\n------Você morreu, fim de jogo.------\n");
        System.exit(0);
        
    }

}

