package com.teddy;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/mangas")
public class MangaResource {

    @Inject
    MangaRepository mangaRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<MangaEntity> getMangas() { return mangaRepository.findAll().list(); }
}
