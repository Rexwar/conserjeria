/*
 * Copyright (c) 2023. Departamento de Ingenieria de Sistemas y Computacion, Universidad Catolica del Norte.
 */

package cl.ucn.disc.as.conserjeria.model;

import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.Instant;

@ToString
@MappedSuperclass
public abstract class BaseModel {
    /**
     * The id.
     */
    @Getter
    @Setter
    @Id
    private Long id;

    /**
     * The version.
     */
    @Getter
    @Setter
    @Version
    private Long version;

    /**
     * Creation date.
     */
    @Getter
    @Setter
    @WhenCreated
    private Instant created;

    /**
     * Modified date.
     */
    @Getter
    @Setter
    @WhenModified
    private Instant modified; /* hora min seg ?? */
}
