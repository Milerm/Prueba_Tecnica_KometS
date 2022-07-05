# Prueba_Tecnica_KometS
# FlowersAPIRest
API Rest con Programacion Funcional

## Descripción
Se expone un API Rest con sus end-points y utilizando Streams API, ademas se añaden pruebas unitarias usando JUnit

## Endpoints
- POST: http://localhost:8080/flowers: Recibe un array de objetos Flower y se almacena en memoria:
  Body: [
  {
  "id": "1",
  "name": "rosa negra",
  "price": 10.5
  },
  {
  "id": "2",
  "name": "rosa roja",
  "price": 15.7
  },
  {
  "id": "3",
  "name": "girasol",
  "price": 20.3
  },
  {
  "id": "4",
  "name": "gardenias",
  "price": 25.8
  },
  {
  "id": "5",
  "name": "clavel",
  "price": 30.2
  }
  ]
- GET: http://localhost:8080/flowers: Devuelve la lista de objetos Flower almacenada en memoria, ordenadas descendentemente por el atributo "name" y concatenada la cadena "-kometsales"
- GET: http://localhost:8080/flowers/{price-filter}: Devuelve una lista de objetos Flower cuyo precio sea mayor a 20
- DELETE: http://localhost:8080/flowers/{id}: Borra un objeto Flower de la lista, cuyo id sea el parámetro {id}
- GET: http://localhost:8080/flowers/{name}: Devuelve una lista de objetos Flower cuyo nombre coincida con el parámetro {name}
- UPDATE: http://localhost:8080/flowers/{id}: Actualiza un objeto Flower de la lista, cuyo id sea el parámetro {id}

