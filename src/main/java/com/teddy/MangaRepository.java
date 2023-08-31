package com.teddy;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MangaRepository implements PanacheMongoRepository<MangaEntity> {
}
