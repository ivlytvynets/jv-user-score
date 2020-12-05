package core.basesyntax;

import exception.UserNotFoundException;

public class UserService {

    public int getUserScore(String[] records, String email) throws UserNotFoundException {
        for (String record:
                records) {
            String[] data = record.split(":");
            if (data[0].equals(email)) {
                return Integer.parseInt(data[1]);
            }
        }
        throw new UserNotFoundException("User with given email doesn't exist");
    }
}
