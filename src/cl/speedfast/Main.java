package cl.speedfast;

public class Main {

    public static void main(String[] args) {

        Pedido pedidoComida =
                new PedidoComida("001", "Av. Italia 456");

        Pedido pedidoEncomienda =
                new PedidoEncomienda("002", "Av. Independencia 123");

        Pedido pedidoExpress =
                new PedidoExpress("003", "Av. Apoquindo 1500");


        pedidoComida.asignarRepartidor();
        pedidoComida.asignarRepartidor("Juan Pérez");

        System.out.println();


        pedidoEncomienda.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor("Camila Soto");

        System.out.println();


        pedidoExpress.asignarRepartidor();
        pedidoExpress.asignarRepartidor("Luis Díaz");
    }
}