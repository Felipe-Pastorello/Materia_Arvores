public class Main {
    public static void main(String[] args) {
        No raiz = new No("Teste");
        Arvore arvore = new Arvore(raiz);

        System.out.println("Quantidade de nós: " + arvore.contarNos());
    }
}