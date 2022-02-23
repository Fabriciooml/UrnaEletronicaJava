package models;

public class Eleitor extends Pessoa {
    private String tituloEleitor;
    private boolean Votou;

    public Eleitor(String nome, String cpf, String tituloEleitor) {
        super(nome, cpf);
        this.tituloEleitor = tituloEleitor;
        this.Votou = false;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }


    public void setVotou(boolean Votou) {
        this.Votou = Votou;
    }

    public boolean isVotou() {
        return Votou;
    }
}
