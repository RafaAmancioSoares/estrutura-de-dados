public class Operacao {

    private ContaBancaria objConta;
    private String operacao;
    private Double valor;

    public Operacao(ContaBancaria objConta, String operacao, Double valor) {
        this.objConta = objConta;
        this.operacao = operacao;
        this.valor = valor;
    }

    public ContaBancaria getObjConta() {
        return objConta;
    }
    public void setObjConta(ContaBancaria objConta) {
        this.objConta = objConta;
    }
    public String getOperacao() {
        return operacao;
    }
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "objConta=" + objConta +
                ", operacao='" + operacao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
