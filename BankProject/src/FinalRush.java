
public class FinalRush {
	public static void main(String[] args)
	{
		Animal animal = new Animal("Vulture", 12.9f, "Carnivore")
				{
				public void display(){
				super.display();
				System.out.print(" But ");
				displayFun();
				};
	};
	animal.display();
	animal.displayFun();
	}
	
}
class Animal
{
	String name;
	float weight;
	String foodhabit;
	public Animal(String name, float weight, String foodhabit)
	{
		this.name=name;
		this.weight=weight;
		this.foodhabit=foodhabit;
	}
	public void display(){ System.out.println("Bird is He r bivorous"); }
	public void displayFun(){
		System.out.println(name + " is " + foodhabit);
		}
}
