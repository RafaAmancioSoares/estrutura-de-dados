public class Apartamento extends Imovel {

    private Integer andar;

    public Apartamento(String tipo, Integer metragem, Double valorTotal, Integer qtdComodos, Integer qtdBanheiros, Integer andar) {
        super(tipo, metragem, valorTotal, qtdComodos, qtdBanheiros);
        this.andar = andar;
    }

    @Override
    public Double getValorMetro() {
        return getValorTotal()/getMetragem();
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "andar=" + andar +
                ", valor por metro quadrado=" + getValorMetro() +
                "} " + super.toString();
    }
}
