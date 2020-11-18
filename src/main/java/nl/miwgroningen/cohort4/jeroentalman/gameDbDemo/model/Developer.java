package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Jeroen Talman ( mail: j.k.talman@st.hanze.nl )
 *
 * model for object Developer (developers of video games)
 */

@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer developerId;

    private String name;

    private Boolean active;

    @OneToMany(mappedBy = "developer")
    private List<Game> myGames;

    //getters and setters
    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
}