package com.sowaznebrowa.sowapetclinic.services.map;

import com.sowaznebrowa.sowapetclinic.model.Speciality;
import com.sowaznebrowa.sowapetclinic.model.Vet;
import com.sowaznebrowa.sowapetclinic.services.SpecialityService;
import com.sowaznebrowa.sowapetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    @Autowired
    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

}
