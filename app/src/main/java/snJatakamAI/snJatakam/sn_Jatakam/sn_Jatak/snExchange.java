
/*--------------------------------------------------------*/
 /*               Suresh's  Jatakam - classes              */
 /*--------------------------------------------------------*/
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak;
/*--------------------------------------------------------*/
import java.io.*;

import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.*;
//import snClasses.snBasic.snDate;
//import snClasses.snBasic.snTime;
//import snClasses.snDasa;
//import snClasses.*;
/*--------------------------------------------------------*/
public class snExchange {

    public String name;
    public snDate age;
    public String sex;
    public String addr1;
    public String addr2;
    public String place;
    public snDate dob;
    public snTime tob;
    public double timeZone;
    public short dow_No;
    public String dow;
    public short dowHindu_No;
    public String dowHindu;
    public short naksha;
    public double tithi;
    public short karanam;
    public short yogam;
    public short paada;
    public snDasa dasa[];
    //snDasa dasa_start[];
    public int vrg_1[];
    public int vrg_9[];
    //int    paapa0[];
    //int    paapa1[];
    //int    paapa2[];
    public int npaapFrom;
    public int npaapCnt;
    public int paapas[][];
    public double chandra;
    public double sunrise;
    public double sunset;
    public double sunriseA;
    public double sunsetA;
    public double longitude;
    public double latitude;
    public double ayanamsa;
    public String snJatakFname;

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
    public static String compressName(String s) {
        char ch;
        int k;
        String fname = "";
        //System.out.println("Compressing =-=-==-=-==>" + s);
        s = s.trim();
        for (k = s.length() - 1; k >= 0; k--) {
            ch = s.charAt(k);
            if (ch == ' ' || ch == '\t') {
                ch = '_';
            }
            fname = ch + fname;
        }
        //System.out.println(fname);
        return (fname);
    }

    /*---------------------------------------------------------------*/
    public static String insertDirName(String s, String drv, String ins) {
        int k;
        char ch, slash = '/';
        //String slash = File.pathSeparator;    //  '/';
        String drvNo = "", fname = "", path = "", npath = "";
        //System.out.println("insertDirName(fname) = ["+s + "] drv=["+drv + "] ins=["+ins+']');
        for (k = s.length() - 1; k >= 0; k--) {
            ch = s.charAt(k);
            if (ch == '/' || ch == '\\') {
                slash = ch;
                break;
            } else if (ch == ':') {
                break;
            }
            fname = ch + fname;
        }
        //System.out.println("fname="+fname);
        fname = compressName(fname);
        //System.out.println("New fname="+fname);
        for (; k >= 0; k--) {
            ch = s.charAt(k);
            if (ch == ':') {
                drvNo = ch + drvNo;
                k--;
                ch = s.charAt(k);
                drvNo = ch + drvNo;
                k = 0;
                /*
		 path = ch + path;
		 k--;
		 ch = drv.trim().charAt(0);
		 k = 0;  // Break/Terminate Start of Path found !!
                 */
            } else {
                path = ch + path;
            }
        }
        //System.out.println("Path="+path);
        path = path + ins;
        //System.out.println(path);
        npath = path;
        path = drvNo + path;
        for (int kx = 0; kx < 2; kx++) {
            boolean created;
            try {
                String pName = path;
                {
                    File f = new File(pName);
                    created = f.mkdirs();
                    //System.out.println("Create File 1:"+pName+" " + created);
                    //pName = f.getAbsolutePath();
                }
                {
                    File f = new File(pName);
                    FilePermission fp = new FilePermission(pName, "read,write");
                    //System.out.println("File Permission = "+fp.getActions());
                    created = f.isDirectory() && f.canWrite() ? true : f.mkdirs();
                    //System.out.println("Create File 2:"+pName+" " + created);
                }
                File f = new File(pName);
                if (f.isDirectory() && f.canWrite()) {
                    path = f.getAbsolutePath();
                    //System.out.println(" New path = " + path);
                    //path = f.getCanonicalPath();
                    //System.out.println(" New Canonical path = " + path);
                    kx = 10;  // exit
                    break;
                }
            } catch (SecurityException se) {
                System.out.println(" Dir creation error : " + path);
            } catch (Exception e) {
                System.out.println(" Exception @mkdirs() [" + path + "] :" + e);
            }
            path = (kx == 0) ? drv.trim() + npath : (kx < 5) ? drvNo + npath : path;
        }
        //System.out.println(path + slash + fname);
        path = path + slash + fname;
        if (fname.trim().length() > 0) {
            try {
                File f = new File(path);
                path = f.getAbsolutePath();
                //System.out.println(" New Final absolute path = " + path);
            } catch (Exception e) {
                System.out.println(" Exception file-path " + path + slash + fname);
            }
        }
        //return (path + slash + fname);
        //System.out.println("==========================");
        return (path);
    }

    /*---------------------------------------------------------------*/
    public static String gn() {
        String ss = "&copy; Suresh P. Nambiar";
        /*
       int ch;
       String ss1="+^�}z~s+[9+Ylxmtl}";
       ss = "";
       for (int i=0; i<ss.length(); i++) {
		 ch = (ss1.charAt(i).toAscii() - 11);
		 ss = ss + ch.toCode();
	   }
         */
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
        return (short) (((kp - ks + 12) % 12) + 1);
    }
    /*------------------------------------------------------------------*/
}
/*-------------------------- For Horoscope -----------------------*/
