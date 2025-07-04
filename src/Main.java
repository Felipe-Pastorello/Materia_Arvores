import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*No raiz = new No("A");
        raiz.esquerda = new No("B");
        raiz.direita = new No("C");
        raiz.esquerda.esquerda = new No("D");
        raiz.esquerda.direita = new No("E");
        raiz.direita.direita = new No("F");

        Arvore arvore = new Arvore(raiz); //Cria a árvore que irá agrupar os nós

        System.out.println("Quantidade de nós: " + arvore.contarNos());

        System.out.println("Pré Ordem");
        arvore.percorrerPreOrdem();
        System.out.println("\n");
        System.out.println("Em Ordem");
        arvore.percorrerEmOrdem();
        System.out.println("\n");
        System.out.println("Pós Ordem");
        arvore.percorrerPosOrdem();
        System.out.println("\n");
        System.out.println("Pré Ordem Iterativo");
        arvore.percorrerPreOrdemIterativo();
        System.out.println("\n");
        System.out.println("Em Ordem Iterativo");
        arvore.percorrerEmOrdemIterativo();
        System.out.println("\n");
        System.out.println("Pós Ordem Iterativo");
        arvore.percorrerPosOrdemIterativo();
        System.out.println("\n");
        System.out.println("Nível");
        arvore.buscaEmNivel();
        System.out.println("\n");
        System.out.println("Contar nós Iterativo");
        System.out.println(arvore.contarNosIterativo());
        System.out.println("\n");
        System.out.println("Contar nós Pilha");
        System.out.println(arvore.contarNosPilha());
        System.out.println("\n");
        System.out.println("Folhas");
        System.out.println(arvore.nosFolha());

        ArvoreAVL avl = new ArvoreAVL();

        int[] chaves = {10, 20, 30, 40, 50, 25};

        for (int chave : chaves){
            avl.raiz = avl.inserir(avl.raiz, chave);
        }

        System.out.println("Percurso em ordem");
        avl.imprimirEmOrdem(avl.raiz);*/

        ArvoreRB arvore = new ArvoreRB();

        arvore.inserirRB(10);
        arvore.inserirRB(20);
        arvore.inserirRB(30);
        arvore.inserirRB(15);
        arvore.inserirRB(5);
        arvore.inserirRB(25);

        System.out.print("Árvore em ordem: ");
        arvore.imprimirEmOrdem();
    }
}