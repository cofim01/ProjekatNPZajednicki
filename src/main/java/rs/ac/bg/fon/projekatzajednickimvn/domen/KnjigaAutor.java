package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja vezu izmedju jedne knjige i jednog autora u biblioteci.
 * Sadrzi id,knjigu i autora.
 * @author Filip Mrdak
 */
public class KnjigaAutor implements OpstiDomenskiObjekat {
    /**
     * id veze izmedju knjige i autora.
     */
    private int knjigaAutorId;
    /**
     * Knjiga koja je povezana sa autorom.
     */
    private Knjiga knjiga;
    /**
     * Autor koji je povezan sa knjigom.
     */
    private Autor autor;
    /**
     * Podrazumevani konstruktor koji kreira novi objekat klase KnjigaAutor.
     */
    public KnjigaAutor() {
    }
    /**
     * Parametrizovani konstruktor koji kreira novi objekat klase KnjigaAutor i postavlja vrednosti atributa na unete vrednosti.
     * @param knjigaAutorId - id veze izmedju knjige i autora.
     * @param knjiga - knjiga koja je povezana sa autorom.
     * @param autor - autor koji je povezan sa knjigom.
     */
    public KnjigaAutor(int knjigaAutorId, Knjiga knjiga, Autor autor) {
        setKnjigaAutorId(knjigaAutorId);
        setKnjiga(knjiga);
        setAutor(autor);
    }
    /**
     * Postavlja id veze izmedju knjige i autora.
     * @param knjigaAutorId - id veze knjige i autora.
     */
    public void setKnjigaAutorId(int knjigaAutorId) {
        this.knjigaAutorId = knjigaAutorId;
    }
    /**
     * Postavlja knjigu koja je povezana sa autorom.
     * Uneta vrednost mora biti razlicita od null.
     * 
     * @param knjiga - knjiga koja je povezana sa autorom.
     * @throws NullPointerException - ukoliko je prosledjena knjiga null.
     */
    public void setKnjiga(Knjiga knjiga) {
        if(knjiga==null){
            throw new NullPointerException("Knjiga ne sme biti null");
        }
        this.knjiga = knjiga;
    }
    /**
     * Postavlja autora koji je povezan sa knjigom.
     * Uneta vrednost mora biti razlicita od null.
     * 
     * @param autor - autor koji je povezan sa knjigom.
     * @throws NullPointerException - ukoliko je prosledjen autor null.
     */
    public void setAutor(Autor autor) {
        if(autor==null){
            throw new NullPointerException("Autor ne sme biti null");
        }
        this.autor = autor;
    }
    /**
     * Vraca id veze izmedju knjige i autora.
     * @return id veze izmedju knjige i autora.
     */
    public int getKnjigaAutorId() {
        return knjigaAutorId;
    }
    /**
     * Vraca knjigu koja je povezana sa autorom.
     * @return knjiga koja je povezana sa autorom.
     */
    public Knjiga getKnjiga() {
        return knjiga;
    }
    /**
     * Vraca autora koji je povezan sa knjigom.
     * @return autor koji je povezan sa knjigom.
     */
    public Autor getAutor() {
        return autor;
    }

    @Override
    public String getNazivTabele() {
        return "knjigaAutor";
    }

    @Override
    public String getAlijas() {
        return "ka";
    }

    @Override
    public String getKoloneZaDodavanje() {
        return "(KnjigaId,AutorId)";
    }

    @Override
    public String join() {
        return "JOIN Knjiga k ON(ka.KnjigaId=k.KnjigaId)"
                + "JOIN Autor a ON(ka.AutorId=a.AutorId)"
                + "JOIN Zanr z ON(k.ZanrId=z.ZanrId)"
                + "JOIN Korisnik ko ON(k.KorisnikId=ko.KorisnikId)";
    }


    @Override
    public String getKriterijum() {
        return "";
    }

    @Override
    public String vrednostiZaDodavanje() {
        return "'" + knjiga.getKnjigaId() + "', '" + autor.getAutorId() + "'";
    }

    @Override
    public String vrednostiZaAzuriranje() {
        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            KnjigaAutor ka = new KnjigaAutor();
            ka.setKnjigaAutorId(rs.getInt("ka.KnjigaAutorId"));

            Knjiga k = new Knjiga();
            k.setKnjigaId(rs.getInt("k.KnjigaId"));
            k.setNaziv(rs.getString("k.Naziv"));


            Zanr z = new Zanr();
            z.setZanrId(rs.getInt("z.ZanrId"));
            z.setNaziv(rs.getString("z.Naziv"));
            k.setZanr(z);



            Korisnik ko = new Korisnik();
            ko.setKorisnikId(rs.getInt("ko.KorisnikId"));
            ko.setIme(rs.getString("ko.Ime"));
            ko.setPrezime(rs.getString("ko.Prezime"));
            ko.setPassword(rs.getString("ko.Password"));
            k.setKorisnik(ko);

            ka.setKnjiga(k);

            Autor a = new Autor();
            a.setAutorId(rs.getInt("a.autorId"));
            a.setIme(rs.getString("a.ime"));
            a.setPrezime(rs.getString("a.prezime"));
            
            ka.setAutor(a);

            lista.add(ka);

        }
        rs.close();
        return lista;
    }

    @Override
    public String getVrednostPrimarniKljuc() {
        return "KnjigaAutorId="+knjigaAutorId;
    }

}
