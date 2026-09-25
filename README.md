# 🤖 ApiDemosAuto

Proyecto de automatización móvil para validar recorridos básicos de **ApiDemos** en Android. Los tests usan **Java, JUnit 4, Appium y UiAutomator2** para abrir la aplicación y comprobar que distintas demos se muestran y siguen respondiendo.

> **Importante:** el APK que automatizan los tests es externo al módulo `app`. La ruta configurada actualmente apunta a `C:/Users/alvar/OneDrive/Desktop/QA/ApiDemos-debug.apk`; cada persona debe cambiarla por la ubicación de su propio APK.

## ✨ Qué cubre

| Caso | Recorrido | Comprobación |
|---|---|---|
| `CP01_AperturaAppTest` | Inicio de ApiDemos | La sesión abre y la app devuelve contenido. |
| `CP02_AccessibilityTest` | Accessibility | Se puede abrir la demo y hay contenido visible. |
| `CP03_AnimationTest` | Animation → Cloning → Run | La app sigue respondiendo tras reproducir la demo. |
| `CP04_AlarmControllerTest` | App → Alarm → Alarm Controller → One Shot Alarm | La app sigue respondiendo tras programar la alarma. |
| `CP05_GraphicsTest` | Graphics → AlphaBitmap | La app sigue respondiendo después del renderizado. |

La suite `SuiteApiDemos` agrupa los cinco casos. Las validaciones actuales comprueban navegación, presencia de contenido y que la app no se cierre; no son verificaciones visuales detalladas.

## 🧰 Requisitos

- Android Studio o herramientas de línea de comandos de Android.
- JDK 17 o superior.
- Android SDK con la plataforma **API 36.1** y herramientas de compilación instaladas.
- Un emulador Android iniciado, identificado actualmente como `emulator-5554`.
- **Appium Server** disponible en `http://127.0.0.1:4723` y el driver **UiAutomator2** instalado.
- El APK de ApiDemos que se quiere probar.

## 🚀 Preparar y ejecutar

1. Clona el repositorio y ábrelo en Android Studio. Espera a que Gradle termine la sincronización.
2. Instala e inicia Appium Server con el driver UiAutomator2.
3. Inicia el emulador `emulator-5554`.
4. En `app/src/test/java/com/example/apidemos_auto/BaseTest.java`, actualiza `.setApp(...)` para que apunte al APK local de ApiDemos.
5. Ejecuta `SuiteApiDemos` desde Android Studio o desde PowerShell:

   ```powershell
   .\gradlew.bat testDebugUnitTest --tests SuiteApiDemos
   ```

Para compilar el módulo Android:

```powershell
.\gradlew.bat assembleDebug
```

Los reportes de las pruebas JVM se generan en `app/build/reports/tests/testDebugUnitTest/`.

## 🗂️ Estructura

```text
app/
├── src/main/       # Manifest y recursos del módulo Android
├── src/test/       # Tests Appium/JUnit y suite ApiDemos
└── src/androidTest/ # Ejemplo de test instrumentado
gradle/             # Versiones de plugins y dependencias
gradlew.bat         # Wrapper de Gradle para Windows
```

## ⚙️ Configuración actual

- `applicationId`: `com.example.apidemos_auto`
- `minSdk`: 24 · `targetSdk`: 36 · `compileSdk`: 36.1
- Java: 11 para compilar el código del módulo Android.
- Dependencias de automatización de tests: Appium Java Client 9.3.0, Selenium 4.21.0 y JUnit 4.13.2.

La ruta del APK, el nombre del emulador y la URL de Appium están definidos directamente en `BaseTest`. Si tu entorno usa valores distintos, actualízalos allí antes de ejecutar la suite.

## 🧪 Diagnóstico rápido

- **No conecta con Appium:** confirma que el servidor escucha en `127.0.0.1:4723` y que UiAutomator2 está instalado.
- **No encuentra el dispositivo:** comprueba que el emulador está iniciado y que su identificador coincide con `emulator-5554`.
- **No encuentra o no instala el APK:** revisa la ruta configurada en `BaseTest` y los permisos de acceso al archivo.
- **No encuentra elementos de la demo:** verifica que el APK es ApiDemos y que los textos accesibles coinciden con los selectores usados por las pruebas.