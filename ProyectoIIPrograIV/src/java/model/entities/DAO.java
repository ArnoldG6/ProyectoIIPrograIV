package model.entities;

import java.util.HashMap;
/**
 *
 * @author GONCAR4
 */
public interface DAO<K, V> { // DAO (Data Access Object Interface)

    public HashMap<K,V> listAll();

    // CRUD         (IMEC)
    // C(reate)     I(nsertar)
    // R(etrieve)   C(onsultar)
    // U(pdate)     M(odificar)
    // D(elete)     E(liminar)
    
    public void add(K id, V value);

    public V recover(K id,K pass);

    public void update(K id, V value);

    public void delete(K id);

}
