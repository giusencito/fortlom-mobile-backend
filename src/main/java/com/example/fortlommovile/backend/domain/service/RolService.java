package com.example.fortlommovile.backend.domain.service;
import com.example.fortlommovile.backend.domain.model.entity.Rol;
import com.example.fortlommovile.backend.domain.model.enumeration.RolName;

import java.util.List;
import java.util.Optional;
public interface RolService {

    Optional<Rol> findByName(RolName name);

    void seed();

    List<Rol> getAll();
}
