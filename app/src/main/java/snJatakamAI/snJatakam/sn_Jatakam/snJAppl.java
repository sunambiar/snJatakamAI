
package snJatakamAI.snJatakam.sn_Jatakam;

/*-------------------- snJatak Applet--------*/
//package snJatak;
/*-------------------------------------------*/
import java.awt.*;
//import java.applet.*;
//import java.text.*;
//import java.io.*;
//import java.util.*;
//import java.lang.*;

import snJatakamAI.snJatakam.sn_Jatakam.snJatak;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snVarsJ;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.DMS;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.HMS;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.snDate;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.snTime;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.snBasicDetls;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snDasa;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.snRiseSet;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.*;

/*
import snVarsJ;
import snVarsM;
import DMS;
import HMS;
import snDate;
import snTime;
import snDasa;
import snBasicDetls;
import snJatak;
import snExchange;
import snRiseSet;
import snRise;
 */
 /*-------------------------------------------*/

 /*
<applet code ="snJAppl" width=400 height=400>
<param name=fontName value=Courier>
<param name=fontSize value=14>
</applet>
 */
 /*-----------------------------------------------*/
public class snJAppl extends snAppletTemplate {
//public class snJAppl extends Applet {
    //snJatak snB = null;

    snJatak snB;
    private String ErrString = "";
    private String[] args = new String[25];
    private int argc;

    public void init() {
        argc = 0;
        args[argc++] = getParameter("snFH");
        args[argc++] = getParameter("snName");
        args[argc++] = getParameter("snSex");
        args[argc++] = getParameter("snDD");
        args[argc++] = getParameter("snMM");
        args[argc++] = getParameter("snYY");
        args[argc++] = getParameter("snHH");
        args[argc++] = getParameter("snMt");
        args[argc++] = getParameter("snSS");
        args[argc++] = getParameter("snTimeZone");
        args[argc++] = getParameter("snPlace");
        args[argc++] = getParameter("snLatDD");
        args[argc++] = getParameter("snLatMM");
        //args[argc++] = getParameter("snLatSS");
        args[argc++] = getParameter("snLatNS");
        args[argc++] = getParameter("snLongDD");
        args[argc++] = getParameter("snLongMM");
        //args[argc++] = getParameter("snLongSS");
        args[argc++] = getParameter("snLongEW");
        args[argc++] = getParameter("snSummDetl");
        args[argc++] = getParameter("snAyanamsa");
        args[argc++] = getParameter("snAyaDD");
        args[argc++] = getParameter("snAyaMM");
        args[argc++] = getParameter("snAyaSS");

        snB = new snJatak(args);

        try {
            for (int i = 0; i < argc; i++) {
                System.out.println("Items " + i + " " + args[i]);
            }

            snB = new snJatak(args);
            for (int i = 0; i < argc; i++) {
                System.out.println("Items " + i + " " + args[i]);
            }

        } catch (Exception e) {
            ErrString = " Error .. " + e;
            System.out.println(ErrString);
        }
    }

    public void start() {
    }

    public void paint(Graphics g) {
        if (snB == null) {
            String str = ".....";
            //g.drawString("Item-Before snJatak(args) ",30, 30);
            //snB = new snJatak(args);
            //str = snB.ayana_opts[0];
            //g.drawString("Item-Middle snJatak(args) ",30, 40);
            g.drawString("Nplnt = " + snB.nplnt + " " + str, 30, 60);
            g.drawString("SunRise : " + HMS.hms(snB.sun_riseA), 60, 40);
            g.drawString("SunSet  : " + HMS.hms(snB.sun_setA), 60, 56);
            g.drawString("SunRise : " + HMS.hms(snB.snE.sunriseA), 60, 70);
            g.drawString("SunSet  : " + HMS.hms(snB.snE.sunsetA), 60, 86);
            //g.drawString("Item-After snJatak(args) ",30, 80);
        }
        for (int i = 0; i < argc; i++) {
            g.drawString("Items " + i + " " + args[i], 0, (i + 1) * 12);
        }
        //g.drawString("Font : "+fontName,0,10);
        //g.drawString("Size : "+fontSize,0,26);
        /*
		String pattern = "##,##,###.00";
		double value  = 353433.4566334;
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(value);
		g.drawString(" "+value + " " + pattern + " " + output,0,50);
         */
    }
}
