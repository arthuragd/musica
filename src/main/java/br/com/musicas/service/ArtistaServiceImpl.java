package br.com.musicas.service;

import br.com.musicas.dao.ArtistaDao;
import br.com.musicas.domain.Artista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArtistaServiceImpl implements ArtistaService {

    @Autowired
    private ArtistaDao artistaDao;

    @Override
    public Artista salvar(Artista artista) {
        artistaDao.salvar(artista);
        return artista;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Artista> recuperar() {
        return artistaDao.recuperar();
    }

    @Override
    @Transactional(readOnly = true)
    public Artista recuperarPorId(long id) {
        return artistaDao.recuperarPorID(id);
    }

    @Override
    public void atualizar(Artista artista) {
        artistaDao.atualizar(artista);
    }

    @Override
    public void excluir(long id) {
        artistaDao.excluir(id);
    }

}

