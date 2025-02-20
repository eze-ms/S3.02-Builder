# Proyecto Builder - Gestión de Pedidos de Pizza

## 📄 Descripción
Este proyecto implementa el **patrón de diseño Builder** para gestionar pedidos de pizza, permitiendo la configuración personalizada de tamaño, masa e ingredientes. La clase `MestrePizzer` facilita la construcción de pizzas utilizando diferentes `PizzaBuilder`.

## 🚀 Funcionalidad
- **Construcción de pizzas paso a paso**: Se usa el patrón **Builder** para definir tamaño, masa e ingredientes.
- **Diferentes tipos de pizzas**: Implementaciones como `HawaiianPizzaBuilder` y `VegetarianPizzaBuilder`.
- **Gestor de construcción (`MestrePizzer`)**: Recibe un `PizzaBuilder` y construye pizzas según la configuración definida.
- **Menú interactivo (`Menu.java`)**: Permite al usuario seleccionar y personalizar su pizza.
- **Encadenamiento de métodos (`Fluent Builder`)**: Permite una configuración clara y concisa.

## 💻 Tecnologías utilizadas
- **Java 17**
- **Maven** (para la gestión de dependencias y compilación)
- **IDE recomendado**: IntelliJ IDEA o cualquier compatible con Java.

## 📋 Requisitos
- **Java Development Kit (JDK)**: Versión 17.
- **Maven**: Sistema de construcción del proyecto.
- **Git** (opcional) para clonar el repositorio.

## 🛠️ Instalación
```bash
# Clonar el repositorio
git clone https://github.com/eze-ms/S3.02-Builder.git

# Compilar el proyecto con Maven
mvn clean package

# Ejecutar la aplicación
java -cp target/classes gm.Main
```
---
© 2025. Proyecto desarrollado por Ezequiel Macchi Seoane

