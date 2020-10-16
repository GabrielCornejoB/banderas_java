//En este script será el que conecte los demás, la idea es tener el menor codigo posible sino que llamara a las demás clases
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
                    Juego.Nivel_1();                                                    //Si elige la opción 1, va al primer nivel del juego
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
                    Opciones.Error();
                    break;
            }
        }
        while(opcion != 4);      
    }

}