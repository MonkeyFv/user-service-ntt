# PRUEBA PRÁCTICA - BACKEND MICROSERVICIO HICE CAMBIO 2

1.  Se requiere crear un microservicio REST que me permita consultar la información básica
   de uncliente.

2. Condiciones del servicio:

a. Es indispensable el manejo de códigos http en la respuesta (dentro del código es
necesario evidenciar el manejo de los siguientes 400, 404, 500 y 200).

b. Los únicos datos de entrada del servicio son tipo y número de documento, ambos son
obligatorios y para tipo de documento son únicamente válidos los tipos C (cédulade
ciudadanía) y P (Pasaporte).

c. Los datos que debe retornar el servicio son: (Deben estar “quemados”)

✓ Primer nombre

✓ Segundo nombre

✓ Primer apellido

✓ Segundo apellido

✓ Teléfono

✓ Dirección

✓ Ciudad de residencia

3. El puerto por el cual debe iniciar la aplicación es 8090.

4. Indispensable usar Spring y Maven.

5. Puede entregar la prueba y código fuente en un repositorio de su preferencia o en JAR.

PUNTOS RELEVANTES:

✓ Los datos de respuesta son mockeados, es decir solo se retornará información para el
cliente identificado con Cedula de ciudadanía 23445322.

✓ Son valores agregados, pero no obligatorios manejo de log de la aplicación,
pruebasunitarias y calidad de código.

✓ Puede utilizar el Ide de desarrollo que se sienta más cómodo.

✓ Se tendrá una sesión de 15 a 30 minutos para sustentar la prueba técnica

---
## Solución propuesta

---

## Arquitectura

Para este servicio se planteó una arquitectura limpia modular, se escoge esta arquitectura ya que, desacopla el core del negocio de la infraestructura, entre otras.


---

## Paradigma de programación

Se trabajó con programación orienta a objetos, programación funcional y programación reactiva.

---

## Testing

Se realizan pruebas unitarias a los casos de uso plantados.

Se realizan pruebas de integracion a los servicios rest.

---

## Docker

Pasos para crear la imagen y levantar el contenedor.

1. Empaquetar la aplicación:

mvn clean package ó mvn clean package -DskipTests

2. Construir la imagen:

docker build -t user-service -f deployment/Dockerfile .

3. Levantar el contenedor:

docker run -d -p 8090:8090 --name user-service user-service

---

