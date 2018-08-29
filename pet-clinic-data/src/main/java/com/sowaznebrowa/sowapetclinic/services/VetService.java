package com.sowaznebrowa.sowapetclinic.services;

import com.sowaznebrowa.sowapetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
