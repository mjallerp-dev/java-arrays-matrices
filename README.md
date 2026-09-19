# Java Arrays y Matrices

Aplicación de consola en Java 17 con menú para gestionar arreglos, matrices y analizar un párrafo de texto.

## Requisitos

| Requisito | Versión |
|---|---|
| Java (JDK) | 17 |
| Maven | 3.8+ (opcional, si se compila por CLI) |
| IDE | opcional |

Comprobar Java:

```bash
java -version
```

Debe mostrar `17` (por ejemplo `openjdk version "17.0.x"`).

## Estructura

```
src/main/java/com/mjallerp/
├── Main.java
├── model/
│   └── Texto.java
└── service/
    ├── AnalizadorTexto.java
    ├── Arreglos.java
    └── Matrices.java
```

- `Main`: menú principal y submenús.
- `Arreglos`: `int[10]` aleatorio (0–99), for clásico, for-each, impares a 0, multiplicar por índice y búsqueda lineal.
- `Matrices`: matriz 3x3 (1 a 9), tabla, recorrido por columnas, suma e intercambio de primera y última fila.
- `Texto`: párrafo, palabras y frecuencias.
- `AnalizadorTexto`: minúsculas y sin puntuación, guarda palabras en un arreglo, cuenta repeticiones y muestra las 5 más frecuentes.

## Compilar y ejecutar

### IntelliJ IDEA

1. Abrir el proyecto (carpeta con `pom.xml`).
2. Esperar a que cargue Maven con JDK 17.
3. Ejecutar `com.mjallerp.Main` (Run).
4. Usar la pestaña Run para escribir las opciones del menú.

### Maven

```bash
mvn compile
java -cp target/classes com.mjallerp.Main
```

### javac (sin Maven)

```bash
javac -encoding UTF-8 -d target/classes src/main/java/com/mjallerp/model/Texto.java src/main/java/com/mjallerp/service/Arreglos.java src/main/java/com/mjallerp/service/Matrices.java src/main/java/com/mjallerp/service/AnalizadorTexto.java src/main/java/com/mjallerp/Main.java
java -cp target/classes com.mjallerp.Main
```

En PowerShell, si `java`/`javac` no están en el PATH, usar la ruta del JDK 17.

## Cómo probarla

Al arrancar aparece el menú:

```
1. Gestión de Arreglos
2. Gestión de Matrices
3. Analizar Texto
0. Salir
```

Hay que **crear** el arreglo o la matriz (opción 1 del submenú) antes de las demás operaciones. En texto, primero **leer el párrafo** (las palabras se guardan solas en el arreglo).

### Arreglos (opción 1)

1. Crear arreglo → 10 enteros aleatorios.
2. Mostrar con for clásico y for-each.
3. Cambiar impares por cero.
4. Multiplicar por índice (el índice `0` queda en `0`).
5. Búsqueda lineal → ingresar un entero; indica el índice o que no está.

### Matrices (opción 2)

1. Crear matriz 3x3 con valores 1 a 9 (se imprime como tabla y se recorre por columnas).
2. Sumar elementos → debe dar **45**.
3. Intercambiar primera y última fila (se vuelve a mostrar la tabla).

### Analizar texto (opción 3)

1. Leer párrafo, por ejemplo: `Hola, hola! Mundo. El mundo es bello, hola mundo.` (se normaliza y se guarda en el arreglo).
2. Mostrar Top 5 de palabras frecuentes → en el ejemplo, `hola` (3) y `mundo` (3) primero.

`0` vuelve al menú anterior o sale.

## Encoding

El proyecto usa UTF-8 (`project.build.sourceEncoding` en `pom.xml`). En consola de Windows, si se ven caracteres raros, ejecutar desde el IDE o una terminal UTF-8.
