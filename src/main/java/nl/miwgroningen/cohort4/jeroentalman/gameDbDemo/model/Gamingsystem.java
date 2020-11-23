package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 *
 * model for object System (gaming systems/platforms)
 */

@Entity
public class Gamingsystem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer systemId;

    private String name;

    private Integer year;

    private String logoUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manufacturerId", referencedColumnName = "manufacturerId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "gamingsystem")
    private List<Game> myGames;

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        if (year < 1970) {
            throw new IllegalArgumentException("Year founded must be 1970 or greater");
        }
        this.year = year;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<Game> getMyGames() {
        return myGames;
    }

    public void setMyGames(List<Game> myGames) {
        this.myGames = myGames;
    }

    public int getNumberOfGames() {
        return myGames.size();
    }

    public String toString() {
        return String.format("Name system: %s, released in year: %d", this.name, this.year);
    }
}
