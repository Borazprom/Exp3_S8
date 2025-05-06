
package com.mycompany.teatro_moro;

public class Cliente {
    private String nombre;
    private int edad;
    private String tipo; // "Normal", "Estudiante", "Tercera Edad"

    public Cliente(String nombre, int edad, String tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getTipo() { return tipo; }
}
