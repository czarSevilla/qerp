package com.qacg.qerp.web.jsf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.qacg.qerp.web.util.MessageUtils;

public class MessageUtilsTest {

    @Test 
    public void newInstanceTest() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Constructor<MessageUtils> constructor = MessageUtils.class.getDeclaredConstructor();
        
        assertFalse(constructor.isAccessible());
        
        constructor.setAccessible(true);
        
        MessageUtils instance = constructor.newInstance();
        
        assertTrue(instance != null);
    }

}
