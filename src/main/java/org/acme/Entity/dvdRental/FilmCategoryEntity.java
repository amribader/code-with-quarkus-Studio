package org.acme.Entity.dvdRental;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "film_category")
public class FilmCategoryEntity extends PanacheEntityBase {

    @Id//non genero io il valore in questo caso
    @Column(name = "film_id")
    private Long filmId;

    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
