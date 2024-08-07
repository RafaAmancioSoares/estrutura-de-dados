public class Produto <T>{

    private Integer codProduto;
    private String nome;
    private Double preco;
    private String avaliacao;
    private Integer qntVendida = 0;

    public Produto(Integer codProduto, String nome, Double preco, String avaliacao, Integer qntVendida) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.qntVendida = qntVendida;
    }

    public Integer getCodProduto() {
        return codProduto;
    }
    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Integer getQntVendida() {
        return qntVendida;
    }
    public void setQntVendida(Integer qntVendida) {
        this.qntVendida = qntVendida;
    }


    public void comprar(Integer qtdComprada) {
        setQntVendida(qtdComprada+=getQntVendida());
    }

    public double calcularFaturamento() {
        Integer qtdVendida = getQntVendida();
        double preco = getPreco();

        return qtdVendida*preco;
    }

    @Override
    public String toString() {
        return String.format("%06d %-14.14S %7.2f %-5s %5d",
                codProduto,
                nome,
                preco,
                avaliacao,
                qntVendida);
    }
}
