package com.example.danielprojetodb3.domain.service;

import java.util.List;

public interface ICrudService<Request,Response> {
    List<Response> obterTodos();
    Response obterPorId(Long id);
    Response cadastrar(Request dto);
    Response atualizar(Long id, Request dto);
    void deletar(Long id);
}
