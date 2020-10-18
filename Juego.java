//Clase donde iran los niveles del juego y probablemente el manejo de la puntuación
public class Juego {

    //Letras ascii generada en http://patorjk.com/software/taag/#p=display&f=Doom&t=NIVEL%20%201 con fuente "Doom"
    public static void Prueba()
    {
        
        System.out.println("   _   _ _____ _   _ _____ _        __   ");
        System.out.println("  | \\ | |_   _| | | |  ___| |      /  | ");
        System.out.println("  |  \\| | | | | | | | |__ | |      `| | ");
        System.out.println("  | . ` | | | | | | |  __|| |       | | ");
        System.out.println("  | |\\  |_| |_\\ \\_/ / |___| |____  _| |_");
        System.out.println("  \\_| \\_/\\___/ \\___/\\____/\\_____/  \\___/");
    }
    //FACIL
    //La idea del nivel 1 es mostrar una bandera al azar y que se generen 4 opciones (una correcta, y 3 incorrectas que se elegirán aleatoriamente)
    public static void Nivel_1()
    {
        int random = (int)(Math.random()*26);

        String banderas[] = ConsoleFile.read("recursos/info_banderas.csv");     //Lee la bandera, debe hacerse al principio de la clase Juego.java
        int indices[] = BaseDeDatos.CrearIndices(25); 
        String respuestas[] = new String[4];

        BaseDeDatos.ImprimirBandera(banderas, indices[random]);  
        System.out.println(""); 
        System.out.println("Este es random" + random);
        respuestas[0] = BaseDeDatos.ImprimirDatos(banderas, indices[random], 0); 
        //System.out.println(""); 
        
            for (int i = 1 ; i<=3; i++)
            {
                System.out.println("");
                int randomDos = (int)(Math.random()*25);
                System.out.println(randomDos);

                if (random != randomDos)
                {
                    respuestas[i] = BaseDeDatos.ImprimirDatos(banderas, indices[randomDos], 0);  
                    System.out.println("");  
                }
                else
                {
                    do
                    {
                        randomDos = (int)(Math.random()*26);
                    }
                    while (random == randomDos);  
                    respuestas[i] = BaseDeDatos.ImprimirDatos(banderas, indices[randomDos], 0);  
                    System.out.println("");   
                }              
            }
            for (int j = 0; j < respuestas.length; j++) {
                System.out.println(respuestas[j]);
            }
        

                                            
    }
    //MEDIO
    //La idea del nivel 2 es hacerlo con comidas tipicas
    public static void Nivel_2()
    {

    }
    //DIFICIL
    //La idea del nivel 3 es hacerlo adivinando la capital
    public static void Nivel_3()
    {

    }

    //EXTRA
    //La idea es adivinar un jugador de futbol del pais que muestre la bandera
    /*
    public static void Nivel_4()
    {

    }
    */
    
}
