package com.sanittas.AuthServer.controller;

public record LoginDtoResponseUsuario(
        Integer id,
        String nome,
        String username,
        String token,
        String cpf,
        String telefone
) {
}
