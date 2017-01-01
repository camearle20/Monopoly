package net.came20.monopoly.common.event;

import net.came20.monopoly.Monopoly;
import net.came20.monopoly.common.item.MoneyStack;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cameronearle on 12/28/16.
 */
public class EventGroup<E extends EventHandler> {
    private List<E> eventHandlers = new ArrayList<>();

    public void addEventHandler(E e) {
        eventHandlers.add(e);
    }

    public int getNumberOfEventHandlers() {
        return eventHandlers.size();
    }

    private void checkedHandlerCall(E handler, Event event) { //Method to check the sides before running a method
        Method method = null;
        try {
            method = handler.getClass().getMethod("onEvent", Event.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return;
        }
        Sided annotation = method.getAnnotation(Sided.class);
        if (annotation == null) {
            handler.onEvent(event);
        } else {
            Side side = annotation.value();
            if (side.equals(Monopoly.getSide())) {
                handler.onEvent(event);
            }
        }
    }

    public E getEventHandler(int index) {
        if (index >= eventHandlers.size()) {
            return null;
        } else {
            return eventHandlers.get(index);
        }
    }

    public boolean callHandler(int index, Event event) {
        if (index >= eventHandlers.size()) {
            return false;
        } else {
            checkedHandlerCall(eventHandlers.get(index), event);
            return true;
        }
    }


    public void callGroup(Event event) {
        for (E handler : eventHandlers) {
            checkedHandlerCall(handler, event);
        }
    }

    public void clearGroup() { //Empty the group, this is used when the client receives a new Player object, it needs to clear out the old (server only) handlers and patch in new ones
        eventHandlers.clear();
    }
}
