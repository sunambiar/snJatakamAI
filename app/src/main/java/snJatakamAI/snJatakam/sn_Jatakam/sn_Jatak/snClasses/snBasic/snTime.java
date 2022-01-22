
/*--------------------------------------------------------*/
/*               Suresh's  Jatakam - classes              */
/*--------------------------------------------------------*/
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic;
//package snBasic;
//import java.text.DecimalFormat;
/*--------------------------------------------------------*/
public class snTime {
  short hh;
  short mm;
  double ss;
  /*------------------------------------------------------------------*/
  public snTime(short h1, short m1, double s1) {
    hh = h1; mm = m1; ss = s1;
  }
  /*------------------------------------------------------------------*/
  public String hms() {
	/*
	DecimalFormat fmt = new DecimalFormat("00");
	   //String output = fmt.format(value);
    return ((hh % 12) + ":" + fmt.format(mm) + ":" +
             fmt.format((int)(Math.round(ss*100)/100) +
                                ((hh >= 12) ? " PM" : " AM"));
    */
    return ((hh % 12) + ":" + mm + ":" + Math.round(ss*100)/100 +
                                ((hh >= 12) ? " PM" : " AM"));
  }
  /*------------------------------------------------------------------*/
  /*
  public String hms(double tm) {
    short h;
    if (tm > 24) tm -= 24;
    else if (tm < 0) tm += 24;
    h = (short)tm;
    m = (tm - (double)h) * 60.0;
    s = (m - (short)m) * 60.0;
    return (h +":"+ (short)m +":"+ (short)s + (tm > 12.0 ? " PM" : " AM"));
  }
  */
}
/*-------------------------- For Horoscope -----------------------*/
