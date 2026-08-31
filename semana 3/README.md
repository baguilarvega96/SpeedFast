# SpeedFast

Proyecto académico desarrollado para la asignatura Desarrollo Orientado a Objetos II.

## Semana 1 - Polimorfismo

Durante esta semana se implementó un sistema de gestión de pedidos para la empresa SpeedFast aplicando conceptos de Programación Orientada a Objetos.

### Funcionalidades implementadas

- Clase base `Pedido`.
- Subclase `PedidoComida`.
- Subclase `PedidoEncomienda`.
- Subclase `PedidoExpress`.
- Herencia.
- Sobrescritura de métodos.
- Sobrecarga de métodos.
- Polimorfismo.
- Asignación automática y manual de repartidores.

## Tecnologías utilizadas

- Java
- IntelliJ IDEA
- Git
- GitHub
- ## Semana 2 - Clases Abstractas

Durante esta semana se amplió el sistema SpeedFast incorporando abstracción y cálculo de tiempos de entrega.

### Funcionalidades implementadas

- Clase abstracta `Pedido`.
- Atributo `distanciaKm`.
- Método `mostrarResumen()`.
- Método abstracto `calcularTiempoEntrega()`.
- Cálculo personalizado para `PedidoComida`.
- Cálculo personalizado para `PedidoEncomienda`.
- Cálculo personalizado para `PedidoExpress`.
- ## Semana 3 - Interfaces y gestión integral de pedidos

Durante esta semana se completó el sistema SpeedFast integrando abstracción, polimorfismo e interfaces.

### Funcionalidades implementadas

- Interfaces `Despachable`, `Cancelable` y `Rastreable`.
- Asignación automática de repartidores.
- Asignación manual mediante sobrecarga.
- Cálculo de tiempos de entrega según tipo de pedido.
- Reserva de pedidos.
- Despacho de pedidos.
- Cancelación de pedidos.
- Historial de operaciones mediante `ArrayList`.
- Uso de polimorfismo y sobrescritura.
- Simulación integral desde la clase `Main`.