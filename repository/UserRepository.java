package repository;

import entity.User;
import exception.UserNotFoundExc;
import service.InterfaceMessages;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    private static final Map<Integer, User> userStorage = new HashMap<>();

    public void saveUser(User user) {
        Integer idUserCount = userStorage.size() + 1;
        user.setId(idUserCount);
        userStorage.put(idUserCount, user);
        System.out.println(user);
        System.out.println();
    }

    public void searchUserByIdInRepository(Integer userId) throws UserNotFoundExc {
        validateUserId(userId);
        System.out.println(userStorage.get(userId));
        System.out.println();
    }

    private static void validateUserId(Integer userId) throws UserNotFoundExc {
        if (userStorage.containsKey(userId)) {
            return;
        }
        throw new UserNotFoundExc("Пользователь не найден! Повторите запрос");
    }

    public void searchUserByNameInRepository(String userFirstName, String userLastName) throws UserNotFoundExc {
        Optional<User> userFromRepository = userStorage.values().stream()
                .filter(user -> user.getUserFirstName().equalsIgnoreCase(userFirstName))
                .filter(user -> user.getUserLastName().equalsIgnoreCase(userLastName))
                .findFirst();
        User user = userFromRepository.orElseThrow(() -> new UserNotFoundExc("Пользователь c данным именем не найден! Повторите запрос"));
        System.out.println(user);
        System.out.println();
    }

    public void deletingUserInRepository(Integer scanUserId) throws UserNotFoundExc {
        userStorage.remove(scanUserId);
        System.out.println();
        InterfaceMessages.userDeleted();
    }

    public void updatingUserInRepository(User user, Integer scanUserId) {
        userStorage.replace(scanUserId, user);
        user.setId(scanUserId);
        InterfaceMessages.userUpdated();
        System.out.println();
        System.out.println(userStorage.get(scanUserId));

    }
}


