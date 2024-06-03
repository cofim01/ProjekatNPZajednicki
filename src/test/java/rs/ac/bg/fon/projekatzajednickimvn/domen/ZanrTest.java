
package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ZanrTest {
    
    private Zanr z;
    
    public ZanrTest() {
        z=new Zanr();
    }
    
    @Test
    public void testZanrParm() {
        Zanr zanr = new Zanr(1, "Triler");
        assertEquals(1, zanr.getZanrId());
        assertEquals("Triler", zanr.getNaziv());
    }
    


    @Test
    public void testSetZanrId() {
        z.setZanrId(1);
        assertEquals(1, z.getZanrId());
    }


    @Test
    public void testSetNaziv() {
        z.setNaziv("Komedija");
        assertEquals("Komedija", z.getNaziv());
    }
    
    @Test
    public void testSetNazivPrazanString() {
        Exception e=assertThrows(java.lang.IllegalArgumentException.class, ()->z.setNaziv(""));
        assertEquals(e.getMessage(), "Naziv zanra ne sme biti prazan string");
    }


    @Test
    public void testToString() {
        z.setNaziv("Drama");
        assertEquals("Drama", z.toString());
    }


    @Test
    public void testGetNazivTabele() {
        assertEquals("zanr", z.getNazivTabele());
    }

    @Test
    public void testGetAlijas() {
        assertEquals("z", z.getAlijas());
    }


    @Test
    public void testGetKoloneZaDodavanje() {
        assertEquals("(Naziv)", z.getKoloneZaDodavanje());
    }


    @Test
    public void testJoin() {
        assertEquals("", z.join());
    }

    @Test
    public void testGetKriterijum() {
        assertEquals("", z.getKriterijum());
    }


    @Test
    public void testVrednostiZaDodavanje() {
        assertEquals("", z.vrednostiZaDodavanje());
    }


    @Test
    public void testVrednostiZaAzuriranje() {
        assertEquals("", z.vrednostiZaAzuriranje());
    }


    @Test
    public void testGetLista() throws Exception {
        ResultSet rs = mock(ResultSet.class);
        when(rs.next()).thenReturn(true, false);
        when(rs.getInt("ZanrId")).thenReturn(15);
        when(rs.getString("Naziv")).thenReturn("Komedija");
        
        ArrayList<OpstiDomenskiObjekat> lista = z.getLista(rs);
        assertEquals(1, lista.size());
        
        Zanr zanr1 = (Zanr)lista.get(0);
        assertEquals(15, zanr1.getZanrId());
        assertEquals("Komedija", zanr1.getNaziv());
    }

    @Test
    public void testGetVrednostPrimarniKljuc() {
        z.setZanrId(10);
        assertEquals("ZanrId=10", z.getVrednostPrimarniKljuc());
    }
    
}
