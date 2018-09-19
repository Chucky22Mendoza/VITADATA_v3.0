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
public class NuevoUsuario {
    private String user;
    private String pass;
    private String mail;
    private String ind;
    private String name;
    private String ced;

    public NuevoUsuario() {
    }

    public NuevoUsuario(String user, String pass, String mail, String ind, String name, String ced) {
        this.user = user;
        this.pass = pass;
        this.mail = mail;
        this.ind = ind;
        this.name = name;
        this.ced = ced;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }
    
    
}
