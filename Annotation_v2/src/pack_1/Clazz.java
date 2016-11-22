package pack_1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

// the class use the annotation with both interfaces

@Interf_1(doSomething1 ="The method attr. of Interf_1 in the class_level", boolean_meth =true)
@Interf_2(double_meth = 4.0, int_meth =4)
public class Clazz {
	
// Create a method that is annotated with both interfaces
	@Interf_1(doSomething1 ="The method attr. of Interf_1 in the method_level", boolean_meth =false)
	@Interf_2(double_meth = 2.0, int_meth =2)
	public static void meth_1(){
		
	// create an instance of the class and get the method attributes at once.
	// getting annotation at the class_level is straightforward
		Clazz cz = new Clazz();
	    try{
	    Annotation [] an = cz.getClass().getAnnotations();
	    // print all the annotations for the class
	    System.out.println("The annotaion at the class_level");
	    for (Annotation a : an){
	    	
	    	System.out.println(a);
	    }
	    		
	    }catch(Exception e){
	    	System.out.println(e.getMessage());
	    }
	    
	    // getting method_level annotation
	    System.out.println();
	    try{
	    // get the Method obj. from the Class object with throws exception if the method does not exist
	    	Method m = cz.getClass().getMethod("meth_1");
	    	// get the annotation of all interfaces associated with the method.
	    	Annotation [] meth_an = m.getAnnotations();
	    	
	    	System.out.println("the method_level annotations");
	    	
	    	for(Annotation ant : meth_an){System.out.println(ant);}
	    }catch(NoSuchMethodException ns){
	    	System.out.println(ns.toString());
	    }
	}

	public static void main(String...args){
		
		meth_1();
		System.out.println("\nAnnotation is Super Interface of all the annotations, and it overrides the\n"+
		"the toString() of Object class to describe the used annotations");
	}
}
