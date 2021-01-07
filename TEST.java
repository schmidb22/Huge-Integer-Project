//2SI4 Lab2
//Test Class
//Brooklyn Schmidt
//400065772

package hugeinteger;
import java.util.Random;

public class Test {
    public static void main(String[] args){
        //Test Contstuctor 1
                
        System.out.println("No1-> test constructor 1 (0 in front)");
        HugeInteger int1 = new HugeInteger("0000000012345678900");  
        System.out.println("Size= "+int1.getSize()+"\nInt = " + int1.toString());
        System.out.println("*********************************************************");
         
        System.out.println("No2-> test constructor 1 (negative number)");
        HugeInteger int2 = new HugeInteger("-3468987");
        System.out.println("Size= "+int2.getSize()+"\nInt = "+int2.toString());
        System.out.println("*********************************************************");
        
        System.out.println("No3-> test constructor 1 (character in string)");
        try{
             HugeInteger int3 = new HugeInteger("123a456");
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        }
        System.out.println("*********************************************************");
        
        System.out.println("No4-> test constructor 1 (string of zeros)");
        System.out.println("Int = "+ new HugeInteger("000000000"));
        System.out.println("*********************************************************");
                               
        System.out.println("No5-> test constructor 2 (invalid index)");
        try {
            HugeInteger int5 = new HugeInteger(-3);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println(e);
        }
        System.out.println("*********************************************************");
        
        System.out.println("No6-> test constructor 2 (valid input)");
        HugeInteger int6 = new HugeInteger(100);
        System.out.println("Size= "+int6.getSize()+"\nInt = "+int6.toString());
        System.out.println("*********************************************************");
        
        System.out.println("No7-> test add (expect 8)");
        HugeInteger int7 = new HugeInteger("3"); 
        HugeInteger int8 = new HugeInteger("5");  
        HugeInteger int9 = int7.add(int8);
        System.out.println("Size = "+int9.getSize()+"\nInt = "+int9.toString());
        System.out.println("*********************************************************");
        
        System.out.println("No8->test add (expect 444444)");
        HugeInteger int10 = new HugeInteger("333333");
        HugeInteger int11 = new HugeInteger("111111");
        HugeInteger int12 = int10.add(int11);
        System.out.println("Size = "+ int12.getSize()+"\nInt = "+int12.toString());
        System.out.println("*********************************************************");
        
        System.out.println("No9->test add (expect 1000000)");
        HugeInteger int13 = new HugeInteger("999999");
        HugeInteger int14 = new HugeInteger("1");
        HugeInteger int15 = int13.add(int14);
        System.out.println("Size = "+ int15.getSize()+"\nInt = "+int15.toString());
        System.out.println("*********************************************************");
        
        System.out.println("No10->test subtract (expect 123456)");
        HugeInteger int16 = new HugeInteger("1234567");
        HugeInteger int17 = new HugeInteger("11111111");
        HugeInteger int18 = int16.subtract(int17);
        System.out.println("Size = "+ int18.getSize()+"\nInt = "+int18.toString());
        System.out.println("*********************************************************");
        
        System.out.println("No11->test subtract (expect -998765)");
        HugeInteger int19 = new HugeInteger("1234");
        HugeInteger int20 = new HugeInteger("999999");
        HugeInteger int21 = int19.subtract(int20);
        System.out.println("Size = "+ int21.getSize()+"\nInt = "+int21.toString());
        System.out.println("*********************************************************");
         
        System.out.println("No12->test subtract");
        System.out.println("15-7 = " + new HugeInteger("15").subtract(new HugeInteger("7")).toString());
        System.out.println("7-15 = " + new HugeInteger("7").subtract(new HugeInteger("15")).toString());
        System.out.println("(-15)-7 = " + new HugeInteger("-15").subtract(new HugeInteger("7")).toString());
        System.out.println("7-(-15) = " + new HugeInteger("7").subtract(new HugeInteger("-15")).toString());
        System.out.println("15-(-7) = " + new HugeInteger("15").subtract(new HugeInteger("-7")).toString());
        System.out.println("(-7)-15 = " + new HugeInteger("-7").subtract(new HugeInteger("15")).toString());
        System.out.println("(-15)-(-7) = " + new HugeInteger("-15").subtract(new HugeInteger("-7")).toString());
        System.out.println("(-7)-(-15) = " + new HugeInteger("-7").subtract(new HugeInteger("-15")).toString());
        System.out.println("*********************************************************");
        
        System.out.println("No13->test subtract (expect -864198)");
        System.out.println("Int = "+new HugeInteger("999994").subtract(new HugeInteger("999999")));
        System.out.println("*********************************************************");
        
        System.out.println("No14->test subtract (expect 0)");
        System.out.println("Int = "+new HugeInteger("4").subtract(new HugeInteger("4")));
        System.out.println("*********************************************************");
        
        System.out.println("No15->test subtract (expect error");
        try{
            new HugeInteger("55").subtract(new HugeInteger("23d45"));
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        }
        System.out.println("*********************************************************");
        
        System.out.println("No16->test multiply (expect -1518435)");
        System.out.println("Int = "+new HugeInteger("-12345").multiply(new HugeInteger("123")));
        System.out.println("*********************************************************");
        
        System.out.println("No17->test multiply (expect 9999800001)");
        System.out.println("Int = "+new HugeInteger("-99999").multiply(new HugeInteger("-99999")));
        System.out.println("*********************************************************");
        
        System.out.println("No18->test multiply (random numbers)");
        System.out.println("Int = "+new HugeInteger(50).multiply(new HugeInteger(50)));
        System.out.println("*********************************************************");
        
        System.out.println("No19->test compare (88888:111)");
        System.out.println("Int = "+new HugeInteger("88888").compare(new HugeInteger("111")));
        System.out.println("*********************************************************");
        
        System.out.println("No20->test compare (-88:111)");
        System.out.println("Int = "+new HugeInteger("-88").compare(new HugeInteger("111")));
        System.out.println("*********************************************************");
        
        System.out.println("No21->test compare (88888:11111)");
        System.out.println("Int = "+new HugeInteger("88888").compare(new HugeInteger("11111")));
        System.out.println("*********************************************************");
        
        System.out.println("No22->test compare (999998:999999)");
        System.out.println("Int = "+new HugeInteger("999998").compare(new HugeInteger("999999")));
        System.out.println("*********************************************************");
        
        System.out.println("No23->test compare (88888:88888)");
        System.out.println("Int = "+new HugeInteger("88888").compare(new HugeInteger("88888")));
        System.out.println("*********************************************************");
        
        System.out.println("No24->test compare (-221:-222)");
        System.out.println("Int = "+new HugeInteger("-221").compare(new HugeInteger("-222")));
        System.out.println("*********************************************************");   
        
        /*HugeInteger huge1, huge2, huge3;
        int MAXRUN = 500;
        int MAXNUMINTS = 100;
        int n = 500;
        long startTime, endTime;
        double runTime=0.0;
        for(int numInts=0;numInts<MAXNUMINTS;numInts++){
            huge1= new HugeInteger(n);
            huge2 = new HugeInteger(n);
            startTime = System.currentTimeMillis();
            for(int numRun=0;numRun<MAXRUN;numRun++)
                huge3 = huge1.add(huge2);
            endTime = System.currentTimeMillis();
            runTime += (double)(endTime-startTime)/((double)MAXRUN);
        }
        runTime = runTime/((double)MAXNUMINTS);
        System.out.println("Run time = "+ runTime);*/
    }
}

