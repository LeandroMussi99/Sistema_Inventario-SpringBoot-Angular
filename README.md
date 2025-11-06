# 📦 Sistema de Inventario (Spring Boot + Angular)

Aplicación **full stack** para la gestión de productos de inventario.  
El backend expone una **API REST** con **Spring Boot**, y el frontend proporciona una interfaz en **Angular** para listar, crear, editar y eliminar productos.

---

## 🖼️ Vista previa

### 📋 Inventario

<img width="1423" height="580" alt="Inventario" src="https://github.com/user-attachments/assets/3d25f648-9b4d-4397-b0db-e2fc7b73d88d" />

### ➕ Agregar Producto

<img width="1422" height="558" alt="agregar" src="https://github.com/user-attachments/assets/1eb89611-24ae-4705-a593-1e87f2f96eee" />

### ✏️ Editar Producto

<img width="1422" height="506" alt="editar" src="https://github.com/user-attachments/assets/ab7e72ef-e9bc-459e-8d79-34b9eb5ecef3" />

---

## 🧩 Estructura del Proyecto
```text
Sistema_Inventario-SpringBoot-Angular/
├── inventarios/ # Backend (Spring Boot)
│ ├── modelo/ # Entidades JPA
│ ├── repositorio/ # Interfaces JpaRepository
│ ├── servicio/ # Lógica de negocio
│ └── controlador/ # Controladores REST
└── inventario-app/ # Frontend (Angular)
├── app/ # Componentes y servicios
└── assets/ # Estilos e imágenes
```


---

## ⚙️ Tecnologías Utilizadas

| Capa | Tecnologías |
|------|--------------|
| **Backend** | Java 21 · Spring Boot 3.5.7 · Spring Data JPA · MySQL |
| **Frontend** | Angular 20 · TypeScript · HTML · CSS · Bootstrap |
| **Herramientas** | Maven · Node.js · Angular CLI |

---

## 🔧 Configuración del Backend (`inventarios/`)

1. **Configurar conexión a MySQL:**  
   Editá el archivo [`src/main/resources/application.properties`](inventarios/src/main/resources/application.properties):

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/inventario_db?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=1214

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

2. Ejecutar el servidor:
   cd inventarios
   ./mvnw spring-boot:run

3. Endpoints disponibles:

| Método   | Ruta                             | Descripción                     |
| -------- | -------------------------------- | ------------------------------- |
| `GET`    | `/inventario-app/productos`      | Lista todos los productos       |
| `POST`   | `/inventario-app/productos`      | Crea un nuevo producto          |
| `GET`    | `/inventario-app/productos/{id}` | Obtiene un producto por ID      |
| `PUT`    | `/inventario-app/productos/{id}` | Actualiza un producto existente |
| `DELETE` | `/inventario-app/productos/{id}` | Elimina un producto por ID      |


## 💻 Configuración del Frontend (inventario-app/)

1. Instalar dependencias:
    cd inventario-app
    npm install

2. Ejecutar el servidor de desarrollo: ng serve -o
El frontend se ejecutará en: http://localhost:4200/


## 🚀 Flujo de Trabajo

1. Iniciá el backend (./mvnw spring-boot:run)
2. Levantá el frontend (ng serve -o)
3. Accedé a http://localhost:4200/ para:
    - Visualizar el inventario.
    - Agregar nuevos productos.
    - Editar o eliminar productos existentes.


## 🧠 Descripción de Componentes

🔹 Backend (Spring Boot)

- Producto.java → Entidad JPA (descripcion, precio, existencia).
- ProductoRepositorio.java → Interfaz JpaRepository (CRUD).
- ProductoServicio.java → Lógica de negocio y persistencia.
- ProductoControlador.java → Endpoints REST con CORS y manejo de errores.

🔹 Frontend (Angular)

- producto.service.ts → Comunicación HTTP con el backend.
- producto-lista → Listado de productos y acciones.
- agregar-producto → Formulario de alta.
- editar-producto → Formulario de edición.
- app.routes.ts → Definición de rutas y navegación.


   
