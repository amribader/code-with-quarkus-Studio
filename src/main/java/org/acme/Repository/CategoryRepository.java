package org.acme.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Entity.dvdRental.CategoryEntity;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<CategoryEntity> {
}
