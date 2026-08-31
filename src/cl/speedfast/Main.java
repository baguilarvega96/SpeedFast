package cl.speedfast;

public class Main {

    public static void main(String[] args) {

        Pedido pedidoComida =
                new PedidoComida("101", "Av. Italia 456", 4);

        Pedido pedidoEncomienda =
                new PedidoEncomienda("102", "Av. Santa Rosa 567", 7);

        Pedido pedidoExpress =
                new PedidoExpress("103", "Av. Apoquindo 1500", 6);


        System.out.println("=== ASIGNACIÓN AUTOMÁTICA ===");

        pedidoComida.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor();
        pedidoExpress.asignarRepartidor();


        System.out.println("\n=== ASIGNACIÓN MANUAL ===");

        pedidoComida.asignarRepartidor("Juan Pérez");
        pedidoEncomienda.asignarRepartidor("Daniela Tapia");
        pedidoExpress.asignarRepartidor("Camila Soto");


        System.out.println("\n=== RESUMEN Y TIEMPOS ===");

        pedidoComida.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoComida.calcularTiempoEntrega() + " minutos");

        System.out.println();

        pedidoEncomienda.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoEncomienda.calcularTiempoEntrega() + " minutos");

        System.out.println();

        pedidoExpress.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoExpress.calcularTiempoEntrega() + " minutos");


        System.out.println("\n=== RESERVA DE PEDIDOS ===");

        pedidoComida.reservar();
        pedidoEncomienda.reservar();
        pedidoExpress.reservar();


        System.out.println("\n=== DESPACHO ===");

        pedidoComida.despachar();
        pedidoEncomienda.despachar();


        System.out.println("\n=== CANCELACIÓN ===");

        System.out.println("Cancelando Pedido Express #103...");
        pedidoExpress.cancelar();


        System.out.println("\n=== HISTORIAL PEDIDO COMIDA ===");

        for (String evento : pedidoComida.verHistorial()) {
            System.out.println("- " + evento);
        }


        System.out.println("\n=== HISTORIAL PEDIDO ENCOMIENDA ===");

        for (String evento : pedidoEncomienda.verHistorial()) {
            System.out.println("- " + evento);
        }


        System.out.println("\n=== HISTORIAL PEDIDO EXPRESS ===");

        for (String evento : pedidoExpress.verHistorial()) {
            System.out.println("- " + evento);
        }
    }
}