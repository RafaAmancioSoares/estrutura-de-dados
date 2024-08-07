import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Teste {

    public static void gravaArquivoCSV(ListaObj<Produto> lista, String nomeArq){
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
                Produto produto = lista.getElemento(i);
                saida.format("%6s;%-14s;%7s;%-5s;%12s\n",
                        produto.getCodProduto(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getAvaliacao(),
                        produto.getQntVendida());
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
            System.out.printf("%6s %-14s %7s %-9s %12s\n", "CÓDIGO", "NOME", "PREÇO", "AVALIAÇÃO", "FATURAMENTO");
            while (entrada.hasNext()){
                Integer codigo = entrada.nextInt();
                String nome = entrada.next();
                Double preco = entrada.nextDouble();
                String avaliacao = entrada.next();
                Integer faturamento = entrada.nextInt();
                System.out.printf("%06d %-14.14S %7.2f %-9s %12d\n", codigo, nome, preco, avaliacao, faturamento);
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

        Produto produto1 = new Produto<>(1, "bolacha",
                3.00, "****", 0);
        Produto produto2 = new Produto<>(2, "pão",
                8.90, "*****", 0);
        Produto produto3 = new Produto<>(3, "macarrão",
                5.00, "*", 0);
        Produto produto4 = new Produto<>(4, "molho",
                2.00, "***", 0);
        Produto produto5 = new Produto<>(5, "feijão",
                6.00, "**", 0);

        ListaObj listaObj = new ListaObj<>(5);

        listaObj.adiciona(produto1);
        listaObj.adiciona(produto2);
        listaObj.adiciona(produto3);
        listaObj.adiciona(produto4);
        listaObj.adiciona(produto5);

        listaObj.exibe();
        System.out.println("-".repeat(15));

        produto1.comprar(2);
        produto2.comprar(1);
        produto3.comprar(4);
        produto4.comprar(1);
        produto5.comprar(5);

        listaObj.exibe();
        System.out.println("-".repeat(15));

        System.out.println(produto1.getNome() +
                " fatourou: R$" + produto1.calcularFaturamento());
        System.out.println(produto2.getNome() +
                " fatourou: R$" + produto2.calcularFaturamento());
        System.out.println(produto3.getNome() +
                " fatourou: R$" + produto3.calcularFaturamento());
        System.out.println(produto4.getNome() +
                    " fatourou: R$" + produto4.calcularFaturamento());
        System.out.println(produto5.getNome() +
                    " fatourou: R$" + produto5.calcularFaturamento());

        gravaArquivoCSV(listaObj, "produtos");

        leArquivoCSV("produtos");

    }
}
