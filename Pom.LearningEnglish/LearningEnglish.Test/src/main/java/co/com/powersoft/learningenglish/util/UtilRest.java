/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author Leonardo
 */
public class UtilRest {
    
    private static final String STATUS_ERROR = "Failed -> HTTP error code: ";
    
    /**
     * Method for obtaining Rest Response
     *
     * @autor Leonardo Solano
     * @since 2017-01-31
     * @param endpoint (String) endpoint of operation
     * @param request (Object) object of request
     * @param responseObjectClass (Class<?>) class object response
     * @return Object of response
     */
    public static Object getResponse(String endpoint, Object request, Class<?> responseObjectClass) {

        Response response = null;
        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target(endpoint);

//            String token = TokenUtil.createToken(user);
//            System.out.println("TOKEN: " + token);

//            response = target.request().header(HttpHeaders.AUTHORIZATION, token).post(Entity.entity(request, MediaType.APPLICATION_JSON));
            response = target.request().post(Entity.entity(request, MediaType.APPLICATION_JSON));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            if (response.getStatus() == 200) {
                return response.readEntity(responseObjectClass);
            } else {
                System.out.println(STATUS_ERROR + response.getStatus());
                System.out.println("*** "+getHttpCodeError(response.getStatus())+" ***");
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }

    public static String getHttpCodeError(int codeError) {
        String resp;
        switch (codeError) {
            case 500:
                resp = "Error con la autenticacion";
                break;
            default:
                resp = "Error desconocido";
                break;
        }
        return resp;
    }
    
}
