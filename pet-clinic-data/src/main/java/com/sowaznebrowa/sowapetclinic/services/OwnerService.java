package com.sowaznebrowa.sowapetclinic.services;

import com.sowaznebrowa.sowapetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
