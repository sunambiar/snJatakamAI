
/*--------------------------------------------------------*/
/*               Suresh's  Jatakam - classes              */
/*--------------------------------------------------------*/
//package snJatakam;
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic;
import java.text.DecimalFormat;
/*--------------------------------------------------------*/
public class HMS {
  private static DecimalFormat fmt = new DecimalFormat("00");
  public static double hrs = 0.0;

  HMS (double h) {
    hrs = h;
  }
  public static String hms(double h) {
    String ampm;
    int hh, mm, ss;
    String sgn = "";
    if (h > 24.0) h -= 24 * ((long)(h / 24));
    if (h < 0) {
      sgn = "-";
      h = -h;
    }
    hrs = h;
    hh = (int)(h);
    h = (h - (int)h)*60;
    mm = (int)h;
    h = (h - (int)h)*60;
    ss = (int)Math.round(h);
    if (ss >= 60) {
      ss -= 60;
      mm++;
    }
    if (mm >= 60) {
     mm -= 60;
     hh++;
    }
    if (hh >= 24) hh -= 24;
    if (hh > 12) {
      hh -= 12;
      ampm = " PM";
    } else if (((double)hh+((double)mm+(double)ss/60.0)/60.0) > 12.0) {
	  ampm = " PM";
    } else ampm = " AM";
    return(sgn.trim() + hh + ":" + fmt.format(mm) + ":" + fmt.format(ss) + ampm);
  }
  public static double toZonalTime(double h, double longitude, double zone) {
    h -= zone - longitude*24.0/360.0;
    return (h);
  }
  public static String hms(double h, double longitude, double zone) {
    return (hms(toZonalTime(h,longitude,zone)));
  }
}
/*-------------------------- For Horoscope -----------------------*/
