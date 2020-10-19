//En este script será el que conecte los demás, la idea es tener el menor codigo posible sino que llamara a las demás clases

//En el archivo .csv la primera linea de cada pais tiene los datos organizados de la siguiente manera:  Nombre país / comida tipica / capital
public class Main{

    public static void main(String[] args) {
        int opcion = 0;                                                                 //Variable para controlar el menu            
        
        do
        {
            Opciones.Menu();                                                            //Llamado al metodo Menu() de la clase Opciones.java
            opcion = ConsoleInput.getInt();                                             //Pide por consola la opción a la que quiere acceder el usuario

            switch(opcion)                                                              //Switch para ingresar a las distintas secciones de la aplicación
            {
                case 1:
                    Juego.Nivel_1(); 

                if (Juego.puntaje == 50)
                {
                    Juego.Nivel_2();

                    if (Juego.puntaje == 100)
                    {
                        Juego.Nivel_3();    
                    }
                    Opciones.MasInfo(); 
                }                                                                       //Si elige la opción 1, va al primer nivel del juego
                    break;
                case 2:
                    Opciones.Instrucciones();                                           //Si elige la opción 2, va a la ventana de instrucciones 
                    break;
                case 3:
                    Opciones.MasInfo();                                                 //Si elige la opción 3, va a la ventana de acerca de
                    break;
                case 4:
                    System.out.println("\nHas salido del programa\n");                  //Si elige la opción 4, sale del programa
                    break;
                default:                                                                
                    Opciones.Error();                                                   //Si coloca un numero distinto a esos 4, sale el mensaje de error de opcion no disp
                    break;
            }
        }
        while(opcion != 4);                                                             //Esta linea de codigo es la que hace que salga del programa cuando se presione el 4
    }

}