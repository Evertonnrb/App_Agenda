package br.com.nrbsistemas.agendacontatos.entidades;

import java.util.Date;

/**
 * Created by Everton on 22/01/2017.
 */

public class ContatoMapping {
    private long id;
    private String nome;
    private String telefone;
    private String tipoTelefone;
    private String email;
    private String tipoEmail;
    private String endereco;
    private String tipoEndereco;
    private Date datasEspeciais;
    private String tipoDataEspeciais;
    private String grupos;

    public ContatoMapping(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(String tipoEmail) {
        this.tipoEmail = tipoEmail;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Date getDatasEspeciais() {
        return datasEspeciais;
    }

    public void setDatasEspeciais(Date datasEspeciais) {
        this.datasEspeciais = datasEspeciais;
    }

    public String getTipoDataEspeciais() {
        return tipoDataEspeciais;
    }

    public void setTipoDataEspeciais(String tipoDataEspeciais) {
        this.tipoDataEspeciais = tipoDataEspeciais;
    }

    public String getGrupos() {
        return grupos;
    }

    public void setGrupos(String grupos) {
        this.grupos = grupos;
    }

    public String toString(){
        return nome+" "+" "+telefone;
    }
}
