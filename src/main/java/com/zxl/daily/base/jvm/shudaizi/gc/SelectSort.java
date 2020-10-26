package com.zxl.daily.base.jvm.shudaizi.gc;

/**
 * 选择排序
 * @author fengunion
 * 
 * 1、由简单到复杂
 * 		1）验证一步走一步
 * 		2）多打印中间结果
 * 
 * 2、先局部后整体
 * 		1）没有思路时先细分
 * 
 * 3、先粗糙后精细
 * 		1）变量更名
 * 		2）语句合并
 * 		3）边界处理
 * 
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr = {5, 4, 6, 3, 7, 8, 1, 9, 2};
		
		int minPos = 0;
		for(int i = 0; i < arr.length-1; i++) {
			
			for(int j = i + 1; j < arr.length; j++) {
				minPos = arr[j] < arr[minPos] ? j : minPos;
			}
			swap(arr, i, minPos);
		}
		
		print(arr);
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void print(int[] arr) {
		for(int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
	}
}
