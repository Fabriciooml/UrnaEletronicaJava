package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Candidato extends Pessoa{
    private int numeroCandidato;
    private String partido;
    private int numeroVotos;

    public Candidato(String nome, String cpf, int numeroCandidato, String partido) {
        super(nome, cpf);
        this.numeroCandidato = numeroCandidato;
        this.partido = partido;
        this.numeroVotos = 0;
    }

    public int getNumeroCandidato() {
        return numeroCandidato;
    }

    public String getPartido() {
        return partido;
    }

    public int getNumeroVotos() {
        return numeroVotos;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void adicionaVoto() {
        this.numeroVotos += 1;
    }

    public boolean isCpfValido() {
        Pattern pattern = Pattern.compile("^(.)\\1{10}");
        Matcher matcher = pattern.matcher(cpf);
        if (matcher.find() || (cpf.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        sm = 0;
        peso = 10;
        for (i=0; i<9; i++) {
            num = (int)(cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else dig10 = (char)(r + 48);

        sm = 0;
        peso = 11;
        for(i=0; i<10; i++) {
            num = (int)(cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig11 = '0';
        else dig11 = (char)(r + 48);

        if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
            return(true);
        else return(false);
    }

    @Override
    public String toString() {
        return "models.Candidato{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", numeroCandidato=" + numeroCandidato +
                ", partido='" + partido + '\'' +
                ", numeroVotos=" + numeroVotos +
                '}';
    }

}
