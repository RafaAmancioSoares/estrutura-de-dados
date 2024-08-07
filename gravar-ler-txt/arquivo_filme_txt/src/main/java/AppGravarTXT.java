import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AppGravarTXT {

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo: " + erro);
        }
    }

    public static void gravaArquivoTxt(List<Filme> lista, String nomeArq) {
        int contaRegCorpo = 0;

        String header = "00FILMES";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        gravaRegistro(header, nomeArq);

        String corpo;
        for (Filme filme : lista) {
            corpo = "02";
            corpo += String.format("%3.3s", filme.getIdFilme());
            corpo += String.format("%-40.40s", filme.getNome());
            corpo += String.format("%5.5s", filme.getNota());
            corpo += String.format("%-15.15s", filme.getGenero());
            corpo += String.format("%2.2s", filme.getIdade());
            contaRegCorpo++;
            gravaRegistro(corpo, nomeArq);
        }

        String trailer = "01";
        trailer += String.format("%010d", contaRegCorpo);
        gravaRegistro(trailer, nomeArq);
    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, genero;
        Double nota;
        Integer idFilme, idade;
        int contaRegCorpoLido = 0;
        int qtdRegCorpoGravado;

        List<Filme> listaLida = new ArrayList<>();

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }

        try {
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0,2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2,7));
                    System.out.println("Data e hora da gravação: " + registro.substring(8,26));
                    System.out.println("Versão do documento: " + registro.substring(27,28));
                }
                else if (tipoRegistro.equals("01")) {
                    System.out.println("É um registro de trailer");
                    qtdRegCorpoGravado = Integer.parseInt(registro.substring(2,12));
                    if (contaRegCorpoLido == qtdRegCorpoGravado) {
                        System.out.println("Quantidade de registros lidos é compatível " +
                                "com a quantidade de registros gravados");
                    }
                    else {
                        System.out.println("Quantidade de registros lidos não é compatível " +
                                "com a quantidade de registros gravados");
                    }
                }
                else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de corpo");
                    idFilme = Integer.valueOf(registro.substring(2,4));
                    nome = registro.substring(5,44).trim();
                    nota = Double.valueOf(registro.substring(45,49).replace(',','.'));
                    genero = registro.substring(50,64).trim();
                    idade = Integer.valueOf(registro.substring(65,66));
                    contaRegCorpoLido++;

                    Filme filme = new Filme(idFilme, nome, nota, genero, idade);

                    listaLida.add(filme);
                }
                else {
                    System.out.println("Tipo de registro inválido!");
                }

                registro = entrada.readLine();
            }

            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo: " + erro);
        }

        System.out.println("\nConteúdo da lista lida:");
        for (Filme filme : listaLida) {
            System.out.println(filme);
        }
    }

    public static void main(String[] args) {
        List<Filme> lista = new ArrayList();

        lista.add(new Filme(1, "Orgulho e preconceito",
                8.9, "Romance", 0));
        lista.add(new Filme(2, "Crepúsculo",
                8.0, "Romance", 12));
        lista.add(new Filme(3, "Guerra mundial Z",
                8.5, "Ação", 14));


        for (Filme filme : lista) {
            System.out.println(filme);
        }

        //gravaArquivoTxt(lista, "filmes.txt");
        leArquivoTxt("filmes.txt");
    }
}
