package com.alexanderberndt.appintegration.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.util.Arrays;

public class IntegrationContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationContext.class);

    public void addWarning(Logger logger, String messagePattern, Object... objects) {
    }


    public void addWarning(String messagePattern, Object... objects) {

        final FormattingTuple formattingTuple;
        if ((objects != null) && (objects.length > 0) && (objects[objects.length - 1] instanceof Throwable)) {
            // format message, if it contains a throwable
            final Throwable t = (Throwable) objects[objects.length - 1];
            final Object[] otherObjects;
            if (objects.length > 1) {
                otherObjects = Arrays.copyOfRange(objects, 0, objects.length - 1);
            } else {
                otherObjects = null;
            }
            formattingTuple = MessageFormatter.arrayFormat(messagePattern, otherObjects, t);
        } else {
            formattingTuple = MessageFormatter.arrayFormat(messagePattern, objects);
        }

        System.out.println(formattingTuple.toString());

    }

    public void addWarning(String text) {

    }

    public void addError(String messagePattern, Object... objects) {

    }

    public void addError(Logger logger, String messagePattern, Object... objects) {

    }
}
