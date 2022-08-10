package com.pta.problem;

import java.util.Scanner;

/**
 * Created on 2022/3/17星期四22:44
 *
 * @author abc
 */
public class 冰岛人 {
    static String[] people;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        people = new String[Integer.parseInt(scanner.nextLine())];
        //输入当地人口
        for (int i = 0; i < people.length; i++) {
            people[i] = scanner.nextLine();
        }
        //输入查询人名
        String[] twoPeople = new String[Integer.parseInt(scanner.nextLine())];

        for (int i = 0; i < twoPeople.length; i++) {
            twoPeople[i] = scanner.nextLine();
        }
        String firstPeople;
        String secondPeople;

        for (String twoPerson : twoPeople) {
            firstPeople = getFirstPeople(twoPerson);
            secondPeople = getSecondPeople(twoPerson);
            if (isNotLocalPeople(firstPeople) || isNotLocalPeople(secondPeople)) {
                System.out.println("NA");
            } else if (getGender(getLocalPeopleName(firstPeople)) == (getGender(getLocalPeopleName(secondPeople)))) {
                System.out.println("Whatever");
            } else if (hasSameForefather(firstPeople, secondPeople)) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    private static boolean isNotLocalPeople(String name) {
        String str2 = getFirstName(name);
        String str1;
        for (int i = 0; i < people.length; i++) {
            str1 = getFirstName(people[i]);
            if (str2.equals(str1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasSameForefather(String firstPeople, String secondPeople) {
        //str1,str2一代祖先
        String str1 = getFather(firstPeople);
        String str2 = getFather(secondPeople);
        //str3,str4二代祖先
        String str3 = getFather(getLastNameWithoutGender(str1));
        String str4 = getFather(getLastNameWithoutGender(str2));
        //str5,str6三代祖先
        String str5 = getFather(getLastNameWithoutGender(str3));
        String str6 = getFather(getLastNameWithoutGender(str4));
        //上一代同祖先
        if (str1.equals(str2)) {
            return true;
        }
        //二代同祖先
        else if (haveSameFather(str1, str2)) {
            return true;
        }
        //三代同祖先
        else if (haveSameFather(str3, str4)) {
            return true;
        } else return str5.equals(str4) || str6.equals(str3);
    }


    private static boolean haveSameFather(String str1, String str2) {
        return getFather(getLastNameWithoutGender(str1)).equals(getFather(getLastNameWithoutGender(str2)));
    }


    private static String getLocalPeopleName(String name) {
        String str = getFirstName(name);
        for (String person : people) {
            if (str.equals(getFirstName(person))) {
                return getLastName(person);
            }
        }
        return people[0];
    }

    private static int getGender(String lastName) {
        if (lastName.charAt(lastName.length() - 1) == 'm') {
            return 1;
        } else if (lastName.charAt(lastName.length() - 1) == 'n') {
            return 1;
        }
        return 0;
    }

    private static String getLastNameWithoutGender(String name) {

        if (name.charAt(name.length() - 1) == 'm') {
            return name.substring(0, name.length() - 1);
        } else if (name.charAt(name.length() - 1) == 'f') {
            return name.substring(0, name.length() - 1);
        } else if (name.charAt(name.length() - 1) == 'n') {
            return name.substring(0, name.length() - 4);
        }
        return name.substring(0, name.length() - 7);
    }

    private static String getFather(String name) {
        String str = getLastName(name);
        for (String person : people) {
            if (str.equals(getFirstName(person))) {
                return person;
            }
        }
        //两个人有可能差辈分，简单对比同父辈不普适
        return "differentFather";

    }


    private static String getSecondPeople(String twoPeople) {
        int j = twoPeople.lastIndexOf(" ") - 1;
        String str = twoPeople.substring(twoPeople.lastIndexOf(" ", j) + 1);
        return str;
    }

    private static String getFirstPeople(String twoPeople) {
        int j = twoPeople.indexOf(" ") + 1;
        String str = twoPeople.substring(0, twoPeople.indexOf(" ", j));
        return str;
    }

    private static String getFirstName(String person) {
        String str = person.substring(0, person.indexOf(" "));
        return str;
    }

    private static String getLastName(String person) {
        String str = person.substring(person.indexOf(" ") + 1);
        return str;
    }
}
