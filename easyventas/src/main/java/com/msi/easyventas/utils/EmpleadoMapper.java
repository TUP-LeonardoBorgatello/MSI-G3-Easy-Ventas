package com.msi.easyventas.utils;

import com.msi.easyventas.dtos.ClienteResponseDTO;
import com.msi.easyventas.dtos.EmpleadoResponseDTO;
import com.msi.easyventas.models.Cliente;
import com.msi.easyventas.models.Empleado;

public class EmpleadoMapper {

    public static EmpleadoResponseDTO toDTO(Empleado empleado) {

        EmpleadoResponseDTO empleadoResponseDTO = new EmpleadoResponseDTO();

        empleadoResponseDTO.setApellido(empleado.getApellido());
        empleadoResponseDTO.setNombre(empleado.getNombre());
        empleadoResponseDTO.setDocumento(empleado.getDocumento());
        empleadoResponseDTO.setRolEmpleado(empleado.getRolEmpleado().getDescripcion());
        empleadoResponseDTO.setCiudad(empleado.getCiudad().getDescripcion());
        if (empleado.isEstado()){
            empleadoResponseDTO.setEstado("Activo");
        }
        else{
            empleadoResponseDTO.setEstado("Inactivo");
        }
        empleadoResponseDTO.setDomicilio(empleado.getDomicilio());
        if (empleado.getGenero() == 1)
        {
            empleadoResponseDTO.setGenero("Hombre");
        }
        else if (empleado.getGenero() == 2){
            empleadoResponseDTO.setGenero("Mujer");
        } else if (empleado.getGenero() == 3){
            empleadoResponseDTO.setGenero("Otro");
        }
        empleadoResponseDTO.setTipoDocumento(empleado.getTipoDoc().getDescripcion());

        return empleadoResponseDTO;
    }
}
