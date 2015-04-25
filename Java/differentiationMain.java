/**
*	@Author Gigaraptor
*	@Description This program generates an equation and gives it to the user to solve, and then checks if it is correct or not
*	This will be part of the proper hello world series repository. I could have used Vectors but I it was a bit late when i realised I could of
**/


import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class differentiationMain 
{
	final static int NUMBER_OF_TERMS = 3;
	final static int MAXIMUM_COEFFICIENT = 10;//this is to compensate for the -5 giving a a range of 5 - -5
	final static int MAXIMUM_EXPONENT = 3;
	final static int COEFFICIENT_OFFSET = -1;//subtracts from rand of MAXIMUM_COEFFICIENT

	/*
	outputTerm
	
	Outputs a term of x based on its coefficient and its exponent
	*/
	
	public static void outputTerm(int Coefficient, int Exponent)
	{
		if(Coefficient == 0)
		{
			return; //if there is no coefficient it cannot have a value
			
		}
		else if(Exponent == 0)
		{
			if(Coefficient > 0)
			{
				System.out.print("+" + Coefficient);
				
			}
			else
			{
			
				System.out.print(Coefficient + " ");//anything ^0 is 1
				
			}
			return;
		}
		else if(Coefficient > 0)
		{
			if(Coefficient != 1)
			{
				System.out.print("+" + Coefficient + "x^" + Exponent + " ");//in cases where the coefficients are positive
			}
			else 
			{
				System.out.print("+" + "x^" + Exponent + " ");//1x looks odd
			
			}
				
			return;
		}
		
		else
		{
			if(Coefficient != -1)
			{
				System.out.print(Coefficient + "x^" + Exponent + " "); //will print out the regular term if negative
			}
			else
			{
				System.out.print("-x^" + Exponent + " ");
		
			}
				
			return;
			
		}
		
		
		
	}
	/*
	differentiateEquation
	
	Differentiates an entire equation and tells the user to differentiate it
	
	*/
	public static void differentiateEquation(int [] diffExponents, int [] diffCoefficients)
	{
		int diffLooper = 0;
		
		for(diffLooper = 0; diffLooper < NUMBER_OF_TERMS;diffLooper++)
		{
			diffCoefficients[diffLooper] = diffCoefficients[diffLooper] * diffExponents[diffLooper];
			diffExponents[diffLooper] = diffExponents[diffLooper] - 1;
			
		}
		
		System.out.println("Differentiate this equation");
	}
	
	/*
	
	takeIntegerInput
	Asks the user to input an integer and converts the string input into an integer
	
	*/
	
	public static int takeIntegerInput(String outputString, BufferedReader inputHandler) throws IOException
	{
		System.out.println(outputString);
		String inputHolder = "";
		int answerHolder = 0;
		inputHolder = inputHandler.readLine();
		answerHolder = Integer.parseInt(inputHolder);
		return answerHolder; 
	}
	
	public static void main(String[] args) throws IOException
	{
		int [] diffExponents = new int [NUMBER_OF_TERMS];
		int [] diffCoefficients  = new int [NUMBER_OF_TERMS];
		int [] ansExponents = new int [NUMBER_OF_TERMS];
		int [] ansCoefficients = new int[NUMBER_OF_TERMS];
		Boolean isCorrect = true;
		BufferedReader inputTaker = new BufferedReader(new InputStreamReader(System.in));
		String outputForInp = "";
		int gpLooper = 0;
		Random rand = new Random();
		
		for(gpLooper = 0; gpLooper < NUMBER_OF_TERMS; gpLooper++)//randomly generates exponents and coefficientss
		{
			diffExponents[gpLooper] = rand.nextInt(MAXIMUM_COEFFICIENT) - COEFFICIENT_OFFSET;
			if(diffExponents[gpLooper] == 0)
			{
				diffExponents[gpLooper] = 1;
				
			}
			diffCoefficients[gpLooper] = rand.nextInt(MAXIMUM_EXPONENT);
			if(diffCoefficients[gpLooper] == 0)
			{
				diffCoefficients[gpLooper] = 1;
				
			}
			outputTerm(diffCoefficients[gpLooper], diffExponents[gpLooper]);
			
		}
		differentiateEquation(diffExponents, diffCoefficients);
		System.out.println("");
		for(gpLooper = 0; gpLooper < NUMBER_OF_TERMS; gpLooper++)
		{
			
			outputForInp = String.format("Please input Coeffcient %d", gpLooper);
			ansCoefficients[gpLooper] = takeIntegerInput(outputForInp, inputTaker);
			outputForInp = String.format("Please input Exponent %d", gpLooper);
			ansExponents[gpLooper] = takeIntegerInput(outputForInp, inputTaker);
			if (ansCoefficients[gpLooper] != diffCoefficients[gpLooper])
			{
				isCorrect = false;
				
				
			}
			if(ansExponents[gpLooper] != diffExponents[gpLooper])
			{
				isCorrect = false;
				
			}
		}
		for(gpLooper = 0; gpLooper < NUMBER_OF_TERMS; gpLooper++)
		{
			outputTerm(diffCoefficients[gpLooper], diffExponents[gpLooper]);
			
		}
		
		if(isCorrect)
		{
			
			System.out.println("Correct");
		}
		else
		{
			System.out.println("Incorrect");
		}

		
		
	}

}
