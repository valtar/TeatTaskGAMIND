package com.gamind;

import java.util.LinkedList;
import java.util.List;

public class AlgoTask {
    public static Integer ip = (192<<24) + (1<<16) + (2<<8) + 168;;

    // 1
    // Сложность по времени порядка 2N
    // Дополнительной памяти тербуется порядка N
    public static void reverseListPrint(List list){
        Object[] toPrints = list.toArray();
        for (int i = toPrints.length - 1; i >= 0 ; i--) {
            System.out.println(toPrints[i] + ";");
        }
    }

    // 2
    public static String intToIP(int ip){
        int mask = 0b11111111;
        return (ip >>> 24) + "." + ((ip >>> 16) & mask)+ "." + ((ip >>> 8) & mask)+ "." + (ip  & mask);
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        reverseListPrint(list);

        System.out.println(intToIP(ip));
    }

    // 3а. Если требуется точно число уникальных посителей то заводим переменную, число уникальный поситителей, и
    // структуру данных(список, дерево, или порсто БД в зависимтости от проекта). При получение очередного ip-адреса
    // Пытаемся добавть его в базу, если такого еще нет, увеличиваем счетчик.

    // 3b. Собираем статистику сколько % поситителей в потоке уникальных, после чего при добавлении нового ip увеличиваем
    // счетчик с соответсвующей вероятностью.
}
