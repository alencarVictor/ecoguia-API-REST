package br.com.fiap.to;

import jakarta.validation.constraints.*;

public class UsuarioTO {

    //atributos
    private Integer idUsuario;
    @NotBlank @Size(max = 15)
    private String nome;
    @NotBlank @Email @Size(max = 100)
    private String email;
    @NotBlank @Size(max = 50)
    private String senha;
    @Size(max = 20)
    private String cidade;
    @NotNull
    private Integer idAvatar;
    @NotNull @PositiveOrZero
    private Integer ofensivaAtual;


    //construtores
    public UsuarioTO() {
    }

    public UsuarioTO(Integer idUsuario, String nome, String email, String senha, String cidade, Integer idAvatar, Integer ofensivaAtual) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.idAvatar = idAvatar;
        this.ofensivaAtual = ofensivaAtual;
    }


    //getters e setters
    public Integer getIdUsuario() {return idUsuario;}
    public void setIdUsuario(Integer idUsuario) {this.idUsuario = idUsuario;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

    public String getCidade() {return cidade;}
    public void setCidade(String cidade) {this.cidade = cidade;}

    public Integer getIdAvatar() {return idAvatar;}
    public void setIdAvatar(Integer idAvatar) {this.idAvatar = idAvatar;}

    public Integer getOfensivaAtual() {return ofensivaAtual;}
    public void setOfensivaAtual(Integer ofensivaAtual) {this.ofensivaAtual = ofensivaAtual;}
}
