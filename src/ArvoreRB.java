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

        /*node.altura = 1 + Math.max(alturaRB(node.esquerda), alturaRB(node.direita)); */


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
        return node != null && node.cor == Cor.VERMELHO;
    }

    private void inverterCores(NoRB node) {
        node.cor = Cor.VERMELHO;
        node.esquerda.cor = Cor.PRETO;
        node.direita.cor = Cor.PRETO;
    }

    /*private int alturaRB(NoRB node) {
        return node == null ? 0 : node.altura;
    }*/

    private NoRB rotacaoDireitaRB(NoRB node) {
        NoRB x = node.esquerda;
        node.esquerda = x.direita;
        x.direita = node;
        x.cor = node.cor;
        node.cor = Cor.VERMELHO;
        return x;
    }

    private NoRB rotacaoEsquerdaRB(NoRB node) {
        NoRB x = node.direita;
        node.direita = x.esquerda;
        x.esquerda = node;
        x.cor = node.cor;
        node.cor = Cor.VERMELHO;
        return x;
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(raiz);
        System.out.println();
    }

    private void imprimirEmOrdem(NoRB node) {
        if (node != null) {
            imprimirEmOrdem(node.esquerda);
            System.out.print(node.valor + (node.cor == Cor.VERMELHO ? "R " : "P "));
            imprimirEmOrdem(node.direita);
        }
    }
}
