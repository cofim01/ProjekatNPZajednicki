package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MRDAK-PC
 */
public class KnjigaAutor implements OpstiDomenskiObjekat {

    private int knjigaAutorId;
    private Knjiga knjiga;
    private Autor autor;

    public KnjigaAutor() {
    }

    public KnjigaAutor(int knjigaAutorId, Knjiga knjiga, Autor autor) {
        this.knjigaAutorId = knjigaAutorId;
        this.knjiga = knjiga;
        this.autor = autor;
    }

    public void setKnjigaAutorId(int knjigaAutorId) {
        this.knjigaAutorId = knjigaAutorId;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getKnjigaAutorId() {
        return knjigaAutorId;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

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
