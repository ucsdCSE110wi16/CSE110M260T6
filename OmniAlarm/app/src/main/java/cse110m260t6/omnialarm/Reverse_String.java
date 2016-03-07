package cse110m260t6.omnialarm;
import java.util.Random;

/**
 * Created by Boyu on 3/5/16.
 */
public class Reverse_String {
    private String rev;
    private String result;
    private String[] arr = {"acquaaintanceship", "biotransformation",
            "chemiluminescence", "lexicostatistics",
            "noncontradiction", "omnidirectional",
            "parliamentarianism", "xerophthalmia",
            "vasoconstriction", "unenthusiastically"};


    public Reverse_String() {
        Random random = new Random();
        int number = random.nextInt(10);
        this.rev = arr[number];
        this.reverse();
    }

    public void reverse(){
        this.result = new StringBuffer(rev).reverse().toString();
    }

    public boolean checkresult(String str){
        if(str.equals(result)){
            return true;
        }
        else{
            return false;
        }
    }

    public String getString(){
        return this.rev;
    }
}