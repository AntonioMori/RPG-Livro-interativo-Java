package principal;

public class escolha {
    String texto;
    capitulo proximo;

    public escolha(String texto, capitulo proximo){
        this.texto = texto;
        this.proximo = proximo;
        
    }

    public String getTexto() {
        return this.texto;
    }

    public capitulo getProximo() {
        return this.proximo;
    }

    public void setProximo(capitulo proximo) {
        this.proximo = proximo;
    }
}
