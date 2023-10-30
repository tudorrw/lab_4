package org.example.repo;
import java.util.List;
public interface Repository<T> {

    List<T> getObjects();

    void save(T entity);

//    void update(T entity);

    void delete(T object);
}
