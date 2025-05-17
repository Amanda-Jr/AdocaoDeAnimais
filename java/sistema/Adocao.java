package java.sistema;

import java.time.LocalDate;

public class Adocao {

    private Long idAdocao;
    private String nomeAdotante;
    private String nomeAnimal;
    private LocalDate dataAdocao;
    private Status status; 

    public Adocao(Long idAdocao, String nomeAdotante, String nomeAnimal, Status status) {
        this.idAdocao = idAdocao;
        this.nomeAdotante = nomeAdotante;
        this.nomeAnimal = nomeAnimal;
        this.status = status;
        this.dataAdocao = LocalDate.now();
    }

    public boolean realizarAdocao() {
        if (status.isDisponivel()) {
            status.setDisponivel(false);
            System.out.println("Adoção realizada com sucesso para: " + nomeAdotante);
            return true;
        } else {
            System.out.println("O animal '" + nomeAnimal + "' não está disponível para adoção.");
            return false;
        }
    }


    public String getStatusAtual() {
        return status.isDisponivel() ? "Disponível" : "Indisponível";
    }

    @Override
    public String toString() {
        return "Adoção {" +
                "Adotante='" + nomeAdotante + '\'' +
                ", Animal='" + nomeAnimal + '\'' +
                ", Data=" + dataAdocao +
                ", Status=" + getStatusAtual() +
                '}';
    }
}