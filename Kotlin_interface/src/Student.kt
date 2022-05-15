import java.util.*

data class Player(
    val name: String,
    var score : Int
)

open class Car{
    var speed : Int = 0
    val color : String = "black"
    val num : Int = 1000
    fun run() {
        speed = 100
    }
    fun stop(){
        speed =0
    }
}

// 콜론을 사용해 상속할 부모 클래스를 지정한다.
// 상속은 부모의 인스턴스를 자식이 갖는 과정이기 때문에
// 부모 클래스명 다음에 괄호를 입력해서 꼭 부모의 생성자를 호출해아 한다.
// 안쓰면 생성자 호출로 변경 이라는 오류메세지 뜸
class Truck : Car() {
    var load : Float = 0.0F //Float 나타내는 F
    fun loadUp(load2 : Float){
        println("짐을 싣습니다")
        load = load2
    }
    fun loadDown(){
        println("짐을 내립니다")
        load = 0.0F
    }
}

//생성자가 있는 클래스 상속

open class Bread(val cost : Int, var name : String){
    var weight = 100
    open fun eat(){
        if(weight==0)
            println("Error")
        else
            weight-=10

    }
}

class CupCake(cost: Int, name: String) : Bread(cost, name){
    var topping = "choco"
}


//생성자를 함께 써줘야 한다
class Cake(cost: Int, name: String) :Bread(cost, name){
    var topping = "strawberry"
    fun hungry() {
        super.eat() //super 키워드 : 상위 클래스의 프로퍼티, 메서드, 생성자에 접근할 때 사용한다.
        println("배고프다")
    }
}

//super
//현재 클래스를 참조할 때에는 this, 상위 클래스를 참조할 때에는 super를 쓴다.
open class A{
    open fun f() = println("A")
}

interface B{
    fun f() = println("B")
}

class C : A(), B{
    override fun f(){ //overrode(오버로드), 재정의가 아닌 이름이 같지만 새로운 기능을 가진 함수
        super<A>.f()
        super<B>.f()
        this.f()
    }
}

//추상화 클래스
//open 키워드를 사용하지 않아도 된다!
//인터페이스와 가장 다른 점은 프로퍼티가 초기값을 가질 수 있다.

abstract class Animal(){
    //추상화 한 변수, 함수 등은 구현을 해놓지 말 것!
    abstract var color : String
    var type = "animal"

    abstract fun walking()
    fun printInfo() {
        println("$type is $color color")
    }
}

class Dog() : Animal(){
    override var color: String = "white"
    override fun walking() {
       println("aaa")
    }
}

//interface
//프로퍼티는 값을 할당할 수 없고 메서드만 구현해놓을 수 있다
interface Pen {
    var color : String
    val cost : Int

    fun draw() { println("drawing~") }
    fun write()
}
class Highlighter : Pen {
    override var color: String = "red"
    override val cost: Int = 100

    override fun write() {
        println("sweetgay")
    }
}

//접근 제어자(제한자)
//open -> 상속을 할 수 있는 클래스다 or 오버라이딩, 오버로드를 사용할 수 있다 등을 나타냄
//public -> "접근을 할 수 있는"
open class Car2{
    public var nickname = "abc"
    var age = 1
    private var color = "black"
    internal var speed = 0
    fun speedUp() { speed+=10 }
}

class MiniCar : Car2(){
    init {
        nickname = "def"
        age = 2
        //color = "white"
        speed = 10
        speedUp()
    }
}

/*
1. 애플파이 인터페이스를 만들자! ( 속성, 기능을 최소 2개씩 작성 )
2. object 키워드를 사용해서 main 함수에서 오버라이딩
3. 현주 class를 만들어서 상속받고 구현하기
4. 이 모든걸 캡처해서 올리면 끝~!
 */


fun main() {
    val truck = Truck()

    //모두 접근 가능
    println(truck.num)

    val mongMong = Dog()
    mongMong.type = "dog"
    mongMong.printInfo()

    //object 키워드를 사용해서 interface의 경우 소스코드에서 직접 구현할 수 있다.
    val myPen = object : Pen {
        override var color: String = "red"
        override val cost: Int = 1500

        override fun write() {
            println("this is my pen")
        }
    }

    val a = object : Pen{
        override var color: String = "black"
        override val cost: Int = 1500
        override fun write() {
            println("김욱일")
        }
    }

    val player = Player("재혁", 0)
    val player2 = player.copy()

    println(player.equals(player2))
    //data class는 기본적으로 데이터를 제공하는 class기 때문에 그냥 객체를 찍어도 String으로 나온다
}




