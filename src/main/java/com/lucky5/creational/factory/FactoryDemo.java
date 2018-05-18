package com.lucky5.creational.factory;


import lombok.extern.slf4j.Slf4j;

/*
Type of Pattern: Creational

Description: Single Factory which knows how to create specific instances, the caller doesn't need to know about exact
creation of instance. This decouples client from actual object implementation. Actual implemention can be changed
without changes in client.
 */
@Slf4j
public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("CIRCLE");
        Shape rectangle = shapeFactory.getShape("RECTANGLE");

        circle.draw();
        rectangle.draw();
    }
}

class ShapeFactory {
    public Shape getShape(String type) {
        switch (type) {
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            default:
                throw new IllegalArgumentException("invalid shape requested " + type);
        }
    }
}

interface Shape {
    void draw();
}

@Slf4j
class Rectangle implements Shape {
    @Override
    public void draw() {
        log.debug("drawing Rectangle");
    }
}

@Slf4j
class Circle implements Shape {
    @Override
    public void draw() {
        log.debug("drawing Circle");
    }
}



