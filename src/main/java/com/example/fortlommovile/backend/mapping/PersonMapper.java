package com.example.fortlommovile.backend.mapping;

import com.example.fortlommovile.backend.domain.model.entity.Person;
import com.example.fortlommovile.backend.resource.Person.PersonResource;
import com.example.fortlommovile.backend.resource.Person.UpdatePersonResource;
import com.example.fortlommovile.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
public class PersonMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public PersonResource toResource(Person model) {
        return mapper.map(model, PersonResource.class);
    }


    public Person toModel(UpdatePersonResource resource) {
        return mapper.map(resource, Person.class);
    }
}
