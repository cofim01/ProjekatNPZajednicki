
package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ClanTest {
    
    private Clan c;
    public ClanTest() {
        c=new Clan();
    }
    
    @Test
    public void testClan() {
        c=new Clan();
        assertTrue(c!=null);
    }
    
    @Test
    public void testClanIntStringStringStringStringKorisnik() {
        Korisnik k=new Korisnik();
        k.setIme("Mika");
        k.setPrezime("Mikic");
        k.setKorisnikId(1);
        k.setPassword("Pera01");
        c=new Clan(1, "Pera", "Peric","Ustanicka","0615533888", k);
        
        assertEquals(1, c.getClanId());
        assertEquals("Pera", c.getIme());
        assertEquals("Peric", c.getPrezime());
        assertEquals("Ustanicka", c.getAdresa());
        assertEquals("0615533888", c.getBrTelefona());
        assertEquals(k, c.getKorisnik());
        
        
    }
    
    @Test
    public void testSetClanId() {
        c.setClanId(1);
        assertEquals(1, c.getClanId());
    }

    
    @Test
    public void testSetIme() {
        c.setIme("Mika");
        assertEquals("Mika", c.getIme());
    }


    @Test
    public void testSetPrezime() {
        c.setPrezime("Mikic");
        assertEquals("Mikic", c.getPrezime());
    }


    @Test
    public void testSetAdresa() {
        c.setAdresa("Bele Bartoka 3");
        assertEquals("Bele Bartoka 3", c.getAdresa());
    }


    @Test
    public void testSetBrTelefona() {
        c.setBrTelefona("0655666555");
        assertEquals("0655666555", c.getBrTelefona());
    }


    @Test
    public void testSetKorisnik() {
        Korisnik k=new Korisnik();
        k.setIme("Pera");
        k.setPrezime("Peric");
        k.setKorisnikId(1);
        k.setPassword("Pera01");
        
        c.setKorisnik(k);
        assertEquals("Pera", c.getKorisnik().getIme());
        assertEquals("Peric", c.getKorisnik().getPrezime());
        assertEquals(1, c.getKorisnik().getKorisnikId());
        assertEquals("Pera01", c.getKorisnik().getPassword());
    }

    
    @Test
    public void testSetEmail() {
        c.setEmail("mikam@gmail.com");
        assertEquals("mikam@gmail.com", c.getEmail());
    }


    @Test
    public void testSetStatus() {
        c.setStatus("Aktivan");
        assertEquals("Aktivan", c.getStatus());
    }



    @Test
    public void testToString() {
        c.setIme("Zika");
        c.setPrezime("Zikic");
        String s=c.toString();
        assertTrue(s.contains("Zika"));
        assertTrue(s.contains("Zikic"));
    }


    @Test
    public void testGetNazivTabele() {
        String s=c.getNazivTabele();
        assertEquals("clan", s);
    }


    @Test
    public void testGetAlijas() {
        String s=c.getAlijas();
        assertEquals("c", s);
    }


    @Test
    public void testGetKoloneZaDodavanje() {
        String s=c.getKoloneZaDodavanje();
        assertEquals("(Ime,Prezime,Adresa,BrojTelefona,Email,Status,KorisnikId)", s);
    }


    @Test
    public void testJoin() {
        String s=c.join();
        assertEquals("JOIN korisnik k ON(c.KorisnikId=k.KorisnikId)", s);
    }


    @Test
    public void testGetKriterijum() {
        c.setIme("Nikola");
        c.setPrezime("Nikolic");
        String s=c.getKriterijum();
        assertEquals("WHERE c.Ime LIKE '%Nikola%' AND c.Prezime LIKE '%Nikolic%'", s);
    }

   
    @Test
    public void testVrednostiZaDodavanje() {
        Korisnik k=new Korisnik();
        k.setIme("Pera");
        k.setPrezime("Peric");
        k.setKorisnikId(1);
        k.setPassword("Pera01");
        
        c.setIme("Nikola");
        c.setPrezime("Nikolic");
        c.setAdresa("Ustanicka");
        c.setBrTelefona("0614455111");
        c.setClanId(1);
        c.setKorisnik(k);
        c.setStatus("Aktivan");
        c.setEmail("nikola@gmail.com");
        
        String s=c.vrednostiZaDodavanje();
        assertEquals("'Nikola','Nikolic','Ustanicka','0614455111','nikola@gmail.com','Aktivan','1'", s);
    }

    
    @Test
    public void testVrednostiZaAzuriranje() {
        c.setAdresa("Ustanicka");
        c.setBrTelefona("0614455111");
        c.setStatus("Aktivan");
        c.setEmail("nikola@gmail.com");
        String s=c.vrednostiZaAzuriranje();
        assertEquals("Adresa='Ustanicka', BrojTelefona='0614455111', Email='nikola@gmail.com', Status='Aktivan'", s);
    }

    
    @Test
    public void testGetLista() throws Exception {
        ResultSet rs = mock(ResultSet.class);


        when(rs.next()).thenReturn(true, false);
        when(rs.getInt("c.ClanId")).thenReturn(1);
        when(rs.getString("c.Ime")).thenReturn("Luka");
        when(rs.getString("c.Prezime")).thenReturn("Lukic");
        when(rs.getString("c.BrojTelefona")).thenReturn("123456789");
        when(rs.getString("c.Adresa")).thenReturn("Adresa 123");
        when(rs.getString("c.Email")).thenReturn("lukal@gmail.com");
        when(rs.getString("c.Status")).thenReturn("Aktivan");

        when(rs.getInt("k.KorisnikId")).thenReturn(2);
        when(rs.getString("k.Ime")).thenReturn("Filip");
        when(rs.getString("k.Prezime")).thenReturn("Filipovic");
        when(rs.getString("k.Password")).thenReturn("Filip123");



        ArrayList<OpstiDomenskiObjekat> result = c.getLista(rs);


        assertEquals(1, result.size());

        Clan c = (Clan) result.get(0);
        assertEquals(1, c.getClanId());
        assertEquals("Luka", c.getIme());
        assertEquals("Lukic", c.getPrezime());
        assertEquals("123456789", c.getBrTelefona());
        assertEquals("Adresa 123", c.getAdresa());
        assertEquals("lukal@gmail.com", c.getEmail());
        assertEquals("Aktivan", c.getStatus());

        Korisnik k = c.getKorisnik();
        assertEquals(2, k.getKorisnikId());
        assertEquals("Filip", k.getIme());
        assertEquals("Filipovic", k.getPrezime());
        assertEquals("Filip123", k.getPassword());
    }


    @Test
    public void testGetVrednostPrimarniKljuc() {
        c.setClanId(1);
        assertEquals("ClanId=1", c.getVrednostPrimarniKljuc());
    }
    
}
