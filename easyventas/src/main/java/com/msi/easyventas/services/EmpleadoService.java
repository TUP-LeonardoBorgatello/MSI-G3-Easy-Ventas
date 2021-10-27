package com.msi.easyventas.services;

import com.msi.easyventas.dtos.EmpleadoRequestDTO;
import com.msi.easyventas.dtos.EmpleadoResponseDTO;
import com.msi.easyventas.models.Ciudad;
import com.msi.easyventas.models.Empleado;
import com.msi.easyventas.models.RolEmpleado;
import com.msi.easyventas.models.TipoDoc;
import com.msi.easyventas.repositories.CiudadRepository;
import com.msi.easyventas.repositories.EmpleadoRepository;
import com.msi.easyventas.repositories.RolEmpleadoRepository;
import com.msi.easyventas.repositories.TipoDocRepository;
import com.msi.easyventas.utils.EmpleadoMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmpleadoService implements iEmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    CiudadRepository ciudadRepository;

    @Autowired
    TipoDocRepository tipoDocRepository;

    @Autowired
    RolEmpleadoRepository rolEmpleadoRepository;

    @Override
    public List<EmpleadoResponseDTO> findAllEmpleados() {
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados.stream().map(EmpleadoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void addEmpleado(EmpleadoRequestDTO empleadoRequestDTO) throws Exception {

        if (empleadoRepository.existsByDocumento(empleadoRequestDTO.getDocumento()) || empleadoRequestDTO.getId_rol_empleado() == 1) {
            throw new Exception("El Vendedor ya existe o es Administrador.");
        } else {
            Ciudad ciudad = ciudadRepository.findById(empleadoRequestDTO.getId_ciudad()).orElseThrow();
            TipoDoc tipoDoc = tipoDocRepository.findById(empleadoRequestDTO.getId_tipo_doc()).orElseThrow();
            RolEmpleado rolEmpleado = new RolEmpleado();
            rolEmpleado.setId(2);

            Empleado empleado = new Empleado();

            empleado.setDocumento(empleadoRequestDTO.getDocumento());
            empleado.setGenero(empleadoRequestDTO.getGenero());
            empleado.setRolEmpleado(rolEmpleado);
            empleado.setApellido(empleadoRequestDTO.getApellido());
            empleado.setCiudad(ciudad);
            empleado.setEstado(empleadoRequestDTO.getEstado());
            empleado.setNombre(empleadoRequestDTO.getNombre());
            empleado.setDomicilio(empleadoRequestDTO.getDomicilio());
            empleado.setTipoDoc(tipoDoc);

            empleadoRepository.save(empleado);
        }
    }

    @Override
    public List<EmpleadoResponseDTO> findEmpleadoByDocumento(int documento) throws Exception {
        List<Empleado> empleados = existEmpleadoByDocumento(documento);
        for (Empleado e : empleados) {
            if (e.getDocumento() != documento) {
                throw new NotFoundException("El vendedor no se encuentra en el sistema.");
            }
        }

        return empleados.stream().map(EmpleadoMapper::toDTO).collect(Collectors.toList());
    }

    public List<Empleado> existEmpleadoByDocumento(int documento) {
        return empleadoRepository.searchByDocumento(documento);
    }

    @Override
    public void changeEmpleadoStatus(EmpleadoResponseDTO empleado) throws Exception {
        if (empleadoRepository.existsByDocumento(empleado.getDocumento()) && !Objects.equals(empleado.getRolEmpleado(), "Administrador")) {
            List<Empleado> empleados = empleadoRepository.searchByDocumento(empleado.getDocumento());
            for (Empleado e : empleados) {
                empleadoRepository.updateEmpleadoStatus(e.getId());
            }
        } else {
            throw new Exception("No se puede modificar el estado del vendedor no existe o es un administrador.");
        }
    }

    @Override
    public void updateEmpleado(EmpleadoRequestDTO empleadoRequestDTO) throws Exception {
        if (empleadoRequestDTO.getDocumento() != 0) {
            List<Empleado> empleados = empleadoRepository.searchByDocumento(empleadoRequestDTO.getDocumento());
            if (empleadoRepository.existsByDocumento(empleadoRequestDTO.getDocumento()) && empleadoRequestDTO.getId_rol_empleado() != 1) {
                for (Empleado empleado : empleados) {
                    Ciudad ciudad = ciudadRepository.findById(empleadoRequestDTO.getId_ciudad()).orElseThrow();
                    TipoDoc tipoDoc = tipoDocRepository.findById(empleadoRequestDTO.getId_tipo_doc()).orElseThrow();
                    RolEmpleado rolEmpleado = rolEmpleadoRepository.findById(empleadoRequestDTO.getId_rol_empleado()).orElseThrow();

                    empleado.setDocumento(empleadoRequestDTO.getDocumento());
                    empleado.setGenero(empleadoRequestDTO.getGenero());
                    empleado.setRolEmpleado(rolEmpleado);
                    empleado.setApellido(empleadoRequestDTO.getApellido());
                    empleado.setCiudad(ciudad);
                    empleado.setEstado(empleadoRequestDTO.getEstado());
                    empleado.setNombre(empleadoRequestDTO.getNombre());
                    empleado.setDomicilio(empleadoRequestDTO.getDomicilio());
                    empleado.setTipoDoc(tipoDoc);
                    empleadoRepository.save(empleado);
                }
            } else {
                throw new Exception("No existe el vendedor o es Administrador.");
            }
        } else {
            throw new Exception("No existe el vendedor. Se requiere el documento.");
        }
    }
}
