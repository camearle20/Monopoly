package net.came20.monopoly.run.server;

import net.came20.camecommand.CameCommand;
import net.came20.monopoly.command.AnnounceWrapper;
import org.zeromq.ZMQ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cameronearle on 12/28/16.
 */
public class AnnounceSocket implements Runnable {
    private String address;

    private static List<AnnounceWrapper> queue = new ArrayList<>();

    public static void addToQueue(AnnounceWrapper announceWrapper) {
        queue.add(announceWrapper);
    }

    public AnnounceSocket(String address) {
        this.address = address;
    }

    @Override
    public void run() {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.PUB);
        socket.bind(address);

        while (!Thread.currentThread().isInterrupted()) {
            while (!queue.isEmpty()) {
                AnnounceWrapper currentWrapper = queue.remove(0);
                socket.sendMore(currentWrapper.getTarget());
                socket.send(currentWrapper.getCommand().encode());
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        socket.close();
    }
}
