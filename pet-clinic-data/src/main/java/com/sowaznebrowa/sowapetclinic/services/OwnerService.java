package com.sowaznebrowa.sowapetclinic.services;

import com.sowaznebrowa.sowapetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
