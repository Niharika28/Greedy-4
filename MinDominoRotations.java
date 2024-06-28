// Time Complexity : O(2N)
// Space Complexity : O(1) // constant space as max numbers can be from 1-6
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int le = tops.length;
        int target = -1;
        for(int i=0;i<le;i++){
            int tNum = tops[i];
            map.put(tNum, map.getOrDefault(tNum, 0)+ 1);
            if(map.get(tNum) >= le){
                target = tNum;
                break;
            }

            int bNum = bottoms[i];
            map.put(bNum, map.getOrDefault(bNum,0)+1);
            if(map.get(bNum) >= le){
                target= bNum;
                break;
            }
        }

        if(target == -1) return -1;

        int tRot = 0;
        int bRot = 0;

        for(int i=0;i< le;i++) {
            if(tops[i] != target && bottoms[i] != target) return -1;

            if(tops[i] != target) tRot++;
            if(bottoms[i] != target) bRot++;
        }

        return Math.min(tRot, bRot);
    }
}

// Time Complexity : O(N)  // worst case :O(2N)
// Space Complexity : O(1) // constant space as max numbers can be from 1-6
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int re = check(tops, bottoms, tops[0]);
        if(re != -1) return re;
        return check(tops, bottoms, bottoms[0]);
    }

    private int check(int[] tops, int[] bottoms, int target){
        int tRot=0, bRot=0;

        for(int i=0;i< tops.length;i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) tRot++;
            if(bottoms[i] != target) bRot++;
        }

        return Math.min(tRot, bRot);
    }
}