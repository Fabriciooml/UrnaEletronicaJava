package models;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Urna {
    private Map<Candidato, Integer> candidatoVoto;
    private Map<Integer, Candidato> numeroCandidato;
    private int totalVotos;

    public Urna() {
        this.candidatoVoto = new HashMap<Candidato, Integer>();
        this.numeroCandidato = new HashMap<Integer, Candidato>();
        this.totalVotos = 0;
    }

    public int getTotalVotos() {
        return this.totalVotos;
    }

    public Map<Candidato, Integer> getCandidatoVoto() {
        return candidatoVoto;
    }

    public void printNumeroCandidato() {
        for (Map.Entry<Integer,Candidato> pair : this.numeroCandidato.entrySet()) {
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }
    }

    public void printCandidatoVoto() {
        for (Map.Entry<Candidato,Integer> pair : this.candidatoVoto.entrySet()) {
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }
    }

    public void computaVoto(Eleitor eleitor, int voto){
        if(!eleitor.isVotou()) {
            Candidato candidato = this.numeroCandidato.get(voto);
            this.totalVotos += 1;
            candidato.adicionaVoto();
            this.candidatoVoto.merge(candidato, 1, Integer::sum);
        }
    }

    public void adicionaCandidato(Candidato candidato){
        this.numeroCandidato.put(candidato.getNumeroCandidato(), candidato);
    }

    public void ordenaCandidatoPorNumeroDeVotos() {
        this.candidatoVoto = sortByComparator(this.candidatoVoto, false);
    }

    private static Map<Candidato, Integer> sortByComparator(Map<Candidato, Integer> unsortMap, final boolean order)
    {

        List<Entry<Candidato, Integer>> list = new LinkedList<Entry<Candidato, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Entry<Candidato, Integer>>()
        {
            public int compare(Entry<Candidato, Integer> o1,
                               Entry<Candidato, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });
        Map<Candidato, Integer> sortedMap = new LinkedHashMap<Candidato, Integer>();
        for (Entry<Candidato, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
