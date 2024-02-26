package org.acme.Entity.dvdRental;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "Actor")
@Getter
@Setter
@ToString
public class ActorEntity extends PanacheEntityBase {
    //actor_id, first_name, last_name, last_update
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", unique = true, nullable = false)
    private int id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @CreationTimestamp
    @Column(name = "last_update")
    private Timestamp last_update;
}
