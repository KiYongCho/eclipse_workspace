package exception.ex;

public class ExceptionTest3 {
	
	public static void main(String[] args) {
		makePerson("홍길동", "산적");
		makePerson("강감찬", "장군");
		makePerson("이순신", "장군");
		makePerson("임꺽정", "산적");
		makePerson("권율", "장군");
	}
	
	private static void makePerson(String name, String job) {
		if (new Person(name, job).getJob().equals("산적")) {
			try {
				throw new JobException();
			} catch (JobException je) {
				System.out.println(name + "님 " + je);
			}
		}
	}

}
