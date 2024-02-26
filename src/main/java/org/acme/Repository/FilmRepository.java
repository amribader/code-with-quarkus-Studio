package org.acme.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Entity.dvdRental.FilmEntity;

@ApplicationScoped
public class FilmRepository implements PanacheRepository<FilmEntity> {
    public long countFilms() {
        return count();
    }

}

