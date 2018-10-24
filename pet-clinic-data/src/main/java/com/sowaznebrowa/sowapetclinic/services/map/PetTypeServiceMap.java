package com.sowaznebrowa.sowapetclinic.services.map;

import com.sowaznebrowa.sowapetclinic.model.PetType;
import com.sowaznebrowa.sowapetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService {

}
