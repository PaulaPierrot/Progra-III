package com.tpo.demo.controller;

import com.tpo.demo.model.Grafo;
import com.tpo.demo.model.MovieEntity;
import com.tpo.demo.repository.MovieRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    //method implementations with walkthroughs below

    @PutMapping
    Mono<MovieEntity> createOrUpdateMovie(@RequestBody MovieEntity newMovie) {
        return movieRepository.save(newMovie);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/grafo")
    public Mono<String> getGrafo() {
        //se una la función mono, para la reacción reactiva
        return movieRepository.findAll()
                .collectList() // Convertimos el Flux a un Mono<List<MovieEntity>>
                .map(movies-> {
                    Grafo grafo = new Grafo(movies); // Construimos el grafo con la lista de películas
                    return grafo.toString(); // Devolvemos la representación en String del grafo
                });
    }

    @GetMapping("/bfs")
    public Mono<String> getBFS() {
        return movieRepository.findAll()
                .collectList() // Convertimos el Flux a un Mono<List<MovieEntity>>
                .map(movies-> { //esto es una expresión lambda
                    Grafo grafo = new Grafo(movies); // Construimos el grafo con la lista de películas
                    return grafo.BFS(movies.get(0)); // Devolvemos la representación en String del grafo
                });
    }

    @GetMapping("/dfs")
    public Mono<String> getDFS() {
        return movieRepository.findAll()
                .collectList() // Convertimos el Flux a un Mono<List<MovieEntity>>
                .map(movies-> {
                    Grafo grafo = new Grafo(movies); // Construimos el grafo con la lista de películas
                    return grafo.DFS(movies.get(0)); // Devolvemos la representación en String del grafo
                });
    }


}
