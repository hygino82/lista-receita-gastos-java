package entities;

public class Product {

    private String nome;
    private String tipoUnidade;
    private String tipoComprado;
    private Double quantidadeComprada;// peso, volume também só pra abreviar
    private Double valorComprado;
    private String tipoUsado;
    private Double quantidadeUsada;

    public Product() {

    }

    public Product(String nome, String tipoUnidade, String tipoComprado, Double quantidadeComprada,
            Double valorComprado, String tipoUsado, Double quantidadeUsada) {
        this.nome = nome;
        this.tipoUnidade = tipoUnidade;
        this.tipoComprado = tipoComprado;
        this.quantidadeComprada = quantidadeComprada;
        this.valorComprado = valorComprado;
        this.tipoUsado = tipoUsado;
        this.quantidadeUsada = quantidadeUsada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public String getTipoComprado() {
        return tipoComprado;
    }

    public void setTipoComprado(String tipoComprado) {
        this.tipoComprado = tipoComprado;
    }

    public Double getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(Double quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public Double getValorComprado() {
        return valorComprado;
    }

    public void setValorComprado(Double valorComprado) {
        this.valorComprado = valorComprado;
    }

    public String getTipoUsado() {
        return tipoUsado;
    }

    public void setTipoUsado(String tipoUsado) {
        this.tipoUsado = tipoUsado;
    }

    public Double getQuantidadeUsada() {
        return quantidadeUsada;
    }

    public void setQuantidadeUsada(Double quantidadeUsada) {
        this.quantidadeUsada = quantidadeUsada;
    }

    public Double custoPorUnidade() {
        Double custoUnitario;
        if (tipoComprado == tipoUsado) {
            custoUnitario = valorComprado / quantidadeComprada;

        } else if ((tipoComprado == "Kg" && tipoUsado == "g") || (tipoComprado == "L" && tipoUsado == "mL")) {
            custoUnitario = valorComprado / (quantidadeComprada * 1000.0);

        } else {
            custoUnitario = (valorComprado * 1000.0) / quantidadeComprada;
        }
        return custoUnitario;
    }

    public Double geraCusto() {
        return custoPorUnidade() * quantidadeUsada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //Double custoUnidade = valorComprado / quantidadeComprada;
        sb.append(nome + "\n");
        sb.append("Embalagem de " + String.format("%.2f", quantidadeComprada) + tipoComprado + " por R$"
                + String.format("%.2f", valorComprado) + "\n");
       /* sb.append("O custo por " + tipoComprado + " é R$" + String.format("%.2f", custoUnidade) + "\n");
        if (tipoComprado != tipoUsado) {
            sb.append("O custo por " + tipoUsado + " é R$" + String.format("%.5f", custoPorUnidade()) + "\n");
        }*/
        sb.append("Foi utilizado " + String.format("%.2f", quantidadeUsada) + tipoUsado + " a um custo de R$"
                + String.format("%.2f", geraCusto()) + "\n");
        return sb.toString();
    }

}
