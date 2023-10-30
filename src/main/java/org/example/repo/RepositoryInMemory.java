package org.example.repo;

import java.util.List;

public class RepositoryInMemory<T> {
    private List<T> objects;

    public RepositoryInMemory(List<T> objects) {
        this.objects = objects;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public void addObject(T object){
        objects.add(object);
    }

    public void removeObject(T object){
        objects.remove(object);
    }

    public void updateObject(T object, Object... arguments){
        objects.remove(object);
    }

}