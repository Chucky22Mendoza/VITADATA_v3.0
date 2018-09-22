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
public class DPaciente {
    private String nombre;
    private int edad;
    private float imc;
    private String persPat;
    private String noPat;
    private String fam;
    private String medQui;
    private String pad;

    public DPaciente() {
    }

    public DPaciente(String nombre, int edad, float imc, String persPat, String noPat, String fam, String medQui, String pad) {
        this.nombre = nombre;
        this.edad = edad;
        this.imc = imc;
        this.persPat = persPat;
        this.noPat = noPat;
        this.fam = fam;
        this.medQui = medQui;
        this.pad = pad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getPersPat() {
        return persPat;
    }

    public void setPersPat(String persPat) {
        this.persPat = persPat;
    }

    public String getNoPat() {
        return noPat;
    }

    public void setNoPat(String noPat) {
        this.noPat = noPat;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getMedQui() {
        return medQui;
    }

    public void setMedQui(String medQui) {
        this.medQui = medQui;
    }

    public String getPad() {
        return pad;
    }

    public void setPad(String pad) {
        this.pad = pad;
    }
    
    
}
