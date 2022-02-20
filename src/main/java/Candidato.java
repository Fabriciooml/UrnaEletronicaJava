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

    @Override
    public String toString() {
        return "Candidato{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", numeroCandidato=" + numeroCandidato +
                ", partido='" + partido + '\'' +
                ", numeroVotos=" + numeroVotos +
                '}';
    }
}
