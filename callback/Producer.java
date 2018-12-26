package com.dcml.cms.controller;

public class Producer extends Thread {
    private ShareCached sCached;

    public Producer(ShareCached shareCached){
        this.sCached = shareCached;
    }

    @Override
    public void run(){
        for(char product = 'A';product <='D';product++){
            try{
                sleep((int)(Math.random()*3000));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            sCached.addShareCachedData(product);
        }
    }
}
