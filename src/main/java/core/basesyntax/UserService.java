package core.basesyntax;

import exception.UserNotFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {

    public int getUserScore(String[] records, String email) throws UserNotFoundException {
        boolean isContain = false;
        String neededRecord = "";
        for (String record:
             records) {
            if (record.contains(email)) {
                isContain = true;
                neededRecord = record;
            }
        }
        if (isContain == false || !isValidEmail(email)) {
            throw new UserNotFoundException("User with given email doesn't exist");
        }
        String[] emailScore = neededRecord.split(":");
        return Integer.parseInt(emailScore[1]);
    }

    private static boolean isValidEmail(String email)
    {
        if (email != null)
        {
            Pattern p = Pattern.compile("^[A-Za-z].*?@gmail\\.com$");
            Matcher m = p.matcher(email);
            return m.find();
        }
        return false;
    }
}
