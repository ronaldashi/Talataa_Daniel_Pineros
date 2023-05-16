# Prueba Talataa

Se trata de una aplicación básica que utiliza la API del proyecto The Movie DataBase para acceder, analizar y mostrar la información a través de los puntos finales mencionados en la sección de Uso.

# Requisitos
* Java 8+
* Maven 3+
* Swagger 3.0
* Docker 23.0.5
## Documentacion

 - [Documentacion The Movie DB](https://www.themoviedb.org/documentation/api)
 - [Documentacion Docker](https://docs.docker.com/)
 - [Documentacion Swagger UI](https://swagger.io/docs/)


## Deployment

To deploy this project run

```bash
  npm run deploy
```
# Instalación
- Clonar el repositorio: 
```bash
git clone https://github.com/ronaldashi/Talataa_Daniel_Pineros.git
``` 
```bash
cd Talataa_Daniel_Pineros
```
Compilar la aplicación: 
```bash
mvn clean package
```
Ejecutar la aplicación: 
```bash
java -jar target/Talataa_Daniel_Pineros.jar
```
# Referencia API

## Controlador de Peliculas

#### Obtener todas las peliculas

```http
  GET /peliculas
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `peliculas` | `string` | **Required**. |

#### Obtener pelicula por id

```http
  GET /peliculas/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id de la pelicula |


#### Agregar calificacion de pelicula por id

```http
  POST /peliculas/calificacion/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `calificacion`      | `string` | **Required**. Calificacion de la pelicula |
| `id`      | `string` | **Required**. Id de la pelicula |

#### Eliminar calificacion de pelicula por id

```http
  DELETE /peliculas/calificacion/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `calificacion`      | `string` | **Required**. Calificacion de la pelicula |
| `id`      | `string` | **Required**. Id de la pelicula |


```http
  DELETE /peliculas/calificaciones/
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `calificaciones`      | `string` | **Required**. Calificaciones de las peliculas |







## Autor

- [@ronaldashi](https://www.github.com/ronaldashi)

## Despliegue - Demo


 - [Despliegue en Azure](https://talataadanielpineros.azurewebsites.net/swagger-ui/)
