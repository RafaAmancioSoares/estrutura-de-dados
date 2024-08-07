public abstract class Educador {

    private String nome;
    private Integer qtdAulas;
    private Double valorHora;

    public Educador(String nome, Integer qtdAulas, Double valorHora) {
        this.nome = nome;
        this.qtdAulas = qtdAulas;
        this.valorHora = valorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdAulas() {
        return qtdAulas;
    }

    public void setQtdAulas(Integer qtdAulas) {
        this.qtdAulas = qtdAulas;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public abstract Double getValorBonus();

    @Override
    public String toString() {
        return "Educador{" +
                "nome='" + nome + '\'' +
                ", qtdAulas=" + qtdAulas +
                ", valorHora=" + valorHora +
                '}';
    }
}
