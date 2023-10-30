package org.example.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T, ID> implements Repository<T, ID>{
    private Map<ID, T> objects = new HashMap<>();

    @Override
    public T getById(ID id) {
        return objects.get(id);
    }

    @Override
    public List<T> getObjects() {
        return List.copyOf(objects.values());
    }

    @Override
    public void save(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(ID id) {
        objects.remove(id);
    }
}
