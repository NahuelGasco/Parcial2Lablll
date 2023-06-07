package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Persona  {

        private String nombreApellido;
        private int edad;
        private String barrio;
        private String dni;
        private String ocupacion;
        private int numKit;

    public Persona() {
    }

    public Persona(String nombreApellido, int edad, String barrio, String dni, String ocupacion) {
        this.nombreApellido = nombreApellido;
        this.edad = edad;
        this.barrio = barrio;
        this.dni = dni;
        this.ocupacion = ocupacion;
        this.numKit = 0;
    }

    public int getNumKit() {
        return numKit;
    }

    public void setNumKit(int numKit) {
        this.numKit = numKit;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return dni.equals(persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombreApellido='" + nombreApellido + '\'' +
                ", edad=" + edad +
                ", barrio='" + barrio + '\'' +
                ", dni='" + dni + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", numKit=" + numKit +
                '}';
    }
}
