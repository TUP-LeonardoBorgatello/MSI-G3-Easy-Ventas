package com.msi.easyventas.services;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceResponse<T> {

    private String status;
    private T data;
}
