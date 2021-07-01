package net.beeapm.agent.plugin.handler;


import net.beeapm.agent.log.LogImpl;
import net.beeapm.agent.model.Span;

import java.lang.reflect.Method;

/**
 * Created by yuan on 2018/7/30.
 */
public abstract class AbstractHandler implements IHandler {
    public String getClassName(Method m){
        if(m!=null){
            return m.getDeclaringClass().getName();
        }
        return null;
    }

    public String getMethodName(Method m){
        if(m!=null){
            return m.getName();
        }
        return null;
    }

    public void logBeginTrace(Method m, Span span, LogImpl log){
        log.trace("[begin]{}.{} tc={}", getClassName(m), getMethodName(m), span.getType());
    }
    public void logEndTrace(Method m, Span span,LogImpl log){
        log.trace("[end]{}.{} tc={}", getClassName(m), getMethodName(m), span.getType());
    }

    public void calculateSpend(Span span){
        if(span != null){
            span.setSpend(System.currentTimeMillis() - span.getTime().getTime());
        }
    }

}
