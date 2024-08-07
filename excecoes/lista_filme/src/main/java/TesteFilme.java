import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteFilme {

    public static void gravaArquivoCSV(ListaObj<Filme> lista, String nomeArq){
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
                Filme filme = lista.getElemento(i);
                saida.format("%6s;%-15s;%5s;%-10s;%5s\n\n",
                        filme.getIdFilme(),
                        filme.getNome(),
                        filme.getNota(),
                        filme.getGenero(),
                        filme.getIdade());
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
            System.out.printf("%6s %-15s %5s %-10s %5s\n", "CÓDIGO", "NOME", "NOTA", "GÊNERO", "IDADE");
            while (entrada.hasNext()){
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                Double nota = entrada.nextDouble();
                String genero = entrada.next();
                Integer idade = entrada.nextInt();
                System.out.printf("%06d %-15s %5.1f %-10s %5d\n", id, nome, nota, genero, idade);
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

        ListaObj lista = new ListaObj(4);

        boolean sair = false;
        int id;
        String nome;
        Double nota;
        String genero;
        int idade;

        Scanner leitor = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);

        while (!sair) {
            System.out.println("-".repeat(20));
            System.out.println("ESCOLHA UMA DAS OPÇÕES: \n" +
                    "1. Adicionar um filme\n" +
                    "2. Exibir a lista\n" +
                    "3. Gravar a lista em arquivo CSV\n" +
                    "4. Ler e exibir um arquivo CSV\n" +
                    "5. Gravar em outro arquivo CSV apenas filmes que estão na lista, mas de um determinado gênero\n" +
                    "6. Sair");
            System.out.println("-".repeat(20));
            Integer resposta = leitor.nextInt();
            System.out.println("-".repeat(20));

            switch (resposta) {
                case 1:
                    System.out.println("ID: ");
                    id = leitor.nextInt();

                    System.out.println("NOME: ");
                    nome = leitorTexto.next();

                    System.out.println("NOTA: ");
                    nota = leitor.nextDouble();

                    System.out.println("GÊNERO: ");
                    genero = leitor.next();

                    System.out.println("IDADE: ");
                    idade = leitor.nextInt();

                    Filme filme = new Filme(id, nome, nota, genero, idade);
                    lista.adiciona(filme);
                    break;

                case 2:
                    lista.exibe();
                    break;

                case 3:
                    gravaArquivoCSV(lista, "filmes");
                    break;

                case 4:
                    leArquivoCSV("filmes");
                    break;

                case 5:
                    System.out.println("Escolha um genero: ");
                    String generoPesquisa = leitorTexto.next();

                    ListaObj<Filme> generoFilmes = new ListaObj<>(4);

                    break;

                case 6:
                    lista.limpa();
                    break;

                default:
                    System.out.println("Resposta inválida, tente outra!");
                    continue;

            }
        }
    }
}
