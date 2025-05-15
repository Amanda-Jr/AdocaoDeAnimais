package java.sistema;

import java.util.ArrayList;

public class SistemaAdocao {
    private Administrador administrador;
    private ArrayList<Adotante> adotantes;
    //private ArrayList<Adocao> listaAdocao;
    private ArrayList<Animal> listaAnimais;
    private ArrayList<Doacao> listaDoacoes;
    private ArrayList<Parceiro> listaParceiros;

    public void realizarAdocao() {}

    public void realizarDoacao() {
        Doacao preDoacao = new Doacao();
        Doacao posDoacao = preDoacao.fazerDoacao();
        if(posDoacao != null) {
            listaDoacoes.add(posDoacao);
        }
    }

    public void loginAdotante() {}

    public void listarParceiros() {}

    public void manterPet() {}

    public void exibeAnimais() {}

    public void acessaAnimal() {}
}
