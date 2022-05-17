package JafarAladdinProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
	public Solution() {}
	
    public int solution(String[] B) {   
        int numChars = B[0].length();
        char[][] mat = new char[numChars][B.length];
        
        int posX = -1;
        int posY = -1;
        
        for(int i = 0; i < B.length; i++) {
        	for(int j = 0; j < numChars; j++) {
        		mat[i][j] = B[i].charAt(j);
        		
        		if(mat[i][j] == 'O') {
        			posX = i;
        			posY = j;
        		}
        	}
        }
        
        /*
        for(int i = 0; i < B.length; i++) {
        	for(int j = 0; j < numChars; j++) {
        		System.out.print(mat[i][j]);
        	}
        	System.out.println();
        }
        */
        
        List<Cvor> levelOrder = new ArrayList<>();
        
        levelOrder.add(new Cvor(posX, posY, 0));
        
        int maxCount = 0;
        
        while(!levelOrder.isEmpty()) {
        	Cvor currPosition = levelOrder.remove(0);
        	
        	// check to see if there is Aladdin's pawn on the left
        	if(currPosition.getX() - 1 > -1 && currPosition.getY() - 1 > -1 && mat[currPosition.getX() - 1][currPosition.getY() - 1] == 'X') {
        		boolean yesJump = false;
        		boolean doubleX = false;
        		boolean yesJumpDouble = false;
        		
				// checking to see if I can jump left 
        		if(currPosition.getX() - 2 > -1 && currPosition.getY() - 2 > -1) {
        			yesJump = true;
        			// checking to see if theres any Aladdin pawn in the field where I want to jump
            		if(mat[currPosition.getX() - 2][currPosition.getY() - 2] == 'X') {
            			doubleX = true;
            			// checking to see if I can jump 2 Aladdin pawns
            			if(currPosition.getX() - 3 > -1 && currPosition.getY() - 3 > -1) {
            				yesJumpDouble = true;
            			}
            		}
        		}
        		
        		if(doubleX == true && yesJumpDouble == true) {
        			Cvor newCvor = new Cvor(currPosition.getX() - 3, currPosition.getY() - 3, currPosition.getJump() + 2);
        			currPosition.setLeft(newCvor);
        			levelOrder.add(newCvor);
        			
        			if(maxCount < newCvor.getJump()) {
        				maxCount = newCvor.getJump();
        			}
        		}else if(yesJump == true && doubleX == false) {
        			Cvor newCvor = new Cvor(currPosition.getX() - 2, currPosition.getY() - 2, currPosition.getJump() + 1);
        			currPosition.setLeft(newCvor);
        			levelOrder.add(newCvor);
        			
        			if(maxCount < newCvor.getJump()) {
        				maxCount = newCvor.getJump();
        			}
        		}
        	}
        	
        	// // check to see if there is Aladdin's pawn on the right
        	if(currPosition.getX() - 1 > -1 && currPosition.getY() + 1 < numChars && mat[currPosition.getX() - 1][currPosition.getY() + 1] == 'X') {
        		boolean yesJump = false;
        		boolean doubleX = false;
        		boolean yesJumpDouble = false;
        		
				// checking to see if I can jump right
        		if(currPosition.getX() - 2 > -1 && currPosition.getY() + 2 < numChars) {
        			yesJump = true;
        			// checking to see if theres any Aladdin pawn in the field where I want to jump
            		if(mat[currPosition.getX() - 2][currPosition.getY() + 2] == 'X') {
            			doubleX = true;
            			// checking to see if I can jump 2 Aladdin pawns
            			if(currPosition.getX() - 3 > -1 && currPosition.getY() + 3 < numChars) {
            				yesJumpDouble = true;
            			}
            		}
        		}
        		
        		if(doubleX == true && yesJumpDouble == true) {
        			Cvor newCvor = new Cvor(currPosition.getX() - 3, currPosition.getY() + 3, currPosition.getJump() + 2);
        			currPosition.setLeft(newCvor);
        			levelOrder.add(newCvor);
        			if(maxCount < newCvor.getJump()) {
        				maxCount = newCvor.getJump();
        			}
        		}else if(yesJump == true && doubleX == false) {
        			Cvor newCvor = new Cvor(currPosition.getX() - 2, currPosition.getY() + 2, currPosition.getJump() + 1);
        			currPosition.setRight(newCvor);
        			levelOrder.add(newCvor);
        			if(maxCount < newCvor.getJump()) {
        				maxCount = newCvor.getJump();
        			}
        		}
        	}
        	
        }
        
        
        
        return maxCount;
        
    
    }
}
