package org.example.controller;

import org.example.repo.RepositoryInMemory;
public class Controller {
    RepositoryInMemory repository;

    public Controller(RepositoryInMemory repository) {
        this.repository = repository;
    }
}
