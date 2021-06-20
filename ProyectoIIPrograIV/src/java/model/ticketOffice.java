package model;

/**
 *
 * @author victo
 */
public class ticketOffice {

    private String id;
    private int occupied;
    private double total;

    public ticketOffice(String _id, int occup) {
        this.id = _id;
        this.occupied = occup;
        this.total = 0.0;
    }
    
    public ticketOffice(String _id, int occup, double to) {
        this.id = _id;
        this.occupied = occup;
        this.total = to;
    }

    public ticketOffice(String _id) {
        this.id = _id;
        this.occupied = 1;
        this.total = 0.0;
    }

    public ticketOffice() {
        this("", 0);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
