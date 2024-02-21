package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Entity.dvdRental.ActorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class ActorRepository implements PanacheRepositoryBase<ActorEntity, Integer> {
}
