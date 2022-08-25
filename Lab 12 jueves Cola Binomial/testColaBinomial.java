package lab12jueves;

// Rene Yañez Navarrete && Cristiam Pinilla Vasquez

class testColaBinomial{
	public static void main(String[] args)
	{
		int a[] = {12,22,21,29,32, 40, 45, 55, 77, 2, 4, 45, 34, 8, 2, 9,1000};
		ColaBinomial b = new ColaBinomial();
		for (int i=0; i < a.length;  i++) b.Insert(a[i]);
		
                
                System.out.println(b.max());
                
                
	} 
}
