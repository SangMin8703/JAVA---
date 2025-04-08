package collection;
import java.util.*;

class Student {
	String name;
	int age;
	String tel;
	public Student(String name, int age, String tel) {
		this.name = name; this.age = age; this.tel = tel;
	}	
	public int hashCode() {	
		System.out.printf("%s 학생의 hashCode 실행\n", this.name);
		int code = this.name.length() + this.age;
		return code;
	}	
	public boolean equals(Object obj) {
		if( !(obj instanceof Student) )
			return false;
		
		System.out.printf("%s 학생의 equals 실행\n", this.name);
		
		Student source = (Student)obj;
		boolean flag;
		flag = this.name.equals(source.name);
		flag = flag && this.age == source.age;
		flag = flag && this.tel.equals(source.tel);
		
		return flag;
	}	
}

public class Collection_09 {
	public static void main(String[] args) {
		HashSet<Student> set = new HashSet<Student>();
		
		Student s1 = new Student("Name01", 11, "Tel01");
		Student s2 = new Student("Name02", 22, "Tel02");
		Student s3 = new Student("Name03", 22, "Tel03");
		
		set.add(s1);	set.add(s2);	set.add(s3);
		
		System.out.printf("set.size = %d\n", set.size());
			
		s1 = new Student("Name01", 11, "Tel01");
		s2 = new Student("Name02", 22, "Tel02");
		s3 = new Student("Name03", 22, "Tel03");
		
		set.add(s1);	set.add(s2);	set.add(s3);	
		// 아래의 결과가 3이 나오도록 Student 클래스의 내용을 수정하세요.
		System.out.printf("set.size = %d\n", set.size());
	}
}










