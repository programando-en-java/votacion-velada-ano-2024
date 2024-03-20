# Votación Velada Año 2024

## Descripción del Proyecto:

El proyecto "Votación Velada del Año 2024" **(no oficial)** es una página web que permite a los usuarios ver un directo de Twitch del
evento organizado por [Ibai Llanos](https://www.twitch.tv/ibai). Además de la transmisión en vivo, la página web incluye funcionalidades de votación
para que los usuarios elijan su luchador favorito durante el combate actual de boxeo. Los votos se registran en una base
de datos y se visualizan en tiempo real a través de una barra de progreso en la interfaz de usuario.

---

## Tecnologías Utilizadas:

- **Backend:** Spring Boot
- **Frontend:** HTML, CSS, JavaScript, Thymeleaf
- **Base de Datos:** *Base de datos a elegir (ver discusión en GitHub)*
- **Contenedorización:** Docker
- **Orquestador de Contenedores:** Docker Compose
- **Herramientas de Desarrollo:** Maven, Java 17

---

## Requisitos Previos:

- Tener instalado Docker y Docker Compose en el sistema.
- Tener instalado Maven y Java 17 en el sistema.

---

## Configuración del Entorno de Desarrollo:

1. Clonar este repositorio en tu máquina local:

```bash
git clone https://github.com/programando-en-java/votacion-velada-ano-2024.git
```

1. Configurar la base de datos de acuerdo con la elección realizada en la discusión de GitHub.
2. Crear el archivo .env para configurar las variables de entorno necesarias.
3. Ejecutar el siguiente comando para iniciar el entorno de desarrollo:

```bash
docker-compose up
```

---

## Ejecución del Proyecto con Maven:

Para ejecutar el proyecto utilizando Maven, sigue los siguientes pasos:

1. Navega hasta la carpeta raíz del proyecto.
2. Ejecuta el siguiente comando para compilar y empaquetar la aplicación:

```bash
mvn clean package
```

3. Una vez que la compilación haya finalizado con éxito, puedes ejecutar la aplicación con el siguiente comando:

```bash
java -jar target/nombre_del_archivo.jar
```

Sustituye nombre_del_archivo.jar por el nombre del archivo JAR generado durante la compilación.

---

## Contribución:

¡Agradecemos tu interés en contribuir al proyecto! Si deseas participar, sigue estos pasos:

1. Realiza un fork de este repositorio.
2. Crea una nueva rama para tu contribución: git checkout -b feature/nueva-funcionalidad.
3. Realiza los cambios necesarios y haz commit de tus modificaciones: git commit -am 'Añadir nueva funcionalidad'.
4. Realiza un push de tu rama a tu repositorio fork: git push origin feature/nueva-funcionalidad.
5. Crea un pull request en este repositorio con una descripción detallada de tus cambios.

---

## Contacto:

Para cualquier consulta o sugerencia, no dudes en ponerte en contacto conmigo:

Correo Electrónico: ricardo@programandoenjava.com
Web: [Programando En Java](https://programandoenjava.com/)https://programandoenjava.com/

---

Este proyecto está bajo la Licencia Apache. Consulta el archivo LICENSE para obtener más información.
