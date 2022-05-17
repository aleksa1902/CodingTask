package JafarAladdinProblem;

public class Test {
	public static void main(String[] args) {
		Solution p = new Solution();
		String test1[] = {"...X...", ".......", ".X.....", "....X.X", ".X.....", "..X.X..", "...O..."};
		System.out.println(p.solution(test1));
		
		String test2[] = {"X....", ".X...", "..O..", "...X.", "....."};
		System.out.println(p.solution(test2));
		
		String test3[] = {"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."};
		System.out.println(p.solution(test3));
	}
}
