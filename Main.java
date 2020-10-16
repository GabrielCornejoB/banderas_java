//En este script será el que conecte los demás, la idea es tener el menor codigo posible sino que llamara a las demás clases
public class Main{

    public static void main(String[] args) {
        int opcion = 0;                                                                 //Variable para controlar el menu            
        //Switch para ingresar a las distintas secciones de la aplicación
        do
        {
            Opciones.Menu();                                                            //Llamado al metodo Menu() de la clase Opciones.java
            opcion = ConsoleInput.getInt();

            switch(opcion)
            {
                case 1:
                    System.out.println("\nImaginemos que este es el jueguito, la idea es que todo ese jueguito este en una clase llamada Juego.java\n");
                    break;
                case 2:
                    Opciones.Instrucciones();
                    break;
                case 3:
                    Opciones.MasInfo();
                    break;
                case 4:
                    System.out.println("\nHas salido del programa\n");
                    break;
                default:
                    System.out.println("\nNum no disponible\n");
                    break;
            }
        }
        while(opcion != 4);      
    }
}