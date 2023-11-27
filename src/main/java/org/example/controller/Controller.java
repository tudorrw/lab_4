package org.example.controller;

import org.example.repo.IRepository;

import java.util.ArrayList;

public abstract class Controller<T> implements IController<T> {
    final protected IRepository<T> repository;

    protected Controller(IRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void add(T object) {
        repository.save(object);
    }

    @Override
    public void update(T object) {
//        repository.update();
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }

    @Override
    public ArrayList<T> getAll() {
        return (ArrayList<T>) repository.getObjects();
    }
}
