package com.sanittas.AuthServer.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sanittas.AuthServer.domain.Empresa;
import com.sanittas.AuthServer.domain.Usuario;
import com.sanittas.AuthServer.services.EmpresaService;
import com.sanittas.AuthServer.services.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/cadastrar")
public class CadastroController {
    private final UsuarioService usuarioService;
    private final EmpresaService empresaService;

    @PostMapping("/empresa/")
    public ResponseEntity<Empresa> cadastroEmpresa(@RequestBody @Valid EmpresaCriacaoDto empresa) {
        try {
            log.info("Recebida solicitação para cadastrar uma nova empresa: {}", empresa.razaoSocial());
            Empresa response = empresaService.cadastrar(empresa);
            log.info("Empresa cadastrada com sucesso: {}", empresa.razaoSocial());
            return ResponseEntity.status(201).body(response);
        } catch (ResponseStatusException e) {
            log.error("Erro ao cadastrar empresa: {}", e.getMessage());
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    @PostMapping("/usuario/")
    public ResponseEntity<Usuario> cadastroUsuario(@RequestBody @Valid UsuarioCriacaoDto dados) {
        try {
            Usuario usuario = usuarioService.cadastrar(dados);
            return ResponseEntity.status(201).body(usuario);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode());
        }
    }

}
