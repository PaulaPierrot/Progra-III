package com.tpo.demo.model;

import java.util.*;

public class Grafo {
    private Map<MovieEntity, List<PersonEntity>> adjMovies;
    private Map<PersonEntity, List<MovieEntity>> adjPeople;
    public Grafo() {}
    public Grafo(List<MovieEntity> movies) {
        adjMovies = new HashMap<>();
        adjPeople = new HashMap<>();
        for (MovieEntity movie : movies) {
            adjMovies.putIfAbsent(movie, new ArrayList<>(movie.getActors()));
            adjMovies.get(movie).addAll(movie.getDirectors());
            for (PersonEntity actor : movie.getActors()) {
                adjPeople.putIfAbsent(actor, new ArrayList<>());
                adjPeople.get(actor).add(movie);
            }
            for (PersonEntity director : movie.getDirectors()) {
                adjPeople.putIfAbsent(director, new ArrayList<>());
                adjPeople.get(director).add(movie);
            }
        }
    }
    public void agregarArista(MovieEntity movie, PersonEntity person) {
        adjMovies.get(movie).add(person);
        adjPeople.get(person).add(movie);
    }
    public String BFS(MovieEntity inicio) {
        StringBuilder resultado = new StringBuilder();
        Set<MovieEntity> visitadoMovies = new HashSet<>();
        Set<PersonEntity> visitadoPeople = new HashSet<>();
        Queue<Object> cola = new LinkedList<>();
        visitadoMovies.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Object actual = cola.poll();

            if (actual instanceof MovieEntity) {
                MovieEntity movie = (MovieEntity) actual;
                resultado.append("Movie: ").append(movie.getTitle()).append("\n");

                // Recorrer actores
                for (PersonEntity actor : movie.getActors()) {
                    if (!visitadoPeople.contains(actor)) {
                        visitadoPeople.add(actor);
                        resultado.append("Actor: ").append(actor.getName()).append("\n");
                        cola.add(actor);
                    }
                }

                // Recorrer directores
                for (PersonEntity director : movie.getDirectors()) {
                    if (!visitadoPeople.contains(director)) {
                        visitadoPeople.add(director);
                        resultado.append("Director: ").append(director.getName()).append("\n");
                        cola.add(director);
                    }
                }

                // Recorrer películas asociadas a los actores y directores
                for (PersonEntity persona : adjMovies.get(movie)) {
                    if (!visitadoPeople.contains(persona)) {
                        visitadoPeople.add(persona);
                        cola.add(persona);
                    }
                }
            } else if (actual instanceof PersonEntity) {
                PersonEntity persona = (PersonEntity) actual;
                if (!visitadoPeople.contains(persona)) {
                    visitadoPeople.add(persona);
                    resultado.append("Person: ").append(persona.getName()).append("\n");

                    // Recorrer películas asociadas a la persona
                    for (MovieEntity movie : adjPeople.get(persona)) {
                        if (!visitadoMovies.contains(movie)) {
                            visitadoMovies.add(movie);
                            cola.add(movie);
                        }
                    }
                }
            }
        }
        return resultado.toString();
    }
    public String DFS(MovieEntity inicio) {
        StringBuilder resultado = new StringBuilder();
        Set<MovieEntity> visitadoMovies = new HashSet<>();
        Set<PersonEntity> visitadoPeople = new HashSet<>();
        dfsRecursivo(inicio, resultado, visitadoMovies, visitadoPeople);
        return resultado.toString();
    }
    // Método recursivo para el recorrido DFS
    private void dfsRecursivo(Object nodo, StringBuilder resultado, Set<MovieEntity> visitadoMovies, Set<PersonEntity> visitadoPeople) {
        if (nodo instanceof MovieEntity) {
            MovieEntity movie = (MovieEntity) nodo;
            if (visitadoMovies.contains(movie)) return; // Evitar ciclos
            visitadoMovies.add(movie);
            resultado.append("Movie: ").append(movie.getTitle()).append("\n");

            // Recorrer actores
            for (PersonEntity actor : movie.getActors()) {
                if (!visitadoPeople.contains(actor)) {
                    visitadoPeople.add(actor);
                    resultado.append("Actor: ").append(actor.getName()).append("\n");
                    dfsRecursivo(actor, resultado, visitadoMovies, visitadoPeople);
                }
            }

            // Recorrer directores
            for (PersonEntity director : movie.getDirectors()) {
                if (!visitadoPeople.contains(director)) {
                    visitadoPeople.add(director);
                    resultado.append("Director: ").append(director.getName()).append("\n");
                    dfsRecursivo(director, resultado, visitadoMovies, visitadoPeople);
                }
            }
        } else if (nodo instanceof PersonEntity) {
            PersonEntity persona = (PersonEntity) nodo;
            if (visitadoPeople.contains(persona)) return; // Evitar ciclos
            visitadoPeople.add(persona);
            resultado.append("Person: ").append(persona.getName()).append("\n");

            // Recorrer películas
            for (MovieEntity movie : adjPeople.get(persona)) {
                if (!visitadoMovies.contains(movie)) {
                    visitadoMovies.add(movie);
                    resultado.append("Movie: ").append(movie.getTitle()).append("\n");
                    dfsRecursivo(movie, resultado, visitadoMovies, visitadoPeople);
                }
            }
        }
    }
    @Override
    public String toString() {
        return "Grafo{" +
                "adjMovies=" + adjMovies +
                ", adjPeople=" + adjPeople +
                '}';
    }
}
