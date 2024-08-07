public class TesteListaEstatica1 {

    public static void main(String[] args) {

        ListaEstatica listaEstatica = new ListaEstatica(4);
        ListaEstaticaOrdenada listaEstaticaOrdenada = new ListaEstaticaOrdenada(3);

        listaEstatica.adiciona(10);
        listaEstatica.adiciona(20);
        listaEstatica.adiciona(30);

        //listaEstatica.exibe();

        //listaEstatica.busca(20);
        //System.out.println(listaEstatica.removePeloIndice(0));
        //listaEstatica.exibe();
        //System.out.println("\n------");

        //listaEstatica.removeElemento(20);
        //listaEstatica.adiciona(40);
        //listaEstatica.exibe();

        //System.out.println("\n------");
        //listaEstatica.substitui(10, 50);
        //listaEstatica.exibe();

        //listaEstatica.contaOcorrencias(50);

        //listaEstatica.adicionaNoInicio(50);
        //listaEstatica.exibe();

        listaEstaticaOrdenada.adiciona(50);
        listaEstaticaOrdenada.exibe();
        System.out.println("---------");
        listaEstaticaOrdenada.adiciona(10);
        listaEstaticaOrdenada.exibe();
        System.out.println("---------");
        listaEstaticaOrdenada.adiciona(30);
        listaEstaticaOrdenada.exibe();

    }
}
