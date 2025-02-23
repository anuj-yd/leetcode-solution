class Solution {
    public List<String> fizzBuzz(int n){
        // synyex of creating an empty list of string
        List<String> s = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5==0){
                // add is the buit-in funtion work like append;
                s.add("FizzBuzz");
            }else if(i%3==0){
                s.add("Fizz");
            }else if(i%5==0){
                s.add("Buzz");
            }else{
                String sv = String.valueOf(i);
                s.add(sv);
            }
        }
        return s;
    }
}