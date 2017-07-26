/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.test;


import co.com.powersoft.learningenglish.bean.model.GetAllThemesRq;
import co.com.powersoft.learningenglish.bean.model.GetAllThemesRs;
import co.com.powersoft.learningenglish.util.UtilRest;
import co.com.powersoft.learningenglish.util.bean.generic.Status;
import co.com.powersoft.learningenglish.util.logger.print.PrintLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URLDecoder;
import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class TestRest {

    private static final String ENDPOINT = "http://localhost:8080/RestProvider/rest/learningEnglish/";
    private static final String SLASH = "/";

    public static void main(String[] args) {

//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        try {
//            TestRest.getAllThemes();
GetAllThemesRs response = new GetAllThemesRs();
Status status = new Status();
status.setCode("ERROR");
//status.setMesage("Invalid Request\r\nAtribute: lessonId -\u003e No puede ser nulo\r\n");
status.setMesage("hola como \r\nEstassss");
response.setStatus(status);

String resp = gson.toJson(response);
//resp = URLDecoder.decode(resp, "UTF-8");
resp = resp.replace("\\n", "\n");
            System.out.println(resp);
            
//            JsonParser p = new JsonParser();
//
//JsonElement r = p.parse("{\"text\":\"good\\n after\\nnoom\"}");
//JsonObject ob = r.getAsJsonObject();
//
//            System.out.println("R: "+r.toString().replace("\\\\n", "\\n"));
            String x = "hola como \r\nEstassss";
            System.out.println(x);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void getAllThemes() {

        //Nombre de la operación
        String OPERACION = "GET_THEMES";
        String endpoint = ENDPOINT + "getAllThemes";

        try {
            GetAllThemesRq request = new GetAllThemesRq();
            request.setRequestDate(new Date());
            request.setRequestId("123456789");
            request.setUserId("lsolano");

            //Logger REQUEST
            PrintLogger.printRequest(OPERACION, request);

            GetAllThemesRs response = (GetAllThemesRs) UtilRest.getResponse(endpoint, request, GetAllThemesRs.class);

            //Logger RESPONSE
            PrintLogger.printResponse(OPERACION, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
