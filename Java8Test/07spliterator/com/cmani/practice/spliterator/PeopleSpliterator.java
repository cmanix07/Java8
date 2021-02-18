package com.cmani.spliterator;

import com.cmani.model.Person;

import javax.xml.namespace.QName;
import java.util.Spliterator;
import java.util.function.Consumer;

public class PeopleSpliterator implements Spliterator<Person> {

    private final Spliterator<String> lineSpliterator;
    private String name;
    private String gender;
    private int age;

    public PeopleSpliterator(Spliterator<String> lineSpliterator) {
        this.lineSpliterator = lineSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Person> action) {

       if(lineSpliterator.tryAdvance(line -> name = line ) &&
        lineSpliterator.tryAdvance(line -> gender = line ) &&
        lineSpliterator.tryAdvance(line -> age = Integer.parseInt(line)) ){
        Person person = new Person(name, gender, age);
        action.accept(person);
           return true;
       };
        return false;
    }

    @Override
    public Spliterator<Person> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return lineSpliterator.estimateSize()/3;
    }

    @Override
    public int characteristics() {
        return lineSpliterator.characteristics();
    }
}
