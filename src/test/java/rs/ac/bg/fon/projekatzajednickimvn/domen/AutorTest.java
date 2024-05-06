
package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author MRDAK-PC
 */
public class AutorTest {
    private Autor a;
    
    public AutorTest(){
        a=new Autor();
    }
    
    
    @Test
    public void testAutor() {
        a=new Autor();
        assertTrue(a!=null);
    }
    
    @Test
    public void testAutorIntStringString() {
        a=new Autor(1,"Mika","Mikic");
        assertTrue(a!=null);
        assertEquals(1, a.getAutorId());
        assertEquals("Mika", a.getIme());
        assertEquals("Mikic", a.getPrezime());


        
    }
    

    @Test
    public void testSetAutorId() {
        a.setAutorId(1);
        assertEquals(1, a.getAutorId());
    }

    
    @Test
    public void testSetIme() {
        a.setIme("Filip");
        assertEquals("Filip", a.getIme());
    }


    @Test
    public void testSetPrezime() {
        a.setPrezime("Filipovic");
        assertEquals("Filipovic", a.getPrezime());
    }


    @Test
    public void testToString() {
        a.setIme("Pera");
        a.setPrezime("Peric");
        String s=a.toString();
        assertTrue(s.contains("Pera"));
        assertTrue(s.contains("Peric"));
    }


    @Test
    public void testGetNazivTabele() {
        String s=a.getNazivTabele();
        assertEquals("autor", s);
    }

    
    @Test
    public void testGetAlijas() {
        String s=a.getAlijas();
        assertEquals("a", s);
    }


    @Test
    public void testGetKoloneZaDodavanje() {
        String s=a.getKoloneZaDodavanje();
        assertEquals("", s);
    }


    @Test
    public void testJoin() {
        String s=a.join();
        assertEquals("", s);
    }


    @Test
    public void testGetKriterijum() {
        String s=a.getKriterijum();
        assertEquals("", s);
    }


    @Test
    public void testGetLista() throws Exception {
        ResultSet rs = mock(ResultSet.class);
        when(rs.next()).thenReturn(true, false);
        when(rs.getInt("autorId")).thenReturn(1);
        when(rs.getString("ime")).thenReturn("Nikola");
        when(rs.getString("prezime")).thenReturn("Nikolic");

        
        ArrayList<OpstiDomenskiObjekat> lista = a.getLista(rs);

        assertEquals(1, lista.size());
        assertEquals(1, ((Autor) lista.get(0)).getAutorId());
        assertEquals("Nikola", ((Autor) lista.get(0)).getIme());
        assertEquals("Nikolic", ((Autor) lista.get(0)).getPrezime());
    }


    @Test
    public void testVrednostiZaDodavanje() {
        String s=a.vrednostiZaDodavanje();
        assertEquals("", s);
    }


    @Test
    public void testVrednostiZaAzuriranje() {
        String s=a.vrednostiZaAzuriranje();
        assertEquals("", s);
    }

   
    @Test
    public void testGetVrednostPrimarniKljuc() {
        a.setAutorId(1);
        String s=a.getVrednostPrimarniKljuc();
        assertEquals("AutorId=1", s);
    }
    
}
