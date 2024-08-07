import java.util.Scanner;

public class TesteListaAlunos {

    public static void main(String[] args) {

        boolean fim = false;
        Integer ra;
        String nome;
        Double nota;
        Integer indice;

        ListaObj listaObj = new ListaObj<>();


        Scanner leitor = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);

        while(!fim) {

            System.out.print("Escolha uma das opções: " +
                    "\n1. Adicionar um aluno" +
                    "\n2. Exibir a lista" +
                    "\n3. Exibir um aluno da lista" +
                    "\n4. Limpar a lista" +
                    "\n5. Buscar um aluno pelo RA" +
                    "\n6. Fim \n");
            Integer resposta = leitor.nextInt();

            switch (resposta){
                case 1:
                    System.out.println("RA:");
                    ra = leitor.nextInt();
                    System.out.println("Nome:");
                    nome = leitorTexto.nextLine();
                    System.out.println("Nota:");
                    nota = leitor.nextDouble();
                    listaObj.adiciona(ra, nome, nota);
                    break;

                case 2 :
                    listaObj.exibe();
                    break;

                case 3:
                    System.out.println("Digite o indice do usuário que deseja buscar: ");
                    indice = leitor.nextInt();
                    listaObj.busca(indice);
                    break;

                case 4:
                    listaObj.limpa();
                    System.out.println("A lista foi esvaziada");
                    break;

                case 5:
                    boolean encontrou = false;
                    System.out.println("Digite o ra do usuário que deseja buscar: ");
                    ra = leitor.nextInt();
                    for (int i = 0; i < listaObj.getTamanho(); i++) {
                        if (listaObj.getElemento(i).getRa().equals(ra)) {
                            System.out.println(listaObj.getElemento(i));
                            encontrou = true;
                            break;
                        }
                    }
                    if (!encontrou) {
                        System.out.println("Aluno não encontrado!");
                    }
                    break;

                case 6:
                    fim = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }

    }

}
