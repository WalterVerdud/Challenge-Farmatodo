Guía de ejecución
Requisitos previos
Asegúrese de tener instalado:

Java 21 o superior
Maven 3.9 o superior
Google Chrome
Verificar instalación:

java -version
mvn -version
Clonar el repositorio
git clone <URL_DEL_REPOSITORIO>
Ingresar al directorio:

cd WordCounterAutomation
Ejecutar pruebas desde línea de comandos
Desde la raíz del proyecto (donde se encuentra el archivo pom.xml) ejecutar:

mvn clean test
Maven descargará automáticamente todas las dependencias necesarias y ejecutará la suite completa.

Resultado esperado
La ejecución debería finalizar con un resultado similar a:

[INFO] Tests run: 3
[INFO] Failures: 0
[INFO] Errors: 0
[INFO] Skipped: 0

[INFO] BUILD SUCCESS
Reportes
Al finalizar la ejecución se generan reportes automáticamente en:

target/surefire-reports
Los archivos generados incluyen:

TEST-com.challenge.tests.WordCounterTest.xml

com.challenge.tests.WordCounterTest.txt
y contienen:

Total de pruebas ejecutadas.
Pruebas exitosas.
Pruebas fallidas.
Detalle de errores en caso de fallo.
Ejecución desde IntelliJ IDEA
Abrir IntelliJ IDEA.
Seleccionar Open.
Abrir la carpeta raíz del proyecto.
Esperar a que Maven descargue las dependencias.
Ejecutar la clase:
WordCounterTest
O ejecutar individualmente cualquiera de los métodos de prueba:

validateWordCount()

validateCharacterCount()

validateTopThreeKeywords()

Decisiones de diseño
La solución fue implementada utilizando:

Selenium WebDriver
JUnit 5
Maven
Page Object Model (POM)
Se eligió el patrón Page Object Model para separar la lógica de interacción con la aplicación de la lógica de las pruebas, facilitando el mantenimiento y la escalabilidad de la suite.