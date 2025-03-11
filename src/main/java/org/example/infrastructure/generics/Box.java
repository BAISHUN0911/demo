package org.example.infrastructure.generics;

/**
 * @description: 泛型类Box
 * @Author BAISHUN
 * @Date 2024/8/31 11:13
 */
public class Box<T> {
    private T element;

    public void setElement(T element) {
        this.element = element;
    }

    // 返回的类型是泛型
    public T getElement() {
        return element;
    }

    // 泛型方法，使用<T>
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        // 使用泛型类时指定类型，可以保证类型安全
        Box<Integer> intBox = new Box<>();
        intBox.setElement(1234);
        System.out.println(intBox.getElement());

        Box<String> strBox = new Box<>();
        strBox.setElement("hello");
        System.out.println(strBox.getElement());

        Box box = new Box<>();
        box.setElement(123);
        System.out.println(box.getElement());
        box.setElement("str123");
        System.out.println(box.getElement());

        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Hello", "World"};

        // 调用泛型方法
        printArray(intArray);
        printArray(stringArray);
    }


}
