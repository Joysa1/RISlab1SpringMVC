package com.example.lab1.Repos;

import com.example.lab1.Docs.Apartaments;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ApartamentsRepository extends MongoRepository<Apartaments, String> {
    Apartaments findByOwner(String owner);
    List<Apartaments> findByAddress(String Address);
    Apartaments findBy_Id(String id);
}
