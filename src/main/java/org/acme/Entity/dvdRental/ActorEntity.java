package org.acme.Entity.dvdRental;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name = "Actor")
@Getter
public class ActorEntity extends PanacheEntityBase {
    //actor_id, first_name, last_name, last_update
    @Id
    @GeneratedValue
    @Column(name = "actor_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "last_update")
    private LocalDate last_update;
}
