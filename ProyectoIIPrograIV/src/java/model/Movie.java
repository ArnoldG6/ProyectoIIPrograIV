package model;

import java.util.HashMap;

/**
 *
 * @author victo
 */
public class Movie {

    String id;
    String name;
    String description;
    String publicationYear;
    String director;
    String inBillboard;
    String imgLink;
    HashMap<String, Projections> projections;

    public Movie(String _id, String _name, String _desc, String _publicY, String direct,
            String inBillboard, String imgLink) {
        this.id = _id;
        this.name = _name;
        this.description = _desc;
        this.publicationYear = _publicY;
        this.director = direct;
        this.inBillboard = inBillboard; //CARTELERA 
        this.projections=new HashMap<>();
        this.imgLink = imgLink;
    }

    public Movie() {
        this("", "", "", "", "","","");
    }
    @Override
    public String toString(){
        String s = "{";
        s += "id: "+id+", ";
        s += "name: "+name+", ";
        s += "description: "+description+", ";
        s += "publicationYear: "+publicationYear+", ";
        s += "director: "+director+", ";
        s += "inBillboard: "+inBillboard+", ";
        s += "projections: "+" null "+", ";
        s += "imgLink: "+imgLink+"}";
        return s;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getInBillboard() {
        return inBillboard;
    }

    public void setInBillboard(String inBillboard) {
        this.inBillboard = inBillboard;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public HashMap<String, Projections> getProjections() {
        return projections;
    }

    public void setProjections(HashMap<String, Projections> projections) {
        this.projections = projections;
    }

}
