import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {

    List<Imovel> imoveis;

    public Imobiliaria() {
        this.imoveis = new ArrayList<>();
    }

    public void adicionarImovel(Imovel i) {
        imoveis.add(i);
        System.out.println("Imóvel cadastrado!");
    }

    public void exibirImoveis() {
        for (Imovel i : imoveis) {
            System.out.println(i);
        }
    }

    public Double valorTotalImoveis() {
        Double total = 0.0;

        for (Imovel i : imoveis) {
            total += i.getValorTotal();
        }

        return total;
    }
}
