package com.company;

/*
Музыкальный магазин.

1.	Создать программу с классами Гитара, Фортепиано, Труба, используя класс Музыкальный инструмент. Открыть Музыкальный
магазин.
2.	Добавить в магазин инструментов метод, который готовит к отгрузке партию музыкальных инструментов согласно заказу.

Сигнатура метода:
public List<Instrument> prepareInstruments(Map<String, Integer> order){...}

В заказе (Map<String, Integer> order) хранится название инструмента и количество необходимых инструментов.

Ключем в заказе является одна из строк "piano", "guitar", "trumpet"
Создать свое исключение, которое будет брошено в случае, когда ключ в заказе другой.
Каким-то образом (самостоятельно выбрать решение) обработать ситуацию, когда количество элементов в заказе отрицательное
, нулевое.

После выполнения метода из магазина должны пропасть те инструменты, которые были отгружены.
В случае, когда количество запрашиваемых инструментов определенного типа больше, чем количество доступных инструментов в
 магазине, должно быть брошено исключение. Выбрать наиболее подходящее из доступных в стандартной библиотеке исключений
Пример:
1.	в магазине было 2 фортепиано, 16 гитар и 7 труб.
2.	пришел заказ на 7 гитар и 2 трубы.
3.	после выполнения заказа в магазине осталось 2 фортепиано, 9 гитар и 5 труб
4.	пришел заказ на 1 фортепиано
5.	после выполнения заказа в магазине осталось 1 фортепиано, 9 гитар и 5 труб
6.	пришел заказ на 1 фортепиано, 8 гитар и 6 труб
7.	товар не был отгружен (было брошено исключение)
в магазине осталось 1 фортепиано, 9 гитар и 5 труб

if(c != 0){
a = b / c
}else{
a = b;
}
 */
public class Main {

    public static void main(String[] args) {
        MusicShop musicShop = new MusicShop();
        musicShop.openMusicShop();
    }
}