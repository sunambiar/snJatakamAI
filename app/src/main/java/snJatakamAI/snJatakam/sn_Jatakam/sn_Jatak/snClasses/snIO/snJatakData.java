/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author sureshnambiar
 * @date 2022-01-23 14:27
 */
public class snJatakData {

  public class AstroSageFormat {
//,Date of Birth,Information Source,Latitude,Longitude,Name,Place of Birth,Segment,Time Zone,Time of Birth

    private int slno;
    private String date_of_birth;
    private String information_source;
    private String latitude;
    private String longitude;
    private String name;
    private String place_of_birth;
    private String segment;
    private int time_zone;
    private String time_of_birth;
    // Constructors, Getters, Setters and toString
  }

//  public static void main(String args[]) throws Exception {
//  }
  public JSONArray getCSV2JSON(String fname) {
    File input = new File(fname);
    JSONObject jsObj = null;
    JSONArray jsonArr = null;
    try {
      CsvSchema csv = CsvSchema.emptySchema().withHeader();
      CsvMapper csvMapper = new CsvMapper();
      MappingIterator<Map<?, ?>> mappingIterator
          = csvMapper.reader().forType(Map.class).with(csv).readValues(input);
      List<Map<?, ?>> list = mappingIterator.readAll();
      //System.out.println(list);
      ObjectMapper mapper = new ObjectMapper();
      String newJsonData = mapper.writeValueAsString(list);

      jsonArr = new JSONArray(newJsonData);
      /*
      for (int i = 0; i < jsonArr.length(); i++) {
        JSONObject jsonObj = jsonArr.getJSONObject(i);
        System.out.println(jsonObj);
      }

      jsObj = new JSONObject("{" + newJsonData + "}");
       */
    } catch (Exception e) {
      e.printStackTrace();
    }
    return jsonArr == null ? new JSONArray() : jsonArr;
    //return jsObj == null ? new JSONObject() : jsObj;
  }

  /*
public JSONObject getCSV2JSON(String fname) {
CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
CsvMapper csvMapper = new CsvMapper();
MappingIterator<OrderLine> orderLines = csvMapper.readerFor(OrderLine.class)
  .with(orderLineSchema)
  .readValues(new File("src/main/resources/orderLines.csv"));

  private String item;
  private int quantity;
  private BigDecimal unitPrice;

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

  // Constructors, Getters, Setters and toString
}
   */
}
