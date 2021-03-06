package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Jeroen Talman ( mail: j.k.talman@st.hanze.nl )
 *
 * Model for object Manufacturer of gamingsystems
 */

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer manufacturerId;

    private String name;

    private Integer yearFounded;

    private Boolean active = false;

    private String logoUrl;

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
        if (yearFounded < 1880) {
            throw new IllegalArgumentException("Year founded must be 1880 or greater");
        }
        this.yearFounded = yearFounded;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<Gamingsystem> getMyGamingsystems() {
        return myGamingsystems;
    }

    public void setMyGamingsystems(List<Gamingsystem> myGamingsystems) {
        this.myGamingsystems = myGamingsystems;
    }

    public Integer getNumberOfSystems() {
        return myGamingsystems.size();
    }

    public String toString() {
        return String.format("name: %s, founded in: %d, still active: %s", this.name, this.yearFounded, this.active);
    }
}
