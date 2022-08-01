package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.domain.Anime;
import br.com.tiacademy.vendas.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public List<Anime> listar() {
        return animeRepository.findAll();
    }

    public Anime porId(Long id) {
        return animeRepository.findById(id).orElse(null);
    }

    public Anime criar(Anime anime) {
        return animeRepository.save(anime);
    }

    public Anime editar(Long id, Anime editado){
        var recuperado = porId(id);
        if (Objects.isNull(recuperado)) {
            throw new RuntimeException("Não foi encontrado");
        }

        recuperado.setNome(editado.getNome());

        return animeRepository.save(recuperado);
    }

    public void excluir(Long id) {
        animeRepository.deleteById(id);
    }
}
