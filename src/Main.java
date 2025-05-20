public class Main {
    public static void main(String[] args) {
        No raiz = new No("A");
        raiz.esquerda = new No("B");
        raiz.direita = new No("C");
        raiz.esquerda.esquerda = new No("D");
        raiz.esquerda.direita = new No("E");
        raiz.direita.direita = new No("F");

        Arvore arvore = new Arvore(raiz); //Cria a árvore que irá agrupar os nós

        System.out.println("Quantidade de nós: " + arvore.contarNos());

        arvore.percorrerPreOrdem();
    }
}