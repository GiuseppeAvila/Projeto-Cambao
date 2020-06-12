package br.edu.insper.al.carolineclc.myapplication;

public class Entrega {
    private String contato;
    private String nome;
    private String endereco;
    private String saida;
    private String chegada;
    private String peso;
    private String preco;
    private String produto;

    public Entrega(String contato, String nome, String endereco, String saida, String chegada, String peso, String preco, String produto) {
        this.contato = contato;
        this.nome = nome;
        this.endereco = endereco;
        this.saida = saida;
        this.chegada = chegada;
        this.peso = peso;
        this.preco = preco;
        this.produto = produto;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getChegada() {
        return chegada;
    }

    public void setChegada(String chegada) {
        this.chegada = chegada;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
