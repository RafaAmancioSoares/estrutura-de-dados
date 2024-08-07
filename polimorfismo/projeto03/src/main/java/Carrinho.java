import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    List<Vendavel> vendas;

    public Carrinho() {
        this.vendas = new ArrayList<>();
    }

    public void adicionarVenda(Vendavel v) {
        vendas.add(v);
        System.out.println("Venda cadastrada");
    }

    public Double calcularTotalVenda() {
        Double total = 0.0;
        for (Vendavel v : vendas) {
            total += v.getValorVenda();
        }
        return total;
    }

    public void exibeItensCarrinhos(){
        for (Vendavel v : vendas) {
            System.out.println(v);
        }
    }
}
