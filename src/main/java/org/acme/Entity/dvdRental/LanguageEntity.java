package org.acme.Entity.dvdRental;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "language")
public class LanguageEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue
    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
