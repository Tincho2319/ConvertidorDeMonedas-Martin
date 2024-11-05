# <t1>Proyecto: Conversor de Monedas - Exchange MRTN-Alura</t1>
## <t2>Descripción</t2>
  *Este proyecto es una aplicación de consola que permite realizar conversiones entre diferentes monedas usando tasas de cambio obtenidas de la API ExchangeRate-API.*
  *Los datos de conversión se guardan en un archivo JSON, y el usuario puede seleccionar las tasas de cambio específicas que desea guardar.*
  *Esto optimiza el tamaño y la relevancia de los datos almacenados.*

### *Las conversiones disponibles incluyen:*

Dólar estadounidense (USD) a Peso Argentino (ARS), Peso Colombiano (COP), y Real Brasileño (BRL).
Y viceversa para estas combinaciones.

### *Características*
**Obtención de Tasas de Cambio: La clase PrincipalRequest se conecta a la API y obtiene las tasas de cambio en formato JSON.**
**Selección de Elementos Específicos: La clase CreandoArchivo permite guardar en el archivo JSON solo las tasas de cambio específicas que el usuario desea.**
**Conversión de Monedas: La clase PrincipalConversor realiza las conversiones usando las tasas de cambio almacenadas en el JSON generado.**

## Cómo Usar
<u>Ejecuta la Aplicación</u>

*Ejecuta la clase Main para iniciar la aplicación.*

# *Menú Interactivo*

**Tras iniciar, se mostrará un menú interactivo con las opciones de conversión. Selecciona una opción y proporciona la cantidad de moneda para realizar la conversión.**

**Guardar Tasas Específicas en JSON**

**La clase CreandoArchivo se usa en Main para guardar solo las tasas de cambio necesarias (e.g., ARS, COP, BRL) en un archivo JSON conversion_rates.json.**

# *Conversión de Monedas*

PrincipalConversor usa el archivo conversion_rates.json para leer solo las tasas de cambio seleccionadas y realizar la conversión con precisión.

# <t3>Documentación de Clases</t3>

## <t4>1. PrincipalRequest</t4>
      Función: Hace la solicitud HTTP a la API de ExchangeRate-API y obtiene las tasas de cambio.
      Método Principal: recibiendoDatos() — Devuelve un JsonObject con las tasas de cambio si la solicitud es exitosa.

## <t5>3. CreandoArchivo</t5>
      Función: Guarda en un archivo JSON solo las tasas de cambio específicas elegidas.
      Método Principal: guardarJsonConElementosEspecificos(JsonObject jsonObject, Set<String> claves, String nombreArchivo) — Filtra y guarda solo los elementos seleccionados.

## <t6>5. PrincipalConversor</t6>
      Función: Realiza conversiones de monedas usando las tasas de cambio desde el archivo JSON generado.
      Método Principal: convertirMoneda(int opcion, int cantidadMoneda) — Convierte monedas según la opción seleccionada del menú.
## <t7>6. Main</t7>
      Función: Coordina el flujo del programa. Obtiene datos de la API, guarda los datos en JSON, y ejecuta el menú interactivo.

### Ejemplo de Ejecución

# ***********************************************************
# Bienvenido/a al Exchange MRTN-Alura
# 1) Dolar >>> Peso Argentino
# 2) Peso Argentino >>> Dolar
# 3) Dolar >>> Peso Colombiano
# 4) Peso Colombiano >>> Dolar
# 5) Dolar >>> Real Brasileño
# 6) Real Brasileño >>> Dolar
# 7) Salir
# Elija una opción válida para realizar las conversiones
# ***********************************************************

<u>Selección de Conversión: Ingresa el número de la opción deseada.
Conversión: Ingresa la cantidad a convertir.
Salida: El programa muestra el resultado de la conversión y vuelve al menú. Para salir, elige la opción 7.</u>
