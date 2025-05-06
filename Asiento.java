
package com.mycompany.teatro_moro;

public class Asiento {
    private int numero;
    private int precio;
    private boolean vendido;
    private boolean reservado;

    public Asiento(int numero, int precio) {
        this.numero = numero;
        this.precio = precio;
        this.vendido = false;
        this.reservado = false;
    }

    public int getNumero() { return numero; }
    public int getPrecio() { return precio; }
    public boolean isVendido() { return vendido; }
    public boolean isReservado() { return reservado; }

    public void setVendido(boolean vendido) { this.vendido = vendido; }
    public void setReservado(boolean reservado) { this.reservado = reservado; }
}
