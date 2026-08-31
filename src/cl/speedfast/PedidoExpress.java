package cl.speedfast;

public class PedidoExpress extends Pedido {

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, "Express", distanciaKm);
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Express]");
        System.out.println("Asignando repartidor...");
        System.out.println("→ Repartidor más cercano con disponibilidad inmediata encontrado.");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("→ Verificando disponibilidad inmediata... OK");
        System.out.println("→ Pedido asignado a " + nombreRepartidor);
    }

    @Override
    public int calcularTiempoEntrega() {
        if (getDistanciaKm() > 5) {
            return 15;
        }

        return 10;
    }
}