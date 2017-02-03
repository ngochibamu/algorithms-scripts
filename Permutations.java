
import java.util.Set;
import java.util.HashSet;

public class Permutations {
	
	public static void main(String[] args){

		String str = "UVWX";
		//permutation("",str);
		char ch = 'a';
		int chInt = ch - 'a';
		System.out.println("chInt="+chInt);

		//System.out.println(crunchifyPermutation(str));
	}


	public static void permutation(String perm, String input){

		if(input.isEmpty()){
			System.out.println(perm);
		}else {

			for(int i =0; i < input.length(); i++){
				permutation(perm + input.charAt(i), input.substring(0,i) + input.substring(i + 1, input.length()));
			}
		}

	}
}