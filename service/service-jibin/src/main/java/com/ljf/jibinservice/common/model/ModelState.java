package com.ljf.jibinservice.common.model;


import com.ljf.jibinservice.common.livy.SessionState;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */
public enum ModelState {
    training,standby,error;
    public  static ModelState convertFromSessionState(SessionState seesionState){
        if(SessionState.isError(seesionState)){
            return error;
        }
        else if(seesionState==SessionState.success){
            return standby;
        }else{
            return training;
        }
    }
}
