# Parcial TFI

## Pasos para probar la solución
- Levantar RabbitMQ con `docker-compose up` 
	- Toma unos segundos en terminar de levantar
	- Consola: `http://localhost:15672` 
		- User: `guest`
		- Passwrd: `guest`
- Levantar el servicio API rest (`rest-service`), ya que es quien crea los canales de las colas
- Levantar el print server
- Levantar el cliente
	- Click en `Generar 10 Archivos`
		- Esto genera 10 archivos con contenido aleatorio. Idealmente los archivos serían convertidos a string base 64.
		- La prioridad queda en 1
		- El nombre del archivo está basado en el indice del archivo
	- Click en `Enviar Archivos`
		- La API rest devuelve el id de proceso.
		- Con este ID podemos buscar el estado de la impresión del archivo
	- Click en `Obtener Estado`
		- Se consulta a la API usando los ID de procesamiento.
		- Los resultados son mostrados según el estado de la impresión
		- Si hubo impresiones fallidas, se activa el botón `Reprocesar fallidos`.
	- Click en `Reprocesar fallidos`
		- Se envían nuevamente los documentos a la API y se obtiene un nuevo id de proceso para cada uno
		- Se habilita el botón de `Obtener Estado`, y el proceso se repite en caso de que vuelvan a ocurrir impresiones fallidas
	- En cualquier momento se pueden generar 10 nuevos documentos, en caso de que no haya habido impresiones fallidas

## Ejemplos de Requests
### Envio de documento
Endpoint: `localhost:8080/print`
```json
{
  "content":"byte array del archivo",
  "priority":1,
  "filename":"nombre de archivo"
}
```

### Consulta de estado
Endpoint: `http://localhost:8080/getStatus?id=`
En valor de `id` es el id devuelto al momento de enviar el archivo.
