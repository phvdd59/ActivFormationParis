package com.formation.phva.main;

import java.util.ArrayList;
import java.util.LinkedList;

public class CodilityStoneWall {

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
	

	public static void main(String[] args) {
		CodilityStoneWall c = new CodilityStoneWall();
		int[] a = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
		System.out.println(c.solution(a) + " " + c.solution1(a));
		int[] b = { 3, 8, 11, 14, 8 };
		System.out.println(c.solution(b) + " " + c.solution1(b));
		int[] f = { 1, 17, 13, 4, 17, 13 };
		System.out.println(c.toString(f));
		System.out.println(c.solution(f) + " " + c.solution1(f));

		label: for (int i = 0; i < 1000; i++) {
			int[] t = new int[6];
			for (int j = 0; j < t.length; j++) {
				t[j] = (int) (Math.random() * 20);
			}
			int v1 = c.solution(t);
			int v2 = c.solution1(t);
			if (v1 != v2) {
				System.err.println(c.toString(t));
				System.err.println(v1 + " " + v2);
				break label;
			}
		}
	}

	public int solution(int[] H) {
		long nb = 0;
		ArrayList<Integer> l = new ArrayList<Integer>();
		if (H.length == 1) {
			nb = 1;
		} else {
			for (int i = 0; i < H.length; i++) {
				if (l.size() == 0 || H[i] > l.get(l.size() - 1)) {
					l.add(H[i]);
				} else {
					while (l.size() > 0 && H[i] < l.get(l.size() - 1)) {
						l.remove(l.size() - 1);
						nb++;
					}
					if (l.size() == 0 || H[i] > l.get(l.size() - 1)) {
						l.add(H[i]);
					}
				}
			}
			nb += l.size();
		}
		return (int) nb;
	}

	public int solution3(int[] H) {
		int neededBlocks = 1;
		LinkedList<Integer> blocks = new LinkedList<Integer>();
		blocks.add(H[0]);
		int height = H[0];
		for (int i = 1; i < H.length; i++) {
			while (H[i] < height) {
				int last = (int) blocks.removeLast();
				height -= last;
			}
			if (H[i] > height) {
				blocks.add(H[i] - height);
				height = H[i];
				neededBlocks++;
			}
		}
		return neededBlocks;
	}

	public int solution1(int[] H) {
		int res = 1;
		ArrayList<Integer> dejaFait = new ArrayList<Integer>();
		dejaFait.add(H[0]);
		int min = H[0];
		int max = H[0];

		try {
			for (int i = 1; i < H.length; i++) {

				if (!dejaFait.contains(H[i])) {
					if (H[i] < min) {
						res++;
						dejaFait.clear();
						dejaFait.add(H[i]);
						min = H[i];
						max = H[i];

					} else {
						res++;
						max = H[i];
						dejaFait.add(H[i]);
					}
				} else {
					if (H[i] > max) {
						res++;
						dejaFait.add(H[i]);
						max = H[i];
					} else {

						if (H[i] == min) {
							dejaFait.clear();
							dejaFait.add(H[i]);
							min = H[i];
							max = H[i];

						}
					}
				}

			}

		} catch (Exception e) {
			res = 0;
		}

		return res;
	}

	public String toString(int[] a) {
		String s = "[";
		for (int i = 0; i < a.length; i++) {
			s += Integer.valueOf(a[i]).toString();
			if (i < a.length - 1) {
				s += ",";
			}
		}
		s += "]";
		return s;
	}
}

