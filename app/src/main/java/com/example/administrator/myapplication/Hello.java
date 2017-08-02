package com.example.administrator.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */

public class Hello<T> {
    List<T> list = new ArrayList<T>();
    public int getSize(){
        return list.size();
    }
    public T peek(){
        return list.get(list.size()-1);
    }

    public void push(T t){
        list.add(t);
    }
}
