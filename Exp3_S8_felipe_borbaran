
package com.mycompany.teatro_moro;

import java.util.*;

public class TeatroMoro {

    private Asiento[] asientos = new Asiento[20];
    private List<Cliente> clientes = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Descuento> descuentos = new ArrayList<>();

    private int idVenta = 1;
    private int idReserva = 1;
    private int totalIngresos = 0;

    public TeatroMoro() {
        for (int i = 0; i < 20; i++) {
            asientos[i] = new Asiento(i + 1, 5000);
        }

        descuentos.add(new Descuento("Estudiante", 0.10));
        descuentos.add(new Descuento("Tercera Edad", 0.15));
    }

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Bienvenido al Teatro Moro ---");
            System.out.println("1. Reservar entrada");
            System.out.println("2. Comprar entrada");
            System.out.println("3. Modificar venta");
            System.out.println("4. Imprimir boleta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> reservarEntrada(sc);
                case 2 -> comprarEntrada(sc);
                case 3 -> modificarVenta(sc);
                case 4 -> imprimirBoleta(sc);
                case 5 -> System.out.println("Gracias por venir a Teatro Moro.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private Cliente registrarCliente(Scanner sc) {
        System.out.print("Ingrese su nombre: ");
        sc.nextLine(); 
        String nombre = sc.nextLine();

        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();

        String tipo = "Normal";
        if (edad <= 18) {
            tipo = "Estudiante";
        } else if (edad >= 60) {
            tipo = "Tercera Edad";
        }

        Cliente cliente = new Cliente(nombre, edad, tipo);
        clientes.add(cliente);
        return cliente;
    }

    private double aplicarDescuento(Cliente cliente, int precioBase) {
        for (Descuento d : descuentos) {
            if (d.getTipoCliente().equalsIgnoreCase(cliente.getTipo())) {
                return precioBase * (1 - d.getPorcentaje());
            }
        }
        return precioBase;
    }

    private void reservarEntrada(Scanner sc) {
        mostrarAsientos();
        System.out.print("Seleccione número de asiento a reservar (1-20): ");
        int num = sc.nextInt();

        if (num < 1 || num > 20) {
            System.out.println("Asiento inválido.");
            return;
        }
        
        //Se puede agregar una confirmacion de reserva

        Asiento asiento = asientos[num - 1];
        if (asiento.isReservado() || asiento.isVendido()) {
            System.out.println("Asiento no disponible.");
            return;
        }

        Cliente cliente = registrarCliente(sc);
        asiento.setReservado(true);
        reservas.add(new Reserva(idReserva++, cliente, asiento));
        System.out.println("Reserva realizada exitosamente.");
    }

    private void comprarEntrada(Scanner sc) {
        mostrarAsientos();
        System.out.print("Seleccione el número del asiento a comprar (1-20): ");
        int num = sc.nextInt();

        if (num < 1 || num > 20) {
            System.out.println("Asiento inválido.");
            return;
        }
            //Se puede agregar una confirmacion de compra
            
        Asiento asiento = asientos[num - 1];
        if (asiento.isVendido()) {
            System.out.println("El Asiento ya fue vendido.");
            return;
        }

        Cliente cliente = registrarCliente(sc);
        double precioFinal = aplicarDescuento(cliente, asiento.getPrecio());
        
        asiento.setVendido(true);
        asiento.setReservado(false);
        reservas.removeIf(r -> r.getAsiento().getNumero() == asiento.getNumero());

        ventas.add(new Venta(idVenta++, cliente, asiento, precioFinal));
        totalIngresos += precioFinal;

        System.out.println("Compra exitosa. Precio final: $" + (int)precioFinal);
        
      
    }

    private void modificarVenta(Scanner sc) {
        System.out.print("Ingrese ID de venta a modificar: ");
        int id = sc.nextInt();

        Venta venta = null;
        for (Venta v : ventas) {
            if (v.getId() == id) {
                venta = v;
                break;
            }
        }

        if (venta == null) {
            System.out.println("Venta no encontrada.");
            return;
        }

        System.out.print("Ingrese nuevo número de asiento (1-20): ");
        int nuevo = sc.nextInt();

        if (nuevo < 1 || nuevo > 20) {
            System.out.println("Asiento no valido.");
            return;
        }

        Asiento nuevoAsiento = asientos[nuevo - 1];
        if (nuevoAsiento.isVendido()) {
            System.out.println("este Asiento ya fue vendido.");
            return;
        }
        
        //Se puede agregar una confirmacion de modificacion

        venta.getAsiento().setVendido(false);
        totalIngresos -= venta.getPrecioPagado();

        nuevoAsiento.setVendido(true);
        double nuevoPrecio = aplicarDescuento(venta.getCliente(), nuevoAsiento.getPrecio());
        venta = new Venta(venta.getId(), venta.getCliente(), nuevoAsiento, nuevoPrecio);

        totalIngresos += nuevoPrecio;

        ventas.removeIf(v -> v.getId() == id);
        ventas.add(venta);
        System.out.println("Venta modificada correctamente.");
    }

    private void imprimirBoleta(Scanner sc) {
        System.out.print("Ingrese ID de venta: ");
        int id = sc.nextInt();

        for (Venta v : ventas) {
            if (v.getId() == id) {
                System.out.println("\n--- Boleta ---");
                System.out.println("Cliente: " + v.getCliente().getNombre());
                System.out.println("Asiento: " + v.getAsiento().getNumero());
                System.out.println("Precio pagado: $" + (int)v.getPrecioPagado());
                System.out.println("\n---------------------------------");
                System.out.println("Gracias por venir a Teatro Moro");
                System.out.println("\n---------------------------------");

                return;
            }
        }

        System.out.println("Venta no encontrada.");
    }

    private void mostrarAsientos() {
        System.out.println("\n--- ----Asientos -------");
        for (Asiento a : asientos) {
            String estado = a.isVendido() ? "VENDIDO" : a.isReservado() ? "RESERVADO" : "DISPONIBLE";
            System.out.println("Asiento " + a.getNumero() + " - $" + a.getPrecio() + " - " + estado);
        }
    }

    public static void main(String[] args) {
        TeatroMoro teatro = new TeatroMoro();
        teatro.mostrarMenu();
    }
}
