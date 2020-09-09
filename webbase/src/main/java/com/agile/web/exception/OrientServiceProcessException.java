/**
 * @Project Name :  mainserver
 * @Package Name :  com.agile.web.exception
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-24 2:04 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.web.exception;

/**
 * @author :  panduanduan
 * @Description :  调用restful异常
 * @Creation Date:  2018-01-24 2:04 PM
 */
public class OrientServiceProcessException extends RuntimeException {

    public OrientServiceProcessException(String message) {
        super(message);
    }

    public OrientServiceProcessException(String message, Throwable cause) {
        super(message, cause);
    }
}