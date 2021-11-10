package com.msi.easyventas.services;

import com.msi.easyventas.dtos.EmpleadoResponseDTO;
import com.msi.easyventas.models.Ciudad;
import com.msi.easyventas.models.Empleado;
import com.msi.easyventas.models.TipoDoc;
import com.msi.easyventas.repositories.CiudadRepository;
import com.msi.easyventas.repositories.EmpleadoRepository;
import com.msi.easyventas.repositories.TipoDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuxService {

    @Autowired
    TipoDocRepository tipoDocRepository;
    @Autowired
    CiudadRepository ciudadRepository;
    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<TipoDoc> findAllTipoDoc() {
        List<TipoDoc> tipoDocs = tipoDocRepository.findAll();
        return tipoDocs;
    }

    public List<Ciudad> findAllCiudad() {
        List<Ciudad> ciudades = ciudadRepository.findAll();
        return ciudades;
    }

    public List<Empleado> findAllEmpleadosWithId(){
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados;
    }
}
