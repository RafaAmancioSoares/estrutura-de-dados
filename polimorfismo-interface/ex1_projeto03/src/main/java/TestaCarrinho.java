import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class TestaCarrinho {

    public static void main(String[] args) {

        Carrinho carrinho1 = new Carrinho();

        Scanner leitor = new Scanner(System.in);
        Scanner leitorLn = new Scanner(System.in);

        boolean compra = true;

        while (compra) {
            System.out.println("Bem vinda ao menu, escolha uma das opções:");
            System.out.println("1. Adicionar livro" +
                    "\n2. Adicionar DVD" +
                    "\n3. Adicionar Servico" +
                    "\n4. Exibir itens do carrinho" +
                    "\n5. Exibir total devenda" +
                    "\n6. Fim");
            Integer menu = leitor.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Digite o código:");
                    Integer codigoLivro = leitor.nextInt();

                    System.out.println("Digite o nome:");
                    String nomeLivro = leitorLn.nextLine();

                    System.out.println("Digite o preço:");
                    Double precoLivro = leitor.nextDouble();

                    System.out.println("Digite o autor:");
                    String autorLivro = leitorLn.nextLine();

                    System.out.println("Digite o ISBN:");
                    String isbnLivro = leitorLn.nextLine();

                    Livro livro1 = new Livro(codigoLivro, nomeLivro, precoLivro, autorLivro, isbnLivro);
                    carrinho1.adicionarVenda(livro1);
                    System.out.println("-".repeat(30));
                    break;

                case 2:
                    System.out.println("Digite o código:");
                    Integer codigoDvd = leitor.nextInt();

                    System.out.println("Digite o nome:");
                    String nomeDvd = leitorLn.nextLine();

                    System.out.println("Digite o preço:");
                    Double precoDvd = leitor.nextDouble();

                    System.out.println("Digite a gravadora:");
                    String gravadoraDvd = leitorLn.nextLine();

                    DVD dvd1 = new DVD(codigoDvd, nomeDvd,precoDvd, gravadoraDvd);
                    carrinho1.adicionarVenda(dvd1);
                    System.out.println("-".repeat(30));
                    break;

                case 3:
                    System.out.println("Digite a descrição:");
                    String descricaoServico = leitorLn.nextLine();

                    System.out.println("Digite o código:");
                    Integer codigoServico = leitor.nextInt();

                    System.out.println("Digite a quantidade de horas de serviço:");
                    Integer qtdHorasServico = leitor.nextInt();

                    System.out.println("Digite o valor das horas de serviço:");
                    Double valorHorasServico = leitor.nextDouble();

                    Servico servico1 = new Servico(descricaoServico, codigoServico, qtdHorasServico, valorHorasServico);
                    carrinho1.adicionarVenda(servico1);
                    System.out.println("-".repeat(30));
                    break;

                case 4:
                    carrinho1.exibeItensCarrinhos();
                    System.out.println("-".repeat(30));
                    break;

                case 5:
                    System.out.println(carrinho1.calcularTotalVenda());
                    System.out.println("-".repeat(30));
                    break;

                case 6:
                    System.out.println("Obrigado por comprar conosco!");
                    System.out.println("-".repeat(30));
                    compra = false;
                    break;

                default:
                    System.out.println("Número errado!");
                    System.out.println("-".repeat(30));
                    break;

            }


        }

    }
}
