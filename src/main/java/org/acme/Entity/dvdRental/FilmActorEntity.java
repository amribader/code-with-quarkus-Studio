package org.acme.Entity.dvdRental;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "film_actor")
@Getter
//@IdClass(FilmActorId.class) //chiave primaria composta
public class FilmActorEntity extends PanacheEntityBase {

    @Id
    @Column(name = "film_id")
    private Long filmId;

    @Id
    @Column(name = "actor_id")
    private Long actorId;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
