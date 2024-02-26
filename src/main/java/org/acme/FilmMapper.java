package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Entity.dvdRental.FilmEntity;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class FilmMapper {

    private final ModelMapper modelMapper;

    public FilmMapper() {
        this.modelMapper = new ModelMapper();
    }

    public FilmDTO toDTO(FilmEntity filmEntity) {
        return modelMapper.map(filmEntity, FilmDTO.class);
    }

    public FilmEntity toEntity(FilmDTO filmDTO) {
        return modelMapper.map(filmDTO, FilmEntity.class);
    }
}
