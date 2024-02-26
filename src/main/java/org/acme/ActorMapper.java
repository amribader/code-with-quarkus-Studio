package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Entity.dvdRental.ActorEntity;
import org.acme.Entity.dvdRental.FilmEntity;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ActorMapper {
    private final ModelMapper modelMapper;


    public ActorMapper() {
        this.modelMapper = new ModelMapper();
    }

    public ActorDTO toDTO(ActorEntity actorEntity) {
        return modelMapper.map(actorEntity, ActorDTO.class);
    }

//    public ActorEntity toEntity(ActorDTO actorDTO) {
//        return modelMapper.map(actorDTO, ActorEntity.class);
//    }

    public ActorEntity toEntity(ActorDTO actorDTO) {
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setFirst_name(actorDTO.getFirstName());
        actorEntity.setLast_name(actorDTO.getLastName());
        return actorEntity;
    }

}
