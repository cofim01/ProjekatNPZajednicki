
package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class KorisnikTest {
    
    private Korisnik k;
    
    public KorisnikTest() {
        k=new Korisnik();
    }
    @Test
    public void testKorisnikParm() {
        Korisnik korisnik = new Korisnik(1, "Marko", "Markovic", "marko123");
        assertEquals(1, korisnik.getKorisnikId());
        assertEquals("Marko", korisnik.getIme());
        assertEquals("Markovic", korisnik.getPrezime());
        assertEquals("marko123", korisnik.getPassword());
    }

    @Test
    public void testSetKorisnikId() {
        k.setKorisnikId(1);
        assertEquals(1, k.getKorisnikId());
    }


    @Test
    public void testSetIme() {
        k.setIme("Nikola");
        assertEquals("Nikola", k.getIme());
    }
    
    @Test
    public void testSetImePrazanString() {
        Exception e=assertThrows(java.lang.IllegalArgumentException.class, ()->k.setIme(""));
        assertEquals(e.getMessage(), "Ime korisnika ne sme biti prazan string");
    }


    @Test
    public void testSetPrezime() {
        k.setPrezime("Nikolic");
        assertEquals("Nikolic", k.getPrezime());
    }
    
    @Test
    public void testSetPrezimePrazanString() {
        Exception e=assertThrows(java.lang.IllegalArgumentException.class, ()->k.setPrezime(""));
        assertEquals(e.getMessage(), "Prezime korisnika ne sme biti prazan string");
    }

    @Test
    public void testSetPassword() {
        k.setPassword("nikola01");
        assertEquals("nikola01", k.getPassword());
    }
    
    @Test
    public void testSetPasswordPrazanString() {
        Exception e=assertThrows(java.lang.IllegalArgumentException.class, ()->k.setPassword(""));
        assertEquals(e.getMessage(), "Sifra korisnika ne sme biti prazan string");
    }


    @Test
    public void testToString() {
        k.setIme("Nikola");
        k.setPrezime("Peric");
        assertEquals("Nikola Peric", k.toString());
    }


    @Test
    public void testGetNazivTabele() {
        assertEquals("korisnik", k.getNazivTabele());
    }


    @Test
    public void testGetAlijas() {
        assertEquals("k", k.getAlijas());
    }


    @Test
    public void testGetKoloneZaDodavanje() {
        assertEquals("(Ime,Prezime,Password)", k.getKoloneZaDodavanje());
    }


    @Test
    public void testJoin() {
        assertEquals("", k.join());
    }


    @Test
    public void testGetKriterijum() {
        assertEquals("", k.getKriterijum());
    }


    @Test
    public void testVrednostiZaDodavanje() {
        k.setIme("Marko");
        k.setPrezime("Markovic");
        k.setPassword("marko01");
        assertEquals("'Marko', 'Markovic', 'marko01'", k.vrednostiZaDodavanje());
    }


    @Test
    public void testVrednostiZaAzuriranje() {
        assertEquals("", k.vrednostiZaAzuriranje());
    }


    @Test
    public void testGetLista() throws Exception {
        ResultSet rs = mock(ResultSet.class);
        when(rs.next()).thenReturn(true, false);
        
        when(rs.getInt("KorisnikId")).thenReturn(1);
        when(rs.getString("Ime")).thenReturn("Marko");
        when(rs.getString("Prezime")).thenReturn("Markovic");
        when(rs.getString("Password")).thenReturn("marko123");
        
        ArrayList<OpstiDomenskiObjekat> lista = k.getLista(rs);
        
        // Provera rezultata
        assertEquals(1, lista.size());
        
        Korisnik ko = (Korisnik)lista.get(0);
        assertEquals(1, ko.getKorisnikId());
        assertEquals("Marko", ko.getIme());
        assertEquals("Markovic", ko.getPrezime());
        assertEquals("marko123", ko.getPassword());
        

    }

    /**
     * Test of getVrednostPrimarniKljuc method, of class Korisnik.
     */
    @Test
    public void testGetVrednostPrimarniKljuc() {
        assertEquals("", k.getVrednostPrimarniKljuc());
    }


    @Test
    public void testEqualsNull() {
        assertFalse(k.equals(null));
    }
    
    @Test
    public void testEqualsIsti() {
        assertTrue(k.equals(k));
    }
    
    @Test
    public void testEqualsDrugaKlasa() {
        assertFalse(k.equals(new String()));
    }
    
    @ParameterizedTest
    @CsvSource({
        "Pera,Peric,pera123,Pera,Peric,pera123,true",
        "Pera,Peric,pera123,Nikola,Peric,pera123,false",
        "Pera,Nikolic,pera123,Pera,Peric,pera123,false",
        "Pera,Peric,pera1234,Pera,Peric,pera123,false"
            
    })
    public void testEqualsDrugaKlasa(String ime1,String pre1,String pas1,String ime2,String pre2,String pas2,boolean vrednost) {
        k.setIme(ime1);
        k.setPrezime(pre1);
        k.setPassword(pas1);
        
        Korisnik k2=new Korisnik();
        k2.setIme(ime2);
        k2.setPrezime(pre2);
        k2.setPassword(pas2);
        
        assertEquals(vrednost, k.equals(k2));
    }
    
}
