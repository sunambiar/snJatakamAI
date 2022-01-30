
/*--------------------------------------------------------*/
/*               Suresh's  Jatakam - classes              */
/*--------------------------------------------------------*/
//package snJatakam;
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic;

import java.text.DecimalFormat;

/*--------------------------------------------------------*/
public class DMS {
  public static double deg = 0.0;
  public static boolean html = false;
  private final static DecimalFormat fmt = new DecimalFormat("00");
  public DMS (boolean htm) {
    html = htm;
  }
  DMS (double d) {
    deg = d;
  }

  public static String dms(double d) {
    int dms[] = _dms(d);   
    String sgn = ""; 
    if (dms[0] < 0) {
      sgn = "-"; 
    }
    return (sgn.trim() + fmt.format(dms[1]) + (html ? "&deg":"\u00B0") + 
          fmt.format(dms[2]) + "'" + fmt.format(dms[3]) + "\"");
  }

  public static String DMS(double d) {
    int dms[] = _dms(d);   
    String sgn = ""; 
    if (dms[0] < 0) {
      sgn = "-"; 
    }
    return (sgn.trim() + fmt.format(dms[1]) + ':' + fmt.format(dms[2]) + ":" + fmt.format(dms[3]));
  }

  public static int[] _dms(double d) {
    int dd, mm, ss;
    int sgn = 1;
    //String sgn = "";
    if (d < 0) {
      //sgn = "-";
      sgn = -1;
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
    return (new int[]{sgn, dd, mm, ss});
    //return (sgn.trim() + dd + (html ? "&deg":"\u00B0") + mm + "'" + ss + "\"");
  }
}
/*-------------------------- For Horoscope -----------------------*/
