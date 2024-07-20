<h1 align="center">API REST FuelRoute</h1>
<div style="display: inline_block"><br><br>
 <p align="center">
  <a href="#" target="_blank"><img align="center" alt="JAVA" height="84" width="84" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg"></a>
  <a href="#" target="_blank"><img align="center" alt="SPRING" height="84" width="84" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg"></a>
  <a href="#" target="_blank"><img align="center" alt="MAVEN" height="84" width="84" src="https://www.svgrepo.com/show/373829/maven.svg"></a>
  <a href="#" target="_blank"><img align="center" alt="SWAGGER" height="84" width="84" src="https://www.svgrepo.com/show/374111/swagger.svg" /></a>
  <a href="#" target="_blank"><img align="center" alt="Docker" height="84" width="84" src="https://www.svgrepo.com/show/452192/docker.svg" /></a>
  <a href="#" target="_blank"><img align="center" alt="Intellijidea" height="84" width="84" src="https://www.svgrepo.com/show/306240/intellijidea.svg" /></a>
  <a href="#" target="_blank"><img align="center" alt="Postman" height="84" width="84" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original.svg" /></a>
  </p>
 </div>

***

* :argentina: Adrian Camus [LinkedIn](https://www.linkedin.com/in/acamus79/ ) - [GitHub](https://github.com/acamus79)



## Desafio

>Una estación esta definida por un nombre. Mientras que un camino, se encuentra definido por un
costo, una estación origen, y otra estación destino (bidireccional). El objetivo es ofrecer una solución
para consultar sobre el camino óptimo para transitar desde una estación A, hasta una estación B
minimizando costos.

## Solución

Al principio, fue un desafío conceptualizar la solución sin utilizar SQL. Sin embargo, me di cuenta de que el problema se podía resolver utilizando teoría de grafos. En este enfoque, cada estación se representa como un nodo del grafo y las rutas entre estaciones, con sus respectivos costos, se representan como los pesos de las aristas. Decidí utilizar el algoritmo de Dijkstra, conocido por encontrar caminos mínimos en grafos ponderados.

## Implementación
He desarrollado un servicio REST que permite obtener el camino más óptimo entre dos estaciones de servicio. El servicio cuenta con los siguientes endpoints:

- POST /stations: Carga de estaciones de servicio.
- POST /routes: Carga de rutas entre estaciones, incluyendo los costos.
- GET /optimal-route: Consulta del camino óptimo entre dos estaciones específicas.

## Pruebas
Se han implementado pruebas unitarias para verificar el correcto funcionamiento del controlador, del servicio y del algoritmo de Dijkstra.

## Algoritmo de Dijkstra
El algoritmo de Dijkstra, 

El [algoritmo de Dijkstra](https://es.wikipedia.org/wiki/Algoritmo_de_Dijkstra), también conocido como algoritmo de caminos mínimos, es un método eficiente para determinar el camino más corto desde un vértice de origen a todos los demás vértices en un grafo ponderado. Fue descrito por primera vez por Edsger Dijkstra en 1959.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.3.1
- Maven
- Swagger
- Docker
- Como IDE se utilizo IntelliJ IDEA 2023.1.4
- También utilice Postman v11.3.2

## Cómo ejecutar

  1. Clona el repositorio:
  ``` git clone https://github.com/acamus79/FuelRoute.git ```

#### <em>Si tienes docker desde el directorio raíz, puedes ejecutar el comando ``docker-compose up``, para descargar la imagen compilada desde mi repositorio personal docker hub.</em>

- Para Docker también puedes utilizar unos scripts de bash o de powershell que estan en la raiz del repositorio
  - buildandrun.sh (linux bash)
  - buildandrun.ps1 (Windows Powershell)

Si no tienes docker deberás tener java 17 instalado, se puede ejecutar seguiendo estos pasos:

  1. Navega al directorio del proyecto: ``` cd fuelRoute ```
  2. Ejecutar el proyecto ``` mvn spring-boot:run ```
     - o si lo prefieres compilar el proyecto: ``` mvn clean install ```
     - Ejecuta la aplicación compilada: ``` java -jar target/fuelRoute-0.0.1-SNAPSHOT.jar ```

La aplicación estará disponible en `http://localhost:8080`.

## Accede a la documentación de la API:

A través de Swagger cuando la aplicación se esta ejecutando

| Documentacion |                                                    Link                                                     |
| :-----------: | :---------------------------------------------------------------------------------------------------------: |
|    SWAGGER    | <a href="http://localhost:8080/swagger-ui/index.html" target="_blank">LINK</a> (sólo si se está ejecutando) |

![imagen](https://github.com/user-attachments/assets/20a2117c-e552-4de6-a71f-0164a1a94dd1)
  
_____
<p align="center">
 <a href="https://acamus79.github.io" target="_blank"><img align="center" alt="Portfolio"  src="https://forthebadge.com/images/badges/built-with-love.svg"></a>
 <a href="#" target="_blank"><img align="center" alt="Daugther"  src="https://github.com/acamus79/StoreChallenge/assets/85143329/f5dda3bd-81cb-4ece-9a60-4c7ae215fa88"></a>
 <a href="#" target="_blank"><img align="center" alt="myMachine"  src="https://github.com/acamus79/StoreChallenge/assets/85143329/5f6c41aa-4209-44b4-8eb7-62f6163c23a7"></a>
</p>
