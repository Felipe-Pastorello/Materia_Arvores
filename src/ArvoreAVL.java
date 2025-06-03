public class ArvoreAVL {
    private NoAVL raiz;

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private NoAVL inserir(NoAVL node, int valor) {
        if (node == null) return new NoAVL(valor);

        if (valor < node.valor)
            node.esquerda = inserir(node.esquerda, valor);
        else if (valor > node.valor)
            node.direita = inserir(node.direita, valor);
        else
            return node;
        System.out.println(node);
        // Altura
        node.altura = 1 + Math.max(altura(node.esquerda), altura(node.direita)); //A função Math.max serve para achar o maior valor entre duas variáveis

        // Balanceamento
        int b = balanceamento(node); //Ver a diferença de altura entre a esquerda e direita

        // Rotações

        // Caso Esquerda-Esquerda (LL)


        // Caso Direita-Direita (RR)


        // Caso Esquerda-Direita (LR)

        return node;
    }

    private int altura(NoAVL node) {
        return node == null ? 0 : node.altura;
    }

    private int balanceamento(NoAVL node) {
        return node == null ? 0 : altura(node.esquerda) - altura(node.direita);
    }
}
