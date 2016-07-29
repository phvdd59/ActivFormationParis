package autre;

public class Y implements I1 {

	@Override
	public void methodeA() {
		System.out.println("methodeA de Y");
	}

	@Override
	public String methodeB() {
		System.out.println("methodeB de Y");
		return null;
	}

}
