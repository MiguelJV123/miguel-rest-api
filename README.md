\# 🚀 API de Usuarios – Spring Boot REST



\*\*Avance 1\*\*  

CRUD de usuarios en memoria con validaciones y manejo global de errores.  

Este proyecto sirve como base para entender cómo exponer una API REST usando Spring Boot, buenas prácticas de validación y manejo de excepciones.



---



\## 🛠️ Tecnologías utilizadas

\- Java 17  

\- Spring Boot 3.3.2  

\- Maven  

\- Postman (para pruebas de la API)



---



\## ▶️ Cómo correr el proyecto



Clonar el repositorio y ejecutar:



mvn spring-boot:run



La API quedará disponible en:



http://localhost:8080



---



\## 📌 Endpoints disponibles



| Método | Endpoint              | Descripción                   |

|--------|-----------------------|-------------------------------|

| GET    | `/api/health`         | Verifica que la API esté viva |

| GET    | `/api/usuarios`       | Lista todos los usuarios      |

| GET    | `/api/usuarios/{id}`  | Obtiene un usuario por id     |

| POST   | `/api/usuarios`       | Crea un nuevo usuario         |

| PUT    | `/api/usuarios/{id}`  | Actualiza un usuario          |

| DELETE | `/api/usuarios/{id}`  | Elimina un usuario            |



---



\## 📄 Ejemplos de uso



\### Crear un usuario (POST `/api/usuarios`)

{

&nbsp; "nombre": "Miguel",

&nbsp; "email": "miguel@test.com"

}



Respuesta esperada:

{

&nbsp; "id": 1,

&nbsp; "nombre": "Miguel",

&nbsp; "email": "miguel@test.com"

}



---



\### Actualizar un usuario (PUT `/api/usuarios/1`)

{

&nbsp; "nombre": "Miguel J.",

&nbsp; "email": "mj@test.com"

}



Respuesta esperada:

{

&nbsp; "id": 1,

&nbsp; "nombre": "Miguel J.",

&nbsp; "email": "mj@test.com"

}



---



\### Errores manejados

La API devuelve errores estandarizados en formato JSON:



\- 400 Bad Request → Datos inválidos en el body.  

\- 404 Not Found → Usuario no encontrado.  



Ejemplo:

{

&nbsp; "timestamp": "2025-09-04T19:40:01.123+00:00",

&nbsp; "status": 404,

&nbsp; "error": "Not Found",

&nbsp; "message": "Usuario no existe",

&nbsp; "path": "/api/usuarios/999"

}



---



\## 📂 Postman

Incluye una colección con todos los endpoints para probar en Postman:  

`/postman/APIUsuarios.postman\_collection.json`



---



\## 🔜 Próximos Avances

\- Avance 2: Persistencia real con JPA + MySQL/H2.  

\- Avance 3: Documentación con Swagger + seguridad básica (JWT).  

\- Avance 4: Dockerización y despliegue en la nube.  

\- Avance 5: Monitoreo, métricas y optimización.



---



✍️ Autor: Miguel JV  

📅 Proyecto Personal 



