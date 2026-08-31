package cl.speedfast;

import cl.speedfast.interfaces.Cancelable;
import cl.speedfast.interfaces.Despachable;
import cl.speedfast.interfaces.Rastreable;

import java.util.ArrayList;
import java.util.List;

public abstract class Pedido implements Despachable, Cancelable, Rastreable {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private double distanciaKm;

    protected String repartidorAsignado = "Sin asignar";

    private boolean despachado = false;
    private boolean cancelado = false;

    private List<String> historial = new ArrayList<>();

    public Pedido(String idPedido, String direccionEntrega,
                  String tipoPedido, double distanciaKm) {

        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
        this.distanciaKm = distanciaKm;

        historial.add("Pedido " + tipoPedido + " #" + idPedido + " creado.");
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void mostrarResumen() {
        System.out.println("Pedido " + tipoPedido + " #" + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Repartidor asignado: " + repartidorAsignado);
    }

    public void asignarRepartidor() {
        System.out.println("Asignando repartidor al pedido...");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        repartidorAsignado = nombreRepartidor;
        registrarEvento("Repartidor asignado: " + nombreRepartidor);
        System.out.println("Pedido asignado a: " + nombreRepartidor);
    }

    protected void registrarEvento(String evento) {
        historial.add(evento);
    }

    @Override
    public void despachar() {
        if (cancelado) {
            System.out.println("No se puede despachar un pedido cancelado.");
            return;
        }

        despachado = true;
        registrarEvento("Pedido despachado por " + repartidorAsignado);
        System.out.println("Pedido despachado correctamente.");
    }

    @Override
    public void cancelar() {
        if (despachado) {
            System.out.println("No se puede cancelar un pedido ya despachado.");
            return;
        }

        cancelado = true;
        registrarEvento("Pedido cancelado.");
        System.out.println("→ Pedido cancelado exitosamente.");
    }

    @Override
    public List<String> verHistorial() {
        return new ArrayList<>(historial);
    }

    public abstract int calcularTiempoEntrega();
}