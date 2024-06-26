package br.pucrs.lucaslanger.exemplo;
public class Aplicativo {

    private Long id;
    private String nome;
    private double custo;

    // Getters e setters
    public Long getId() {
        return id; 
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getCusto() {
        return custo;
    }
    public void setCusto(double custo) {
        this.custo = custo;
    }
}