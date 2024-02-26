package org.acme.Resources;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.acme.Entity.dvdRental.FilmEntity;
import org.acme.FilmDTO;
import org.acme.FilmMapper;
import org.acme.Repository.FilmRepository;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Slf4j
@Path("/films")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class FilmResource {

    @Inject
    FilmRepository filmRepository;

    @Inject
    FilmMapper filmMapper;

//    @POST
//    @Transactional
//    public Response create(FilmDTO filmDTO) {
//        Log.info(filmDTO);
//        System.out.println(filmDTO);
//        FilmEntity filmEntity = filmMapper.toEntity(filmDTO);
//        System.err.println(filmEntity);
//        filmRepository.persist(filmEntity);
//        return Response.status(Response.Status.CREATED).entity(filmMapper.toDTO(filmEntity)).build();
//    }

    @POST
    @Transactional
    public Response create(FilmEntity film) {
        film.persist();
        return Response.created(URI.create("/films/" + film.getFilmId())).build();
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

    @GET
    @Path("/{id}")
    public FilmDTO getFilmById(@PathParam("id") Long id) {
        FilmEntity filmEntity = filmRepository.findById(id);
        if (filmEntity == null) {
            throw new NotFoundException("Film not found");
        }
        return filmMapper.toDTO(filmEntity);
    }

    //non funziona
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteFilm(@PathParam("id") Long id) {
        FilmEntity filmEntity = filmRepository.findById(id);
        System.err.println(filmEntity);
        if (filmEntity == null) {
            throw new NotFoundException("Film not found");
        }
        filmRepository.deleteById(id);
        return Response.noContent().build();
    }



}
