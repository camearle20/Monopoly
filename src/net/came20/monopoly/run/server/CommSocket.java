package net.came20.monopoly.run.server;

import net.came20.camecommand.CameCommand;
import org.zeromq.ZMQ;

import java.io.UncheckedIOException;

/**
 * Created by cameronearle on 12/29/16.
 */
public class CommSocket {
    private static String threadName = null;
    private static ZMQ.Context context = null;
    private static ZMQ.Socket socket = null;

    private static void checkThread() {
        if (!Thread.currentThread().getName().equals(threadName)) {
            throw new RuntimeException("Comm socket accessed from illegal thread [" + Thread.currentThread().getName() + "], must be accessed from [" + threadName + "]");
        }
    }

    public static void init() {
        threadName = Thread.currentThread().getName();
        context = ZMQ.context(1);
        socket = context.socket(ZMQ.PUB);
    }

    public static void connect(String address) {
        checkThread();
        socket.bind(address);
    }

    public static void disconnect() {
        checkThread();
        socket.close();
        socket = null;
        context = null;
    }

    public static CameCommand listen() {
        checkThread();
        return new CameCommand(socket.recvStr());
    }

    public static void respond(CameCommand command) {
        checkThread();
        socket.send(command.encode());
    }

}
