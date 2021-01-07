//2SI4 Lab2
//Brooklyn Schmidt
//400065772

package hugeinteger;
import java.util.Random;

public class HugeInteger {
    private int hugeint[];
    private int size;
    private boolean negative;
    
    public HugeInteger(String val) throws IllegalArgumentException { 
        size = val.length();
        hugeint = new int[size];
        negative = false;
        char[] val2 = val.toCharArray();//converts the string to an array of characters
        int p=0;//represents the actual start of the number
        if(val2[0]=='-'){//if the number is negative
            p++;//the array is shifted right so the sign is not included in the number
            negative =true;
            size--;
        }
        while(val2[p]=='0'){//if the number begins with a 0
            p++;//the array is shifted right so the zero is not included in the number
            size--;
            if(size==0){
                size = 1;
                hugeint[0] = 0;
                return;
            }                
        }
        int j=0;//the indexing of hugeint must start at 0
        for(int i=p;i<size+p;i++,j++){
            if((int)val2[i]<48||(int)val2[i]>57)//if one of the numbers is a character
                throw new IllegalArgumentException("Index "+(i+1)+" is not valid.");                
            hugeint[j]= (int)val2[i]-48;       
        }        
    }
    public HugeInteger(int n)throws IndexOutOfBoundsException{
        if(n<=0)//you cannot have a number with 0 or negatie digits
            throw new IndexOutOfBoundsException("Invalid index");
        size = n;
        hugeint = new int[size];        
        Random rand = new Random();
        hugeint[0] = rand.nextInt(9)+1;//finds a random number from 1-9
        for(int i=1;i<size;i++){
           hugeint[i]=rand.nextInt(10);//finds a random number from 0-9           
        }
        negative = rand.nextBoolean();//randomly assigns negative a boolean   
    }
    public HugeInteger add(HugeInteger h) {
        String output = "";
        int []sum;//new int array      
        if (this.negative&&h.negative==false){ //check if the signs are the same otherwise you subtract
            negative=false;
            return h.subtract(this);
        }
        if (this.negative==false&&h.negative){
            h.negative=false;
            return subtract(h);
        }
        if(this.negative&&h.negative)
            output += "-";
        int n = size>=h.size?size:h.size;//initializes n to the larger of the two int sizes
        int diff = java.lang.Math.abs(size - h.size);//finds the difference between them
        sum = new int[n + 1];//adds one extra space to n in case there is a carry in the last digit
        for (int i =n-diff-1;i>=0;i--) {
            sum[i+diff+1] += hugeint[size>=h.size?i+diff:i] + h.hugeint[size>=h.size?i:i+diff];
            if (sum[i+diff+1] > 9) {
                sum[i+diff] += 1;//carries to the next digit
                sum[i+diff+1] -= 10;
            } 
        }
        for (int i = diff-1; i >=0; i--) {
            sum[i+1] += (size>=h.size?this.hugeint:h.hugeint)[i];
            if (sum[i+1] > 9) {
                sum[i+1] -= 10;
                sum[i] += 1;
            }
        }
        for (int i=0;i<n+1;i++) 
            output += String.valueOf(sum[i]);//converts the array to a string
        return new HugeInteger(output);//converts the string to a HugeInteger and returns it
    }
    public HugeInteger subtract(HugeInteger h){
        String output = "";
        int []sub;//new int array 
        int diff = java.lang.Math.abs(size-h.size);
        int n = size>=h.size?size:h.size;
        sub = new int[n];
        if(negative&&!h.negative){//special case: subtract from a negative number is adding
                h.negative=true;
                return add(h);
        }
        if(!negative&&h.negative){//special case: subtracting a negative number is adding
                h.negative=false;
                return add(h);
        }
        if(negative&&h.negative)//special case: if both numbers are negative the sign is switched
                output += "-";
        if(size>h.size){//big int-small int        
            for(int i=n-diff-1;i>=0;i--){
                sub[i+diff] += hugeint[i+diff] - h.hugeint[i];
                if(sub[i+diff]<0){
                    sub[i+diff] += 10;
                    sub[i+diff-1] -= 1;
                }
            }
            for(int j=diff-1;j>0;j--){
                sub[j] += hugeint[j];
                if(sub[j]<0){
                    sub[j] += 10;
                    sub[j-1] -= 1;
                }
            }
            sub[0] += hugeint[0];
            if(sub[0]<0){
                sub[0] += 10;
                if("-".equals(output))
                    output = "";
                else
                    output = "-";
                }
            
        }
        if(h.size>size){//small int - big int
            if("-".equals(output))
                output = "";
            else
                output = "-";
            for(int i=n-diff-1;i>=0;i--){
                sub[i+diff] += h.hugeint[i+diff] - hugeint[i];
                if(sub[i+diff]<0){
                    sub[i+diff] += 10;
                    sub[i+diff-1] -= 1;
                }
            }
            for(int j=diff-1;j>0;j--){
                sub[j] += h.hugeint[j];
                if(sub[j]<0){
                    sub[j] += 10;
                    sub[j-1] -= 1;
                }
            }
            sub[0] += h.hugeint[0];
            if(sub[0]<0){
                sub[0] += 10;
            if("-".equals(output))
                output = "";
            else
                output = "-";
            }            
        }
        if(h.size==size){//same number of digits
            int i=0;
            while(hugeint[i]==h.hugeint[i]){
                i++;    
                if(i==n)
                    return new HugeInteger("0");
            }
            if(hugeint[i]>h.hugeint[i]){//big int - small int           
                for(i=n-1;i>=0;i--){
                    sub[i] += hugeint[i] - h.hugeint[i];
                    if(sub[i+diff]<0){
                        sub[i+diff] += 10;
                        sub[i+diff-1] -= 1;
                    }
                }
                }
            else if(h.hugeint[i]>hugeint[i]){//small int - big int                
                    if("-".equals(output))
                        output = "";
                    else
                        output = "-";
                for(i=n-1;i>=0;i--){
                    sub[i] += h.hugeint[i] - hugeint[i];
                    if(sub[i+diff]<0){
                        sub[i+diff] += 10;
                        sub[i+diff-1] -= 1;
                    }
                }
            }       
        }
        for (int i=0;i<n;i++) 
            output += Integer.toString(sub[i]);//converts the array to a string
        return new HugeInteger(output);//converts the string to a HugeInteger and returns it       
    }
    public HugeInteger multiply(HugeInteger h){
        String output = "";
        int []mul;//new int array 
        int n = size+h.size;
        if(negative&&!h.negative||!negative&&h.negative)
            output += "-";
        mul = new int[n];
        for(int i=0;i<size;i++){
            for(int j=0;j<h.size;j++){
                mul[n-1-(j+i)] += hugeint[size-1-i]*h.hugeint[h.size-1-j];
                while(mul[n-1-(i+j)]>9){
                    mul[n-1-(i+j)] -= 10;
                    mul[n-2-(i+j)] += 1;
                }
            }
        }
        for (int i=0;i<n;i++) 
            output += Integer.toString(mul[i]);//converts the array to a string
        return new HugeInteger(output);//converts the string to a HugeInteger and returns it       
    }
    public int compare(HugeInteger h){
        int n = size>h.size?size:h.size;
        int i = 0;
        if(!negative&&h.negative)
            return 1;
        if(negative&&!h.negative)
            return -1;
        if(size>h.size){
            if(negative&&h.negative)
                return -1;
            return 1;
        }
        if(h.size>size){
            if(negative&&h.negative)
                return 1;
            return -1;
        }
        while(hugeint[i]==h.hugeint[i]){
            i++;
            if(i==size)
                return 0;
        }
        if(hugeint[i]>h.hugeint[i]){
            if(negative&&h.negative)
                return -1;
            return 1;
        }
        if(h.hugeint[i]>hugeint[i]){
            if(negative&&h.negative)
                return 1;
            return -1;
        }
        return 1;
    }
    public int getSize(){//returns the size of the array
        return size;
    }
    public int getHugeInt(int i){
        return hugeint[i];
    }
    public boolean getSign(){
        return negative;
    }
    public String toString(){
        String output = new String(); // creates an empty string
        if(negative)
            output += '-';//adds a negative to the front if the num is negative
        int i = 0;
        for(int j=i;j<size;j++){
            output += String.valueOf(hugeint[j]);//converts the ints to string
        }
        return output;            
    }    
}
