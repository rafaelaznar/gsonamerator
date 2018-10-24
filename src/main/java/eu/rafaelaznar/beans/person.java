package eu.rafaelaznar.beans;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.Date;

public class person {

    @Expose
    private Integer id;
    @Expose
    private String nombre;
    @Expose
    private String primerApellido;
    @Expose
    private String segundoApellido;
    @Expose
    private ArrayList<pet> pets;
    @Expose
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public ArrayList<pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<pet> pets) {
        this.pets = pets;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }



}
