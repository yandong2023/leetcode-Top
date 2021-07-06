/**
 * 题目设计一个类，我们只能生成该类的一个实例。
 * 思路：
 * 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 *
 * 单例模式（Singleton）的目的是为了保证在一个进程中，某个类有且仅有一个实例。
 */

public class No02 {
     public static void main(String[] args) {
         String instance = A.getInstance().say();
         System.out.println(instance);
    }

}

/**
 * 饿汉式  线程安全
 * 饿汉式就是在系统初始化的时候我们已经把对象创建好了，需要用的时候直接拿过来用就好了。
 * 饿汉式天生就是线程安全的，可以直接用于多线程而不会出现问题。
 * 只有private构造方法，确保外部无法实例化；
 * 通过private static变量持有唯一实例，保证全局唯一性；
 * 通过public static方法返回此唯一实例，使外部调用方能获取到实例。
 */
class A {
    //静态字段引用唯一实例
    private static final A instance = new A();

    //private 构造方法保证外部无法实例化
    private A() {
    }

    public static A getInstance() {
        return instance;
    }
    public String  say() {
        return "Hello world";
    }
}

/**懒汉式 线程安全写法
 * 懒汉式就是创建对象时比较懒，先不急着创建对象，在需要加载配置文件的时候再去创建
 * 懒汉式本身是非线程安全的，为了实现线程安全有几种写法
 * 通过加锁来实现线程安全 但是性能不是很好
 */

class B {
    private static volatile B instance = null;

    private B() {
    }

    public static B getInstance() {
        if (instance == null) {
            synchronized (B.class) {
                if (instance == null)
                    instance = new B();
            }
        }
        return instance;
    }
}

// 静态内部类方式 线程安全
class C {
    private C() {

    }

    public static C getInstance() {
        return CHolder.INSTANCE;
    }

    private static class CHolder {
        private static final C INSTANCE = new C();
    }
}

/**
 * 另一种实现Singleton的方式是利用Java的enum，因为Java保证枚举类的每个枚举都是单例，
 * 所以我们只需要编写一个只有一个枚举的类
 */
enum World {
    // 唯一枚举:
    INSTANCE;

    private String name = "world";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

