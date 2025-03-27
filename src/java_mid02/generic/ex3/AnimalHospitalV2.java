package java_mid02.generic.ex3;

/*
 * 제네릭으로 변경
 * 장점 : 모든 객체의 최종 부모인 Object 타입으로 가정되어 어떤 타입이든 들어올 수 있음
 * 단점 : 
 * 1.Animal에서 제공하는 기능을 사용할 수 없음
 * Integer, Object와 같은 동물과 전혀 관계 없는 타입이 들어올 수 있음
 * */
public class AnimalHospitalV2<T> {

	private T animal;

	public void set(T animal) {
		this.animal = animal;
	}

	public void checkup() {
		// T의 타입을 메서드 정의하는 시점에는 알 수 없음, Object 기능만 사용 가능
		animal.toString();
		animal.equals(null);
	}

	public T bigger(T target) {
		// 컴파일 오류
		//return animal.getSize() > target.getSize() ? animal : target;
		return null;
	}

}
