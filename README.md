
## Separación de Componentes según MVVM

En este proyecto, intenté seguir el patrón de arquitectura MVVM (Model-View-ViewModel) para organizar el código de la aplicación Android. Cada componente está separado de la siguiente manera:

- **Model:** Aquí puse las clases que representan los datos y la lógica de negocio, como las tareas y cómo se guardan o modifican.
- **View:** Son las actividades y fragmentos, donde se muestra la interfaz de usuario y se reciben las acciones del usuario.
- **ViewModel:** Es la capa intermedia que conecta el Model con la View. Aquí usé ViewModel para manejar los datos que la vista necesita y LiveData para que la vista observe los cambios.


## Informe Breve

### ¿Qué patrón usaron y por qué?

Usé el patrón MVVM porque es recomendado para aplicaciones Android modernas. Permite separar la lógica de la interfaz de usuario y facilita el mantenimiento y las pruebas del código.

### ¿Cómo aplicaron ViewModel y LiveData?

Creé una clase ViewModel para manejar los datos de las tareas. Usé LiveData para que la vista (Activity o Fragment) observe los cambios en la lista de tareas y se actualice automáticamente cuando los datos cambian, sin tener que actualizar la interfaz manualmente.

### ¿Qué ventajas encontraron al usar MVVM?

- El código es más organizado y fácil de entender.
- Es más sencillo hacer pruebas a la lógica de negocio porque está separada de la interfaz.
- La interfaz de usuario se actualiza automáticamente cuando los datos cambian, gracias a LiveData.
- Facilita el mantenimiento y la escalabilidad del proyecto.


