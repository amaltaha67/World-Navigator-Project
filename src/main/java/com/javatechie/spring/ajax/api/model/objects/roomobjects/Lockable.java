package com.javatechie.spring.ajax.api.model.objects.roomobjects;

public class Lockable {
    private boolean isLocked ;
    public Lockable(Boolean Locked){
        if (Locked)
            Lock();
        else
            UnLock();
    }
    public void Lock(){
        isLocked = true ;
    }
    public void UnLock(){
        isLocked = false  ;
    }
    public boolean LockStatus(){
        return isLocked  ;
    }

    @Override
    public String toString() {
        return "Lockable";
    }
}
