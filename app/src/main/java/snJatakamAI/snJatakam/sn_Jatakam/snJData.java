/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snJatakamAI.snJatakam.sn_Jatakam;

import snJatakamAI.snJatakam.sn_Jatakam.snJatak;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snIOglobalSetting;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snPrintWriter;

/**
 *
 * @author sureshnambiar
 * @date 2022-01-22 16:30 hrs
 */
public class snJData {

    String viewHTML_fileHTML = ""; // = "VH";
    String name = ""; // = req.getParameter("nm");
    String sex = ""; // = req.getParameter("sex");
    String dd = ""; // = req.getParameter("dd");
    String mm = ""; // = req.getParameter("mm");
    String yy = ""; // = req.getParameter("yy");
    String hh = ""; // = req.getParameter("hh");
    String mt = ""; // = req.getParameter("mt");
    String ss = ""; // = req.getParameter("ss");
    String tmZ = ""; //  = req.getParameter("tmZ");
    String place = ""; // = req.getParameter("place");
    String latDeg = ""; // = req.getParameter("ltd");
    String latMin = ""; // = req.getParameter("ltm");
    //String latSec = args[argc++]; // = req.getParameter("lts");
    String latNS = ""; // = req.getParameter("ns");
    String longDeg = ""; // = req.getParameter("lgd");
    String longMin = ""; // = req.getParameter("lgm");
    //String longSec = args[argc++]; // = req.getParameter("lgs");
    String longEW = ""; // = req.getParameter("ew");
    String summDetlFlag = ""; // = req.getParameter("summdetl");
    //ayanamsa = new String(req.getParameter("ayan"));
    String ayanamsa = ""; // = ayanamsa;
    //if (Integer.parseInt(ayanamsa.trim()) == 3) {
    String ayanDeg = ""; // = req.getParameter("ayd");
    String ayanMin = ""; // = req.getParameter("aym");
    String ayanSec = ""; // = req.getParameter("ays");

  /**
   * To get only data for given arguments
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
  }

  snJData(String[] args) {
    snIOglobalSetting.usePrintWriterFlag = true;
    snIOglobalSetting.setPrintWriterOn(false);
    int argc = 0; 
    String viewHTML_fileHTML = args[argc++]; // = "VH";
    String name = args[argc++]; // = req.getParameter("nm");
    String sex = args[argc++]; // = req.getParameter("sex");
    String dd = args[argc++]; // = req.getParameter("dd");
    String mm = args[argc++]; // = req.getParameter("mm");
    String yy = args[argc++]; // = req.getParameter("yy");
    String hh = args[argc++]; // = req.getParameter("hh");
    String mt = args[argc++]; // = req.getParameter("mt");
    String ss = args[argc++]; // = req.getParameter("ss");
    String tmZ = args[argc++]; //  = req.getParameter("tmZ");
    String place = args[argc++]; // = req.getParameter("place");
    String latDeg = args[argc++]; // = req.getParameter("ltd");
    String latMin = args[argc++]; // = req.getParameter("ltm");
    //String latSec = args[argc++]; // = req.getParameter("lts");
    String latNS = args[argc++]; // = req.getParameter("ns");
    String longDeg = args[argc++]; // = req.getParameter("lgd");
    String longMin = args[argc++]; // = req.getParameter("lgm");
    //String longSec = args[argc++]; // = req.getParameter("lgs");
    String longEW = args[argc++]; // = req.getParameter("ew");
    String summDetlFlag = args[argc++]; // = req.getParameter("summdetl");
    //ayanamsa = new String(req.getParameter("ayan"));
    String ayanamsa = args[argc++]; // = ayanamsa;
    //if (Integer.parseInt(ayanamsa.trim()) == 3) {
    String ayanDeg = args[argc++]; // = req.getParameter("ayd");
    String ayanMin = args[argc++]; // = req.getParameter("aym");
    String ayanSec = args[argc++]; // = req.getParameter("ays");

    snPrintWriter pW = new snPrintWriter();
    snJatak snP = new snJatak(pW, args);
  }
}
