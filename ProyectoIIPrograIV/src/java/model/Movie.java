package model;

import java.util.HashMap;

/**
 *
 * @author victo
 */
public class Movie {

    private String id;
    private String name;
    private String description;
    private String publicationYear;
    private String director;
    private HashMap<String, Projections> projections;

    public Movie(String _id, String _name, String _desc, String _publicY, String direct) {
        this.id = _id;
        this.name = _name;
        this.description = _desc;
        this.publicationYear = _publicY;
        this.director = direct;
        this.projections=new HashMap<>();
    }

    public Movie() {
        this("", "", "", "", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Projections> getProjections() {
        return projections;
    }

    public void setProjections(HashMap<String, Projections> projections) {
        this.projections = projections;
    }

}
