# Chat con Listas Enlazadas

Proyecto en Java que implementa:
- Un servidor de chat (`ChatServer`) capaz de atender múltiples clientes.
- Un cliente de chat (`ChatClient`).
- Una aplicación de consola independiente (`ChatApp`) que simula chats entre usuarios usando estructuras propias (listas enlazadas).

## Requisitos
- Java 8 o superior
- Acceso a línea de comandos (CMD, PowerShell, terminal)

## Estructura de carpetas
```
/Chat Listas enlazadas
│
├─ src/
│   ├─ app/
│   │   ├─ ChatServer.java
│   │   ├─ ChatClient.java
│   │   └─ ChatApp.java
│   ├─ datastructure/
│   ├─ model/
│   └─ service/
└─ README.md
```

## Compilación
1. Abre la terminal y sitúate en la raíz del proyecto:
   ```
   /
   ```
2. Compila todo en una carpeta `bin`:
   ```
   javac -d bin src\app\*.java src\datastructure\*.java src\model\*.java src\service\*.java
   ```

## Ejecución

### 1. Iniciar el servidor de chat
En una consola:
```
java -cp bin app.ChatServer
```

### 2. Conectar uno o varios clientes
En consolas separadas, ejecuta:
```
java -cp bin app.ChatClient
```
Sigue la petición de nombre y podrás chatear entre las instancias conectadas.

### 3. Usar la aplicación de consola (`ChatApp`)
Esta app corre local y permite crear usuarios, chats, enviar y ver historial:
```
java -cp bin app.ChatApp
```
Sigue el menú interactivo para gestionar usuarios y mensajes.

## Notas
- Asegúrate de iniciar primero `ChatServer` antes de lanzar `ChatClient`.
- `ChatApp` funciona de forma distinta: no requiere servidor, gestiona todo en memoria.
