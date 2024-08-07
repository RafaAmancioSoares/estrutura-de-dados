public class Casa extends Imovel {

    private Integer qtdAndares;

    public Casa(String tipo, Integer metragem, Double valorTotal, Integer qtdComodos, Integer qtdBanheiros, Integer qtdAndares) {
        super(tipo, metragem, valorTotal, qtdComodos, qtdBanheiros);
        this.qtdAndares = qtdAndares;
    }

    @Override
    public Double getValorMetro() {
        return getValorTotal()/getMetragem();
    }

    @Override
    public String toString() {
        return "Casa{" +
                "qtdAndares=" + qtdAndares +
                ", valor por metro quadrado=" + getValorMetro() +
                "} " + super.toString();
    }
}
