/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snJatakamAI.snJatakam.sn_Jatakam;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import snJatakamAI.snJatakam.sn_Jatakam.snJatak;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snIOglobalSetting;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snPrintWriter;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snJatakData;

/**
 *
 * @author sureshnambiar
 * @date 2022-01-22 16:30 hrs
 */
public class snJDataEx {

  private static String[] getCSV2Args(JSONObject jsObj) {
    String xstr = null, xstrArr[];
    Calendar calendar = new GregorianCalendar();
    Date dt = null;
    String[] sArg = new String[23];
    //ArrayList<String> arr = new ArrayList(22);
    int cnt = 0;
    sArg[cnt++] = "VH";
    sArg[cnt++] = jsObj.getString("Name");
    sArg[cnt++] = "M"; //jsObj.getString("Sex"); 
//,Date of Birth,Information Source,Latitude,Longitude,Name,Place of Birth,Segment,Time Zone,Time of Birth
    xstr = jsObj.getString("Date of Birth") + " " + jsObj.getString("Time of Birth");
    try {
      dt = new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm:ss").parse(xstr);
      calendar.setTime(dt);
      sArg[cnt++] = "" + calendar.get(Calendar.DATE);
      sArg[cnt++] = "" + (calendar.get(Calendar.MONTH) + 1);
      sArg[cnt++] = "" + calendar.get(Calendar.YEAR);
      sArg[cnt++] = "" + calendar.get(Calendar.HOUR_OF_DAY);
      sArg[cnt++] = "" + calendar.get(Calendar.MINUTE);
      sArg[cnt++] = "" + calendar.get(Calendar.SECOND);
    } catch (Exception ign) {
      System.out.println("Error " + ign);
    }
    sArg[cnt++] = jsObj.getString("Time Zone");
    sArg[cnt++] = jsObj.getString("Place of Birth");
    xstr = jsObj.getString("Latitude");
    xstrArr = xstr.replaceAll("[^\\\\x00-\\\\x7F]", ":").split(":");
    sArg[cnt++] = xstrArr[0]; // deg
    sArg[cnt++] = xstrArr[2]; // min
    sArg[cnt++] = xstrArr[1]; // NS
    xstr = jsObj.getString("Longitude");
    xstrArr = xstr.replaceAll("[^\\\\x00-\\\\x7F]", ":").split(":");
    sArg[cnt++] = xstrArr[0]; // deg
    sArg[cnt++] = xstrArr[2]; // min
    sArg[cnt++] = xstrArr[1]; // EW
    sArg[cnt++] = "1"; // 0-Summary / 1-Detail  
    sArg[cnt++] = "0"; // 0-Lahiri, 1-BVRaman, 2-ChandraHari, 3-Custom  
    sArg[cnt++] = "0";
    sArg[cnt++] = "0";
    sArg[cnt++] = "0";
    sArg[cnt++] = jsObj.getString("Segment");
    return sArg;
  }
  /*
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
   */
  JSONObject jsonObj = null;

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
    if (args.length < 2) {
      System.out.println("====================================================");
      System.out.println("java -jar snJDataEx <inpfilename> <outputJSONfile>");
      System.out.println("====================================================");
      System.out.println("         snJyotish_charts-orig.csv  chartsJSON.json");
      System.out.println("====================================================");
      System.exit(0);
    }
    String inpFile = args[0];
    String outFile = args[1];

    snJatakData snJdt = new snJatakData();
    JSONArray jsonAll = new JSONArray();
    JSONArray jsonArr = snJdt.getCSV2JSON(inpFile);
    //JSONObject jsObj = snJdt.getCSV2JSON(inpFile);
    // writing JSON to file
    PrintWriter pw = null;
    try {
      pw = new PrintWriter(outFile); // ("JSONExample.json");   
      for (int i = 0; i < 3 /*jsonArr.length()*/ ; i++) {
        JSONObject jsObj = jsonArr.getJSONObject(i);
        String[] chartArgs = getCSV2Args(jsObj);
        snJDataEx snJD = new snJDataEx(chartArgs);
        //jsonAll.put(snJD.jsonObj.toString());
        jsonAll.put(snJD.jsonObj);
        //new JSONObject(jsonString).toString(spacesToIndentEachLevel);
      }
    } catch (Exception ee) {
      System.out.println(ee);
    } finally {
      if (pw != null) {
        pw.write(jsonAll.toString(2));
        pw.flush();
        pw.close();
      }
      System.out.println("-- Done --");
    }
  }

  snJDataEx() {
  }

  snJDataEx(String[] args) {
    snIOglobalSetting.usePrintWriterFlag = true;
    snIOglobalSetting.setPrintWriterOn(false);

    /*
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
     */
    snPrintWriter pW = new snPrintWriter();
    snJatak snP = new snJatak(pW, args);
    jsonObj = snP.getDataJSON();

  }
}
