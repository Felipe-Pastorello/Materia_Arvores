import java.util.LinkedList;
import java.util.Queue;
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

        percorrerPosOrdem(node.esquerda); // Visita a subárvore esquerda
        percorrerPosOrdem(node.direita);  // Visita a subárvore direita
        System.out.print(node.valor + " ");  // Visita o nó atual

    }

    public void percorrerPreOrdemIterativo() {
        percorrerPreOrdemIterativo(raiz);
    }

    public void percorrerPreOrdemIterativo(No node) {
        if (node == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(node);

        while (!pilha.isEmpty()) { //Enquanto a pilha não estiver vazia
            No atual = pilha.pop(); //Retira atual
            System.out.print(atual.valor + " ");


            if (atual.direita != null) pilha.push(atual.direita); //Coloca o da direita primeiro pq será o último a sair
            if (atual.esquerda != null) pilha.push(atual.esquerda);
        }
    }

    public void percorrerEmOrdemIterativo() {
        percorrerEmOrdemIterativo(raiz);
    }

    public void percorrerEmOrdemIterativo(No node) {
        if (node == null) return;

        Stack<No> pilha = new Stack<>();
        No atual = node;

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
        percorrerPosOrdemIterativo(raiz);
    }

    public void percorrerPosOrdemIterativo(No node) {
        if (node == null) return;

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();
        pilha1.push(node);

        while (!pilha1.isEmpty()) { //Enquanto a pilha 1 não estiver vazia
            No atual = pilha1.pop(); //Retira o primeiro
            pilha2.push(atual);


            if (atual.esquerda != null) pilha1.push(atual.esquerda);
            if (atual.direita != null) pilha1.push(atual.direita); //É o último, para ser retirado antes da esquerda. Porque começará pelo lado da esquerda
        }



        while (!pilha2.isEmpty()) {
            System.out.print(pilha2.pop().valor + " ");
        }
    }

    public void buscaEmNivel() {
        buscaEmNivel(raiz);
    }

    public void buscaEmNivel(No node){
        if (node == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(node);

        while (!fila.isEmpty()){
            No atual = fila.poll();
            System.out.println(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
    }

    public int nosFolha() {
        return nosFolha(raiz);
    }

    public int nosFolha(No node){
        if (node == null) return 0;

        Queue<No> fila = new LinkedList<>();
        fila.add(node);
        int n = 0;

        while (!fila.isEmpty()){
            No atual = fila.poll();

            if (atual.esquerda == null && atual.direita == null){
                n++;
            }
            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);

        }
        return n;
    }

    public int contarNosIterativo() {
        return contarNosIterativo(raiz);
    }

    public int contarNosIterativo(No node){
        if (node == null) return 0;

        Queue<No> fila = new LinkedList<>();
        fila.add(node);
        int n = 0;

        while (!fila.isEmpty()){
            No atual = fila.poll();
            n++;

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
        return n;
    }

    public int contarNosPilha() {
        return contarNosPilha(raiz);
    }

    public int contarNosPilha(No node){
        if (node == null) return 0;

        Stack<No> fila = new Stack<>();
        fila.add(node);
        int n = 0;

        while (!fila.isEmpty()){
            No atual = fila.pop();
            n++;

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
        return n;
    }
}
