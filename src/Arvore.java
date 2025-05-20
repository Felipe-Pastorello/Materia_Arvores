public class Arvore {
    No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    public int contarNos(No node){
        if (node == null) return 0;
        return 1 + contarNos(node.esquerda) + contarNos(node.direita);
    }
}
