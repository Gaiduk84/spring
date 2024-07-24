package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
//import jakarta.persistence.NoResultException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Vanya", "Java", "vanya@pochta.com");
      User user2 = new User("Oleg", "Pyton", "oleg@pochta.com");
      User user3 = new User("Marina", "C++", "marina@pochta.com");
      User user4 = new User("Nastya", "Javascript", "nastya@pochta.com");

      Car car1 = new Car("Corolla", 1992);
      Car car2 = new Car("Fancargo", 2000);
      Car car3 = new Car("Lada", 2023);
      Car car4 = new Car("Nissan", 2090);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      // 1. Пользователи с машинами
      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
         System.out.println("1. _____________________________________________");
      }

      // 2. Выбрать пользователя, владеющего машиной (по ее модели и серии)
      System.out.println(userService.getUserByCar("Fancargo", 2000));
      System.out.println("2. _____________________________________________");

      // Нет пользователя с такой машиной
      try {
         User notFoundUser = userService.getUserByCar("Renout", 2023);
      } catch (NoResultException e) {
         System.out.println("User not found");
         System.out.println("3. _____________________________________________");
      }

      context.close();
   }
}
