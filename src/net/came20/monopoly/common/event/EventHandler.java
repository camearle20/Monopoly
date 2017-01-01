package net.came20.monopoly.common.event;

/**
 * Created by cameronearle on 12/28/16.
 */
public interface EventHandler<E extends Event> {
    void onEvent(E e);
}
