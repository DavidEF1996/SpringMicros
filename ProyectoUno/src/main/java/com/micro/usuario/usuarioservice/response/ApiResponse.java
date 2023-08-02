package com.micro.usuario.usuarioservice.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private String mensaje;
    private boolean success;
    private HttpStatus status;
}
