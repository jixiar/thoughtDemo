package com.dcml.cms.controller;

public class CloneClass implements Cloneable {

    public int aInt;

    @Override
    public Object clone(){

        CloneClass o = null;
        try{
            o = (CloneClass)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return o;

    }

}
