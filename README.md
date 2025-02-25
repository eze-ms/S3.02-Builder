# Proyecto Builder - Gestión de Pedidos de Pizza

## 📄 Descripción
Este proyecto implementa el **patrón de diseño Builder** en **Java** para gestionar pedidos de pizza, permitiendo la configuración personalizada de **tamaño, masa e ingredientes**.

### Características principales
- **Gestor de construcción (`MestrePizzer`)**: Actúa como **Director**, organizando la construcción de pizzas predefinidas y personalizadas.
- **Menú interactivo (`Menu.java`)**: Permite a los usuarios seleccionar y personalizar pizzas desde la consola.
- **Constructor flexible (`PizzaBuilder`)**: Implementa la interfaz `Builder` y permite la creación fluida de pizzas.
- **Validación de entrada**: Se evita la introducción de valores inválidos para el tamaño y la masa.

---

## Funcionalidad
- **Construcción de pizzas paso a paso**: Se utiliza el **patrón Builder** para definir **tamaño, masa e ingredientes** de manera estructurada.  
- **Menú interactivo**: El usuario puede elegir entre pizzas predefinidas (**Hawaiana**, **Vegetariana**) o crear una personalizada.  
- **Uso de `MestrePizzer` como Director**: Se encarga de coordinar la construcción de las pizzas mediante `PizzaBuilder`.  
- **Encadenamiento fluido (`Fluent Builder`)**: Permite configurar las pizzas de forma clara y concisa con llamadas encadenadas.

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

```
---
© 2025. Proyecto desarrollado por Ezequiel Macchi Seoane

