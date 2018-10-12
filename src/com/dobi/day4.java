//package com.dobi;
//
//import com.dobi.bean.Pair;
//import com.dobi.bean.Person;
//
//import java.lang.reflect.Constructor;
//import java.util.ArrayList;
//
///**
// * 反射注解泛型
// *
// * https://blog.csdn.net/sinat_38259539/article/details/71799078
// */
//public class day4 {
//
//    /**
//     * java除基本类型外，其他的都是class（包含Interface）
//     * 包括：String  Object  Runnable  Interface  Exception等
//     *
//     * class/interface的数据类型是Class
//     * 每加载一个class，JVM就为其创建一个Class类型实例，并关联起来
//     * 例如加载String类，读取String.class文件，为String类创建一个Class实例
//     * Class cls = new Class(String);
//     *
//     * JVM为每个class创建对应的Class实例，并在实例中保存该class的所有信息
//     * 通过Class实例获取class信息的方法称为反射
//     *
//     */
//
//    //三种获取Class实例的方法
//    //1.
//    Class cls = String.class;
//    //2.
//    String s = "Hello";
//    Class cls2 = s.getClass();
//    //3.
//    Class cls3 = Class.forName("java.lang.String");
//
//
//    //反射的目的
//    //当获得某个Object实例的时候，我们可以获取该Object的class信息
//    //简单说就是获取某个类的信息
//
//    //从Class实例获取信息
//    //1.getName
//    String name = cls.getName(); //"java.lang.String"
//    //2.getSimpleName
//    String simpleName = cls.getSimpleName(); //"String"
//    //3.getPackage
//    String pkg = cls.getPackage().getName(); //"java.lang"
//
//    //从Class实例判断class类型
//    //isInterface  接口类型
//    //isEnum   枚举类型
//    //isArray  数组类型
//    //isPrimitive 基本类型
//
//    //创建class实例
//    String c = (String) cls.newInstance();
//
//
//
//
//    //调用构造方法
//    //Class.newInstance只能调用public无参构造方法
//    //要调用带参数的构造方法可以用Constructor
//
//    Class cls123 = Integer.class;
//    //获取带参构造方法
//    Constructor constructor = cls123.getConstructor(int.class);
//    //通过Constructor创建实例
//    Integer ni = constructor.newInstance(123);
//
//    //通过Class实例获取Constructor信息
//    //getConstructor();---获取public的Construct
//    //getDeclaredConstructors()----获取所有Constructor ,包括私有的
//    //contuctor.setAccessible(true)  通过设置setAccessible(true)来访问非public构造方法
//    //getConstructor(xx.class);---获取单个public的Construct
//    //getDeclaredConstructors(xx.class)----获取单个Constructor ,包括私有的
//    //通过构造方法创建实例对象
//    //constructor.newInstance();
//
//   //获取父类的Class----getSuperClass
//    //获取当前类直接实现的interface-----getInterface
//
//    //通过Class实例cls获取字段(成员变量)信息并调用
//    //Field[] xx = cls.getFields()----获取所有public字段
//    //cls.getDeclaredFields()----获取所有字段,包含private
//    //cls.getFeild(xx) //获取单个public字段
//    //cls.getDeclaredFeild(xx)  //获取单个字段，可以是private
//    //field.setAccessible(true)  //暴力解除private
//    //field.set(对象名，)
//
//    //通过Class实例cls获取成员方法并调用
//    //Method[] xx = cls.getMethods()  ---获取所有public方法
//    //cls.getDeclaredMethods()  ---获取所有方法,包括private
//    //cls.getMethods("方法名",xx.class)  ---获取某个public方法
//    //cls.getDeclaredMethods("方法名",xx.class)  ---获取某个方法，包括私有
//    //mothod.invoke(对象名，方法实参)----调用方法
//    //mothod.setAccessible(true)  //暴力解除private
//
//
//
//    ////////////////////////////////////////华丽的分割线//////////////////////////////////////////////////
//    //////////////////////////////////////////注解/////////////////////////////////////////////////////
//    //注解只是起标注作用
//    //编译器可以使用的注解
//    //@Override---让编译器检查该方法是否正确的实现了复写
//    //@Deprecated-----告诉编译器该方法已经被标记作废
//    //@SuppressWarning----出现警告会忽略警告
//
//    //注解参数
//    //@Test(参数=xx)
//    //配置参数包括
//    //所有基本类型  String 枚举类型  数组类型（只能是前三种类型的数组）
//    //配置参数必须是常量
//    //如果参数名称是value，可以省略参数名称
//
//    //定义注解
//    //使用@interface定义注解(Annotation)
//    //注解的参数类似于无参方法
//    //可以设定一个默认值(推荐)
//    //把最常用的参数命名为value(推荐)
//
//    //元注解
//    //使用@Target定义Annotation可以被应用于源码的哪个位置
//    //类或者接口----ElementType.TYPE
//    //字段-----ElementType。FIELD
//    //方法-----ElementType.METHOD
//    //构造方法----ElementType.CONSTRUCTOR
//    //方法参数-----ElementType.PARAMETER
//
//    //使用@Retention定义Annotion的生命周期
//    //1.仅编译期：RetentionPolicy.SOURCE
//    //2.仅仅class文件  RetentionPolicy.CLASS ----默认
//    //3.运行期  RetentionPolicy.RUNTIME  ----通常自定义是这个
//
//    //注解Annotation也是class,如何读取注解，使用反射
//    //使用反射API读取Annotation
//    //Class.isAnnotationPresent(xx.class)  //判断@xx注解是否存在
//    //Field.isAnnotationPresent(xx.class)  //判断@xx注解是否存在
//    //Method.isAnnotationPresent(xx.class)  //判断@xx注解是否存在
//     //Constructor.isAnnotationPresent(xx.class)  //判断@xx注解是否存在
//
//    //例如
//    Class cla = Person.class;
//    Report report = (Report) cla.getAnnotation(Report.class);
//
//
//
//
//
//    ///////////////////////////////////////////////////华丽的分割线////////////////////////////////////////////////////////
//    //////////////////////////////////////////////////泛型Generic///////////////////////////////////////////////////
//
//    //泛型就是定义一种模板,编写模板来适应任意类型，例如ArrayList<T>
//    //泛型的好处
//    //1.不必对类型进行强制转换，编译器会自己检查
//    //2.编译器对类型进行检查
//    ArrayList<String> stringArrayList = new ArrayList<String>();
//
//    //泛型默认是采用的擦拭法
//    //擦拭法是，编译器将T全部看成Object类型，在相应的时候强制转换成对应的类型
//
//    //通配符
//    //extends
//    //Pair<? extends Number> 表示接收Number或者Number子类Interger,Double等 ，可以调用set方法，不能调用get方法（除了Object），
//    //super
//    //Pair<? super Interger> 表示接收Interger或者Interger的超类
//
//    //<? extends T>允许调用方法的获取T的引用 如List的get(i)
//    //<？super T> 允许调用方法传入T的引用   如List的add(i)
//    //<？> 无限定通配符 可以使用<T>来替换他
//
//
//
//    //部分反射API是泛型
//    //Class<T> 是泛型
//
//    Class ca = String.class;
//    String string = (String) ca.newInstance();
//
//    Class<String> clazz = String.class;
//    String str = clazz.newInstance();
//}
