package org.utleon.dsm406_peliculas_renta;

public class PeliculasModel {
    int idPelicula, anio;
    String titulo, genero,  director;


    public PeliculasModel() {
    }

    public PeliculasModel(int idPelicula, String titulo, String genero, int anio, String director) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.director = director;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}