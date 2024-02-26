package org.acme.Resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Entity.dvdRental.FilmEntity;
import org.acme.FilmDTO;
import org.acme.FilmMapper;
import org.acme.Repository.FilmRepository;

import java.util.List;
import java.util.stream.Collectors;

@Path("/films")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class FilmResource {

    @Inject
    FilmRepository filmRepository;

    @Inject
    FilmMapper filmMapper;

    @POST
    @Transactional
    public Response create(FilmDTO filmDTO) {
        FilmEntity filmEntity = filmMapper.toEntity(filmDTO);
        filmRepository.persist(filmEntity);
        return Response.status(Response.Status.CREATED).entity(filmMapper.toDTO(filmEntity)).build();
    }

    @GET
    public List<FilmDTO> getAllFilms() {
        return filmRepository.findAll().stream()
                .map(filmMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/count")
    public long countFilms() {
        return filmRepository.countFilms();
    }

    //non funziona
//    @DELETE
//    @Path("/{id}")
//    @Transactional
//    public Response deleteFilm(@PathParam("id") Long id) {
//        FilmEntity filmEntity = filmRepository.findById(id);
//        //if (filmEntity == null) {
//        //    throw new NotFoundException("Film not found");
//        //}
//        filmEntity.delete();
//        return Response.noContent().build();
//    }


}
