/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.logger;

/**
 * Clase que permite configurar Log4j
 * @author Leonardo
 * @since 2016-02-19
 */
public class ConfigurationService {
    
    private static transient ConfigurationService instance;

    public ConfigurationService() {
        try {
//        URL url = getClass().getResource("/co/com/powersoft/logger/resources/log4j2.xml");
//        InputStream inputStream = this.getClass().getResourceAsStream("/co/com/powersoft/logger/resources/log4j2.xml");
//        System.setProperty("log4j.configurationFile", "C:/powersoft/log4j2.xml");
//        System.setProperty("log4j.configurationFile", this.getClass().getResourceAsStream("/co/com/powersoft/dao/xml/log4j2.xml"));
        
//        System.setProperty("log4j.configurationFile", url.getPath());
        } catch (Exception e) {
            System.out.println("ERROR ConfigurationService: "+e);
        }
    }
    
    
    /**
     * Devuelve la instancia de la clase
     *
     * @author Leonardo Solano
     * @since 2016-02-19
     * @return instancia de la clase
     */
    public static ConfigurationService getInstance() {
        if (null == instance) {
            instance = new ConfigurationService();
        }
        return instance;
    }
    
}
