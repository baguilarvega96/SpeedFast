# SpeedFast - Semana 5

## Desarrollo Orientado a Objetos II

Actividad correspondiente a la Semana 5 de la asignatura Desarrollo Orientado a Objetos II.

### Autor
Byron Aguilar Vega

---

## Descripción

En esta actividad se continúa el desarrollo del sistema SpeedFast.

El objetivo es simular un sistema de entregas concurrentes donde varios repartidores trabajan en paralelo retirando pedidos desde una zona de carga compartida.

Para evitar que dos repartidores retiren el mismo pedido al mismo tiempo, se implementan mecanismos de sincronización mediante `synchronized`.

---

## Objetivos de la actividad

- Implementar múltiples hilos mediante `Runnable`.
- Ejecutar varios repartidores de forma concurrente.
- Proteger el acceso a recursos compartidos.
- Evitar condiciones de carrera.
- Utilizar sincronización mediante `synchronized`.
- Gestionar estados de los pedidos mediante `enum`.
- Simular tiempos de entrega mediante `Thread.sleep()`.
- Utilizar `ExecutorService` para administrar los hilos.

---

## Estructura principal del proyecto

```text
semana 5
└── src
    └── cl.speedfast
        ├── interfaces
        │   ├── Cancelable.java
        │   ├── Despachable.java
        │   └── Rastreable.java
        │
        ├── EstadoPedido.java
        ├── Main.java
        ├── Pedido.java
        ├── PedidoComida.java
        ├── PedidoEncomienda.java
        ├── PedidoExpress.java
        ├── Repartidor.java
        └── ZonaDeCarga.java