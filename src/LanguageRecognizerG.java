public class LanguageRecognizerG {
    /**
     * String G is a field of class LanguageRecognizerG, which will be use in other methods in the class.
     */
    String G;

    /**
     * This is the constructor of class LanguageRecognizerG
     * @param nextLine the input of the word in G language from the client program
     */
    public LanguageRecognizerG(String nextLine) {
        this.G = nextLine;
    }

    /**
     * This method check if the input word follows the rules of language G
     * @param G is the word in language G come from the input
     * @return true if the input word follow the rules of language G, false if otherwise
     */
    public boolean recursiveRecogG(String G){
        if(((G.equals("")) || G.length()==1) || G.length()==2){
            if(G.equals("")){
                return true;
            }else if(G.length()==1){
                if((G.equals("&") || G.equals("#"))) {
                    return true;
                }else{
                    return false;
                }
            }else{
                if(((G.charAt(0)== 'W')||(G.charAt(0)=='A'))&&
                        ((G.charAt(1)=='&')||(G.charAt(1)=='#'))){
                    return true;
                }else if(((G.charAt(1)== 'W')||(G.charAt(1)=='A'))&&
                        ((G.charAt(0)=='&')||(G.charAt(0)=='#'))){
                    return true;
                }else{
                    return false;
                }
            }
        }else{
            if((G.charAt(G.length()-1)=='W')||(G.charAt(G.length()-1)=='A')){
                return recursiveRecogG(G.substring(1, G.length()-1));
            }else{
                return false;
            }
        }
    }

    /**
     * The method check the validity of the input word of G language, if it is valid, print out a message indicate that
     * the word is valid, else also print out a message indicate that the word is not a valid word of the G language.
     */
    public void recursivePrintG(){
        boolean check = recursiveRecogG(G);
        if (check) {
            System.out.println("Recursion: Word \"" + G + "\" IS a word of the G language");
        } else {
            System.out.println("Recursion: Word \"" + G + "\" is NOT a word of the G language ");
        }
    }
}





