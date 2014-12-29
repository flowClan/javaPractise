interface IQuackable
{
	public void quack();
}

class Quack implements IQuackable
{
	public void quack(){
		System.out.println("Quacking");
	}
}

interface IFlyable
{
	public void fly();
}

class Fly implements IFlyable
{
	public void fly(){
		System.out.println("Flying");
	}
}

abstract class Duck
{
	IQuackable quackDelegate;
	IFlyable flyDelegate;
	public Duck(){
		System.out.println("Initiated a duck");
	}
	public abstract void display();
	public void performQuack(){
		quackDelegate.quack();
	}
	public void performFly(){
		flyDelegate.fly();
	}
}

class MallardDuck extends Duck
{
	private int length;
	public MallardDuck(){
		quackDelegate = new Quack();
		flyDelegate = new Fly();
	}
	
	public MallardDuck(int length){
		this();
		System.out.println("initiating a duck with length");
		this.length = length;
	}
	
	public void display(){
		System.out.println("Displaying a mallard duck");
	}
}

class WoodDuck extends Duck
{
	public WoodDuck(){
		quackDelegate = new Quack();
		flyDelegate = new Fly();
	}
	public void display(){
		System.out.println("Displaying a wood duck");
	}
}

public class DuckGame
{
	public static void main(String[] args){
		System.out.println("Weclcome to duck kingdom");
		
		MallardDuck md = new MallardDuck(23);
		md.performQuack();
		md.performFly();
	}
}