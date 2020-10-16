public class Juego {

    public static void ImprimirFila(String fila[])
    {
        for (int i = 0; i < fila.length; i++) {
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
        }
    }


    public static void MostrarBandera(String[] banderas, int indice)
    {
        for (int i = indice; i < indice+20; i++) {
            ImprimirFila(banderas[i].split(";"));
        }
    }


    public static void Nivel_1()
    {
        System.out.println("ola");

        //String[] banderas = ConsoleFile.read("recursos/info_banderas.csv");
    }
    
}
