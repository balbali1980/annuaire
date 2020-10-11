
package annuaire.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author balbali
 */
public class tableModelAnnuaire extends AbstractTableModel {
    List<annuaire> lb;

    /**
     *
     * @param lb
     */
    public tableModelAnnuaire(List<annuaire> lb) {
        this.lb = lb;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }


    public int getRowCount() {
        return lb.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Numéro de téléphone";
            case 2:
                return "Nom";
            case 3:
                return "Adresse";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getNum();
            case 2:
                return lb.get(row).getNom();
            case 3:
                return lb.get(row).getAdresse();
            default:
                return null;
        }
    }
}
