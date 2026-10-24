package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ConquistaTO {

    //atributos
    private Integer idConquista;
    @NotNull
    private Integer idUsuario;
    @NotNull
    private Integer idBadge;
    @PastOrPresent
    private LocalDate dataConquista;


    //construtores
    public ConquistaTO() {
    }
    public ConquistaTO(Integer idConquista, Integer idUsuario, Integer idBadge, LocalDate dataConquista) {
        this.idConquista = idConquista;
        this.idUsuario = idUsuario;
        this.idBadge = idBadge;
        this.dataConquista = dataConquista;
    }

    //getters e setters
    public Integer getIdConquista() {return idConquista;}
    public void setIdConquista(Integer idConquista) {this.idConquista = idConquista;}

    public Integer getIdUsuario() {return idUsuario;}
    public void setIdUsuario(Integer idUsuario) {this.idUsuario = idUsuario;}

    public Integer getIdBadge() {return idBadge;}
    public void setIdBadge(Integer idBadge) {this.idBadge = idBadge;}

    public LocalDate getDataConquista() {return dataConquista;}
    public void setDataConquista(LocalDate dataConquista) {this.dataConquista = dataConquista;}
}
