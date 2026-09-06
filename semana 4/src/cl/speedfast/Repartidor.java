package cl.speedfast;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombre, List<Pedido> pedidosAsignados) {
        this.nombre = nombre;
        this.pedidosAsignados = pedidosAsignados;
    }

    @Override
    public void run() {

        System.out.println("[Repartidor: " + nombre + "] Iniciando entregas.");

        for (Pedido pedido : pedidosAsignados) {

            try {
                pedido.asignarRepartidor(nombre);

                System.out.println(
                        "[Repartidor: " + nombre + "] Entregando "
                                + pedido.getTipoPedido()
                                + " #" + pedido.getIdPedido() + "..."
                );

                int tiempoEspera =
                        ThreadLocalRandom.current().nextInt(1000, 3001);

                Thread.sleep(tiempoEspera);

                pedido.despachar();

                System.out.println(
                        "[Repartidor: " + nombre + "] Pedido #"
                                + pedido.getIdPedido()
                                + " entregado."
                );

            } catch (InterruptedException e) {

                System.out.println(
                        "[Repartidor: " + nombre
                                + "] La entrega fue interrumpida."
                );

                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(
                "[Repartidor: " + nombre
                        + "] Finalizó todas sus entregas."
        );
    }
}