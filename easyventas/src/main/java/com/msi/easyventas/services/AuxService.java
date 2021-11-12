package com.msi.easyventas.services;

import com.msi.easyventas.dtos.EmpleadoResponseDTO;
import com.msi.easyventas.models.*;
import com.msi.easyventas.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.Normalizer;
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
    @Autowired
    MetodoEntregaRepository entregaRepository;
    @Autowired
    MetodoPagoRepository pagoRepository;

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

    public List<FormaEntrega> findAllFormaEntrega(){
        List<FormaEntrega> entregas = entregaRepository.findAll();
        return entregas;
    }

    public List<MetodoPago> findAllMetodoPago(){
        List<MetodoPago> pagos = pagoRepository.findAll();
        return pagos;
    }
}
