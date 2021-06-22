package model;

/**
 *
 * @author victo
 */
public class ticketOffice {

    String id;
    String idClient;
    String movie;
    int occupied;
    double total;


    public ticketOffice(String _id, String idClient, String nomMovie, int occup, double to) {
        this.id = _id;
        this.idClient = idClient;
        this.movie = nomMovie;
        this.occupied = occup;
        this.total = to;
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

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
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
