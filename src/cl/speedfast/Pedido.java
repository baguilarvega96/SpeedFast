package cl.speedfast;

public abstract class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private double distanciaKm;

    public Pedido(String idPedido, String direccionEntrega,
                  String tipoPedido, double distanciaKm) {

        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
        this.distanciaKm = distanciaKm;
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
    }

    public void asignarRepartidor() {
        System.out.println("Asignando repartidor al pedido...");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Pedido asignado a: " + nombreRepartidor);
    }

    public abstract int calcularTiempoEntrega();
}