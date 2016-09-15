package com.formation.issa;

public class ExoAlgo7 implements InterAlgo7 {

	/**
	 * Stacks and queues : StoneWall
	 * 
	 * You are going to build a stone wall. The wall should be straight and N
	 * meters long, and its thickness should be constant; however, it should
	 * have different heights in different places. The height of the wall is
	 * specified by a zero-indexed array H of N positive integers. H[I] is the
	 * height of the wall from I to I+1 meters to the right of its left end. In
	 * particular, H[0] is the height of the wall's left end and H[N−1] is the
	 * height of the wall's right end.
	 * 
	 * The wall should be built of cuboid stone blocks (that is, all sides of
	 * such blocks are rectangular). Your task is to compute the minimum number
	 * of blocks needed to build the wall.
	 * 
	 * Write a function:
	 *
	 * class Solution { public int solution(int[] H); }
	 *
	 * that, given a zero-indexed array H of N positive integers specifying the
	 * height of the wall, returns the minimum number of blocks needed to build
	 * it.
	 *
	 * For example, given array H containing N = 9 integers: H[0] = 8 H[1] = 8
	 * H[2] = 5 H[3] = 7 H[4] = 9 H[5] = 8 H[6] = 7 H[7] = 4 H[8] = 8
	 *
	 * the function should return 7. The figure shows one possible arrangement
	 * of seven blocks.
	 * 
	 * __ ____ | |__ | | | | | __ | | __|__|__|__ | | | | | | | | |
	 * |__|___________| | | | | | | | | | |__|__| | | | | | | | | | | | | | | |
	 * | |____|______________|_____|
	 *
	 *
	 * Assume that:
	 *
	 * N is an integer within the range [1..100,000]; each element of array H is
	 * an integer within the range [1..1,000,000,000].
	 * 
	 * Complexity:
	 *
	 * expected worst-case time complexity is O(N); expected worst-case space
	 * complexity is O(N), beyond input storage (not counting the storage
	 * required for input arguments).
	 *
	 * Elements of input arrays can be modified.
	 * 
	 */

	public int solution(int[] H) {

		int nbBlocks = H.length;

		for (int j = 0; j < H.length - 1; j++) {

			if (H[j] == H[j + 1]) {
				nbBlocks--;
			}
			for (int i = j + 1; i < H.length; i++) {
				if (H[j] == H[i]) {
					for (int k = j; k < i; k++) {
						if (H[k] < H[j]) {
							break;
						} else if (H[k] > H[j]) {
							nbBlocks--;
							break;

						}

					}
				}

			}

		}
		return nbBlocks;
	}
}
