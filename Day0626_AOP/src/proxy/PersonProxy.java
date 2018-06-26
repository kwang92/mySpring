package proxy;

public class PersonProxy {
	Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
	}
	public void callPerson() {
		System.out.println("지하철을 탄다");
		person.doSomething();
		System.out.println("계산하고 집에 온다.");
		System.out.println("씻고 잠을 잔다.");
	}
}
