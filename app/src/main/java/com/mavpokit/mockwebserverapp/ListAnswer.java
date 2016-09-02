package com.mavpokit.mockwebserverapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 30.08.2016.
 */
public class ListAnswer {
    List<Answer> items=new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Answer answer:items){
            sb.append(answer);
            sb.append("-----------\n");
        }

        return sb.toString();
    }
}
