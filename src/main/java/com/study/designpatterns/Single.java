package com.study.designpatterns;

public class Single {

private Single(){}

private static Single single=null;

public static Single init(){
    if(single== null){
        synchronized (Single.class){
            if(single==null){
                single = new Single();
            }
        }
    }
return single;
}
}
