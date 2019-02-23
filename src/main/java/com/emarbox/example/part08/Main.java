package com.emarbox.example.part08;

public class Main {
	 
    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        
        for(Operation op : opSet.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
    
    public static void main(String[] args) {
        double x = 2.0;
        double y = 4.0;
        test(ExtendedOperation.class, x, y);
        System.out.println(ExtendedOperation.EXP.apply(1D, 2D));;
    }
 
}