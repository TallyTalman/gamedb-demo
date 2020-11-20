package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * @author Jeroen Talman ( mail: j.k.talman@st.hanze.nl )
 *
 * model for object Game
 */

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gameId;

    private String title;

    private Integer year;

    private String imageUrl;

    private String videoUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genreId", referencedColumnName = "genreId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "developerId", referencedColumnName = "developerId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Developer developer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "publisherId", referencedColumnName = "publisherId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "systemId", referencedColumnName = "systemId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Gamingsystem gamingsystem;

    //getters and setters
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Gamingsystem getGamingsystem() {
        return gamingsystem;
    }

    public void setGamingsystem(Gamingsystem gamingsystem) {
        this.gamingsystem = gamingsystem;
    }

    public String toString() {
        return String.format("%s, %d", this.title, this.year);
    }
}