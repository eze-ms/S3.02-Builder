# Proyecto Builder - Gestión de Pedidos de Pizza

## 📄 Descripción
Este proyecto implementa el **patrón de diseño Builder** para gestionar pedidos de pizza, permitiendo la configuración personalizada de **tamaño, masa e ingredientes**.

### ✅ Características principales
- **`PizzaBuilder` como clase interna de `Pizza`**: Sigue la estructura recomendada en el artículo del mentor.
- **Gestión de pedidos con `MestrePizzer`**: Actúa como **servicio** para construir pizzas según la configuración del usuario.
- **Menú interactivo (`Menu.java`)**: Permite seleccionar y personalizar pizzas mediante consola.
- **Gestor de preparación (`GestorPizzas.java`)**: Separa la lógica de creación de pizzas del menú, aplicando el principio de responsabilidad única.
- **Validación de entrada con `EntradaInvalidaException`**: Maneja errores y evita entradas incorrectas.

---

## 🚀 Funcionalidad
- **Construcción de pizzas paso a paso**: El patrón **Builder** permite definir tamaño, masa e ingredientes de manera flexible.
- **Menú interactivo**: El usuario puede seleccionar pizzas predefinidas o crear una personalizada.
- **Validaciones robustas**: Se evita la entrada de valores inválidos en tamaño y tipo de masa.
- **Fluent Builder**: Permite encadenar métodos para una configuración clara y concisa.

---

## 💻 Tecnologías utilizadas
- **Java 17**
- **Maven** (gestión de dependencias y compilación)
- **IDE recomendado**: IntelliJ IDEA o cualquier compatible con Java

---

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

