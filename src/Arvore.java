import java.util.Stack;

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

        percorrerEmOrdem(node.esquerda);     // Visita a subárvore esquerda
        System.out.print(node.valor + " ");  // Visita o nó atual
        percorrerEmOrdem(node.direita);      // Visita a subárvore direita
    }

    public void percorrerPosOrdem() {
        percorrerPosOrdem(raiz);
    }

    private void percorrerPosOrdem(No node) {
        if (node == null) return;

        percorrerPosOrdem(node.esquerda);
        percorrerPosOrdem(node.direita); // Visita a subárvore esquerda
        System.out.print(node.valor + " ");  // Visita o nó atual
             // Visita a subárvore direita
    }

    public void percorrerPreOrdemIterativo() {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) { //Enquanto a pilha não estiver vazia
            No atual = pilha.pop(); //Retira atual
            System.out.print(atual.valor + " ");


            if (atual.direita != null) pilha.push(atual.direita); //Coloca o da direita primeiro pq será o último a sair
            if (atual.esquerda != null) pilha.push(atual.esquerda);
        }
    }

    public void percorrerEmOrdemIterativo() {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null){ //Repete até chegar em um nó null
                pilha.push(atual); //Empilha o nó atual
                atual = atual.esquerda; //Chama o nó da esquerda como próximo
            }

            atual = pilha.pop(); //Desempilha o atual

            System.out.print(atual.valor + " ");

            atual = atual.direita; //Se tiver um nó a direita ele leva para o segundo while

        }
    }

    public void percorrerPosOrdemIterativo() {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null){
                pilha.push(atual);
                atual = atual.esquerda;
                pilha.push(atual);
                atual = atual.direita;
                pilha.push(atual);
                atual = atual.esquerda;
                pilha.push(atual);
            }

            atual = pilha.pop();

            System.out.print(atual.valor + " ");

        }
    }
}
