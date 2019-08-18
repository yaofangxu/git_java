package com.study.designpatterns;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
public @interface AnnotationTest {

    String name();

    String[] ars();


}


class Pers{

    @AnnotationTest(name="你好",ars={"1","2"})

    private String name;

}