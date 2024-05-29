package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ZaduzenjeTest {

    private Zaduzenje z;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ZaduzenjeTest() {
        z = new Zaduzenje();
        Date datumZaduzenja = new Date();
        Date datumRazduzenja = null;

        PrimerakKnjige primerak = new PrimerakKnjige();

        Korisnik k = new Korisnik();
        k.setIme("Mika");
        k.setPrezime("Mikic");
        k.setKorisnikId(1);
        k.setPassword("Pera01");
        Clan clan = new Clan(1, "Pera", "Peric", "Ustanicka", "0615533888", k);

        Korisnik korisnik = new Korisnik(1, "Marko", "Markovic", "marko123");
        z.setBrZaduzenja(15);
        z.setClan(clan);
        z.setDatumRazduzenja(datumRazduzenja);
        z.setDatumZaduzenja(datumZaduzenja);
        z.setKorisnik(korisnik);
        z.setPrimerak(primerak);
    }

    @Test
    public void testZaduzenjaParm() {
        Date datumZaduzenja = new Date();
        Date datumRazduzenja = null;

        PrimerakKnjige primerak = new PrimerakKnjige();

        Korisnik k = new Korisnik();
        k.setIme("Mika");
        k.setPrezime("Mikic");
        k.setKorisnikId(1);
        k.setPassword("Pera01");
        Clan clan = new Clan(1, "Pera", "Peric", "Ustanicka", "0615533888", k);

        Korisnik korisnik = new Korisnik(1, "Marko", "Markovic", "marko123");

        Zaduzenje zaduzenje = new Zaduzenje(1, datumZaduzenja, datumRazduzenja, primerak, clan, korisnik);

        assertEquals(1, zaduzenje.getBrZaduzenja());
        assertEquals(datumZaduzenja, zaduzenje.getDatumZaduzenja());
        assertEquals(datumRazduzenja, zaduzenje.getDatumRazduzenja());
        assertEquals(primerak, zaduzenje.getPrimerak());
        assertEquals(clan, zaduzenje.getClan());
        assertEquals(korisnik, zaduzenje.getKorisnik());
    }

    @Test
    public void testSetBrZaduzenja() {
        z.setBrZaduzenja(15);
        assertEquals(15, z.getBrZaduzenja());
    }

    @Test
    public void testSetDatumZaduzenja() {
        Date d = new Date();
        z.setDatumZaduzenja(d);
        assertEquals(d, z.getDatumZaduzenja());
    }

    @Test
    public void testSetDatumRazduzenja() {
        Date d = new Date();
        z.setDatumRazduzenja(d);
        assertEquals(d, z.getDatumRazduzenja());
    }

    @Test
    public void testSetClan() {
        Korisnik k = new Korisnik();
        k.setIme("Mika");
        k.setPrezime("Mikic");
        k.setKorisnikId(1);
        k.setPassword("Pera01");
        Clan clan = new Clan(1, "Nikola", "Nikolic", "Ustanicka", "0615533888", k);
        z.setClan(clan);
        assertEquals(1, z.getClan().getClanId());
        assertEquals("Nikola", z.getClan().getIme());
        assertEquals("Nikolic", z.getClan().getPrezime());
        assertEquals("Ustanicka", z.getClan().getAdresa());
        assertEquals("0615533888", z.getClan().getBrTelefona());
        assertEquals(k, z.getClan().getKorisnik());
    }

    @Test
    public void testSetKorisnik() {
        Korisnik k = new Korisnik();
        k.setIme("Sara");
        k.setPrezime("Mikic");
        k.setKorisnikId(1);
        k.setPassword("Pera01");
        z.setKorisnik(k);
    }

    @Test
    public void testSetPrimerak() {
        PrimerakKnjige primerak = new PrimerakKnjige();
        primerak.setBrojPolice(25);
        primerak.setGodinaIzdanja(2016);
        Izdavac i = new Izdavac(1, "Laguna");
        primerak.setIzdavac(i);
        primerak.setPrimerakId(5);
        primerak.setStatus("Dostupan");
        Zanr zanr = new Zanr(1, "Komedija");
        Korisnik korisnik = new Korisnik(1, "Nikola", "Nikolic", "nikola123");

        Knjiga knjiga = new Knjiga(1, "Nova knjiga", zanr, korisnik);
        primerak.setKnjiga(knjiga);
        z.setPrimerak(primerak);

        assertEquals(25, z.getPrimerak().getBrojPolice());
        assertEquals(2016, z.getPrimerak().getGodinaIzdanja());
        assertEquals(i, z.getPrimerak().getIzdavac());
        assertEquals(5, z.getPrimerak().getPrimerakId());
        assertEquals("Dostupan", z.getPrimerak().getStatus());
        assertEquals(knjiga, z.getPrimerak().getKnjiga());

    }

    @Test
    public void testGetNazivTabele() {
        assertEquals("zaduzenje", z.getNazivTabele());
    }

    @Test
    public void testGetAlijas() {
        assertEquals("zd", z.getAlijas());
    }

    @Test
    public void testGetKoloneZaDodavanje() {
        assertEquals("(DatumZaduzenja,IdClan,IdPrimerak,KorisnikId,KnjigaId)", z.getKoloneZaDodavanje());
    }

    @Test
    public void testJoin() {
        assertEquals("JOIN Clan c ON(zd.IdClan=c.ClanId)"
                + "JOIN primerakKnjige pk ON (zd.IdPrimerak=pk.IdPrimerak)"
                + "JOIN knjiga k ON(pk.idKnjiga=k.KnjigaId)"
                + "JOIN  zanr z ON(k.ZanrId=z.ZanrId)"
                + "JOIN izdavac i ON(pk.idIzdavac=i.IzdavacId)"
                + "JOIN korisnik kk ON(k.KorisnikId=kk.KorisnikId)"
                + "JOIN korisnik kz ON(zd.KorisnikId=kz.KorisnikId)", z.join());
    }

    @Test
    public void testGetKriterijum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        z.setDatumOdFilter(new Date());
        z.setDatumDoFilter(new Date());
        Clan clan = new Clan();
        clan.setClanId(1);
        z.setClan(clan);
        String datum = sdf.format(new Date());
        String kriterijum = z.getKriterijum();

        String expected = "WHERE idClan=1 AND DatumZaduzenja >= '" + datum + "' AND DatumZaduzenja <= '" + datum + "' ORDER BY DatumZaduzenja DESC";
        assertEquals(expected, kriterijum);
    }

    @Test
    public void testVrednostiZaDodavanje() {

    }

    @Test
    public void testVrednostiZaAzuriranje() {
        Date datumRazduzenja = new Date();
        z.setDatumRazduzenja(datumRazduzenja);

        String s = z.vrednostiZaAzuriranje();
        String o = "DatumRazduzenja='" + java.sql.Date.valueOf(sdf.format(datumRazduzenja)) + "'";
        assertEquals(o, s);
    }

    @Test
    public void testGetLista() throws Exception {
        ResultSet rs = mock(ResultSet.class);
        when(rs.next()).thenReturn(true, false);

        when(rs.getInt("BrojZaduzenja")).thenReturn(1);
        when(rs.getDate("DatumZaduzenja")).thenReturn(java.sql.Date.valueOf("2024-05-06"));
        when(rs.getDate("DatumRazduzenja")).thenReturn(java.sql.Date.valueOf("2024-05-07"));

        when(rs.getInt("c.ClanId")).thenReturn(1);
        when(rs.getString("c.Ime")).thenReturn("Marko");
        when(rs.getString("c.Prezime")).thenReturn("Markovic");
        when(rs.getString("c.BrojTelefona")).thenReturn("123456");
        when(rs.getString("c.Adresa")).thenReturn("Adresa 123");

        when(rs.getInt("pk.idPrimerak")).thenReturn(1);
        when(rs.getInt("pk.brojPolice")).thenReturn(1);
        when(rs.getInt("pk.godinaIzdanja")).thenReturn(2020);
        when(rs.getString("pk.status")).thenReturn("Dostupna");

        when(rs.getInt("i.IzdavacId")).thenReturn(1);
        when(rs.getString("i.Naziv")).thenReturn("Laguna");

        when(rs.getInt("k.KnjigaId")).thenReturn(1);
        when(rs.getString("k.Naziv")).thenReturn("Naziv knjige");

        when(rs.getInt("z.ZanrId")).thenReturn(1);
        when(rs.getString("z.Naziv")).thenReturn("Triler");

        when(rs.getInt("kk.KorisnikId")).thenReturn(1);
        when(rs.getString("kk.Ime")).thenReturn("Nikola");
        when(rs.getString("kk.Prezime")).thenReturn("Nikolic");
        when(rs.getString("kk.Password")).thenReturn("Dzoni123");

        // Korisnik koji je kreirao zaduzenje
        when(rs.getInt("kz.KorisnikId")).thenReturn(1);
        when(rs.getString("kz.Ime")).thenReturn("Petar");
        when(rs.getString("kz.Prezime")).thenReturn("Petrovic");
        when(rs.getString("kz.Password")).thenReturn("petar45");

        ArrayList<OpstiDomenskiObjekat> lista = z.getLista(rs);

        assertEquals(1, lista.size());

        Zaduzenje zaduzenje1 = (Zaduzenje) lista.get(0);
        assertEquals(1, zaduzenje1.getBrZaduzenja());
        assertEquals(java.sql.Date.valueOf("2024-05-06"), zaduzenje1.getDatumZaduzenja());
        assertEquals(java.sql.Date.valueOf("2024-05-07"), zaduzenje1.getDatumRazduzenja());

        //Provera clana
        assertEquals(1, zaduzenje1.getClan().getClanId());
        assertEquals("Marko", zaduzenje1.getClan().getIme());
        assertEquals("Markovic", zaduzenje1.getClan().getPrezime());
        assertEquals("123456", zaduzenje1.getClan().getBrTelefona());
        assertEquals("Adresa 123", zaduzenje1.getClan().getAdresa());

        // Provera primerka knjige
        assertEquals(1, zaduzenje1.getPrimerak().getPrimerakId());
        assertEquals(1, zaduzenje1.getPrimerak().getBrojPolice());
        assertEquals(2020, zaduzenje1.getPrimerak().getGodinaIzdanja());
        assertEquals("Dostupna", zaduzenje1.getPrimerak().getStatus());

        //Provera izdavaca
        assertEquals(1, zaduzenje1.getPrimerak().getIzdavac().getIzdavacId());
        assertEquals("Laguna", zaduzenje1.getPrimerak().getIzdavac().getNaziv());

        //Provera knjige
        assertEquals(1, zaduzenje1.getPrimerak().getKnjiga().getKnjigaId());
        assertEquals("Naziv knjige", zaduzenje1.getPrimerak().getKnjiga().getNaziv());

        // Provera zanra knjige
        assertEquals(1, zaduzenje1.getPrimerak().getKnjiga().getZanr().getZanrId());
        assertEquals("Triler", zaduzenje1.getPrimerak().getKnjiga().getZanr().getNaziv());

        //Provera korisnika koji je kreirao knjigu
        assertEquals(1, zaduzenje1.getPrimerak().getKnjiga().getKorisnik().getKorisnikId());
        assertEquals("Nikola", zaduzenje1.getPrimerak().getKnjiga().getKorisnik().getIme());
        assertEquals("Nikolic", zaduzenje1.getPrimerak().getKnjiga().getKorisnik().getPrezime());
        assertEquals("Dzoni123", zaduzenje1.getPrimerak().getKnjiga().getKorisnik().getPassword());

        //Provera korisnika koji je kreirao zaduzenje
        assertEquals(1, zaduzenje1.getKorisnik().getKorisnikId());
        assertEquals("Petar", zaduzenje1.getKorisnik().getIme());
        assertEquals("Petrovic", zaduzenje1.getKorisnik().getPrezime());
        assertEquals("petar45", zaduzenje1.getKorisnik().getPassword());
    }

    @Test
    public void testGetVrednostPrimarniKljuc() {
        assertEquals("BrojZaduzenja=15", z.getVrednostPrimarniKljuc());
    }

}
