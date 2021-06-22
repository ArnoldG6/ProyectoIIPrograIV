package model;

/**
 *
 * @author victo
 */
public class ticketOffice {

    private String id;
    private String idClient;
    private String moviee;
    private int occupied;
    private double total;

    public ticketOffice(String _id, int occup) {
        this.id = _id;
        this.idClient = "";
        this.moviee = "";
        this.occupied = occup;
        this.total = 0.0;
    }

    public ticketOffice(String _id, String idClient, int occup, double to) {
        this.id = _id;
        this.idClient = idClient;
        this.moviee = "";
        this.occupied = occup;
        this.total = to;
    }

    public ticketOffice(String _id, String idClient, String nomMovie, int occup, double to) {
        this.id = _id;
        this.idClient = idClient;
        this.moviee = nomMovie;
        this.occupied = occup;
        this.total = to;
    }

    public ticketOffice(String _id) {
        this.id = _id;
        this.idClient = "0";
        this.moviee = "";
        this.occupied = 1;
        this.total = 0.0;
    }

    public ticketOffice() {
        this("", "", "", 0, 0.0);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getMoviee() {
        return moviee;
    }

    public void setMoviee(String moviee) {
        this.moviee = moviee;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
