package com.sowaznebrowa.sowapetclinic.services.map;

import com.sowaznebrowa.sowapetclinic.model.Speciality;
import com.sowaznebrowa.sowapetclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality,Long> implements SpecialitiesService {
}
