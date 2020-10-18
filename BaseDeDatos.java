//Clase para manejar la base de datos, imprimir banderas y mostrar info para los niveles

//La base de datos en archivo .csv en java es usada como un array de Strings, donde cada linea del archivo, cuenta como un String
//Por ende para poder pintar las banderas primero debo hacer un metodo que coloree cada fila y luego otro que las imprima juntas

//En el archivo .csv la primera linea de cada pais tiene los datos organizados de la siguiente manera:  Nombre país / comida tipica / capital
public class BaseDeDatos {
    
    //Este metodo lo que hace es tomar fila por fila, recorrerla con un for, y si un caracter es igual a un número, pintarlo de un color en específico
    //Su argumento es el indice de la fila que va a recorrer
    public static void ImprimirFila(String[] fila)
    {
        for (int i = 0; i < fila.length; i++) 
        {
            if(fila[i].equals("1"))
            {
                System.out.print(ConsoleColors.RED_BACKGROUND+"  ");
            }
            else if(fila[i].equals("2"))
            {
                System.out.print(ConsoleColors.BLUE_BACKGROUND+"  ");
            }
            else if(fila[i].equals("3"))
            {
                System.out.print(ConsoleColors.WHITE_BACKGROUND+"  ");
            }
            else if(fila[i].equals("4"))
            {
                System.out.print(ConsoleColors.YELLOW_BACKGROUND+"  ");
            }
            else if(fila[i].equals("5"))
            {
                System.out.print(ConsoleColors.GREEN_BACKGROUND+"  ");
            }
            else if(fila[i].equals("6"))
            {
                System.out.print(ConsoleColors.PURPLE_BACKGROUND+"  ");
            }
            else if(fila[i].equals("7"))
            {
                System.out.print(ConsoleColors.CYAN_BACKGROUND+"  ");
            }
            else if(fila[i].equals("8"))
            {
                System.out.print(ConsoleColors.BLACK_BACKGROUND+"  ");
            }
            System.out.print(ConsoleColors.RESET);
        }
    }

    //A este metodo se le entrega el arreglo con las banderas y un indice inicial desde el que se van a imprimir
    //Conecta con el metodo "ImprimirFila()"
    public static void ImprimirBandera(String[] banderas, int indice)
    {
        //El ciclo empieza desde el indice dado + 1 (para no imprimir el titulo), e itera 19 veces
        for (int i = indice+1; i < indice + 20; i++) {
  
            ImprimirFila(banderas[i].split(";"));                               //Imprime una fila quitando los punto y coma
            System.out.println();                                               //Despues de cada fila, deja un espacio
        }   
    }

    //A este metodo se le entregan los mismos argumentos que al anterior, pero el indice solo debe ser la primera fila de cada pais
    public static String ImprimirDatos(String[] banderas, int indice, int pregunta)
    {
        String datos[] = new String[27];                                        //Arreglo de Strings para almacenar los datos de cada pais, el tamaño luego se modificará
        String respuesta = "";

        //Ciclo que llena el arreglo de información
        for (int i = indice; i < indice+1; i++) 
        {
            datos = banderas[i].split(";");
        }
        
        //Esto es para imprimir un dato en específico
        //System.out.print(datos[pregunta]);
        respuesta = datos[pregunta];
        return respuesta;
    }

    //Este metodo coloca los indices de cada bandera en un arreglo, el argumento total, es el total de banderas
    public static int[] CrearIndices(int total)
    {
        int indices[] = new int[total];
        int contador = 0;

        for (int i = 0; i < indices.length; i++) {
            indices[i] = contador;
            contador = contador + 20;
        }
        return indices;
    }

    //Esto está para pruebas, esta clase no debería de poder ejecutarse, es solo para probar funcionamiento
    /*
    public static void main(String[] args) {
        String banderas[] = ConsoleFile.read("recursos/info_banderas.csv");     //Lee la bandera, debe hacerse al principio de la clase Juego.java
        int indices[] = CrearIndices(25);                                                //Esta linea crea los indices, de momento solo son 25 paises
        ImprimirBandera(banderas, indices[21]);                                           //Esta linea imprime la bandera del indice 0
        ImprimirDatos(banderas, indices[0], 2);                                        //Esta linea muestra el dato 3 (capital) de la bandera en el indice 0
    }*/

}
