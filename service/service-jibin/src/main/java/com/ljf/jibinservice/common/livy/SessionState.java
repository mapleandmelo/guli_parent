package com.ljf.jibinservice.common.livy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */
public enum SessionState {
    not_started,starting,idle,busy,shutting_down,error,dead,killed,success,running;


    public static Boolean isError(SessionState sessionState){
        switch (sessionState){
            case killed:
            case error:
            case shutting_down:
            case dead:
                return true;
            default:return false;
        }
    }

    public static List<SessionState> getFinalState(){
        List<SessionState> finalState=new ArrayList<>();
        finalState.add(killed);
        finalState.add(error);
        finalState.add(shutting_down);
        finalState.add(success);
        finalState.add(dead);
        return finalState;
    }
    public static Boolean isFinalState(SessionState sessionState){
        switch (sessionState){
            case killed:
            case error:
            case shutting_down:
            case success:
            case dead:
                return true;
            default:return false;
        }
    }
}
