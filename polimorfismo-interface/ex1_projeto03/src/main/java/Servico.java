public class Servico implements Vendavel{

    private String descricao;
    private Integer codigo;
    private Integer qtdHoras;
    private Double valorHoras;

    public Servico(String descricao, Integer codigo, Integer qtdHoras, Double valorHoras) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.qtdHoras = qtdHoras;
        this.valorHoras = valorHoras;
    }

    @Override
    public Double getValorVenda() {
        return qtdHoras * valorHoras;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", qtdHoras=" + qtdHoras +
                ", valorHoras=" + valorHoras +
                ", valor venda=" + getValorVenda() +
                '}';
    }
}
