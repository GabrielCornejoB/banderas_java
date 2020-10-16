//Clase donde estaran las opciones del Menu, menos el juego
public class Opciones {
    public static void Menu()
    {
        //Prints para titulo inicial
        System.out.println(ConsoleColors.RED + "\n  ______ _    _ _   _      __          _______ _______ _    _       ______ _               _____  _____ ");
        System.out.println(" |  ____| |  | | \\ | |     \\ \\        / /_   _|__   __| |  | |     |  ____| |        /\\   / ____|/ ____|" + ConsoleColors.RESET);
        System.out.println(" | |__  | |  | |  \\| |      \\ \\  /\\  / /  | |    | |  | |__| |     | |__  | |       /  \\ | |  __| (___  ");
        System.out.println(" |  __| | |  | | . ` |       \\ \\/  \\/ /   | |    | |  |  __  |     |  __| | |      / /\\ \\| | |_ |\\___ \\ ");
        System.out.println(ConsoleColors.BLUE +" | |    | |__| | |\\  |        \\  /\\  /   _| |_   | |  | |  | |     | |    | |____ / ____ \\ |__| |____) |");
        System.out.println(" |_|     \\____/|_| \\_|         \\/  \\/   |_____|  |_|  |_|  |_|     |_|    |______/_/    \\_\\_____|_____/ \n" + ConsoleColors.RESET );

        System.out.println("\nIngrese la opcion a la que quiere ingresar");
        System.out.println("1. Jugar");
        System.out.println("2. Como jugar?");
        System.out.println("3. Acerca de");
        System.out.println("4. Salir\n");
    }

    public static void Instrucciones()
    {
        System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||      "+ConsoleColors.GREEN+"_____           _                       _"+ConsoleColors.RESET+"                                ||");
        System.out.println("||"+ConsoleColors.GREEN+"     |_   _|         | |                     (_)                               "+ConsoleColors.RESET+"||");
        System.out.println("||"+ConsoleColors.GREEN+"       | |  _ __  ___| |_ _ __ _   _  ___ ___ _  ___  _ __   ___  ___          "+ConsoleColors.RESET+"||");
        System.out.println("||"+ConsoleColors.GREEN+"       | | | '_ \\/ __| __| '__| | | |/ __/ __| |/ _ \\| '_ \\ / _ \\/ __|         "+ConsoleColors.RESET+"||");
        System.out.println("||"+ConsoleColors.GREEN+"      _| |_| | | \\__ \\ |_| |  | |_| | (_| (__| | (_) | | | |  __/\\__ \\         "+ConsoleColors.RESET+"||");
        System.out.println("||"+ConsoleColors.GREEN+"     |_____|_| |_|___/\\__|_|   \\__,_|\\___\\___|_|\\___/|_| |_|\\___||___/         "+ConsoleColors.RESET+"||");
        System.out.println("||                                                                               ||");
        System.out.println("||    Para poder jugar debes usar la consola git bash o una que soporte          ||");
        System.out.println("||    caracteres/fondos de colores                                               ||");
        System.out.println("||                                                                               ||");
        System.out.println("||    El juego va por niveles, cada nivel pregunta por algo en especifico        ||");
        System.out.println("||    pero variando cada vez, mostrando diferentes resultados y respuestas       ||");
        System.out.println("||                                                                               ||");
        System.out.println("||    Por ejemplo en el nivel 3 se te va a mostrar una bandera y se te daran     ||");
        System.out.println("||    4 capitales para sumar puntos debes elegir la respuesta correcta           ||");
        System.out.println("||                                                                               ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }

    public static void MasInfo()
    {
        System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||"+ConsoleColors.YELLOW+"                                                     _                         "+ConsoleColors.RESET+"||");
        System.out.println("||"+ConsoleColors.YELLOW+"                   /\\                               | |                        "+ConsoleColors.RESET+"||");
        System.out.println("||"+ConsoleColors.YELLOW+"                  /  \\   ___ ___ _ __ ___ __ _    __| | ___                    "+ConsoleColors.RESET+"||");
        System.out.println("||"+ConsoleColors.YELLOW+"                 / /\\ \\ / __/ _ \\ '__/ __/ _` |  / _` |/ _ \\                   "+ConsoleColors.RESET+"||");
        System.out.println("||"+ConsoleColors.YELLOW+"                / ____ \\ (_|  __/ | | (_| (_| | | (_| |  __/                   "+ConsoleColors.RESET+"||");
        System.out.println("||"+ConsoleColors.YELLOW+"               /_/    \\_\\___\\___|_|  \\___\\__,_|  \\__,_|\\___|                   "+ConsoleColors.RESET+"||");
        System.out.println("||                                                                               ||");
        System.out.println("||    Este proyecto fue creado para el final de logica de programacion de ing    ||");
        System.out.println("||    de sistemas en la UPB, con el profesor Andres Bedoya Tobon (Xaca Rana).    ||");
        System.out.println("||                                                                               ||");
        System.out.println("||    Realizado por Diego Alejandro Gonzalez y Gabriel Cornejo Botero.           ||");
        System.out.println("||                                                                               ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }

}
