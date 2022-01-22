
package snJatakamAI.snJatakam.sn_Jatakam;

/*---------------------------------------------------*/
//package snJatak;
/*---------------------------------------------------*/
import java.awt.*;
import java.awt.event.*;
import snJatakamAI.snJatakam.sn_Jatakam.snJatak;
//import java.applet.*;
//import java.net.*;
//import javax.swing.event.*;
//import java.util.*;
//import java.awt.Cursor;
//import javax.swing.JLabel;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snExchange;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.*;

/*---------------------------------------------------*/
class snJAppln extends Frame implements ItemListener, ActionListener {

    //static int nArgs = 25;
    String Args[];   // = new String[nArgs];
    String snFname = new String();
    snBasicDetls b_place = new snBasicDetls();
    int nPlaces;

    static String timeZone[][] = {
        {"-11.5", "-11:30 GMT"}, {"-11.0", "-11:00 GMT"},
        {"-10.5", "-10:30 GMT"}, {"-10.0", "-10:00 GMT"},
        {"-9.5", "-9:30 GMT"}, {"-9.0", "-9:00 GMT"},
        {"-8.5", "-8:30 GMT"}, {"-8.0", "-8:00 GMT"},
        {"-7.5", "-7:30 GMT"}, {"-7.0", "-7:00 GMT"},
        {"-6.5", "-6:30 GMT"}, {"-6.0", "-6:00 GMT"},
        {"-5.5", "-5:30 GMT"}, {"-5.0", "-5:00 GMT"},
        {"-4.5", "-4:30 GMT"}, {"-4.0", "-4:00 GMT"},
        {"-3.5", "-3:30 GMT"}, {"-3.0", "-3:00 GMT"},
        {"-2.5", "-2:30 GMT"}, {"-2.0", "-2:00 GMT"},
        {"-1.5", "-1:30 GMT"}, {"-1.0", "-1:00 GMT"},
        {"-0.5", "-0:30 GMT"}, {"+0.0", "GMT"},
        {"+0.5", "+0:30 GMT"}, {"+1.0", "+1:00 GMT"},
        {"+1.5", "+1:30 GMT"}, {"+2.0", "+2:00 GMT"},
        {"+2.5", "+2:30 GMT"}, {"+3.0", "+3:00 GMT"},
        {"+3.5", "+3:30 GMT"}, {"+4.0", "+4:00 GMT"},
        {"+4.5", "+4:30 GMT"}, {"+5.0", "+5:00 GMT"},
        {"+5.5", "+5:30 GMT (IST)"}, {"+6.0", "+6:00 GMT"},
        {"+6.5", "+6:30 GMT"}, {"+7.0", "+7:00 GMT"},
        {"+7.5", "+7:30 GMT"}, {"+8.0", "+8:00 GMT"},
        {"+8.5", "+8:30 GMT"}, {"+9.0", "+9:00 GMT"},
        {"+9.5", "+9:30 GMT"}, {"+10.0", "+10:00 GMT"},
        {"+10.5", "+10:30 GMT"}, {"+11.0", "+11:00 GMT"},
        {"+11.5", "+11:30 GMT"}, {"+12.0", "+12:00 GMT"}};

    Button snGenerate = new Button("Generate Horoscope");
    static Label lName = new Label("Name : ");
    static Label lSex = new Label("Sex : ");
    TextField snName = new TextField(40);
    static Label lPlace = new Label("Place : ");
    TextField snPlace = new TextField(25);
    static Label lDOB = new Label("Date of Birth (dd/mm/yyyy) :");
    TextField snDD = new TextField(2);
    TextField snMM = new TextField(2);
    TextField snYY = new TextField(4);
    static Label lTOB = new Label("Time of Birth (HH:MM:SS) :");
    TextField snHH = new TextField(2);
    TextField snMt = new TextField(2);
    TextField snSS = new TextField(2);
    static Label lLAT = new Label("Latitude :");
    TextField snLatDD = new TextField(2);
    TextField snLatMM = new TextField(2);
    TextField snLatSS = new TextField(2);
    static Label lLONG = new Label("Longitude :");
    TextField snLongDD = new TextField(2);
    TextField snLongMM = new TextField(2);
    TextField snLongSS = new TextField(2);
    static Label lAya = new Label("Ayanamsa :");
    TextField snAyaDD = new TextField(2);
    TextField snAyaMM = new TextField(2);
    TextField snAyaSS = new TextField(2);

    //static TextField snSummDetl = new TextField(1);
    static Label lMesg = new Label("                             ");

    Choice snSex = new Choice();
    Choice snPlaceSel = new Choice();
    Choice snLongEW = new Choice();
    Choice snLatNS = new Choice();
    static Label lTZ = new Label("Time Zone :");
    Choice snTimeZone = new Choice();
    Choice snAyanamsa = new Choice();
    CheckboxGroup snSummDetl = new CheckboxGroup();
    Checkbox snBasic = new Checkbox("Basic", snSummDetl, true);
    Checkbox snDetail = new Checkbox("Detail", snSummDetl, false);

    static String snJTitle
            = new String("snJatakam Application - by Suresh P. Nambiar (C)opyright");

    MenuBar mb = new MenuBar();
    Menu mSystem = new Menu("System");
    MenuItem miExit = new MenuItem("Exit");

    Panel p_snAya = new Panel();

    /*----------------------------------------------------*/
    snJAppln() {
        super(snJTitle);
        mSystem.add(miExit);
        mb.add(mSystem);
        //setMenuBar(mb);
        addWindowListener(new snWin(this));

        setFont(new Font("Arial", Font.PLAIN, 12));
        setLayout(new FlowLayout(FlowLayout.LEFT));

        String sSlash = new String("/");
        String sColon = new String(":");
        String sDeg = new String("deg.");
        String sMin = new String("min.");
        String sSec = new String("sec.");

        snSex.addItem("Male");
        snSex.addItem("Female");
        snSex.select(0);

        loadPlaces();
        snPlaceSel.addItemListener(this);

        for (int i = 0; i < timeZone.length; i++) {
            snTimeZone.addItem(timeZone[i][1]);
        }
        snTimeZone.select(34);

        snLongEW.addItem("East");
        snLongEW.addItem("West");
        snLongEW.select(0);

        snLatNS.addItem("North");
        snLatNS.addItem("South");
        snLatNS.select(0);

        snAyanamsa.addItem("N.C.Lahiri");
        snAyanamsa.addItem("B.V.Raman");
        snAyanamsa.addItem("Chandra Hari");
        snAyanamsa.addItem("User Specified...");
        snAyanamsa.select(0);
        snAyanamsa.addItemListener(this);

        Panel p_snName = new Panel();
        p_snName.add(lName);
        snName.setText("(C)opyright Suresh P. Nambiar");
        p_snName.add(snName);

        Panel p_snSex = new Panel();
        p_snSex.add(lSex);
        p_snSex.add(snSex);

        Panel p_snPlace = new Panel();
        p_snPlace.add(lPlace);
        snPlace.setText("Payyanur");
        p_snPlace.add(snPlace);
        p_snPlace.add(snPlaceSel);

        Panel p_snDOB = new Panel();
        p_snDOB.add(lDOB);
        snDD.setText("02");
        snMM.setText("01");
        snYY.setText("2003");
        p_snDOB.add(snDD);
        p_snDOB.add(new Label(sSlash));
        p_snDOB.add(snMM);
        p_snDOB.add(new Label(sSlash));
        p_snDOB.add(snYY);

        Panel p_snTOB = new Panel();
        p_snTOB.add(lTOB);
        snHH.setText("10");
        snMt.setText("23");
        snSS.setText("00");
        p_snTOB.add(snHH);
        p_snTOB.add(new Label(sColon));
        p_snTOB.add(snMt);
        p_snTOB.add(new Label(sColon));
        p_snTOB.add(snSS);

        Panel p_snTZ = new Panel();
        p_snTZ.add(lTZ);
        p_snTZ.add(snTimeZone);

        Panel p_snLAT = new Panel();
        p_snLAT.add(lLAT);
        snLatDD.setText("12");
        snLatMM.setText("18");
        snLatSS.setText("00");
        p_snLAT.add(snLatDD);
        p_snLAT.add(new Label(sDeg));
        p_snLAT.add(snLatMM);
        p_snLAT.add(new Label(sMin));
        //p_snLAT.add(snLatSS);
        //p_snLAT.add(new Label(sSec));
        p_snLAT.add(snLatNS);

        Panel p_snLONG = new Panel();
        p_snLONG.add(lLONG);
        snLongDD.setText("75");
        snLongMM.setText("19");
        snLongSS.setText("00");
        p_snLONG.add(snLongDD);
        p_snLONG.add(new Label(sDeg));
        p_snLONG.add(snLongMM);
        p_snLONG.add(new Label(sMin));
        //p_snLONG.add(snLongSS);
        //p_snLONG.add(new Label(sSec));
        p_snLONG.add(snLongEW);

        //Panel p_snAya = new Panel();
        snAyaDD.setText("00");
        snAyaMM.setText("00");
        snAyaSS.setText("00");
        p_snAya.add(snAyaDD);
        p_snAya.add(new Label(sDeg));
        p_snAya.add(snAyaMM);
        p_snAya.add(new Label(sMin));
        p_snAya.add(snAyaSS);
        p_snAya.add(new Label(sSec));

        Panel p_snAyanamsa = new Panel();
        p_snAyanamsa.add(lAya);
        p_snAyanamsa.add(snAyanamsa);
        p_snAyanamsa.add(p_snAya);

        Panel p_snSummDetl = new Panel();
        p_snSummDetl.add(snBasic);
        p_snSummDetl.add(snDetail);

        add(p_snName);
        add(p_snSex);
        add(p_snDOB);
        add(p_snTOB);
        add(p_snTZ);
        add(p_snPlace);
        add(p_snLAT);
        add(p_snLONG);
        add(p_snAyanamsa);
        add(p_snSummDetl);
        showAyanamsa(false, true);

        setBackground(new Color(250, 225, 180));   // .magenta); // lightGray);
        snGenerate.addActionListener(this);
        add(snGenerate);
        add(lMesg);

    }

    /*----------------------------------------------------*/
    private void showAyanamsa(boolean enabld, boolean visibl) {

        snAyaDD.setEnabled(enabld);
        snAyaMM.setEnabled(enabld);
        snAyaSS.setEnabled(enabld);

        p_snAya.setVisible(visibl);
        //Dimension d = getSize();
        //setSize(new Dimension(d.width+1, d.height));
        //repaint();
        //setSize(new Dimension(d.width, d.height));
    }

    /*----------------------------------------------------*/
    public void itemStateChanged(ItemEvent ie) {
        System.out.println("Changed " + ie);
        //System.out.println(snPlaceSel.getState());
        if (ie.getSource() == snPlaceSel) {
            int i = snPlaceSel.getSelectedIndex();
            if (i > 0 && i <= nPlaces) {
                snLatDD.setText(b_place.token[i - 1][1]);
                snLatMM.setText(b_place.token[i - 1][2]);
                snLatNS.select(b_place.token[i - 1][3].charAt(0) == 'N' ? 0 : 1);
                snLongDD.setText(b_place.token[i - 1][4]);
                snLongMM.setText(b_place.token[i - 1][5]);
                snLongEW.select(b_place.token[i - 1][6].charAt(0) == 'E' ? 0 : 1);
            }
        } else if (ie.getSource() == snAyanamsa) {
            // Last Item shall be  User Defined ...
            boolean envis = snAyanamsa.getSelectedIndex() == snAyanamsa.getItemCount() - 1;
            showAyanamsa(envis, envis);
        }
    }

    /*----------------------------------------------------*/
    private void loadPlaces() {
        int i;
        String placeFName = "Place.sdb";
        placeFName = snExchange.insertDirName(placeFName, "", "snPlace");

        nPlaces = b_place.loadBasicDetails(placeFName);
        snPlaceSel.addItem("-- Select Place --");
        for (i = 0; i < nPlaces; i++) {
            snPlaceSel.addItem(b_place.token[i][0].trim());
        }
        snPlaceSel.select(0);
    }

    /*----------------------------------------------------*/
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Action Performed " + ae);
        if (ae.getSource() == miExit) {
            System.out.println("Exit Pressed");
            this.dispose();
            System.exit(0);
        } else if (ae.getSource() == snGenerate) {
            getDataIntoArgs();
            /*
			for (int i = 0; i < Args.length; i++)
				  System.out.print("[Arg " + i + " = " + Args[i] + ']');
             */
            lMesg.setText(" Please Wait ....");
            snJatak snJ = new snJatak(Args);
            lMesg.setText(" Done !!... ");

            //snApp snA = new snApp();
            //System.out.println("Applet Initiated");
            //snShowDocument("snJatak/" + snFname + ".htm");
            snShowDocument(snJ.snE.snJatakFname);
            //snShowDocument('"'+snJ.snE.snJatakFname+'"');
/*
			try {
   		    	//file:///C:/java/HorosNew/snJatak/Suresh%20P.%20Nambiar.htm
				URL hp = new URL("file:///C:/java/HorosNew/snJatak/" + snFname + ".htm");
				URLConnection hpCon = hp.openConnection();
				System.out.println("Connection OPENED..." + hpCon);
			} catch (MalformedURLException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println("Err:-" + e);
			}
             */
        }
    }

    /*----------------------------------------------------*/
    public void snShowDocument(String fName) {
        String osName = System.getProperty("os.name");
        osName = osName.toUpperCase();
        String cmd;
        cmd = (osName.indexOf("NT") != -1 || osName.indexOf("XP") != -1
                || osName.indexOf("2000") != -1)
                ? "cmd /c " + '"' + "start " + fName + '"' : "start " + '"' + fName + '"';
        //cmd += fName;
        System.out.println(fName);
        //System.out.println(cmd);
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            //System.out.println(p);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*----------------------------------------------------*/
    private String removeWhiteSpaces(String str) {
        String st1 = new String(str);
        char ch;
        /* ---- Check for /|\*-"'`!@#$%^&(){}[]:;,. and remove them  ---*/
        st1 = "";
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            switch (ch) {
                case '/':
                case '|':
                case '\\':
                case '*':
                case '-':
                case '"':
                case '\'':
                case '`':
                case '~':
                case '@':
                case '#':
                case '$':
                case '%':
                case '{':
                case '}':
                case '(':
                case ')':
                case '^':
                case '\t':
                case '+':
                case '=':
                case '[':
                case ']':
                case ' ':
                case '&':
                case '.':
                case ',':
                    break;
                default:
                    st1 = st1 + ch;
                    break;
            }
        }
        str = st1;
        return str;
    }

    /*----------------------------------------------------*/
    private void getDataIntoArgs() {
        int n_args = 25;
        String args[] = new String[n_args];
        String str = new String();
        int cnt = 0;
        int i;

        for (i = 0; i < n_args; i++) {
            args[i] = new String();
        }
        str = snName.getText().trim();
        snFname = removeWhiteSpaces(str);
        args[cnt++] = "FH " + snFname;
        args[cnt++] = str;
        args[cnt++] = snSex.getSelectedItem().trim();
        args[cnt++] = snDD.getText().trim();
        args[cnt++] = snMM.getText().trim();
        args[cnt++] = snYY.getText().trim();
        args[cnt++] = snHH.getText().trim();
        args[cnt++] = snMt.getText().trim();
        args[cnt++] = snSS.getText().trim();
        args[cnt++] = timeZone[snTimeZone.getSelectedIndex()][0];
        i = snPlaceSel.getSelectedIndex();
        str = (i > 0) ? " " + b_place.token[i - 1][0] : "";
        args[cnt++] = snPlace.getText().trim() + str;
        args[cnt++] = snLatDD.getText().trim();
        args[cnt++] = snLatMM.getText().trim();
        //args[cnt++] = snLatSS.getText().trim();
        args[cnt++] = snLatNS.getSelectedItem().trim();
        args[cnt++] = snLongDD.getText().trim();
        args[cnt++] = snLongMM.getText().trim();
        //args[cnt++] = snLongSS.getText().trim();
        args[cnt++] = snLongEW.getSelectedItem().trim();
        args[cnt++] = "" + ((snSummDetl.getSelectedCheckbox() == snBasic) ? 0 : 1);
        args[cnt++] = "" + snAyanamsa.getSelectedIndex();
        args[cnt++] = snAyaDD.getText().trim();
        args[cnt++] = snAyaMM.getText().trim();
        args[cnt++] = snAyaSS.getText().trim();

        Args = new String[cnt];
        System.arraycopy(args, 0, Args, 0, cnt);
        /*for (i = 0; i < cnt; i++)
			System.out.print("  Arg " + i + " = " + args[i]);
         */
    }

    /*----------------------------------------------------*/
    public static void main(String args[]) {
        snJAppln snA = new snJAppln();
        snA.setSize(600, 400);
        snA.setTitle(snJTitle);

        snA.setVisible(true);
    }

    /*----------------------------------------------------*/
    class snWin extends WindowAdapter {

        snJAppln sn_A;

        snWin(snJAppln snA) {
            sn_A = snA;
        }

        public void windowClosing(WindowEvent we) {
            sn_A.dispose();
            System.exit(0);
        }
    }
    /*----------------------------------------------------*/
 /*
	class snApp extends Applet {
		//public void start () {
		snApp () {
			//URL url = getCodeBase();
			//AppletContext ac = new AppletContext();  //getAppletContext();
			try {
				URL url = new URL("file:///snJatak/");
				System.out.println(url);
				//System.out.println(getAppletContext());
				//file:///C:/java/HorosNew/snJatak/Suresh%20P.%20Nambiar.htm
				getAppletContext().showDocument(new URL(url + snFname + ".htm"));
			} catch (MalformedURLException e) {
				System.out.println(e);
			}
		}
	}
     */
 /*----------------------------------------------------*/

}
/*----------------------------------------------------------SuN---------*/
 /*
	snPop.document.write('<PARAM name=snFH value="VH '+ form1.nm.value + '">\n');
	snPop.document.write('<PARAM name=snName value="' + form1.nm.value + '">\n');

	snPop.document.write('<PARAM name=snSex value="' + form1.sex.value + '">\n');
	snPop.document.write('<PARAM name=snDD value=' + form1.dd.value + '>\n');
	snPop.document.write('<PARAM name=snMM value=' + form1.mm.value + '>\n');
	snPop.document.write('<PARAM name=snYY value=' + form1.yy.value + '>\n');
	snPop.document.write('<PARAM name=snHH value=' + form1.hh.value + '>\n');
	snPop.document.write('<PARAM name=snMt value=' + form1.mt.value + '>\n');
	snPop.document.write('<PARAM name=snSS value=' + form1.ss.value + '>\n');
	snPop.document.write('<PARAM name=snTimeZone value=' + form1.tmZ.value + '>\n');
	snPop.document.write('<PARAM name=snPlace value=' + form1.place.value + '>\n');
	snPop.document.write('<PARAM name=snLatDD value=' + form1.ltd.value + '>\n');
	snPop.document.write('<PARAM name=snLatMM value=' + form1.ltm.value + '>\n');
	snPop.document.write('<PARAM name=snLatNS value=' + form1.ns.value + '>\n');
	snPop.document.write('<PARAM name=snLongDD value=' + form1.lgd.value + '>\n');
	snPop.document.write('<PARAM name=snLongMM value=' + form1.lgm.value + '>\n');
	snPop.document.write('<PARAM name=snLongEW value=' + form1.ew.value + '>\n');
	snPop.document.write('<PARAM name=snAyanamsa value=' + form1.ayan.value + '>\n');
	snPop.document.write('<PARAM name=snAyaDD value=' + form1.ayd.value + '>\n');
	snPop.document.write('<PARAM name=snAyaMM value=' + form1.aym.value + '>\n');
	snPop.document.write('<PARAM name=snAyaSS value=' + form1.ays.value + '>\n');
	snPop.document.write('<PARAM name=snSummDetl value=' + form1.summdetl.value + '>\n');
 */
