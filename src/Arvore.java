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

    public void percorrerPreOrdem() {
        percorrerPreOrdem(raiz);
    }

    private void percorrerPreOrdem(No node) {
        if (node == null) return;

        System.out.print(node.valor + " "); // Visita o nó
        percorrerPreOrdem(node.esquerda);   // Vai para a subárvore esquerda
        percorrerPreOrdem(node.direita);    // Vai para a subárvore direita
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdem(raiz);
    }

    private void percorrerEmOrdem(No node) {
        if (node == null) return;

        percorrerEmOrdem(node.esquerda);     // Primeiro visita a subárvore esquerda
        System.out.print(node.valor + " ");  // Depois visita o nó atual
        percorrerEmOrdem(node.direita);      // Por fim, visita a subárvore direita
    }
}
