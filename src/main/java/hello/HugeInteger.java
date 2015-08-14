package hello;

import java.util.function.Predicate;


public class HugeInteger implements HugeIntegerInterface{
	int[] digits;
	
	HugeInteger()
	{
		digits = new int[40];
		for(int i=0;i<40;i++)
		{
			digits[i]=0;
		}
	}
	
	
	HugeInteger(int[] indigits)
	{
		digits = new int[40];
		for(int i=0;i<40;i++)
		{
			digits[i]=indigits[i];
		}
	}
	
	public String toString()
	{
		String value="";
		int start=0;
		for(int i=39;i>=0;i--)
		{
			if(start==0 && digits[i]!=0)
			{
				start=1;
			}
			if(start!=0)
			{
				value+=digits[i];
			}
		}
		return reverseString(value);
	}
	
	public String reverseString(String original)
	{
		 int length = original.length();
		 String reverse="";
	      for ( int i = length - 1 ; i >= 0 ; i-- )
	      {
	    	  reverse = reverse + original.charAt(i);
	      }
	      return reverse;
	}
	public int[] parse(String numbers)
	{
		numbers = numbers.trim();
		String values = reverseString(numbers);
		for(int i=0;i<40;i++)
		{
			digits[i]=0;
		}
		for(int i=0;i<values.length();i++)
		{
			System.out.println(values.charAt(i));
			digits[i]=values.charAt(i)-'0';
		}
		return digits;
	}
	public boolean operation(HugeInteger second, String Op)
	{
		HugeInteger firstNumber = new HugeInteger(this.digits);
		HugeInteger secondNumber = second;
		Predicate<HugeInteger> isEqualTo = b -> {
			return firstNumber.isEqualto(b);
		};
		Predicate<HugeInteger> isNotEqualTo = b -> {
			return firstNumber.isNotEqualTo(b);
		};
		Predicate<HugeInteger> isGreaterThan = b -> {
			return firstNumber.isGreaterThan(b);
		};
		Predicate<HugeInteger> isLessThan = b -> {
			return firstNumber.isLessThan(b);
		};
		Predicate<HugeInteger> isGreaterThanOrEqualTo = b -> {
			return firstNumber.isGreaterThanOrEqualTo(b);
		};
		Predicate<HugeInteger> isLessThanOrEqualTo = b -> {
			return firstNumber.isLessThanOrEqualTo(b);
		};
		switch(Op)
		{
		case "isEqualto":
			return isEqualTo.test(secondNumber);
		case "isNotEqualTo":
			return isNotEqualTo.test(secondNumber);
		case "isGreaterThan":
			return isGreaterThan.test(secondNumber);
		case "isLessThan":
			return isLessThan.test(secondNumber);
		case "isGreaterThanOrEqualTo":
			return isGreaterThanOrEqualTo.test(secondNumber);
		case "isLessThanOrEqualTo":
			return isLessThanOrEqualTo.test(secondNumber);
		}
		return true;
	}
	public int[] add(HugeInteger second)
	{
		int[] result = new int[40];
		System.out.println(" "+this.toString()+" + "+second.toString());
		int carry=0;
		for(int i=0;i<40;i++)
		{
			result[i] = 0;
		}
		for(int i=0;i<40;i++)
		{
			int val=this.digits[i]+second.digits[i];
			result[i] = (val%10+carry)%10;
			carry = 0;
			if(val>10 || ((val%10+carry))>10)
			{
				carry=1;
			}
		}
		return result;
	}
	
	public int[] subtract(HugeInteger second)
	{
		int[] result = new int[40];
		int carry=0;
		for(int i=0;i<40;i++)
		{
			int val=this.digits[i] - (second.digits[i]+carry);
			if(val<0)
			{
				val = (this.digits[i]*10) - (second.digits[i]+carry);
				carry = 1;
			}
			result[i] = val;
		}
		return result;
	}
	
	public boolean isEqualto(HugeInteger second)
	{
		for(int i=0;i<40;i++)
		{
			if(this.digits[i]!=second.digits[i])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isNotEqualTo(HugeInteger second)
	{
		for(int i=0;i<40;i++)
		{
			if(this.digits[i]!=second.digits[i])
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isGreaterThan(HugeInteger second)
	{
		for(int i=39;i>=0;i--)
		{
			if(this.digits[i]>second.digits[i])
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isLessThan(HugeInteger second)
	{
		for(int i=39;i>=0;i--)
		{
			if(this.digits[i]>second.digits[i])
			{
				return false;
			}
		}
		
		return true;
	}

	public boolean isGreaterThanOrEqualTo(HugeInteger second)
	{
		for(int i=39;i>=0;i--)
		{
			if(this.digits[i]<second.digits[i])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isLessThanOrEqualTo(HugeInteger second)
	{
		for(int i=39;i>=0;i--)
		{
			if(this.digits[i]>second.digits[i])
			{
				return false;
			}
		}
		
		return true;
	}
	
}
