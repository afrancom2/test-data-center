# ⚙️ Backend - Test Data Center Recargas App

Este proyecto es el backend de una aplicación para realizar recargas de diferentes operadores, construido con **Spring Boot 3**, **H2**, y documentado con **Swagger / OpenAPI**.

---

## ✅ Requisitos Previos

- Puerto `8080` libre en tu máquina

---

## ▶️ Ejecución del Proyecto

1.  Clona el repositorio:

   ```bash
   git clone https://github.com/afrancom2/test-data-center
   cd test-data-center
   ```

2.  Abre el proyecto preferiblemente con **IntelliJ IDEA** ya que se usa Lombok

3.  Ejecuta la app desde el archivo `TestApplication.java`

4.  Accede a la documentación Swagger:

   [http://localhost:8080/data-center/swagger-ui.html](http://localhost:8080/data-center/swagger-ui.html)

---

## 📄 Documentación Swagger

 Swagger UI disponible en:

[http://localhost:8080/data-center/swagger-ui.html](http://localhost:8080/data-center/swagger-ui.html)

---

## 🔗 Endpoints Disponibles

|  Método  |  Endpoint                          |  Descripción                                |
|----------|------------------------------------|---------------------------------------------|
| GET      | `/operator`                        | Lista todos los operadores                  |
| GET      | `/sale`                            | Lista todos los vendedores                  |
| POST     | `/recharge`                        | Registrar recarga                           |
| GET      | `/recharge/by-sale`                | Lista de recargas por vendedor              |
| GET      | `/recharge/by-operator`            | Lista de recargas por operador              |
| GET      | `/recharge/by-operator-and-sale`   | Lista de recargas por operador y vendedor   |
| GET      | `/recharge`                        | Lista de todas las recargas                 |

---

## 🗂️ Estructura del Proyecto

```
com.data.center.api
├── config               #  Configuración de data inicial y CORS
├── controller           #  Controladores REST y manejo de errores
├── domain               #  Entidades JPA (Operator, Recharge, Sale)
├── infraestructure      #  Lógica de negocio
├── models               #  Request y response
├── util                 #  Enums y excepciones
└── resources
    └── application.properties
```

---

## 🛠️ Tecnologías Utilizadas

-  Java 17  
-  Spring Boot 3.X  
-  PostgreSQL  
-  Swagger / Springdoc OpenAPI  
-  IntelliJ IDEA Community  

---

## 👨‍💻 Autor

**Andrés Felipe Franco Monroy**  
🔗 GitHub: [afrancom2](https://github.com/afrancom2)  
📧 Email: afrancom2@gmail.com
