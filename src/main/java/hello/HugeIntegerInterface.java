package hello;

public interface HugeIntegerInterface {

	public String toString();
	public int[] parse(String numbers);
	public int[] add(HugeInteger second);
	public int[] subtract(HugeInteger second);
	public boolean isEqualto(HugeInteger second);
	public boolean isNotEqualTo(HugeInteger second);
	public boolean isGreaterThan(HugeInteger second);
	public boolean isLessThan(HugeInteger second);
	public boolean isGreaterThanOrEqualTo(HugeInteger second);
	public boolean isLessThanOrEqualTo(HugeInteger second);
}
