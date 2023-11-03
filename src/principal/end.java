package principal;

public class end {
    String texto;
    int vida;
    int dano;
    int estamina;
    personagem personagem;


    public end(String texto, personagem personagem, int vida, int dano){
        this.texto = texto;
        this.personagem = personagem;
        this.vida = vida;
        this.dano = dano;
    }
    
    public end(String texto, personagem personagem, int vida, int dano, int estamina){
        this.texto = texto;
        this.personagem = personagem;
        this.vida = vida;
        this.dano = dano;
        this.estamina = estamina;
    }

    public void mostrar(){
        System.out.println(texto);
        this.personagem.addVida(this.dano);
        this.personagem.addEstamina(this.estamina);
        
    }

}
