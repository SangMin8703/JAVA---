package package_01;

// public 키워드가 사용되지 않은 일반 클래스들은
// 동일한 패키지 내부에서만 사용될 수 있는 클래스입니다.
// 다른 패키지에서 import 하여 사용할 수 없는 클래스
class Package_06_Model_B{}
class Package_06_Model_C{}

// public class 는 동일한 패키지에서 사용할 수 있고,
// 다른 패키지에서 import 하여 사용할 수 있는 클래스
public class Package_06_Model_A {}
