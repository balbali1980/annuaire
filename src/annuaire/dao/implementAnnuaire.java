
package annuaire.dao;

import java.util.List;
import annuaire.model.*;

/**
 *
 * @author balbali
 */
public interface implementAnnuaire {

    /**
     *
     * @param b
     */
    public void ajouter(annuaire b);

    /**
     *
     * @param b
     */
    public void update(annuaire b);

    /**
     *
     * @param id
     */
    public void supprimer(int id);

    /**
     *
     * @return
     */
    public List<annuaire> getALL();

    /**
     *
     * @param nom
     * @return
     */
    public List<annuaire> getRechercheNom(String nom);
}
