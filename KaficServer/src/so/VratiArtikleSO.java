/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.InterfaceObjekat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

/**
 *
 * @author User
 */
public class VratiArtikleSO extends OpstaSistemskaOperacija {

    public VratiArtikleSO() {
        super();
    }

    @Override
    protected void proveriPreduslove(InterfaceObjekat domenskiObjekat) throws Exception {
    }

    @Override
    protected ServerskiOdgovor izvrsiOperaciju(InterfaceObjekat domenskiObjekat) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();

        try {
            List<InterfaceObjekat> lista = domenskiObjekat.kreirajListu(getDb().vrati(domenskiObjekat));
            so.setUspesno(true);
            so.setOdgovor(lista);
            so.setPoruka("Uspesno pronadjeni artikli");

        } catch (Exception e) {
            Logger.getLogger(VratiArtikleSO.class.getName()).log(Level.SEVERE, null, e);

            throw new Exception("Nije pronadjena lista artikala");
        }
        return so;
    }

}
