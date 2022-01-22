
/*--------------------------------------------------------*/
/*               Suresh's  Jatakam - classes              */
/*--------------------------------------------------------*/
//package snJatakam;
/*--------------------------------------------------------*/
//import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
/*--------------------------------------------------------*/
class snBasicDetls {
   int maxRows = 500;
   String[][] token = new String[maxRows][30];
   int recNo = 0;
   public int loadBasicDetails(String inpFile) {
     FileInputStream fileStream = null;
     BufferedInputStream buffStream = null;
     LineNumberInputStream lineStream = null;
     DataInputStream dataStream = null;
     String line, str;
     char ch = ' ';
     int i;
     try{
       fileStream = new FileInputStream( inpFile );
       buffStream = new BufferedInputStream(fileStream);
       lineStream = new LineNumberInputStream(buffStream);
       dataStream = new DataInputStream(lineStream);
       while ((line = dataStream.readLine()) != null) {
         int lineNo = lineStream.getLineNumber();
         line = line.trim();
         if (line.length() > 0) {
           if (line.charAt(0) != '#') {
             StringTokenizer st = new StringTokenizer(line,"/:|\n");
             //System.out.print(lineNo + " " + line);
             //System.out.println(" No of tokens = "+st.countTokens());
             for (i=0; st.hasMoreTokens(); i++) {
                                     //i < st.countTokens(); i++) {
               str = st.nextToken();
               token[recNo][i] = new String(str);
               //System.out.print("["+token[recNo][i]+"]");
             }
             //System.out.println();
             recNo++;
           }
         }
       }
     } catch (Exception ioErr) {
       System.out.println(ioErr.toString() );
       System.exit(100);
     }
     finally {
       try { dataStream.close(); } catch (Exception ignored) {}
     }
     return (recNo);
   }
   public int noofRecs() {
     return (recNo);
   }
   public int noofTokens(int nRec) {
     return (token[nRec].length);
   }
}
/*-------------------------- For Horoscope -----------------------*/
class DMS {
  public static double deg = 0.0;
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
    return (sgn.trim() + dd + "\u00B0" + mm + "'" + ss + "\"");
  }
}
/*-------------------------- For Horoscope -----------------------*/
class HMS {
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
    } else ampm = " AM";
    return(sgn.trim() + hh + ":" + mm + ":" + ss + ampm);
  }
  public static double toZonalTime(double h, double longitude, double zone) {
    h -= zone - longitude*24.0/360.0;
    return (h);
  }
  public static String hms(double h, double longitude, double zone) {
    return (hms(toZonalTime(h,longitude,zone)));
  }
}

/*--------------------------------------------------------*/
class snDate {
  short CC;
  short YY;
  short yy;
  short mm;
  short dd;
  /*------------------------------------------------------------------*/
  /*
  snDate(short y1, short m1, short d1) {
    yy = y1; mm = m1; dd = d1;
    YY = (short)((int)yy % 100);
    CC = (short)((int)yy - (int)YY);
  }
  */
  /*------------------------------------------------------------------*/
  snDate(int y1, int m1, int d1) {
    yy = (short)y1; mm = (short)m1; dd = (short)d1;
    YY = (short)((int)yy % 100);
    CC = (short)((int)yy - (int)YY);
  }
  /*------------------------------------------------------------------*/
  snDate(snDate d) {
    yy = d.yy; mm = d.mm; dd = d.dd;
    YY = (short)((int)yy % 100);
    CC = (short)((int)yy - (int)YY);
  }
  /*------------------------------------------------------------------*/
  snDate (long jd) {
    long a, l, y, m, d;
    y = (long)(jd / 365.25);
    a = y / 100;
    jd -= (365*y + y/4 + 2 - a + a/4);
    m = (long)((jd / 30.6f) - 1);
    l = (long)(30.6f * (float)(m + 1));
    jd -= l;
    d = jd;
    yy = (short)y; mm = (short)m; dd = (short)d;
    YY = (short)((int)yy % 100);
    CC = (short)((int)yy - (int)YY);
  }
  /*------------------------------------------------------------------*/
  public String dmy() {
    return(dd + "/" + mm + "/" + yy);
  }
  /*------------------------------------------------------------------*/
  public String ymd() {
    return(yy + " Yrs " + mm + " mths " + dd + " days");
  }
  /*------------------------------------------------------------------*/
  public double years() {
    return ((double)yy + ((double)mm + (double)dd / 30.0) / 12.0);
  }
  /*------------------------------------------------------------------*/
  public static long jd (long d, long m, long y) {
    long a, j, l;
    float b;
    if (m < 3) {
      m += 12;
      y--;
    }
    a = y/100;
    b = 30.6f * (float)(m+1);
    l = (long)b;
    j = 365 * y + y/4 + l + 2 - a + a/4 + d;
    return (j);
  }
  /*------------------------------------------------------------------*/
  public static long datediff (snDate d1, snDate d2) {
    long ld1, ld2;
    ld1 = jd(d1.dd, d1.mm, d1.yy);
    ld2 = jd(d2.dd, d2.mm, d2.yy);
    return (ld1 - ld2);
  }
  /*------------------------------------------------------------------*/
  public static snDate dateDiff (snDate d1, snDate d2) {
    snDate x = new snDate(d1);
    long ld, xx;
    ld = datediff(d1, d2);
    //System.out.println(" Date Difference :--------->"+d1.dmy() +" "+ d2.dmy());
    x.yy = (short)(ld / 365);
    //ld = Math.abs(ld);
    xx = (Math.abs(ld) - Math.abs(x.yy)*365);
    x.mm = (short)(xx / 30);
    x.dd = (short)(xx - x.mm*30);
    if (x.dd >= 30) {
      x.dd = 0; x.mm++;
    }
    if (x.mm >= 12) {
      x.mm = 0; x.yy++;
    }
    //System.out.println(x.dmy());
    return (x);
    /*
    snDate x = new snDate(d1);
    x.yy -= d2.yy;
    x.mm -= d2.mm;
    if (x.mm < 0) { x.mm += 12;  x.yy--; }
    x.dd -= d2.dd;
    if (x.dd < 0) { x.dd += 30;  x.mm--; }
    return (x);
    */
  }
  /*------------------------------------------------------------------*/
  private static int Fix (double x) {
	  return (int)(long)(x);
  }
  /*------------------------------------------------------------------*/
  public static double day2000 (int year, int month, int day, int hour,
                               int min, double sec, double greg) {
	// Returns days before J 2000.0 given date in Gregorian calendar
	// (greg = 1) or Julian calendar (grep = 0)
	double a;
	int b;
	a = 10000.0 * year + 100.0 * month + day;
	if (month <= 2) {
	  month += 12;
	  year--;
    }
    if (greg == 0) {
		b = -2 + Fix((year + 4716)/4) - 1179;
    } else {
		b = Fix(year/400) - Fix(year/100) + Fix(year/4);
    }
    a = 365.0 * year - 730548.5;
    return (a + b + Fix(30.6001 * (month+1)) + day +
                      (hour + month/60.0 + sec/3600) / 24.0);
  }
  /*------------------------------------------------------------------*/
}

/*--------------------------------------------------------*/
class snTime {
  short hh;
  short mm;
  double ss;
  /*------------------------------------------------------------------*/
  snTime(short h1, short m1, double s1) {
     hh = h1; mm = m1; ss = s1;
  }
  /*------------------------------------------------------------------*/
  public String hms() {
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
/*--------------------------------------------------------*/
class snDasa {
  short  dasaLord;
  short  dasaYrs;
  snDate dasaEnd;
  short  nextDasaLord;
}
/*--------------------------------------------------------*/
class snExchange {
   String name;
   snDate age;
   String sex;
   String addr1;
   String addr2;
   String place;
   snDate dob;
   snTime tob;
   double timeZone;
   short  dow_No;
   String dow;
   short  dowHindu_No;
   String dowHindu;
   short  naksha;
   double tithi;
   short  karanam;
   short  yogam;
   short  paada;
   snDasa dasa[];
   //snDasa dasa_start[];
   int    div_1[];
   int    div_9[];
   //int    paapa0[];
   //int    paapa1[];
   //int    paapa2[];
   int    npaapFrom;
   int    npaapCnt;
   int    paapas[][];
   double chandra;
   double sunrise;
   double sunset;
   double sunriseA;
   double sunsetA;
   double longitude;
   double latitude;
   double ayanamsa;
   String snJatakFname;
   /*
   public void mkPaapArray() {
     int i, j;
     int[][] tpap = new int[npaapFrom][npaapCnt];
     paapas = new int[npaapFrom][npaapCnt];
     for (i = 0; i < npaapFrom; i++) {
       paapas[i] = new int[npaapCnt];
       for (j = 0; j < npaapCnt; j++) {
         switch (i) {
           case 0 : paapas[i][j] = paapa0[j]; break;
           case 1 : paapas[i][j] = paapa1[j]; break;
           case 2 : paapas[i][j] = paapa2[j]; break;
         }
       }
     }
   }
   */
   //private class snPaap {
   //  int paapaL[];
   //  int paapaC[];
   //  int paapaS[];
   //}
   /*
   snExchange (short npF, short npC) {
     int i, j;
     npaapFrom = npF;
     npaapCnt = npC;
     int[][] pap = new int[npF][npC];
     for (i=0; i < npF; i++) for (j=0; j < npC; j++) {
       pap[i] = new int;
     }
     paapas = pap;
   }
   */
   /*---------------------------------------------------------------*/
   public static String compressName (String s) {
     char ch;
     int k;
     String fname = "";
     s = s.trim();
     for (k = s.length()-1; k >= 0; k--) {
       ch = s.charAt(k);
       if (ch == ' ' || ch == '\t') ch = '_';
       fname = ch + fname;
     }
     //System.out.println(fname);
     return (fname);
   }
   /*---------------------------------------------------------------*/
   public static String insertDirName (String s, String ins) {
     int k;
     char ch, slash = '/';
     String fname = "", path = "";
     for (k = s.length()-1; k >= 0; k--) {
       ch = s.charAt(k);
       if (ch == '/' || ch == '\\') {
         slash = ch;
         break;
       } else if (ch == ':') break;
       fname = ch + fname;
     }
     //System.out.println("fname="+fname);
     for (; k >= 0; k--) {
       ch = s.charAt(k);
       path = ch + path;
     }
     //System.out.println("Path="+path);
     path = path + ins;
     //System.out.println(path);
     try {
       File f = new File(path);  f.mkdir();
     } catch (SecurityException se) {
       System.out.println(" Dir creation error : " + path);
     }
     //System.out.println(path + slash + fname);
     return (path + slash + fname);
   }
   /*---------------------------------------------------------------*/
   public static String gn () {
       String ss=" Jyotisha Sarathi Suresh P. Nambiar";
       /*
       char[] s1 = new char[20];
       s1 = ss.toCharArray();
       //for (int i=0; i<ss.length(); i++) s1[i] = s1[ss.length()-i-1];
       s1[ss.length()] = '\0';
       ss = s1.toString();
       */
       return (ss);
     }
   /*------------------------------------------------------------------*/
     public static short bhaavaDiff(int kp, int ks) {
       return (short)(((kp - ks +  12) % 12) + 1);
     }
   /*------------------------------------------------------------------*/
}
/*--------------------------------------------------------*/
class snRiseSet {
  static final double PI = 3.1415926535897932384626433832795d;
  static final double radians = PI / 180.0;
  static final double degrees = 180.0 / PI;
  /*------------------------------------------------------------------*/
  private static double range360(double x) {
    long xy;
    xy = (long)(x / 360.0);
    return (x - xy * 360.0);
  }
  /*------------------------------------------------------------------*/
  public static double snRiseSet (double day, double glat,
     			double glong, int index, double altitude) {
	//------------- index indicates whether Rise = 1 or Set = 2 ------------
    double sinalt, gha, lambda, delta, t, c, days, utold, utnew;
    double sinphi, cosphi, L, G, E, obl, signt, act;
    // Altitude values are : Astronomical)-18.0);
    // Nautical(-12.0)		Civil (-6.0)		Sun (-0.833)
    if (altitude == 0.0) altitude = -0.833;
    utold = 180.0;  // initial value finds first position @12h UT on day
    utnew = 0.0;
    sinalt = Math.sin(altitude * radians);
    sinphi = Math.sin(glat * radians);
    cosphi = Math.cos(glat * radians);
    signt = (index == 1 ? 1.0 : -1.0);
    while (Math.abs(utold - utnew) > 0.1) {
      utold = utnew;
      days = day + utold / 360.0; // Update args of Sun's position
      t = days / 36525;
      // Find Sun's co-ordinates
      L = range360(280.46 + 36000.77 * t);
      G = 357.528 + 35999.05 * t;
      G *= radians;
      lambda = L + 1.915 * Math.sin(G) +
                   0.02 * Math.sin(2 * G);
      lambda *= radians;
      E = -1.915 * Math.sin(G) - 0.02 * Math.sin(2*G)
              + 2.466 * Math.sin(2*lambda) - 0.053 * Math.sin(4*lambda);
      obl = 23.4393 - 0.13 * t;
      //System.out.println("Obliquity===>"+DMS.dms(obl));
      obl *= radians;
      // Update the hour angle and declination of sun
      gha = utold - 180.0 + E;
      delta = Math.asin(Math.sin(obl) * Math.sin(lambda));
      // Calculate correction term for this loop
      c = (sinalt - sinphi * Math.sin(delta)) / (cosphi * Math.cos(delta));
      act = Math.acos(c);
      act *= degrees;
      //System.out.println("Act = " + DMS.dms(act));
      if (c > 1) act = 0.0;
      if (c < -1) act = 180.0;
      // Find the newly corrected ut for sunrise/set
      utnew = range360(utold - (gha + glong + signt * act));
      //System.out.println("UTnew = " + utnew + " UT Old = " + utold+ " sign = "+signt);
    }
    return (utnew / 15.0);
  }
  /*------------------------------------------------------------------*/
}
/*--------------------------------------------------------*/
