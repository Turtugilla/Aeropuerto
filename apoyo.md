# Guía Errores Comunes Etapas 9-12
## Base de datos Apache Derby
### Al iniciar
Forma de Reproducir: Iniciando la base de datos desde netbeans.
Si aparece una ventana como la de la siguiente imagen una manera de solucionar es iniciando como administrador Apache Netbeans.
![Error 40,000](https://i.imgur.com/sFdMelw.png)

## Formatos
### Nombres de Columnas
Los nombres de las columnas que se agregan en las etiquetas Column y JoinColumn no deben contener espacios y de preferencia tampoco acéntos
```java
@JoinColumn(name="fecha nacimiento") // INCORRECTO
```
```java
@JoinColumn(name="FECHA_NACIMIENTO") // CORRECTO
```
### Lógica de los JoinColumn
