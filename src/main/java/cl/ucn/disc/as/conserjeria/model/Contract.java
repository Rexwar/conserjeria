/*
 * Copyright (c) 2023. Departamento de Ingenieria de Sistemas y Computacion, Universidad Catolica del Norte.
 */

package cl.ucn.disc.as.conserjeria.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Contract extends BaseModel {
    /**
     * The id.
     */
    @NotNull
    private Integer Id;

    /**
     * Common expenses payment date.
     */
    @Getter
    @NotNull
    private Date paymentDate;

    /**
     * Contract owner.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Owner owner;

}
