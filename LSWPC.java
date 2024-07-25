class Solution {
    public int lengthOfLongestSubstring(String s) {

      // initialise two integer values with 0
          int j = 0;
        int lenSubstr = 0;
      // create a Hashset for setting the index and the values associated 
      // you will see further how it works in a loop

        HashSet<Character> subset = new HashSet<Character>();

      // we will initialise the loop with max to string length
        for (int i = 0; i < s.length(); i++) {
          // here we see character in each index of the String
            char c = s.charAt(i);

          // Here we will check if we already saved the character in the HashSet 
          // and proceed only when we wont find it 

            if (!subset.contains(c)) {
              // we will add it since we did not found it
                subset.add(c);
              // here we check the maximum size of the two strings
                lenSubstr = Math.max(lenSubstr, subset.size());
            } else {
              // we will follow the below loop when we wont find the value in the hashset
              // but we will make sure that dont cover the same index of character that we already did 
              // so we keep the value of j < i
                while (j < i) {
                  // we will check if the character in a String at index j is equal to character at i index 
                  // (i.e character c)
                    if (s.charAt(j) == c) {
                        j++;
                        break;
                    } else {
                      // else we remove that character key in hashset and move further 
                        subset.remove(s.charAt(j));
                        j++;
                    }
                }

              
            }
        }
      return lenSubstr;
    }
}
