# SpeedFast - Semana 4

## Desarrollo Orientado a Objetos II

### Actividad: Ejecutando tareas en paralelo con hilos en Java

Este proyecto corresponde a la actividad de la Semana 4 del ramo Desarrollo Orientado a Objetos II.

El objetivo de esta actividad es incorporar programación concurrente al sistema SpeedFast, simulando que varios repartidores realizan entregas al mismo tiempo.

---

## Descripción del proyecto

SpeedFast es una empresa dedicada al reparto de:

- Pedidos de comida.
- Encomiendas.
- Pedidos express.

En las semanas anteriores se desarrolló una estructura orientada a objetos utilizando una clase abstracta `Pedido`, subclases específicas e interfaces.

En esta semana se incorpora programación concurrente para representar a varios repartidores trabajando de manera simultánea.

---

## Estructura principal

El proyecto contiene las siguientes clases:

### Pedido

Clase abstracta que representa la estructura general de un pedido.

Contiene información como:

- ID del pedido.
- Dirección de entrega.
- Distancia en kilómetros.

Además, contiene métodos relacionados con el comportamiento general de los pedidos.

### PedidoComida

Representa un pedido relacionado con entrega de comida.

### PedidoEncomienda

Representa un pedido correspondiente a una encomienda.

### PedidoExpress

Representa un pedido que requiere una entrega express.

### Repartidor

La clase `Repartidor` implementa la interfaz `Runnable`.

Cada repartidor posee:

- Un nombre.
- Una lista de pedidos asignados.

El método `run()` permite que el repartidor procese sus pedidos de manera secuencial dentro de su propio hilo.

Para simular el tiempo necesario para realizar cada entrega se utiliza:

`Thread.sleep()`

El tiempo de espera se genera de forma aleatoria.

---

## Interfaces utilizadas

El sistema reutiliza las interfaces desarrolladas anteriormente:

- `Despachable`
- `Cancelable`
- `Rastreable`

Estas interfaces permiten mantener una estructura reutilizable y organizada para los distintos tipos de pedidos.

---

## Programación concurrente

Para ejecutar varios repartidores de manera simultánea se utiliza:

`ExecutorService`

En la clase `Main` se crean tres repartidores:

- Camila
- Luis
- Diego

Cada repartidor posee dos pedidos asignados.

Los repartidores son ejecutados utilizando un grupo de tres hilos:

```java
ExecutorService executor = Executors.newFixedThreadPool(3);