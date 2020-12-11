package br.com.musicas.dao;

import java.util.List;

import br.com.musicas.domain.Artista;

public interface ArtistaDao {

    Artista salvar(Artista artista);
    List<Artista> recuperar();
    Artista recuperarPorID(long id);
    void atualizar(Artista artista);
    void excluir(long id);

}
