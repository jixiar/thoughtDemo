package com.dcml.cms.controller;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class Consumer extends Thread {
    private ShareCached sCached;

    public Consumer(ShareCached shareCached){
        this.sCached = shareCached;
    }

    @Override
    public void run(){
        char product = '\u0000';
        do{
            try{
                Thread.sleep((int)(Math.random()*3000));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

            product = sCached.getShareCachedData();

        }while (product != 'D');
    }

}
