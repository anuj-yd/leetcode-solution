class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<command.length();i++){
            command.charAt(i);
            if(command.charAt(i) == 'G'){
                sb.append("G");
            }if(command.charAt(i)=='('&&command.charAt(i+1)==')'){
                sb.append("o");
            }if(command.charAt(i)=='a'&&command.charAt(i+1)=='l'){
                sb.append("al");
            }
        }
        return sb.toString();
    }
}