package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) throws ReactivosException {

        SSMunicipal ssm = new SSMunicipal(3);

        Persona paciente0 = new Persona("Juan Domingues", 24, "Cerrito sur", "41429571", "Mecanico");
        Persona paciente1 = new Persona("Raul Martin", 25, "Cerrito sur", "42425572", "Doctor");
        Persona paciente2 = new Persona("Manuel Lopez", 30, "Troncos", "42425572", "Enfermero");
        Persona paciente3 = new Persona("Nahuel Peñalva", 20, "Mogotes", "42525573", "Programador");
        Persona paciente4 = new Persona("Jose Gomez", 35, "Avellaneda", "32425772", "Colectivero");
        Persona paciente5 = new Persona("Maria Josefa", 27, "Avellaneda", "40425782", "Cocinera");

        try {
            ssm.validacionDNI(paciente0);
            ssm.validacionDNI(paciente1);
            ssm.validacionDNI(paciente2);
            ssm.validacionDNI(paciente3);
            ssm.validacionDNI(paciente4);
        } catch (ReactivosException e) {
            System.out.println(e.getMessage());
            ssm.setReactivos(10);
        }
        ssm.validacionDNI(paciente4);
        ssm.validacionDNI(paciente5);


        System.out.println(ssm.getPersonas().toString());
        System.out.println(ssm.getReactivos());
    }
}
