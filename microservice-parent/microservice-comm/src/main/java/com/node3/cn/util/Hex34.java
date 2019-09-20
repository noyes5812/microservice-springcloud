package com.node3.cn.util;

import java.util.HashMap;


public   class Hex34 {
	  public static void main(String[] args) { 
		  
		  // System.out.println("ii="+to10("0AB"));
		  System.out.println("ii="+UtilCommon.left0("AB",3));
		  
	  }

    public  static HashMap<String, Integer> digitsMap = new HashMap<String, Integer>() {   
		    { 
		        put("0",0);  
		        put("1",1); 
		        put("2",2);  
		        put("3",3); 
		        put("4",4);  
		        put("5",5); 
		        put("6",6);  
		        put("7",7); 
		        put("8",8);  
		        put("9",9); 
		        put("A",10);  
		        put("B",11); 		        
		        put("C",12);  
		        put("D",13); 
		        put("E",14);  
		        put("F",15);  
		        put("G",16);  
		        put("H",17);  
		        put("J",18);  
		        put("K",19); 
		        put("L",20);  
		        put("M",21); 
		        put("N",22);  
		        put("P",23); 	
		        put("Q",24);  
		        put("R",25); 
		        put("S",26);  
		        put("T",27); 
		        put("U",28);  
		        put("V",29); 
		        put("W",30);  
		        put("X",31); 
		        put("Y",32);  
		        put("Z",33);  
		    }
		};
 
    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
        99999999, 999999999, Integer.MAX_VALUE };
    final static char[] digits = {
        '0' , '1' , '2' , '3' , '4' , '5' ,
        '6' , '7' , '8' , '9' , 'A' , 'B' ,
        'C' , 'D' , 'E' , 'F' , 'G' , 'H' ,
         'J' , 'K' , 'L' , 'M' , 'N' ,
          'P' , 'Q' , 'R' , 'S' , 'T' ,
        'U' , 'V' , 'W' , 'X' , 'Y' , 'Z'
    };

    final static char [] DigitTens = {
        '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
        '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
        '2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
        '3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
        '4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
        '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
        '6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
        '7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
        '8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
        '9', '9', '9', '9', '9', '9', '9', '9', '9', '9',
        } ;

    final static char [] DigitOnes = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        } ;

    
    
    static void getChars(int i, int index, char[] buf) {
        int q, r;
        int charPos = index;
        char sign = 0;

        if (i < 0) {
            sign = '-';
            i = -i;
        }

        // Generate two digits per iteration
        while (i >= 65536) {
            q = i / 100;
        // really: r = i - (q * 100);
            r = i - ((q << 6) + (q << 5) + (q << 2));
            i = q;
            buf [--charPos] = DigitOnes[r];
            buf [--charPos] = DigitTens[r];
        }

        // Fall thru to fast mode for smaller numbers
        // assert(i <= 65536, i);
        for (;;) {
            q = (i * 52429) >>> (16+3);
            r = i - ((q << 3) + (q << 1));  // r = i-(q*10) ...
            buf [--charPos] = digits [r];
            i = q;
            if (i == 0) break;
        }
        if (sign != 0) {
            buf [--charPos] = sign;
        }
    }
 
    public static int to10(String str) {
    	String newStr = str.replaceAll("^(0+)", "");  
    	System.out.println("newStr=="+newStr);
    	double v = 0;
    	int len = newStr.length();
    	for(int i=0;i<len;i++){ 
    		int j = digitsMap.get(String.valueOf(newStr.charAt(i))); 
    		System.out.println("j=="+j);
    		v = v +   ( j * Math.pow(34,(len-i-1))) ;
    	}  
        return (new Double(v)).intValue();
    }
    
    public static String toString(int i) {
        if (i == Integer.MIN_VALUE)
            return "-2147483648";
        int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
        char[] buf = new char[size];
        getChars(i, size, buf);
        return new String(buf.toString());
    }
    public static String toString(int i, int radix) {

        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
            radix = 10;

        /* Use the faster version */
        if (radix == 10) {
            return toString(i);
        }

        char buf[] = new char[33];
        boolean negative = (i < 0);
        int charPos = 32;

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = digits[-(i % radix)];
            i = i / radix;
        }
        buf[charPos] = digits[-i];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }

    static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }


}

