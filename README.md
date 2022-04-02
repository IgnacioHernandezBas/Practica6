# Practica6

## PARTE I

Creación de test unitarios para las clases DNI y teléfono.

1.Clase DNI   

Se ha llevado la creaciión de dos DNIs ,uno de ellos de forma incorrecta.Posteriromente se ha llamado al metodo de validación,el cual devuelve true si no se dan errores y false en el caso de que sí los haya.Para finalizar se analiza que el resultado obtenido sea el resultado esperado gracias al uso del assertEquals.

![image](https://user-images.githubusercontent.com/91118338/161384678-e529be68-4566-4310-acd9-6b0440b8d7f4.png)

2.Clase Teléfono   

Se ha llevado a cabo la misma metodoógía a la hora de realizar el testing,donde se ha llevado a cabo la comprobación de que se pueden establecer teléfonos válidos con o  sin prefijo(+34,+38,...etc ).Y posteriormete se ha probado a introducir teléfonos incorrectos para comprobar que el método de validación referente a los teléfonos funciona correctamente.

![image](https://user-images.githubusercontent.com/91118338/161384935-40efeec5-aa9b-40af-9c49-25fd18612786.png)

** Con la herramienta de VSCode se puede comprobar que el testing ha sido realizado de fomra correcta observando los ticks verdes que se encuentran junto a los indicadores del número de cada línea. **

## PARTE II
Desarrollo de test E2E de la clase ProcessController

Se ha comprobado que la clase funciona correctamente cuando el envío de datos es satisfactorio como cuando este no lo es,dando lugar a las siguientes test:

given_app_when_login_using_right_credentials_then_ok()
  
![image](https://user-images.githubusercontent.com/91118338/161385364-9f3f92de-fcfb-4eac-b1c8-cc7733bbd809.png)
  
given_app_when_login_legacy()

![image](https://user-images.githubusercontent.com/91118338/161385503-fd713b67-7acf-40b8-a94f-26be002127c6.png)

Se ha llevado a cabo la comprobación de que el envío de datos correctos como incorrectos reciben la respuesta esperada,dando lugar a un OK(200) y un KO(400) en el caso de que el envío de alguno de los parametros sea el incorrecto.Se han introducido errores tanto en el nombre,como en el dni y el teleéfono para observar todas las salidas posibles.


