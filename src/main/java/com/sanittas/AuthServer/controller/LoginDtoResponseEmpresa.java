package com.sanittas.AuthServer.controller;

public record LoginDtoResponseEmpresa(
        Integer id,
        String razao_social,
        String username,
        String token
) {
}
