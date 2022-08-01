package br.com.tiacademy.vendas.repository;

import br.com.tiacademy.vendas.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository <Anime,Long> {



}
