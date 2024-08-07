public class ContaBancaria {

    private Integer numero;
    private Double saldo;

    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Boolean debitar(Double valor) {
        if (getSaldo() > valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saldo: R$" + getSaldo());
            return true;
        }
        System.out.println("Saldo insuficiente");
        return false;

    }

    public void depositar(Double valor) {
        setSaldo(getSaldo() + valor);
        System.out.println("Saldo: R$" + getSaldo());
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
