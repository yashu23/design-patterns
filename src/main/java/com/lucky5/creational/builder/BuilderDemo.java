package com.lucky5.creational.builder;

import lombok.extern.slf4j.Slf4j;

/*
Builder pattern is useful when an object creation is a complex i.e. have n number of inputs required.
It provides flexiblity to generate different flavours of an object
 */
@Slf4j
public class BuilderDemo {
    public static void main(String[] args) {
        Burger burgerWithoutLettuce = new Burger.Builder().withBread("honeygrain").withPatty("veg-patty").build();
        log.debug("burger without lettuce {} ", burgerWithoutLettuce);

        Burger burgerWithEverything = new Burger.Builder()
                .withBread("honeygrain")
                .withPatty("veg-patty")
                .withLettuce("iceberg")
                .build();
        log.debug("burger without everything {} ", burgerWithEverything);


    }
}


/*
Some of the inputs are optional, burger may or may not have patty or lettuce
 */
class Burger {
    private String patty;
    private String bread;
    private String lettuce;

    @Override
    public String toString() {
        return "Burger{" +
                "patty='" + patty + '\'' +
                ", bread='" + bread + '\'' +
                ", lettuce='" + lettuce + '\'' +
                '}';
    }

    public Burger(Builder builder) {
        this.patty = builder.patty;
        this.bread = builder.bread;
        this.lettuce = builder.lettuce;
    }

    public static class Builder {
        private String patty;
        private String bread;
        private String lettuce;

        public Builder withPatty(String patty) {
            this.patty = patty;
            return this;
        }

        public Builder withBread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder withLettuce(String lettuce) {
            this.lettuce = lettuce;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }
}
