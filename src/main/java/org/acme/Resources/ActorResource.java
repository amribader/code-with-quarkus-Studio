package org.acme.Resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.acme.ActorDTO;
import org.acme.ActorMapper;
import org.acme.Entity.dvdRental.ActorEntity;
import org.acme.FilmMapper;
import org.acme.Repository.ActorRepository;
import org.acme.Service.ActorService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.net.URI;
import java.util.List;
@Slf4j
@Path("/actor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//controller
public class ActorResource {

    @Inject
    ActorRepository personRepository;
//nel controller non si inietta la repository, ma il service

    @Inject
    ActorService actorService;

    @Inject
    ActorMapper actorMapper;

    @GET
    public List<ActorEntity> getAllActors() {
        return actorService.getAllActors();
    }

//    @GET
//    public List<ActorEntity> getAllActors() {
//        return personRepository.listAll();
//    }

    @GET
    @Path("/count")
    public long count() {
        return personRepository.count();
    }

    @GET
    @Path("/{id}")
    public ActorEntity get(Long id) {
        return ActorEntity.findById(id);
    }

//    @POST
//    @Transactional
//    public Response create(@RequestBody ActorDTO actor) {
//        log.info(String.valueOf(actor));
//        //log.info(actor.getFirst_name());
//        ActorEntity actorEntity = actorMapper.toEntity(actor);
//        actorEntity.persist();
//        //actor.persist();
//        log.info("1"+String.valueOf(actorEntity));
//        log.info("3"+String.valueOf(actor));
//        return Response.created(URI.create("/actors/" + actorEntity.getId())).build();
//    }

    @POST
    @Transactional
    public Response create(@RequestBody ActorDTO actor) {
        return Response.created(URI.create("/actors/" + actorService.create(actor).getId())).build();
    }

//    @GET
//    @Path("/search")
//    public List<ActorEntity> searchByName(@QueryParam("name") String name) {
//        return actorRepository.searchByName(name);
//    }

    @GET
    @Path("/search/")
    public List<ActorEntity> searchByName(@QueryParam("name") String name) {
        return personRepository.searchByName(name);
    }

//    @PUT
//    @Path("/{id}")
//    @Transactional
//    public ActorEntity update(Long id, ActorEntity person) {
//        ActorEntity entity = ActorEntity.findById(id);
//        if (entity == null) {
//            throw new NotFoundException();
//        }
//
//        // map all fields from the person parameter to the existing entity
//        entity.getFirst_name() = person.getFirst_name();
//        entity = person;
//        return entity;
//    }

}
