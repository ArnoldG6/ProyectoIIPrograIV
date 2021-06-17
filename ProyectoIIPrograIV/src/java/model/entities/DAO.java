package model.entities;
import java.util.HashMap;
public interface DAO<K, V> { // DAO (Data Access Object Interface)
    public HashMap<K,V> listAll();
    public void add(K id, V value);
    public V recover(K id,K pass);
    public void update(K id, V value);
    public void delete(K id);
    static final String path = "jdbc:mysql://localhost:3306/cinema?useSSL=false";
}
