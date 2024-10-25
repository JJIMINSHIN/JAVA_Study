package java_bsc.final1.ex;

/*
	id: myId, name: kim
	id: myId, name: seo
 * */
public class MemberMain {
	public static void main(String args[]) {
		Member member = new Member("myId", "kim");
		member.print();
		member.changeData("myId2", "seo");
		member.print();
	}
}
