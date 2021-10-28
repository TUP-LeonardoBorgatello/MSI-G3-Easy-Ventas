package com.msi.easyventas.services;

import com.msi.easyventas.dtos.EmpleadoRequestDTO;
import com.msi.easyventas.dtos.EmpleadoResponseDTO;
import com.msi.easyventas.dtos.LoginRequestDTO;

import java.util.List;

public interface iEmpleadoService {

    List<EmpleadoResponseDTO> findAllEmpleados() throws Exception;

    List<EmpleadoResponseDTO> findEmpleadoByDocumento(int documento) throws Exception;

    void addEmpleado(EmpleadoRequestDTO empleadoRequestDTO) throws Exception;

    void changeEmpleadoStatus(EmpleadoResponseDTO empleadoResponseDTO) throws Exception;

    void updateEmpleado(EmpleadoRequestDTO empleadoRequestDTO) throws Exception;

    void login(LoginRequestDTO loginRequestDTO) throws Exception;
}
