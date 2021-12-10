package service;

public class InterfaceMessages {
    private static UserService userService;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static void startMessage() {
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println(ANSI_GREEN + "Добро пожаловать в редактор пользователей. Вы можете: Добавить, удалить, найти и обновить данные о пользователе" + ANSI_RESET);
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    public static void mainMenu() {
        System.out.println("Для добавления пользователя введите - \"add\"");
        System.out.println("Для поиска пользователя введите - \"find\"");
        System.out.println("Для удаления пользователя введите - \"del\"");
        System.out.println("Для обновления данных о пользователе введите - \"upd\"");
//        System.out.println("Загрузить базу данных - \"load\"");
//        System.out.println("Сохранить базу данных - \"save\"");
//      System.out.println("Для получения помощи введите - \"help\"");
    }


    public static void userSaved() {
        System.out.println("Пользователь сохранен!" + ANSI_YELLOW + "             OK!" + ANSI_RESET);
        System.out.println();
    }

    public static void userFindChoice() {
        System.out.println("""
                "1" - Поиск по ID
                "2" - Поиск по Имени и Фамилии
                "3" - Выйти в главное меню""");
    }

    public static void userDelChoice() {
        System.out.println("""
                "1" - Удалить по ID
                "2" - Выйти в главное меню
                """);
    }

    public static void userUpdateChoice() {
        System.out.println("""
                "1" - Обновить по ID
                "2" - Выйти в главное меню
                """);
    }

    public static void userDeleted() {
        System.out.println("Пользователь удален!" + ANSI_YELLOW + "             OK!" + ANSI_RESET);
        System.out.println();
    }

    public static void userUpdated() {
        System.out.println("Пользователь обновлен!" + ANSI_YELLOW + "             OK!" + ANSI_RESET);
        System.out.println();
    }
}
