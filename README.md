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

Para realizar esta desafio me costo mucho pensar la solucion sin untilizar SQL, pero al hacerlo me di cuenta de que se podria resolver utilizando grafos y pense que cada estacion seria un nodo del grafo las rutas el costo de las rutas el peso de cada arista, y entonces decidi utilizar el el algoritmo de los caminos minimos.

Implemente un servicio REST para obtener el camino mas optimo entre dos estaciones de servicio. Se han implementado tres endpoints: dos de tipo POST uno para cargar estaciones de servicio, otro endpoint para cargar las rutas entre estaciones y un endpoint de tipo GET para obtener el camino optimo entre estaciones

Además, se han implementado pruebas unitarias para el controlador, el servicio, y para el algoritmo.

El [algoritmo de Dijkstra](https://es.wikipedia.org/wiki/Algoritmo_de_Dijkstra), también llamado algoritmo de caminos mínimos, es un algoritmo para la determinación del camino más corto dado un vértice origen al resto de los vértices en un grafo con pesos en cada arista. Su nombre se refiere a Edsger Dijkstra, quien lo describió por primera vez en 1959.

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

## Endpoints

  - POST /api/stations
  - POST /api/routes
  - GET /api/optimal-route


![imagen](https://github.com/user-attachments/assets/20a2117c-e552-4de6-a71f-0164a1a94dd1)
  
_____
<p align="center">
 <a href="https://acamus79.github.io" target="_blank"><img align="center" alt="Portfolio"  src="https://forthebadge.com/images/badges/built-with-love.svg"></a>
 <a href="#" target="_blank"><img align="center" alt="Daugther"  src="https://github.com/acamus79/StoreChallenge/assets/85143329/f5dda3bd-81cb-4ece-9a60-4c7ae215fa88"></a>
 <a href="#" target="_blank"><img align="center" alt="myMachine"  src="https://github.com/acamus79/StoreChallenge/assets/85143329/5f6c41aa-4209-44b4-8eb7-62f6163c23a7"></a>
</p>
