package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.acme.ActorDTO;
import org.acme.ActorMapper;
import org.acme.Entity.dvdRental.ActorEntity;
import org.acme.Repository.ActorRepository;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.net.URI;
import java.util.List;
@Slf4j
@ApplicationScoped
public class ActorService {
    @Inject
    ActorRepository personRepository;

    @Inject
    ActorMapper actorMapper;

    public List<ActorEntity> getAllActors() {
        return personRepository.listAll();
    }

    public ActorEntity create(ActorDTO actor) {
        log.info(String.valueOf(actor));
        //log.info(actor.getFirst_name());
        ActorEntity actorEntity = actorMapper.toEntity(actor);
        actorEntity.persist();
        log.info("1"+String.valueOf(actorEntity));
        log.info("3"+String.valueOf(actor));
        return actorEntity;
    }
}
