public class Banco {

  // Atributos
  PilhaObj<Operacao> pilhaOperacao = new PilhaObj(10);
  FilaObj<Operacao> filaOperacao = new FilaObj(10);
  // Contador de operações empilhadas
  Integer contadorOperacao = 0;

  // Métodos

  /* Método debitar - recebe o valor a ser debitado e o objeto conta bancária
     Se o débito ocorreu com sucesso, cria um objeto Operacao com os valores adequados
     e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
   */
  public void debitar(Double valor, ContaBancaria conta) {
    if (conta.debitar(valor)) {
      Operacao operacao = new Operacao(conta, "Débito", valor);
      pilhaOperacao.push(operacao);
      contadorOperacao++;
    }
  }

  /* Método depositar - recebe o valor a ser debitado e o objeto conta bancária
     Executa o depósito, cria um objeto Operacao com os valores adequados
     e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
   */
  public void depositar(Double valor, ContaBancaria conta) {
    conta.depositar(valor);
    Operacao operacao = new Operacao(conta, "Depósito", valor);
    pilhaOperacao.push(operacao);
    contadorOperacao++;
  }

  /* Método desfazerOperacao - recebe a quantidade de operações a serem desfeitas
     Se essa quantidade for inválida, lança IllegalArgumentException
     Senão, "desfaz" a quantidade de operações passadas como argumento
     e atualiza o contadorOperacao
   */
  public void desfazerOperacao(Integer qtdOperacaoDesfeita) {
    if (qtdOperacaoDesfeita > contadorOperacao || qtdOperacaoDesfeita <= 0 || qtdOperacaoDesfeita == null) {
      throw new IllegalArgumentException("Quantidade inválida");
    }
    for (int i = 0; i < qtdOperacaoDesfeita; i++) {
      if (pilhaOperacao.peek().getTipoOperacao().equalsIgnoreCase("Débito")) {
        pilhaOperacao.peek().getContaBancaria().depositar(pilhaOperacao.peek().getValor());
        pilhaOperacao.pop();
        contadorOperacao--;
      } else if (pilhaOperacao.peek().getTipoOperacao().equalsIgnoreCase("Depósito")) {
        pilhaOperacao.peek().getContaBancaria().debitar(pilhaOperacao.peek().getValor());
        pilhaOperacao.pop();
        contadorOperacao--;
      }
    }
  }


  /* Método agendarOperacao - recebe o tipo da operaçõa, o valor e o objeto conta bancária
     Se um dos argumentos for inválido, lança IllegalArgumentException.
     Senão, cria um objeto Operacao e insere esse objeto na fila.
  */
  public void agendarOperacao(String tipoOperacao, Double valor, ContaBancaria conta) {
    if(tipoOperacao.equalsIgnoreCase("Débito") ||
            tipoOperacao.equalsIgnoreCase("Depósito") &&
                    valor >= 0.0 && conta != null){
      Operacao operacao = new Operacao(conta, tipoOperacao, valor);
      filaOperacao.insert(operacao);
    } else {
      throw new IllegalArgumentException("Operação Inválida");
    }

  }

  /* Método executarOperacoesAgendadas
     Se não houver operações na fila, exibe mensagem de que não há operações agendadas.
     Senão, esvazia a fila, executando cada uma das operações agendadas.
  */
  public void executarOperacoesAgendadas() {
    if (filaOperacao.isEmpty()) {
      System.out.println("Não há operações agendadas");
    }
    while (!filaOperacao.isEmpty()) {
      Operacao operacaoAFazer = filaOperacao.poll();

      ContaBancaria contaUtilizada = operacaoAFazer.getContaBancaria();

      if (operacaoAFazer.getTipoOperacao().equalsIgnoreCase("Débito")) {
        contaUtilizada.depositar(operacaoAFazer.getValor());
        pilhaOperacao.pop();
        contadorOperacao--;
      } else if (operacaoAFazer.getTipoOperacao().equalsIgnoreCase("Depósito")) {
        contaUtilizada.debitar(operacaoAFazer.getValor());
        pilhaOperacao.pop();
        contadorOperacao--;
      } else {
        System.out.println("Operação inválida!");
      }
    }
  }

  // Gettens
  public PilhaObj<Operacao> getPilhaOperacao() {
    return pilhaOperacao;
  }

  public FilaObj<Operacao> getFilaOperacao() {
    return filaOperacao;
  }

  public Integer getContadorOperacao() {
    return contadorOperacao;
  }
}
