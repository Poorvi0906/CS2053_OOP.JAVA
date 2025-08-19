package program;

public class Car 
{
String brand;
int year;

//Constructor
Car(String b, int y)
	{ 
	  brand = b;
	  year = y;
	}
void display()
{ System.out.println("Car: "+ brand + " ("+ year + ")");}
public static void main(String[] args) {
	Car c1 = new Car("toyota", 2020);
	Car c2 = new Car("honda", 2022);
	c1.display();
	c2.display();
}
}
