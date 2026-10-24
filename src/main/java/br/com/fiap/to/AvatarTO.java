package br.com.fiap.to;

import jakarta.validation.constraints.*;

public class AvatarTO {
    //atributos
    private Integer idAvatar;
    @NotBlank @Size(max = 30)
    private String nome;
    @NotNull @Positive
    private Integer nivelAtual;
    @NotNull @PositiveOrZero
    private Double xpAtual;

    //construtores

    public AvatarTO() {}

    public AvatarTO(Integer idAvatar, String nome, Integer nivelAtual, Double xpAtual) {
        this.idAvatar = idAvatar;
        this.nome = nome;
        this.nivelAtual = nivelAtual;
        this.xpAtual = xpAtual;
    }

    //getter e setters

    public Integer getIdAvatar() {return idAvatar;}
    public void setIdAvatar(Integer idAvatar) {this.idAvatar = idAvatar;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Integer getNivelAtual() {return nivelAtual;}
    public void setNivelAtual(Integer nivelAtual) {this.nivelAtual = nivelAtual;}

    public Double getXpAtual() {return xpAtual;}
    public void setXpAtual(Double xpAtual) {
        this.xpAtual = xpAtual;
    }
}
