package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String user;
    private String document;
    private String datenasc;
    private String email;
    private String city;
    private String contact;

    private List<String> listE = new ArrayList<>();

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
        listE.add(this.evento);


    }

    private String evento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDatenasc() {
        return datenasc;
    }

    public void setDatenasc(String datenasc) {
        this.datenasc = datenasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<String> getListE() {

        return listE;

    }

    public void setListE(List<String> listE) {
        this.listE = listE;

    }
}
