public class Coordenador extends Professor{

    private Integer qtdCoordenacao;
    private Double valorHoraCoord;

    public Coordenador(String nome, Integer qtdAulas, Double valorHora, Integer qtdCoordenacao, Double valorHoraCoord) {
        super(nome, qtdAulas, valorHora);
        this.qtdCoordenacao = qtdCoordenacao;
        this.valorHoraCoord = valorHoraCoord;
    }

    @Override
    public Double getValorBonus() {
        return getQtdAulas() * getValorHora() * 4.5 *
                0.15 + qtdCoordenacao * valorHoraCoord* 4.5 *
                0.2;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "qtdCoordenacao=" + qtdCoordenacao +
                ", valorHoraCoord=" + valorHoraCoord +
                "} " + super.toString() +
                "valor bonus= " + getValorBonus();
    }
}
