/*
 * Copyright (c) 2023. Departamento de Ingenieria de Sistemas y Computacion, Universidad Catolica del Norte.
 */

package cl.ucn.disc.as.conserjeria.dao;

import cl.ucn.disc.as.conserjeria.model.Building;
import cl.ucn.disc.as.conserjeria.model.query.QBuilding;
import io.ebean.Finder;

import java.util.Optional;

public class BuildingFinder extends Finder<Long, Building> {
    /**
     * The constructor.
     */
    public BuildingFinder() {
        super(Building.class);
    }

    /**
     * Find a building by address.
     * @param address to use.
     * @return the building.
     */
    public Optional<Building> byAddress(String address) {
        return new QBuilding().address.eq(address).findOneOrEmpty();
    }
}
