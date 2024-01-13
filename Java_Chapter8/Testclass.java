package Test;

import java.util.Arrays;

public class Testclass {

	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3, 4, 5,6,7,8 };
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			if(i%2==0) {
				sum += arr[i];
			}

		}
		System.out.println(sum);
		
		
		//int arr1[][]= new int[3][3];
		int arr1[][] = {{2,3,4},{5,6,7},{8,9,3}};
		int row = 3;
		int total =0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<row;j++) {
				if(i==j) {
					total+= arr1[i][j];
					
				}
			
			}
		
			
		}	System.out.println(total);

		
		
	
	}

}
