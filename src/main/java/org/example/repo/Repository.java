package org.example.repo;
import java.util.List;
public interface Repository<T, ID> {
    T getById(ID id);

    List<T> getObjects();

    void save(T entity);

    void update(T entity);

    void delete(ID id);
}
