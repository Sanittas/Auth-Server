package com.sanittas.AuthServer.controller;

import com.sanittas.AuthServer.services.EmpresaService;
import com.sanittas.AuthServer.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;
    private final EmpresaService empresaService;

    @PostMapping("/login/usuario")
    public ResponseEntity<LoginDtoResponseUsuario> loginUsuario(@RequestBody LoginDtoRequest loginDto) {
        try{
        LoginDtoResponseUsuario response = usuarioService.login(loginDto);
        return ResponseEntity.ok(response);
        }
        catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    @PostMapping("/login/empresa")
    public ResponseEntity<LoginDtoResponseEmpresa> loginEmpresa(@RequestBody LoginDtoRequest loginDto) {
        try{
        LoginDtoResponseEmpresa response = empresaService.login(loginDto);
        return ResponseEntity.ok(response);
        }
        catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

}
