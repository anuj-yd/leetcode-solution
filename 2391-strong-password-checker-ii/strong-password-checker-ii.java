class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8)return false;

        boolean l = false;
        boolean u = false;
        boolean d = false;
        boolean spc = false;

        String schar = "!@#$%^&*()-+";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isLowerCase(c)) {
                l = true;
            }
            else if (Character.isUpperCase(c)) {
                u = true;
            }
            else if (Character.isDigit(c)) {
                d = true;
            }
            else if (schar.contains(String.valueOf(c))) {
                spc = true;
            }

            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
        }
        return l && u && d && spc;
    }
}