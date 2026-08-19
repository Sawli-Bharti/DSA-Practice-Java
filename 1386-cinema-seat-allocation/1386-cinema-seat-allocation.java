class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeat) {
        HashMap<Integer,List<Boolean>> blockOccupied=new HashMap<>();
        for(int i=0;i<reservedSeat.length;i++){
            int r=reservedSeat[i][0], s=reservedSeat[i][1];
            if(s>=2 && s<=5) blockOccupied.computeIfAbsent(r, k -> new ArrayList<>(Arrays.asList(false, false, false)))
             .set(0, true);
            if(s>=4 && s<=7) blockOccupied.computeIfAbsent(r, k -> new ArrayList<>(Arrays.asList(false, false, false)))
             .set(1, true);
            if(s>=6 && s<=9) blockOccupied.computeIfAbsent(r, k -> new ArrayList<>(Arrays.asList(false, false, false)))
             .set(2, true);
        } 
        int count=0;
        for(Map.Entry<Integer,List<Boolean>> e:blockOccupied.entrySet()){
            Boolean block1=e.getValue().get(0);
            Boolean block2=e.getValue().get(1);
            Boolean block3=e.getValue().get(2);
            if(!block1 && !block3) count+=2;
            else if(!block1 && !block2) count++;
            else if(!block2 && !block3) count++;
            else if(!block1 || !block2  || !block3) count++;
        }
        return count+(n-blockOccupied.size())*2;
    }
}