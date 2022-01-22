package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void leapYear (int year) {
        if ( ((year % 100 == 0) && (year % 400 == 0)) || ((year % 100 != 0) && (year % 4 == 0)) ) {
            System.out.println(year + " — високосный год");
        }
        else {
            System.out.println(year + " — не високосный год");
        }
    }

    public static void appVersionPrompt (int clientOS, int clientDeviceYear) {
        String message = "Установите";
        message += (clientDeviceYear >= 2015) ? " " : " облегченную ";
        message += "версию приложения для ";
        message += (clientOS == 1) ? "Android" : "iOS";
        message += " по ссылке.";
        System.out.println(message);
    }

    public static int estimatedDeliveryTimeInDays (int deliveryDistance) {
        int deliveryDays = 1; // Доставка в пределах 20 км занимает сутки.
        if (deliveryDistance >= 20) //Доставка в пределах от 20 км до 60 км добавляет еще один день доставки.
            deliveryDays += 1;
        if (deliveryDistance >= 60) //Доставка в пределах 60 км до 100 км добавляет еще одни сутки.
            deliveryDays += 1;

        if ( (deliveryDistance > 0) && (deliveryDistance <= 100) )
            return deliveryDays;
        else
            return -1;
    }

    public static void textValidator (String textToValidate) {
        int length = textToValidate.length();
/*
//      Версия 1
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if ( textToValidate.charAt(i) == textToValidate.charAt(j) ) {
                    System.out.println("В исходной строке \"" + textToValidate + "\" был найден повторяющийся символ \""
                            + textToValidate.charAt(i) + "\" в позции " + (i+1) + " и в позии " + (j+1)
                            + ".\nНе благодарите!");
                    return;
                }
            }
        }

//      Версия 2*/
        for (int i = 0; i < length; i++) {
            if (textToValidate.charAt(i) == textToValidate.charAt(i+1)) {
                System.out.println("В исходной строке \"" + textToValidate + "\" был найден повторяющийся символ \""
                            + textToValidate.charAt(i++) + "\" в позиции " + (i) + " и в позиции " + (i+1)
                            + ".");
                return;
            }
        }


    }

    public static void mirrorTheArray (int arr[] ) {
        int length = arr.length;
        for (int i = 0; i < (length / 2); i++) {
            int temp = arr[i];
            arr[i] = arr[(length-1)-i];
            arr[(length-1)-i] = temp;
        }
    }



    public static void main(String[] args) {
        //#1
        System.out.println("Задача №1");
        int currentYear = 2100;
        leapYear(currentYear);

        //#2
        System.out.println("\nЗадача №2");
        int clientDeviceYear = 2015;
        byte clientOS = 0; //0 — iOS, 1 — Android
        appVersionPrompt (clientOS, clientDeviceYear);

        //#3
        System.out.println("\nЗадача №3");
        int deliveryDistance = 95;
        System.out.println( "Потребуется дней: " + estimatedDeliveryTimeInDays(deliveryDistance) );

        //#4
        System.out.println("\nЗадача №4");
        String textToValidate = "aabccddefgghiijjkk";
        textValidator(textToValidate);

        //#5
        System.out.println("\nЗадача №5");
        int array[] = {3, 2, 1, 6, 5};
        System.out.println("Исходный массив " + Arrays.toString(array));
        mirrorTheArray(array);
        System.out.println("Отраженный массив " + Arrays.toString(array));
    }
}
