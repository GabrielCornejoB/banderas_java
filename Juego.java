import java.util.Arrays;
import java.util.Random;

//Clase donde iran los niveles del juego y probablemente el manejo de la puntuación
public class Juego {

    public static int puntaje = 0;
    

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

    
            
        //INICIZALICACIÓN DEL JUEGO
        String banderas[] = ConsoleFile.read("recursos/info_banderas.csv");                 //Lee la bandera, debe hacerse al principio de la clase Juego.java
        int indices[] = BaseDeDatos.CrearIndices(25);                                       //Llamado al metodo de crear indices de la clase "BaseDeDatos", 25 indices porque son 25 banderas      
        puntaje = 0;                                                                    //Variable para puntos (si llega a 50 pasa de nivel)
        //INICIALIZACIÓN DEL JUEGO
do{       
        int r1 = (int)(Math.random()*25);                                                   //Variable int que elige aleatoriamente un num del 0 al 25
        String respuestas[] = new String[4];                                                //Arreglo que almacena las 4 respuestas de cada intento (1 correcta, 3 random)

        System.out.println( ConsoleColors.WHITE_BOLD + "\nPUNTOS: " + puntaje + "\n");
        BaseDeDatos.ImprimirBandera(banderas, indices[r1]);                                 //Imprime la bandera correspondiente al indice elegido con la var "r1"
        System.out.println("");                                                             //Salto de linea
        respuestas[0] = BaseDeDatos.ImprimirDatos(banderas, indices[r1], 0);                //LLenamos el arreglo de respuestas con el nombre del país correspondiente al indice elegido con la var "r1"
        
        int r2 = 0, r3 = 0, r4 = 0;                                                         //Declaración e inicialización de las otas 3 variables random

        //PROCESO PARA ELEGIR LA OPCION RANDOM 2
        r2 = (int)(Math.random()*25);                                                       //r2 será igual a un num aleatorio del 0 al 25
        if(r2 == r1)                                                                        //Si r2 es igual a r1
        {
            do                                                          
            {   
                r2 = (int)(Math.random()*25);                                               //Va a volver a elegir un num aleatorio
            }
            while(r2 == r1);                                                                //Hasta que sea diferente de r1
            respuestas[1] = BaseDeDatos.ImprimirDatos(banderas, indices[r2], 0);            //Cuando termina de iterar se asigna al metodo de los datos
        }
        else
        {
            respuestas[1] = BaseDeDatos.ImprimirDatos(banderas, indices[r2], 0);            //Si desde el principio ya es distinto, simplemente se asigna la respuesta
        }
        //---------------------------*

        //PROCESO PARA ELEGIR LA OPCION RANDOM 3
        r3 = (int)(Math.random()*25); 
        if(r3 == r2 || r3 == r1)
        {
            do
            {
                r3 = (int)(Math.random()*25); 
            }
            while(r3 == r2 || r3 == r1);
            respuestas[2] = BaseDeDatos.ImprimirDatos(banderas, indices[r3], 0);
        }
        else
        {
            respuestas[2] = BaseDeDatos.ImprimirDatos(banderas, indices[r3], 0);
        }
        //---------------------------*

        //PROCESO PARA ELEGIR LA OPCION RANDOM 4
        r4 = (int)(Math.random()*25); 
        if(r4 == r3 || r4 == r2 || r4 == r1)
        {
            do 
            {
                r4 = (int)(Math.random()*25);
            }
            while(r4 == r3 || r4 == r2 || r4 == r1);
            respuestas[3] = BaseDeDatos.ImprimirDatos(banderas, indices[r4], 0);
        }
        else
        {
            respuestas[3] = BaseDeDatos.ImprimirDatos(banderas, indices[r4], 0);
        }
        //---------------------------*

        //Desorganiza el arreglo          
        Random rand = new Random();                                                     //Usamos la clase "Random" (tocó importarla arriba)

        //Ciclo for que se encarga de reemplazar el elemento del indice con uno generado aleatorimanete, al final del ciclo for que el arreglo desorganizado
        for (int i = 0; i < respuestas.length; i++)                                     
        {
            int indiceRandomACambiar = rand.nextInt(respuestas.length);
            String temp = respuestas[indiceRandomACambiar];

            respuestas[indiceRandomACambiar] = respuestas[i];
            respuestas[i] = temp;
        }

        System.out.println("\nA que pais corresponde esta bandera?");                                                         

        int contador_resps = 1;                                                         //Variable para poner numero antes de la respuesta
        //Ciclo for que imprime el arreglo desorganizado
        for (int j = 0; j < respuestas.length; j++) 
        {
            System.out.println(contador_resps + ". " + respuestas[j]);
            contador_resps = contador_resps + 1;
        }  
            System.out.println("\n" + "5. salir");                                      //opción de salir   
    
        //Elección de la respuesta correcta
        int eleccion = 0;                                                               //Variable elección (la cual ingresará el usuario)
        int correcta = 0;                                                               //Variable que almacenará la respuesta correcta
        System.out.println();                                                           //Salto de linea

        //Ciclo para encontrar la respuesta correcta
        for (int i = 0; i < respuestas.length; i++) 
        {
            if(respuestas[i].equals(BaseDeDatos.ImprimirDatos(banderas, indices[r1], 0)))   //Si la respuesta es igual a la correcta (primera variable random)
            {
                correcta = i+1;                                                             //Se asgina la opción correcta al indice + 1 para que no empiece en 0
                //System.out.println(correcta);
            }
        }
    
        //puntaje----------------------------------*
        eleccion = ConsoleInput.getInt();     
        
        if (eleccion > 4) {
             break;
        }
        else
        {

            if(eleccion == correcta)                                                           
            {
                puntaje = puntaje + 10; 
                if (puntaje == 50) {
                    break;
                } 
                else
                {
                    System.out.println("\n" + ConsoleColors.GREEN + "+10");                                                              
                } 
            }   
            else                                                                              
            {
                puntaje = puntaje - 10; 
                if (puntaje == -10) 
                {
                    puntaje = puntaje + 10;  
                    System.out.println("\n" + ConsoleColors.RED + "-10");   
                    System.out.println("UFF, eso estuvo cerca, menos mal no tenemos puntajes negativos :)"); 
                }else
                {
                    System.out.println("\n" + ConsoleColors.RED + "-10"); 
                }                                                           
            }  
        }    
    
    }while(puntaje >= 0 && puntaje < 50);
    //comprueba si salio del juego forsosamente o lo gano
    if (puntaje > 49) 
    {
        System.out.println(ConsoleColors.GREEN_BOLD+ "Felicidades completaste el nivel 1!");  
        System.out.println(ConsoleColors.GREEN_BOLD+ "NIVEL 2: Adivina la comida tipica del pais");  
    } 
    //------------*
  
}
    //La idea del nivel 2 es hacerlo con comidas tipicas
    public static void Nivel_2()
{
   
            
        //INICIZALICACIÓN DEL JUEGO
        String banderas[] = ConsoleFile.read("recursos/info_banderas.csv");                 //Lee la bandera, debe hacerse al principio de la clase Juego.java
        int indices[] = BaseDeDatos.CrearIndices(25);                                       //Llamado al metodo de crear indices de la clase "BaseDeDatos", 25 indices porque son 25 banderas      
        puntaje = 0;                                                                    //Variable para puntos (si llega a 50 pasa de nivel)
        //INICIALIZACIÓN DEL JUEGO
    do
    {       
        int r1 = (int)(Math.random()*25);                                                   //Variable int que elige aleatoriamente un num del 0 al 25
        String respuestas[] = new String[4];                                                //Arreglo que almacena las 4 respuestas de cada intento (1 correcta, 3 random)

        System.out.println( ConsoleColors.WHITE_BOLD + "\nPUNTOS: " + puntaje + "\n");
        BaseDeDatos.ImprimirBandera(banderas, indices[r1]);                                 //Imprime la bandera correspondiente al indice elegido con la var "r1"
        System.out.println("");                                                             //Salto de linea
        respuestas[0] = BaseDeDatos.ImprimirDatos(banderas, indices[r1], 1);                //LLenamos el arreglo de respuestas con el nombre del país correspondiente al indice elegido con la var "r1"
        
        int r2 = 0, r3 = 0, r4 = 0;                                                         //Declaración e inicialización de las otas 3 variables random

        //PROCESO PARA ELEGIR LA OPCION RANDOM 2
        r2 = (int)(Math.random()*25);                                                       //r2 será igual a un num aleatorio del 0 al 25
        if(r2 == r1)                                                                        //Si r2 es igual a r1
        {
            do                                                          
            {   
                r2 = (int)(Math.random()*25);                                               //Va a volver a elegir un num aleatorio
            }
            while(r2 == r1);                                                                //Hasta que sea diferente de r1
            respuestas[1] = BaseDeDatos.ImprimirDatos(banderas, indices[r2], 1);            //Cuando termina de iterar se asigna al metodo de los datos
        }
        else
        {
            respuestas[1] = BaseDeDatos.ImprimirDatos(banderas, indices[r2], 1);            //Si desde el principio ya es distinto, simplemente se asigna la respuesta
        }
        //---------------------------*

        //PROCESO PARA ELEGIR LA OPCION RANDOM 3
        r3 = (int)(Math.random()*25); 
        if(r3 == r2 || r3 == r1)
        {
            do
            {
                r3 = (int)(Math.random()*25); 
            }
            while(r3 == r2 || r3 == r1);
            respuestas[2] = BaseDeDatos.ImprimirDatos(banderas, indices[r3], 1);
        }
        else
        {
            respuestas[2] = BaseDeDatos.ImprimirDatos(banderas, indices[r3], 1);
        }
        //---------------------------*

        //PROCESO PARA ELEGIR LA OPCION RANDOM 4
        r4 = (int)(Math.random()*25); 
        if(r4 == r3 || r4 == r2 || r4 == r1)
        {
            do 
            {
                r4 = (int)(Math.random()*25);
            }
            while(r4 == r3 || r4 == r2 || r4 == r1);
            respuestas[3] = BaseDeDatos.ImprimirDatos(banderas, indices[r4], 1);
        }
        else
        {
            respuestas[3] = BaseDeDatos.ImprimirDatos(banderas, indices[r4], 1);
        }
        //---------------------------*

        //Desorganiza el arreglo          
        Random rand = new Random();                                                     //Usamos la clase "Random" (tocó importarla arriba)

        //Ciclo for que se encarga de reemplazar el elemento del indice con uno generado aleatorimanete, al final del ciclo for que el arreglo desorganizado
        for (int i = 0; i < respuestas.length; i++)                                     
        {
            int indiceRandomACambiar = rand.nextInt(respuestas.length);
            String temp = respuestas[indiceRandomACambiar];

            respuestas[indiceRandomACambiar] = respuestas[i];
            respuestas[i] = temp;
        }

        System.out.println("\nCual es la comida tipica del pais correspondiente a la bandera?");                                                         

        int contador_resps = 1;                                                         //Variable para poner numero antes de la respuesta
        //Ciclo for que imprime el arreglo desorganizado
        for (int j = 0; j < respuestas.length; j++) 
        {
            System.out.println(contador_resps + ". " + respuestas[j]);
            contador_resps = contador_resps + 1;
        }  
            System.out.println("\n" + "5. salir");                                      //opción de salir   
    
        //Elección de la respuesta correcta
        int eleccion = 0;                                                               //Variable elección (la cual ingresará el usuario)
        int correcta = 0;                                                               //Variable que almacenará la respuesta correcta
        System.out.println();                                                           //Salto de linea

        //Ciclo para encontrar la respuesta correcta
        for (int i = 0; i < respuestas.length; i++) 
        {
            if(respuestas[i].equals(BaseDeDatos.ImprimirDatos(banderas, indices[r1], 1)))   //Si la respuesta es igual a la correcta (primera variable random)
            {
                correcta = i+1;                                                             //Se asgina la opción correcta al indice + 1 para que no empiece en 0
                //System.out.println(correcta);
            }
        }
    
        //puntaje----------------------------------*
        eleccion = ConsoleInput.getInt();     
        
        if (eleccion > 4) {
             break;
        }
        else
        {

            if(eleccion == correcta)                                                           
            {
                puntaje = puntaje + 10; 
                if (puntaje == 50) {
                    break;
                } 
                else
                {
                    System.out.println("\n" + ConsoleColors.GREEN + "+10");                                                              
                } 
            }   
            else                                                                              
            {
                puntaje = puntaje - 10; 
                if (puntaje == -10) 
                {
                    puntaje = puntaje + 10;  
                    System.out.println("\n" + ConsoleColors.RED + "-10");   
                    System.out.println("UFF, eso estuvo cerca, menos mal no tenemos puntajes negativos :)"); 
                }else
                {
                    System.out.println("\n" + ConsoleColors.RED + "-10"); 
                }                                                           
            }  
        }    
    
    }while(puntaje >= 0 && puntaje < 100);
    //comprueba si salio del juego forsosamente o lo gano
    if (puntaje > 99) 
    {
        System.out.println(ConsoleColors.GREEN_BOLD+ "Felicidades completaste el nivel 2!");  
        System.out.println(ConsoleColors.GREEN_BOLD+ "NIVEL 3: Adivina la capital");  
    } 
    //------------*
  
}
    //DIFICIL
    //La idea del nivel 3 es hacerlo adivinando la capital
    public static void Nivel_3()
    {
  //INICIZALICACIÓN DEL JUEGO
        String banderas[] = ConsoleFile.read("recursos/info_banderas.csv");                 //Lee la bandera, debe hacerse al principio de la clase Juego.java
        int indices[] = BaseDeDatos.CrearIndices(25);                                       //Llamado al metodo de crear indices de la clase "BaseDeDatos", 25 indices porque son 25 banderas      
        puntaje = 0;                                                                    //Variable para puntos (si llega a 50 pasa de nivel)
        //INICIALIZACIÓN DEL JUEGO
    do
    {       
        int r1 = (int)(Math.random()*25);                                                   //Variable int que elige aleatoriamente un num del 0 al 25
        String respuestas[] = new String[4];                                                //Arreglo que almacena las 4 respuestas de cada intento (1 correcta, 3 random)

        System.out.println( ConsoleColors.WHITE_BOLD + "\nPUNTOS: " + puntaje + "\n");
        BaseDeDatos.ImprimirBandera(banderas, indices[r1]);                                 //Imprime la bandera correspondiente al indice elegido con la var "r1"
        System.out.println("");                                                             //Salto de linea
        respuestas[0] = BaseDeDatos.ImprimirDatos(banderas, indices[r1], 2);                //LLenamos el arreglo de respuestas con el nombre del país correspondiente al indice elegido con la var "r1"
        
        int r2 = 0, r3 = 0, r4 = 0;                                                         //Declaración e inicialización de las otas 3 variables random

        //PROCESO PARA ELEGIR LA OPCION RANDOM 2
        r2 = (int)(Math.random()*25);                                                       //r2 será igual a un num aleatorio del 0 al 25
        if(r2 == r1)                                                                        //Si r2 es igual a r1
        {
            do                                                          
            {   
                r2 = (int)(Math.random()*25);                                               //Va a volver a elegir un num aleatorio
            }
            while(r2 == r1);                                                                //Hasta que sea diferente de r1
            respuestas[1] = BaseDeDatos.ImprimirDatos(banderas, indices[r2], 2);            //Cuando termina de iterar se asigna al metodo de los datos
        }
        else
        {
            respuestas[1] = BaseDeDatos.ImprimirDatos(banderas, indices[r2], 2);            //Si desde el principio ya es distinto, simplemente se asigna la respuesta
        }
        //---------------------------*

        //PROCESO PARA ELEGIR LA OPCION RANDOM 3
        r3 = (int)(Math.random()*25); 
        if(r3 == r2 || r3 == r1)
        {
            do
            {
                r3 = (int)(Math.random()*25); 
            }
            while(r3 == r2 || r3 == r1);
            respuestas[2] = BaseDeDatos.ImprimirDatos(banderas, indices[r3], 2);
        }
        else
        {
            respuestas[2] = BaseDeDatos.ImprimirDatos(banderas, indices[r3], 2);
        }
        //---------------------------*

        //PROCESO PARA ELEGIR LA OPCION RANDOM 4
        r4 = (int)(Math.random()*25); 
        if(r4 == r3 || r4 == r2 || r4 == r1)
        {
            do 
            {
                r4 = (int)(Math.random()*25);
            }
            while(r4 == r3 || r4 == r2 || r4 == r1);
            respuestas[3] = BaseDeDatos.ImprimirDatos(banderas, indices[r4], 2);
        }
        else
        {
            respuestas[3] = BaseDeDatos.ImprimirDatos(banderas, indices[r4], 2);
        }
        //---------------------------*

        //Desorganiza el arreglo          
        Random rand = new Random();                                                     //Usamos la clase "Random" (tocó importarla arriba)

        //Ciclo for que se encarga de reemplazar el elemento del indice con uno generado aleatorimanete, al final del ciclo for que el arreglo desorganizado
        for (int i = 0; i < respuestas.length; i++)                                     
        {
            int indiceRandomACambiar = rand.nextInt(respuestas.length);
            String temp = respuestas[indiceRandomACambiar];

            respuestas[indiceRandomACambiar] = respuestas[i];
            respuestas[i] = temp;
        }

        System.out.println("\nCual es la capital del pais correspondiente a la bandera?");                                                         

        int contador_resps = 1;                                                         //Variable para poner numero antes de la respuesta
        //Ciclo for que imprime el arreglo desorganizado
        for (int j = 0; j < respuestas.length; j++) 
        {
            System.out.println(contador_resps + ". " + respuestas[j]);
            contador_resps = contador_resps + 1;
        }  
            System.out.println("\n" + "5. salir");                                      //opción de salir   
    
        //Elección de la respuesta correcta
        int eleccion = 0;                                                               //Variable elección (la cual ingresará el usuario)
        int correcta = 0;                                                               //Variable que almacenará la respuesta correcta
        System.out.println();                                                           //Salto de linea

        //Ciclo para encontrar la respuesta correcta
        for (int i = 0; i < respuestas.length; i++) 
        {
            if(respuestas[i].equals(BaseDeDatos.ImprimirDatos(banderas, indices[r1], 2)))   //Si la respuesta es igual a la correcta (primera variable random)
            {
                correcta = i+1;                                                             //Se asgina la opción correcta al indice + 1 para que no empiece en 0
                //System.out.println(correcta);
            }
        }
    
        //puntaje----------------------------------*
        eleccion = ConsoleInput.getInt();     
        
        if (eleccion > 4) {
             break;
        }
        else
        {

            if(eleccion == correcta)                                                           
            {
                puntaje = puntaje + 10; 
                if (puntaje == 50) {
                    break;
                } 
                else
                {
                    System.out.println("\n" + ConsoleColors.GREEN + "+10");                                                              
                } 
            }   
            else                                                                              
            {
                puntaje = puntaje - 10; 
                if (puntaje == -10) 
                {
                    puntaje = puntaje + 10;  
                    System.out.println("\n" + ConsoleColors.RED + "-10");   
                    System.out.println("UFF, eso estuvo cerca, menos mal no tenemos puntajesnegativos :)"); 
                }else
                {
                    System.out.println("\n" + ConsoleColors.RED + "-10"); 
                }                                                           
            }  
        }    
    
    }while(puntaje >= 0 && puntaje < 150);
    //comprueba si salio del juego forsosamente o lo gano
    if (puntaje > 149) 
    {
        System.out.println(ConsoleColors.GREEN_BOLD+ "¡Felicidades completaste el nivel 3!");  
        System.out.println(ConsoleColors.GREEN_BOLD+ "COMPLETASTE EL JUEGO, MUCHAS GRACIAS POR JUGAR");  
    } 
    //------------*
    }

    //EXTRA
    //La idea es adivinar un jugador de futbol del pais que muestre la bandera
    /*
    public static void Nivel_4()
    {

    }
    */
    
}
