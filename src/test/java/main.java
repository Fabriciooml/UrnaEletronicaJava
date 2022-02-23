public class main {
    public static void main(String[] args) {
        Eleicao eleicao = new Eleicao();
        Candidato candidato1 = eleicao.adicionaCandidato("Ford Prefect", "89082448670", 42, "GMG");
        eleicao.adicionaCandidato("Sherlock Holmes", "2", 221, "SH");
        eleicao.adicionaCandidato("David Tennant", "3", 10, "DW");

        Eleitor eleitor1 = new Eleitor("Marvin", "4", "4");
        Eleitor eleitor2 = new Eleitor("Rose", "5", "5");
        Eleitor eleitor3 = new Eleitor("Mycroft", "6", "6");
        Eleitor eleitor4 = new Eleitor("John", "7", "7");
        Eleitor eleitor5 = new Eleitor("Jack Harkness", "8", "8");
        Eleitor eleitor6 = new Eleitor("Martha", "9", "9");

        eleicao.votar(eleitor1, 42);
        eleicao.votar(eleitor2, 10);
        eleicao.votar(eleitor3, 221);
        eleicao.votar(eleitor4, 221);
        eleicao.votar(eleitor5, 10);
        eleicao.votar(eleitor6, 10);

        eleicao.contabilizaVotos();

        System.out.println(eleicao);
        System.out.println(candidato1.isCpfValido());
    }
}