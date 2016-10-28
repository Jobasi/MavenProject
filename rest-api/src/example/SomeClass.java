package example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created on 19/10/2016.
 */
@WebService
public class SomeClass {
    @WebMethod
    public String someMethod(){
        return "Some String";
    }

    public static void main(String[] args) {
        Object someObject = new SomeClass();
        String uri = "http://localhost:9000/SomeClass";
        Endpoint.publish(uri, someObject);

    }
}
