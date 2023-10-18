/*
 * Copyright (c) 2023. Departamento de Ingenieria de Sistemas y Computacion, Universidad Catolica del Norte.
 */

package cl.ucn.disc.as.conserjeria;

import cl.ucn.disc.as.conserjeria.dao.BuildingFinder;
import cl.ucn.disc.as.conserjeria.model.Apartment;
import cl.ucn.disc.as.conserjeria.model.Building;
import cl.ucn.disc.as.conserjeria.model.Contract;
import cl.ucn.disc.as.conserjeria.model.Owner;
import io.ebean.DB;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The Main.
 * @author Rey Valdes
 */
@Slf4j
public final class Main {
    /**
     * The Main constr.
     * @param args to use.
     */
    public static void main(String[] args) {

        Owner owner = Owner.builder()
                .rut("20416699-4")
                .name("Pepe")
                .lastname("Grillo")
                .email("pepito.el.grillo@alumnos.ucn.cl")
                .phone("+56958157708")
                .build();

        Contract contract = Contract.builder()
                .Id(1)
                .paymentDate(new Date())
                .owner(owner)
                .build();

        List<Apartment> apartments = new ArrayList<>();

        Apartment apartment = Apartment.builder()
                .number(15)
                .floorName("Piso catorce")
                .contract(contract)
                .build();
        apartments.add(apartment);

        apartment = Apartment.builder()
                .number(7)
                .floorName("Piso ocho")
                .build();
        apartments.add(apartment);

        Building building = Building.builder()
                .name("Hotel Ibis Budget")
                .address("14 de febrero 1630")
                .apartments(apartments)
                .build();

        Database db = DB.getDefault();
        db.save(owner);
        db.save(contract);
        db.save(building);
        System.out.println(db.json());

        BuildingFinder buildingFinder = new BuildingFinder();

        String addressToSearch = "14 de febrero 1630"; // Reemplaza con la dirección que deseas buscar

        Optional<Building> buildingOptional = buildingFinder.byAddress(addressToSearch);

        if (buildingOptional.isPresent()) {
            Building build1 = buildingOptional.get();
            System.out.println("Edificio encontrado: " + build1.getName());
        } else {
            System.out.println("No se encontró ningún edificio con la dirección: " + addressToSearch);
        }
    }
}
