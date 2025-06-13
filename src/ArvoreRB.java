public class ArvoreRB {
    NoRB raiz;

    public void inserirRB(int valor) {
        raiz = inserirRB(raiz, valor);
    }

    NoRB inserirRB(NoRB node, int valor) {
        if (node == null) return new NoRB(valor);

        if (valor < node.valor)
            node.esquerda = inserirRB(node.esquerda, valor);
        else if (valor > node.valor)
            node.direita = inserirRB(node.direita, valor);
        else
            return node;
        // Altura
        node.altura = 1 + Math.max(alturaRB(node.esquerda), alturaRB(node.direita)); //A função Math.max serve para achar o maior valor entre duas variáveis

        // Balanceamento
        int b = balanceamentoRB(node); //Ver a diferença de altura entre a esquerda e direita

        // Rotações

        if (ehVermelho(node.direita) && !ehVermelho(node.esquerda))
            node = rotacaoEsquerdaRB(node);
        if (ehVermelho(node.esquerda) && ehVermelho(node.esquerda.esquerda))
            node = rotacaoDireitaRB(node);
        if (ehVermelho(node.esquerda) && ehVermelho(node.direita))
            inverterCores(node);

        return node;
    }

    private boolean ehVermelho(NoRB node) {
        if (node == null) return false;
        return node.vermelho;
    }

    private void inverterCores(NoRB node) {
        node.vermelho = true;
        node.esquerda.vermelho = false;
        node.direita.vermelho = false;
    }

    private int alturaRB(NoRB node) {
        return node == null ? 0 : node.altura;
    }

    private int balanceamentoRB(NoRB node) {
        return node == null ? 0 : alturaRB(node.esquerda) - alturaRB(node.direita);
    }

    private NoRB rotacaoDireitaRB(NoRB y) {
        NoRB x = y.esquerda;
        NoRB T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = 1 + Math.max(alturaRB(y.esquerda), alturaRB(y.direita));
        x.altura = 1 + Math.max(alturaRB(x.esquerda), alturaRB(x.direita));

        return x;
    }

    private NoRB rotacaoEsquerdaRB(NoRB x) {
        NoRB y = x.direita;
        NoRB T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = 1 + Math.max(alturaRB(x.esquerda), alturaRB(x.direita));
        y.altura = 1 + Math.max(alturaRB(y.esquerda), alturaRB(y.direita));

        return y;
    }
}
