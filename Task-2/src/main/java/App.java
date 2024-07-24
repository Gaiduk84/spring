
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld bean = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());
        HelloWorld bean1 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean1.getMessage());

        System.out.println("============================");
        System.out.println("Наши бины одинаковы ? " + (bean == bean1));
        System.out.println("============================");

        Cat cat1 = applicationContext.getBean(Cat.class);
        System.out.println(cat1.getName());
        Cat cat2 = applicationContext.getBean(Cat.class);
        System.out.println(cat2.getName());

        System.out.println("============================");
        System.out.println("Наши коты одинаковы ? " + (cat1 == cat2));
        System.out.println("============================");

    }
}