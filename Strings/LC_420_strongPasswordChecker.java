/*
    https://leetcode.com/problems/strong-password-checker/


    A password is considered strong if the below conditions are all met:

It has at least 6 characters and at most 20 characters.
It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
It does not contain three repeating characters in a row (i.e., "Baaabb0" is weak, but "Baaba0" is strong).
Given a string password, return the minimum number of steps required to make password strong. if password is already strong, return 0.

In one step, you can:

Insert one character to password,
Delete one character from password, or
Replace one character of password with another character.

intiution:
1. check for missing types and repeating groups
2. if length < 6, we can only insert, so the answer is max(missing, 6-n)
3. if length between 6 and 20, we can only replace, so the answer is max(missing, replacement)
4. if length > 20, we need to delete first, then replace. We can greedily delete from repeating groups to reduce replacements needed.
TC- O(n) where n is the length of the password
SC- O(n) for storing repeating groups, O(1) for other variables
*/


class Solution {
    public boolean upperCaseCheck(String p){
        for(char c:p.toCharArray()){
            if(c>='A' && c<='Z') return true;
        }
        return false;
    }

    public boolean lowerCaseCheck(String p){
        for(char c:p.toCharArray()){
            if(c>='a' && c<='z') return true;
        }
        return false;
    }

    public boolean containsDigit(String p){
        for(char c:p.toCharArray()){
            if(c>='0' && c<='9') return true;
        } 
        return false;
    }

    // modified: also store lengths for greedy deletion
    public List<Integer> getRepeatingLengths(String p){
        List<Integer> list = new ArrayList<>();
        int count = 1;

        for(int i=1;i<p.length();i++){
            if(p.charAt(i)==p.charAt(i-1)){
                count++;
            }else{
                if(count>=3) list.add(count);
                count=1;
            }
        }
        if(count>=3) list.add(count);

        return list;
    }

    public int strongPasswordChecker(String password) {
        int n = password.length();

        boolean hasUpper = upperCaseCheck(password);
        boolean hasLower = lowerCaseCheck(password);
        boolean hasDigit = containsDigit(password);

        int missing = 0;
        if(!hasUpper) missing++;
        if(!hasLower) missing++;
        if(!hasDigit) missing++;

        // get repeating groups
        List<Integer> list = getRepeatingLengths(password);

        int replacement = 0;
        for(int len : list){
            replacement += len / 3;
        }

        // case 1
        if(n < 6) return Math.max(missing, 6 - n);

        // case 2
        if(n <= 20) return Math.max(missing, replacement);

        // case 3: n > 20
        int delete = n - 20;

        // greedy deletion
        int remainDelete = delete;

        // step 1: len % 3 == 0
        for(int i=0;i<list.size() && remainDelete>0;i++){
            if(list.get(i) >= 3 && list.get(i) % 3 == 0){
                list.set(i, list.get(i)-1);
                remainDelete--;
                replacement--;
            }
        }

        // step 2: len % 3 == 1
        for(int i=0;i<list.size() && remainDelete>0;i++){
            if(list.get(i) >= 3 && list.get(i) % 3 == 1){
                int del = Math.min(2, remainDelete);
                list.set(i, list.get(i)-del);
                remainDelete -= del;
                if(del == 2) replacement--;
            }
        }

        // step 3: rest
        for(int i=0;i<list.size() && remainDelete>0;i++){
            if(list.get(i) >= 3){
                int del = Math.min(remainDelete, list.get(i)-2);
                list.set(i, list.get(i)-del);
                remainDelete -= del;
                replacement -= del/3;
            }
        }

        return delete + Math.max(missing, replacement);
    }
}