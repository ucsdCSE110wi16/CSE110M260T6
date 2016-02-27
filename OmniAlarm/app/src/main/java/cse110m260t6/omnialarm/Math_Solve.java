package cse110m260t6.omnialarm;

import java.util.Random;

/**
 * Created by Boyu on 2/21/16.
 */
public class Math_Solve {
    private int x;
    private int y;
    private int result;
    private boolean addsub;

    public Math_Solve(){
        setFirst();
        setSecond();
        doMath();
    }

    //modified by ging
    public void setFirst() {
        Random r = new Random();
        this.x = r.nextInt(101);
    }

    public void setSecond(){
        Random r = new Random();
        this.y = r.nextInt(101);
    }

    public void doMath() {
        Random r = new Random();
        int temp = r.nextInt(2);

        if(temp == 0){
            addsub = true;
            result = x + y;
        }
        else {
            addsub = false;
            result = x - y;
        }
    }

    public boolean checkAnswer(int a){
        if(this.result == a){
            return true;
        }
        else{
            return false;
        }
    }

    public int getFirst(){
        return x;
    }

    public int getSecond(){
        return y;
    }

    public int getResult(){
        return result;
    }

    public boolean getOperator(){
        return addsub;
    }

    //added by ging
    public String printOperator() {
        if(getOperator()) {
            return "+";
        }
        else
            return "-";
    }

    //convert int to string
    public String firstToString() {
        String first = String.valueOf(x);
        return first;
    }

    public String secondToString() {
        String second = String.valueOf(y);
        return second;
    }

    public String resultToString() {
        String r = String.valueOf(result);
        return r;
    }

}

