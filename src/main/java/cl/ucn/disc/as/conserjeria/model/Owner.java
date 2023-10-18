/*
 * Copyright (c) 2023. Departamento de Ingenieria de Sistemas y Computacion, Universidad Catolica del Norte.
 */

package cl.ucn.disc.as.conserjeria.model;

import cl.ucn.disc.as.conserjeria.model.exception.IllegalDomainException;
import cl.ucn.disc.as.conserjeria.util.ValidationUtil;
import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;

@ToString(callSuper = true)
@AllArgsConstructor
@Entity
@Builder
public class Owner extends BaseModel {
    /**
     * Owner's RUT.
     */
    @NotNull
    private String rut;

    /**
     * Owner's name.
     */
    @NotNull
    private String name;

    /**
     * Owner's lastname.
     */
    @NotNull
    private String lastname;

    /**
     * Owner's email.
     */
    @NotNull
    private String email;

    /**
     * Owner's phone.
     */
    @NotNull
    private String phone;


    public static class OwnerBuilder {

        /**
         * @return the owner.
        */
        public Owner build() throws IllegalDomainException {
            // validate the rut
            if (!ValidationUtil.isRutValid(this.rut)) {
                throw new IllegalDomainException("Invalid RUT: " + this.rut);
            }

            // validate the email
            if (!ValidationUtil.isEmailValid(this.email)) {
                throw new IllegalDomainException("Invalid email: " + this.email);
            }

            return new Owner(this.rut, this.name, this.lastname, this.email, this.phone);
        }
    }


}
