package week08;

import java.util.ArrayList;
import java.util.List;

public class PermutationString
{

	public static List<String> getPerumutaionts(String word)
	{

		return permutate(new ArrayList<String>(), "", word, 0);
	}

	private static List<String> permutate(ArrayList<String> list, String perm,
			String word, int level)
	{
		trace(getPad(level) + "Level in: " + level);
		trace(getPad(level) + "Input word: " + word);
		trace(getPad(level) + "Input perm: " + perm);

		if(word.isEmpty())
		{
			trace(getPad(level) + "adding: " + perm);
			list.add(perm + word);
		}
		for(int i = 0; i < word.length(); i++)
		{
			permutate(list, perm + word.charAt(i),
					word.substring(0, i) + word.substring(i + 1, word.length()),
					level + 1);
		}

		trace(getPad(level) + "Level out: " + level);
		return list;
	}

	private static void trace(String msg)
	{
		System.out.println(msg);
	}

	private static String getPad(int level)
	{
		return Integer.toString(level);
	}
}
