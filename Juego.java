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
        int random = (int)(Math.random()*25);

        String banderas[] = ConsoleFile.read("recursos/info_banderas.csv");     //Lee la bandera, debe hacerse al principio de la clase Juego.java
        int indices[] = BaseDeDatos.CrearIndices(25); 
        String respuestas[] = new String[4];

        BaseDeDatos.ImprimirBandera(banderas, indices[random]);  
        System.out.println(""); 
        respuestas[0] = BaseDeDatos.ImprimirDatos(banderas, indices[random], 0); 
        //System.out.println(""); 

        int r2 = 0, r3 = 0, r4 = 0; 
        r3 = (int)(Math.random()*25);
        r2 = (int)(Math.random()*25);
        r4 = (int)(Math.random()*25);

        if (r2 != r3 && r2 != r4 && r2!= random && r3 != random && r4 != random)
        {
            respuestas[1] = BaseDeDatos.ImprimirDatos(banderas, indices[r2], 0);  
            respuestas[2] = BaseDeDatos.ImprimirDatos(banderas, indices[r3], 0);  
            respuestas[3] = BaseDeDatos.ImprimirDatos(banderas, indices[r4], 0);  
        } 
            else 
            {
                do
                {
                    r2 = (int)(Math.random()*25);
                    r3 = (int)(Math.random()*25);
                    r4 = (int)(Math.random()*25);  
                } 
                while (r2 == r3 && r2 == r4 && r2== random && r3 == random && r4 == random);

                    respuestas[1] = BaseDeDatos.ImprimirDatos(banderas, indices[r2], 0);  
                    respuestas[2] = BaseDeDatos.ImprimirDatos(banderas, indices[r3], 0);  
                    respuestas[3] = BaseDeDatos.ImprimirDatos(banderas, indices[r4], 0);  
            }

        for (int j = 0; j < respuestas.length; j++) 
        {
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
