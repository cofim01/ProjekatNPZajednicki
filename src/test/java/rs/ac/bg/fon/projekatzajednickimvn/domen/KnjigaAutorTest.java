
package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KnjigaAutorTest {
    
    KnjigaAutor ka;
    Knjiga k;
    public KnjigaAutorTest() {
        ka=new KnjigaAutor();
        k=new Knjiga();
    }
    
    
    @Test
    public void testSetKnjigaAutorId() {
        ka.setKnjigaAutorId(1);
        assertEquals(1, ka.getKnjigaAutorId());
    }


    @Test
    public void testSetKnjiga() {
        Korisnik korisnik=new Korisnik(1, "Nikola", "Nikolic", "nikola123");
        k.setKnjigaId(1);
        k.setKorisnik(korisnik);
        k.setNaziv("Nova knjiga");
        Zanr z=new Zanr(1, "Komedija");
        k.setZanr(z);
        PrimerakKnjige pk1=new PrimerakKnjige(1, 25, new Izdavac(2, "Laguna"), 2016, "Dostupna");
        ArrayList<PrimerakKnjige> primerci = new ArrayList<>();
        primerci.add(pk1);
        k.setPrimerci(primerci);
        ka.setKnjiga(k);
        
        assertEquals(1, ka.getKnjiga().getKnjigaId());
        assertEquals("Nova knjiga", ka.getKnjiga().getNaziv());
        assertEquals(1, ka.getKnjiga().getZanr().getZanrId());
        assertEquals("Komedija", ka.getKnjiga().getZanr().getNaziv());
        assertEquals(1, ka.getKnjiga().getKorisnik().getKorisnikId());
        assertEquals("Nikola", ka.getKnjiga().getKorisnik().getIme());
        assertEquals("Nikolic", ka.getKnjiga().getKorisnik().getPrezime());
        assertEquals("nikola123", ka.getKnjiga().getKorisnik().getPassword());
        
        assertEquals(1, ka.getKnjiga().getPrimerci().size());
        assertEquals(1, ka.getKnjiga().getPrimerci().get(0).getPrimerakId());
        assertEquals(25, ka.getKnjiga().getPrimerci().get(0).getBrojPolice());
        assertEquals(2, ka.getKnjiga().getPrimerci().get(0).getIzdavac().getIzdavacId());
        assertEquals("Laguna", ka.getKnjiga().getPrimerci().get(0).getIzdavac().getNaziv());
        assertEquals("Dostupna", ka.getKnjiga().getPrimerci().get(0).getStatus());
    }
    
    @Test
    public void testSetKnjigaNull() {
        Exception e=assertThrows(java.lang.NullPointerException.class, ()->ka.setKnjiga(null));
        assertEquals(e.getMessage(), "Knjiga ne sme biti null");
    }


    @Test
    public void testSetAutor() {
        Autor a=new Autor(1,"Ivo","Andric");
        ka.setAutor(a);
        assertEquals(1, ka.getAutor().getAutorId());
        assertEquals("Ivo", ka.getAutor().getIme());
        assertEquals("Andric", ka.getAutor().getPrezime());
    }
    
    @Test
    public void testSetAutorNull() {
        Exception e=assertThrows(java.lang.NullPointerException.class, ()->ka.setAutor(null));
        assertEquals(e.getMessage(), "Autor ne sme biti null");
    }


    @Test
    public void testGetNazivTabele() {
        assertEquals("knjigaAutor", ka.getNazivTabele());
    }

    
    @Test
    public void testGetAlijas() {
        assertEquals("ka", ka.getAlijas());
    }

    
    @Test
    public void testGetKoloneZaDodavanje() {
        assertEquals("(KnjigaId,AutorId)", ka.getKoloneZaDodavanje());
    }

   
    @Test
    public void testJoin() {
         assertEquals("JOIN Knjiga k ON(ka.KnjigaId=k.KnjigaId)JOIN Autor a ON(ka.AutorId=a.AutorId)JOIN Zanr z ON(k.ZanrId=z.ZanrId)JOIN Korisnik ko ON(k.KorisnikId=ko.KorisnikId)", ka.join());
    }


    @Test
    public void testGetKriterijum() {
        assertEquals("", ka.getKriterijum());
    }


    @Test
    public void testVrednostiZaDodavanje() {
        Knjiga k=new Knjiga();
        k.setKnjigaId(3);
        Autor a=new Autor();
        a.setAutorId(5);
        ka.setAutor(a);
        ka.setKnjiga(k);
        assertEquals("'3', '5'", ka.vrednostiZaDodavanje());
    }

    
    @Test
    public void testVrednostiZaAzuriranje() {
        assertEquals("", ka.vrednostiZaAzuriranje());
    }


    @Test
    public void testGetLista() throws Exception {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true).thenReturn(false); 

        
        when(resultSet.getInt("ka.KnjigaAutorId")).thenReturn(1);
        when(resultSet.getInt("k.KnjigaId")).thenReturn(10);
        when(resultSet.getString("k.Naziv")).thenReturn("Nova knjiga");
        when(resultSet.getInt("z.ZanrId")).thenReturn(2);
        when(resultSet.getString("z.Naziv")).thenReturn("Komedija");
        when(resultSet.getInt("ko.KorisnikId")).thenReturn(15);
        when(resultSet.getString("ko.Ime")).thenReturn("Zika");
        when(resultSet.getString("ko.Prezime")).thenReturn("Zikic");
        when(resultSet.getString("ko.Password")).thenReturn("zika123");
        when(resultSet.getInt("a.autorId")).thenReturn(9);
        when(resultSet.getString("a.ime")).thenReturn("Ivo");
        when(resultSet.getString("a.prezime")).thenReturn("Andric");

        ArrayList<OpstiDomenskiObjekat> lista = ka.getLista(resultSet);


        assertNotNull(lista);
        assertEquals(1, lista.size()); 

        KnjigaAutor knjigaA = (KnjigaAutor) lista.get(0);
        assertEquals(1, knjigaA.getKnjigaAutorId());
        Knjiga knjiga = knjigaA.getKnjiga();
        assertNotNull(knjiga);
        assertEquals(10, knjiga.getKnjigaId());
        assertEquals("Nova knjiga", knjiga.getNaziv());
        Zanr zanr = knjiga.getZanr();
        assertNotNull(zanr);
        assertEquals(2, zanr.getZanrId());
        assertEquals("Komedija", zanr.getNaziv());
        Korisnik korisnik = knjiga.getKorisnik();
        assertNotNull(korisnik);
        assertEquals(15, korisnik.getKorisnikId());
        assertEquals("Zika", korisnik.getIme());
        assertEquals("Zikic", korisnik.getPrezime());
        assertEquals("zika123", korisnik.getPassword());
        assertEquals(9, knjigaA.getAutor().getAutorId());
        assertEquals("Ivo", knjigaA.getAutor().getIme());
        assertEquals("Andric", knjigaA.getAutor().getPrezime());
    }


    @Test
    public void testGetVrednostPrimarniKljuc() {
        ka.setKnjigaAutorId(1);
        assertEquals("KnjigaAutorId=1", ka.getVrednostPrimarniKljuc());
    }
    
}
