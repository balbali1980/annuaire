package annuaire.model;

/**
 *
 * @author balbali
 */
public class annuaire {

    private Integer id;
    private String num;
    private String nom;
    private String adresse;

    /**
     *
     * @return
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     *
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public String getNum() {
        return num;
    }

    /**
     *
     * @param num
     */
    public void setNum(String num) {
        this.num = num;
    }
}
