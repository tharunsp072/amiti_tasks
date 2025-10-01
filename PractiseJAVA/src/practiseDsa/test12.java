package practiseDsa;

//A password is considered strong if the below conditions are all met:
//It has at least 6 characters and at most 20 characters.
//It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
//It does not contain three repeating characters in a row (i.e., "Baaabb0" is weak, but "Baaba0" is strong).
//Given a string password, return the minimum number of steps required to make password strong. 
//If password is already strong, return 0.
public class test12 {

    public static int password() {
        String password = "99999"; // test input
        int result = 0;

        // Check length condition
        if (password.length() < 6 || password.length() > 20) {
            result++;
        }

        // Check character types
        boolean hasLower = false, hasUpper = false, hasDigit = false;

        for (char c : password.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                hasLower = true;
            } else if (c >= 'A' && c <= 'Z') {
                hasUpper = true;
            } else if (c >= '0' && c <= '9') {
                hasDigit = true;
            }
        }

        if (!hasLower) result++;
        if (!hasUpper) result++;
        if (!hasDigit) result++;

        // Check repeating characters (3 in a row)
        int replace = 0;
        for (int i = 2; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i - 1) == password.charAt(i - 2)) {
                replace++;
                i++; // skip ahead to avoid double-counting
            }
        }

        // Final result should cover both missing categories and repeats
        return Math.max(result, replace);
    }

    public static void main(String args[]) {
        System.out.println(password());
    }
}
