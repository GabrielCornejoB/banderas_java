//Clase para manejar la base de datos, imprimir banderas y mostrar info para los niveles
public class BaseDeDatos {
    
    //A este metodo se le entrega el arreglo con las banderas y un indice inicial desde el que se van a imprimir
    public static void ImprimirBandera(String[] banderas, int indice)
    {
        //El ciclo empieza desde el indice dado, e itera 20 veces (Así muestra titulo y bandera)
        for (int i = indice+1; i < indice + 20; i++) {

            System.out.println(banderas[i]);              
        }   
    }

    //A este metodo se le entregan los mismos argumentos que al anterior, pero el indice solo debe ser la primera fila de cada pais
    public static void ImprimirDatos(String[] banderas, int indice, int pregunta)
    {
        String datos[] = new String[27];                                        //Arreglo de Strings para almacenar los datos de cada pais, el tamaño luego se modificará

        //Ciclo que llena el arreglo de información
        for (int i = indice; i < indice+1; i++) 
        {
            datos = banderas[i].split(";");
        }
        
        //Esto es para imprimir un dato en específico
        System.out.print(datos[pregunta]);
    }
    //Total es el total de banderas que hay
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

    
    public static void main(String[] args) {
        String banderas[] = ConsoleFile.read("recursos/info_banderas.csv");     //Lee la bandera, debe hacerse al principio de la clase Juego.java
        CrearIndices(25);
        ImprimirBandera(banderas, 20);
        //ImprimirDatos(banderas, 0, 2);
    }

}
