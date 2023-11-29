package principal;

public class escolha {
    private String texto;
    private capitulo proximo;

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
    //setters
    
    public void setProximo(capitulo proximo) {
        this.proximo = proximo;
    }
}
