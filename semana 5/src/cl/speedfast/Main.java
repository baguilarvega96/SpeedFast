package cl.speedfast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        // Recurso compartido por todos los repartidores.
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Se agregan al menos 5 pedidos al sistema.
        zonaDeCarga.agregarPedido(
                new Pedido(1, "Santiago Centro")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(2, "Providencia")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(3, "Ñuñoa")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(4, "Recoleta")
        );

        zonaDeCarga.agregarPedido(
                new Pedido(5, "Las Condes")
        );

        System.out.println();

        // Se crean los tres repartidores solicitados.
        Repartidor repartidor1 =
                new Repartidor("Juan", zonaDeCarga);

        Repartidor repartidor2 =
                new Repartidor("Camila", zonaDeCarga);

        Repartidor repartidor3 =
                new Repartidor("Pedro", zonaDeCarga);

        // Pool de tres hilos para ejecutar los repartidores en paralelo.
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        executor.execute(repartidor1);
        executor.execute(repartidor2);
        executor.execute(repartidor3);

        // No se aceptan nuevas tareas.
        executor.shutdown();

        try {

            // Espera a que todos los repartidores terminen.
            boolean finalizado =
                    executor.awaitTermination(
                            1,
                            TimeUnit.MINUTES
                    );

            if (finalizado) {

                System.out.println();
                System.out.println(
                        "Todos los pedidos han sido entregados correctamente"
                );

            } else {

                System.out.println();
                System.out.println(
                        "El proceso no finalizó dentro del tiempo esperado."
                );
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "El proceso principal fue interrumpido."
            );
        }
    }
}