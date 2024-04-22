package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author MRDAK-PC
 */
public interface OpstiDomenskiObjekat extends Serializable {

    public String getNazivTabele();

    public String getAlijas();

    public String getKoloneZaDodavanje();

    public String join();

    public String getVrednostPrimarniKljuc();

    public String getKriterijum();

    public String vrednostiZaDodavanje();

    public String vrednostiZaAzuriranje();

    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException;

}
