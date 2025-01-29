// ## **Question 1.** Computational Biology


// Create a class `DNA` at path `app/src/main/java/DNA.java` with the following static methods:

// ```java
// public class DNA {
//     public static String countNucleotides(String dna);
//     public static String transcribe(String dna);
//     public static String reverseComplement(String dna);
// }
// ```

package csc223.gh;

public class DNA {
    static String countNucleotides(String dna){
        int G = 0;
        int A = 0;
        int T = 0;
        int C = 0;

        char g = 'G';
        char a = 'A';
        char t = 'T';
        char c = 'C';
        
        for (int i=0; i<dna.length(); i++){
            if (dna.charAt(i) == g){
                G+= 1;
            }
            else if (dna.charAt(i) == a){
                A+= 1;
            }
            else if (dna.charAt(i) == t){
                T+= 1;
            }
            else if (dna.charAt(i) == c){
                C+= 1;
            }
        }
        return String.format("%d %d %d %d", A, C, G, T);

    }
    
    public static String transcribe(String dna){
        return dna.replace('T', 'U');
    }

    public static String reverseComplement(String dna){
        String complement = "";

        for (int i=dna.length()-1; i>=0; --i){
            if (dna.charAt(i)=='G'){
                complement += 'C';
            }
            else if (dna.charAt(i)=='C'){
                complement += 'G';
            }
            else if (dna.charAt(i)=='A'){
                complement += 'T';
            }
            else if (dna.charAt(i)=='T'){
                complement += 'A';
            }
            
        }
        return complement;

    }

    public static void main(String[] args){
        System.out.println(DNA.reverseComplement("AAAACCCGGT"));
    }

}
