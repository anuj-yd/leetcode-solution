class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int spaceIndex = 0; 
        for (int i = 0; i < s.length(); i++) {
            // Check if the current index matches a space position
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                sb.append(" ");
                spaceIndex++; // Move to the next space position
            }
            sb.append(s.charAt(i)); // Add the current character
        }
        return sb.toString();
    }
}