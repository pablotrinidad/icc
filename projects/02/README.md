# Proyecto 02 - Autómatas

Aplicación que simula tres modelos basados en autómatas celulares:

1. Actividad sísimica
2. Propagación de epidemias
3. Incendios forestales

## Arquitectura de la aplicación

Todo el código fuente se encuentra dentro de `src`. Dentro se divide en dos
paquetes, `app` y `simulations`. `app` mantiene el código principal que
se encarga de preguntarle al usuario, a través de un menú en la consola,
que simulación quiere correr y recolectar los datos específicos por simulación.


`simulations` es el paquete que contiene lo siguiente:

 * **`Simulation.java`**: Clase abstracta que expone el método `run` para iniciar
 la simulación así como definir firmas que las demás clases tienen que implementar.
 * **`Automata.java`**: Clase abstracta que define los atributos generales de
 todos los autómatas así como las firmas que tienen que implementar los hijos.
 * **`Plot.java`**: Clase que recibe los datos de una simulación y genera una gráfica
 lineal de los resultados (células críticas vs células normales)

Por cada simulación existe un submódulo: `outbreak` (propagación de epidemias),
`seismic` (actividad sísimica) y `wildire` (incendios forestales). Dentro de
cada módulo se declaran dos clases, la de simulación (hereda de `Simulation`)
y la de autómata (hereda de `Automata`) las cuales se encargan de inicializar
las simulaciones y controlar la evolución respectivamente.

## Uso

Se incluye un archivo `run.sh` con todas las rutinas necesarias para iniciar
la aplicación. Para utilizarlo es necesario que se use Java 11 y se haya
descargado JavaFX, JavaFX tiene que estar ubicado en `~/.java/libraries/javafx-sdk-11.0.1/lib`.
El archivo `run.sh` expone la variable `JAVAFX_PATH` que puede ser configurada
con la ubicación de JavaFX.

Para usar el archivo, se tienen que seguir los siguientes pasos:

1. Convertir en al archivo en ejecutable: **`$ chmod +x run.sh`**
2. Correr el archivo: **`./run.sh`**

## Datos del alumno

* **Nombre:** Pablo Angel Trinidad Paz
* **No. de cuenta:** 419004279
