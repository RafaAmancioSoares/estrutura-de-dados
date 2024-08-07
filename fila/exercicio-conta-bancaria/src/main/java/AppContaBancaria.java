import java.util.Scanner;

public class AppContaBancaria {

    /*
    rever 3 e 5
     */

    public static void main(String[] args) {

        PilhaObj<Operacao> operacaoPilha = new PilhaObj<>(10);
        FilaObj<Operacao> operacaoFila = new FilaObj<>(10);

        Integer contador = 0;
        Boolean menu = true;
        String conversao = "";

        ContaBancaria contaBancaria1 = new ContaBancaria(1, 1000.00);
        ContaBancaria contaBancaria2 = new ContaBancaria(2, 100.00);

        Scanner leitorNum = new Scanner(System.in);
        Scanner leitorTex = new Scanner(System.in);

        while (menu) {
            System.out.println("-".repeat(30));
            System.out.println("QUAL OPERAÇÃO DESEJA FAZER? \n" +
                            "1- Debitar valor  \n" +
                            "2- Depositar valor  \n" +
                            "3- Desfazer operação  \n" +
                            "4- Agendar operação  \n" +
                            "5- Executar operações agendadas  \n" +
                            "6- Sair"
            );
            Integer resposta = leitorNum.nextInt();
            System.out.println("-".repeat(30));

            switch (resposta) {
                case 1:
                    ContaBancaria contaUtilizada;

                    System.out.println("Deseja depositar em qual conta?");
                    Integer conta = leitorNum.nextInt();
                    System.out.println("Qual o valor a ser debitado?");
                    Double debito = leitorNum.nextDouble();

                    if (conta == 1) {
                        contaUtilizada = contaBancaria1;
                    } else if (conta == 2) {
                        contaUtilizada = contaBancaria2;
                    } else {
                        System.out.println("Conta Inválida");
                        break;
                    }

                    if (contaUtilizada.debitar(debito)) {
                        Operacao operacao = new Operacao(contaUtilizada, "debito", debito);
                        try {
                            operacaoPilha.push(operacao);
                            contador++;
                        } catch (IllegalStateException e) {
                            System.out.println(e);
                        }
                        System.out.println(contador);
                    }
                    break;
                    /*
                    Execute a operação, chamando o método do objeto
                    correspondente. Se o método debitar retornar true, crie um objeto Operacao,
                    contendo o objeto conta associado, ”debito” para tipo de operação e o valor da
                    operação. Empilhe esse objeto na pilha de operações e incremente o contador de
                    operações. No momento de empilhar, precisa do try/catch.
                     */

                case 2:
                    System.out.println("Deseja depositar em qual conta?");
                    conta = leitorNum.nextInt();
                    System.out.println("Que valor será depositado?");
                    Double deposito = leitorNum.nextDouble();

                    if (conta == 1) {
                        contaUtilizada = contaBancaria1;
                    } else if (conta == 2) {
                        contaUtilizada = contaBancaria2;
                    } else {
                        System.out.println("Conta Inválida");
                        break;
                    }
                    try {
                        contaUtilizada.depositar(deposito);
                        Operacao operacao = new Operacao(contaUtilizada, "deposito", deposito);
                        operacaoPilha.push(operacao);
                        contador++;
                        System.out.println(contador);
                    } catch (IllegalStateException e) {
                        System.out.println(e);
                    }
                    break;
                    /*
                    Depositar valor: peça para o usuário digitar o número da conta onde vai depositar,
                    e o valor a ser depositado. Execute a operação, chamando o método do objeto
                    correspondente. Crie um objeto Operacao, contendo o objeto conta associado,
                    ”deposito” para tipo de operação e o valor da operação. Empilhe esse objeto na
                    pilha de operações e incremente o contador de operações
                     */

                case 3:
                    System.out.println("Quantidade de operações que serão desfeitas:");
                    Integer desfazer = leitorNum.nextInt();

                    if (desfazer > contador) {
                        System.out.println("Quantidade Inválida");
                    } else {
                        while (contador >= desfazer){
                            operacaoPilha.pop();
                            contador--;
                        }
                    }
                    break;
                    /*
                    Desfazer operação: solicite que o usuário digite a quantidade de operações a
                    serem desfeitas. Se a quantidade for maior do que o contador de operações, exiba
                    a mensagem de que essa quantidade é inválida. Desempilhe uma operação por vez
                    da pilha de operações, desfazendo a operação. Desfaça a quantidade solicitada
                    pelo usuário e subtraia a quantidade desfeita do contador de operações.
                     */

                case 4:
                    System.out.println("Qual operação deseja fazer?" +
                                        "1- Debitar \n" +
                                        "2- Depositar \n");
                    Integer tipoOperacao = leitorNum.nextInt();
                    System.out.println("Em qual conta fará a operação?");
                    conta = leitorNum.nextInt();
                    System.out.println("Qual o valor da operação?");
                    Double valor = leitorNum.nextDouble();

                    if (tipoOperacao == 1) {
                        conversao = "debito";
                    } else if (tipoOperacao == 2) {
                        conversao = "deposito";
                    }

                    if (conta == 1) {
                        Operacao operacao = new Operacao(contaBancaria1, conversao, valor);
                        try {
                            operacaoFila.insert(operacao);
                        } catch (Error e) {
                            System.out.println(e);
                        }

                    } else if (conta == 2) {
                        Operacao operacao = new Operacao(contaBancaria2, conversao, valor);
                        try {
                            operacaoFila.insert(operacao);
                        } catch (Error e) {
                            System.out.println(e);
                        }
                    }

                    /*
                    Solicite que o usuário digite qual a operação desejada (debito ou credito), número
                    da conta e o valor. Crie um objeto Operacao, contendo o objeto conta associado,
                    tipo de operação e o valor da operação. Enfileire esse objeto (não se esqueça do
                    try/catch).
                     */

                case 5:
                    if (operacaoFila.isEmpty()) {
                        System.out.println("Nenhuma operação agendada");
                    }

                    while (!operacaoFila.isEmpty()) {
                        Operacao operacaoAFazer = operacaoFila.poll();

                        contaUtilizada = operacaoAFazer.getObjConta();

                        if (operacaoAFazer.getOperacao().equals("debito")) {
                            contaUtilizada.depositar(operacaoAFazer.getValor());
                        } else if (operacaoAFazer.getOperacao().equals("deposito")) {
                            contaUtilizada.debitar(operacaoAFazer.getValor());
                        } else {
                            System.out.println("Operação digitava invalida!");
                        }

                    }
                    break;
                    /*
                    Se a fila de operações agendadas estiver vazia, exiba uma mensagem de que não
                    há operações agendadas. Caso contrário, esvazie a fila, executando cada uma das
                    operações.
                     */

                case 6:
                    System.out.println("Obrigada por usar o nosso programa, até a próxima!");
                    menu = false;
                    break;

                default:
                    System.out.println("O valor digitado não está nas opções, por favor escolha um valor válido");
                    break;
            }
        }
    }
}
