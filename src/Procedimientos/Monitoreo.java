/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

/**
 *
 * @author Jesús Mendoza
 */
public class Monitoreo {
    private String nombre;
    private float temp;
    private int oxi;
    private int fre;

    public Monitoreo() {
    }

    public Monitoreo(String nombre, float temp, int oxi, int fre) {
        this.nombre = nombre;
        this.temp = temp;
        this.oxi = oxi;
        this.fre = fre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public int getOxi() {
        return oxi;
    }

    public void setOxi(int oxi) {
        this.oxi = oxi;
    }

    public int getFre() {
        return fre;
    }

    public void setFre(int fre) {
        this.fre = fre;
    }
    
    
}
