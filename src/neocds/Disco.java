/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neocds;

import java.util.Comparator;

/**
 *
 * @author Augusto
 */
public class Disco implements Comparable<Disco>{
    
    private String titulo;
    private int nroPistas;
    private float valor;
    private char clasificacion;
    
    public Disco(){}

    public Disco(String titulo, int nroPistas, float valor, char clasificacion) {
        this.titulo = titulo;
        this.nroPistas = nroPistas;
        this.valor = valor;
        this.clasificacion = clasificacion;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the nroPistas
     */
    public int getNroPistas() {
        return nroPistas;
    }

    /**
     * @param nroPistas the nroPistas to set
     */
    public void setNroPistas(int nroPistas) {
        this.nroPistas = nroPistas;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the clasificacion
     */
    public char getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(char clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public int compareTo(Disco d) {
        return this.titulo.compareTo(d.getTitulo());
    }
    
    @Override
    public String toString() {
        return String.format("Título: %s.\nNúmero de pistas: %s\nValor: %s.\nClasificación: %s.", this.titulo, this.nroPistas, this.valor, this.clasificacion);
    }
    
}
