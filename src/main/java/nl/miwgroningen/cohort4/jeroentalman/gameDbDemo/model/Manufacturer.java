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

    private Integer yearFounded;

    private Boolean active;

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

    public Integer getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(Integer yearFounded) {
        this.yearFounded = yearFounded;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Gamingsystem> getMyGamingsystems() {
        return myGamingsystems;
    }

    public void setMyGamingsystems(List<Gamingsystem> myGamingsystems) {
        this.myGamingsystems = myGamingsystems;
    }

    public int getNumberOfSystems() {
        return myGamingsystems.size();
    }
}
