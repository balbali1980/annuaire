
package annuaire.dao;
import annuaire.connexion.connexion;
import annuaire.model.annuaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author balbali
 */
public class daoAnnuaire implements implementAnnuaire {

    Connection connection;
    final String insert = "INSERT INTO annuaire (num, nom, adresse) VALUES ( ?, ?, ?);";
    final String update = "UPDATE annuaire set num=?, nom=?, adresse=? where id=? ;";
    final String delete = "DELETE FROM annuaire where id=? ;";
    final String select = "SELECT * FROM annuaire;";
    final String recherchenom = "SELECT * FROM annuaire where nom like ?";

    /**
     *
     */
    public daoAnnuaire() {
        connection = connexion.connection();
    }

    /**
     *
     * @param b
     */
    public void ajouter(annuaire b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getNum());
            statement.setString(2, b.getNom());
            statement.setString(3, b.getAdresse());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getInt(1));
               
            }
        } catch (SQLException ex) {
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @param b
     */
    public void update(annuaire b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNum());
            statement.setString(2, b.getNom());
            statement.setString(3, b.getAdresse());
            statement.setInt(4, b.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @param id
     */
    public void supprimer(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @return
     */
    public List<annuaire> getALL() {
        List<annuaire> lb = null;
        try {
            lb = new ArrayList<annuaire>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                annuaire b = new annuaire();
                b.setId(rs.getInt("id"));
                b.setNum(rs.getString("num"));
                b.setNom(rs.getString("nom"));
                b.setAdresse(rs.getString("adresse"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoAnnuaire.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }

    /**
     *
     * @param nom
     * @return
     */
    public List<annuaire> getRechercheNom(String nom) {
        List<annuaire> lb = null;
        try {
            lb = new ArrayList<annuaire>();
            PreparedStatement st = connection.prepareStatement(recherchenom);
            st.setString(1, "%" + nom + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                annuaire b = new annuaire();
                b.setId(rs.getInt("id"));
                b.setNum(rs.getString("num"));
                b.setNom(rs.getString("nom"));
                b.setAdresse(rs.getString("adresse"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoAnnuaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
}
