package com.company.javaCore.populationCensus;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );

        }
        Stream<Person> streamAge = persons.stream();
        streamAge.filter(x -> x.getAge() > 18).count();
        Stream<Person> personStream = persons.stream();
        personStream.filter(x -> x.getAge() >= 18 && x.getAge() <= 27)
                .map(s -> s.getName() + " " + s.getFamily()).collect(Collectors.toList());
        Stream<Person> surnameStream = persons.stream();
        surnameStream.filter(s -> s.getEducation() == Education.HIGHER)
                .filter(s -> s.getSex() == Sex.MAN ?
                        s.getAge() > 18 && s.getAge() < 65 : s.getAge() > 18 && s.getAge() < 60)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
//
    }
}
