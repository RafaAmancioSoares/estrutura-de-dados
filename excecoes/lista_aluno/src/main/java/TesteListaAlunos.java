import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteListaAlunos {

    public static void gravaArquivoCSV(ListaObj<Aluno> lista, String nomeArq){
        FileWriter arquivo = null; // Objeto que representa o arquivo que será usado para escrita/gravação
        Formatter saida = null; // Objeto que será usado para escrever o arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv"; // Acrescenta a extensão do arquivo ;csv

        // Bloco try-catch para abrir o arquivo
        try{
            arquivo = new FileWriter(nomeArq);
            saida = new Formatter(arquivo);
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo!");
            System.exit(1);
        }

        // Bloco try-catch para gravar no arquivo
        try{
            for (int i = 0; i < lista.getTamanho(); i++){
                Aluno aluno = lista.getElemento(i);
                saida.format("%010d;%-30.30s;%5.2f\n",
                        aluno.getRa(),
                        aluno.getNome(),
                        aluno.getNota());
            }
        }
        catch (FormatterClosedException erro){
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try{
                arquivo.close();
            }
            catch(IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if(deuRuim){
                System.exit(1);
            }
        }
    }


    public static void leArquivoCSV(String nomeArq){
        FileReader arquivo = null; // obj que representa o arquivo que será aberto para leitura
        Scanner entrada = null; // obj que será usado para ler o arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try{
            arquivo = new FileReader(nomeArq);
            // Para o Scanner entender o que o \n é um delimitador precisa colocar \\n
            entrada = new Scanner(arquivo).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro){
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler o arquivo
        try {
            System.out.printf("%-10s %-30s %5s\n", "RA", "NOME", "NOTA");
            while (entrada.hasNext()){
                Integer ra = entrada.nextInt();
                String nome = entrada.next();
                Double nota = entrada.nextDouble();
                System.out.printf("%10d %-30.30s %5.2f\n", ra, nome, nota);
            }
        }
        catch (NoSuchElementException erro){
            System.out.printf("Arquivo com problema");
            deuRuim = true;
        }
        catch (IllegalStateException erro){
            System.out.println("Erro na leitura do arquivo");
        }
        finally {
            entrada.close();
            try{
                arquivo.close();
            }
            catch(IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if(deuRuim){
                System.exit(1);
            }
        }
    }


    public static void main(String[] args) {

        boolean fim = false;
        Integer ra;
        String nome;
        Double nota;
        Integer indice;

        ListaObj<Aluno> alunoListaObj = new ListaObj<>(3);


        Scanner leitor = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);

        while(!fim) {

            System.out.print("Escolha uma das opções: " +
                    "\n1. Adicionar um aluno" +
                    "\n2. Exibir a lista" +
                    "\n3. Exibir um aluno da lista" +
                    "\n4. Limpar a lista" +
                    "\n5. Buscar um aluno pelo RA" +
                    "\n6. Gravar a lista num arquivo csv" +
                    "\n7. Ler e exibir o arquivo csv" +
                    "\n8. Fim \n");
            Integer resposta = leitor.nextInt();

            switch (resposta){
                case 1:
                    System.out.println("RA:");
                    ra = leitor.nextInt();
                    System.out.println("Nome:");
                    nome = leitorTexto.nextLine();
                    System.out.println("Nota:");
                    nota = leitor.nextDouble();
                    Aluno aluno = new Aluno(ra, nome, nota);
                    alunoListaObj.adiciona(aluno);
                    break;

                case 2 :
                    alunoListaObj.exibe();
                    break;

                case 3:
                    System.out.println("Digite o indice do usuário que deseja buscar: ");
                    indice = leitor.nextInt();
                    alunoListaObj.busca(alunoListaObj.getElemento(indice));
                    break;

                case 4:
                    alunoListaObj.limpa();
                    System.out.println("A lista foi esvaziada");
                    break;

                case 5:
                    boolean encontrou = false;
                    System.out.println("Digite o ra do usuário que deseja buscar: ");
                    ra = leitor.nextInt();
                    for (int i = 0; i < alunoListaObj.getTamanho(); i++) {
                        if (alunoListaObj.getElemento(i).getRa().equals(ra)) {
                            System.out.println(alunoListaObj.getElemento(i));
                            encontrou = true;
                            break;
                        }
                    }
                    if (!encontrou) {
                        System.out.println("Aluno não encontrado!");
                    }
                    break;

                case 6:
                    gravaArquivoCSV(alunoListaObj, "aluno");
                    System.out.println("Arquivo gravado");
                    break;

                case 7:
                    leArquivoCSV("aluno");
                    break;

                case 8:
                    fim = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }

    }

}
