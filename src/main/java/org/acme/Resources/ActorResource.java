package org.acme.Resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Entity.dvdRental.ActorEntity;
import org.acme.Repository.ActorRepository;

import java.net.URI;
import java.util.List;

@Path("/actor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActorResource {

    @Inject
    ActorRepository personRepository;

    @GET
    public List<ActorEntity> getAllActors() {
        return personRepository.listAll();
    }

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

    @POST
    @Transactional
    public Response create(ActorEntity actor) {
        actor.persist();
        return Response.created(URI.create("/actors/" + actor.getId())).build();
    }

    @GET
    @Path("/search/{name}")
    public ActorEntity search(String name) {
        return actorr
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
