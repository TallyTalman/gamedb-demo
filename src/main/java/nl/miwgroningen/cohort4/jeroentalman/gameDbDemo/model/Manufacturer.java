package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Jeroen Talman ( mail: j.k.talman@st.hanze.nl )
 */

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer manufacturerId;

    private String name;

    @OneToMany(mappedBy = "manufacturer")
    private List<Gamingsystem> myGamingsystems;

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gamingsystem> getMySystems() {
        return myGamingsystems;
    }

    public void setMySystems(List<Gamingsystem> myGamingsystems) {
        this.myGamingsystems = myGamingsystems;
    }

    public int getNumberOfSystems() {
        return myGamingsystems.size();
    }
}
