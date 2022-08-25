package lab.pkg2.sorting;

import java.util.Arrays;
import java.util.Random;

/*	Conclusión lab 2
	Pese a ser sencillo de implementar el Bubble Sort es el menos eficiente de los tres. 
	El Mergue Sort es bastante eficiente. El Java Sort es el mas eficiente y rápido.
*/

public class Sorting {

	public static int[] fillArray(int n) {
		int[] array = new int[n];
		Random rnd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(n * 10);
		}
		return array;
	}

	public static void bubbleSort(int array[]) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void merge(int array[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = array[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	public static void sort(int array[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			sort(array, l, m);
			sort(array, m + 1, r);

			// Merge the sorted halves
			merge(array, l, m, r);
		}
	}
	
	public static void mergeSort(int array[]) {
		sort(array, 0, array.length - 1);
	}
	
	public static void print(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	

	public static void main(String[] args) {
		
		
		long data[][] = new long[9][3];
		int i=0; // contador de iteraciones
                int n=0; // numero asignado para cada caso(con el switch)
                switch (i+1){
                    case 1:n=1000;break;
                    case 2:n=5000;break;
                    case 3:n=10000;break;
                    case 4:n=50000;break;
                    case 5:n=100000;break;
                    case 6:n=1000000;break;
                    case 7:n=5000000;break;
                    case 8:n=10000000;break;
                    case 9:n=50000000;break;
                    
                }
                
                for (; i < 5; i++) {
                    
                    int arr1[] = fillArray(n);
                    int arr2[] = fillArray(n);

                    int arr1_1[] = arr1.clone();
                    int arr2_1[] = arr2.clone();
                    int arr1_2[] = arr1.clone();
                    int arr2_2[] = arr2.clone();

                    long startTime = System.nanoTime();
                    bubbleSort(arr1);
                    long finishTime = System.nanoTime() - startTime;
                    data[i][0] = finishTime;

                    startTime = System.nanoTime();
                    bubbleSort(arr2);
                    finishTime = System.nanoTime() - startTime;
                    data[i][0] = (data[0][0]+finishTime) / 2;

                    startTime = System.nanoTime();
                    mergeSort(arr1_1);
                    finishTime = System.nanoTime() - startTime;
                    data[i][1] = finishTime;

                    startTime = System.nanoTime();
                    mergeSort(arr2_1);
                    finishTime = System.nanoTime() - startTime;
                    data[i][1] = (data[0][1]+finishTime) / 2;

                    startTime = System.nanoTime();
                    Arrays.sort(arr1_2);
                    finishTime = System.nanoTime() - startTime;
                    data[i][2] = finishTime;

                    startTime = System.nanoTime();
                    Arrays.sort(arr2_2);
                    finishTime = System.nanoTime() - startTime;
                    data[i][2] = (data[0][2]+finishTime) / 2;
                }
                
                for (; i < 9; i++) {
                    
                    int arr1[] = fillArray(n);
                    int arr2[] = fillArray(n);

                    int arr1_1[] = arr1.clone();
                    int arr2_1[] = arr2.clone();
                    int arr1_2[] = arr1.clone();
                    int arr2_2[] = arr2.clone();

                    long startTime = System.nanoTime();
                    mergeSort(arr1_1);
                    long finishTime = System.nanoTime() - startTime;
                    data[i][1] = finishTime;

                    startTime = System.nanoTime();
                    mergeSort(arr2_1);
                    finishTime = System.nanoTime() - startTime;
                    data[i][1] = (data[0][1]+finishTime) / 2;

                    startTime = System.nanoTime();
                    Arrays.sort(arr1_2);
                    finishTime = System.nanoTime() - startTime;
                    data[i][2] = finishTime;

                    startTime = System.nanoTime();
                    Arrays.sort(arr2_2);
                    finishTime = System.nanoTime() - startTime;
                    data[i][2] = (data[0][2]+finishTime) / 2;
                }
                
                        // impresion de los resultados
		        for (int j = 0; j < 9; j++) {
                            for (int k = 0; k < 3; k++) {
                                System.out.print((data[j][k])/1000+"\t");
                            }
                            System.out.println(" ");
                        }
		
		//  Se concluye que el bubble sort es el menos eficiente para cada caso
                //  Se concluye que el merge sort es bastante eficiente
                //  Se concluye que el java sort es el mas eficiente
	}

}
