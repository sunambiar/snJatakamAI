
/*--------------------------------------------------------*/
/*               Suresh's  Jatakam - classes              */
/*--------------------------------------------------------*/
//package snJatakam;
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic;
/*--------------------------------------------------------*/
public class DMS {
  public static double deg = 0.0;
  public static boolean html = false;
  public DMS (boolean htm) {
    html = htm;
  }
  DMS (double d) {
    deg = d;
  }
  public static String dms(double d) {
    int dd, mm, ss;
    String sgn = "";
    if (d < 0) {
      sgn = "-";
      d = -d;
    }
    deg = d;
    dd = (int)d;
    d = (d - (int)d)*60;
    mm = (int)d;
    d = Math.round((d - (int)d)*60);
    ss = (int)d;
    if (ss >= 60) {
      ss -= 60;
      mm++;
    }
    if (mm >= 60) {
      mm -= 60;
      dd++;
    }
    if (dd >= 360) dd -= 360;
    return (sgn.trim() + dd + (html ? "&deg":"\u00B0") + mm + "'" + ss + "\"");
  }
}
/*-------------------------- For Horoscope -----------------------*/
