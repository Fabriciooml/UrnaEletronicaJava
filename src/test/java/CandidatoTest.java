import models.Candidato;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandidatoTest {

    @Test
    public void cpfEhValido() {
            Candidato candidato = new Candidato("Ford Prefect", "89082448670", 42, "GMG");
            assertEquals(true, candidato.isCpfValido());
    }

    @Test
    public void cpfTem10digitos() {
        Candidato candidato = new Candidato("Ford Prefect", "8908244867", 42, "GMG");
        assertEquals(false, candidato.isCpfValido());
    }

    @Test
    public void cpfDigito10Invalido() {
        Candidato candidato = new Candidato("Ford Prefect", "89082448600", 42, "GMG");
        assertEquals(false, candidato.isCpfValido());
    }

    @Test
    public void cpfDigito11Invalido() {
        Candidato candidato = new Candidato("Ford Prefect", "89082448671", 42, "GMG");
        assertEquals(false, candidato.isCpfValido());
    }

    @Test
    public void cpfDigitos10e11Invalidos() {
        Candidato candidato = new Candidato("Ford Prefect", "89082448699", 42, "GMG");
        assertEquals(false, candidato.isCpfValido());
    }

    @Test
    public void cpfTotalmenteInvalido() {
        Candidato candidato = new Candidato("Ford Prefect", "00000000000", 42, "GMG");
        assertEquals(false, candidato.isCpfValido());
    }

}
