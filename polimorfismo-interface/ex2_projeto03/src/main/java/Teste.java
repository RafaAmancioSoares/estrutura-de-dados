public class Teste {

    public static void main(String[] args) {

        Professor professor1 = new Professor("Lucas", 45, 80.00);
        Coordenador coordenador1 = new Coordenador("Ana", 20, 90.00, 25, 110.00);

        ControleBonus controleBonus = new ControleBonus();

        controleBonus.adicionar(professor1);
        System.out.println("Exibir Lista de Educadores: ");
        controleBonus.exibeLista();
        System.out.println("-".repeat(30));

        System.out.println("Total de Bonus:");
        System.out.println(controleBonus.totalBonus());
        System.out.println("-".repeat(30));


    }
}
