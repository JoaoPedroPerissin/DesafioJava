package br.com.tiacademy.vendas.controller;

import br.com.tiacademy.vendas.domain.Anime;
import br.com.tiacademy.vendas.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/Animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> listar() {

        var vendedores = animeService.listar();

        return ResponseEntity.ok(vendedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> especifico(@PathVariable("id") Long id) {

        var resultado = animeService.porId(id);

        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Anime> criar(@RequestBody Anime anime) {
        var salvo = animeService.criar(anime);

        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anime> editar(@PathVariable("id") Long id, @RequestBody Anime anime) {
        return  ResponseEntity.ok(animeService.editar(id, anime));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        animeService.excluir(id);
        return  ResponseEntity.ok().build();
    }
}
