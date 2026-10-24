package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BadgeTO {

    //atributos
    private Integer idBadge;
    @NotBlank @Size (max = 40)
    private String nome;
    @NotBlank @Pattern(regexp = "normal|lendario")
    private String tipo;
    @NotBlank @Size(max = 200)
    private String descricao;

    //construtores
    public BadgeTO() {
    }

    public BadgeTO(Integer idBadge, String nome, String tipo, String descricao) {
        this.idBadge = idBadge;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    //getters e setters
    public Integer getIdBadge() {return idBadge;}
    public void setIdBadge(Integer idBadge) {this.idBadge = idBadge;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
}
