package com.xujun.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujun
 * @date 2018.08.17 15:37
 */
public class GreedyAlgorithm {

	/**
	 * 这是《算法导论》上的例子，也是一个非常经典的问题。有n个需要在同一天使用同一个教室的活动a1,a2,…,an，
	 * 教室同一时刻只能由一个活动使用。每个活动ai都有一个开始时间si和结束时间fi 。一旦被选择后，活动ai就占据半开时间区间[si,fi)。
	 * 如果[si,fi]和[sj,fj]互不重叠，ai和aj两个活动就可以被安排在这一天。该问题就是要安排这些活动使得尽量多的活动能不冲突的举行。
	 */

	public static void main(String[] args) {
		List<Active> initActives = new ArrayList<>();
		initActives.add(new Active(3, 5));
		initActives.add(new Active(5, 7));
		initActives.add(new Active(6, 10));
		initActives.add(new Active(8, 11));
		initActives.add(new Active(12, 14));
		initActives.add(new Active(1, 4));
		initActives.add(new Active(0, 6));
		initActives.add(new Active(3, 8));
		initActives.add(new Active(5, 9));
		initActives.add(new Active(8, 12));
		initActives.add(new Active(2, 13));
		List<Active> bestActives = getBestActives(initActives, 0, 16);
		for (int i = 0; i < bestActives.size(); i++) {
			System.out.println(bestActives.get(i));
		}
	}

	/**
	 * 获取最优
	 * @param actives
	 * @return
	 */
	private static List<Active> getBestActives(List<Active> actives, int startTime, int endTime) {
		// 先排序
		actives.sort(null);
		int tempTime = startTime;
		List<Active> tempActives = new ArrayList<>();
		for (int i = 0; i < actives.size(); i++) {
			Active temp = actives.get(i);
			if (temp.startTime >= tempTime && temp.endTime <= endTime) {
				tempActives.add(temp);
				tempTime = temp.endTime;
			}
		}
		return tempActives;
	}

	private static class Active implements Comparable<Active> {

		private int startTime;
		private int endTime;

		public Active(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public String toString() {
			return "Active [startTime=" + startTime + ", endTime=" + endTime + "]";
		}

		/**
		 * 按照结束时间升序排序
		 */
		@Override
		public int compareTo(Active o) {
			if (this.endTime > o.endTime) {
				return 1;
			} else if (this.endTime == o.endTime) {
				return 0;
			}
			return -1;
		}

	}
}
