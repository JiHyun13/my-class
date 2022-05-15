// 클래스를 만들 때는 class 클래스 명 {} 로 생성. 이 때 클래스의 범위를 지정하는 중괄호를 Scope 라고 하고, 클래스에서 사용했기 때문에 class scope 라고 한다.
// 몇몇 예외를 제외하고, 대부분의 코드는 클래스 스코프 안에 작성.
// 작성된 클래스를 사용하기 위해서는 생성자라고 불리는 함수가 호출되어야 한다. 코틀린은 Primary 와 Secondary 2개의 함수를 제공.

//Primary 생성자 / 마치 클래스의 헤더처럼 사용할 수 있으며 생성자도 함수이기 때문에 파라미터를 사용할 수 있음.
class Car constructor(name : String){
    //코드
}

//생성자에 접근 제한자나 다른 옵션이 없다면 constructor 키워드 생략 가능
class Car2 (name: String){
    //코드
}

// 클래스의 생성자가 호출되면 자동적으로 실행되는 init 함수. class가 사용되면 바로 실행되고, 필요 없다면 생략해도 무방.
class Car3 constructor(name : String){
    init {
        println("The Car's name is $name")
    }
}

// 클래스 스코프 전체에서 파라미터로 전달된 값을 사용하고 싶다면 파라미터 앞에 변수 키워드를 붙여주면 된다. var 대신 읽기전용인 val 권장.
class Car4 (val name: String){
    fun printName(){
        println(name)
    }
}

// Default 매개변수
class Car44 (val name: String = "자동차"){
    fun printName(){
        println(name)
    }
}

//Secondary 생성자 / 함수처럼 클래스 스코프 안에 직접 작성. 뒤에 중괄호를 붙이면 init 블록과 동일하게 사용 가능. (그렇다고 init 블록 사용 못하는거 아님! 둘 다 쓸경우 init 실행 -> constructor 실행)
class Car5{
    constructor(name: String){
        println("The Car's name is $name")
    }
}

//다중 생성자 / 세컨더리 생성자는 여러개 작성할 수 있다. 다만 파라미터의 개수, 또는 파라미터의 타입이 달라야지만 가능하다.
class Car55{
    constructor(name: String)
    constructor(cost : Int)
    constructor(value1 : Float, value2 : String)
}

//Default 생성자 / 아무것도 안써도 기본적으로 class를 사용할 때 기본 생성자가 동작한다.
class Car6{
}

//다시 ppt 돌아가서 class 생성 방법 쭉 정리한다음 사용으로 들어가기
//지금까지 열심히 만든 class, 어떻게 사용할까?

class FishCake(val flavor : String) {
    var cost : Int = 500 //클래스의 변수 = 멤버 변수 = 프로퍼티(Property)
    fun printThis(){ //클래스의 함수 = 멤버 함수 = 메서드(Method)
        val a = 1 //클래스의 함수 안에 정의된 변수는 프로퍼티라고 하지 않음!! 그냥 변수 또는 지역 변수라고 한다.
        println("This $flavor fishcake costs $cost")
    }
}

data class Person(
    val name : String,
    var age : Int,
    val number : Int
    ){
    var nickname : String = "" // 클래스 내부에 선언할 수도 있다. 하지만 이 곳에 정의된 데이터들은 인스턴스가 생성될 때, 그 객체의 특성에서 제외된다.
}

fun main(){
    var fishCake = FishCake("민초")
    fishCake.cost = 1000 //프로퍼티 사용
    fishCake.printThis() //메서드 사용

    var fishCake2 = FishCake("팥") //붕어빵 1, 2는 다른 값을 가지고 있음. 생성시 새로운 객체 인스턴스가 만들어지고 얘들은 별개의 존재임.
    fishCake2.printThis()

    val HyunJu = Person("현주", 18, 20600)

    //데이터 클래스에 대해 생성된 구성 요소들을 사용하고 싶을 때는 객체를 분해해 각 변수에 넣어준다.
    val (name, age, number) = HyunJu
    println("$name, $age, $number")

    val HyunJuClone = HyunJu.copy() //데이터 클래스의 기본 제공 메서드. 간단히 현주를 복제했다
    HyunJuClone.age = 19
    //val HyunJuClone2 = HyunJu.copy(age = 19) 로 쓸 수도 있다.

    //기본적으로 데이터클래스는 안의 값을 출력해주기 때문에 다른 함수보다 데이터를 다루기 좋다.
    //nickname이 나오지 않는다. 기본적으로 nickname은 특성에서 제외된다.
    println(HyunJu)
    println(HyunJuClone.toString()) //.toString() 또한 기본 제공

    val HyunJu2 = Person("현주", 18, 20600)
    HyunJu.nickname="a"
    HyunJu2.nickname="B"

    //nickname은 다르지만 같다고 인식한다. nickname은 특성에서 제외되기 때문이다.
    println(HyunJu==HyunJu2)
    println(HyunJu.nickname===HyunJu2.nickname)
}



