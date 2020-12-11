package br.com.musicas.dao;

import java.util.List;

import br.com.musicas.domain.Playlist;

public interface PlaylistDao {

    void salvar(Playlist playlist);
    List<Playlist> recuperar();
    Playlist recuperarPorID(long id);
    void atualizar(Playlist playlist);
    void excluir(long id);

}
