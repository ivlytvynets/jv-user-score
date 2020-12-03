package core.basesyntax;

import exception.UserNotFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {

    public int getUserScore(String[] records, String email) throws UserNotFoundException {
        String[][] data = new String[records.length][2];
        for (int i = 0; i < records.length; i++) {
            data[i][0] = records[i].split(":")[0];
            data[i][1] = records[i].split(":")[1];
        }
        int indexEmail = 0;
        boolean isContainEmail = false;
        for (int i = 0; i < records.length && !isContainEmail; i++) {
            if (data[i][0] == email) {
                isContainEmail = true;
                indexEmail = i;
            }
        }
        if (!isContainEmail) {
            throw new UserNotFoundException("User with given email doesn't exist");
        }

        return Integer.parseInt(data[indexEmail][1]);
    }
}
