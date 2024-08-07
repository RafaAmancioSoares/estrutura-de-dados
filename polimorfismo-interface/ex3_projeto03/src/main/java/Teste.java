public class Teste {

    public static void main(String[] args) {

        Apartamento apartamento1 = new Apartamento("kitnet", 20, 200000.00, 1, 1, 9);
        Casa casa1 = new Casa("Sobrado", 90, 600000.0, 3, 2, 2);
        Casa casa2 = new Casa("terrea", 120, 550000.0, 2, 3, 1);

        Imobiliaria imobiliaria = new Imobiliaria();

        imobiliaria.adicionarImovel(apartamento1);
        imobiliaria.adicionarImovel(casa1);
        System.out.println("-".repeat(30));

        imobiliaria.exibirImoveis();
        System.out.println("-".repeat(30));

        System.out.println(imobiliaria.valorTotalImoveis());
        System.out.println("-".repeat(30));
    }
}
