public class TesteAluno {

    public static void main(String[] args) {

        AlunoFundamental alunoFundamental1 = new AlunoFundamental(123, "rafaela", 8.0, 9.0, 7.0, 8.5);
        AlunoGraduacao alunoGraduacao1 = new AlunoGraduacao(456, "Flávia", 9.0, 9.5);
        AlunoPos alunoPos1 = new AlunoPos(789, "Ana", 9.9, 8.3, 10.0);

        System.out.println(alunoFundamental1);
        System.out.println(alunoGraduacao1);
        System.out.println(alunoPos1);

        Escola escola1 = new Escola("abc");

        escola1.exibeTodos();
        System.out.println("-".repeat(20));

        escola1.adicionaAluno(alunoFundamental1);
        System.out.println("-".repeat(20));

        escola1.adicionaAluno(alunoGraduacao1);
        System.out.println("-".repeat(20));

        escola1.buscaAluno(123);
        System.out.println("-".repeat(20));

        escola1.exibeTodos();
        System.out.println("-".repeat(20));

        escola1.exibeAprovados();

    }
}
