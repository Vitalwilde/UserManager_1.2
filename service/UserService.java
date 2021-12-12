package service;

import entity.User;
import entity.UserGender;
import entity.UserProfiling;
import exception.UserNotFoundExc;
import repository.UserRepository;
import java.util.Scanner;

public class UserService {
    public static Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();                                                             //спросить для чего так делать
    }

    public void firstUserChoice() {
        String menuChoice = scanner.nextLine().toLowerCase();
        switch (menuChoice) {
            case ("add") -> addUser();
            case ("find") -> findUser();
            case ("del") -> delUser();
            case ("upd") -> updateUser();
            case ("help") -> InterfaceMessages.mainMenu();
            default -> {
                System.out.println("Введите правильный запрос (help - для вызова справки)");
                firstUserChoice();
            }
        }
    }

    private void addUser() {
        User user = new User();
        user.setUserFirstName(enterFirstName());
        user.setUserLastName(enterLastName());
        user.setUserGender(enterGender());
        user.setUserAge(enterAge());
        user.setUserPsychotype(enterPsycho());
        userRepository.saveUser(user);
        InterfaceMessages.userSaved();
        continueMessage();
    }

    public void findUser() {
        InterfaceMessages.userFindChoice();
        String findUserChoice = scanner.nextLine();
        int userChoice = Integer.parseInt(findUserChoice);

        switch (userChoice) {
            case (1) -> searchById();
            case (2) -> searchByName();
            case (3) -> {
                System.out.println();
                InterfaceMessages.mainMenu();
                firstUserChoice();
            }
            default -> {
                System.out.println("Ошибка! Неверный ввод");
                findUser();
            }
        }
    }

    public void delUser() {
        InterfaceMessages.userDelChoice();
        String findUserChoice = scanner.nextLine();
        int userChoice = Integer.parseInt(findUserChoice);
        switch (userChoice) {
            case (1) -> delUserById();
            case (2) -> {
                System.out.println();
                InterfaceMessages.mainMenu();
                firstUserChoice();
            }
            default -> {
                System.out.println("Ошибка! Неверный ввод");
                findUser();
            }
        }
    }

    public void updateUser() {
        InterfaceMessages.userUpdateChoice();
        String findUserChoice = scanner.nextLine();
        int userChoice = Integer.parseInt(findUserChoice);
        switch (userChoice) {
            case (1) -> updateUserById();
            case (2) -> {
                System.out.println();
                InterfaceMessages.mainMenu();
                firstUserChoice();
            }
            default -> {
                System.out.println("Ошибка! Неверный ввод");
                findUser();
            }
        }
    }

    private String enterFirstName() {
        System.out.println("Введите имя");
        return checkUserFirstName();
    }

    private String checkUserFirstName() {
        String scanFirstName = scanner.nextLine();
        if (scanFirstName.equals("")) {
            System.out.println("Ошибка! Поле не может быть пустым! Введите имя");
            return checkUserFirstName();
        } else {
            return scanFirstName;
        }
    }

    private String enterLastName() {
        System.out.println("Введите фамилию");
        return checkUserLastName();
    }

    private String checkUserLastName() {
        String scanLastName = scanner.nextLine();
        if (scanLastName.equals("")) {
            System.out.println("Ошибка! Поле не может быть пустым! Введите фамилию");
            return checkUserLastName();
        } else {
            return scanLastName;
        }
    }

    private String enterGender() {
        System.out.println("Введите пол - M / Ж");
        return checkUserGender();

    }

    private String checkUserGender() {
        String scanGender = scanner.nextLine().toLowerCase();
        UserGender maleGender = UserGender.MALE;
        UserGender femaleGender = UserGender.FEMALE;
        switch (scanGender) {
            case ("м") -> {
                return maleGender.getGender();
            }
            case ("ж") -> {
                return femaleGender.getGender();
            }
            default -> {
                System.out.println("Введите корректный пол");
                return checkUserGender();

            }
        }
    }

    private Integer enterAge() {

        System.out.println("Введите возраст");
        return checkUserAge();
    }

    private Integer checkUserAge() throws NumberFormatException {
        try {
            String scanUserAge = scanner.nextLine();
            int userAgeNumber = Integer.parseInt(scanUserAge);
            if (userAgeNumber > 0 && userAgeNumber < 120)
                return userAgeNumber;
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Ошибка! Введите корректный возраст");
            return checkUserAge();
        }
        return null;
    }

    private String enterPsycho() {
        System.out.println("Введите психотип");
        //   cleanScanner();
        return checkPsycho();
    }

    private String checkPsycho() {
        UserProfiling isteroid = UserProfiling.ISTEROID;
        UserProfiling epileptoid = UserProfiling.EPILEPTOID;
        UserProfiling paranoid = UserProfiling.PARANOID;
        UserProfiling emotive = UserProfiling.EMOTIVE;
        UserProfiling shizoid = UserProfiling.SHIZOID;
        UserProfiling hypertim = UserProfiling.HYPERTIM;

        String scanUserPsycho = scanner.nextLine().toLowerCase();
        switch (scanUserPsycho) {
            case ("истероид") -> {
                return isteroid.getPsychotype();
            }
            case ("эпилептоид") -> {
                return epileptoid.getPsychotype();
            }
            case ("параноиальный") -> {
                return paranoid.getPsychotype();
            }
            case ("эмотивный") -> {
                return emotive.getPsychotype();
            }
            case ("шизоид") -> {
                return shizoid.getPsychotype();
            }
            case ("гипертим") -> {
                return hypertim.getPsychotype();
            }
            default -> {
                System.out.println("Ошибка! Введите корректный психотип");
                return checkPsycho();
            }
        }
    }

    private void searchByName() {
        String firstName = enterFirstName();
        String lastName = enterLastName();
        try {
            userRepository.searchUserByNameInRepository(firstName, lastName);
            continueMessage();
        } catch (UserNotFoundExc exc) {
            System.out.println(exc.getMessage());
            searchByName();
        }
    }

    private void searchById() {
        System.out.println("Введите ID пользователя.");
        int scanUserId = Integer.parseInt(scanner.nextLine());
        try {
            userRepository.searchUserByIdInRepository(scanUserId);
            continueMessage();
        } catch (UserNotFoundExc exc) {
            System.out.println(exc.getMessage());
            findUser();
        }
    }

    private void delUserById() {
        System.out.println("Введите ID пользователя.");
        int scanUserId = Integer.parseInt(scanner.nextLine());
        try {
            userRepository.deletingUserInRepository(scanUserId);
            continueMessage();
        } catch (UserNotFoundExc exc) {
            System.out.println(exc.getMessage());
            delUser();
        }
    }

    private void updateUserById() {
        System.out.println("Введите ID пользователя.");
        int scanUserId = Integer.parseInt(scanner.nextLine());
        User user = new User();
        user.setUserFirstName(enterFirstName());
        user.setUserLastName(enterLastName());
        user.setUserGender(enterGender());
        user.setUserAge(enterAge());
        user.setUserPsychotype(enterPsycho());
        userRepository.updatingUserInRepository(user, scanUserId);
        continueMessage();
        firstUserChoice();
    }

    public void continueMessage() {
        System.out.println(InterfaceMessages.ANSI_YELLOW + "Что бы продолжить нажмите Enter" + InterfaceMessages.ANSI_RESET);
        String userChoiceContinue = UserService.scanner.nextLine();
        if (userChoiceContinue.equals("")) {
            InterfaceMessages.mainMenu();
            firstUserChoice();
        } else {
            continueMessage();
        }
    }
}


