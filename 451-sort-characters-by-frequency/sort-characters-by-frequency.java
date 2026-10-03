class Solution {
    static class Pair{
        char ch;
        int freq;

        Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(b.freq-a.freq));

        for(char ch : map.keySet()){
            pq.offer(new Pair(ch,map.get(ch)));
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            char ch = p.ch;
            int freq = p.freq;

            while(freq>0){
                sb.append(ch);
                freq--;
            }
        }

        return sb.toString();
        
    }
}