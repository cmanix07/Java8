package com.cmani.model.com.cmani.main;

import com.cmani.model.Person;
import com.cmani.spliterator.PeopleSpliterator;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorMain {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("07spliterator/files/people.txt");
        System.out.println("====== Demonstration of Custom Spliterator ======");

        try(Stream<String> lines = Files.lines(path)){
            Spliterator<String> lineSpliterator = lines.spliterator();

            PeopleSpliterator peopleSpliterator = new PeopleSpliterator(lineSpliterator);
            Stream<Person> personStream = StreamSupport.stream(peopleSpliterator,false);
            personStream.forEach(System.out::println);
        }
    }
}
