package net.came20.monopoly.run.player;


import net.came20.camecommand.CameCommand;
import net.came20.monopoly.command.update.PlayerUpdate;
import net.came20.monopoly.command.update.parameter.NewServerPlayerUpdateReferenceParameter;
import net.came20.monopoly.common.event.PlayerIncomingUpdateEvent;
import org.zeromq.ZMQ;

/**
 * Created by cameronearle on 12/28/16.
 */
public class AnnounceReceiver implements Runnable {
    private String address;
    private String token;

    public AnnounceReceiver(String address, String token) {
        this.address = address;
        this.token = token;
    }

    @Override
    public void run() {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.SUB);
        socket.subscribe(token.getBytes());
        socket.subscribe("ALL".getBytes());
        socket.connect(address);

        while (!Thread.currentThread().isInterrupted()) {
            socket.recv();
            System.out.println("Got announcement");
            CameCommand recvCommand = new CameCommand(socket.recvStr());
            if (recvCommand.getCommand().equals(PlayerUpdate.NEW_SERVER_PLAYER_UPDATE_REF)) {
                NewServerPlayerUpdateReferenceParameter parameter = (NewServerPlayerUpdateReferenceParameter) recvCommand.getParameter();
                RunPlayer.incomingUpdateGroup.callGroup(new PlayerIncomingUpdateEvent(parameter.getNewPlayerRef()));
            }
        }
    }
}
