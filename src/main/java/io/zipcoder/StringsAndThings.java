package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){


        char[] charArray = input.toCharArray();
        Integer answer = 0;

        for (int i = 0; i <charArray.length; i++){


            if ((charArray[i] == 'y') || (charArray[i] == 'z') || (charArray[i] == 'Y') || (charArray[i] == 'Z')){



                if ((i == (charArray.length - 1)) || (!Character.isLetter(charArray[i + 1]))){
                    answer++;
                }
            }
        }
        return answer;

    }








    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){

        Integer indexToRemove = 0;
        Integer index = 0;
        String answer = "";

        while (indexToRemove != -1){
            indexToRemove = base.toLowerCase().indexOf(remove.toLowerCase(), index);
            if (indexToRemove != -1) {
                answer = answer + base.substring(index, indexToRemove);
            }
            else {
                answer = answer + base.substring(index);
            }
            index = indexToRemove + remove.length();
        }
        return answer;

    }









    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){

        Integer isCount = 0;
        Integer notCount = 0;

        for (int i = 0; i < input.length(); i++){
            if (i <= input.length() - 2){
                if (input.substring(i, i+2).equals("is")){
                    isCount++;
                }
            }
            if (i <= input.length() - 3){
                if (input.substring(i, i + 3).equals("not")){
                    notCount++;
                }
            }
        }
        return isCount == notCount;




    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){

        if ((input.length() == 1) && (input.charAt(0) == 'g')){
            return false;
        }
        if ((input.charAt(input.length() - 1) == 'g') && ((input.charAt(input.length() - 2) != 'g'))){
            return false;
        }
        if ((input.charAt(0) == 'g') && ((input.charAt(1) != 'g'))){
            return false;
        }
        for(int i = 1; i < input.length() - 1; i++){
            if (input.charAt(i) == 'g'){
                if ((input.charAt(i + 1) != 'g') && (input.charAt(i - 1) != 'g')){
                    return false;
                }
            }
        }
        return true;



    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int answer = 0;
        if (input.length() < 3){
            return answer;
        }
        for (int i = 2; i < input.length(); i++){
            if ((input.charAt(i)) == input.charAt(i - 1) && (input.charAt(i) == input.charAt(i - 2))){
                answer++;
            }
        }
        return answer;
    }

}

