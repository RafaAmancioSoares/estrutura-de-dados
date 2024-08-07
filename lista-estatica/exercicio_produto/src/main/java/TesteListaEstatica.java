public class TesteListaEstatica {

    public static void main(String[] args) {

        Produto produto1 = new Produto<>(1, "bolacha",
                3.00, "****", 0);
        Produto produto2 = new Produto<>(2, "pão",
                8.90, "*****", 0);
        Produto produto3 = new Produto<>(3, "macarrão",
                5.00, "*", 0);
        Produto produto4 = new Produto<>(4, "molho",
                2.00, "***", 0);
        Produto produto5 = new Produto<>(5, "feijão",
                6.00, "**", 0);

        ListaObj listaObj = new ListaObj<>(5);

        listaObj.adiciona(produto1);
        listaObj.adiciona(produto2);
        listaObj.adiciona(produto3);
        listaObj.adiciona(produto4);
        listaObj.adiciona(produto5);

        listaObj.exibe();
        System.out.println("-".repeat(15));

        produto1.comprar(2);
        produto2.comprar(1);
        produto3.comprar(4);
        produto4.comprar(1);
        produto5.comprar(5);

        listaObj.exibe();
        System.out.println("-".repeat(15));

        System.out.println(produto1.getNome() +
                " fatourou: R$" + produto1.calcularFaturamento());
        System.out.println(produto2.getNome() +
                " fatourou: R$" + produto2.calcularFaturamento());
        System.out.println(produto3.getNome() +
                " fatourou: R$" + produto3.calcularFaturamento());
        System.out.println(produto4.getNome() +
                    " fatourou: R$" + produto4.calcularFaturamento());
        System.out.println(produto5.getNome() +
                    " fatourou: R$" + produto5.calcularFaturamento());

        
    }
}
