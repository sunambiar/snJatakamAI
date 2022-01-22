/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snJatakamAI.snJatakam.sn_Jatakam;

import snJatakamAI.snJatakam.sn_Jatakam.snJatak;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snIOglobalSetting;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snPrintWriter;


import java.util.LinkedHashMap;
import java.util.Map; 
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author sureshnambiar
 * @date 2022-01-22 16:30 hrs
 */
public class snJDataEx {

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

    JSONObject jo = new JSONObject();
           
/*          
        // putting data to JSONObject
        jo.put("firstName", "John");
        jo.put("lastName", "Smith");
        jo.put("age", 25);
          
        // for address data, first create LinkedHashMap
        Map m = new LinkedHashMap(4);
        m.put("streetAddress", "21 2nd Street");
        m.put("city", "New York");
        m.put("state", "NY");
        m.put("postalCode", 10021);
          
        // putting address to JSONObject
        jo.put("address", m);
          
        // for phone numbers, first create JSONArray 
        JSONArray ja = new JSONArray();
          
        m = new LinkedHashMap(2);
        m.put("type", "home");
        m.put("number", "212 555-1234");
          
        // adding map to list
        ja.add(m);
          
        m = new LinkedHashMap(2);
        m.put("type", "fax");
        m.put("number", "212 555-1234");
          
        // adding map to list
        ja.add(m);
          
        // putting phoneNumbers to JSONObject
        jo.put("phoneNumbers", ja);
          
        // writing JSON to file:"JSONExample.json" in cwd
        PrintWriter pw = new PrintWriter("JSONExample.json");
        pw.write(jo.toJSONString());
          
        pw.flush();
        pw.close();
*/

  /**
   * To get only data for given arguments
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
  }

  snJDataEx() {
  }

  snJDataEx(String[] args) {
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
