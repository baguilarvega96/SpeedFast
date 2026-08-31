package cl.speedfast;

public class PedidoComida extends Pedido {

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, "Comida", distanciaKm);
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Comida]");
        System.out.println("Asignando repartidor...");
        System.out.println("→ Verificando mochila térmica... OK");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("→ Verificando mochila térmica... OK");
        System.out.println("→ Pedido asignado a " + nombreRepartidor);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + (2 * getDistanciaKm()));
    }
}