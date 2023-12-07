package principal;
import java.io.Serializable;
public class escolha implements Serializable{
    private String nome;
    private String texto;
    private capitulo proximo;
    private String proximoCapNome;

    public escolha(String texto, capitulo proximo){
        this.texto = texto;
        this.proximo = proximo;
        
    }
    
    //getters
    
    public String getTexto() {
        return this.texto;
    }

    public capitulo getProximo() {
        return this.proximo;
    }

    public String getProximoCapNome() {
        return this.proximoCapNome;
    }
    public String getNome() {
        return this.nome;
    }
    //setters
    public void setProximo(capitulo proximo) {
        this.proximo = proximo;
    }


    
}
