/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO;

/**
 *
 * @author sureshnambiar
 * @date 2022-01-22 18:06
 */
public class snIOglobalSetting {

  public static boolean usePrintWriterFlag = false;
  private static boolean printWriterOn = false;

  public static void setPrintWriterOn(boolean on_off) {
    printWriterOn = on_off;
  }

  public static boolean getPrintWriterOn() {
    return  usePrintWriterFlag ? printWriterOn : true;
  }
}
