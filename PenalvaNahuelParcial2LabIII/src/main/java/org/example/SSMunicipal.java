package org.example;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.HashMap;

public class SSMunicipal  {

    Random rand = new Random();
    private int reactivos;
    private Queue<Persona> personas;

    private static int kit = 0;
    private int numeroDeKit;

    public SSMunicipal(int reactivosIniciales) {
        this.reactivos = reactivosIniciales;
        this.personas = new LinkedList<>();
    }

    public int getReactivos() {
        return reactivos;
    }

    public void setReactivos(int reactivos) {
        this.reactivos = reactivos;
    }

    public Queue<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Queue<Persona> personas) {
        this.personas = personas;
    }

    public void addPersonaFila(Persona p) throws ReactivosException {
        if (this.reactivos == 0) {
            throw new ReactivosException("Los reactivos se terminaron");
        } else {
            this.personas.add(p);
            this.numeroDeKit = kit++;
            this.setReactivos(getReactivos() - 1);
            p.setNumKit(numeroDeKit);
            System.out.println("Paciente en fila");
        }
    }

    public int validacionDNI(Persona p) throws ReactivosException {
        int i = 0;
        int existe = 0;
        Queue<Persona> aux = new LinkedList();
        while (!this.personas.isEmpty()) {
            if (this.personas.peek().getDni().equals(p.getDni())) {
                System.out.println("Este DNI ya existe en la fila");
                System.out.println(p.getNombreApellido() + "No es quien dice ser 'o'");
                existe = 1;
            }
            aux.add(this.personas.poll());
        }
        while (!aux.isEmpty()) {
            this.personas.add(aux.poll());
        }
        if (existe == 0) {
            addPersonaFila(p);
        }
        return existe;
    }

    public void testear() throws ExcepcionAislamiento{
        Map<Integer,Registro> resultados = new HashMap<>();

        while (!personas.isEmpty()) {
            Persona persona = personas.poll();
            int numeroKit = persona.getNumKit();
            String dni = persona.getDni();
            double temperatura = rand.nextInt(36, 41);
            String barrio = persona.getBarrio();

            Registro registro = new Registro(dni, temperatura, barrio);
            resultados.put(numeroKit, registro);
        }

        for (Map.Entry<Integer,Registro> entry : resultados.entrySet()) {
            int numeroKit = entry.getKey();
            Registro registro = entry.getValue();

            System.out.println("Número de Kit: " + numeroKit);
            System.out.println("DNI: " + registro.getDni());
            System.out.println("Temperatura: " + registro.getTemperatura());

                 if (registro.getTemperatura() >= 38.0) {
                try {
                    aislar(numeroKit, registro.getBarrio());
                } catch (ExcepcionAislamiento e) {
                    System.out.println(e.getMessage());
                }}
        }
    }
    private void aislar(int numeroKit, String barrio) throws ExcepcionAislamiento {
            throw new ExcepcionAislamiento(numeroKit, barrio);
    }

}
