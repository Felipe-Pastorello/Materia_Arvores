public class NoRB {
    int valor /*altura*/;
    NoRB esquerda, direita;
    Cor cor;


    public NoRB(int valor){
        this.valor = valor;
        this.cor = Cor.VERMELHO;
    }
}
