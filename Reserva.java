
package com.mycompany.teatro_moro;

public class Reserva {
    private int id;
    private Cliente cliente;
    private Asiento asiento;

    public Reserva(int id, Cliente cliente, Asiento asiento) {
        this.id = id;
        this.cliente = cliente;
        this.asiento = asiento;
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Asiento getAsiento() { return asiento; }
}

