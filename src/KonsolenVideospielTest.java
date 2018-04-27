import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 */
public class KonsolenVideospielTest
{
    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "Videospiel";
    private static final String SYSTEM = "System";
    private KonsolenVideospiel _videoSpiel1;
    private KonsolenVideospiel _videoSpiel2;


    @Before
    public void setUp()
    {
        _videoSpiel1 = getMedium();
        _videoSpiel2 = getMedium();
    }

    @Test
    public void testeKonstruktoren()
    {
        assertEquals(TITEL, _videoSpiel1.getTitel());
        assertEquals(KOMMENTAR, _videoSpiel1.getKommentar());
        assertEquals(SYSTEM, _videoSpiel1.getSystem());
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        String videospielBezeichnung = BEZEICHNUNG;
        assertEquals(videospielBezeichnung, _videoSpiel1.getMedienBezeichnung());
    }
    
    @Test
    /*
     * Von ein und dem selben Videospiel kann es mehrere Exemplare geben, die von
     * unterschiedlichen Personen ausgeliehen werden können.
     */
    public void testEquals()
    {
        assertFalse("Mehrere Exemplare des gleichen Videospiels sollten ungleich sein, equals gibt hier aber true zurück!",
        		_videoSpiel1.equals(_videoSpiel2));
        assertTrue("Ein Videospiels-Exemplar sollte sich selbst gleichen, equals gibt aber false zurück!",
        		_videoSpiel1.equals(_videoSpiel1));
    }

    protected KonsolenVideospiel getMedium()
    {
        return new KonsolenVideospiel(TITEL, KOMMENTAR, SYSTEM);
    }

    @Test
    public final void testSetKommentar()
    {
    	KonsolenVideospiel medium = getMedium();
        medium.setKommentar("Kommentar2");
        assertEquals(medium.getKommentar(), "Kommentar2");
    }

    @Test
    public final void testSetTitel()
    {
    	KonsolenVideospiel medium = getMedium();
        medium.setTitel("Titel2");
        assertEquals(medium.getTitel(), "Titel2");
    }
    
    @Test
    public void testeMietgebuehr()
    {
    	Medium medium = getMedium();
    	assertEquals(new Geldbetrag(200), medium.berechneMietgebuehr(1));
    	assertEquals(new Geldbetrag(900), medium.berechneMietgebuehr(3));
    	assertEquals(new Geldbetrag(900), medium.berechneMietgebuehr(5));
    	assertEquals(new Geldbetrag(1600), medium.berechneMietgebuehr(6));
    }

}
