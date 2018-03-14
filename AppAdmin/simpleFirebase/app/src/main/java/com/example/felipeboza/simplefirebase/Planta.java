package com.example.felipeboza.simplefirebase;

/**
 * Created by Felipe Boza on 28/12/2017.
 */

public class Planta {

    // Atributos de la estructura planta

    public String id;
    public String nombreCientifico;
    public String nombreComun;
    public String familia;

    public String genero;
    public String especie;
    public String clasificador;
    public String tipo;

    public String distrito;
    public String usos;
    public String productor;
    public String latitud;

    public String longitud;
    public String imagenGenoma;
    public String imagenMetaboloma;
    public String imagenPlanta;

    public Planta() {

        this.id = "";
        this.nombreCientifico = "";
        this.nombreComun = "";
        this.familia = "";

        this.genero = "";
        this.especie = "";
        this.clasificador = "";
        this.tipo = "";

        this.distrito = "";
        this.usos = "";
        this.productor = "";
        this.latitud = "";

        this.longitud ="";
        this.imagenGenoma = "";
        this.imagenMetaboloma = "";
        this.imagenPlanta = "";

    }

    public Planta(String id, String nombreCientifico, String nombreComun, String familia,
                  String genero, String especie, String clasificador, String tipo, String distrito,
                  String usos, String productor, String latitud, String longitud, String imagenGenoma,
                  String imagenMetaboloma, String imagenPlanta) {

        this.id = id;
        this.nombreCientifico = nombreCientifico;
        this.nombreComun = nombreComun;
        this.familia = familia;

        this.genero = genero;
        this.especie = especie;
        this.clasificador = clasificador;
        this.tipo = tipo;

        this.distrito = distrito;
        this.usos = usos;
        this.productor = productor;
        this.latitud = latitud;

        this.longitud = longitud;
        this.imagenGenoma = imagenGenoma;
        this.imagenMetaboloma = imagenMetaboloma;
        this.imagenPlanta = imagenPlanta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getClasificador() {
        return clasificador;
    }

    public void setClasificador(String clasificador) {
        this.clasificador = clasificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getUsos() {
        return usos;
    }

    public void setUsos(String usos) {
        this.usos = usos;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getImagenGenoma() {
        return imagenGenoma;
    }

    public void setImagenGenoma(String imagenGenoma) {
        this.imagenGenoma = imagenGenoma;
    }

    public String getImagenMetaboloma() {
        return imagenMetaboloma;
    }

    public void setImagenMetaboloma(String imagenMetaboloma) {
        this.imagenMetaboloma = imagenMetaboloma;
    }

    public String getImagenPlanta() {
        return imagenPlanta;
    }

    public void setImagenPlanta(String imagenPlanta) {
        this.imagenPlanta = imagenPlanta;
    }
}