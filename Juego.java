import java.util.Arrays;
import java.util.Random;

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
        //INICIZALICACIÓN DEL JUEGO
        String banderas[] = ConsoleFile.read("recursos/info_banderas.csv");                 //Lee la bandera, debe hacerse al principio de la clase Juego.java
        int indices[] = BaseDeDatos.CrearIndices(25);                                       //Llamado al metodo de crear indices de la clase "BaseDeDatos", 25 indices porque son 25 banderas
        //INICIALIZACIÓN DEL JUEGO
        
        int r1 = (int)(Math.random()*25);                                                   //Variable int que elige aleatoriamente un num del 0 al 25
        String respuestas[] = new String[4];                                                //Arreglo que almacena las 4 respuestas de cada intento (1 correcta, 3 random)

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
        //PROCESO PARA ELEGIR LA OPCION RANDOM 2

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
        //PROCESO PARA ELEGIR LA OPCION RANDOM 3

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
        //PROCESO PARA ELEGIR LA OPCION RANDOM 4

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

        System.out.println("");                                                         //Salto de linea

        int contador_resps = 1;
        //Ciclo for que imprime el arreglo desorganizado
        for (int j = 0; j < respuestas.length; j++) 
        {
            System.out.println(contador_resps + ". " + respuestas[j]);
            contador_resps = contador_resps + 1;

            if(respuestas[j].equals(BaseDeDatos.ImprimirDatos(banderas, indices[r1], 0)))
            {
                System.out.println("La de arriba es la correcta");
            }
        }     

        //Elección de la respuesta correcta

        //El nivel se va a repetir maximo 10 veces, si adivina 5 preguntas pasa de nivel, si despues de las 10 no adivinó, ya pierde
        //Si adivina una respuesta se le suman puntos pero si falla, se le restan

        //int eleccion = 0;
        //eleccion = ConsoleInput.getInt();

        //primero hare como saber que una respuesta es correcta

        

        


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
