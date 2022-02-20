import java.util.Map;

public class Eleicao {
    private Candidato vencedor;
    private int totalVotos;
    private Urna urna;

    public Eleicao() {
        this.vencedor = null;
        this.urna = new Urna();
        this.totalVotos = 0;
    }

    public Candidato getVencedor() {
        return vencedor;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public Urna getUrna() {
        return urna;
    }

    public void votar(Eleitor eleitor, int voto) {
        urna.computaVoto(eleitor, voto);
        eleitor.setVotou(true);
        this.totalVotos += 1;
    }

    public Candidato adicionaCandidato(String nome, String cpf, int numeroCandidato, String partido) {
        Candidato candidato = new Candidato(nome, cpf, numeroCandidato, partido);
        this.urna.adicionaCandidato(candidato);
        return candidato;
    }

    public void contabilizaVotos() {
        this.urna.ordenaCandidatoPorNumeroDeVotos();
        Map<Candidato, Integer> candidatoVoto = urna.getCandidatoVoto();
        Map.Entry<Candidato, Integer> entry = candidatoVoto.entrySet().iterator().next();
        this.vencedor = entry.getKey();
    }

    @Override
    public String toString() {
        float porcentagemVotos = (float) this.vencedor.getNumeroVotos()/this.totalVotos;
        return "O número total de votos foi:\n" +
                this.totalVotos + "\n" +
                "Com " + porcentagemVotos +"% de votos, o vencedor foi o candidato " +
                this.vencedor.getNome() + " do partido " + this.vencedor.getPartido();
    }
}
