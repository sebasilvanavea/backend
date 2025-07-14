# Spring Boot Railway Demo

Este es un proyecto de ejemplo de Spring Boot configurado para desplegarse en Railway.

## Características

- ✅ Configurado para usar la variable de entorno `PORT` de Railway
- ✅ Endpoint de ejemplo `/api/hello` para probar el despliegue
- ✅ Endpoint de health check `/api/health`
- ✅ Configuración para PostgreSQL usando variables de entorno
- ✅ Listo para desplegar en Railway

## Endpoints disponibles

- `GET /api/hello` - Endpoint de prueba principal
- `GET /api/health` - Health check para Railway

## Variables de entorno necesarias

### Para Railway (automáticas)
- `PORT` - Puerto asignado por Railway (se configura automáticamente)

### Para PostgreSQL (opcionales)
- `SPRING_DATASOURCE_URL` - URL de conexión a PostgreSQL
- `SPRING_DATASOURCE_USERNAME` - Usuario de la base de datos
- `SPRING_DATASOURCE_PASSWORD` - Contraseña de la base de datos

## Despliegue en Railway

### Opción 1: Desde GitHub (Recomendado)

1. Sube este proyecto a un repositorio de GitHub
2. Ve a [Railway](https://railway.app) y crea una cuenta
3. Haz clic en "New Project" → "Deploy from GitHub repo"
4. Selecciona tu repositorio
5. Railway detectará automáticamente que es un proyecto Java/Maven
6. El proyecto se desplegará automáticamente

### Opción 2: Desde Railway CLI

1. Instala Railway CLI: `npm install -g @railway/cli`
2. Ejecuta `railway login`
3. Ejecuta `railway init`
4. Ejecuta `railway up`

## Configuración de PostgreSQL (Opcional)

Si quieres agregar una base de datos PostgreSQL:

1. En tu proyecto de Railway, ve a "Variables"
2. Agrega una nueva variable de entorno:
   - `SPRING_DATASOURCE_URL` = `jdbc:postgresql://tu-host:5432/tu-db`
   - `SPRING_DATASOURCE_USERNAME` = `tu-usuario`
   - `SPRING_DATASOURCE_PASSWORD` = `tu-password`

## Desarrollo local

### Prerrequisitos
- Java 17 o superior
- Maven 3.6 o superior

### Ejecutar localmente

```bash
# Clonar el repositorio
git clone <tu-repositorio>
cd railway-demo

# Compilar y ejecutar
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

### Probar endpoints

```bash
# Endpoint principal
curl http://localhost:8080/api/hello

# Health check
curl http://localhost:8080/api/health
```

## Estructura del proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/example/railwaydemo/
│   │       ├── RailwayDemoApplication.java
│   │       └── controller/
│   │           └── HelloController.java
│   └── resources/
│       └── application.properties
├── test/
└── pom.xml
```

## Troubleshooting

### Error de puerto
Si ves errores relacionados con el puerto, asegúrate de que `server.port=${PORT:8080}` esté en `application.properties`.

### Error de base de datos
Si no tienes PostgreSQL configurado, la aplicación funcionará sin problemas. Los endpoints básicos no requieren base de datos.

### Build falla en Railway
Verifica que:
- El archivo `pom.xml` esté en la raíz del proyecto
- Java 17 esté especificado en `pom.xml`
- No haya errores de sintaxis en el código Java 