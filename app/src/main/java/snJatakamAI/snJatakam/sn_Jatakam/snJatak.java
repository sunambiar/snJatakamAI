package snJatakamAI.snJatakam.sn_Jatakam;

/*---------------------------------------------------------------*/
//package snJatakam;
//package sn_Jatak;
//import snJatakam.*;
//import java.io.*;
import java.io.DataInputStream;
//import java.io.snPrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.text.DecimalFormat;
//import java.util.*;
//import java.lang.*;

import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snVarsJ;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snExchange;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.snDate;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.snTime;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.snBasicDetls;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.DMS;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snDasa;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snIOglobalSetting;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snIO.snPrintWriter;

/*---------------------------------------------------------------*/
 /*---------------------------------------------------
        Suresh's Horoscope
-----------------------------------------------------*/
//#define TRUE 1
public class snJatak {

  static final int nplnt = 13;  // Including Gulika(Maandi)
  static final int nrasi = 12;  // No. of Rasis
  static final String sTDc = "<TD align=center>";
  static final String sTDj = "<TD align=justify>";
  static final String sTDTDc = "</TD>" + sTDc;
  static final String sTDTDj = "</TD>" + sTDj;
  static double[][] plnt = new double[3][nplnt + 1];
  static double[] jupc = new double[4],
      satc = new double[4], tt = new double[4],
      f2 = new double[nplnt], f3 = new double[nplnt];
  static double ps, pt, z2, b6, s1, lat, longt;
  static double timeZone = +5.5;
  static double ayanamsa, obliq, sidtime, h6, lahiri_ayan;
  static double nakshatra, tithi, yoga;
  static short karanam, yogam;
  static short paadaValue;
  String place;
  static snVarsJ V = new snVarsJ();
  snDasa[] dasa_end = new snDasa[nplnt];  //, dasa_start = new snDasa[nplnt];
  int cnt_dasaend;
  snExchange snE = new snExchange();
  static final int npaapFrom = 3;
  static final int npaapCnt = 7;
  int[][] paapCount = new int[npaapFrom][npaapCnt];
  // [][3]-Total & [][6]-GrandTotal
  static int ret, page, line;
  static int[] r3 = new int[nrasi + 1], s3 = new int[nrasi + 1];
  static int saptvarg_sz = 10;
  static int[][] varga = new int[nplnt + 1][saptvarg_sz];
  static String sOMKaar = "<H5>" + (char) (92) + "</H5>";
  static String name, sex;
  static int ayana_opt;
  static final String ayana_opts[] = {"N.C.Lahiri", "B.V.Raman",
    "Chandra Hari", "User specified"};
  static double tob, sun_riseA, sun_setA;  ////, sun_rise, sun_set;
  static char outOpt, outType;
  static snPrintWriter pS;
  //static snPrintWriter pW;
  static boolean html, argsPassed;
  static boolean chandraHariAyana;
  static DMS dms = new DMS(false);

  /*---------------------------------------------------------------*/
  private static double round(double x, int dec) {
    double deci;
    deci = (double) Math.pow(10, dec);
    return ((double) Math.round(x * deci) / deci);
  }

  /*---------------------------------------------------------------*/
  public static void main(String[] args) {
    snJatak snJtk = new snJatak(args);
  }

  /*---------------------------------------------------------------*/
 /*
     private static double lagnam_New (double sb6, double sh6) {
	    double radians, degrees;
        double a0, b0, c0, ssidtime;
        double sS, oblq;
        double xo, xm, xs, xl;
        //oblq = (23.0 + (26.0 + (17.0/60.0))/60.0);
        //oblq = (23.0 + (26.0 / 60.0));
        //oblq = (23.0 + (26.0 + (50.0/60.0))/60.0);
        //xo = oblq * radians;

        oblq = 23.452294 - 0.0130125*sb6;
        oblq += 0.00426 * Math.cos(plnt[2][8] * z2); /// Sayana Rahu
        xo = oblq;

        a0 = 24.0 * fract(0.2769 + 100.00214*sb6);
        b0 = sh6 * 24.0 + 12.0;
        c0 = longt / 15.0;
        ssidtime = 24.0 * fract((a0 + b0 + c0) / 24.0);
        if (ssidtime < 0) ssidtime += 24.0;

        radians = z2;
        degrees = 1.0 / z2;

        xm = ssidtime * 15.0;
        xs = xm * V.PI / 12.0;
        xl = lat * radians;
        sS = (Math.cos(xo) * Math.tan(xs));
        sS += (Math.sin(xo) * Math.tan(xl) / Math.cos(xs));
        sS = Math.atan(sS);
        sS = sS * degrees;
        if (sS >= 360.0) sS -= 360.0;
        if (sS < 0.0) sS += 360.0;
        if (xm >= 270.0 && xm < 90.0) sS += 90.0;
        else if (xm >=90.0 && xm < 270.0) sS += 270.0;
        sS -= ayanamsa;
        if (sS >= 360.0) sS -= 360.0;
        if (sS < 0.0) sS += 360.0;
        return (sS);
	 }
   */
 /*---------------------------------------------------------------*/
  private static double lagnam(double sb6, double sh6) {
    double a0, b0, c0;
    double sobliq, ssidtime;
    //ayanamsa = plnt[0][0];
    sobliq = 23.452294 - 0.0130125 * sb6;
    sobliq += 0.00426 * Math.cos(plnt[2][8] * z2); /// Sayana Rahu
    a0 = 24.0 * fract(0.2769 + 100.00214 * sb6);
    b0 = sh6 * 24.0 + 12.0;
    c0 = longt / 15.0;
    ssidtime = 24.0 * fract((a0 + b0 + c0) / 24.0);
    if (ssidtime < 0.0) {
      ssidtime += 24.0;
    }
    /*
       pS.println("Ayanamsa="+ayanamsa + " lat="+DMS.dms(lat) +
          " Sidtime="+ssidtime + " Obliquity="+sobliq + " Actual="+obliq);
     */
    //System.out.println("Sayana Rahu="+plnt[2][8]);
    a0 = bhavspl(sobliq, ssidtime, lat);
    return (a0);
  }

  /*---------------------------------------------------------------*/
  private static double getHour(double sphutam, double ad,
      long d, long m, long y) {
    double hr, sb6, sh6, sphutnew, time_diff, sphutnxtday, fullcircle;
    double prevhr, ghr, deg_diff, one_sec, ayan_diff;
    int kkk, iter = 0;
    long j;
    one_sec = 1.0 / 3600.0;
    ayan_diff = lahiri_ayan - ayanamsa;
    j = jd(d, m, y);
    //hr = 12.00;
    hr = tob;
    sh6 = (hr - timeZone - 12.0) / 24.0;
    sb6 = (j - 694025 + sh6) / 36525.0;
    sphutam = sun(sb6) + ayan_diff;
    //System.out.println("Ayana Diff=" + DMS.dms(ayan_diff));
    hr = 6.0 + ad / 360.0 * 24.0;
    prevhr = 12.00;
    ghr = 0.0;
    deg_diff = 0;
    //if (ad != 0) {
    /*
	     if (srise <= 0) {
		   hr = getHour(sphutam,0,d,m,y);
	     }
     */
    sh6 = (hr - timeZone - 12.0) / 24.0;
    sb6 = (j - 694025 + sh6) / 36525.0;
    sphutnew = sun(sb6) + ayan_diff;
    //System.out.println(" Soorya Sphutam for getting Hour="+sphutnew);
    sphutnxtday = sun(sb6 + 1.0 / 36525.0) + ayan_diff;
    if (sphutnxtday < sphutnew) {
      sphutnxtday += 360.0;
    }
    deg_diff = (sphutnxtday - sphutnew) * ad / 360.0;
    //sphutam += deg_diff + ad;
    sphutam += ad;
    fullcircle = (360.0 + deg_diff);
    //}
    if ((sphutam) > 360.0) {
      sphutam -= 360.0;
    } else if ((sphutam) < 0.0) {
      sphutam += 360.0;
    }
    //pS.println("Sun-sphutam = "+sphutam);
    //pS.println("sphutam="+(sphutam+ad)+" hour="+hr+ " j="+j);
    //pS.println(" Lagna sphutam = " + lagnam(b6, h6));
    //pS.println(" Lagna sphutam () " + lagnam());
    //pS.println(" Lagna sphutam = " + lagnam(b6, h6));
    sh6 = (hr - timeZone - 12.0) / 24.0;
    sb6 = (j - 694025 + sh6) / 36525.0;
    sphutnew = lagnam(sb6, sh6);
    if (sphutnew >= 360.0) {
      sphutnew -= 360.0;
    } else if (sphutnew < 0.0) {
      sphutnew += 360.0;
    }
    for (kkk = 0; kkk < 15 && Math.abs(sphutnew - sphutam) > one_sec; kkk++) {
      do {
        sh6 = (hr - timeZone - 12.0) / 24.0;
        sb6 = (j - 694025 + sh6) / 36525.0;
        sphutnew = lagnam(sb6, sh6);
        if (sphutnew >= 360.0) {
          sphutnew -= 360.0;
        } else if (sphutnew < 0.0) {
          sphutnew += 360.0;
        }
        //System.out.println(" New Lagnam = "+sphutnew+" for Hr="+HMS.hms(hr));
        //sphutnxtday = lagnam((sb6 + 1.0/36525.0),sh6);
        //if (sphutnxtday >= 360.0) sphutnxtday -= 360.0;
        //if (sphutnxtday < sphutnew) sphutnxtday += 360.0;
        //fullcircle = sphutnxtday - sphutnew + 360.0;
        //fullcircle = (360.0 + deg_diff);
        //System.out.println("Sphut=" + sphutnew + " nxtday="+sphutnxtday+
        //    " Fullcircle="+fullcircle);
        //sphutnxtday = (sphutam < sphutnew) ? 360.0 : 0.0;
        //time_diff = ((sphutam + sphutnxtday) - sphutnew) * 24.0 / fullcircle;
        time_diff = ((sphutam) - sphutnew) * 24.0 / fullcircle;
        //time_diff = ((sphutam+ad+ad/fullcircle) - sphutnew) * 24.0/fullcircle;
        //if (time_diff > 12.0) time_diff -= 24.0;
        //time_diff = ((sphutam+ad*fullcircle/360.0) - sphutnew) * 24.0/fullcircle;
        if (time_diff >= 24.0) {
          time_diff -= 24.0;
        }
        if (time_diff <= -24.0) {
          time_diff += 24.0;
        }
        //if (time_diff > 12.0) time_diff -= 24.0;
        hr += time_diff;
        if (hr >= 24.0) {
          hr -= 24;
        }
        if (hr < 0.0) {
          hr += 24;
        }
        //System.out.println("kkk="+kkk+" sphutnew="+sphutnew+" timediff="+time_diff+
        //    " hour="+hr);
        //System.out.println("sphutnew="+sphutnew+" sphutam="+(sphutam));
        iter++;
        //ghr += hr;
        //hr = (ghr / (double)iter);
        //System.out.println("Hour = "+hr+" ghr=" +ghr+" iter="+iter);
        if (iter > 3) {
          hr = (hr + prevhr) / 2.0;
          iter = 1;
          //ghr = hr;
          if (Math.abs(hr - prevhr) < 0.5) {
            //hr = Math.round(hr * 60.0 * 60.0) / 60.0 / 60.0;
            sh6 = (hr - timeZone - 12.0) / 24.0;
            sb6 = (j - 694025 + sh6) / 36525.0;
            sphutam = sun(sb6) + ayan_diff; //Correction
            sphutam += ad;
            if (sphutam >= 360.0) {
              sphutam -= 360.0;
            }
            if (sphutam < 0.0) {
              sphutam += 360.0;
            }
          }
        }
        prevhr = hr;
        //System.out.println("sphutam->sun=" +DMS.dms(sb6) +" " + plnt[0][1]);
      } while (Math.abs(time_diff) > 0.000000001d);
      hr = Math.round(hr * 3600.0) / 3600.0;
      sh6 = (hr - timeZone - 12.0) / 24.0;
      sb6 = (j - 694025 + sh6) / 36525.0;
      sphutam = sun(sb6) + ayan_diff;
      //sphutam += deg_diff + ad;
      sphutam += ad;
      if (sphutam >= 360.0) {
        sphutam -= 360.0;
      } else if (sphutam < 0.0) {
        sphutam += 360.0;
      }
      //sh6 = (hr - timeZone - 12.0) / 24.0;
      //sb6 = (j - 694025 + sh6) / 36525.0;
      sphutnew = lagnam(sb6, sh6);
      if (sphutnew >= 360.0) {
        sphutnew -= 360.0;
      } else if (sphutnew < 0.0) {
        sphutnew += 360.0;
      }
      //System.out.println("FOR Hr="+HMS.hms(hr)+" sphutnew="+sphutnew+
      //    " ("+DMS.dms(sphutnew)+")  sphutam="+sphutam+" ("+DMS.dms(sphutam)+")");
    }
    /*
       System.out.println("Hr="+hr+" Sun"+"="+sphutam+" Lagnam="+sphutnew);
       System.out.println(" Sun-Rise/Set="+HMS.hms(hr));
     */
    return (hr);
  }

  /*---------------------------------------------------------------*/
  private static long jd(long d, long m, long y) {
    long a, j, l;
    float b;
    if (m < 3) {
      m += 12;
      y--;
    }
    a = y / 100;
    b = 30.6f * (float) (m + 1);
    l = (long) b;
    j = 365 * y + y / 4 + l + 2 - a + a / 4 + d;
    return (j);
  }

  /*---------------------------------------------------------------*/
  private static double jd2000(long y, long m, long d, long h, long mt, double s) {

    return (snDate.JD(y, m, d, h, mt, s));
    //return (snDate.day2000(y,m,d,0,0,0.0,0));
  }

  /*---------------------------------------------------------------*/
  private static double precessionArc(double jd1, double jd2) {
    double pArc = 0.0, t_period = 0.0, Tperiod = 0.0;
    double jd2000 = 2451545.0;
    t_period = ((double) (jd2 - jd1)) / 36525.0;
    Tperiod = ((double) (jd1 - jd2000)) / 36525.0;
    //System.out.println(" JD2000 = " + jd2000 + " Calc=" + jd2000(2000,1,1,12,0,0));
    pArc = (5029.0966 + 2.22226 * Tperiod - 0.000042 * Tperiod * Tperiod);
    pArc = pArc * t_period;
    pArc = pArc + (1.11161 - 0.000127 * Tperiod) * t_period * t_period;
    pArc = pArc - 0.000113 * t_period * t_period * t_period;
    return (pArc / 60.0 / 60.0);
  }

  /*---------------------------------------------------------------*/
  private static double chandraHari_Ayana(long y, long m, long d,
      long h, long mt, double s) {
    double jd1 = jd2000(231, 3, 21, 15, 30, 0.0);//Spring Equinox of 231 A.D. = 0 Ayanamsa
    double jd2 = jd2000(y, m, d, h, mt, s);
    //System.out.println("JD231 = " + jd1 + " Required for "+jd2);
    return (precessionArc(jd1, jd2));
  }

  /*---------------------------------------------------------------*/
  private static double fract(double x) {
    long i;
    double y;
    i = (long) x;
    y = x - i;
    return y;
  }

  /*---------------------------------------------------------------*/
  private static double fabs(double x) {
    return ((x < 0) ? -x : x);     // Math.abs(x);
  }

  /*---------------------------------------------------------------*/
  private static void init() {
    double v0, p0, q0, s0, c0, z0, v1, v2, v3, v4, v5;
    double y1, y2, y3, y4, y5, y6;
    double q1, q2, q3, q4, q5, q6, w2;
    double r1, r2, r3, r4, s1, s2, s3, s4;

    v0 = b6 / 5 + 0.1;
    p0 = 2 * V.PI * fract(0.65965 + 8.43029 * b6);
    q0 = 2 * V.PI * fract(0.73866 + 3.39476 * b6);
    s0 = 2 * V.PI * fract(0.67644 + 1.19019 * b6);
    v1 = 5 * q0 - 2 * p0;
    c0 = s0 - q0;
    z0 = q0 - p0;
    v2 = Math.sin(v1);
    v3 = Math.sin(2 * v1);
    v4 = Math.cos(v1);
    v5 = Math.cos(2 * v1);
    y1 = Math.sin(z0);
    y2 = Math.sin(2 * z0);
    y3 = Math.sin(3 * z0);
    y4 = Math.cos(z0);
    y5 = Math.cos(2 * z0);
    y6 = Math.cos(3 * z0);
    q1 = Math.sin(q0);
    q2 = Math.sin(2 * q0);
    q3 = Math.sin(3 * q0);
    q4 = Math.cos(q0);
    q5 = Math.cos(2 * q0);
    q6 = Math.cos(3 * q0);
    w2 = Math.sin(3 * c0);
    r1 = (0.331 - 0.01 * v0) * v2 - 0.064 * v0 * v4 + 0.014 * y1;
    r1 += 0.018 * y2 - 0.034 * y4 * q1 - 0.036 * y1 * q4;
    r2 = 0.007 * v2 - 0.02 * v4 + q1 * (0.007 * y1 + 0.034 * y4 + 0.006 * y5);
    r2 += q2 * (-0.005 * y1 + 0.004 * y4) + q5 * (0.004 * y1 + 0.006 * y4);
    r3 = 3606 * v2 + (1289 - 580 * v0) * v4 + q1 * (-6764 * y1 - 1110 * y2 - 204 + 1284 * y4);
    r3 += q4 * (1460 * y1 - 817 + 6074 * y4 + 992 * y5 + 508 * y6);
    r3 += q2 * (-956 * y1 - 997 * y4 + 480 * y5);
    r3 += q5 * (-956 * y1 + 490 * y2 + 179 + 1024 * y4 - 437 * y5);
    r3 *= 1e-7;
    r4 = -263 * v4 + 205 * y4 + 693 * y5 + 312 * y6;
    r4 += q1 * (299 * y1 + 181 * y5) + q4 * (204 * y2 + 111 * y3 - 337 * y4 - 111 * y5);
    r4 *= 1e-6;
    s1 = (-0.814 + 0.018 * v0 - 0.017 * v0 * v0) * v2;
    s1 += (-0.01 + 0.161 * v0) * v4 - 0.149 * y1 - 0.041 * y2 - 0.015 * y3;
    s1 += q1 * (-0.006 - 0.017 * y2 + 0.081 * y4 + 0.015 * y5);
    s1 += q4 * (0.086 * y1 + 0.025 * y4 + 0.014 * y5 + 0.006 * y6);
    s2 = (0.077 + 0.007 * v0) * v2 + (0.046 - 0.015 * v0) * v4 - 0.007 * y1;
    s2 -= q1 * (0.076 * y1 + 0.025 * y2 + 0.009 * y3);
    s2 += q4 * (-0.073 - 0.15 * y4 + 0.027 * y5 + 0.01 * y6);
    s2 += q6 * (-0.014 * y1 - 0.008 * y4 + 0.014 * y5);
    s2 += q5 * (-0.014 * y1 + 0.012 * y2 + 0.015 * y4 - 0.013 * y5);
    s3 = (-7927 + 2548 * v0) * v2 + (13381 + 1226 * v0) * v4;
    s3 += 248 * v3 - 305 * v5 + 412 * y2;
    s3 += q1 * (12415 + (390 - 617 * v0) * y1 + 26599 * y4 - 4687 * y5
        - 1870 * y6 - 821 * Math.cos(4 * z0));
    s3 += q4 * (163 - 611 * v0 - 12696 * y1 - 4200 * y2 - 1503 * y3
        - 619 * Math.sin(4 * z0) - (282 + 1306 * v0) * y4);
    s3 += q2 * (-350 + 2211 * y1 - 2208 * y2 - 568 * y3 - 2780 * y4 + 2022 * y5);
    s3 += q5 * (-490 - 2842 * y1 - 1594 * y4 + 2162 * y5 + 561 * y6 + 469 * w2);
    s3 *= 1e-7;
    s4 = 572 * v2 + 2933 * v4 + 33629 * y4 - 3081 * y5 - 1423 * y6 - 671 * Math.cos(4 * z0);
    s4 += q1 * (1098 - 2812 * y1 + 688 * y2 - 393 * y3 + 2138 * y4 - 999 * y5 - 642 * y6);
    s4 += q4 * (-890 + 2206 * y1 - 1590 * y2 - 647 * y3 + 2285 * y4 + 2172 * y5 + 296 * y6);
    s4 += q2 * (-267 * y2 - 778 * y4 + 495 * y5 + 250 * y6);
    s4 += q5 * (-856 * y1 + 441 * y2 + 296 * y5 + 211 * y6);
    s4 += q3 * (-427 * y1 + 398 * y3) + q6 * (344 * y4 - 427 * y6);
    s4 *= 1e-6;

    jupc[0] = r1;
    jupc[1] = r2;
    jupc[2] = r3;
    jupc[3] = r4;
    satc[0] = s1;
    satc[1] = s2;
    satc[2] = s3;
    satc[3] = s4;

  }

  /*---------------------------------------------------------------*/
  private static double setSayana(double aya_val) {
    for (int i = 1; i <= nplnt; i++) {
      plnt[2][i] = plnt[0][i] + aya_val;  // Sayana
      if (plnt[2][i] < 0.0) {
        plnt[2][i] += 360.0;
      }
      if (plnt[2][i] >= 360.0) {
        plnt[2][i] -= 360.0;
      }
      plnt[1][i] = plnt[1][i] + aya_val;  // Sayana
      if (plnt[1][i] < 0.0) {
        plnt[1][i] += 360.0;
      }
      if (plnt[1][i] >= 360.0) {
        plnt[1][i] -= 360.0;
      }
      //System.out.println("i="+i+" plnt="+plnt[2][i]);
    }
    plnt[2][0] = 0.0;
    return (aya_val);
  }

  /*---------------------------------------------------------------*/
  private static double applyAyan(double aya_val) {
    for (int i = 1; i < nplnt; i++) {
      plnt[0][i] = plnt[2][i] - aya_val;  // Nirayana = Sayana - ayana
      if (plnt[0][i] < 0.0) {
        plnt[0][i] += 360.0;
      }
      if (plnt[0][i] > 360.0) {
        plnt[0][i] -= 360.0;
      }
    }
    plnt[0][0] = aya_val;
    return (aya_val);
  }

  /*---------------------------------------------------------------*/
  private static double ayan(int ayan_opt,
      long y, long m, long d, long h, long mt, double s, double aya_val) {
    double ret = 0;
    chandraHariAyana = false;
    switch (ayan_opt) {
      case 1:
        ret = 21.013972 + 1.398191 * b6;  /// BVRaman
        break;
      case 2:
        /*
                   double dob, basedt, nyrs;
                   //basedt = jd(21, 3, 238);
                   basedt = jd(21, 3, 240);
                   dob = jd(d, m, y);
                   nyrs = (dob - basedt) / 365.24219;
                   //pS.println(" dob = "+ dob + " basedt="+basedt +
                   //    " Years = " + nyrs);
                   //ret = nyrs * 120.0 / 8586.0;
                   ret = nyrs * 240.0 / 17181.0;
                   //plnt[0][0] = 120.0 / 8586.0 * (year - 238); //Chandra Hari
                   System.out.println("ChandraHari Ayana using 240AD = " + DMS.dms(ret));
         */
        ret = chandraHari_Ayana(y, m, d, h, mt, s);
        //System.out.println("ChandraHari Ayana using Precsn Arc="+DMS.dms(ret));
        chandraHariAyana = true;
        break;
      case 3:
        ret = aya_val;   // User specified
        break;
      default:
        ret = 22.460148 + 1.396042 * b6 + 3.08e-4 * b6 * b6;
        break;     // NCLahiri
    }
    return (ret);
  }

  /*---------------------------------------------------------------*/
  private static double lat_planet(double obl, double decl,
      double rtasc, int pno) {
    double po, pd, pr, res = 0.0;
    po = obl * z2;
    pd = decl * z2;
    pr = rtasc * z2;
    res = Math.cos(po) * Math.sin(pd)
        - Math.sin(po) * Math.cos(pd) * Math.sin(pr);
    res = Math.asin(res) / z2;
    if (res < 0.0) {
      res += 360.0;
    }
    if (res >= 360.0) {
      res -= 360.0;
    }
    return (res);
  }

  /*---------------------------------------------------------------/
     private static double long_planet (double obl, double decl,
                           double rtasc, int pno) {
		double po, pd, pr, res = 0.0;
		po = obl * z2;
		pd = decl * z2;
		pr = rtasc * z2;
		res = (Math.sin(po) * Math.tan(pd) +
		            Math.cos(po) * Math.sin(pr)) / Math.cos(pr);
		res = Math.atan(res) / z2;
		if (res < 0.0) res += 360.0;
		if (res >= 360.0) res -= 360.0;
		return (res);
     }
     /---------------------------------------------------------------*/
  private static double long_planet(double pg, double ph, double pp,
      double pe, double pq, double pa, int pno) {
    double pm, pb, pf, pc, pd, pr, e1, e2, e3, e4;
    double v1, pv, pj, pk, pl, px, py;
    pm = pg - ph;
    if (pm < 0) {
      pm += 360.0;
    }
    pb = pm * z2;
    pf = pb + pe * Math.sin(pb);
    do {
      pc = pf - pe * Math.sin(pf) - pb;
      pd = 1 - pe * Math.cos(pf);
      pf = pf - pc / pd;
    } while (fabs(pc / pd) > 0.01);
    pr = pa * (1 - pe * Math.cos(pf));
    e1 = Math.atan(pe / Math.sqrt(1 - pe * pe));
    e2 = V.PI / 4 - e1 / 2;
    e3 = Math.tan(e2);
    e4 = Math.tan(pf / 2);
    v1 = Math.atan(e4 / e3);
    if (v1 < 0.0) {
      v1 += V.PI;
    }
    pv = 2 * v1;
    pc = ph * z2;
    pd = pp * z2;
    pb = pq * z2;
    pj = pv + pc;
    pk = pj - pd;
    pl = 1.0 - Math.cos(pb);
    px = (Math.cos(pj) + Math.sin(pk) * Math.sin(pd) * pl) * pr;
    py = (Math.sin(pj) - Math.sin(pk) * Math.cos(pd) * pl) * pr;
    if (pno == 1) {
      ps = px;
      pt = py;
    }
    pc = ps + px;
    pd = pt + py;
    pm = Math.atan(pd / pc) / z2;
    if (pc < 0.0) {
      pm += 180.0;
    } else if (pd < 0.0) {
      pm += 360.0;
    }
    while (pm < 0.0) {
      pm += 360.0;
    }
    return (pm);
  }

  /*---------------------------------------------------------------*/
  private static double sun(double sb6) {
    double g0, h0, p0, e0, q0, a0;
    //int pno;
    g0 = 360 * fract(0.71455 + 99.99826 * sb6);
    h0 = 258.76 + 0.323 * sb6;
    p0 = 0.0;
    e0 = 0.016751 - 0.000042 * sb6;
    q0 = 0.0;
    a0 = 1.0;
    //pno = 1;
    //return (long_planet(g0,h0,p0,e0,q0,a0,pno));
    return (long_planet(g0, h0, p0, e0, q0, a0, 1));
  }

  /*---------------------------------------------------------------*/
  private static void sun() {
    plnt[ret][1] = sun(b6);
    //System.out.println(" Soorya Sphutam = "+plnt[0][1] + " for Hr="+tob+" "+HMS.hms(tob));
  }

  /*---------------------------------------------------------------*/
  private static void mer() {
    double g0, h0, p0, e0, q0, a0;
    int pno;
    g0 = 360 * fract(0.43255 + 415.20187 * b6);
    h0 = 53.44 + 0.159 * b6;
    p0 = 24.69 - 0.211 * b6;
    e0 = 0.205614 + 0.00002 * b6;
    q0 = 7.00288 + 0.001861 * b6;
    a0 = 0.3871;
    pno = 2;
    plnt[ret][pno] = long_planet(g0, h0, p0, e0, q0, a0, pno);
    /*
       if (ret == 0) {
         plnt[pno] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       } else {
         plnt[pno+nplnt+1] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       }
     */
  }

  /*---------------------------------------------------------------*/
  private static void ven() {
    double g0, h0, p0, e0, q0, a0;
    int pno;
    g0 = 360 * fract(0.88974 + 162.54949 * b6);
    h0 = 107.70 + 0.012 * b6;
    p0 = 53.22 - 0.496 * b6;
    e0 = 0.006820 - 0.000048 * b6;
    q0 = 3.39363 + 0.001 * b6;
    a0 = 0.72333;
    pno = 3;
    plnt[ret][pno] = long_planet(g0, h0, p0, e0, q0, a0, pno);
    /*
       if (ret == 0) {
         plnt[pno] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       } else {
         plnt[pno+nplnt+1] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       }
     */
  }

  /*---------------------------------------------------------------*/
  private static void mars() {
    double g0, h0, p0, e0, q0, a0;
    int pno;
    g0 = 360 * fract(0.75358 + 53.16751 * b6);
    h0 = 311.76 + 0.445 * b6;
    p0 = 26.33 - 0.625 * b6;
    e0 = 0.093313 - 0.000092 * b6;
    q0 = 1.850333 - 0.000675 * b6;
    a0 = 1.5237;
    pno = 4;
    plnt[ret][pno] = long_planet(g0, h0, p0, e0, q0, a0, pno);
    /*
       if (ret == 0) {
         plnt[pno] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       } else {
         plnt[pno+nplnt+1] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       }
     */
  }

  /*---------------------------------------------------------------*/
  private static void jup() {
    double g0, h0, p0, e0, q0, a0;
    int pno;
    g0 = 360 * fract(0.59886 + 8.43029 * b6) + jupc[0];
    e0 = 0.048335 - 0.000164 * b6 + jupc[2];
    h0 = 350.26 + 0.214 * b6 + jupc[1] / e0;
    p0 = 76.98 - 0.386 * b6;
    q0 = 1.308376 - 0.005696 * b6;
    a0 = 5.2026 + jupc[3];
    pno = 5;
    plnt[ret][pno] = long_planet(g0, h0, p0, e0, q0, a0, pno);
    /*
       if (ret == 0) {
         plnt[pno] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       } else {
         plnt[pno+nplnt+1] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       }
     */
  }

  /*---------------------------------------------------------------*/
  private static void sat() {
    double g0, h0, p0, e0, q0, a0;
    int pno;
    g0 = 360 * fract(0.67807 + 3.39476 * b6) + satc[0];
    e0 = 0.055892 - 0.000346 * b6 + satc[2];
    h0 = 68.64 + 0.562 * b6 + satc[1] / e0;
    p0 = 90.33 - 0.523 * b6;
    q0 = 2.492520 - 0.003920 * b6;
    a0 = 9.5547 + satc[3];
    pno = 6;
    plnt[ret][pno] = long_planet(g0, h0, p0, e0, q0, a0, pno);
    /*
       if (ret == 0) {
         plnt[pno] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       } else {
         plnt[pno+nplnt+1] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       }
     */
  }

  /*---------------------------------------------------------------*/
  private static void moon() {
    double g1, h1, a0, b0, c0, g0, e0, d0, f0, l0;
    double r0, d3, d4, d5;
    g1 = 360 * fract(0.71455 + 99.99826 * b6);
    h1 = 258.76 + 0.323 * b6;
    a0 = 360 * fract(0.68882 + 1336.851353 * b6);
    b0 = 360 * fract(0.8663 + 11.298994 * b6 - 3.0e-5 * b6 * b6);
    c0 = 360 * fract(0.65756 - 5.376495 * b6);
    if (c0 < 0.0) {
      c0 += 360.0;
    }
    g0 = z2 * (a0 - b0);
    e0 = z2 * (g1 - h1);
    d0 = z2 * (a0 - g1);
    f0 = z2 * (a0 - c0);
    l0 = a0 + 6.2888 * Math.sin(g0) + 0.2136 * Math.sin(2 * g0);
    l0 += 0.01 * Math.sin(3 * g0) + 1.274 * Math.sin(2 * d0 - g0);
    l0 += 0.0085 * Math.sin(4 * d0 - 2 * g0) - 0.0347 * Math.sin(d0);
    l0 += 0.6583 * Math.sin(2 * d0) + 0.0039 * Math.sin(4 * d0);
    l0 += -0.1856 * Math.sin(e0) - 0.0021 * Math.sin(2 * e0);
    l0 += 0.0052 * Math.sin(g0 - d0) - 0.0588 * Math.sin(2 * g0 - 2 * d0);
    l0 += 0.0572 * Math.sin(2 * d0 - g0 - e0) + 0.0533 * Math.sin(g0 + 2 * d0);
    l0 += 0.0458 * Math.sin(2 * d0 - e0) + 0.041 * Math.sin(g0 - e0);
    l0 += -0.0305 * Math.sin(g0 + e0);
    l0 += -0.0237 * Math.sin(2 * f0 - g0) - 0.0153 * Math.sin(2 * f0 - 2 * d0);
    l0 += 0.0107 * Math.sin(4 * d0 - g0) - 0.0079 * Math.sin(-g0 + e0 + 2 * d0);
    l0 += -0.0068 * Math.sin(e0 + 2 * d0) + 0.005 * Math.sin(e0 + d0);
    l0 += -0.0023 * Math.sin(g0 + d0) + 0.004 * Math.sin(2 * g0 + 2 * d0);
    l0 += 0.004 * Math.sin(g0 - e0 + 2 * d0) - 0.0037 * Math.sin(3 * g0 - 2 * d0);
    l0 += -0.0026 * Math.sin(g0 - 2 * d0 + 2 * f0) + 0.0027 * Math.sin(2 * g0 - e0);
    l0 += -0.0024 * Math.sin(2 * g0 + e0 - 2 * d0) + 0.0022 * Math.sin(2 * d0 - 2 * e0);
    l0 += -0.0021 * Math.sin(2 * g0 + e0) + 0.0021 * Math.sin(c0 * z2);
    l0 += 0.0021 * Math.sin(2 * d0 - g0 - 2 * e0) - 0.0018 * Math.sin(g0 + 2 * d0 - 2 * f0);
    l0 += 0.0012 * Math.sin(4 * d0 - g0 - e0) - 0.0008 * Math.sin(3 * d0 - g0);
    r0 = z2 * 2 * (l0 - c0);
    d3 = l0 - 0.1143 * Math.sin(r0) + 0.004;
    if (d3 >= 360.0) {
      d3 -= 360.0;
    }
    if (d3 < 0.0) {
      d3 += 360.0;
    }
    plnt[ret][7] = d3;
    d4 = c0;
    plnt[ret][8] = d4;
    d5 = c0 + 180.0;
    if (d5 >= 360.0) {
      d5 -= 360.0;
    }
    plnt[ret][9] = d5;
  }

  /*---------------------------------------------------------------*/
  private static void ura() {
    double g0, h0, p0, e0, q0, a0;
    int pno;
    g0 = 360 * fract(0.61372 + 1.19019 * b6);
    g0 = g0 - 0.166 * Math.sin((g0 + 50.0 + plnt[0][0]) * z2);
    h0 = 149.09 + 0.088 * b6;
    p0 = 51.02 - 0.897 * b6;
    e0 = 0.046344 - 0.000027 * b6;
    q0 = 0.772464 + 0.000625 * b6;
    a0 = 19.218;
    pno = 10;
    plnt[ret][pno] = long_planet(g0, h0, p0, e0, q0, a0, pno);
    /*
       if (ret == 0) {
         plnt[pno] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       } else {
         plnt[pno+nplnt+1] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       }
     */
  }

  /*---------------------------------------------------------------*/
  private static void nep() {
    double g0, h0, p0, e0, q0, a0;
    int pno;
    g0 = 360 * fract(0.17361 + 0.60692 * b6);
    g0 += 0.1 - 0.1 * Math.sin((g0 / 2 - 90.0 + plnt[0][0]) * z2);
    g0 += 0.166 * Math.sin(b6 - 1.0);
    h0 = 24.27 + 0.028 * b6;
    p0 = 108.22 - 0.297 * b6;
    e0 = 0.009 + 0.000006 * b6;
    q0 = 1.779242 - 0.009544 * b6;
    a0 = 30.11;
    pno = 11;
    plnt[ret][pno] = long_planet(g0, h0, p0, e0, q0, a0, pno);
    /*
       if (ret == 0) {
         plnt[pno] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       } else {
         plnt[pno+nplnt+1] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       }
     */
  }

  /*---------------------------------------------------------------*/
  private static void plu() {
    double g0, h0, p0, e0, q0, a0;
    int pno;
    g0 = 360 * fract(0.19434 + 0.40254 * b6);
    g0 -= 0.1 * Math.sin((g0 + plnt[0][0]) * z2);
    h0 = 200.02 + 0.002 * b6;
    p0 = 86.49 - 0.038 * b6;
    e0 = 0.248644;
    q0 = 17.146778 - 0.005531 * b6;
    a0 = 39.52;
    pno = 12;
    plnt[ret][pno] = long_planet(g0, h0, p0, e0, q0, a0, pno);
    /*
       if (ret == 0) {
         plnt[pno] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       } else {
         plnt[pno+nplnt+1] = long_planet(g0,h0,p0,e0,q0,a0,pno);
       }
     */
  }

  /*---------------------------------------------------------------*/
  private static void gulikan(long d, long m, long y) {
    // Gulikan does not move but only rises :-
    // On a 30 nazhika day it rises at 26, 22, 18, 14, 10, 6, 2
    // and on a 30 nazh. night it rises at 10, 6, 2, 26, 22, 18, 14
    // respectively from Sunday thru Saturday.
    long j, jj;
    double uday[][] = {{26, 22, 18, 14, 10, 06, 02},
    {10, 06, 02, 26, 22, 18, 14}};
    double sh6, sb6;
    double ayan_diff = lahiri_ayan - ayanamsa;
    double prevdaySet, nxtdayRise, prevdaySun, nxtdaySun;
    double gul_rise = 0.0, day_nazhika;
    jj = jd(d, m, y);
    j = (jj + 4) % 7;
    while (j < 0) {
      j += 7;
    }

    sh6 = (tob - timeZone - 12.0) / 24;
    sb6 = (jj - 694025 + sh6) / 36525.0;

    //pS.println(" Sunsphutam=" + DMS.dms(plnt[0][1]) +
    //  " sun(sb6)=" + DMS.dms(sun(sb6)));
    //---nxtdaySun = sun(sb6 + 1.0/36525.0) + ayan_diff;
    //---prevdaySun = sun(sb6 - 1.0/36525.0) + ayan_diff;
    //pS.println(" NxtdaySun = " + DMS.dms(nxtdaySun) +
    //   " PrevdaySun=" + DMS.dms(prevdaySun));
    //---nxtdayRise = getHour(nxtdaySun,0,d+1,m,y);
    //---prevdaySet = getHour(prevdaySun,180,d-1,m,y);
    //pS.println(" NxtdayRise=" + HMS.hms(nxtdayRise) +
    //   " PrevDaySet="+HMS.hms(prevdaySet));

    /*----------------------------------------------------------------
       //====================== Suresh's method for Gulika ==============
       // It is assumed that if it is day, on a Sunday, then, Gulika would
       // rise at 26/60 th of 360 Degree from Sun-rise i.e Sun-sphutam
       // And if it is Night, it would rise at 10/60 th Degree from Sun-set
       // i.e. 180 degrees from Sun-sphutam.
       //
       day_nazhika = ((24.0+nxtdayRise-sun_riseA) +(24.0+sun_setA-prevdaySet))/2.0;
       day_nazhika = (day_nazhika / 24.0 * 60.0);
       //pS.println(" Day Nazhika = " + day_nazhika);
       if (tob >= sun_riseA && tob < sun_setA) {  // Day
         plnt[0][13] = plnt[0][1] + uday[0][(int)j] / day_nazhika * 360.0;
         //pS.println(" Gulika Udayam = " + uday[0][(int)j]);
       } else if (tob >= sun_setA && tob < 24.0) { // Night Samedate
         plnt[0][13] = plnt[0][1] + uday[1][(int)j] / day_nazhika * 360.0;
         plnt[0][13] += 180.0;  // Since Night
         //pS.println(" Gulika Udayam = " + uday[1][(int)j]);
       } else if (tob >= 0.0 && tob < sun_riseA) { // Night Prev.date
         if (--j < 0) j += 7;  // Previous date
         plnt[0][13] = prevdaySun + uday[1][(int)j] / day_nazhika * 360.0;
         plnt[0][13] += 180.0;  // Since Night
         //pS.println(" Gulika Udayam = " + uday[1][(int)j]);
       }
       if (plnt[0][13] >= 360.0) plnt[0][13] -= 360.0;
       //pS.println(" Day = " + j + " " +V.day[(int)j]);
       //pS.println("Gulika(Suresh's.Method)="+DMS.dms(plnt[0][13]));
       ----------------------------------------------------------------*/
    //===================== Traditional Method for Gulika ==========
    j = (jj + 4) % 7;
    while (j < 0) {
      j += 7;
    }
    //gul_rise = sun_riseA;
    if (tob >= sun_riseA && tob < sun_setA) {  // Day
      gul_rise = (sun_setA - sun_riseA) * uday[0][(int) j] / 30.0;
      gul_rise += sun_riseA;
      //sh6 = (gul_rise - timeZone - 12.0) / 24;
      //sb6 = (jj - 694025 + sh6) / 36525;
      //pS.println(" Gulika Udayam = " + uday[0][(int)j] + " "+HMS.hms(gul_rise));
    } else if (tob >= sun_setA && tob < 24.0) { // Night Samedate
      nxtdaySun = sun(sb6 + 1.0 / 36525.0) + ayan_diff;
      nxtdayRise = getHour(nxtdaySun, 0, d + 1, m, y);
      gul_rise = (24.0 + nxtdayRise - sun_setA) * uday[1][(int) j] / 30.0;
      gul_rise += sun_setA;
      //sh6 = (gul_rise - timeZone - 12.0) / 24;
      //sb6 = (jj - 694025 + sh6) / 36525;
      //pS.println(" Gulika Udayam = " + uday[1][(int)j] + " "+HMS.hms(gul_rise));
    } else if (tob >= 0.0 && tob < sun_riseA) { // Night Prev.date
      if (--j < 0) {
        j += 7;  // Previous date
      }
      --jj;
      prevdaySun = sun(sb6 - 1.0 / 36525.0) + ayan_diff;
      prevdaySet = getHour(prevdaySun, 180, d - 1, m, y);
      gul_rise = (24.0 + sun_riseA - prevdaySet) * uday[1][(int) j] / 30.0;
      gul_rise += prevdaySet;
      //sh6 = (gul_rise - timeZone - 12.0) / 24;
      //sb6 = (jj - 694025 + sh6) / 36525;
      //pS.println(" Gulika Udayam = " + uday[1][(int)j] + " "+HMS.hms(gul_rise));
    }
    //gul_rise += sun_riseA;
    //pS.println(" Sunrise="+sun_riseA+ " " +HMS.hms(sun_riseA));
    //pS.println(" Gulika Udayam = " + gul_rise + " " + HMS.hms(gul_rise));
    sh6 = (gul_rise - timeZone - 12.0) / 24.0;
    sb6 = (jj - 694025.0 + sh6) / 36525.0;
    plnt[0][13] = lagnam(sb6, sh6);
    //pS.println("Gulika(Traditnl.Method)="+DMS.dms(plnt[0][13]));
    if (plnt[0][13] >= 360.0) {
      plnt[0][13] -= 360.0;
    } else if (plnt[0][13] < 0) {
      plnt[0][13] += 360.0;
    }
    //pS.println("Gulika(Traditnl.Method)="+DMS.dms(plnt[0][13]));
    //pS.println(" Gulika Rise = " + gul_rise);
    //pS.println(" Day = " + j + " " +V.day[(int)j]);

    plnt[2][13] = plnt[0][13] + ayanamsa;    // Sayana
    if (plnt[2][13] >= 360.0) {
      plnt[2][13] -= 360.0;
    } else if (plnt[2][13] < 0.0) {
      plnt[2][13] += 360.0;
    }
    //pS.println("Sayana Gulika(Traditnl.Method)="+DMS.dms(plnt[2][13]));
  }

  /*---------------------------------------------------------------*/
  private static void misc() {
    int ti, na, yo, ra, i, part;
    double rasi;
    int bh, pk, pak;
    double c, s, csdiff;
    tithi = (plnt[0][7] - plnt[0][1]) / 12;
    if (tithi < 0.0) {
      tithi += 30.0;
    }
    tt[0] = tithi;
    nakshatra = plnt[0][7] * 3 / 40;
    tt[1] = nakshatra;
    part = (int) ((4 * fract(tt[1])) + 1.0);
    paadaValue = (short) part;
    yoga = (plnt[0][7] + plnt[0][1]) * 3 / 40;
    if (yoga > 27.0) {
      yoga -= 27.0;
    }
    tt[2] = yoga;
    /*
       ti = (int)tt[0] + 1;
       System.out.println("ti = " + ti);
       if (ti == 30) ti = 15;
       else ti = ti % 15 - 1;
       System.out.println("ti = " + ti);
       if (ti == -1) ti = 14;
       System.out.println("ti = " + ti);
     */
    ti = (int) tt[0];
    //if (ti < 0.0) ti += 15;
    //System.out.println("ti = " + ti);

    na = (int) tt[1];
    yo = (int) tt[2];
    rasi = plnt[0][7] / 30;
    ra = (int) rasi;
    tt[3] = rasi;

    bh = (na < 6 ? 0 : na < 11 ? 1 : na < 16 ? 2 : na < 22 ? 3 : 4);
    pk = (na < 6 ? 0 : na < 11 ? 1 : na < 17 ? 2 : na < 22 ? 3 : 4);
    s = plnt[0][1];
    c = plnt[0][7];
    if (s > 180.0) {
      s -= 360.0;
    }
    if (c > 180.0) {
      c -= 360.0;
    }
    csdiff = (c - s);
    if (csdiff < 0.0) {
      csdiff += 360.0;
    }
    if (csdiff == 180.0 || csdiff == 0.0) {
      pak = 2;
    } else if (csdiff < 180.0) {
      pak = 1;
    } else {
      pak = 0;
    }
    //System.out.println("C = " + c + "  S = " + s + " csdiff="+csdiff);
    karanam = (short) (csdiff / 6.0);
    //System.out.println("kar = "+karanam);

    hWrite("<TR><TD>");
    pS.print("Tithi      : ");
    hWrite("</TD><TD>");
    pS.print(round(tt[0], 2));
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("          \t\t");
    }
    hWrite("</TD><TD>");
    pS.print("Tithi Name     : ");
    hWrite("</TD><TD>");
    pS.println(V.tit[ti]);
    hWrite("</TD></TR><TR><TD>");
    pS.print("Nakshatra  : ");
    hWrite("</TD><TD>");
    //pS.print(nakshatra);      hWrite("</TD><TD>");
    pS.print(round(tt[1], 2));
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("\t");
    }
    pS.print("(" + part + " Paada)");
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("\t");
    }
    pS.print("Nakshatra Name : ");
    hWrite("</TD><TD>");
    pS.println(V.nak[na]);
    hWrite("</TD></TR><TR><TD>");

    yogam = (short) yo;
    pS.print("Yoga       : ");
    hWrite("</TD><TD>");
    pS.print(round(tt[2], 2));
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("          \t\t");
    }
    hWrite("</TD><TD>");
    pS.print("Yoga Name      : ");
    hWrite("</TD><TD>");
    pS.println(V.yog[yogam]);
    hWrite("</TD></TR><TR><TD>");

    pS.print("Raasi      : ");
    hWrite("</TD><TD>");
    pS.print((int) tt[3] + "S " + DMS.dms((tt[3] - (int) tt[3]) * 30));
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("\t\t");
    }
    hWrite("</TD><TD>");
    pS.print("Raasi Name     : ");
    hWrite("</TD><TD>");
    pS.println(V.ras[ra]);
    hWrite("</TD></TR><TR><TD>");

    hWrite("</TD></TR><TR><TD>");
    pS.print("Ganam      : ");
    hWrite("</TD><TD>");
    pS.print(V.ganam[V.gnmId[na]]);
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("\t\t\t");
    }
    hWrite("</TD><TD>");
    pS.print("Devata     : ");
    hWrite("</TD><TD>");
    pS.println(V.devata[na]);
    hWrite("</TD></TR><TR><TD>");
    pS.print("Vriksham   : ");
    hWrite("</TD><TD>");
    pS.print(V.vriksha[na]);
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("\t\t\t");
    }
    hWrite("</TD><TD>");
    pS.print("Yoni       : ");
    hWrite("</TD><TD>");
    pS.println(V.yoni[V.yonId[na]]);
    hWrite("</TD></TR><TR><TD>");
    pS.print("Bhootam    : ");
    hWrite("</TD><TD>");
    pS.print(V.bhootam[bh]);
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("\t\t\t");
    }
    hWrite("</TD><TD>");
    pS.print("Mrigam     : ");
    hWrite("</TD><TD>");
    pS.println(V.mrigam[na]);
    hWrite("</TD></TR><TR><TD>");
    pS.print("Pakshi     : ");
    hWrite("</TD><TD>");
    pS.print(V.pakshi[pk]);
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("\t\t\t");
    }
    hWrite("</TD><TD>");
    pS.print("Paksham    : ");
    hWrite("</TD><TD>");
    pS.println(V.paksham[pak]);
    hWrite("</TD></TR><TR><TD>");
    pS.print("Karanam    : ");
    hWrite("</TD><TD>");
    //System.out.println("Kar=" + karanam);
    //System.out.println("Karid["+karanam+"] = " +  V.karId[karanam]);
    pS.println(V.karanam[V.karId[karanam]]);
    hWrite("</TD></TR>");
  }

  /*---------------------------------------------------------------*/
  private void misc(long d, long m, long y, long j) {
    int hj;
    double sun_rise, sun_set, noon, noonA;
    double days2k;
    //snDate dt = new snDate(y, m, d);
    //snDate d2000 = new snDate(2000,01,01);
    days2k = snDate.day2000((int) y, (int) m, (int) d, 6, 0, 0, 1);
    //days2k = dt.datediff(dt, d2000);

    sun_rise = snRiseSet.snRiseSet(days2k, lat, longt, 1, 0.0) + timeZone;
    sun_riseA = getHour(plnt[0][1], 0, d, m, y);

    hWrite("<TABLE border=2>");
    hWrite("<TR><TD>");
    pS.print("Sun rise   : ");
    hWrite("</TD><TD>");
    pS.print(HMS.hms(sun_rise));
    hWrite("&times;</TD><TD>");
    pS.println(" (" + HMS.hms(sun_riseA) + ")");
    hWrite("&copy;</TD></TR><TR><TD>");
    //pS.println("Sun rise   : " + HMS.hms(sun_rise,longt,5.5));

    sun_set = snRiseSet.snRiseSet(days2k, lat, longt, 2, 0.0) + timeZone;
    sun_setA = getHour(plnt[0][1], 180, d, m, y);

    noon = (sun_rise + sun_set) / 2.0;
    noonA = (sun_riseA + sun_setA) / 2.0;
    pS.print("Noon       : ");
    hWrite("</TD><TD>");
    pS.print(HMS.hms(noon));
    hWrite("&times;</TD><TD>");
    pS.println(" (" + HMS.hms(noonA) + ")");
    hWrite("&copy;</TD></TR><TR><TD>");

    //System.out.println("Sun_Set = "+HMS.hms(sun_set));
    pS.print("Sun set    : ");
    hWrite("</TD><TD>");
    pS.print(HMS.hms(sun_set));
    hWrite("&times;</TD><TD>");
    pS.println(" (" + HMS.hms(sun_setA) + ")");
    hWrite("&copy;</TD></TR><TR><TD>");

    pS.print("Dina-Maanam: ");
    hWrite("</TD><TD>");
    pS.print(HMS.hms(sun_set - sun_rise));
    hWrite("&times;</TD><TD>");
    pS.println(" (" + HMS.hms(sun_setA - sun_riseA) + ")");
    hWrite("&copy;</TD></TR>");

    hj = (int) ((tob < sun_rise) ? (j - 1) : j);
    if (hj < 0) {
      hj += 7;
    }
    hWrite("<TR><TD>");
    //d_o_w_Hindu = V.day[hj];
    snE.dowHindu_No = (short) hj;
    snE.dowHindu = V.day[hj];
    snE.sunrise = sun_rise;
    snE.sunset = sun_set;
    pS.print("Hindu Day of Birth  : ");
    hWrite("</TD><TD>");
    pS.println(V.day[hj]);
    hWrite("</TD><TD>");
    //hWrite(snE.getMalayalamEra(d_o_b,plnt[0][1],
    hWrite("</TD></TR></TABLE>");

    hWrite("<TABLE><TR><TD>");
    hWrite("Abhjith Muhurtham: ");
    hWrite("</TD><TD>");
    hWrite(HMS.hms(noon - 24.0 / 60) + "-" + HMS.hms(noon - 1.0 / 60.0));
    hWrite("</TD><TD align=center width=18> and </TD><TD>");
    hWrite(HMS.hms(noon + 1.0 / 60) + "-" + HMS.hms(noon + 24.0 / 60.0));
    hWrite("</TD><TD>&times;");
    hWrite("</TD></TR><TR><TD>");
    hWrite("                   ");
    hWrite("</TD><TD>");
    hWrite(" (" + HMS.hms(noonA - 24.0 / 60.0) + "-" + HMS.hms(noonA - 1.0 / 60.0));
    hWrite("</TD><TD align=center> and </TD><TD>");
    hWrite(HMS.hms(noonA + 1.0 / 60.0) + "-" + HMS.hms(noonA + 24.0 / 60.0) + ")");
    hWrite("</TD><TD>&copy;");
    hWrite("</TD></TR></TABLE>");
  }

  /*---------------------------------------------------------------*/
  private static void prplnt() {
    int i, a, b, c;
    double aa, bb, lagn, lagnS, xx, aaS;
    double klagn = 0.0, kmoon = 0.0;
    String pp;
    lagn = lagnam();
    lagnS = (lagn + ayanamsa);
    if (lagnS > 360.0) {
      lagnS -= 360.0;
    } else if (lagnS < 0.0) {
      lagnS += 360.0;
    }
    for (i = 0; i <= nplnt; i++) {
      aa = (i > 0 ? plnt[0][i] : lagn);
      aaS = (i > 0 ? plnt[2][i] : lagnS);
      a = (int) (aa / 30);
      b = (int) (aa * 3 / 40);
      c = (int) (4 * fract(aa * 3.0 / 40) + 1.0);
      if (i == 0) {
        pp = "   ";
      } else {
        if (plnt[1][i] < aaS) {
          pp = (html ? "<STRONG>RET<STRONG>" : "RET");
        } else {
          pp = (html ? "<I>dir</I>" : "dir");
          //pp = ">>+>>";  &uml;&macr;&middot;&shy;&divide;
        }
        /*
           bb = plnt[1][i];    // plnt[i+nplnt+1];
           if (bb < aa) pp = "RET";
           else pp = "DIR";
         */
      }
      hWrite("<TR><TD>");
      pS.print(V.grahalong[i]);
      hWrite(sTDTDj);
      if (!html) {
        pS.print("      ");
      }
      if (html) {
        xx = aa / 30.0;
        if (xx >= 12.0) {
          xx -= 12.0;
        }
        //pS.print((int)xx+" S " + DMS.dms(30.0*fract(xx)));
        pS.print(V.ras[(int) xx] + " " + DMS.dms(30.0 * fract(xx)));
        //hWrite(sTDTDj);
        hWrite(sTDTDj);
        xx = (aa + ayanamsa) / 30.0;
        if (xx >= 12.0) {
          xx -= 12.0;
        }
        while (xx < 0.0) {
          xx += 12.0;
        }
        //pS.print((int)xx+" S " + DMS.dms(30.0*fract(xx)));
        pS.print(V.ras[(int) xx] + " " + DMS.dms(30.0 * fract(xx)));
        hWrite(sTDTDc);
      }
      pS.print(DMS.dms(aa));
      hWrite(sTDTDc);
      if (!html) {
        pS.print(" (");
      }
      /*
         xx = (aa + ayanamsa);
         if (xx >= 360.0) xx -= 360.0;
         pS.print(DMS.dms(xx)); hWrite(sTDTDc);
       */
      pS.print(DMS.dms(aaS));
      hWrite(sTDTDc);
      if (!html) {
        pS.print(")   \t");
      }
      if (!html) {
        pS.print(V.ras[a]);   //       hWrite(sTDTDc);
      }
      pS.print(" (" + c + ") ");
      hWrite(sTDTDc);
      pS.print(V.nak[b]);
      hWrite(sTDTDc);
      pS.println(pp);
      hWrite("</TD></TR>");
    }
    hWrite("<TR><TD>");
    pS.print("Kunda Lagnam");
    hWrite(sTDTDc);
    klagn = kunda_Amsam(lagn);
    pS.print(DMS.dms(klagn));
    hWrite(sTDTDc);
    double klagdiff = kunda_lagna_diff(lagn, plnt[0][7]);
    pS.print(DMS.dms(klagdiff));
    hWrite(sTDTDc);
    hWrite("</TD></TR><TR><TD>");
    pS.print("Actual Lagnam");
    hWrite(sTDTDc);
    pS.print(DMS.dms(lagn + klagdiff));
    hWrite(sTDTDc);
    hWrite("</TD></TR>");
    /*
       hWrite("<TR><TD>");
       pS.print("Kunda Chandra");  hWrite(sTDTDc);
       kmoon = kunda_Amsam(plnt[0][7]);
       pS.print(DMS.dms(kmoon));           hWrite(sTDTDc);
       pS.print(DMS.dms(klagdiff));
       hWrite(sTDTDc);
       pS.print(DMS.dms(klagn, kmoon)
       hWrite(sTDTDc);
       hWrite("</TD></TR>");
     */
  }

  /*---------------------------------------------------------------*/
  private static double kunda_lagna_diff(double lag, double moon) {
    double c1, c2, k1, k2, k3, k4;
    double klag, diff, corr = 0.0;
    System.out.println("Lagn=" + DMS.dms(lag));
    System.out.println("Moon=" + DMS.dms(moon));
    klag = kunda_Amsam(lag);
    diff = (moon - klag);
    /*
       System.out.println("Diff="+DMS.dms(moon)+" - "+DMS.dms(klag)+" = " + DMS.dms(diff));
       if (diff < 0) diff += 360.0;
       System.out.println("Diff="+DMS.dms(moon)+" - "+DMS.dms(klag)+" = " + DMS.dms(diff));
       //if (diff >= 300.0 && diff < 60.0) corr = 0.0;
       if (diff >= 60.0 && diff < 180.0) corr = +120.0;
       else if (diff >= 180.0 && diff < 300.0) corr = -120.0;
       System.out.println(" correction="+DMS.dms(corr));
       corr = diff - corr;
       if (corr >= 360.0) corr -= 360.0;
       else if (corr < 0.0) corr += 360.0;
     */
    c1 = diff / 81.0;
    c2 = (diff + 120.0) / 81.0;
    k1 = kunda_Amsam(lag + c1);
    k2 = kunda_Amsam(lag + c2);
    k3 = kunda_Amsam(lag - c1);
    k4 = kunda_Amsam(lag - c2);
    if ((long) round((k1 - moon), 0) == 0) {
      corr = c1;
    } else if ((long) round((k2 - moon), 0) == 0) {
      corr = c2;
    } else if ((long) round((k3 - moon), 0) == 0) {
      corr = -c1;
    } else if ((long) round((k4 - moon), 0) == 0) {
      corr = -c2;
    } else if (120 == ((long) round(Math.abs(k1 - moon), 0))) {
      corr = c1;
    } else if (120 == ((long) round(Math.abs(k2 - moon), 0))) {
      corr = c2;
    } else if (120 == ((long) round(Math.abs(k3 - moon), 0))) {
      corr = -c1;
    } else if (120 == ((long) round(Math.abs(k4 - moon), 0))) {
      corr = -c2;
    }
    System.out.print(" k1=" + DMS.dms(k1));
    System.out.println(" k2=" + DMS.dms(k2));
    System.out.print(" k3=" + DMS.dms(k3));
    System.out.println(" k4=" + DMS.dms(k4));
    System.out.println("Correction = " + DMS.dms(corr));
    System.out.println("Corrected Lagn=" + DMS.dms(lag + corr));
    return (corr);
  }

  /*---------------------------------------------------------------*/
  private static double kunda_Amsam(double lag) {
    double m0;
    long i0;
    //System.out.println("Graha="+DMS.dms(lag));
    m0 = lag * 81.0;
    //System.out.println("KundaAmsam ="+(m0));
    //System.out.println("KundaAmsam ="+DMS.dms(m0));
    i0 = (long) (m0 / 360.0);
    m0 = m0 - i0 * 360.0;
    //System.out.println(" Kunda -"+i0 + " x 360 -> " + (m0));
    //System.out.println(" Kunda -"+i0 + " x 360 -> " + DMS.dms(m0));
    return (m0);
  }

  /*---------------------------------------------------------------*/
  private static void bhavgnl(double j0, double k0, int u) {
    int l, v;
    double m0;
    for (l = 0; l < 3; l++) {
      m0 = j0 + k0 * l;
      if (m0 >= 360.0) {
        m0 -= 360.0;
      }
      v = u + l - 1;
      f2[v] = m0;
    }
  }

  /*---------------------------------------------------------------*/
  private static double bhavspl(double sobliq, double a0, double c0) {
    /*
       double xa, xw, xd, xv, xb, xe, xret;
       xa = (a0 + 90.0) * V.PI / 12.0;
       xw = sobliq * z2;
       xd = Math.asin(Math.sin(xa) * Math.sin(xw));
       xv = Math.atan(Math.cos(xa) * Math.tan(xw));
       xb = Math.atan(Math.tan(xa) * Math.cos(xw));
       xe = Math.atan(Math.sin(xd) * Math.tan(c0+xv));
       xret = (xb + xe)/z2 - ayanamsa;
       if (xret < 0.0) xret += 360.0;
       if (xret > 360.0) xret -= 360.0;
       return (xret);
     */

    double r0, w0, b0, g0;
    r0 = ayanamsa;
    w0 = sobliq * z2;
    b0 = a0 * 15 + 90.0;
    if (b0 >= 360.0) {
      b0 -= 360.0;
    }
    if (chandraHariAyana) {
      a0 *= 15 * z2;
    } else {
      a0 *= V.PI / 12;
    }
    c0 *= z2;
    if (a0 == 0.0 && c0 == 0.0) {
      return 90.0;
    }
    if (chandraHariAyana) {
      g0 = Math.atan(Math.cos(w0) * Math.tan(a0)
          + Math.sin(w0) * Math.tan(c0) / Math.cos(a0));
      //System.out.println("ChandraHari's g0="+g0);
    } else {
      g0 = Math.atan(-Math.cos(a0) / (Math.sin(c0) * Math.sin(w0)
          / Math.cos(c0) + Math.sin(a0) * Math.cos(w0)));
    }
    g0 /= z2;
    if (chandraHariAyana) {
      if (b0 >= 180.0) {
        g0 += 270.0;
      } else {
        g0 += 90;
      }
    } else {
      if (g0 < 0.0) {
        g0 += 180.0;
      }
      if (b0 - g0 > 75.0) {
        g0 += 180.0;
      }
    }
    g0 -= r0;
    if (g0 < 0.0) {
      g0 += 360.0;
    }
    if (g0 > 360.0) {
      g0 -= 360.0;
    }
    //pS.println(" ayanamsa -> bhavspl() = " + ayanamsa);
    return (g0);
  }

  /*---------------------------------------------------------------*/
  private static void pageHeader() {
    hWrite("<TABLE><TR><TD>");
    pS.println("\f");
    hWrite("</TD></TR><TR><TD width=500 align=left>");
    page++;
    pS.print("Jatakam of ");
    hWrite("&nbsp;<U>");
    pS.print(name);
    hWrite("</U></TD><TD width=400 align=right>");
    if (!html) {
      pS.print("\t\t\t ");
    }
    if (!html) {
      pS.println("Page : " + page);
    }
    hWrite("</TD></TR></TABLE>");
    /*
       if (!html) {
         pS.println("\f");
         page++;
         pS.println(name + "\t\t\t Page : " + page);
       }
     */
  }

  /*---------------------------------------------------------------*/
  private static double lagnam() {
    //double a0, b0, c0;
    return (lagnam(b6, h6));
    /*
       //ayanamsa = plnt[0][0];
       obliq = 23.452294 - 0.0130125*b6;
       obliq += 0.00426 * Math.cos(plnt[2][8] * z2);  // Sayana Rahu
       a0 = 24.0 * fract(0.2769 + 100.00214*b6);
       b0 = h6 * 24.0 + 12.0;
       c0 = longt / 15.0;
       sidtime = 24.0 * fract((a0 + b0 + c0) / 24.0);
       if (sidtime < 0) sidtime += 24.0;
       a0 = bhavspl(obliq, sidtime, lat);
       /*
       b0 = bhavspl(obliq, sidtime - 6.0, 0.0);
       c0 = (180 + b0 - a0)/3;
       if (b0 > a0) c0 -= 120;
       bhavgnl(a0, c0, 1);
     */
    //System.out.println("Lagnam() Sayana Rahu="+plnt[2][8]);
    //System.out.println(" Lagnam = "+a0 + " Lagnam calc="+lagnam(b6,h6));
    /*
       return (a0);
     */
  }

  /*---------------------------------------------------------------*/
  private static void bhav() {
    String dashL
        = "---------------------------------------------------------";
    double a0, b0, c0, d0, j0, k0;
    int i;
    boolean fnd;
    //ayanamsa = plnt[0][0];
    obliq = 23.452294 - 0.0130125 * b6;
    obliq += 0.00426 * Math.cos(plnt[2][8] * z2);  // Sayana Rahu
    a0 = 24.0 * fract(0.2769 + 100.00214 * b6);
    b0 = h6 * 24.0 + 12.0;
    c0 = longt / 15.0;
    sidtime = 24.0 * fract((a0 + b0 + c0) / 24.0);
    if (sidtime < 0) {
      sidtime += 24.0;
    }
    a0 = bhavspl(obliq, sidtime, lat);
    b0 = bhavspl(obliq, sidtime - 6.0, 0.0);
    c0 = (180.0 + b0 - a0) / 3.0;
    if (b0 > a0) {
      c0 -= 120.0;
    }
    d0 = 60.0 - c0;
    bhavgnl(a0, c0, 1);
    bhavgnl(b0 + 180, d0, 4);
    bhavgnl(a0 + 180, c0, 7);
    bhavgnl(b0, d0, 10);
    f3[0] = (f2[11] + f2[0]) / 2;
    if (f2[0] < f2[11]) {
      f3[0] += 180.0;
    }
    if (f3[0] >= 360.0) {
      f3[0] -= 360.0;
    }
    for (i = 1; i < nrasi; i++) {
      f3[i] = (f2[i - 1] + f2[i]) / 2;
      if (f2[i] < f2[i - 1]) {
        f3[i] += 180.0;
      }
      if (f3[i] >= 360.0) {
        f3[i] -= 360.0;
      }
    }
    hWrite("<TABLE border=2><TR><TD>");
    pS.print("Ayanamsa      : ");
    hWrite("</TD><TD>");
    pS.print(DMS.dms(plnt[0][0]));
    hWrite("</TD><TD>");
    pS.println("(" + ayana_opts[ayana_opt] + ")");
    hWrite("</TD></TR><TR><TD>");
    pS.print("Obliquity     : ");
    hWrite("</TD><TD>");
    pS.println(DMS.dms(obliq));
    hWrite("</TD></TR><TR><TD>");
    pS.print("Siderial Time : ");
    hWrite("</TD><TD>");
    pS.println(HMS.hms(sidtime));
    hWrite("</TD></TR></TABLE>");
    hWrite("<HR><TABLE><TR><TD>");
    if (!html) {
      pS.println(dashL);
    }
    hWrite("</TD></TR><TR><TD>");
    hWrite("<a name=\"_BhaavaSthiti\"></a><a href=\"#_top\">");
    pS.println("           Bhaava Sthiti  ");
    hWrite("</a></TD></TR><TR><TD>");
    if (!html) {
      pS.println(dashL);
    }
    hWrite("</TD></TR></TABLE>");
    hWrite("<TABLE border=3 cellspacing=2><TR><TD>");
    pS.print(" Bhava ");
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("       ");
    }
    pS.print("Bhava.Begin ");
    hWrite("</TD><TD>");
    if (!html) {
      pS.print("       ");
    }
    pS.print("Mid-Bhava  ");
    hWrite("</TD><TD align=center>");
    pS.println("\tGrahas   ");
    hWrite("</TD></TR>");
    if (!html) {
      pS.println(dashL);
    }
    for (i = 0; i < nrasi; i++) {
      hWrite("<TR><TD align=center>");
      if (!html) {
        pS.print("   ");
      }
      pS.print((i + 1));
      hWrite("</TD><TD>");
      if (!html) {
        pS.print("\t\t");
      }
      pS.print(DMS.dms(f3[i]));
      hWrite("</TD><TD>");
      if (!html) {
        pS.print("\t");
      }
      pS.print(DMS.dms(f2[i]));
      hWrite("</TD><TD>");
      if (!html) {
        pS.print("\t");
      }
      for (int kk, k = 1; k <= nplnt; k++) {
        kk = i + 1;
        kk = (kk == nrasi) ? 0 : kk;
        /*
		   System.out.println(" i="+i+" kk="+kk + " k="+k+" "+V.grahalong[k]);
		   System.out.println("f3[i]="+DMS.dms(f3[i])+"~f3[kk]="+
		   					DMS.dms(f3[kk])+" Planet[0][k]="+plnt[0][k]);
         */
        fnd = ((f3[kk] < 30.0 && plnt[0][k] < 30.0 && plnt[0][k] < f3[kk])
            || (f3[i] > 330.0 && plnt[0][k] > 330.0) && plnt[0][k] >= f3[i]);
        //if (fnd || (f3[i] <=	plnt[0][k] && plnt[0][k] <= f3[i]+30.0)) {
        if (fnd || (f3[i] <= plnt[0][k] && plnt[0][k] <= f3[kk])) {
          //System.out.println("Found="+fnd+" Planet between "+f3[i]+" & "+f3[kk]);
          pS.print(' ' + V.grahalong[k]);
        }
      }
      if (!html) {
        pS.println();
      }
      hWrite("</TD><TR>");
    }
    hWrite("</TABLE>");
    hWrite("<TABLE><TR><TD>");
    if (!html) {
      pS.println(dashL);
    }
    hWrite("</TD></TR></TABLE>");
    pageHeader();
  }

  /*---------------------------------------------------------------*/
  private static void saptavg() {
    int i;
    String dashL
        = "--------------------------------------------------------------------------";
    hWrite("<HR><TABLE><TR><TD><B>");
    pS.println();
    hWrite("</TD></TR><TR><TD>");
    hWrite("<a name=\"_SaptaVarga\"></a><a href=\"#_top\">");
    pS.println("      Saptavarga Table (in Raasi)");
    hWrite("</a></TD></TR><TR><TD>");
    if (!html) {
      pS.println(dashL);
    }
    hWrite("</TD></TR></TABLE>");
    hWrite("<TABLE border=5 cellpadding=2><TR><TD>");
    /*
       pS.print("Graha  ");   hWrite("</TD><TD>");
       pS.print("Div.1  ");   hWrite("</TD><TD>");
       pS.print("Div.3  ");   hWrite("</TD><TD>");
       pS.print("Div.7  ");   hWrite("</TD><TD>");
       pS.print("Div.9  ");   hWrite("</TD><TD>");
       pS.print("Div.10 ");   hWrite("</TD><TD>");
       pS.print("Div.12 ");   hWrite("</TD><TD>");
       pS.print("Div.16 ");   hWrite("</TD><TD>");
       pS.print("Div.30 ");   hWrite("</TD><TD>");
       pS.println("Div.60 ");
     */
    pS.print("Graham ");
    hWrite("</TD><TD>");
    pS.print("  x 1  ");
    hWrite("</TD><TD>");
    pS.print("  x 3  ");
    hWrite("</TD><TD>");
    pS.print("  x 7  ");
    hWrite("</TD><TD>");
    pS.print("  x 9  ");
    hWrite("</TD><TD>");
    if (chandraHariAyana) {
      pS.print("  x 10 ");
      hWrite("</TD><TD>");
    } else {
      pS.print("Div.10 ");
      hWrite("</TD><TD>");
    }
    pS.print("  x 12 ");
    hWrite("</TD><TD>");
    pS.print("  x 16 ");
    hWrite("</TD><TD>");
    pS.print("  x 30 ");
    hWrite("</TD><TD>");
    pS.print("  x 60 ");
    hWrite("</TD><TD>");
    pS.print("  x 81 ");
    pS.println();
    hWrite("</TD></TR><TR><TD></B>");
    if (!html) {
      pS.println(dashL);
    }
    vgcomp(V.grahalong[0], f2[0], 0); // Lagna
    for (i = 1; i <= nplnt; i++) {
      vgcomp(V.grahalong[i], plnt[0][i], i);
    }
    hWrite("</TD></TR></TABLE>");
    hWrite("<TABLE><TR><TD>");
    if (!html) {
      pS.println(dashL);
    }
    hWrite("</TD></TR><TR><TD>");
    pS.println();
    hWrite("</TD></TR></TABLE>");
  }

  /*---------------------------------------------------------------*/
  private void listPaapas() {
    /* 0-Lagn 1-Ravi 2-Budh 3-Sukr 4-Kuja 5-Guru 6-Sani 7-Moon
          8-Rahu 9-Ketu 13-Maandi   */

    //System.out.println(" HTML = " + html);
    if (html || argsPassed) {
      String dashL
          = "---------------------------------------------------------------";
      int paapHouse[] = {1, 2, 4, 7, 8, 12};
      int paapGrahA[] = {1, 4, 9};
      int paapGrahB[] = {6, 8};
      int paapFrom[] = {0, 7, 3};/*Lagnaal,Chandraal,Sukraal*/
      //int[][] paapCount = new int[npaapFrom][npaapCnt];
      //                             [][3]-Total & [][6]-GrandTotal
      int i, j, jj, k, totidx, grndtotidx, pos;
      totidx = paapGrahA.length;
      grndtotidx = totidx + paapGrahB.length + 1;
      for (i = 0; i < paapFrom.length; i++) {
        for (j = 0; j < totidx; j++) {
          pos = (varga[paapGrahA[j]][0] - varga[paapFrom[i]][0] + 1 + 12) % 12;
          if (pos == 0) {
            pos = 12;
          }
          paapCount[i][j] = 0;
          for (k = 0; k < paapHouse.length; k++) {
            if (pos == paapHouse[k]) {
              paapCount[i][j] = 1;
            }
          }
          paapCount[i][totidx] += paapCount[i][j];
        }
        paapCount[i][grndtotidx] = paapCount[i][totidx];
        for (jj = totidx + 1, j = 0; jj < grndtotidx; jj++, j++) {
          pos = (varga[paapGrahB[j]][0] - varga[paapFrom[i]][0] + 1 + 12) % 12;
          if (pos == 0) {
            pos = 12;
          }
          paapCount[i][jj] = 0;
          for (k = 0; k < paapHouse.length; k++) {
            if (pos == paapHouse[k]) {
              paapCount[i][jj] = 1;
            }
          }
          paapCount[i][grndtotidx] += paapCount[i][jj];
        }
      }

      hWrite("<HR><TABLE><TR><TD><B>");
      pS.println();
      hWrite("</TD></TR><TR><TD>");
      hWrite("<a name=\"_Paapa_Count\"></a><a href=\"#_top\">");
      pS.print("    Count of Paapans for Horoscope Compatibility ");
      hWrite("</a>");
      pS.print(" (for houses :-");
      //System.out.println(" PaapHouse.length = "+ paapHouse.length);
      for (i = 0; i < paapHouse.length; i++) {
        pS.print(" " + paapHouse[i] + " ");
        //System.out.print(paapHouse[i]);
      }
      pS.println(")");
      hWrite("</TD></TR><TR><TD>");
      if (!html) {
        pS.println(dashL);
      }
      hWrite("</TD></TR></TABLE>");
      hWrite("<TABLE border=5 cellpadding=2><TR align=center><TD>");
      pS.print("Graha  ");
      hWrite("</TD><TD>");
      for (i = 0; i < paapGrahA.length; i++) {
        pS.print(V.grahalong[paapGrahA[i]]);
        hWrite("</TD><TD>");
      }
      pS.print("<-- Total -->");
      hWrite("</TD><TD>");
      for (i = 0; i < paapGrahB.length; i++) {
        pS.print(V.grahalong[paapGrahB[i]]);
        hWrite("</TD><TD>");
      }
      pS.print("<- Grand-Total ->");
      hWrite("</TD></TR></B>");
      for (i = 0; i < paapFrom.length; i++) {
        hWrite("<TR align=center><TD>");
        pS.print(V.grahalong[paapFrom[i]]);
        hWrite("</TD>");
        for (j = 0; j <= grndtotidx; j++) {
          hWrite("<TD>");
          if (paapCount[i][j] > 0) {
            pS.print(paapCount[i][j]);
          } else {
            pS.print(" - ");
          }
          hWrite("</TD>");
        }
        hWrite("</TR>");
      }
      hWrite("</TABLE><HR>");
    }
  }

  /*---------------------------------------------------------------*/
  private static void vgcomp(String y1, double x0, int t) {
    String delim;
    int q, z;
    int[] j = new int[saptvarg_sz + 1];
    int m, r, i;
    double r0;
    q = (int) (x0 / 30);
    z = q + 1;
    j[1] = z % 12;
    r0 = 30 * fract(x0 / 30);
    if (r0 >= 0 && r0 < 10) {
      m = 1;
    } else if (r0 >= 10 && r0 < 20) {
      m = 5;
    } else {
      m = 9;
    }
    z = q + m;
    j[2] = z % 12;
    z = (int) (x0 * 7.0 / 30 + 1);
    j[3] = z % 12;
    z = (int) (x0 * 9.0 / 30 + 1);
    j[4] = z % 12;
    if (chandraHariAyana) {
      z = (int) ((360.0 * fract(x0 * 10.0 / 360)) / 30 + 1);
    } else {
      r = (int) (10 * fract(x0 / 30));
      if (q % 2 == 0) {
        m = 1;
      } else {
        m = 9;
      }
      z = q + r + m;
    }
    j[5] = z % 12;
    if (chandraHariAyana) {
      z = (int) (x0 * 12.0 / 30 + 1);
    } else {
      r = (int) (12 * fract(x0 / 30));
      z = q + r + 1;
    }
    j[6] = z % 12;
    z = (int) (x0 * 16.0 / 30 + 1);
    j[7] = z % 12;
    z = (int) (x0 + 1);
    j[8] = z % 12;
    if (chandraHariAyana) {
      z = (int) (x0 * 60.0 / 30 + 1);
    } else {
      r = (int) (60 * fract(x0 / 30));
      z = q + r + 1;
    }
    j[9] = z % 12;
    z = (int) (x0 * 81.0 / 30 + 1);
    j[10] = z % 12;
    for (i = 1; i <= saptvarg_sz; i++) {
      if (j[i] == 0) {
        j[i] = 12;
      }
    }
    hWrite("<TR><TD>");
    pS.print(y1);
    delim = "   ";
    for (i = 1; i <= saptvarg_sz; i++) {
      varga[t][i - 1] = j[i];
      hWrite("</TD><TD align=center>");
      if (!html) {
        pS.print(delim);
      }
      pS.print(j[i]);
      delim = "\t";
    }
    pS.println();
    hWrite("</TD></TR>");
  }

  /*---------------------------------------------------------------*/
  private static void vgcalc(int m) {
    String[][] tz = new String[33][8];
    int i, j, z;
    for (i = 0; i < 33; i++) {
      for (j = 0; j < 8; j++) {
        tz[i][j] = "    ";
      }
    }
    if (!html) {
      int s, p, q, r, u, v;
      for (i = 0; i <= nplnt; i++) {
        s = varga[i][m];
        if (s < 4) {
          r = s + 1;
        } else if (s < 7) {
          r = (s - 2) * 4;
        } else if (s < 10) {
          r = 22 - s;
        } else {
          r = (12 - s) * 4 + 1;
        }
        p = (r - 1) / 4 + 1;
        q = r - (p - 1) * 4;
        u = (p - 1) * 8 + 2 + i / 2;
        v = (q - 1) * 2 + i % 2;
        tz[u][v] = V.graha[i];
      }
      for (z = 1; z <= 33; z++) {
        if (z % 8 == 1 && z != 17) {
          for (i = 0; i < 4; i++) {
            pS.print("-------------");
          }
          pS.println('-');
        } else if (z == 17) {
          pS.println("--------------" + "       " + V.vrg[m]
              + "        " + "--------------");
        } else if (z < 9 || z > 25) {
          for (i = 0; i < 8; i++) {
            pS.print(
                (i % 2 == 0 ? "| " : " ") + tz[z][i] + " ");
          }
          pS.println('|');
        } else {
          for (i = 0; i < 8; i++) {
            pS.print(
                (i == 4 ? "   "
                    : ((i > 2 && i < 6) ? (i % 2 == 0 ? "|       " : "        ")
                        : ((i % 2 == 0 ? "| " : " ") + tz[z][i] + " "))));
          }
          pS.println('|');
        }
      }
    } else {
      int rIdx[] = {1, 2, 3, 5, 7, 11, 10, 9, 8, 6, 4, 0};
      int[] rItx = new int[nplnt + 1];
      String std = "<TD width=100 align=center>";
      String delm[] = {"..   12    ..", "..    1    ..",
        "..    2    ..", "..    3    .."};
      String delim = ".           .";
      //String stB = "<TD width=100 bgcolor=gray align=center>";
      String stB = "<TD width=100 align=center height=300>";
      int maxGrh = 6;
      boolean found = false;
      for (i = 0; i <= nplnt; i++) {
        rItx[i] = 0;
      }
      for (i = 0; i <= nplnt; i++) {
        z = rIdx[varga[i][m] - 1];
        tz[z][rItx[z]] = V.graha[i];
        if (rItx[z] > maxGrh) {
          maxGrh = rItx[z];
        }
        rItx[z]++;
      }
      //System.out.println(" Max Grahas = "+maxGrh);
      hWrite("<TABLE><TR><TD width=400 align=center font:14pt verdana>");
      hWrite("<STRONG><a name=\"_" + V.vrg[m].trim() + "\"></a><a href=\"#_top\">");
      hWrite(V.vrg[m]);
      hWrite("</a></STRONG></TD></TR></TABLE>");
      hWrite("<TABLE border=4><TR>");
      for (i = 0; i < 4; i++) {
        hWrite(std + delm[i] + "</TD>");
      }
      hWrite("</TR><TR>");
      for (i = 0; i < 12; i++) {
        hWrite(std);
        found = false;
        for (j = 0; j < rItx[i]; j++) {
          pS.print(tz[i][j]);
          if (j % 2 > 0) {
            pS.println();
            hWrite("<BR>");
          } else {
            pS.print("\t");
          }
          found = true;
        }
        if (!found) {
          hWrite(delim);
        }
        for (; j <= maxGrh / 2; j++) {
          hWrite("<BR>");
        }
        if (i == 4) {
          hWrite("</TD><TD align=center colspan=2 rowspan=2>" + sOMKaar);
          //hWrite("<H5>" + (char)92 + "</H5>");
        }
        hWrite("</TD>");
        if (i == 3 || i == 5 || i == 7) {
          hWrite("</TR><TR>");
        }
        /*
           if (i==4 || i==6) hWrite("</TD>"+stB+"</TD>"+stB);
           hWrite("</TD>");
           if (i==3 || i==5 || i==7) hWrite("</TR><TR>");
         */
      }
      hWrite("</TR></TABLE>");
    }
    if (m % 2 == 1) {
      pS.println();
    } else {
      pageHeader();
    }
  }

  /*---------------------------------------------------------------*/
  private static void vgprint(int detl) {
    if (detl == 0) {
      vgcalc(0);
      vgcalc(3);
    } else {
      for (int m = 0; m <= saptvarg_sz - 4; m++) {
        vgcalc(m);
      }
      vgcalc(saptvarg_sz - 1);
    }
  }

  /*---------------------------------------------------------------*/
  private static void ashtakCalc(long hexval, int n) {
    int p, q;
    long bit;
    int[] k2 = new int[nrasi + 1];
    bit = 0x0001L;
    for (q = nrasi; q > 0; q--) {
      k2[q] = (((int) (hexval & bit)) == 0 ? 0 : 1);
      bit <<= 1;
    }
    for (q = 1; q <= nrasi; q++) {
      p = n + q - 1;
      if (p > nrasi) {
        p -= nrasi;
      }
      r3[p] += k2[q];
    }
  }

  /*---------------------------------------------------------------*/
  private static void ashtakTotal() {
    for (int q = 1; q <= nrasi; q++) {
      s3[q] += r3[q];
      r3[q] = 0;
    }
  }

  /*---------------------------------------------------------------*/
  private static void ashtakPrint(String x1) {
    int i;
    hWrite("<TR><TD>");
    pS.print(x1 + " ");
    for (i = 1; i <= nrasi; i++) {
      hWrite("</TD><TD width=30 align=center>");
      if (!html) {
        pS.print("   ");
      }
      pS.print(r3[i]);
    }
    if (!html) {
      pS.println();
    }
    hWrite("</TD></TR>");
  }

  /*---------------------------------------------------------------*/
  private static void ashtak() {
    int c, d, e, f, g, h, i, j, k, aaa;
    String dashL
        = "=========================================================";
    c = (int) (plnt[0][1] / 30.0 + 1);
    d = (int) (plnt[0][7] / 30.0 + 1);
    e = (int) (plnt[0][4] / 30.0 + 1);
    f = (int) (plnt[0][2] / 30.0 + 1);
    g = (int) (plnt[0][5] / 30.0 + 1);
    h = (int) (plnt[0][3] / 30.0 + 1);
    i = (int) (plnt[0][6] / 30.0 + 1);
    j = (int) (f2[0] / 30.0 + 1);
    pS.println();
    hWrite("<HR><TABLE width=500 align=center><TR>");
    hWrite("<a name=\"_AshtakaVargam\"></a><a href=\"#_top\">");
    pS.println("                 Ashtaka Varga Table");
    hWrite("</a></TR></TABLE>");
    if (!html) {
      pS.println(dashL);
    }
    //hWrite("</TEXTAREA>");
    hWrite("<TABLE border=3><TR><TD><H4>");
    pS.print("Raasi ");
    if (!html) {
      pS.print("    ");
    }
    for (aaa = 1; aaa < 10; aaa++) {
      hWrite("</TD><TD width=30 align=center>");
      pS.print("  " + aaa + " ");
    }
    for (aaa = 10; aaa <= 12; aaa++) {
      hWrite("</TD><TD width=30 align=center>");
      pS.print(" " + aaa + " ");
    }
    if (!html) {
      pS.println("\n" + dashL);
    }
    hWrite("</TD></H4></TR>");
    hWrite("</H4>");
    for (int q = 1; q <= nrasi; q++) {
      s3[q] = 0;
      r3[q] = 0;
    }
    ashtakCalc(0xD3E, c);
    ashtakCalc(0x246, d);
    ashtakCalc(0xD3E, e);
    ashtakCalc(0x2CF, f);
    ashtakCalc(0x0CA, g);
    ashtakCalc(0x061, h);
    ashtakCalc(0xD3E, i);
    ashtakCalc(0x347, j);
    ashtakPrint(V.grahalong[1]);   // Sun
    ashtakTotal();
    ashtakCalc(0x276, c);
    ashtakCalc(0xA66, d);
    ashtakCalc(0x6CE, e);
    ashtakCalc(0xBB6, f);
    ashtakCalc(0x937, g);
    ashtakCalc(0x3AE, h);
    ashtakCalc(0x2C2, i);
    ashtakCalc(0x246, j);
    ashtakPrint(V.grahalong[7]);  //"Moon     ");
    ashtakTotal();
    ashtakCalc(0x2C6, c);
    ashtakCalc(0x242, d);
    ashtakCalc(0xD36, e);
    ashtakCalc(0x2C2, f);
    ashtakCalc(0x047, g);
    ashtakCalc(0x053, h);
    ashtakCalc(0x93E, i);
    ashtakCalc(0xA46, j);
    ashtakPrint(V.grahalong[4]);  //"Mars    ");
    ashtakTotal();
    ashtakCalc(0x0CB, c);
    ashtakCalc(0x556, d);
    ashtakCalc(0xD3E, e);
    ashtakCalc(0xACF, f);
    ashtakCalc(0x053, g);
    ashtakCalc(0xF9A, h);
    ashtakCalc(0xD3E, i);
    ashtakCalc(0xD56, j);
    ashtakPrint(V.grahalong[2]);  //"Mercury ");
    ashtakTotal();
    ashtakCalc(0xF3E, c);
    ashtakCalc(0x4AA, d);
    ashtakCalc(0xD36, e);
    ashtakCalc(0xDCE, f);
    ashtakCalc(0xF36, g);
    ashtakCalc(0x4CE, h);
    ashtakCalc(0x2C1, i);
    ashtakCalc(0xDEE, j);
    ashtakPrint(V.grahalong[5]);  // "Jupiter");
    ashtakTotal();
    ashtakCalc(0x013, c);
    ashtakCalc(0xF9B, d);
    ashtakCalc(0x2CB, e);
    ashtakCalc(0x2CA, f);
    ashtakCalc(0x09E, g);
    ashtakCalc(0xF9E, h);
    ashtakCalc(0x39E, i);
    ashtakCalc(0xF9A, j);
    ashtakPrint(V.grahalong[3]);  // "Venus");
    ashtakTotal();
    ashtakCalc(0xD36, c);
    ashtakCalc(0x242, d);
    ashtakCalc(0x2C7, e);
    ashtakCalc(0x05F, f);
    ashtakCalc(0x0C3, g);
    ashtakCalc(0x043, h);
    ashtakCalc(0x2C2, i);
    ashtakCalc(0xB46, j);
    ashtakPrint(V.grahalong[6]);  // "Saturn ");
    ashtakTotal();
    if (!html) {
      pS.println(dashL);
    }
    hWrite("<TR color=#FFFCCC><TD>");
    pS.print(" Total  ");
    for (k = 1; k <= nrasi; k++) {
      hWrite("</TD><TD width=30 align=center>");
      pS.print("  " + s3[k]);
    }
    pS.println();
    hWrite("</TD></TR></TABLE><HR>");
    if (!html) {
      pS.println(dashL);
    }
    pageHeader();
  }

  /*---------------------------------------------------------------*/
  private static void vimsHeading(int detl) {
    String dashL = "----------------------------------------------";
    hWrite("<TABLE color=#FCCCCF border=0 width=400><TR>");
    hWrite("<TD align=left><STRONG><font color=\"red\">");
    hWrite("<a name=\"_Vimsottari_Dasa\"></a><a href=\"#_top\">");
    pS.println("            Vimsottari Dasa ");
    if (!html) {
      pS.println(dashL);
    }
    hWrite("</a></STRONG></TD></TR></TABLE>");
    /*
       pS.println(  (detl==1) ?
         "Dasa     Bhukti   AntarDasa   Date Month Year" :
         "Dasa     Bhukti     Date Month Year" );
     */
    hWrite("<TABLE border=1><TR><TD align=center>");
    if (detl == 1) {
      pS.print("Dasa  ");
      hWrite(sTDTDc);
      pS.print("   Bhukti ");
      hWrite(sTDTDc);
      pS.print("  AntarDasa ");
      hWrite(sTDTDc);
      pS.print("  Date    ");
      hWrite(sTDTDc);
      //pS.print(" Month");        hWrite(sTDTDc);
      pS.println("         Age");
    } else {
      pS.print("Dasa  ");
      hWrite(sTDTDc);
      pS.print("   Bhukti  ");
      hWrite(sTDTDc + sTDTDc);
      pS.print("   Date    ");
      hWrite(sTDTDc);
      //pS.print(" Month");        hWrite(sTDTDc);
      pS.println("         Age");
    }
    hWrite("</TD></TR>");
    if (!html) {
      pS.println(dashL);
    }
  }

  /*---------------------------------------------------------------*/
  private void vimst(int detl, int d1, int m1, int y1) {
    double d0, n0, p0, e0;
    int q, c, d, e, n, g, p, r, t, f;
    DecimalFormat fmt = new DecimalFormat("00");
    //String output = fmt.format(value);
    double a0 = (double) d1;
    double b0 = (double) m1;
    double c0 = (double) y1;
    snDate snDOB = new snDate(y1, m1, d1);
    //boolean hdg_prted = false;

    n = c = g = 0;
    t = 99;
    r = 99;
    p = 9999;
    d0 = plnt[0][7];
    d0 = 9.0 * fract(d0 / 120);
    n0 = fract(d0);
    q = (int) d0;
    p0 = n0 * V.dY[q];
    a0 = c0 + b0 / 12 + a0 / 360;
    e0 = a0 + (detl == 1 ? 75.0 : 100.0);
    b0 = a0 - p0;
    vimsHeading(detl);
    line = (detl == 1 ? 23 : 6);
    for (c = q; c <= q + 8; c++) {
      c %= 9;       //  if (c > 8) c -= 9;
      for (d = 0; d <= 8; d++) {
        n = c + d;
        n %= 9;     //  if (n > 8) n -=9;
        if (detl == 0) {
          b0 += V.dY[c] * V.dY[n] / 120;
          if (b0 < a0) {
            continue;
          }
          p = (int) b0;
          r = (int) (12 * fract(b0));
          t = (int) (30 * fract(12 * fract(b0)) + 1.0);
          if (r == 0) {
            p--;
            r = 12;
          } else if (r == 2 && t > 28) {
            t -= 28;
            r = 3;
          }
          hWrite("<TR><TD>");
          pS.print(V.dL[c] + "  ");
          hWrite("</TD><TD>");
          pS.print(V.dL[n] + "   ");
          hWrite(sTDTDc + sTDTDc);
          /*
             pS.print(fmt.format(t) + "   ");hWrite(sTDTDc);
             pS.print(fmt.format(r) + "   ");hWrite(sTDTDc);
             pS.println(p);     hWrite("</TD></TR>");
           */
          pS.print(fmt.format(t) + "-" + V.mth[r - 1] + "-" + p + " ");
          hWrite(sTDTDc);
          pS.println(snDate.dateDiff(new snDate(p, r, t), snDOB).ymd());
          hWrite("</TD></TD>");
          line++;
          if (line > 60) {
            hWrite("</TABLE>");
            pageHeader();
            vimsHeading(detl);         //hWrite("<TABLE border=6>");
            line = 6;
          }
        } else {
          for (e = 0; e <= 8; e++) {
            g = n + e;
            g %= 9;    /// if (g>8) g -= 9;
            b0 += V.dY[c] * V.dY[n] * V.dY[g] / 14400;
            if (b0 < a0) {
              continue;
            }
            p = (int) b0;
            r = (int) (12 * fract(b0));
            t = (int) (30 * fract(12 * fract(b0)) + 1.0);
            if (r == 0) {
              p--;
              r = 12;
            } else if (r == 2 && t > 28) {
              t -= 28;
              r = 3;
            }
            hWrite("<TR><TD>");
            pS.print(V.dL[c]);
            hWrite("</TD><TD>");
            pS.print("  " + V.dL[n]);
            hWrite("</TD><TD>");
            pS.print("  " + V.dL[g]);
            hWrite(sTDTDc);
            /*
               pS.print("   " + fmt.format(t)); hWrite(sTDTDc);
               pS.print("   " + fmt.format(r)); hWrite(sTDTDc);
               pS.println("   " + fmt.format(p)); hWrite("</TD></TR>");
             */
            pS.print(fmt.format(t) + "-" + V.mth[r - 1] + "-" + p + " ");
            hWrite(sTDTDc);
            pS.println(snDate.dateDiff(new snDate(p, r, t), snDOB).ymd());
            hWrite("</TD></TD>");
            line++;
            if (line > 60) {
              hWrite("</TABLE>");
              pageHeader();
              vimsHeading(detl);       //hWrite("<TABLE border=6>");
              line = 6;
            }
          }
        }
      }
      f = c + 1;
      f %= 9;      //  if (f > 8) f -= 9;
      //System.out.println(cnt_dasaend);
      dasa_end[cnt_dasaend].dasaLord = (short) c;
      dasa_end[cnt_dasaend].dasaYrs = (short) ((int) ((long) V.dY[c]));
      dasa_end[cnt_dasaend].dasaEnd = new snDate(p, r, t);
      dasa_end[cnt_dasaend].nextDasaLord = (short) f;
      //dasa_start[cnt_dasaend].dasaLord = (short)f;
      //dasa_start[cnt_dasaend].dasaYrs = (short)((int)((long) V.dY[f]));
      //dasa_start[cnt_dasaend].dasaEnd = new snDate(p,r,t);
      cnt_dasaend++;
      hWrite("<TR><TD>");
      pS.print("=========== ");
      hWrite(sTDTDc);
      pS.print(V.dL[c]);
      hWrite(sTDTDc + "<I>");
      hWrite("<a name=\"_DasaEnd" + cnt_dasaend + "\"></a>");
      hWrite("<a href=\"#_");
      hWrite(cnt_dasaend == 1 ? "Vimsottari_Dasa" : "DasaStart" + cnt_dasaend);
      hWrite("\">");
      pS.print(" Dasa Ends   ");
      hWrite("</a></I>" + sTDTDc);
      pS.print("===========");
      hWrite(sTDTDc);
      //pS.print("===");           hWrite(sTDTDc);
      pS.println("=====================");
      hWrite("</TD></TR><TR><TD>");
      line++;
      if (b0 > e0) {
        break;
      }
      pS.print("*********** ");
      hWrite(sTDTDc);
      pS.print(V.dL[f]);
      hWrite(sTDTDc + "<I>");
      hWrite("<a name=\"_DasaStart" + (cnt_dasaend + 1) + "\"></a>");
      hWrite("<a href=\"#_DasaEnd" + (cnt_dasaend + 1) + "\">");
      pS.print(" Dasa Starts ");
      hWrite("</a></I>" + sTDTDc);
      pS.print("***********");
      hWrite(sTDTDc);
      //pS.print("***");           hWrite(sTDTDc);
      pS.println("*********************");
      hWrite("</TD></TR>");
      /*
         hWrite("</TABLE><TEXTAREA>");
         pS.println("=========== " +  V.dL[c] +
           " Dasa Ends   " +"===========");
         line++;
         if (b0 > e0) break;
         pS.println("*********** " +  V.dL[f] +
           " Dasa Starts " +"***********");
         hWrite("</TEXTAREA><TABLE border=6>");
       */
      line++;
    }
    hWrite("</TABLE><HR><I>");
    if (!html) {
      pS.println("--------------------------------------------");
    }
    //hWrite("<BR>");
    hWrite("</a><a href=\"#_top\">");
    pS.println("** Dates indicated are the "
        + "ending dates of respective Dasa/Bhukti/AntarDasa.");
    //hWrite("</TEXTAREA>");
    hWrite("</a></I><HR>");
  }

  /*---------------------------------------------------------------*/
  private void snExport(long d, long m, long y,
      long h, long mt, double sec) {
    /*
       name, age, sex, addr1, addr2, dob, tob,
       nakshatra_no, dasa_end_dates[], div1_pos[], div9_pos[],
       chandra_pos
     */
    int i;
    Date curDt;
    snDate sncurDt;
    curDt = new Date();
    //snExchange snE = new snExchange();
    snE.name = name;
    snE.sex = sex;
    snE.addr1 = " ";
    snE.addr2 = " ";
    snE.place = place;
    snE.dob = new snDate((short) y, (short) m, (short) d);
    snE.tob = new snTime((short) h, (short) mt, sec);
    snE.timeZone = timeZone;
    snE.naksha = (short) (nakshatra);
    snE.tithi = tithi;
    snE.karanam = karanam;
    snE.yogam = yogam;
    snE.paada = paadaValue;
    snE.dasa = dasa_end;  //snE.dasa_start = dasa_start;
    //snE.age = (curDt.getYear()+1900 - snE.dob.yy);
    sncurDt = new snDate(curDt.getYear() + 1900,
        curDt.getMonth() + 1, curDt.getDate());
    //snE.age = new snDate();
    snE.age = snDate.dateDiff(sncurDt, snE.dob);
    int[] vrg1 = new int[nplnt + 1];
    for (i = 0; i <= nplnt; i++) {
      vrg1[i] = varga[i][0];  // Raasi
    }
    snE.vrg_1 = vrg1;
    int[] vrg9 = new int[nplnt + 1];
    for (i = 0; i <= nplnt; i++) {
      vrg9[i] = varga[i][3];  // Navamsa
    }
    snE.vrg_9 = vrg9;
    snE.npaapCnt = npaapCnt;
    snE.npaapFrom = npaapFrom;
    snE.paapas = paapCount;
    snE.chandra = plnt[0][7];
    snE.sunriseA = sun_riseA;
    snE.sunsetA = sun_setA;
    //snE.sunrise = sun_rise;
    //snE.sunset = sun_set;
    snE.longitude = longt;
    snE.latitude = lat;
    snE.ayanamsa = plnt[0][0];  // ayanamsa;
  }

  /*---------------------------------------------------------------*/
 /*
     private static void snWrite (String s) {
       switch (outOpt) {
         case 'S' : { System.out.print(s);
                    }
                    break;
         case 'F' : { pS.print(s);
                    }
                    break;
       }
     }
   */
 /*---------------------------------------------------------------*/
 /*
     private static void snWrite (char s) {
       switch (outOpt) {
         case 'S' : { System.out.print(s);
                    }
                    break;
         case 'F' : { pS.print(s);
                    }
                    break;
       }
     }
   */
 /*---------------------------------------------------------------*/
 /*
     private static void snWriteln (String s) {
       switch (outOpt) {
         case 'S' : { System.out.println(s);
                    }
                    break;
         case 'F' : { pS.println(s);
                    }
                    break;
       }
     }
   */
 /*---------------------------------------------------------------*/
 /*
     private static void snWriteln (char s) {
       switch (outOpt) {
         case 'S' : { System.out.println(s);
                    }
                    break;
         case 'F' : { pS.println(s);
                    }
                    break;
       }
     }
   */
 /*---------------------------------------------------------------*/
 /*
     private static void snWriteln () {
       switch (outOpt) {
         case 'S' : { System.out.println();
                    }
                    break;
         case 'F' : { pS.println();
                    }
                    break;
       }
     }
   */
 /*---------------------------------------------------------------*/
  private static void hWrite(String s) {
    if (html) {
      pS.println(s);
    }
  }

  /*---------------------------------------------------------------*/
 /*
     private static String insertDirName (String s, String ins) {
       int k;
       char ch, slash = '/';
       String fname = "";
       String path = "";
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
   */
 /*---------------------------------------------------------------*/
  snJatak(snPrintWriter pW, String args[]) {
    pS = pW;
    snJatak(args);
  }

  /*---------------------------------------------------------------*/
  snJatak(String args[]) {
    snJatak(args);
  }

  /*---------------------------------------------------------------*/
  public void snJatak(String args[]) {
    final String dashL = "=================================="
        + "==================================";
    int argc = 0;
    long d, m, y, j, h, mt, i;
    double sec;
    boolean snServlet = false;
    int latdeg, latmt, longdeg, longmt;
    //String place;
    char ns, ew;
    char[] news = new char[1], outOption = new char[2];
    //String versionNo = "Version 1.0 (20-Oct-2000)";
    //String versionNo = "Version 2.0 (11-Aug-2002)";
    //String versionNo = "Version 2.1 (11-Jan-2003)";
    String versionNo = "Version 2.3 (18-May-2003)";
    //DataInputStream dis = new DataInputStream(System.in);
    String nxtline;
    int detail = 0;
    int aya_deg, aya_mts;
    double aya_sec;
    double aya_val = 0.0;
    float retro_hrs;
    //boolean argsPassed;
    String outFname = "snJatak", outFext = "txt", fname = "";
    //FileOutputStream os;
    String htmlheader, htmlfooter;
    htmlheader = "<HTML><HEAD><TITLE>Your Own Jatakam - by "
        + snExchange.gn() + " " + versionNo
        + " </TITLE>";
    htmlfooter = "</BODY></HTML>";

    ret = 0;
    page = 1;
    html = false;
    argsPassed = false;
    ayana_opt = 0;
    cnt_dasaend = 0;
    for (int ii = 0; ii < dasa_end.length; ii++) {
      dasa_end[ii] = new snDasa();
      //dasa_start[ii] = new snDasa();
    }

    ps = 0.0;
    pt = 0.0;
    //PI = 3.14159265359d;
    z2 = V.PI / 180;
    s1 = 99.99826;
    //System.out.println("Args Passed ="+args.length);
    try {
      argsPassed = (args.length >= 19);
      outOpt = 'S';
      outType = 'T';
      if (!argsPassed) {
        DataInputStream dis = new DataInputStream(System.in);
        d = 0;
        m = 0;
        y = 0;
        h = 0;
        mt = 0;
        sec = 0;
        ew = ' ';
        ns = ' ';
        System.out.println("============================="
            + "======================");
        System.out.println("(C)opyright - Suresh P. Nambiar");
        System.out.println(
            "**-> You may also enter name of the File in case of \n"
            + " [F] - File Option. "
            + "(default would be \"snJatak.[htm|txt]\")\n"
            + "Eg.:-    FH Suresh "
            + "\t\t ---> Would create output in Suresh.HTM \n"
            + "         FT Suresh "
            + "\t\t ---> Would create output in Suresh.TXT ");
        System.out.println("============================="
            + "======================");
        System.out.println("Output to :- ");
        System.out.println("[ST] Screen-Text / [SH] Screen-HTML / ");
        System.out.println("[FT] File Text   / [FH] File HTML : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        if (nxtline.length() > 0) {
          nxtline.getChars(0, 2, outOption, 0);
          //outOption = outOption.toUpperCase();
          outOpt = outOption[0];
          outType = outOption[1];
          outOpt = Character.toUpperCase(outOpt);
          outType = Character.toUpperCase(outType);
          fname = nxtline.substring(2, nxtline.length());
          fname = fname.trim();
          snServlet = (outOpt == 'V');
          if (!snServlet) { // Not thru serVlet
            if (fname.length() > 0) {
              outFname = snE.insertDirName(fname, V.drvName, "snJatak");
            }
          }
        }
        System.out.println(" outOpt=" + outOpt + " outType=" + outType);
        System.out.println("Enter Name : ");
        System.out.flush();
        name = dis.readLine();
        System.out.println("Enter Sex : ");
        System.out.flush();
        sex = dis.readLine();
        System.out.println("Day (dd) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        d = Integer.parseInt(nxtline);
        System.out.println("Month (mm) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        m = Integer.parseInt(nxtline);
        System.out.println("Year (yyyy) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        y = Integer.parseInt(nxtline);
        System.out.println("Hours (HH) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        h = Integer.parseInt(nxtline);
        System.out.println("Minutes (MM) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        mt = Integer.parseInt(nxtline);
        System.out.println("Seconds (SS) : ");
        System.out.flush();
        nxtline = dis.readLine();
        sec = Double.parseDouble(nxtline);
        tob = (double) h + ((double) mt + ((double) sec / 60.0)) / 60.0;
        System.out.println("Time Zone (in Hours) : ");
        System.out.flush();
        nxtline = dis.readLine();
        timeZone = Double.parseDouble(nxtline);
        System.out.println("Place : ");
        System.out.flush();
        place = dis.readLine();
        System.out.println("Latitude (deg.) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        latdeg = Integer.parseInt(nxtline);
        System.out.println("Latitude (min.) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        latmt = Integer.parseInt(nxtline);
        ns = 'A';
        ew = 'B';
        System.out.println("North/South (N/S) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        if (nxtline.length() > 0) {
          nxtline.getChars(0, 1, news, 0);
          ns = news[0];
        }
        System.out.println("Longitude (deg.) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        longdeg = Integer.parseInt(nxtline);
        System.out.println("Longitude (min.) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        longmt = Integer.parseInt(nxtline);
        System.out.println("East/West (E/W) : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        if (nxtline.length() > 0) {
          nxtline.getChars(0, 1, news, 0);
          ew = news[0];
        }
        lat = (double) latdeg + (double) latmt / 60.0;
        if (ns == 'S' || ns == 's') {
          ns = 'S';
          lat = -lat;
        } else if (ns == 'N' || ns == 'n') {
          ns = 'N';
        }
        longt = (double) longdeg + (double) longmt / 60.0;
        if (ew == 'W' || ew == 'w') {
          ew = 'W';
          longt = -longt;
        } else if (ew == 'E' || ew == 'e') {
          ew = 'E';
        }
        System.out.println("[0]-Basic [1]-Detail : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        detail = Integer.parseInt(nxtline);
        System.out.println("Ayanamsa :- ");
        System.out.println("[0]-N.C.Lahiri [1]-B.V.Raman "
            + "[2]-Chandra Hari [3]-Other : ");
        System.out.flush();
        nxtline = dis.readLine();
        nxtline = nxtline.trim();
        ayana_opt = Integer.parseInt(nxtline);
        if (ayana_opt > 2) {
          System.out.println("Ayanamsa (deg.) : ");
          System.out.flush();
          nxtline = dis.readLine();
          nxtline = nxtline.trim();
          aya_deg = Integer.parseInt(nxtline);
          System.out.println("Ayanamsa (mts.) : ");
          System.out.flush();
          nxtline = dis.readLine();
          nxtline = nxtline.trim();
          aya_mts = Integer.parseInt(nxtline);
          System.out.println("Ayanamsa (sec.) : ");
          System.out.flush();
          nxtline = dis.readLine();
          nxtline = nxtline.trim();
          aya_sec = Double.parseDouble(nxtline);
          aya_val = (double) aya_deg
              + ((double) aya_mts + (double) aya_sec / 60.0) / 60.0;
        }
      } else {
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        //System.out.println("Arg0= "+nxtline);
        if (nxtline.length() > 0) {
          nxtline.getChars(0, 2, outOption, 0);
          //outOption = outOption.toUpperCase();
          outOpt = outOption[0];
          outType = outOption[1];
          outOpt = Character.toUpperCase(outOpt);
          outType = Character.toUpperCase(outType);
          fname = nxtline.substring(2, nxtline.length());
          fname = fname.trim();
          snServlet = (outOpt == 'V');
          if (!snServlet) { // Not thru serVlet
            if (fname.length() > 0) {
              outFname = snE.insertDirName(fname, V.drvName, "snJatak");
            }
          }
        }
        //System.out.print(" "+outOpt+outType);
        name = args[argc++];
        sex = args[argc++];
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        d = Integer.valueOf(nxtline).intValue();
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        m = Integer.valueOf(nxtline).intValue();
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        y = Integer.valueOf(nxtline).intValue();
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        h = Integer.valueOf(nxtline).intValue();
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        mt = Integer.valueOf(nxtline).intValue();
        nxtline = args[argc++];
        //sec = Double.parseDouble(nxtline);
        sec = Double.valueOf(nxtline).doubleValue();
        tob = (double) h + ((double) mt + ((double) sec / 60.0)) / 60.0;
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        //timeZone = Double.parseDouble(nxtline);
        timeZone = Double.valueOf(nxtline).doubleValue();
        place = args[argc++];
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        latdeg = Integer.valueOf(nxtline).intValue();
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        latmt = Integer.valueOf(nxtline).intValue();
        ns = 'A';
        ew = 'B';
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        if (nxtline.length() > 0) {
          nxtline.getChars(0, 1, news, 0);
          ns = news[0];
        }
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        longdeg = Integer.valueOf(nxtline).intValue();
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        longmt = Integer.valueOf(nxtline).intValue();
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        if (nxtline.length() > 0) {
          nxtline.getChars(0, 1, news, 0);
          ew = news[0];
        }
        lat = (double) latdeg + (double) latmt / 60;
        if (ns == 'S' || ns == 's') {
          ns = 'S';
          lat = -lat;
        } else if (ns == 'N' || ns == 'n') {
          ns = 'N';
        }
        longt = (double) longdeg + (double) longmt / 60;
        if (ew == 'W' || ew == 'w') {
          ew = 'W';
          longt = -longt;
        } else if (ew == 'E' || ew == 'e') {
          ew = 'E';
        }
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        detail = Integer.valueOf(nxtline).intValue();
        nxtline = args[argc++];
        nxtline = nxtline.trim();
        ayana_opt = Integer.valueOf(nxtline).intValue();

        if (ayana_opt > 2) {
          nxtline = args[argc++];
          nxtline = nxtline.trim();
          aya_deg = Integer.valueOf(nxtline).intValue();
          nxtline = args[argc++];
          nxtline = nxtline.trim();
          aya_mts = Integer.valueOf(nxtline).intValue();
          nxtline = args[argc++];
          nxtline = nxtline.trim();
          //aya_sec = Double.parseDouble(nxtline);
          aya_sec = Double.valueOf(nxtline).doubleValue();
          aya_val = (double) aya_deg
              + ((double) aya_mts + (double) aya_sec / 60.0) / 60.0;
        }
        //System.out.print(" "+name+ " " + place);
        //System.out.print(" "+round(longt,2)+ " " + ns +
        //                     " "+ round(lat,2) + " " + ew);
        //System.out.println(" Ayana="+ayana_opt+"("+DMS.dms(aya_val)+")");
      }
      outFext = (outType == 'H') ? "htm" : "txt";
      html = (outType == 'H' || outType == 'S');
      //System.out.println("Output type = " + outType + ", Extension="+outFext);
      dms.html = html;
      if (outOpt == 'F') {
        if (outType == 'H' || outType == 'T') {
          for (int kx = 0; kx < 2; kx++) {
            try {
              //os = new FileOutputStream(outFname+"."+outFext);
              File pSFD = new File(outFname + "." + outFext);
              snE.snJatakFname = pSFD.getAbsolutePath();
              //String pt = pSFD.getPath(),  fn = pSFD.getName();
              //System.out.println("Path = "+pt + "  Name = "+ fn);
              //System.out.println("pSFD Canonical Path = "+pSFD.getCanonicalPath());
              //pS = new PrintStream(new FileOutputStream(pSFD));
              pS = new snPrintWriter(new FileOutputStream(pSFD));
              //System.out.println(" File Name = "+pSFD.getPath());
              //System.out.println(" File Name = "+pSFD.getAbsolutePath());
              //pS = new PrintStream(new FileOutputStream(outFname+"."+outFext));
              if (snIOglobalSetting.getPrintWriterOn()) {
                snPrintWriter.enable(pS);
              } else {
                snPrintWriter.disable(pS);
              }

            } catch (Exception e) {
              //System.out.println("pSFD Error Hence, ");
              outFname = snE.insertDirName(outFname, V.drvName, "");
              System.out.println(e);
            }
          }
        } else if (outType == 'S') {
          // snPrintWriter is already Passed as Argument while calling this function
        }
      } else if (!snServlet) {  // Not from serVlet
        //pS = new PrintStream(System.out);
        pS = new snPrintWriter(System.out);
        if (snIOglobalSetting.getPrintWriterOn()) {
          snPrintWriter.enable(pS);
        } else {
          snPrintWriter.disable(pS);
        }

      }
      htmlheader = "<HTML><HEAD><TITLE>" + name.trim() + "'s Own Jatakam - by "
          + snExchange.gn() + " {" + versionNo
          + "}</TITLE>";
      hWrite(htmlheader);
      {
        String sTDwc = "  <TD align=\"center\" width=\"150\"><a href=\"#_";
        hWrite("<a name=\"_top\"></a>");
        hWrite("<TABLE bgcolor=\"lightyellow\"><TR>");  // lightgreen
        hWrite(sTDwc + "GrahaSthiti\">GrahaSthiti</a></TD>");
        hWrite(sTDwc + "BhaavaSthiti\">BhaavaSthiti</a></TD>");
        hWrite(sTDwc + "Saptavarga\">SaptaVarga</a></TD>");
        hWrite(sTDwc + "Paapa_Count\">PaapaSamkhya</a></TD>");
        hWrite("</TR><TR>");
        hWrite(sTDwc + V.vrg[0].trim() + "\">Raasi</a></TD>");
        if (detail == 1) {
          hWrite(sTDwc + V.vrg[1].trim() + "\">Drekkaana</a></TD>");
          hWrite(sTDwc + V.vrg[2].trim() + "\">Sapthaamsa</a></TD>");
        }
        hWrite(sTDwc + V.vrg[3].trim() + "\">Navamsa</a></TD>");
        if (detail == 1) {
          hWrite("</TR><TR>");
          hWrite(sTDwc + V.vrg[4].trim() + "\">Dasaamsa</a></TD>");
          hWrite(sTDwc + V.vrg[5].trim() + "\">DwaaDasaamsa</a></TD>");
          hWrite(sTDwc + V.vrg[6].trim() + "\">Shodasaamsa</a></TD>");
          hWrite(sTDwc + V.vrg[9].trim() + "\">Kundaamsa</a></TD>");
        }
        if (detail == 1) {
          hWrite("</TR><TR>");
        }
        hWrite(sTDwc + "AshtakaVargam\">AshtakaVargam</a></TD>");
        hWrite(sTDwc + "Vimsottari_Dasa\">Vimsottari Dasa</a></TD>");
        hWrite("</TR>");
        hWrite("</TABLE>");
      }
      hWrite("<STYLE><!-- BODY {margin-left:1.00in;");
      //hWrite("background:#FFFFFF;color:#FFFFCC;");
      hWrite("}");
      hWrite("H2{text-align:left;} ");
      //hWrite("A{color:#FF0000; font:13pt verdana}");
      hWrite("H4{text-align:center;color:#FF0000; font:14pt times}");
      hWrite("H5{text-align:center; font:50pt Wingdings}");
      hWrite("--> </STYLE>");
      j = jd(d, m, y);
      h6 = (double) h + ((double) mt + (double) sec / 60.0) / 60.0;
      //System.out.println(" Birth Hour = " + h6);
      h6 = (h6 - timeZone - 12.0) / 24.0;
      b6 = ((double) j - 694025.0 + h6) / 36525.0;
      j = (j + 4) % 7;
      while (j < 0) {
        j += 7;
      }
      //dow = j;
      init();
      lahiri_ayan = plnt[0][0] = ayan(0, y, m, d, h, mt, sec, aya_val);// Apply Lahiri's First

      retro_hrs = 0.15f;
      //retro_hrs = 1.0f;
      ret = 0;
      sun();
      mer();
      ven();
      mars();
      jup();
      sat();
      moon();
      ura();
      nep();
      plu();
      ret = 1;
      b6 += retro_hrs / 24.0 / 36525.0;
      sun();
      mer();
      ven();
      mars();
      jup();
      sat();
      moon();
      ura();
      nep();
      plu();
      b6 -= retro_hrs / 24.0 / 36525.0;

      setSayana(lahiri_ayan);
      plnt[0][0] = applyAyan(ayan(ayana_opt, y, m, d, h, mt, sec, aya_val));// Apply Specified Ayana
      ayanamsa = plnt[0][0];

      hWrite("<TABLE><TR><TD width=\"60%\" align=right rowspan=3>");
      hWrite("<H2>");
      pS.print("\n\n                Jatakam ");
      pS.println("(" + (detail == 0 ? "Basic" : "Detail") + ")");
      hWrite("</H2>");
      hWrite("</TD><TD width=100 align=center>");
      hWrite(sOMKaar);
      hWrite("</TD></TR></TABLE>");
      //hWrite("</TD><TD width=\"500\" align=right><I>");
      hWrite("<TABLE><TR><TD width=700 align=right><I>");
      pS.print("                                   ");
      pS.println(versionNo);  //hWrite("</I></TD></TR>");
      hWrite("</I></TD></TR>");
      hWrite("<TABLE><TR><TD width=650 align=right><I>");
      //hWrite("<TR><TD width=600 align=right><I>");
      if (html) {
        pS.print("<a href=\"mailto:sunambiar@yahoo.com?Subject=Jatakam Feedback\"><i>"
            + "(e-mail)</i></a>");
      } else {
        pS.print("\t\t\t\t   Author :-" + snExchange.gn());
      }
      hWrite("</I></TD></TR></TABLE>");
      if (html) {
        hWrite("<font color=\"yellow+orange\" bgcolor=\"blue\">");
        hWrite("<I><marquee style=\"filter=glow(color=yellow,strength=1)\""
            + "border=\"0\">This report was generated by Software designed &amp developed by "
            + snExchange.gn() + "... ... ...</marquee></I><HR><BR>");
      }
      pS.println();
      pS.println();
      hWrite("<BODY><TABLE width=75%><TR><TD align=\"center\">");
      //{char ch = 92;

      //hWrite("<H5>"+(char)(92)+"</H5>");
      hWrite("</TD></TR></TABLE>");
      hWrite("<TABLE><TR><TD>");
      pS.print("Name           : ");
      hWrite("</TD><TD colspan=2>");
      hWrite("<STRONG>");
      pS.print(name);
      hWrite("</TD>");
      //hWrite("<TD width=75></TD><TD></TD><TD>");
      hWrite("<TD width=\"1%\"></TD><TD>");
      pS.print("\t\tSex  : ");
      hWrite("</TD><TD>");
      hWrite("<STRONG>");
      pS.println(sex);
      hWrite("</TD></TR><TR><TD>");
      pS.print("Date of Birth  : ");
      hWrite("</TD><TD>");
      hWrite("<STRONG>");
      pS.print("" + d + "-" + V.mth[(int) m - 1] + "-" + y);
      hWrite("</TD>");
      hWrite("<TD width=75>");
      hWrite("<STRONG>");
      //d_o_w = V.day[(int)j];
      snE.dow_No = (short) j;
      snE.dow = V.day[(int) j];
      //System.out.println("Day of Week " + snE.dow);
      pS.println(" (" + V.day[(int) j] + ") ");
      hWrite("</TD><TD></TD><TD>");
      pS.print("Time of Birth  : ");
      hWrite("</TD><TD>");
      hWrite("<STRONG>");
      pS.print(HMS.hms(tob));
      pS.println(" (" + (timeZone >= 0.0 ? "+" : "-")
          + (timeZone >= 0.0 ? timeZone : -timeZone) + " GMT)");
      hWrite("</TD></TR></TABLE><TABLE><TR><TD>");
      pS.print("Place of Birth : ");
      hWrite("</TD><TD>");
      hWrite("<STRONG>");
      pS.println(place);
      hWrite("</TD></TR></TABLE><TABLE><TR><TD>");
      pS.print("Latitude       : ");
      hWrite("</TD><TD>");
      hWrite("<STRONG>");
      pS.println(DMS.dms(lat) + " " + ns);
      hWrite("</TD>");
      hWrite("<TD width=75></TD><TD>");
      pS.print("Longitude      : ");
      hWrite("</TD><TD>");
      hWrite("<STRONG>");
      pS.println(DMS.dms(longt) + " " + ew);
      hWrite("</TD></TR>");
      /*
          pS.println("Latitude       : " + latdeg +
                                              " deg. " + latmt + " " + ns);
          pS.println("Longitude      : " + longdeg + " deg. " +
                                              longmt + " " + ew);
       */
      hWrite("<TR><TD>");
      //pS.print("Day of Birth   : "); hWrite("</TD><TD>");
      //pS.println("" + V.day[(int)j]);
      hWrite("</TD></TR>");
      hWrite("</TABLE><TABLE border=1>");
      misc();
      hWrite("</TABLE>");
      //hWrite("<TABLE border=2>");
      misc(d, m, y, j); // Calculate Sun-rise & Sun-set
      //hWrite("</TABLE>");
      gulikan(d, m, y);  // After calculating Sun-rise and Sun-set
      hWrite("<TABLE><TR><TD>");
      pS.println("\n");
      hWrite("</TD></TR><TR><TD>");

      hWrite("<a name=\"_GrahaSthiti\"></a><a href=\"#_top\">");
      pS.println("         Graha  Sthithi     ");
      hWrite("</a></TD></TR><TR><TD>");
      if (!html) {
        pS.println(dashL);
      }
      hWrite("</TD></TR>");
      hWrite("</TABLE>");
      hWrite("<TABLE border='1'><TR>" + sTDc);
      pS.print(" Graha ");
      hWrite(sTDTDc);
      if (!html) {
        pS.print("      ");
      }
      if (html) {
        pS.print("Nirayana-Raasi");
        hWrite(sTDTDc);
        pS.print("Sayana-Raasi");
        hWrite(sTDTDc);
      }
      pS.print(" Nirayana ");
      hWrite(sTDTDc);
      if (!html) {
        pS.print(" (");
      }
      pS.print("Sayana");
      hWrite(sTDTDc);
      if (!html) {
        pS.print(") ");
      }
      if (!html) {
        pS.print("  \t");
      }
      if (!html) {
        pS.print("Raasi ");
        hWrite(sTDTDc);
      }
      pS.print("(Paada)");
      hWrite(sTDTDc);
      pS.print("Naksatra ");
      hWrite(sTDTDc);
      pS.println(" Gati");
      hWrite("</TD></TR><TR><TD>");
      if (!html) {
        pS.println(dashL);
      }
      hWrite("</TD></TR>");
      prplnt();
      hWrite("<TR><TD>");
      if (!html) {
        pS.println(dashL);
      }
      hWrite("</TD></TR><TR><TD>");
      pS.println();
      hWrite("</TD></TR></TABLE border=1>");
      bhav();
      saptavg();
      listPaapas();         /// For Horoscope matching purpose
      vgprint(detail);      /// vgprint(0) if no details required.
      ashtak();
      vimst(detail, (int) d, (int) m, (int) y);
      snExport(d, m, y, h, mt, sec);

    } catch (IOException e) {
      return;
    }
    hWrite("</H2>");
    hWrite(htmlfooter);
    if (outOpt == 'F') {
      pS.flush();
      pS.close();
    }
  }
  /*---------------------------------------------------------------*/
}

/*--------------End of Program------------Suresh P. Nambiar--20-Oct-2000---*/
