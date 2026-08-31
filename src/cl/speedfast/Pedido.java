package cl.speedfast;

public class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;

    public Pedido(String idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
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

    public void asignarRepartidor() {
        System.out.println("Asignando repartidor al pedido...");
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Pedido asignado a: " + nombreRepartidor);
    }
}