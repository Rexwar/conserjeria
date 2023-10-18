/*
 * Copyright (c) 2023. Departamento de Ingenieria de Sistemas y Computacion, Universidad Catolica del Norte.
 */

package cl.ucn.disc.as.conserjeria.dao;

import cl.ucn.disc.as.conserjeria.model.Owner;
import cl.ucn.disc.as.conserjeria.model.query.QOwner;
import io.ebean.Finder;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class OwnerFinder extends Finder<Long, Owner> {
    /**
     * The constructor.
     */
    public OwnerFinder() {
        super(Owner.class);
    }

    /**
     * Find an owner by rut.
     *
     * @param rut to use.
     * @return the owner.
     */
    public Optional<Owner> byRut(@NotNull String rut) {
        return new QOwner().rut.eq(rut).findOneOrEmpty();
    }
}
