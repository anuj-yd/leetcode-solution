class Solution {
    public String capitalizeTitle(String title) {
        title = title.toLowerCase();
        String[] w = title.split(" "); 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < w.length; i++) {
            String wd = w[i];
            if (wd.length() <= 2) {
                sb.append(wd);
            } else {
                sb.append(Character.toUpperCase(wd.charAt(0)));
                sb.append(wd.substring(1));
            }
            if (i < w.length - 1) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}