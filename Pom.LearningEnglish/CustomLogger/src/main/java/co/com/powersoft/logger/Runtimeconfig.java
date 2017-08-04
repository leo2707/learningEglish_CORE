/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.logger;

/**
 *
 * @author Leonardo
 */
public class Runtimeconfig {

    public void prueba() {

        CustomLogger logger = new CustomLogger(this.getClass());

        logger.info("Leooo INFO");
        logger.debug("Leooo DEBUG");
        logger.warn("Leooo WARN");
        logger.error("Leooo ERROR");
        logger.fatal("Leooo FATAL");
        System.out.println("Leooo SYSTEM OUT");

        try {
            CustomLogger logger2 = new CustomLogger(this.getClass());
            
            logger2.info("aaaaaaaaaab");
        } catch (Exception e) {
            System.out.println("EXPLOTOO");
            logger.error(ErrorUtil.getInstance().getErrorData(e, "PRUEBA", "INfo adicionallll"), e);
        }

    }

    public static void main(String args[]) {
        Runtimeconfig runtimeconfig = new Runtimeconfig();

        runtimeconfig.prueba();
    }

}
