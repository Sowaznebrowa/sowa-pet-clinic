package com.sowaznebrowa.sowapetclinic.services.map;

import com.sowaznebrowa.sowapetclinic.model.Owner;
import com.sowaznebrowa.sowapetclinic.model.Pet;
import com.sowaznebrowa.sowapetclinic.services.OwnerService;
import com.sowaznebrowa.sowapetclinic.services.PetService;
import com.sowaznebrowa.sowapetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    private PetTypeService petTypeService;

    private PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object){

        if(object != null){
            if (object.getPets() != null) {
                object.getPets().forEach(pet ->{
                    if (pet.getPetType() != null){
                        if (pet.getPetType().getId() != null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is Required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }
    }
}
