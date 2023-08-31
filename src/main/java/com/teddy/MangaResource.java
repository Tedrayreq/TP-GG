package com.teddy;

import io.smallrye.common.constraint.NotNull;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/mangas")
public class MangaResource {

    @Inject
    MangaRepository mangaRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MangaEntity> getMangas() { return mangaRepository.findAll().list(); }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@NotNull MangaEntity mangaEntity) {
        mangaRepository.persist(mangaEntity);
        return Response.status(Response.Status.CREATED).build();
    }
}
