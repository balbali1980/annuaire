

/*
 * contrôleur de l'annuaire.java
 * by Foued BALBALI
 * 
 */
package annuaire.controleur;

import annuaire.dao.daoAnnuaire;
import annuaire.dao.implementAnnuaire;
import annuaire.model.annuaire;
import annuaire.model.tableModelAnnuaire;
import annuaire.view.FrameTelephone;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author balbali
 */
public class controleurAnnuaire {

    FrameTelephone frame;
    implementAnnuaire implAnnuaire;
    List<annuaire> lb;

    /**
     *
     * @param frame
     */
    public controleurAnnuaire(FrameTelephone frame) {
        this.frame = frame;
        implAnnuaire = new daoAnnuaire();
        lb = implAnnuaire.getALL();
    }

    // Vider les champs

    /**
     *
     */
    public void reset() {
        frame.getTxtID().setText("");
        frame.getTxtNum().setText("");
        frame.getTxtNom().setText("");
        frame.getTxtAdresse().setText("");
    }

    // Afficher les données de la table

    /**
     *
     */
    public void isiTable() {
        lb = implAnnuaire.getALL();
        tableModelAnnuaire tmb = new tableModelAnnuaire(lb);
        frame.getTabelData().setModel(tmb);
    }

    //cette fonction pour afficher les données sélectionnées à partir de la grille

    /**
     *
     * @param row
     */
    public void isiField(int row) {
        frame.getTxtID().setText(lb.get(row).getId().toString());
        frame.getTxtNum().setText(lb.get(row).getNum());
        frame.getTxtNom().setText(lb.get(row).getNom());
        frame.getTxtAdresse().setText(lb.get(row).getAdresse());
    }

    //Fonction permettant insérer des données en fonction de l'entrée utilisateur du champ de texte dans le cadre

    /**
     *
     */
    public void insert() {
        annuaire b = new annuaire();
        b.setNum(frame.getTxtNum().getText());
        b.setNom(frame.getTxtNom().getText());
        b.setAdresse(frame.getTxtAdresse().getText());
        implAnnuaire.ajouter(b);
    }

    //mettre à jour les données sur la base de l'entrée d'utilisateur de la textfield dans le cadre

    /**
     *
     */
    public void update() {
        try {
            annuaire b = new annuaire();
            b.setNum(frame.getTxtNum().getText());
            b.setNom(frame.getTxtNom().getText());
            b.setAdresse(frame.getTxtAdresse().getText());
            b.setId(Integer.parseInt(frame.getTxtID().getText()));
            implAnnuaire.update(b);
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(frame, "Sélectionnez les données à mettre à jour");
        }
    }

    //fonction pour supprimer les données sélectionnées

    /**
     *
     */
    public void delete() {
        if (!frame.getTxtID().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtID().getText());
            implAnnuaire.supprimer(id);
        } else {
            JOptionPane.showMessageDialog(frame, "Sélectionnez les données à supprimer");
        }
    }

    /**
     *
     */
    public void isiTableRechercheNom() {
        lb = implAnnuaire.getRechercheNom(frame.getTxtRechercheNom().getText());
        tableModelAnnuaire tmb = new tableModelAnnuaire(lb);
        frame.getTabelData().setModel(tmb);
    }

    /**
     *
     */
    public void recherchenom() {
        if (!frame.getTxtRechercheNom().getText().trim().isEmpty()) {
            implAnnuaire.getRechercheNom(frame.getTxtRechercheNom().getText());
            isiTableRechercheNom();
        } else {
            JOptionPane.showMessageDialog(frame, "Sélectionner des données");
        }
    }
}
