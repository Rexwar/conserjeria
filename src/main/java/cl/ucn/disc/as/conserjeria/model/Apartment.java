/*
 * Copyright (c) 2023. Departamento de Ingenieria de Sistemas y Computacion, Universidad Catolica del Norte.
 */

package cl.ucn.disc.as.conserjeria.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Apartment extends BaseModel {
    /**
     * Apartment number.
     */
    @NotNull
    private Integer number;

    /**
     * Apartment floor name.
     */
    @NotNull
    private String floorName;

    /**
     * Apartment owner contract.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Contract contract;
}
