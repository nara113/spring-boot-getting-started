package com.study.argument;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ArgumentListener {
    public ArgumentListener(ApplicationArguments arguments) {
        System.out.println("foo : " + arguments.containsOption("foo"));
        System.out.println("bar : " + arguments.containsOption("bar"));
    }

    @Component
    public static class ArgumentRunner implements ApplicationRunner {
        @Override
        public void run(ApplicationArguments args) throws Exception {
            System.out.println("foo : " + args.containsOption("foo"));
            System.out.println("bar : " + args.containsOption("bar"));
        }
    }

    @Component
    public static class ArgumentCommand implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            System.out.println(Arrays.toString(args));
        }
    }
}
