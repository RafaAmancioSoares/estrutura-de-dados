public abstract class Imovel {

    private String tipo;
    private Integer metragem;
    private Double valorTotal;
    private Integer qtdComodos;
    private Integer qtdBanheiros;

    public Imovel(String tipo, Integer metragem, Double valorTotal, Integer qtdComodos, Integer qtdBanheiros) {
        this.tipo = tipo;
        this.metragem = metragem;
        this.valorTotal = valorTotal;
        this.qtdComodos = qtdComodos;
        this.qtdBanheiros = qtdBanheiros;
    }

    public abstract Double getValorMetro();

    public Integer getMetragem() {
        return metragem;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "tipo='" + tipo + '\'' +
                ", metragem=" + metragem +
                ", valorTotal=" + valorTotal +
                ", qtdComodos=" + qtdComodos +
                ", qtdBanheiros=" + qtdBanheiros +
                '}';
    }
}
