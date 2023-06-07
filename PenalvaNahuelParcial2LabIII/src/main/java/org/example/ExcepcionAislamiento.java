package org.example;

public class ExcepcionAislamiento extends Exception {
    private int numeroKit;
    private String barrio;

    public ExcepcionAislamiento(int numeroKit, String barrio) {
        this.numeroKit = numeroKit;
        this.barrio = barrio;
    }

    @Override
    public String getMessage() {
        return "Temperatura superior a 38 grados. Aislar persona del número de kit: " + numeroKit + ", barrio: " + barrio;
    }
}
