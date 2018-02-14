import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PalindromoTest {

    public Frases frases = new Frases();


    @Test
    public void unStringVacioEsUnPalindromo() throws Exception {
        assertThat(frases.isPalindromo(""), is(true));

    }

    @Test
    public void unaSolaLetraEsPalindromo() throws Exception {
        assertThat(frases.isPalindromo("a"), is(true));
    }

    @Test
    public void abNoEsPalindromo() throws Exception {
        assertThat(frases.isPalindromo("ab"), is(false));
    }

    @Test
    public void readerNoEsPalindromo() throws Exception {
        assertThat(frases.isPalindromo("reader"), is(false));
    }

    @Test
    public void radarEsPalindromo() throws Exception {
        assertThat(frases.isPalindromo("radar"), is(true));
    }

    @Test
    public void unStringConEspaciosTambienPuedeSerPalindromo() throws Exception {
        assertThat(frases.isPalindromo("anita, lava la tina"), is(true));
    }

    @Test
    public void unStringConMayusculasTambienPuedeSerPalindromo() throws Exception {
        assertThat(frases.isPalindromo("¡Anita Lava La Tina!"), is(true));
    }
}
