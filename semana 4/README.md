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

Durante las semanas anteriores se desarrolló una estructura orientada a objetos utilizando una clase abstracta `Pedido`, subclases específicas e interfaces.

En esta semana se incorpora programación concurrente para representar a varios repartidores trabajando de manera simultánea.

---

## Clases utilizadas

### Pedido

Clase abstracta que representa la estructura general de un pedido.

Contiene atributos como:

- `idPedido`
- `direccionEntrega`
- `distanciaKm`

Además, incluye métodos como:

- `calcularTiempoEntrega()`
- `mostrarResumen()`

---

### PedidoComida

Representa un pedido relacionado con la entrega de comida.

---

### PedidoEncomienda

Representa un pedido correspondiente a una encomienda.

---

### PedidoExpress

Representa un pedido que requiere una entrega express.

---

### Repartidor

La clase `Repartidor` implementa la interfaz `Runnable`.

Cada repartidor posee:

- Un nombre.
- Una lista de pedidos asignados.

El método `run()` permite que el repartidor procese sus pedidos de manera secuencial dentro de su propio hilo.

Para simular el tiempo necesario para realizar cada entrega se utiliza:

```java
Thread.sleep(tiempoEspera);
```

El tiempo de espera se genera de forma aleatoria utilizando `ThreadLocalRandom`.

---

## Interfaces utilizadas

El sistema reutiliza las interfaces desarrolladas anteriormente:

- `Despachable`
- `Cancelable`
- `Rastreable`

Estas interfaces permiten mantener una estructura reutilizable y organizada para los distintos tipos de pedidos.

---

## Programación concurrente

Para ejecutar varios repartidores de manera simultánea se utiliza `ExecutorService`.

En la clase `Main` se crean tres repartidores:

- Camila
- Luis
- Diego

Cada repartidor posee dos pedidos asignados.

Los repartidores son ejecutados utilizando un grupo de tres hilos:

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
```

Luego cada repartidor es enviado al `ExecutorService`:

```java
executor.execute(camila);
executor.execute(luis);
executor.execute(diego);
```

De esta forma, los tres repartidores pueden realizar sus entregas de manera concurrente.

---

## Finalización de los hilos

Luego de enviar las tareas al `ExecutorService`, se utiliza:

```java
executor.shutdown();
```

Esto indica que no se recibirán nuevas tareas.

Posteriormente, el programa espera que todos los repartidores finalicen mediante:

```java
executor.awaitTermination(1, TimeUnit.MINUTES);
```

De esta manera, la simulación continúa hasta que todos los repartidores terminan sus entregas.

---

## Manejo de excepciones

El proyecto incorpora manejo de excepciones para controlar posibles interrupciones durante la ejecución de los hilos.

Dentro de la clase `Repartidor` se controla `InterruptedException`:

```java
try {
    Thread.sleep(tiempoEspera);
} catch (InterruptedException e) {
    System.out.println("La entrega fue interrumpida.");
    Thread.currentThread().interrupt();
}
```

También se controla una posible interrupción mientras el programa principal espera la finalización de todos los repartidores.

Esto permite evitar que el programa termine inesperadamente frente a una interrupción.

---

## Ejemplo de funcionamiento

Durante la ejecución se pueden visualizar mensajes similares a los siguientes:

```text
[Repartidor: Camila] Entregando PedidoComida #101...
[Repartidor: Luis] Entregando PedidoEncomienda #103...
[Repartidor: Diego] Entregando PedidoExpress #105...

[Repartidor: Camila] Pedido #101 entregado.
[Repartidor: Luis] Pedido #103 entregado.
[Repartidor: Diego] Pedido #105 entregado.
```

El orden de los mensajes puede cambiar en cada ejecución debido a que los repartidores están trabajando de manera concurrente.

Cuando cada repartidor termina sus pedidos, se muestra un mensaje indicando la finalización de sus entregas.

Finalmente, el programa muestra:

```text
=== TODAS LAS ENTREGAS HAN FINALIZADO ===
```

---

## Tecnologías utilizadas

- Java
- IntelliJ IDEA
- Programación Orientada a Objetos
- Programación concurrente
- `Runnable`
- `Thread.sleep()`
- `ExecutorService`
- `ThreadLocalRandom`
- Git
- GitHub

---

## Cómo ejecutar el proyecto

1. Abrir el proyecto en IntelliJ IDEA.
2. Ubicar la clase `Main.java`.
3. Ejecutar el método `main`.
4. Revisar la consola.
5. Observar cómo los repartidores realizan sus entregas de manera concurrente.
6. Esperar hasta que aparezca el mensaje final indicando que todas las entregas han finalizado.

---

## Estructura de la Semana 4

```text
semana 4
├── README.md
└── src
    └── cl
        └── speedfast
            ├── interfaces
            │   ├── Cancelable.java
            │   ├── Despachable.java
            │   └── Rastreable.java
            ├── Main.java
            ├── Pedido.java
            ├── PedidoComida.java
            ├── PedidoEncomienda.java
            ├── PedidoExpress.java
            └── Repartidor.java
```

---

## Autor

Byron Aguilar

Desarrollo Orientado a Objetos II  
Duoc UC