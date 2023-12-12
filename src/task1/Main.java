package task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Dog("Bim", 3, true));
        animalList.add(new Dog("Jeckie", 5, false));
        animalList.add(new Cat("Murzik", 8, false));
        animalList.add(new Cat("Sfinx", 7, true));

        getInfo(animalList);
    }

    public static <T> void getInfo(List<T> list) {
        AtomicInteger count = new AtomicInteger(1);

        list.forEach(item -> {
            System.out.printf("\n\n%s. Класс объекта - %s;\n   Поля объекта: ", count.getAndIncrement(),
                    item.getClass().toString().substring(12));
            try {
                for (Field field : item.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    System.out.printf("%s (значение %s);\n", field.getName(), field.get(item));
                }
                System.out.print("   Методы объекта: ");
                for (Method method : item.getClass().getDeclaredMethods()) {
                    System.out.printf("\"%s\" - возвращает %s; ", method.getName(), method.getReturnType());
                    if (method.getName().equals("makeSound")) {
                        System.out.print("Метод \"makeSound\" этого объекта возвращает - ");
                        method.invoke(item);
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }
}