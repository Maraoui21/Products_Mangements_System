package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Dao<T>{
    Boolean addOne(T o);
    Boolean Remove(T o);
    T finOne(T o);
    ArrayList<T> findAll();
}
