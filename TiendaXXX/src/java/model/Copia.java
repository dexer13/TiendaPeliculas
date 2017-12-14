/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo
 */
public class Copia {
    private boolean deteriorada;
    private String formato;
    private float precioAlquiler;

    public boolean isDeteriorada() {
        return deteriorada;
    }

    public void setDeteriorada(boolean deteriorada) {
        this.deteriorada = deteriorada;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public float getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(float precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public String toString() {
        return "Copia{" + "deteriorada=" + deteriorada + ", formato=" + formato + ", precioAlquiler=" + precioAlquiler + '}';
    }
}
