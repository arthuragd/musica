package br.com.musicas.service;

import java.util.List;

import br.com.musicas.domain.Artista;

public interface ArtistaService {

    Artista salvar(Artista artista);
    List<Artista> recuperar();
    Artista recuperarPorId(long id);
    void atualizar(Artista artista);
    void excluir(long id);

}
