# Desarrollo de Software - Back-End
## Trabajo Práctico de JPA N.° 1

Alumno: Sebastián Ogás (legajo 48867)

Tecnologías usadas:
* IntelliJ IDEA 2023.2.1
* Java 18.0.1.1
* Spring Boot 3.1.3
* Gradle 8.3
* Dependencias indicadas por la cátedra

Puerto utilizado para acceso al servidor web: 8081

[Consola de H2](http://localhost:8081/h2-console/)

JDBC URL: jdbc:h2:mem:./sebadb

Usuario: sa

Contraseña: (no tiene)

### Contenido
El trabajo práctico presentado contiene en sus respectivos paquetes a las clases de entidad y a los repositorios correspondientes a estas.

Además, en la clase principal (Jpatp1Application.java) se encuentra hardcodeado un conjunto de datos de muestra, el cual más abajo es accedido y mostrado mediante la consola de java, realizando dos consultas:
1. Se muestran los datos del cliente de id = 1 (el único añadido), con sus domicilios, pedidos y la factura y los detalles de estos.
2. Se muestran todos los datos de todos los rubros (dos en el conjunto de datos cargado) y los productos que abarcan.

### Conclusiones
Me resultó muy interesante saber cómo es la implementación de un back-end mediante java, ya que mi escasa experiencia en esta área fue utilizando PHP y ASP Clásico.

Fuera de algunos problemas surgidos durante la instalación de las herramientas necesarias para el desarrollo del Trabajo Práctico, no tuve mayores inconvenientes. El mapeo automático de las clases de entidad a las tablas de la base de datos me resultó muy sencillo de implementar.

La mayor dificultad fue probablemente entender cómo funciona el "cascadeo" al guardar objetos en la base de datos. En un principio intentaba tener una variable de repositorio para todas las clases de entidad en main, hasta que finalmente noté que solo las necesitaba para las clases "Cliente" y "Rubro", pues las asociaciones a otras clases (con cascade = CascadeType.ALL) automatizaban sus inserciones.
