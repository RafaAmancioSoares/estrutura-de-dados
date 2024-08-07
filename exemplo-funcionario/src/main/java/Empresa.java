import java.util.ArrayList;
import java.util.List;

public class Empresa {

    // Atributo
    private List<Funcionario> lista;

    // Construtor
    public Empresa () {
        lista = new ArrayList<>();
    }

    // Métodos

    // Método adicionaFunc
    public void adicionaFunc(Funcionario f) {
        lista.add(f);
    }

    // Método exibeTodos
    public void exibeTodos() {
        System.out.println("Lista dos funcionários:");
        for (Funcionario f : lista) {
            System.out.println(f);
        }
    }

    // Método exibeTotalSalario
    public void exibeTotalSalario() {
        Double total = 0.0;
        for (Funcionario f : lista) {
            total += f.calcSalario();
        }
        System.out.println(String.format("Total dos salários: R$ %.2f",total));
        System.out.printf("Total dos salários: R$ %.2f\n",total);
    }

    // Método exibeHoristas
    public void exibeHoristas() {
        System.out.println("Lista dos horistas:");
        for (Funcionario f : lista) {
            if (f instanceof Horista) {
                System.out.println(f);
            }
        }
    }

    // Método buscaFunc
    public void buscaFunc(String cpf) {

    }



}
