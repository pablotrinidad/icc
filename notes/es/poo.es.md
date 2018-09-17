# Programación orientada a objetos

La programación orientada a objetos es un paradigma de programación para diseñar sistemas de Software.

La programación orientada a objetos no está pensada para diseñar algoritmos, la lógica de programación, sino para manejar los datos de tu programa, para diseñar sistemas.

## Clase

Es una plantilla de objetos, qué forma tienen, qué propiedades tienen y/o qué pueden hacer.
Todo esto son abstracciones, generalizaciones, puedes *definir* sustantivos abstractos o físicos.

Un objeto tiene propiedades, datos, un objeto es un contenedor, una clase es la forma que toma el recipiente, un tipo de dato en especial que tiene un objeto son funciones, cuando se definen funciones en clases, es decir como propiedades de objetos se llaman **métodos**.

Cómo llegar de las precondiciones a las postcondiciones se encapsula, se protege, *¿De quién?*, te preguntaras, **de ti mismo**.

### Tipos de dato abstracto

Clases que representan un tipo de dato, si los que tiene Java no te alcanzan puedes diseñar los tuyos.
Estos están definidos en base a tipos de dato básicos (entero, flotante, buleano, etc).

### Tipos de datos compuestos

Son tipos de datos definidos como composiciones de los tipos de dato básicos como los enteros, buleanos, flotantes.
Las formas en que los datos compuestos de hacen resultan en lo que se conoce como **estructuras de datos**.

# Preguntas por @diegojardonc

### Wrapper 

Un patrón de diseño. Un objeto que contiene a otro objeto, controlando su "API".
Todos los primitivos tienen su Wrapper, e.g. ```int``` tiene a ```Integer```.

### Extrapolación de cadenas en XML

Para hacer referencia a una variable en XML puedes hacer extrapolación dentro de sus cadenas.

```xml
<property name="prop" value="val2"/>
<tag arg="${prop}"/>
```

### Constructor en Java

Un constructor también puede ser ```private``` en Java. Inhibiendo el acceso desde fuera de la clase.
Por defecto, los constructores son ```public```.