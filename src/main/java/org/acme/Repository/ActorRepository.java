package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Entity.dvdRental.ActorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.List;

@ApplicationScoped
public class ActorRepository implements PanacheRepositoryBase<ActorEntity, Integer> {

    public List<ActorEntity> searchByName(String name) {
        // Utilizza il metodo find di PanacheRepository per trovare tutti gli attori che corrispondono al nome
        return find("first_name", name).list();
    }

}
