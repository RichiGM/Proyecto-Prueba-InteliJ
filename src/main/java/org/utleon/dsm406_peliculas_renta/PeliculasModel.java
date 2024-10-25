package org.utleon.dsm406_peliculas_renta;

public class PeliculasModel {
    String titulo, genero, director, anio;

    public PeliculasModel() {
    }

    public PeliculasModel(String titulo, String genero, String director, String anio) {
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
        this.anio = anio;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}