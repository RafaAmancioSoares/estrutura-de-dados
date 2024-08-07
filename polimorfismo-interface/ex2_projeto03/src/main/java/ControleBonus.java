import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    List<Educador> educadores;

    public ControleBonus() {
        this.educadores = new ArrayList<>();
    }

    public void adicionar(Educador e) {
        educadores.add(e);
        System.out.println("Usuario cadastrado");
    }

    public void exibeLista() {
        for (Educador e : educadores) {
            System.out.println(e);
        }
    }

    public Double totalBonus() {
        Double total = 0.0;

        for (Educador e : educadores) {
            total += e.getValorBonus();
        }
        return total;
    }
}

