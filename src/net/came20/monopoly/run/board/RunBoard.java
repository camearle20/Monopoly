package net.came20.monopoly.run.board;

import org.zeromq.ZMQ;

/**
 * Created by cameronearle on 12/27/16.
 */
public class RunBoard implements Runnable {
    @Override
    public void run() {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket pubSock = context.socket(ZMQ.PUB);
        ZMQ.Socket subSock = context.socket(ZMQ.SUB);
        subSock.subscribe("A".getBytes());
        subSock.subscribe("B".getBytes());
        pubSock.bind("tcp://*:8100");
        subSock.connect("tcp://127.0.0.1:8100");

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    pubSock.sendMore("C");
                    pubSock.send("test");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        System.out.println(subSock.recvStr());
        System.out.println(subSock.recvStr());
    }
}
