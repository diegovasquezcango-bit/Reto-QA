# Proyecto de Automatización - Serenity BDD

Este archivo **README.md** forma parte del proyecto y describe cómo ejecutar las pruebas automatizadas y consultar los resultados.

El proyecto implementa pruebas E2E del flujo de compra en:

https://www.saucedemo.com/

Utiliza Serenity BDD con el patrón Screenplay, Cucumber y JUnit 5.

---

## Requisitos

* Java JDK 17 o superior
* Maven 3.9.x o superior
* Google Chrome

---

## Ejecución de pruebas

Ubicarse en la raíz del proyecto (donde está el archivo `pom.xml`) y ejecutar:

```bash
mvn clean verify
```

Este comando compila el proyecto, ejecuta los escenarios y genera los reportes.

---

## Reportes

Los reportes de Serenity se generan automáticamente en la siguiente ruta:

```text
target/site/serenity/index.html
```

Abrir este archivo en el navegador para visualizar los resultados de ejecución.

---

## Estructura del proyecto

```text
src/test/java
  ├── models
  ├── tasks
  ├── questions
  ├── ui
  ├── stepdefinitions
  └── runners

src/test/resources
  ├── features
  └── data
```

---

## Datos de prueba

Los datos de prueba se gestionan mediante archivos JSON ubicados en:

```text
src/test/resources/data/
```

---

## Notas

* Se recomienda cerrar todas las ventanas de Chrome antes de ejecutar
* Se recomienda ejecutar las pruebas mediante Maven para asegurar la correcta generación de reportes

---
