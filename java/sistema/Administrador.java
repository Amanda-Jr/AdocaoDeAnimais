package java.sistema;

import java.util.Date;

public class Administrador{
    private int idAdministrador;
    private String nome;
    private String sobrenome;
    private Date dataNasc;
    private String email;
    private String telefone;
    private String senha;

    public void cadastrarAdministrador(){

    }

    public void atualizarAdministrador(){
        
    }

    public void removerAdministrador(){
        
    }

    public void mostrarAdministrador(){
        
    }

    public void historicoAcesso(){
        
    }



    public int getIdAdministrador() {
        return idAdministrador;
    }
    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    

}