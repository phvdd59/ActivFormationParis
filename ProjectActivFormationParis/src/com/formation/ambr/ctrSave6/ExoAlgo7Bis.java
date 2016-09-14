package com.formation.ambr.ctrSave6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.formation.phva.inter.InterAlgo7;

public class ExoAlgo7Bis implements InterAlgo7 {

	/** Stacks and queues : StoneWall
	 * 
	 * You are going to build a stone wall. 
	 * The wall should be straight and N meters long, 
	 * and its thickness should be constant; however, 
	 * it should have different heights in different places. 
	 * The height of the wall is specified 
	 * by a zero-indexed array H of N positive integers. 
	 * H[I] is the height of the wall from I to I+1 meters 
	 * to the right of its left end. In particular, 
	 * H[0] is the height of the wall's left 
	 * end and H[N−1] is the height of the wall's right end.

	 * The wall should be built of cuboid stone blocks 
	 * (that is, all sides of such blocks are rectangular). 
	 * Your task is to compute the minimum number of 
	 * blocks needed to build the wall.
	 *	
	 * Write a function:
	 *
	 *	class Solution { public int solution(int[] H); }
	 *
	 * that, given a zero-indexed array H of N positive 
	 * integers specifying the height of the wall, 
	 * returns the minimum number of blocks needed to build it.
	 *
	 * For example, given array H containing N = 9 integers:
	 *  H[0] = 8    H[1] = 8    H[2] = 5
	 *  H[3] = 7    H[4] = 9    H[5] = 8
	 *  H[6] = 7    H[7] = 4    H[8] = 8
	 *
	 * the function should return 7. 
	 * The figure shows one possible 
	 * arrangement of seven blocks.
	 * 
	 *                        __
	 *             ____      |  |__ 
	 *            |    |     |  |  |      __
	 *            |    |   __|__|__|__   |  |
	 *            |    |  |           |  |  |
	 *            |    |__|___________|  |  |
	 *            |    |              |  |  |
	 *            |    |              |__|__|
	 *            |    |              |     |
	 *            |    |              |     |
	 *            |    |              |     |
	 *            |    |              |     |
	 *            |____|______________|_____|
	 *
	 *
	 * Assume that:
	 *
	 *  N is an integer within the range [1..100,000];
	 *    each element of array H is an integer within the range [1..1,000,000,000].
	 *    
	 * Complexity:
	 *
	 *        expected worst-case time complexity is O(N);
	 *        expected worst-case space complexity is O(N), 
	 *        beyond input storage (not counting the storage 
	 *        required for input arguments).
	 *
	 * Elements of input arrays can be modified.
	 * 
	 */
	

	public int solution(int[] H) {
		int N = H.length;
		int nbreBlocs = 1;
		if (N>100000 || N<1) {
			return -1;
		}
		// scan le tableau pour trouver la hauteur min -> donne un bloc de longueur H.length et de hauteur la hauteur min
		int min = H[0];
		for (int i = 0; i < H.length; i++) {
			//min = H[0];
			if (H[i]<min) {
				min=H[i];
			}
		}
		nbreBlocs++; //1
		// tableau H2
		int[] H2 = new int[H.length];
		for (int i = 0; i < H2.length; i++) {
			H2[i]=H[i]-min;
		}
		String H2Str = Arrays.toString(H2);
		//H2Str.replaceAll("0+", "0");
		String[] H2StrSplt = H2Str.split("0");
		
		//ArrayList<Integer> H2 = new ArrayList<Integer>();
//		for (int i = 0; i < H2.size(); i++) {
//			H2.add(H[i]-min);
//		}
		//Collections.replaceAll(H2, 0, 0);
		//H2.spl
		// split de H2 en H2A et H2B, car on a un 0 dans H2
//		for (int i = 0; i < H2.size(); i++) {
//			
//		}
		
		
		for (int i = 0; i < H2.length; i++) {
			if (H2[i]==0) {
				nbreBlocs+=2;
				break;				
			}
			//H3[i]=H2[i];
		}
		
		return nbreBlocs;
	}
}

