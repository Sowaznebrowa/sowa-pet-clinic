package com.sowaznebrowa.sowapetclinic.services.map;

import com.sowaznebrowa.sowapetclinic.model.Vet;
import com.sowaznebrowa.sowapetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
}
