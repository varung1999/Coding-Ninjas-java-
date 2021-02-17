
public class Solution {
	public static boolean checkSequence(String a, String b) {
	if(a.length()<b.length())
		{
			return false;
		}
		int count = 0;
		for(int i =0;i<a.length();i++)
		{
			if(count<b.length() && a.charAt(i)==b.charAt(count))
			{
				count++;
			}
		}
		if(count==b.length())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
