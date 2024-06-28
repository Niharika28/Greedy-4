// Time Complexity : O(length of source * length of target)
// Space Complexity : O(1) // constant space for a-z chars
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int shortestWay(String source, String target) {
        HashSet<Character> set = new HashSet<>();

        for(char c : source.toCharArray()) {
            set.add(c);
        }

        int sp=0, tp=0, count=0;

        while(tp < target.length()){
            char tChar = target.charAt(tp);
            char sChar = source.charAt(sp);
            if(!set.contains(tChar)) return -1;

            if(sChar == tChar){
                tp++;

                if(tp == target.length()){
                    count++;
                    return count;
                }
            }

            sp++;
            if(sp == source.length()){
                sp = 0;
                count++;
            }
        }

        return count;
    }
}

// Time Complexity : O(N * log K)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for(int i=0;i< source.length();i++){
            char sChar = source.charAt(i);
            if(!map.containsKey(sChar)){
                map.put(sChar, new ArrayList<>());
            }

            map.get(sChar).add(i);
        }

        int tp=0, sp=0, count =0;

        while(tp < target.length()){
            char tChar = target.charAt(tp);

            if(!map.containsKey(tChar)) return -1;
            List<Integer> li = map.get(tChar);

            int k = Collections.binarySearch(li, sp);

            if(k < 0){
                k = -k-1;
            }

            if(k == li.size()){
                sp = li.get(0);
                count++;
            }else{
                sp = li.get(k);
            }
            sp++;
            tp++;
        }


        if(tp == target.length()) {
            return count+1;
        }

        return 234;
    }
}