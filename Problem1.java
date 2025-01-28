class Problem1 {
    //TC:O(N)
    //SC:O(N)
    public List<String> findRepeatedDnaSequences(String s) {
        int m = s.length();
        Set<String> result = new HashSet<>();

        int numOfPossibleChars = 26;
        long posFactor = (long) Math.pow(numOfPossibleChars,10);// it is possible characters raised to the power window size : 26^10 (A,C,G,T is only 4 but we consider all 26) raised to 10

        Set<Long> hashes = new HashSet<>();

        long curHash = 0l;

        for(int j=0;j<m;j++){
            char ch = s.charAt(j);

            curHash = ((curHash * numOfPossibleChars) + (ch -'A' +1));
            if(j>=10){
                //remove the outgoing character
                char outChar = s.charAt(j-10);
                curHash = (curHash - ((outChar - 'A' +1)*posFactor));

            }

            if(hashes.contains(curHash)){
                String currString = s.substring(j-9,j+1);
                result.add(currString);
            }else{
                hashes.add(curHash);
            }

        }

        return new ArrayList<>(result);

    }
}