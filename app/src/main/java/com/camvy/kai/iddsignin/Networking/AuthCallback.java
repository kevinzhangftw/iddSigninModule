package com.camvy.kai.iddsignin.Networking;

/**
 * Created by kai on 2017-07-16.
 */

public interface AuthCallback<T> {

    void completion(T t);

}
