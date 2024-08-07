import java.util.ArrayList;
import java.util.List;

public class Escola {

    private String nome;
    private List<Aluno> alunos;

    public Escola(String nome) {
        this.nome = nome;
        alunos = new ArrayList<>();
    }

    public void adicionaAluno(Aluno a) {
        alunos.add(a);
        System.out.println("Aluno cadastrado");
    }

    public void exibeTodos() {
        if (alunos.isEmpty()) {
            System.out.println("Lista de alunos vazia! Cadastre alunos");

        } else {
            System.out.println("Lista de Alunos: ");
            for (Aluno a : alunos) {
                System.out.println(alunos);
            }

        }
    }

    public void exibeAlunoGraduacao() {
        System.out.println("Alunos Graduação:");
        for (Aluno a : alunos) {
            if (a instanceof AlunoGraduacao) {
                System.out.println(alunos);
            }

        }
    }

    public void exibeAprovados() {
        System.out.println("Alunos aprovados:");
        for (Aluno a : alunos) {
            if (a.calcularMedia() >= 6.0) {
                System.out.println(a);
            }
        }
    }

    public void buscaAluno(Integer ra) {
        for (Aluno a : alunos) {
            if (a.getRa() == ra) {
                System.out.println(a);
            }
        }
    }


}
