package java.sistema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Doacao {
    private int idDoacao; //deve gerar automaticamente
    private double valor;
    private LocalDate dataNasc;
    private String nomeDoador;
    private Scanner sc;
    private DateTimeFormatter formato;

    public Doacao() {
        this.sc = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public int getIdDoacao() {
        return idDoacao;
    }

    public Doacao fazerDoacao() {
        Doacao doacao = new Doacao();

        System.out.println("Nome do doador: ");
        String nomeDoador = sc.nextLine();
        System.out.println("Data de Nascimento (dd/MM/ yyyy): ");
        String dataStr = sc.nextLine();
        LocalDate dataNasc = LocalDate.parse(dataStr, formato);
        System.out.println("Valor da doação: R$ ");
        double valor = sc.nextDouble();

        if(LocalDate.now().minusYears(18).isAfter(dataNasc)){
            doacao.valor = valor;
            doacao.nomeDoador = nomeDoador;
            doacao.dataNasc = dataNasc;
            System.out.println("Doação feita com sucesso!");
            return doacao;
        } else {
            System.out.println("Doação não autorizada. O doador é menor de idade!");
        }
        return null;
    }

    public String mostrarDoacao() {
        return "Doador: " + nomeDoador + "\nValor doado: R$ " + valor;
    }
}
