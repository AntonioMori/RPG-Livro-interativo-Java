package principal;

public class capituloImagem extends capitulo{
    private String imagem;


    //construtor capitulo Final com imagem 
    public capituloImagem(String nome, String texto,String nomePersonagem,int dano, int estamina) {
        super(nome, texto, nomePersonagem, dano, estamina);
        this.imagem = imagem;
    }

    
    @Override
    public void mostrar(){
        System.out.println(getTexto());
        System.out.println(imagem);
    }
    
    public void setImagem(String imagem){
        this.imagem = imagem;
    }
    public String getImagem(){
        return this.imagem;
    }

}