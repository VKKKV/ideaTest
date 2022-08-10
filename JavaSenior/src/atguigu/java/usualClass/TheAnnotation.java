package atguigu.java.usualClass;

/**
 * Created on 2022/3/24星期四22:02
 *
 * @author abc
 * Jdk5新增
 *
 * Annotation是代码里的特殊标记，可以在不改变原有逻辑的情况
 * 下，在源文件中嵌入一些补充信息。
 * 代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证
 * 或者进行部署
 * Annocation的使用示例：
 * 示例一：生成文档相关的注解
 * 实例二：在编译时进行格式检查（JDK内置的三个基本注解）
 * @Override：限定重写父类方法，该注解只能用于方法
 * @Deprecated：用于表示所修饰的元素（类，方法等）已过时。通常是因为
 * 所修饰的结构危险或存在更新
 * @SuppressWarnings:抑制编译器警告
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 自定义注解：参照@SuppressWarnings
 * 1.注解声明为：@interface
 * 2.内部定义成员，通常使用value表示
 * 3.可以指定成员的默认值，使用default定义
 * 4.如果自定义的注解没有成员，表明是一个标识作用。
 * 如果注解有成员，再使用注解时，需要指明成员的值
 *
 * 元注解：对现有的注解解释说明
 * jdk5提供四个元注解：Retention/Target/Documented/Inherited
 *
 */
public class TheAnnotation {

}
