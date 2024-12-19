package messources;

import static org.junit.Assert.*;
import org.junit.Test;
public class CalculerImpotsTest {

    @Test (expected=IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionWhenNombreDePartsGreaterThanCinq() {
        CalculerImpots classe= new CalculerImpots();
        classe.calculerImpots(1500, 6);
    }

    @Test (expected=ArithmeticException.class)
    public void throwsArithmeticExceptionWhenNombreDePartsZero() {
        CalculerImpots classe= new CalculerImpots();
        classe.calculerImpots(1500, 0);
    }
    @Test
    public void shouldReturn10000ForRevenu50000AndNombreParts5() {
        CalculerImpots classe= new CalculerImpots();
        assertEquals("50000 / 5 donne 10.000", 10000, classe.calculerImpots (50000, 5));

    }

    @Test
    public void testCelibataireSansEnfant() {
        // Célibataire, sans enfant
        CalculerImpots classe= new CalculerImpots();
        assertEquals(1.0, classe.calculerNombreParts(0, "", 0), 0.01);
    }
    @Test
    public void testCelibataireDeuxEnfants() {
        // Célibataire, 2 enfants
        CalculerImpots classe= new CalculerImpots();
        assertEquals(2.0, classe.calculerNombreParts(0, "", 2), 0.01);
    }

    @Test
    public void testMarieSixEnfantsConjointSalarie() {
        // Marié, 6 enfants, conjoint salarié
        CalculerImpots classe= new CalculerImpots();
        assertEquals(4.0, classe.calculerNombreParts(1, "S", 6), 0.01);
    }
    @Test
    public void testMarieNeufEnfantsConjointNonSalarie() {
        // Marié, 9 enfants, conjoint non-salarié
        CalculerImpots classe= new CalculerImpots();
        assertEquals(5.0, classe.calculerNombreParts(1, "N", 9), 0.01);
    }




}

