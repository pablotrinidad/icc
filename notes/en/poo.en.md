# Object Oriented Programming

Object Oriented Programming is a programming paradigm for designing Software Systems.
OOP is not a way to design algorithms but your data, your program, your system. 

## Class

A class is a template (blueprint) for objects, it defines the properties an object has.
The properties and the objects themselves are abstractions, generalizations of nous.
A very special property of objects are functions that when belonging to an object are called **methods**. Functions are also data. 

An object is a data container, a class is the form the container has.

### Abstract Data Types

A data type defined by its semantic (its behaviour), these are defined based on basic data types (integer, float, boolean, etc).

### Composite Data Type

A composite data type that is derived from the basic data types, the ways they are combined are called **Data Structures**.

# Questions made by @diegojardonc

### Wrapper

A design pattern. An object that contains (wraps) another object, controlling or limiting its "API", its way of interacting with another classes. All primitived data types do have a Wrapper in Java. 

### Extrapolación de cadenas en XML

Para hacer referencia a una variable en XML puedes hacer extrapolación dentro de sus cadenas.

```xml
<property name="prop" value="val2"/>
<tag arg="${prop}"/>
```

### Constructor en Java

Un constructor también puede ser ```private``` en Java. Inhibiendo el acceso desde fuera de la clase.
Por defecto, los constructores son ```public```.

### Encapsulación

Cómo llegar de las precondiciones a las postcondiciones se encapsula, se protege, *¿De quién?*, te preguntaras, **de ti mismo**.