package se.liu.ida.carek123.tddd78.lab1;

public class Exercise10
{
    public static void main(String[] args) {
	int tal = 16777216;
	double decimaltal = tal;
	int tillbaka = (int)decimaltal;
	System.out.println(tal+" "+decimaltal+" "+tillbaka);

	int big = 2147483647;
	long bigger = (long)big+1;
	System.out.println(big+" "+bigger);
    }
}
