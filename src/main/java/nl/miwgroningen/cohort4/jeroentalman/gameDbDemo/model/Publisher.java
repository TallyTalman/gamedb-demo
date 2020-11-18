package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Jeroen Talman ( mail: j.k.talman@st.hanze.nl )
 *
 * model for object Publisher (publishers of video games)
 */

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer publisherId;

    private String name;

    private Integer yearFounded;

    private Boolean active;

    @OneToMany(mappedBy = "publisher")
    private List<Game> myGames;

    //getters and setters
    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
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
