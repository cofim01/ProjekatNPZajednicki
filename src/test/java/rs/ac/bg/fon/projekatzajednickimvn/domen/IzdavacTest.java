
package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IzdavacTest {
    
    private Izdavac i;
    
    public IzdavacTest() {
        i=new Izdavac();
        i.setIzdavacId(1);
        i.setNaziv("Izdavac 1");
    }
    
    @Test
    public void testIzdavacParametrizovani() {
        Izdavac izdavac = new Izdavac(1, "Laguna");
        assertEquals(1, izdavac.getIzdavacId());
        assertEquals("Laguna", izdavac.getNaziv());
    }
    
    
    @Test
    public void testSetIzdavacId() {
        i.setIzdavacId(1);
         assertEquals(1, i.getIzdavacId());
    }

    
    @Test
    public void testSetNaziv() {
        i.setNaziv("Laguna");
        assertEquals("Laguna", i.getNaziv());
    }

    
    @Test
    public void testToString() {
        String s=i.toString();
        assertTrue(s.contains("Izdavac 1"));
    }

    
    @Test
    public void testGetNazivTabele() {
        assertEquals("izdavac", i.getNazivTabele());
    }


    @Test
    public void testGetAlijas() {
        assertEquals("i", i.getAlijas());
    }


    @Test
    public void testGetKoloneZaDodavanje() {
        assertEquals("", i.getKoloneZaDodavanje());
    }


    @Test
    public void testJoin() {
        assertEquals("", i.join());
    }


    @Test
    public void testGetKriterijum() {
        assertEquals("", i.getKriterijum());
    }


    @Test
    public void testVrednostiZaDodavanje() {
        assertEquals("", i.vrednostiZaDodavanje());
    }


    @Test
    public void testVrednostiZaAzuriranje() {
        assertEquals("", i.vrednostiZaAzuriranje());
    }


    @Test
    public void testGetLista() throws Exception {
        ResultSet rs = mock(ResultSet.class);


        when(rs.next()).thenReturn(true, false);
        when(rs.getInt("IzdavacId")).thenReturn(1);
        when(rs.getString("Naziv")).thenReturn("Izdavac 1");

        ArrayList<OpstiDomenskiObjekat> result = i.getLista(rs);

        assertEquals(1, result.size());

        Izdavac i = (Izdavac) result.get(0);
        assertEquals(1, i.getIzdavacId());
        assertEquals("Izdavac 1", i.getNaziv());
    }


    @Test
    public void testGetVrednostPrimarniKljuc() {
        assertEquals("", i.getVrednostPrimarniKljuc());
    }
    
}
