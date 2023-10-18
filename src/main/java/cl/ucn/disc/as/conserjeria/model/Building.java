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
import javax.persistence.OneToMany;
import java.util.List;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Building extends BaseModel {
    /**
     * Building name.
     */
    @Getter
    @NotNull
    private String name;

    /**
     * Building address.
     */
    @Getter
    @NotNull
    private String address;

    /**
     * Building apartments.
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<Apartment> apartments;
}
