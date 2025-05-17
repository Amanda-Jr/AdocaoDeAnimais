package java.sistema;

import java.util.Date;

public class Adotante {
    private int idAdotante;
    private String nome;
    private String sobrenome;
    private Date dataNasc;
    private String email;
    private String telefone;
    private String senha;
    private double renda;
    private int pessoaCasa; //??
    private String animaisPossui;
    private String cpf;
    private String rg;
    private Endereco endereco;

    public Adotante(){
       
    }
    
    public void cadastrarAdotante(){

    }

    public void atualizarAdotante(){
        
    }

    public void removerAdotante(){
        
    }

    public void mostrarAdotante(){
        
    }

    public int getIdAdotante() {
        return idAdotante;
    }

    public void setIdAdotante(int idAdotante) {
        this.idAdotante = idAdotante;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public void setPessoaCasa(int pessoaCasa) {
        this.pessoaCasa = pessoaCasa;
    }

    public void setAnimaisPossui(String animaisPossui) {
        this.animaisPossui = animaisPossui;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    

    

}
