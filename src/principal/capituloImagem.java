package principal;
//Apenas uma classe para a utilização do construtor Super, não utilizado no código principal mas sim
// em testes e fins educativos
public class capituloImagem extends capitulo{
    private String imagem;


    //construtor capitulo Final com imagem 
    public capituloImagem(String nome, String texto,String nomePersonagem,int dano, int estamina,String imagem) {
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