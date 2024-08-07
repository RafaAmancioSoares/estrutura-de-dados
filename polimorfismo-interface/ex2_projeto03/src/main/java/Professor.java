public class Professor extends Educador{

    public Professor(String nome, Integer qtdAulas, Double valorHora) {
        super(nome, qtdAulas, valorHora);
    }

    @Override
    public Double getValorBonus() {
        return getQtdAulas() * getValorHora() * 4.5 * 0.15;
    }

    @Override
    public String toString() {
        return "Professor{} " + super.toString() +
                "valor bonus= " + getValorBonus();
    }
}
