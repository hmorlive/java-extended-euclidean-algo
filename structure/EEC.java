package structure;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
* Class EEC - Find the GCD and x and y values using the Extended Euclidean Algorithm 
* @author hazmed
* @version 1.0
*/
public class EEC {	

	private int gcd, valA, valB, x, y, x1, y1;
	private Scanner userInput;
	private boolean flag;
	
	public EEC() {
		gcd = 0; valA = 0; valB = 0; x = 0; y = 1; x1 = 1; y1 = 0;
		userInput = new Scanner(System.in);
		flag = false;
	}
	
	public void run() {
		int a = 0, b = 0;
		System.out.println("Welcome. This program finds the GCD and Extended Euclidean Algorithm\n"
						 + "of two positive integers.\nProgram by Hazmed\n"
						 + "----------------------------------------------------------------------");
		try {
			System.out.println("Please enter first integer: ");
			a = userInput.nextInt();
			System.out.println("Please enter Second integer: ");
			b = userInput.nextInt();
		}
		catch (InputMismatchException ime) {
			run();
		}
		
		if (a < 0 || b < 0) run();		
		
		if (a < b) findEEC(b, a);
		else findEEC(a, b);
		
		System.out.println("________________________________\n"
				 + "Greatest Common Denominator: " + gcd
				 + "\n"
				 + "--------------------------------\n"
				 + "Extended Euclidean Algorithm:\n"
				 + "a(x) + b(y) = GCD\n"
				 + "x = " + x1 + " | y = " + y1 + "\n"
				 + valA + "(" + x1 + ") + " + valB
				 + "(" + y1 + ")" + " = " + gcd
				 + "\n________________________________\n");
		
		System.out.println("Rerun program? (Y/N)");
		char sel = userInput.next().charAt(0);
		if (sel == 'n' || sel == 'N') System.exit(0);
		resetValues();
		run();
	}
	
	//Find the GCD and EEC
	private void findEEC(int a, int b) {
		int q = a / b, r = a % b;
		if (flag == false) saveValues(a, b);
		gcd = b;
		a = b;
		b = r;
		
		findX(x1, q * x);
		findY(y1, q * y);
		
		if (r == 0)	return;
		findEEC(a, b);
	}
	
	//Finds x value
	private void findX(int var1, int var2){
		int temp = x;
		x = x1 - var2;
		x1 = temp;
	}
	
	//Finds y value
	private void findY(int var1, int var2){
		int temp = y;
		y = y1 - var2;
		y1 = temp;
	}
	
	//Saves initial values of a and b
	private void saveValues(int a, int b) {
		valA = a;
		valB = b;
		flag = true;
	}
	
	//Rests all variables to initial state
	private void resetValues() {
		gcd = 0; valA = 0; valB = 0; x = 0; y = 1; x1 = 1; y1 = 0;
		flag = false;
	}
}
