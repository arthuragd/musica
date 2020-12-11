package br.com.musicas.dao;

import org.springframework.stereotype.Repository;

import br.com.musicas.domain.Artista;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ArtistaDaoImpl implements ArtistaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Artista salvar(Artista artista) {
        em.persist(artista);
        return artista;
    }

    @Override
    public List<Artista> recuperar() {
        return em.createQuery("select p from Artista p", Artista.class).getResultList();
    }

    @Override
    public Artista recuperarPorID(long id) {
        return em.find(Artista.class, id);
    }

    @Override
    public void atualizar(Artista artista) {
        em.merge(artista);
    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(Artista.class, id));
    }
}
