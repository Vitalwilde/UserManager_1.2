import service.InterfaceMessages;
import service.UserService;

public class UserManager {

    public static void main(String[] args) {
        InterfaceMessages.startMessage();
        InterfaceMessages.mainMenu();
        UserService userService = new UserService();

        userService.firstUserChoice();
    }
}
