
package rs.ac.bg.fon.projekatzajednickimvn.komunikacija;

import java.io.Serializable;

/**
 * Enumeracija koja definise moguce statuse odgovora koji se koriste u aplikaciji.
 * Ovi statusi se koriste za oznacavanje rezultata operacija u sistemu.
 * 
 * @author Filip Mrdak
 */
public enum StatusOdgovora implements Serializable{
    SUCCESS,    // Oznacava uspesan rezultat operacije u sistemu.
    ERROR;      // Oznacava gresku ili neuspesan rezultat operacije u sistemu.
}
