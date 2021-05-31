package model;

/**
 *
 * @author victo
 */
public class Movie {
    
    private String name;
    private String description;
    private String publicationYear;
    
    Movie(String _name, String _desc, String _publicY){
        this.name=_name;
        this.description=_desc;
        this.publicationYear=_publicY;
    }
    
    Movie(){
     this("","","");   
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
    
}
