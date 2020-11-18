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
    private List<System> mySystems;

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

    public List<System> getMySystems() {
        return mySystems;
    }

    public void setMySystems(List<System> mySystems) {
        this.mySystems = mySystems;
    }

    public int getNumberOfSystems() {
        return mySystems.size();
    }
}
