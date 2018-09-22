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
public class nuevoPaciente {
    private String name;
    private int edad;
    private String fecha;
    private float peso;
    private float est;
    private String nomRec;
    private int idDoc;
    private String tel;
    private String persPat;
    private String noPat;
    private String fam;
    private String medQui;
    private String pad;
    private int id;

    public nuevoPaciente() {
    }

    public nuevoPaciente(String name, int edad, String fecha, float peso, float est, String nomRec, int idDoc, String tel, String persPat, String noPat, String fam, String medQui, String pad) {
        this.name = name;
        this.edad = edad;
        this.fecha = fecha;
        this.peso = peso;
        this.est = est;
        this.nomRec = nomRec;
        this.idDoc = idDoc;
        this.tel = tel;
        this.persPat = persPat;
        this.noPat = noPat;
        this.fam = fam;
        this.medQui = medQui;
        this.pad = pad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEst() {
        return est;
    }

    public void setEst(float est) {
        this.est = est;
    }

    public String getNomRec() {
        return nomRec;
    }

    public void setNomRec(String nomRec) {
        this.nomRec = nomRec;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
