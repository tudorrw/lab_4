package org.example.repo.databaseRepo;

import org.example.database.IDatabase;
import org.example.repo.IRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBRepository<T> implements IRepository<T> {
    private final IDatabase<T> database;

    public DBRepository(IDatabase<T> database) {
        this.database = database;
    }

    @Override
    public ArrayList<T> getObjects() {
        return database.getObjects();
    }

    @Override
    public void save(T Entity) {
        database.add(Entity);
    }

    @Override
    public void update(T Entity, String action) {

    }

    @Override
    public void delete(T Entity) {
        database.remove(Entity);
    }
}
