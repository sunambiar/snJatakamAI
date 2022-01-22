package snJatakamAI.snJatakam.sn_Jatakam;

/*---------------------------------------------------------------*/
import java.io.*;
//import java.util.*;
//import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.snDate;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.snTime;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.DMS;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.snBasicDetls;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snExchange;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snVarsJ;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snVarsM;
//import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.*;
/*---------------------------------------------------------------*/

 /*---------------------------------------------------
        Suresh's Horoscope Matchmaker
-----------------------------------------------------*/
//#define TRUE 1
public class snMatch {

    static char outOpt, outType;
    static PrintWriter pS = null, pP = null, pM = null, pI = null;
    static boolean snServlet = false;
    static boolean html = false;
    static int detail = 0;
    static snVarsJ J = new snVarsJ();
    static snVarsM M = new snVarsM();
    double poruthaVal = 0.0, poruthaValCutOff = 0.0;

    //static final int nplnt = 13;  // Including Gulika(Maandi)
    //static final int nrasi = 12;  // No. of Rasis
    //static final double PI = 3.1415926535897932384626433832795;
    // 3.14159265359d;
    static final String sTDc = "<TD align=center>";
    static final String sTDj = "<TD align=justify>";
    static final String sTDTDc = "</TD>" + sTDc;
    static final String sTDTDj = "</TD>" + sTDj;

    /*------------------------------------------------------------------*/
    private class sandhi {

        short graha;
        short yrs;
        snDate dt;
        short nextGraha;

        sandhi(short gr, short yr, snDate d, short nxtGr) {
            graha = gr;
            dt = d;
            yrs = yr;
            nextGraha = nxtGr;
        }

        sandhi(sandhi sd) {
            graha = sd.graha;
            dt = sd.dt;        //dt = new snDate(sd.dt);
            yrs = sd.yrs;
            nextGraha = sd.nextGraha;
        }
    }

    /*------------------------------------------------------------------*/
    private short nthHouse(int from, int n) {
        return (short) ((from + n - 1 + 12) % 12);
    }

    /*------------------------------------------------------------------*/
    private short nthNakshatra(int from, int n) {
        return (short) ((from + n - 1 + 27) % 27);
    }

    /*------------------------------------------------------------------*/
 /*
     private short bhaavaDiff(int kp, int ks) {
       return (short)(((kp - ks +  12) % 12) + 1);
     }
     */
 /*------------------------------------------------------------------*/
    private short nakshatraDiff(int np, int ns) {
        return (short) (((np - ns + 27) % 27) + 1);
    }

    /*------------------------------------------------------------------*/
    private short paadaDiff(manushya p, manushya s) {
        int ppaada, spaada, ret;
        ppaada = (p.naksha - 1) * 4 + p.paadam;
        spaada = (s.naksha - 1) * 4 + s.paadam;
        ret = (ppaada - spaada + 1 + 108) % 108;
        if (ret == 0) {
            ret = 108;
        }
        return ((short) ret);
    }

    /*------------------------------------------------------------------*/
 /*
     private short paadaDiff(double np, double ns) {
       int ppaada, spaada, ret;
       ppaada = (int)(0.3 * np) + 1;
       spaada = (int)(0.3 * ns) + 1;
       ret = (ppaada - spaada + 1 + 108) % 108;
       if (ret == 0) ret = 108;
       return ((short)ret);
     }
     */
 /*------------------------------------------------------------------*/
    private boolean ashtamashashtam(int p, int s) {
        return (snExchange.bhaavaDiff(p, s) == 8);
    }

    /*------------------------------------------------------------------*/
    private boolean shashtashtamam(int p, int s) {
        return (snExchange.bhaavaDiff(p, s) == 6);
    }

    /*------------------------------------------------------------------*/
    private short koorAdhipa(int koor) {
        return (M.rasi[koor].adhipa[0]);
    }

    /*------------------------------------------------------------------*/
    private class manushya {

        Boolean flag;
        /* Flag showing Updated or Not  */
        String name;
        /* Name of the person           */
        snDate age;
        /* Age                          */
        String sex;
        /* Sex                          */
        String addr1;
        /* Address...                   */
        String addr2;
        /*                              */
        String place;
        /* Place of Birth               */
        double longitude;
        /* Longitude of Place of Birth  */
        double latitude;
        /* Latitude of Place of Birth   */
        snDate d_o_b;
        /* Date of Birth                */
        snTime t_o_b;
        /* Time of Birth                */
        double timeZone;
        /* Time Zone                    */
        String dow;
        /* Day of Week                  */
        String dowHindu;
        /* Day of Week (Hindu)          */
        snDate dasa_bal;
        /* Birth Dasa Balance           */
        snDate firstDasaEnds;
        /* Date when first Dasa Ends    */
        //short dasa_endYr[];      /* Year when each dasa ends (12)*/
        short nrasi[];
        /* No. of Grahas in each Rasi (12)*/
        short sthithi[];
        /* Rasi where each Graha stands (10)*/
        short amsa9sthithi[];
        /* NavamsaRasi - graha sthithi  */
        double chandra;
        /* Position of Chandra          */
        short naksha;
        /* Nakshatra of the person      */
        short paadam;
        /* Nakshatra Paadam             */
        short porutham[];
        /* Porutham Array (PORUTHAMS)   */
        sandhi dasas[];
        /* Dasa Periods (12)            */
        sandhi sandi[];
        /* Dasa Sandhi Periods (12)     */
        int npaapFrom;
        int npaapCnt;
        int paapas[][];
        /* Lagnal, Chandral, Shukral(GRAHAS+1(RAASIS+1)*/
        String snJatakRef;
        /* Jataka Reference filename    */
        private int i, j;

        public short kooru() {
            return (sthithi[M.SASI]);
        }

        manushya(snExchange sE) {
            //sandhi[] tmp_sndi = new sandhi[M.GRAHAS+1];
            name = sE.name;
            age = sE.age;
            sex = sE.sex;
            snJatakRef = sE.snJatakFname;
            addr1 = sE.addr1;
            addr2 = sE.addr2;
            place = sE.place;
            longitude = sE.longitude;
            latitude = sE.latitude;
            d_o_b = sE.dob;
            t_o_b = sE.tob;
            timeZone = sE.timeZone;
            dow = sE.dow;
            dowHindu = sE.dowHindu;
            //System.out.println(dow + " " + dowHindu);
            dasa_bal = snDate.dateDiff(sE.dasa[0].dasaEnd, d_o_b);
            naksha = sE.naksha;
            naksha++;
            chandra = sE.chandra;
            paadam = sE.paada;
            sthithi = new short[M.GRAHAS + 1];
            amsa9sthithi = new short[M.GRAHAS + 1];
            nrasi = new short[M.RAASIS + 1];
            //dasa_endYr = new short[M.GRAHAS+1];
            porutham = new short[M.PORUTHAMS];
            npaapFrom = sE.npaapFrom;
            npaapCnt = sE.npaapCnt;
            //paapas = new int[npaapFrom][npaapCnt];
            //System.out.println(" paapFrom="+npaapFrom+ " paapCnt="+npaapCnt);
            //System.out.println("Chandra = " + sE.chandra);
            //dasas = new sandhi[M.GRAHAS+1];
            for (i = 0; i <= M.RAASIS; i++) {
                nrasi[i] = 0;
                //dasa_endYr[i] = 0;
            }
            /*
         for (i=0; i < npaapFrom; i++) {
           //paapas[i] = new short[M.RAASIS+1];
           for (j=0; j < npaapCnt; j++) paapas[i][j] = 0;
         }
             */
            for (i = 0; i <= M.GRAHAS; i++) {
                sthithi[i] = (short) (sE.vrg_1[i] % 12);
                amsa9sthithi[i] = (short) (sE.vrg_9[i] % 12);
                //System.out.print(sthithi[i]+" ");
                nrasi[sthithi[i]]++;
                //dasa_endYr[i] = sE.dasa[i].dasaEnd.yy;
            }
            for (i = 0; sE.dasa[i].dasaEnd != null && i <= M.GRAHAS; i++) {
            };
            //System.out.println(" No of Dasas ==== > " + i);
            dasas = new sandhi[i];
            for (i = 0; i < dasas.length; i++) {
                dasas[i] = new sandhi(M.dasa_grh[sE.dasa[i].dasaLord],
                        sE.dasa[i].dasaYrs, sE.dasa[i].dasaEnd,
                        M.dasa_grh[sE.dasa[i].nextDasaLord]);
            }
            paapas = sE.paapas;
        }
    }

    /*------------------------------------------------------------------*/
    private String getAbsolutePath(String ofname) {
        File pSFD = new File(ofname);
        return (pSFD.getAbsolutePath());
    }

    /*------------------------------------------------------------------*/
    public snMatch(PrintWriter wP, PrintWriter wS, PrintWriter wM, PrintWriter wI,
            String FH, String ArgsB[], String ArgsG[],
            int dtl, double poruthValCtOff) {
        pI = wI;
        pM = wM;
        pS = wS;
        pP = wP;
        get_snMatch(ArgsB, dtl, ArgsG, poruthValCtOff, "VH");
    }

    /*------------------------------------------------------------------*/
    public snMatch(String ArgsB[], int detail, String ArgsG[],
            double poruthaValCutOff, String FH) {
        //System.out.println(" About to go to get_snMatch thru snMatch(5)");
        get_snMatch(ArgsB, detail, ArgsG, poruthaValCutOff, FH);
    }

    /*------------------------------------------------------------------*/
    private void get_snMatch(String ArgsB[], int detail, String ArgsG[],
            double poruthaValCutOff, String FH) {
        String nxtline, boyFname, girlFname, xB_fname, xG_fname;
        String outFname = "snMatch", outFext = "txt", fname = "";
        String outFname1 = outFname;
        char[] outOption = new char[2];
        int nboys, ngirls, i, j;
        String ofname, idxFname = "snIndex.htm";
        //idxFname = snExchange.insertDirName(idxFname,"snIndex");

        //snExchange.insertDirName("suresh","Nambiar");  // Has inserted a Dir in C:\
        //System.out.println(" FH String ===> " + FH);
        nxtline = FH.trim();
        if (nxtline.length() > 0) {
            nxtline.getChars(0, 2, outOption, 0);
            outOpt = outOption[0];
            outType = outOption[1];
            outOpt = Character.toUpperCase(outOpt);
            outType = Character.toUpperCase(outType);
            fname = nxtline.substring(2, nxtline.length());
            //System.out.println(" ----> FNAME = " + fname);
            fname = snExchange.compressName(fname);
            snServlet = (outOpt == 'V');
            //if (fname.length() <= 0) fname = "snMatch";
            if (!snServlet) {
                //System.out.println(" ---->2 FNAME = " + fname);
                outFname = snExchange.insertDirName(fname, J.drvName, "snMatch");
            }
        }
        snServlet = (outOpt == 'V');
        if (!snServlet) {
            //System.out.println(" ----> IDX FNAME = " + fname);
            idxFname = snExchange.insertDirName(idxFname, J.drvName, "snIndex");
        }
        outFext = (outType == 'H') ? "htm" : "txt";
        html = (outType == 'H');
        snJatak j_boy = new snJatak(pP, ArgsB);
        snExchange xB;  // = new snExchange();
        xB = j_boy.snE;
        manushya purusha = new manushya(xB);
        xB_fname = xB.compressName(purusha.name);
        if (!snServlet) {
            idxFname = getAbsolutePath(idxFname);
            try {
                pI = new PrintWriter(new FileOutputStream(idxFname));
            } catch (Exception e) {
            }
        }
        pI.println("<HTML><TITLE>Index of Horoscope Compatibilities");
        pI.println("</TITLE>");
        //<STRONG><BR><BR>");
        //pI.println(" Index of Horoscope Compatibilities<BR><BR>");
        /*
       pI.println("<STYLE><!-- BODY {margin-left:1.00in;");
       //pI.println("background:#FFFFFF;color:#FFFFCC;");
       pI.println("}");
       pI.println("H2{text-align:left;} A{color:#FF0000; font:13pt verdana}");
       pI.println("H4{text-align:center;color:#FF0000; font:14pt times}");
       pI.println("--> </STYLE>");
         */
        pI.println("<H2>");
        pI.print("\n\n Index of Horoscope Compatibilities<BR><BR>");
        pI.println("</H2>");
        pI.println("<TABLE BORDER=1>");

        snJatak j_girl = new snJatak(pS, ArgsG);
        snExchange xG;   // = new snExchange();
        xG = j_girl.snE;
        manushya stree = new manushya(xG);
        if (outOpt == 'F' || snServlet) {
            ofname = stree.name;
            xG_fname = xB.compressName(stree.name);
            //outFname1 = outFname.trim() + "_" + i + "_" + j;
            outFname1 = outFname.trim() + "_" + xB_fname + "_" + xG_fname;
            ofname = outFname1 + "." + outFext;
            if (outOpt == 'F') {
                ofname = snExchange.insertDirName(ofname, J.drvName, "");
                /*for (int kx = 0; kx < 2; kx++)*/ {
                    try {
                        pS = new PrintWriter(new FileOutputStream(ofname));
                    } catch (Exception e) {
                        ofname = J.drvName + ofname;
                        System.out.println(e + "\n New ofname=" + ofname);
                    }
                }
                ofname = getAbsolutePath(ofname);
            } else if (snServlet) {
                //pI = PrintWriter (Passed Value)
                //pP = PrintWriter (Passed Value)
                //pS = PrintWriter (Passed value)
            }
            pI.println("<TR><TD width=450>" + "<A HREF=\"" + ofname + "\">");
            pI.println(purusha.name.trim() + M.sWITH + stree.name.trim());
            pI.println("</A></TD>");
        } else {
            pS = new PrintWriter(System.out);
        }
        match_hors(purusha, stree);
        System.out.println(M.sPOR_VALUE + poruthaVal);
        pI.println("<TD>" + "<A HREF=\"");
        pI.print(purusha.snJatakRef + "\">" + purusha.name.trim());
        pI.println("</A></TD>");
        pI.println("<TD>" + "<A HREF=\"");
        pI.print(stree.snJatakRef + "\">" + stree.name.trim());
        pI.println("</A></TD>");
        if (poruthaVal >= poruthaValCutOff) {
            reports(purusha, stree, pS);
        }
        if (outOpt == 'F') {
            pS.flush();
            pS.close();
        }
        pI.println("</TR>");
        pI.println("</TABLE></BODY></HTML>");
        pI.flush();
        pI.close();
    }

    /*------------------------------------------------------------------*/
    public snMatch(String args[]) {
        DataInputStream dis = new DataInputStream(System.in);
        String nxtline, boyFname, girlFname, xB_fname, xG_fname;
        String outFname = "snMatch", outFext = "txt", fname = "";
        String outFname1 = outFname;
        char[] outOption = new char[2];

        try {
            System.out.println("============================="
                    + "======================");
            System.out.println(
                    "**-> You may also enter name of the File in case of \n"
                    + " [F] - File Option. "
                    + "(default would be \"snMatch.[htm|txt]\")\n"
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
                outOpt = outOption[0];
                outType = outOption[1];
                outOpt = Character.toUpperCase(outOpt);
                outType = Character.toUpperCase(outType);
                fname = nxtline.substring(2, nxtline.length());
                fname = snExchange.compressName(fname);
                //if (fname.length() <= 0) fname = "snMatch";
                System.out.println("363: fname=" + fname);
                outFname = snExchange.insertDirName(fname, J.drvName, "snMatch");
            }
            outFext = (outType == 'H') ? "htm" : "txt";
            html = (outType == 'H');
            //System.out.println(" outOpt="+outOpt+" outType="+outType);
            {
                snBasicDetls b_boy = new snBasicDetls();
                snBasicDetls b_girl = new snBasicDetls();
                int nboys, ngirls, i, j;
                String ofname, idxFname = "snIndex.htm";
                idxFname = snExchange.insertDirName(idxFname, J.drvName, "snIndex");

                System.out.println("Enter Filename with Boy's data : ");
                System.out.flush();
                boyFname = dis.readLine();

                nboys = b_boy.loadBasicDetails(boyFname);

                System.out.println("Enter Filename with Girl's data : ");
                System.out.flush();
                girlFname = dis.readLine();

                ngirls = b_girl.loadBasicDetails(girlFname);

                System.out.println("[0]-Summary [1]-Detail : ");
                System.out.flush();
                nxtline = dis.readLine();
                nxtline = nxtline.trim();
                detail = Integer.parseInt(nxtline);

                System.out.println("Porutha Value cut-off at... : ");
                System.out.flush();
                nxtline = dis.readLine();
                nxtline = nxtline.trim();
                poruthaValCutOff = Double.parseDouble(nxtline);
                idxFname = getAbsolutePath(idxFname);
                pI = new PrintWriter(new FileOutputStream(idxFname));
                pI.println("<HTML><TITLE>Index of Horoscope Compatibilities");
                pI.println("</TITLE>");
                //<STRONG><BR><BR>");
                //pI.println(" Index of Horoscope Compatibilities<BR><BR>");
                /*
           pI.println("<STYLE><!-- BODY {margin-left:1.00in;");
           //pI.println("background:#FFFFFF;color:#FFFFCC;");
           pI.println("}");
           pI.println("H2{text-align:left;} A{color:#FF0000; font:13pt verdana}");
           pI.println("H4{text-align:center;color:#FF0000; font:14pt times}");
           pI.println("--> </STYLE>");
                 */
                pI.println("<H2>");
                pI.print("\n\n Index of Horoscope Compatibilities<BR><BR>");
                pI.println("</H2>");

                pI.println("<TABLE BORDER=1>");

                for (i = 0; i < nboys; i++) {
                    snJatak j_boy = new snJatak(b_boy.token[i]);
                    snExchange xB;  // = new snExchange();
                    xB = j_boy.snE;
                    manushya purusha = new manushya(xB);
                    xB_fname = xB.compressName(purusha.name);
                    for (j = 0; j < ngirls; j++) {
                        snJatak j_girl = new snJatak(b_girl.token[j]);
                        snExchange xG;   // = new snExchange();
                        xG = j_girl.snE;
                        manushya stree = new manushya(xG);
                        if (outOpt == 'F' || outOpt == 'V') {
                            ofname = "";
                            if (outOpt == 'F') {
                                xG_fname = xB.compressName(stree.name);
                                //outFname1 = outFname.trim() + "_" + i + "_" + j;
                                outFname1 = outFname.trim() + "_" + xB_fname + "_" + xG_fname;
                                ofname = outFname1 + "." + outFext;
                                ofname = snExchange.insertDirName(ofname, J.drvName, "");
                                pS = new PrintWriter(new FileOutputStream(ofname));
                                ofname = getAbsolutePath(ofname);
                            } else if (outOpt == 'V') {
                                //pS =  PrintWriter (Passed value)
                            }
                            pI.println("<TR><TD width=450>" + "<A HREF=\"" + ofname + "\">");
                            pI.println(purusha.name.trim() + M.sWITH + stree.name.trim());
                            pI.println("</A></TD>");
                        } else {
                            pS = new PrintWriter(System.out);
                        }
                        match_hors(purusha, stree);
                        System.out.println(M.sPOR_VALUE + poruthaVal);
                        pI.println("<TD>" + "<A HREF=\"");
                        pI.print(purusha.snJatakRef + "\">" + purusha.name.trim());
                        pI.println("</A></TD>");
                        pI.println("<TD>" + "<A HREF=\"");
                        pI.print(stree.snJatakRef + "\">" + stree.name.trim());
                        pI.println("</A></TD>");
                        if (poruthaVal >= poruthaValCutOff) {
                            reports(purusha, stree, pS);
                        }
                        if (outOpt == 'F') {
                            pS.flush();
                            pS.close();
                        }
                        pI.println("</TR>");
                    }
                }
                pI.println("</TABLE></BODY></HTML>");
                pI.flush();
                pI.close();
            }
        } catch (IOException e) {
            return;
        }
    }

    /*------------------------------------------------------------------*/
    public static void main(String args[]) {
        System.out.println("Access thru ------------------>");
        snMatch sM = new snMatch(args);
    }

    /*------------------------------------------------------------------*/
    private int findpaapa(manushya p) {
        int npaapa;
        npaapa = p.paapas[M.LAGNA_P][M.TOTAL_PAP] * 4
                + p.paapas[M.SASI_P][M.TOTAL_PAP] * 2
                + p.paapas[M.SUKRA_P][M.TOTAL_PAP] * 1;
        //System.out.println(" Paapa 0 = " + p.paapas[M.LAGNA_P][M.TOTAL_PAP]);
        //System.out.println(" Paapa 1 = " + p.paapas[M.SASI_P][M.TOTAL_PAP]);
        //System.out.println(" Paapa 2 = " + p.paapas[M.SUKRA_P][M.TOTAL_PAP]);
        return (npaapa);
    }

    /*------------------------------------------------------------------*/
    private short raasiporutham(manushya p, manushya s) {
        short ret;
        short kp, ks, sh;
        //short svnthhouse;
        ret = M.NODOSHAM;
        //System.out.println(" Nakshatras = "+p.naksha+" " + s.naksha);
        kp = p.kooru();
        ks = s.kooru();
        //System.out.println(" Kooru = "+kp + " " + ks);
        //svnthhouse = nthHouse(ks, 7);
        //System.out.println(" SeventhHouse= "+svnthhouse);
        //System.out.println("====== RAsiPorutham  ====" + kp + " " + ks);
        //System.out.println(" Ret = "+ret+ " (Uthamam="+M.UTHAMAM+", Adhamam="+M.ADHAMAM+")");
        ret |= (snExchange.bhaavaDiff(kp, ks) >= 7) ? M.UTHAMAM : M.ADHAMAM;
        //System.out.println(" Ret = "+ret);
        /*
       ret |= ((ks < 6) ? ((kp > ks) && kp >= svnthhouse)
                    : ((kp <= ks) && (kp >= svnthhouse))  ) ?
                    M.UTHAMAM : M.ADHAMAM;
         */
        if (ashtamashashtam(kp, ks)) {
            ret |= M.MADHYAMAM;
        }
        //System.out.println(" after AshtamaShashtamam Ret = "+ret);
        /*
       if (paadam(p) <= paadam(s))  ret |= M.UTHAMAM;
       if (paadamDiff(p,s) == 108)  ret |= M.ADHAMAADHAMAM;
         */
        if (p.naksha == s.naksha) {
            if ((p.naksha == M.BHARANI)
                    || (p.naksha == M.ROHINI)
                    || (p.naksha == M.THIRUVATHIRA)
                    || (p.naksha == M.POOYAM)
                    || (p.naksha == M.AYILYAM)
                    || (p.naksha == M.MAKAM)
                    || (p.naksha == M.ATHAM)
                    || (p.naksha == M.TRIKKETA)
                    || (p.naksha == M.MOOLAM)
                    || (p.naksha == M.POORADAM)
                    || (p.naksha == M.AVITTOM)
                    || (p.naksha == M.CHATAYAM)) {
                ret |= M.ADHAMAM;
            }
        }
        //System.out.println(" after AshtamaShashtamam Ret = "+ret);
        if (((ks == M.MEDAM) || (ks == M.KARKKIDAKAM))
                && (5 == snExchange.bhaavaDiff(kp, ks))) {
            ret |= M.UTHAMAM;
        }
        //System.out.println(" Before Last (shashtashtamam) Ret = "+ret);
        if ((ks == M.EDAVAM)
                || (ks == M.KARKKIDAKAM)
                || (ks == M.KANNI)
                || (ks == M.VRISCHIKAM)
                || (ks == M.MAKARAM)
                || (ks == M.MEENAM)) {
            if (shashtashtamam(kp, ks)) {
                ret |= M.ADHAMAM;
            }
            /* else ret |= M.UTHAMAM; */
        }
        //System.out.println(" Before Return Ret = "+ret);
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short bandhu(manushya p, manushya s) {
        int i, j, k;
        short kp, ks;
        short kpadhipa, ksadhipa;
        short ret = 0;
        kp = p.kooru();
        ks = s.kooru();
        kpadhipa = koorAdhipa(kp);
        ksadhipa = koorAdhipa(ks);
        if (kpadhipa == ksadhipa) {
            ret = 1;
        }
        if (ret == 0) {
            k = M.grah[ksadhipa].poruthabandhu.length;
            for (i = 0; i < k; i++) {
                j = M.grah[ksadhipa].poruthabandhu[i];
                if ((j > 0) && (kpadhipa == j)) {
                    ret = 1;
                    break;
                }
            }
        }
        if (ret == 0) {
            k = M.grah[ksadhipa].bandhu.length;
            for (i = 0; i < k; i++) {
                j = M.grah[ksadhipa].bandhu[i];
                if ((j > 0) && (kpadhipa == j)) {
                    ret = 1;
                    break;
                }
            }
        }
        if (ret == 0) {
            k = M.grah[ksadhipa].sama.length;
            for (i = 0; i < k; i++) {
                j = M.grah[ksadhipa].sama[i];
                if ((j > 0) && (kpadhipa == j)) {
                    ret = 2;
                    break;
                }
            }
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short raasyadhipaporutham(manushya p, manushya s) {
        short ret;
        short bndu;
        /*
       switch (bandhu(p,s)) {
         default        :  ret = M.ADHAMAM;  break;
         case  1        :  ret = M.UTHAMAM;  break;
         case  2        :  ret = M.MADHYAMAM; break;
       }
         */
        bndu = bandhu(p, s);
        ret = ((bndu == 1) ? M.UTHAMAM
                : (bndu == 2) ? M.MADHYAMAM : M.ADHAMAM);
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short vasyaporutham(manushya p, manushya s) {
        short kp, ks;
        int i;
        short ret;
        ret = M.ADHAMAM;
        kp = p.kooru();
        ks = s.kooru();
        for (i = 0; i < M.rasi[kp].vasya.length; i++) {
            if (M.rasi[kp].vasya[i] == ks) {
                ret = M.UTHAMAM;
                break;
            }
        }
        if (ret == M.ADHAMAM) {
            for (i = 0; i < M.rasi[ks].vasya.length; i++) {
                if (M.rasi[ks].vasya[i] == kp) {
                    ret = M.UTHAMAM;
                    break;
                }
            }
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short mahendraporutham(manushya p, manushya s) {
        short ret;
        ret = M.ADHAMAM;
        switch (nakshatraDiff(p.naksha, s.naksha)) {
            default:
                break;
            case 4:
            case 7:
            case 10:
            case 13:
            case 16:
            case 19:
            case 25:
                /* case 22 : -- 88 paada dosha !! */
                ret = M.UTHAMAM;
                break;
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short ganaporutham(manushya p, manushya s) {
        short gp, gs;
        short ret;
        ret = M.ADHAMAM;
        gp = M.naksha[p.naksha].ganam;
        gs = M.naksha[s.naksha].ganam;
        if (gs == gp) {
            ret = M.UTHAMAM;
        } else if ((gs == M.DEVAM) && (gp == M.MAANUSHAM)) {
            ret = M.MADHYAMAM;
        } else if ((gs == M.DEVAM) && (gp == M.AASURAM)) {
            ret = M.ADHAMAM;
        } else if ((gs == M.MAANUSHAM) && (gp == M.AASURAM)) {
            ret = M.ATIDOSHAM;
        } else if ((gs == M.AASURAM) && (gp == M.MAANUSHAM)) {
            ret = M.ATYANTADOSHAM;
        }
        if (STREEDEERGHAM(p, s)) {
            ret |= M.PARIHAARAM;
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short streedeergham(manushya p, manushya s) {
        short nakshdiff;
        //short np, ns, fnakshatra;
        short ret;
        ret = M.ADHAMAM;
        //np = p.naksha;           ns = s.naksha;
        nakshdiff = nakshatraDiff(p.naksha, s.naksha);
        ret = (nakshdiff >= 14) ? M.UTHAMAM : (nakshdiff < 8)
                ? M.ADHAMAM : M.MADHYAMAM;
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private boolean STREEDEERGHAM(manushya p, manushya s) {
        return ((streedeergham(p, s) & M.UTHAMAM) > 0);
    }

    /*------------------------------------------------------------------*/
    private short yoniporutham(manushya p, manushya s) {
        short yp, ys;
        short ret;
        ret = M.ADHAMAM;
        yp = M.naksha[p.naksha].yoni;
        ys = M.naksha[s.naksha].yoni;
        if (yp == M.PURUSHA && ys == M.STREE) {
            ret = M.UTHAMAM;
        } else if (yp == ys) {
            if (yp == M.STREE) {
                ret = M.MADHYAMAM;
            } else {
                ret = M.ADHAMAM;
            }
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private boolean aarohanam(int nk) {
        boolean ret;
        switch (nk % 6) {
            default:
                ret = false;
                break;
            case 1:
            case 2:
            case 3:
                ret = true;
                break;
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short rajjuporutham(manushya p, manushya s) {
        short rpn, rsn;
        short ret;
        rpn = M.naksha[p.naksha].rajju;
        rsn = M.naksha[s.naksha].rajju;
        ret = M.UTHAMAM;
        if (rpn == rsn) {
            if (rpn == M.MADHYA) {
                ret = M.ATYANTADOSHAM;
            }
            if (aarohanam(p.naksha) != aarohanam(s.naksha)) {
                ret = M.SAAMANYADOSHAM;
            } else {
                ret |= M.DOSHAM;
            }
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short aayavyayaporutham(manushya p, manushya s) {
        int vyayam, aayam;
        short ret;
        vyayam = (nakshatraDiff(p.naksha, s.naksha) * 5) % 7;
        aayam = (nakshatraDiff(s.naksha, p.naksha) * 5) % 7;
        ret = (aayam > vyayam) ? M.UTHAMAM : (aayam == vyayam)
                ? M.MADHYAMAM : M.ADHAMAM;
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short vayaporutham(manushya p, manushya s) {
        short ret;
        double p_age, s_age;
        p_age = p.age.years();
        s_age = s.age.years();
        ret = M.ADHAMAM;
        if (p_age <= s_age) {
            ret = M.NISHIDHAM;
        } else if ((p_age - s_age) >= 8) {
            ret = M.UTHAMAM;
        } else if ((p_age - s_age) >= 4) {
            ret = M.MADHYAMAM;
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short dinaporutham(manushya p, manushya s) {
        short ret;
        ret = M.UTHAMAM;
        switch (nakshatraDiff(p.naksha, s.naksha)) {
            case 3:
            case 7:
                ret |= M.ADHAMAM;
                break;
            case 5:
                ret |= M.MADHYAMAM;
                break;
            case 12:
                if (p.paadam == 1) {
                    ret |= M.ADHAMAM;
                }
                break;
            case 14:
                if (p.paadam == 4) {
                    ret |= M.ADHAMAM;
                }
                break;
            case 16:
                if (p.paadam == 3) {
                    ret |= M.ADHAMAM;
                }
                break;
            case 21:
            case 23:
            case 25:
                switch ((p.naksha - 1) % 3) {
                    case 0:
                        if (p.paadam == 1) {
                            ret |= M.ADHAMAM;
                        }
                        break;
                    case 1:
                        if (p.paadam == 1 || p.paadam == 4) {
                            ret |= M.ADHAMAM;
                        }
                        break;
                    case 2:
                        if (p.paadam == 2 || p.paadam == 3) {
                            ret |= M.ADHAMAM;
                        }
                        break;
                }
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short grahamaitri(manushya p, manushya s) {
        short i, j, ret;
        short pLagnRasi, _7thRasi, _7thAdhipa, _7thAdhipaPos;
        short _7thUchaNeecha;
        short _7thAdhipaAmsaPos, pSukraRasi, s7thRasi, pSasiRasi;
        short c7thRasi;
        short sKooru, sLagnam;
        ret = M.NODOSHAM;
        sLagnam = s.sthithi[M.LAGNA];
        sKooru = s.kooru();
        pLagnRasi = p.sthithi[M.LAGNA];
        _7thRasi = nthHouse(pLagnRasi, 7);
        if (_7thRasi == sKooru || _7thRasi == sLagnam) {
            ret |= M.UTHAMAM;
        }
        for (i = 0; i < M.GRAHAS && i < M.rasi[_7thRasi].adhipa.length; i++) {
            _7thAdhipa = M.rasi[_7thRasi].adhipa[i];
            _7thAdhipaPos = p.sthithi[_7thAdhipa];
            if (_7thAdhipaPos == sKooru || _7thAdhipaPos == sLagnam) {
                ret |= M.UTHAMAM;
            }
            _7thAdhipaAmsaPos = p.amsa9sthithi[_7thAdhipa];
            if (_7thAdhipaAmsaPos == sKooru || _7thAdhipaAmsaPos == sLagnam) {
                ret |= M.UTHAMAM;
            }
            //System.out.println("Seventh Adhipa = "+_7thAdhipa);
            for (j = 0; j < M.GRAHAS && j < M.grah[_7thAdhipa].ucham.length; j++) {
                _7thUchaNeecha = M.grah[_7thAdhipa].ucham[j];
                if (_7thUchaNeecha == sKooru || _7thUchaNeecha == sLagnam) {
                    ret |= M.UTHAMAM;
                }
            }
            for (j = 0; j < M.GRAHAS && j < M.grah[_7thAdhipa].neecham.length; j++) {
                _7thUchaNeecha = M.grah[_7thAdhipa].neecham[j];
                if (_7thUchaNeecha == sKooru || _7thUchaNeecha == sLagnam) {
                    ret |= M.UTHAMAM;
                }
            }
        }
        pSukraRasi = p.sthithi[M.SUKRA];
        if (pSukraRasi == sKooru || pSukraRasi == sLagnam) {
            ret |= M.UTHAMAM;
        }
        s7thRasi = nthHouse(pSukraRasi, 7);
        if (s7thRasi == sKooru || s7thRasi == sLagnam) {
            ret |= M.UTHAMAM;
        }
        pSasiRasi = p.sthithi[M.SASI];
        c7thRasi = nthHouse(pSasiRasi, 7);
        //System.out.println(" Sasi Rasi = " + pSasiRasi +
        //         " c7th Rasi="+c7thRasi);
        if (c7thRasi == sKooru || c7thRasi == sLagnam) {
            ret |= M.UTHAMAM;
        }
        // Chandras dwadasamsakaRasi & Trikona Rasi also to be considered
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short vedhaporutham1(manushya p, manushya s, short nak[]) {
        short nk[] = {0, 0};
        boolean rk[] = {false, false};
        int i, j;
        nk[0] = p.naksha;
        nk[1] = s.naksha;
        for (i = 0; i < 2; i++) {
            rk[i] = false;
            for (j = 0; j < nak.length; j++) {
                if (nk[i] == nak[j]) {
                    rk[i] = true;
                    break;
                }
            }
        }
        return ((rk[0] && rk[1]) ? M.DOSHAM : M.NODOSHAM);
        /* Both Nakshatras in the Ganam */
    }

    /*------------------------------------------------------------------*/
    private short kantavedham(manushya p, manushya s) {
        short naks[] = {M.ROHINI, M.ATHAM, M.THIRUVONAM, M.THIRUVATHIRA,
            M.CHOTI, M.CHATAYAM};
        return (vedhaporutham1(p, s, naks));
    }

    /*------------------------------------------------------------------*/
    private short kativedham(manushya p, manushya s) {
        short naks[] = {M.BHARANI, M.POORAM, M.POOYAM, M.ANIZHAM,
            M.UTHRATTATHI};
        return (vedhaporutham1(p, s, naks));
    }

    /*------------------------------------------------------------------*/
    private short paadavedham(manushya p, manushya s) {
        short naks[] = {M.AYILYAM, M.TRIKKETA, M.REVATHI, M.ASWATHI,
            M.MAKAM, M.MOOLAM};
        return (vedhaporutham1(p, s, naks));
    }

    /*------------------------------------------------------------------*/
    private short kukshivedham(manushya p, manushya s) {
        short naks[] = {M.PUNARTHAM, M.VISAKHAM, M.POORORUTTATHI, M.KARTHIKA,
            M.UTHRAM, M.UTHRADAM};
        return (vedhaporutham1(p, s, naks));
    }

    /*------------------------------------------------------------------*/
    private short sirovedham(manushya p, manushya s) {
        short naks[] = {M.MAKEERYAM, M.CHITRA, M.AVITTOM};
        return (vedhaporutham1(p, s, naks));
    }

    /*------------------------------------------------------------------*/
    private short panchavargavedham(manushya p, manushya s) {
        short kanta, kati, paada, kukshi, siro;
        short ret;
        ret = M.NODOSHAM;
        kanta = kantavedham(p, s);
        kati = kativedham(p, s);
        paada = paadavedham(p, s);
        kukshi = kukshivedham(p, s);
        siro = sirovedham(p, s);
        //if (kanta || kati || paada || kukshi || siro) ret |= M.ADHAMAM;
        ret |= (kanta | kati | paada | kukshi | siro);
        if (shashtashtamam(p.kooru(), s.kooru())) {
            ret |= M.NOPARIHAARAM;
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short vedhaporutham(manushya p, manushya s) {
        short vpn;
        int i;
        short ret;
        vpn = 0;
        ret = M.UTHAMAM;
        for (i = 0; i < M.naksha[p.naksha].vedha.length && vpn != M.NONE; i++) {
            vpn = M.naksha[p.naksha].vedha[i];
            if (vpn == s.naksha) {
                ret = M.DOSHAM;
                break;
            }
        }
        if (M.DOSHAM == ret) {
            ret |= panchavargavedham(p, s);
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private boolean paada108(manushya p, manushya s) {
        boolean ret;
        ret = (paadaDiff(p, s) == 108) ? true : false;
        //ret = (paadaDiff(p.chandra, s.chandra) == 108) ? true : false;
        //ret = (nakshatraDiff(p.naksha,s.naksha) == 26) ? true : false;
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private boolean paada88(manushya p, manushya s) {
        boolean ret;
        ret = (paadaDiff(p, s) == 88) ? true : false;
        //ret = (paadaDiff(p.chandra, s.chandra) == 88) ? true : false;
        //ret = (nakshatraDiff(p.naksha,s.naksha) == 22) ? true : false;
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private String matched(manushya p, int val) {
        return (" ");
    }

    /*------------------------------------------------------------------*/
    private String match(manushya p, int val) {
        return (M.getMatchStr(p.porutham[val]));
        //return (matchstr);
    }

    /*------------------------------------------------------------------*/
    private short dasaSandhi(manushya p, manushya s) {
        snDate diff = new snDate(1967, 10, 20);
        sandhi[] tmpP = new sandhi[M.GRAHAS + 1], tmpS = new sandhi[M.GRAHAS + 1];
        //snDate pdt, sdt;
        double diffYrs, adiffYrs;
        int i, j, k, szi, szj;
        short ret;
        i = j = k = 0;
        ret = M.NODOSHAM;
        //pdt = p.dasas[0].dt;     sdt = s.dasas[0].dt;
        szi = p.dasas.length;
        szj = s.dasas.length;
        //System.out.println("dasas Length i = " + szi + "  j = " + szj);
        while ((i < szi) && (j < szj)) {
            //yp = p.dasas[i].dt.yy; ys = s.dasas[j].dt.yy;
            diff = snDate.dateDiff(p.dasas[i].dt, s.dasas[j].dt);
            diffYrs = diff.years();
            adiffYrs = Math.abs(diffYrs);
            //System.out.println(" Adiff Yrs = " + adiffYrs);
            if (adiffYrs > 1.0) {
                if (diffYrs < 0.0) {
                    i++;
                } else {
                    j++;
                }
            } else {
                if (adiffYrs < 0.75) {
                    ret |= M.DOSHAM;
                } else if (adiffYrs < 0.50) {
                    ret |= M.ATIDOSHAM;
                } else if (adiffYrs < 0.25) {
                    ret |= M.NISHIDHAM;
                }
                //System.out.println(M.graham[p.dasas[i].graha] + " " +
                //    p.dasas[i].dt.dmy() + " " +
                //    M.graham[s.dasas[j].graha] + " " + s.dasas[j].dt.dmy());
                tmpP[k] = new sandhi(p.dasas[i]);
                tmpS[k] = new sandhi(s.dasas[j]);
                //System.out.println(M.graham[tmpP[k].graha] + " " +
                //    tmpP[k].dt.dmy() + " " +
                //    M.graham[tmpS[k].graha] + " " + tmpS[k].dt.dmy());
                i++;
                j++;
                k++;
            }
        }

        for (i = 0; tmpP[i] != null && i <= M.GRAHAS; i++) {
        };
        //System.out.println(" No of Sandhis ==== > " + i);
        p.sandi = new sandhi[i];
        s.sandi = new sandhi[i];
        for (i = 0; i < p.sandi.length; i++) {
            p.sandi[i] = tmpP[i];
            s.sandi[i] = tmpS[i];
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private double marks(int val) {
        double ret = 0.0;
        int i, ch;
        for (i = 0; i < 16; i++) {
            if (((val << i) & 0x8000) > 0) {
                ch = (val & (0x0001 << (15 - i)));
                ret = (ch == M.NODOSHAM ? 1.00
                        : ch == M.ATIUTHAMAM ? 5.00
                                : ch == M.UTHAMAM ? 4.75
                                        : ch == M.MADHYAMAM ? -0.50
                                                : ch == M.SAAMANYADOSHAM ? -1.50
                                                        : ch == M.DOSHAM ? -2.50
                                                                : ch == M.ATIDOSHAM ? -3.00
                                                                        : ch == M.ATYANTADOSHAM ? -4.00
                                                                                : ch == M.ADHAMAM ? -5.00
                                                                                        : ch == M.ADHAMAADHAMAM ? -6.00
                                                                                                : ch == M.NISHIDHAM ? -7.00
                                                                                                        : ch == M.NOPARIHAARAM ? -9.00
                                                                                                                : ret);
            }
            if (ret != 0.0) {
                break;
            }
        }
        if ((val & M.PARIHAARAM) > 0) {
            if (ret < 0.0) {
                ret = 0.0;
            }
        }
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private short match_hors(manushya male, manushya female) {
        short ret, ret1;
        int i, diff, adiff;
        short npaapas1, npaapas2;
        ret = ret1 = M.NODOSHAM;
        poruthaVal = 0;
        npaapas1 = (short) findpaapa(male);
        npaapas2 = (short) findpaapa(female);
        //System.out.println("Male Paapas="+npaapas1);
        //System.out.println("FeMale Paapas="+npaapas2);
        male.porutham[M.P_PAAPAS] = npaapas1;
        female.porutham[M.P_PAAPAS_SPOUSE] = npaapas1;
        female.porutham[M.P_PAAPAS] = npaapas2;
        male.porutham[M.P_PAAPAS_SPOUSE] = npaapas2;
        diff = npaapas2 - npaapas1;
        adiff = Math.abs(diff);
        ret1 = female.porutham[M.P_PAAPAPORUTHAM] = (adiff == 0)
                ? M.ATIUTHAMAM : (adiff <= 2) ? ((diff < 0) ? M.UTHAMAM : M.MADHYAMAM)
                        : (adiff <= 8) ? ((diff < 0) ? M.MADHYAMAM : M.ADHAMAM) : M.ADHAMAM;
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_RAASIPORUTHAM] = raasiporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_RAASYADHIPAPORUTHAM]
                = raasyadhipaporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_VASYAPORUTHAM] = vasyaporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_MAHENDRAPORUTHAM]
                = mahendraporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_GANAPORUTHAM] = ganaporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_STREEDEERGHAPORUTHAM]
                = streedeergham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_YONIPORUTHAM] = yoniporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_DINAPORUTHAM] = dinaporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_RAJJUPORUTHAM] = rajjuporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_AAYAVYAYAPORUTHAM]
                = aayavyayaporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_VAYAPORUTHAM] = vayaporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_VEDHAPORUTHAM] = vedhaporutham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_PANCHAVARGAVEDHAM]
                = panchavargavedham(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_KANTAVEDHAM] = kantavedham(male, female);
        ret |= ret1;
        ret1 = female.porutham[M.P_KATIVEDHAM] = kativedham(male, female);
        ret |= ret1;
        ret1 = female.porutham[M.P_PAADAVEDHAM] = paadavedham(male, female);
        ret |= ret1;
        ret1 = female.porutham[M.P_KUKSHIVEDHAM] = kukshivedham(male, female);
        ret |= ret1;
        ret1 = female.porutham[M.P_SIROVEDHAM] = sirovedham(male, female);
        ret |= ret1;
        ret1 = female.porutham[M.P_DASASANDHI] = dasaSandhi(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_GRAHAMAITRI] = grahamaitri(male, female);
        poruthaVal += marks(ret1);
        ret |= ret1;
        ret1 = female.porutham[M.P_SPOUSE_GRAHAMAITRI] = grahamaitri(female, male);
        poruthaVal += marks(ret1);
        ret |= ret1;
        return (ret);
    }

    /*------------------------------------------------------------------*/
    private void printOutKalams(manushya p, manushya s, PrintWriter pS) {
        String[][][] stz = new String[2][33][M.RAASIS];
        int i, j, k, ii, jj, z;
        int rIdx[] = {0, 1, 2, 3, 5, 7, 11, 10, 9, 8, 6, 4};
        int[][] rItx = new int[2][M.RAASIS + 1];
        String std = "<TD width=75 align=center>";
        String delm[] = {"..   12    ..", "..    1    ..",
            "..    2    ..", "..    3    .."};
        String delim = ".           .";
        //String stB = "<TD width=75 bgcolor=gray align=center>";
        String stB = "<TD width=75 align=center>";
        int maxGrh[] = {6, 6};
        boolean found = false;
        for (k = 0; k < 2; k++) {
            for (i = 0; i < 33; i++) {
                for (j = 0; j < M.RAASIS; j++) {
                    stz[k][i][j] = "    ";
                }
            }
            for (i = 0; i <= M.RAASIS; i++) {
                rItx[k][i] = 0;
            }
        }
        //System.out.println(" Maandi of Stree="+s.sthithi[MAANDI]);
        //System.out.println(" Maandi of Purusha="+p.sthithi[MAANDI]);
        for (k = 0; k < 2; k++) {
            for (i = 0; i <= M.GRAHAS; i++) {
                z = (k == 0 ? rIdx[s.sthithi[i]] : rIdx[p.sthithi[i]]);
                //stz[k][z][ rItx[k][z] ] = M.graham[i];
                stz[k][z][rItx[k][z]] = M.grah[i].name;
                if (rItx[k][z] > maxGrh[k]) {
                    maxGrh[k] = rItx[k][z];
                }
                rItx[k][z]++;
            }
        }
        hWrite("<TABLE><TR><TD width=500 align=center>");
        hWrite("<STRONG>RASI</STRONG></TD></TR></TABLE>");
        hWrite("<TABLE border=9><TR>");
        for (i = 0; i < 4; i++) {
            hWrite(std + delm[i] + "</TD>");
        }
        hWrite("<TD></TD>");
        for (i = 0; i < 4; i++) {
            hWrite(std + delm[i] + "</TD>");
        }
        hWrite("</TR><TR>");
        for (i = ii = 0; i < M.RAASIS; i++) {
            hWrite(std);
            found = false;
            for (j = 0; j < rItx[0][i]; j++) {
                pS.print(stz[0][i][j]);
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
            for (; j <= maxGrh[0] / 2; j++) {
                hWrite("<BR>");
            }
            if (i == 4 || i == 6) {
                hWrite("</TD>" + stB + "</TD>" + stB);
            }
            hWrite("</TD>");

            if (i == 3 || i == 5 || i == 7 || i == 11) {
                hWrite("<TD></TD>");
                for (; ii <= i; ii++) {
                    hWrite(std);
                    found = false;
                    for (jj = 0; jj < rItx[1][ii]; jj++) {
                        pS.print(stz[1][ii][jj]);
                        if (jj % 2 > 0) {
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
                    for (; jj <= maxGrh[1] / 2; jj++) {
                        hWrite("<BR>");
                    }
                    if (ii == 4 || ii == 6) {
                        hWrite("</TD>" + stB + "</TD>" + stB);
                    }
                    hWrite("</TD>");
                    if (ii == 3 || ii == 5 || ii == 7) {
                        hWrite("</TR><TR>");
                    }
                }
                //hWrite("</TR><TR>");
            }
        }
        hWrite("</TR></TABLE>");
    }

    /*------------------------------------------------------------------*/
    private void reports(manushya p, manushya s, PrintWriter pS) {
        boolean dosham;
        String htmlheader, htmlfooter, str;
        //String versionNo = "Version 2.0 (11-Aug-2002)";
        String versionNo = "Version 2.1 (11-Jan-2003)";
        String sTDC = "</TD><TD align=center>";

        htmlheader = "<HTML><HEAD><TITLE>"
                + p.name.trim() + " <-> " + s.name.trim()
                + " Compatibility - "
                + snExchange.gn() + " {" + versionNo
                + "}</TITLE>";
        htmlfooter = "</BODY></HTML>";
        hWrite(htmlheader);
        hWrite(M.htmlStyle);
        hWrite("<H2>");
        pS.print(M.sHOROSCOPE_COMPATIBILITY);
        hWrite("</H2>");
        hWrite("<TABLE><TR><TD width=600 align=right><I>");
        pS.print("                                   " + versionNo);
        hWrite("</I></TD></TR></TABLE>");
        hWrite("<TABLE><TR><TD width=600 align=right><I>");
        if (html) {
            pS.print("<a href=\"mailto:sunambiar@yahoo.com?Subject=Jatakam Feedback\"><i>"
                    + "(e-mail)</i></a>");
        } else {
            pS.print("\t\t\t\t   Author :-" + snExchange.gn());
        }
        hWrite("</TD></TR></TABLE>");
        if (html) {
            hWrite("<font color=\"yellow+orange\" bgcolor=\"blue\">");
            hWrite("<I><marquee style=\"filter=glow(color=yellow,strength=1)\""
                    + "border=\"0\">This report was generated by Software designed &amp developed by "
                    + snExchange.gn() + "... ... ...</marquee></I><HR><BR>");
        }
        pS.println();
        pS.println();
        printOutKalams(p, s, pS);
        hWrite("<BODY><TABLE border=3><TR><TD>");
        hWrite("</TD><TD><STRONG>");
        hWrite("<A HREF=\"" + s.snJatakRef + "\">STREE</A>");
        hWrite("</TD>");
        hWrite("</TD><TD><STRONG>");
        hWrite("<A HREF=\"" + p.snJatakRef + "\">PURUSHA</A>");
        hWrite("</TD>");
        //hWrite("<TD><STRONG>PURUSHA</TD></TR>");
        //hWrite("<TR><TD>==</TD><TD>=========</TD><TD>===========</TD></TR>");
        //pS.println();
        //printGrhSymbolHelp(pS);

        hWrite("<TR><TD>");
        pS.print(M.sNAME);
        hWrite("</TD><TD>");
        //hWrite("<STRONG>");
        pS.print(s.name);
        hWrite("</TD><TD>");
        pS.print(p.name);
        hWrite("</TD></TD></TR><TR><TD>");
        pS.print(M.sAGE);
        hWrite("</TD><TD>");
        pS.println(s.age.ymd());
        hWrite("</TD><TD>");
        pS.println(p.age.ymd());
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sSEX);
        hWrite("</TD><TD>");
        pS.println(s.sex);
        hWrite("</TD><TD>");
        pS.println(p.sex);
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sNAKSHATRA);
        hWrite("</TD><TD>");
        pS.println(M.naksha[s.naksha].name);
        hWrite("</TD><TD>");
        pS.println(M.naksha[p.naksha].name);
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sDOB);
        hWrite("</TD><TD>");
        pS.print(s.d_o_b.dmy() + " " + s.dow);
        pS.print((s.dow != s.dowHindu) ? M.sHINDU + s.dowHindu + ")" : " ");
        hWrite("</TD><TD>");
        pS.print(p.d_o_b.dmy() + " " + p.dow);
        pS.print((p.dow != p.dowHindu) ? M.sHINDU + p.dowHindu + ")" : " ");
        hWrite("</TD></TR><TR><TD>");
        //hWrite("<TD width=75>");       hWrite("<STRONG>");
        pS.print(M.sTOB);
        hWrite("</TD><TD>");
        str = (s.timeZone == +5.5) ? M.sIST
                : "(" + (s.timeZone >= 0.0 ? "+" : "-") + s.timeZone + M.sGMT + ")";
        pS.println(s.t_o_b.hms() + str);
        hWrite("</TD><TD>");
        str = (p.timeZone == +5.5) ? M.sIST
                : "(" + (p.timeZone >= 0.0 ? "+" : "-") + p.timeZone + M.sGMT + ")";
        pS.println(p.t_o_b.hms() + str);
        hWrite("</TD></TR>");
        hWrite("<TR><TD>");
        pS.print(M.sPOB);
        hWrite("</TD><TD>");
        pS.println(s.place);
        hWrite("</TD><TD>");
        pS.println(p.place);
        hWrite("</TD></TR>");
        hWrite("<TR><TD>");
        pS.print(M.sLATI);
        hWrite("</TD><TD>");
        pS.print(DMS.dms(Math.abs(s.latitude)));
        pS.println(" " + (s.latitude < 0 ? "S" : "N"));
        hWrite("</TD><TD>");
        pS.print(DMS.dms(Math.abs(p.latitude)));
        pS.println(" " + (p.latitude < 0 ? "S" : "N"));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sLNGT);
        hWrite("</TD><TD>");
        pS.print(DMS.dms(Math.abs(s.longitude)));
        pS.println(" " + (s.longitude < 0 ? "S" : "N"));
        hWrite("</TD><TD>");
        pS.print(DMS.dms(Math.abs(p.longitude)));
        pS.println(" " + (p.longitude < 0 ? "W" : "E"));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sSISTA);
        hWrite("</TD><TD>");
        pS.print(M.dasa[M.naksha[s.naksha].aadidasa]);
        pS.println(" " + s.dasa_bal.ymd());
        hWrite("</TD><TD>");
        pS.print(M.dasa[M.naksha[p.naksha].aadidasa]);
        pS.println(" " + p.dasa_bal.ymd());
        hWrite("</TD></TR>");
        if (detail > 0) {
            detail_report(p, s, pS);
        }
        printDasaSandhis(p, s, pS);
        hWrite("</TABLE>");
        pS.println("<TABLE><TR><TD><STRONG><I><H2>");
        pS.println();
        pS.println(M.sCOMPATIBILITY);
        pS.println();
        hWrite("</H2></I></TD></TR></TABLE>");
        if (detail > 0) {
            listPaapas(p, s, pS);
        }
        pS.println("<TABLE><TR><TD><STRONG><I>");
        pS.print(" Total Porutha Value :- ");
        hWrite("</I>");
        pS.println(poruthaVal);
        pS.println();
        hWrite("</TD></TR></TABLE>");
        pS.println("<TABLE border=1><TR><TD>");
        pS.print(M.sPAAP_VAL);
        hWrite(sTDC);
        pS.print(s.porutham[M.P_PAAPAS]);
        hWrite(sTDC);
        pS.print(s.porutham[M.P_PAAPAS_SPOUSE]);
        hWrite("</TD></TR><TR><TD>");
        /*
       pS.print(M.sNO_OF_PAAPAS);   hWrite("</TD><TD>");
       pS.print(s.porutham[M.P_PAAPAS]); hWrite(sTDC);
       pS.print(s.porutham[M.P_PAAPAS_SPOUSE]); hWrite("</TD></TR><TR><TD>");
         */
        pS.print(M.sPAAPA_SAAMYA);
        hWrite(sTDC);
        pS.print(match(s, M.P_PAAPAPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_PAAPAPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sRAASI_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_RAASIPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_RAASIPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sRAASYADHIPA);
        hWrite(sTDC);
        pS.print(match(s, M.P_RAASYADHIPAPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_RAASYADHIPAPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sVASYA_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_VASYAPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_VASYAPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sMAHEN_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_MAHENDRAPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_MAHENDRAPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sGANA_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_GANAPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_GANAPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sSTRDEER);
        hWrite(sTDC);
        pS.print(match(s, M.P_STREEDEERGHAPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_STREEDEERGHAPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sYONI_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_YONIPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_YONIPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sDINA_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_DINAPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_DINAPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sRAJJU_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_RAJJUPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_RAJJUPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sAAYA_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_AAYAVYAYAPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_AAYAVYAYAPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sVAYA_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_VAYAPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_VAYAPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sVED_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_VEDHAPORUTHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_VEDHAPORUTHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sPANCHVED_POR);
        hWrite(sTDC);
        pS.print(match(s, M.P_PANCHAVARGAVEDHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_PANCHAVARGAVEDHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sKANTA_VED);
        hWrite(sTDC);
        pS.print(match(s, M.P_KANTAVEDHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_KANTAVEDHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sKATI_VED);
        hWrite(sTDC);
        pS.print(match(s, M.P_KATIVEDHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_KATIVEDHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sPAADA_VED);
        hWrite(sTDC);
        pS.print(match(s, M.P_PAADAVEDHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_PAADAVEDHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sKUKSHI_VED);
        hWrite(sTDC);
        pS.print(match(s, M.P_KUKSHIVEDHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_KUKSHIVEDHAM));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sSIRO_VED);
        hWrite(sTDC);
        pS.print(match(s, M.P_SIROVEDHAM));
        hWrite(sTDC);
        pS.print(matched(s, M.P_SIROVEDHAM));
        hWrite("</TD></TR><TR><TD>");
        dosham = paada88(p, s);
        pS.print(M.sPAADA_88);
        hWrite(sTDC);
        pS.print(dosham ? M.sDOSHAM : " ");
        hWrite(sTDC);
        pS.print(!dosham ? M.sNA : " ");
        hWrite("</TD></TR><TR><TD>");
        dosham = paada108(p, s);
        pS.print(M.sPAADA_108);
        hWrite(sTDC);
        pS.print(dosham ? M.sDOSHAM : " ");
        hWrite(sTDC);
        pS.print(!dosham ? M.sNA : " ");
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.s6_8_DOSHAM);
        hWrite(sTDC);
        dosham = shashtashtamam(p.kooru(), s.kooru());
        pS.print(dosham ? M.sDOSHAM : " ");
        hWrite(sTDC);
        pS.print(!dosham ? M.sNA : " ");
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.s8_6_DOSHAM);
        hWrite(sTDC);
        dosham = ashtamashashtam(p.kooru(), s.kooru());
        pS.print(dosham ? M.sDOSHAM : " ");
        hWrite(sTDC);
        pS.print(!dosham ? M.sNA : " ");
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sGRAH_MAITRI_P);
        hWrite(sTDC);
        pS.print(match(s, M.P_GRAHAMAITRI));
        hWrite(sTDC);
        pS.print(matched(s, M.P_GRAHAMAITRI));
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sGRAH_MAITRI_S);
        hWrite(sTDC);
        pS.print(match(s, M.P_SPOUSE_GRAHAMAITRI));
        hWrite(sTDC);
        pS.print(matched(s, M.P_SPOUSE_GRAHAMAITRI));
        hWrite("</TD></TR><TR><TD>");
        //printOutPaapas(p,s);
        hWrite(htmlfooter);
        if (outOpt == 'F') {
            pS.flush();
            pS.close();
        }
    }

    /*---------------------------------------------------------------*/
    private void detail_report(manushya p, manushya s, PrintWriter pS) {
        hWrite("<TR><TD><STRONG>");
        pS.println(M.sMORE_DETLS);
        hWrite("</TD></TR>");
        //hWrite("<TABLE border=1><TR><TD>");
        //pS.print();    hWrite("</TD><TD>");
        hWrite("<TR><TD>");
        pS.print(M.sGANAM);
        hWrite("</TD><TD>");
        pS.println(M.ganam[M.naksha[s.naksha].ganam]);
        hWrite("</TD><TD>");
        pS.println(M.ganam[M.naksha[p.naksha].ganam]);
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sVRIKSHAM);
        hWrite("</TD><TD>");
        pS.println(M.vriksham[M.naksha[s.naksha].vriksham]);
        hWrite("</TD><TD>");
        pS.println(M.vriksham[M.naksha[p.naksha].vriksham]);
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sMRIGAM);
        hWrite("</TD><TD>");
        pS.println(M.mrigam[M.naksha[s.naksha].mrigam]);
        hWrite("</TD><TD>");
        pS.println(M.mrigam[M.naksha[p.naksha].mrigam]);
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sYONI);
        hWrite("</TD><TD>");
        pS.println(M.yoni[M.naksha[s.naksha].yoni]);
        hWrite("</TD><TD>");
        pS.println(M.yoni[M.naksha[p.naksha].yoni]);
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sPAKSHI);
        hWrite("</TD><TD>");
        pS.println(M.pakshi[M.naksha[s.naksha].pakshi]);
        hWrite("</TD><TD>");
        pS.println(M.pakshi[M.naksha[p.naksha].pakshi]);
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sBHOOTAM);
        hWrite("</TD><TD>");
        pS.println(M.bhootam[M.naksha[s.naksha].bhootam]);
        hWrite("</TD><TD>");
        pS.println(M.bhootam[M.naksha[p.naksha].bhootam]);
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sDEVATA);
        hWrite("</TD><TD>");
        pS.println(M.devata[M.naksha[s.naksha].devata]);
        hWrite("</TD><TD>");
        pS.println(M.devata[M.naksha[p.naksha].devata]);
        //hWrite("</TD></TR><TR><TD>");
        hWrite("</TD></TR>");
        //hWrite(</TABLE>");
    }

    /*---------------------------------------------------------------*/
    private void printDasaSandhis(manushya p, manushya s, PrintWriter pS) {
        int i;
        //hWrite("<TR><TD><STRONG>");
        //pS.println("Dasa Sandhi :- ");
        //hWrite("</TD></TR>");
        //pS.println("<TABLE border=1><TR><TD>");
        //System.out.println(" Dasa Sandhis Count = "+p.sandi.length);
        hWrite("<TR><TD><STRONG>");
        pS.println(M.sDASASANDHI);
        hWrite("</TD><TD>");
        if (p.sandi.length == 0) {
            pS.print(M.sNA);
            hWrite("</TD><TD>");
            pS.print(M.sNA);
            hWrite("</TD></TR>");
        }
        for (i = 0; i < p.sandi.length; i++) {
            if (i > 0) {
                hWrite("<TR><TD></TD><TD>");
            }
            pS.print(M.dasa[s.sandi[i].graha] + "--> " + s.sandi[i].dt.dmy());
            pS.print(" -->" + M.dasa[s.sandi[i].nextGraha]);
            hWrite("</TD><TD>");
            pS.print(M.dasa[p.sandi[i].graha] + "--> " + p.sandi[i].dt.dmy());
            pS.println(" -->" + M.dasa[p.sandi[i].nextGraha]);
            hWrite("</TD></TR>");
        }
        //hWrite("</TABLE>");
    }

    /*---------------------------------------------------------------*/
    private void listPaapas(manushya p, manushya s, PrintWriter pS) {
        int paapHouse[] = {1, 2, 4, 7, 8, 12};
        int paapGrahA[] = {1, 4, 9};
        int paapGrahB[] = {6, 8};
        int paapFrom[] = {0, 7, 3};/*Lagnaal,Chandraal,Sukraal*/
        int i, j, grndtotidx;
        String dashL
                = "---------------------------------------------------------------";
        grndtotidx = paapGrahA.length + paapGrahB.length + 1;
        hWrite("<TABLE><TR><TD><B>");
        pS.println();
        hWrite("</TD></TR><TR><TD>");
        pS.print(M.sCOUNT_OF_PAAPS);
        //System.out.println(" PaapHouse.length = "+ paapHouse.length);
        for (i = 0; i < paapHouse.length; i++) {
            pS.print(" " + paapHouse[i] + " ");
            //System.out.print(paapHouse[i]);
        }
        //System.out.println();
        pS.println(")");
        hWrite("</TD></TR><TR><TD>");
        pS.println(dashL);
        hWrite("</TD></TR></TABLE>");
        hWrite("<TABLE border=5 cellpadding=2><TR align=center><TD>");
        pS.print(M.sGRAHA);
        hWrite("</TD><TD>");
        for (i = 0; i < paapGrahA.length; i++) {
            pS.print(M.graham[paapGrahA[i]]);
            hWrite("</TD><TD>");
        }
        pS.print(M.sTOTAL);
        hWrite("</TD><TD>");
        for (i = 0; i < paapGrahB.length; i++) {
            pS.print(M.graham[paapGrahB[i]]);
            hWrite("</TD><TD>");
        }
        pS.print(M.sGRAND_TOT);
        hWrite("</TD></TR></B>");
        hWrite("<TR><TD><STRONG>");
        pS.println(M.sSTREE);
        hWrite("</TD></TR>");
        for (i = 0; i < paapFrom.length; i++) {
            hWrite("<TR align=center><TD>");
            pS.print(M.graham[paapFrom[i]] + M.sGRAHA_AL);
            hWrite("</TD>");
            for (j = 0; j <= grndtotidx; j++) {
                hWrite("<TD>");
                if (s.paapas[i][j] > 0) {
                    pS.print(s.paapas[i][j]);
                } else {
                    pS.print(" - ");
                }
                hWrite("</TD>");
            }
            hWrite("</TR>");
        }
        hWrite("<TR><TD><STRONG>");
        pS.println(M.sPURUSHA);
        hWrite("</TD></TR>");
        for (i = 0; i < paapFrom.length; i++) {
            hWrite("<TR align=center><TD>");
            pS.print(M.graham[paapFrom[i]] + M.sGRAHA_AL);
            hWrite("</TD>");
            for (j = 0; j <= grndtotidx; j++) {
                hWrite("<TD>");
                if (p.paapas[i][j] > 0) {
                    pS.print(p.paapas[i][j]);
                } else {
                    pS.print(" - ");
                }
                hWrite("</TD>");
            }
            hWrite("</TR>");
        }
        hWrite("</TABLE>");
    }

    /*---------------------------------------------------------------*/
    private static void hWrite(String s) {
        if (html) {
            pS.println(s);
        }
    }
    /*------------------------------------------------------------------*/

}
/*--------------------------------------------------------*/
 /*--------------------------------------------------------*/

/**
 * **********************************************
 * for (int i=0; i <= M.GRAHAS; i++) { System.out.println(i+" " +M.graham[i]); }
 * for (int i=0; i <= M.GRAHAS; i++) { System.out.println(i+" " +M.dasa[i]); }
 * for (int i=0; i <= DEVATAAS; i++) { System.out.println(i+" " +M.devata[i]); }
 * for (int i=0; i <= BHOOTAS; i++) { System.out.println(i+" " +M.bhootam[i]); }
 * for (int i=0; i <= PAKSHIS; i++) { System.out.println(i+" " +M.pakshi[i]); }
 * for (int i=0; i <= YONIS; i++) { System.out.println(i+" " +M.yoni[i]); } for
 * (int i=0; i <= GANAMS; i++) { System.out.println(i+" " +M.ganam[i]); } for
 * (int i=0; i <= VRIKSHAMS; i++) { System.out.println(i+" " +M.vriksham[i]); }
 * for (int i=0; i <= MRIGAMS; i++) { System.out.println(i+" " +M.mrigam[i]); }
 * System.out.println(rasi.length); for (int i=0; i<rasi.length; i++) {
 * System.out.println(M.rasi[i].name); for (int j=0; j < M.rasi[i].vasya.length;
 * j++) { System.out.print(" "+M.rasi[i].vasya[j]); if (M.rasi[i].vasya[j] !=
 * M.NONE) { System.out.print(" " + M.rasi[M.rasi[i].vasya[j]].name); } }
 * System.out.println(); } System.out.println(grah.length); for (int i=0;
 * i<grah.length; i++) { System.out.println(M.grah[i].dasa + " " +
 * M.grah[i].name); for (int j=0; j < M.grah[i].poruthabandhu.length; j++) {
 * System.out.print(" "+M.grah[i].poruthabandhu[j]); System.out.print(" " +
 * M.grah[M.grah[i].poruthabandhu[j]].name); } System.out.println(); }
 *
 * System.out.println(naksha.length); for (int i=0; i<naksha.length; i++) {
 * //try { // System.out.println(i +" "+ M.naksha[i].name); //} catch (Exception
 * e) {}; System.out.println(M.naksha[i].name + " Vedha = " +
 * M.naksha[i].vedha[0] + ", " + M.naksha[i].vedha[1] + " " ); try {
 * System.out.println(M.naksha[i].name + " Vedha = " +
 * M.naksha[M.naksha[i].vedha[0]].name + ", " +
 * M.naksha[M.naksha[i].vedha[1]].name); } catch (Exception e){
 * System.out.println(M.naksha[i].name + " Vedha = " +
 * M.naksha[M.naksha[i].vedha[0]].name); }; }
       *****************************************************
 */
