
package snJatakamAI.snJatakam.sn_Jatakam;

/*---------------------------------------------------*/
//package snJatak;
/*---------------------------------------------------*/
import java.awt.*;
import java.awt.event.*;
import java.io.File;
//import java.applet.*;
//import java.net.*;
//import javax.swing.event.*;
//import java.util.*;
//import java.awt.Cursor;
//import javax.swing.JLabel;
//import javax.swing.JEditorPane;
import snJatakamAI.snJatakam.sn_Jatakam.snMatch;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snExchange;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snVarsJ;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snVarsM;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.*;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic.*;

/*---------------------------------------------------*/
class snJMatch extends Frame implements ItemListener, ActionListener {

    //static int nArgs = 25;
    String ArgsG[], ArgsB[];   // = new String[nArgs];
    int snDetail = 1;
    double snPoruthaCutOff;
    String snFnameG = new String();
    String snFnameB = new String();
    snBasicDetls b_place = new snBasicDetls();
    int nPlaces;

    String snIndexFile = snExchange.insertDirName(
            "snIndex.htm", snVarsJ.drvName, "snIndex");

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

    Button snGenerate = new Button("Match Horoscope");
    Button snView = new Button("View Compatibility");

    static Label lNameG = new Label("Name : ");
    static Label lNameB = new Label("Name : ");
    static Label lSexG = new Label("Sex : ");
    static Label lSexB = new Label("Sex : ");
    TextField snNameG = new TextField(40);
    TextField snNameB = new TextField(40);
    static Label lPlaceG = new Label("Place : ");
    static Label lPlaceB = new Label("Place : ");
    TextField snPlaceG = new TextField(25);
    TextField snPlaceB = new TextField(25);
    static Label lDOBG = new Label("Date of Birth (dd/mm/yyyy) :");
    static Label lDOBB = new Label("Date of Birth (dd/mm/yyyy) :");
    TextField snDDG = new TextField(2);
    TextField snMMG = new TextField(2);
    TextField snYYG = new TextField(4);
    TextField snDDB = new TextField(2);
    TextField snMMB = new TextField(2);
    TextField snYYB = new TextField(4);
    static Label lTOBG = new Label("Time of Birth (HH:MM:SS) :");
    static Label lTOBB = new Label("Time of Birth (HH:MM:SS) :");
    TextField snHHG = new TextField(2);
    TextField snMtG = new TextField(2);
    TextField snSSG = new TextField(2);
    TextField snHHB = new TextField(2);
    TextField snMtB = new TextField(2);
    TextField snSSB = new TextField(2);
    static Label lLATG = new Label("Latitude :");
    static Label lLATB = new Label("Latitude :");
    TextField snLatDDG = new TextField(2);
    TextField snLatMMG = new TextField(2);
    TextField snLatSSG = new TextField(2);
    TextField snLatDDB = new TextField(2);
    TextField snLatMMB = new TextField(2);
    TextField snLatSSB = new TextField(2);
    static Label lLONGG = new Label("Longitude :");
    static Label lLONGB = new Label("Longitude :");
    TextField snLongDDG = new TextField(2);
    TextField snLongMMG = new TextField(2);
    TextField snLongSSG = new TextField(2);
    TextField snLongDDB = new TextField(2);
    TextField snLongMMB = new TextField(2);
    TextField snLongSSB = new TextField(2);
    static Label lAya = new Label("Ayanamsa :");
    TextField snAyaDD = new TextField(2);
    TextField snAyaMM = new TextField(2);
    TextField snAyaSS = new TextField(2);
    static Label lCutOff = new Label("Show only if Porutha-Value is more than :");
    TextField snCutOff = new TextField(6);

    //static TextField snBasicDetl = new TextField(1);
    static Label lMesg = new Label("                             ");

    Choice snSexG = new Choice();
    Choice snSexB = new Choice();
    Choice snPlaceSelG = new Choice();
    Choice snPlaceSelB = new Choice();
    Choice snLongEWG = new Choice();
    Choice snLongEWB = new Choice();
    Choice snLatNSG = new Choice();
    Choice snLatNSB = new Choice();
    static Label lTZG = new Label("Time Zone :");
    static Label lTZB = new Label("Time Zone :");
    Choice snTimeZoneG = new Choice();
    Choice snTimeZoneB = new Choice();
    Choice snAyanamsa = new Choice();
    CheckboxGroup snBasicDetlG = new CheckboxGroup();
    Checkbox snBasicG = new Checkbox("Basic", snBasicDetlG, true);
    Checkbox snDetailG = new Checkbox("Detail", snBasicDetlG, false);
    CheckboxGroup snBasicDetlB = new CheckboxGroup();
    Checkbox snBasicB = new Checkbox("Basic", snBasicDetlB, true);
    Checkbox snDetailB = new Checkbox("Detail", snBasicDetlB, false);

    static String snJTitle
            = new String("snJatakam Application - by Suresh P. Nambiar (C)opyright");

    Panel p_snAya = new Panel();

    MenuBar mb = new MenuBar();
    Menu mSystem = new Menu("System");
    MenuItem miExit = new MenuItem("Exit");
    static int mnuBarHeight;

    {
        File pSFD = new File(snIndexFile);
        snIndexFile = pSFD.getAbsolutePath();
    }

    /*----------------------------------------------------*/
    snJMatch() {
        super(snJTitle);

        addWindowListener(new snWin(this));
        miExit.addActionListener(this);
        mSystem.add(miExit);
        mb.add(mSystem);
        //setMenuBar(mb);
        mnuBarHeight = 25;

        setFont(new Font("Arial", Font.PLAIN, 11));

        String sSlash = new String("/");
        String sColon = new String(":");
        String sDeg = new String("deg.");
        String sMin = new String("min.");
        String sSec = new String("sec.");

        snSexG.addItem("Male");
        snSexG.addItem("Female");
        snSexG.select(1);
        snSexB.addItem("Male");
        snSexB.addItem("Female");
        snSexB.select(0);

        loadPlaces();
        snPlaceSelG.addItemListener(this);
        snPlaceSelB.addItemListener(this);

        for (int i = 0; i < timeZone.length; i++) {
            snTimeZoneG.addItem(timeZone[i][1]);
            snTimeZoneB.addItem(timeZone[i][1]);
        }
        snTimeZoneG.select(34);
        snTimeZoneB.select(34);

        snLongEWG.addItem("East");
        snLongEWG.addItem("West");
        snLongEWG.select(0);
        snLongEWB.addItem("East");
        snLongEWB.addItem("West");
        snLongEWB.select(0);

        snLatNSG.addItem("North");
        snLatNSG.addItem("South");
        snLatNSG.select(0);
        snLatNSB.addItem("North");
        snLatNSB.addItem("South");
        snLatNSB.select(0);

        snAyanamsa.addItem("N.C.Lahiri");
        snAyanamsa.addItem("B.V.Raman");
        snAyanamsa.addItem("Chandra Hari");
        snAyanamsa.addItem("User Specified...");
        snAyanamsa.select(2);
        snAyanamsa.addItemListener(this);

        Panel p_snNameG = new Panel();
        p_snNameG.add(lNameG);
        snNameG.setText("Stree");
        p_snNameG.add(snNameG);
        Panel p_snNameB = new Panel();
        p_snNameB.add(lNameB);
        snNameB.setText("Purusha");
        p_snNameB.add(snNameB);

        Panel p_snSexG = new Panel();
        p_snSexG.add(lSexG);
        p_snSexG.add(snSexG);
        Panel p_snSexB = new Panel();
        p_snSexB.add(lSexB);
        p_snSexB.add(snSexB);

        Panel p_snPlaceG = new Panel();
        p_snPlaceG.add(lPlaceG);
        snPlaceG.setText("Payyanur");
        p_snPlaceG.add(snPlaceG);
        p_snPlaceG.add(snPlaceSelG);
        Panel p_snPlaceB = new Panel();
        p_snPlaceB.add(lPlaceB);
        snPlaceB.setText("Payyanur");
        p_snPlaceB.add(snPlaceB);
        p_snPlaceB.add(snPlaceSelB);

        Panel p_snDOBG = new Panel();
        p_snDOBG.add(lDOBG);
        snDDG.setText("02");
        snMMG.setText("01");
        snYYG.setText("2003");
        p_snDOBG.add(snDDG);
        p_snDOBG.add(new Label(sSlash));
        p_snDOBG.add(snMMG);
        p_snDOBG.add(new Label(sSlash));
        p_snDOBG.add(snYYG);
        Panel p_snDOBB = new Panel();
        p_snDOBB.add(lDOBB);
        snDDB.setText("02");
        snMMB.setText("01");
        snYYB.setText("2003");
        p_snDOBB.add(snDDB);
        p_snDOBB.add(new Label(sSlash));
        p_snDOBB.add(snMMB);
        p_snDOBB.add(new Label(sSlash));
        p_snDOBB.add(snYYB);

        Panel p_snTOBG = new Panel();
        p_snTOBG.add(lTOBG);
        snHHG.setText("10");
        snMtG.setText("23");
        snSSG.setText("00");
        p_snTOBG.add(snHHG);
        p_snTOBG.add(new Label(sColon));
        p_snTOBG.add(snMtG);
        p_snTOBG.add(new Label(sColon));
        p_snTOBG.add(snSSG);
        Panel p_snTOBB = new Panel();
        p_snTOBB.add(lTOBB);
        snHHB.setText("10");
        snMtB.setText("23");
        snSSB.setText("00");
        p_snTOBB.add(snHHB);
        p_snTOBB.add(new Label(sColon));
        p_snTOBB.add(snMtB);
        p_snTOBB.add(new Label(sColon));
        p_snTOBB.add(snSSB);

        Panel p_snTZG = new Panel();
        p_snTZG.add(lTZG);
        p_snTZG.add(snTimeZoneG);
        Panel p_snTZB = new Panel();
        p_snTZB.add(lTZB);
        p_snTZB.add(snTimeZoneB);

        Panel p_snLATG = new Panel();
        p_snLATG.add(lLATG);
        snLatDDG.setText("12");
        snLatMMG.setText("18");
        snLatSSG.setText("00");
        p_snLATG.add(snLatDDG);
        p_snLATG.add(new Label(sDeg));
        p_snLATG.add(snLatMMG);
        p_snLATG.add(new Label(sMin));
        //p_snLAT.add(snLatSS);
        //p_snLAT.add(new Label(sSec));
        p_snLATG.add(snLatNSG);
        Panel p_snLATB = new Panel();
        p_snLATB.add(lLATB);
        snLatDDB.setText("12");
        snLatMMB.setText("18");
        snLatSSB.setText("00");
        p_snLATB.add(snLatDDB);
        p_snLATB.add(new Label(sDeg));
        p_snLATB.add(snLatMMB);
        p_snLATB.add(new Label(sMin));
        //p_snLAT.add(snLatSS);
        //p_snLAT.add(new Label(sSec));
        p_snLATB.add(snLatNSB);

        Panel p_snLONGG = new Panel();
        p_snLONGG.add(lLONGG);
        snLongDDG.setText("75");
        snLongMMG.setText("19");
        snLongSSG.setText("00");
        p_snLONGG.add(snLongDDG);
        p_snLONGG.add(new Label(sDeg));
        p_snLONGG.add(snLongMMG);
        p_snLONGG.add(new Label(sMin));
        //p_snLONG.add(snLongSS);
        //p_snLONG.add(new Label(sSec));
        p_snLONGG.add(snLongEWG);
        Panel p_snLONGB = new Panel();
        p_snLONGB.add(lLONGB);
        snLongDDB.setText("75");
        snLongMMB.setText("19");
        snLongSSB.setText("00");
        p_snLONGB.add(snLongDDB);
        p_snLONGB.add(new Label(sDeg));
        p_snLONGB.add(snLongMMB);
        p_snLONGB.add(new Label(sMin));
        //p_snLONG.add(snLongSS);
        //p_snLONG.add(new Label(sSec));
        p_snLONGB.add(snLongEWB);

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

        Panel p_snBasicDetlG = new Panel();
        p_snBasicDetlG.add(snBasicG);
        p_snBasicDetlG.add(snDetailG);
        Panel p_snBasicDetlB = new Panel();
        p_snBasicDetlB.add(snBasicB);
        p_snBasicDetlB.add(snDetailB);

        //setLayout(new FlowLayout(FlowLayout.LEFT));
        setLayout(null);

        Panel p_snG = new Panel(new FlowLayout(FlowLayout.LEFT));
        //p_snG.setLayout(new FlowLayout(FlowLayout.LEFT));
        //p_snG.setSize(100,600);
        //p_snG.setLocation(10,10);
        //p_snG.setBounds(0,40,600,240);
        p_snG.setBounds(0, 40, 600, 220);
        p_snG.setBackground(new Color(173, 232, 130));
        //p_snG.setBackground(Color.green);
        p_snG.add(p_snNameG);
        p_snG.add(p_snSexG);
        p_snG.add(p_snDOBG);
        p_snG.add(p_snTOBG);
        p_snG.add(p_snTZG);
        p_snG.add(p_snPlaceG);
        p_snG.add(p_snLATG);
        p_snG.add(p_snLONGG);
        p_snG.add(p_snBasicDetlG);

        Panel p_snB = new Panel(new FlowLayout(FlowLayout.LEFT));
        //p_snB.setBounds(0,280,600,240);
        p_snB.setBounds(0, 260, 600, 220);
        p_snB.setBackground(new Color(232, 201, 130));
        //p_snB.setLayout(new FlowLayout(FlowLayout.LEFT));
        p_snB.add(p_snNameB);
        p_snB.add(p_snSexB);
        p_snB.add(p_snDOBB);
        p_snB.add(p_snTOBB);
        p_snB.add(p_snTZB);
        p_snB.add(p_snPlaceB);
        p_snB.add(p_snLATB);
        p_snB.add(p_snLONGB);
        p_snB.add(p_snBasicDetlB);

        //p_snG.setBackground(Color.green);
        //p_snB.setBackground(Color.orange);
        add(p_snG);
        add(p_snB);

        Panel p_snCutOff = new Panel();
        p_snCutOff.add(lCutOff);
        p_snCutOff.add(snCutOff);
        snCutOff.setText("-999999");

        //p_snAyanamsa.setBounds(0,520,600,50);
        p_snAyanamsa.setBounds(0, 480, 600, 40);
        p_snAyanamsa.setLayout(new FlowLayout(FlowLayout.LEFT));
        p_snAyanamsa.setBackground(new Color(187, 205, 234));
        add(p_snAyanamsa);
        //p_snCutOff.setBounds(0,570,600,30);
        p_snCutOff.setBounds(0, 520, 600, 30);
        p_snCutOff.setBackground(new Color(252, 241, 218));
        p_snCutOff.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(p_snCutOff);
        showAyanamsa(false, true);

        setBackground(Color.lightGray);
        snGenerate.addActionListener(this);
        snView.addActionListener(this);

        Panel p_snGen = new Panel();
        p_snGen.add(snGenerate);
        p_snGen.add(lMesg);
        p_snGen.add(snView);

        //p_snGen.setBounds(0,615,600,50);
        p_snGen.setBounds(0, 550, 600, 50);
        add(p_snGen);

        /*
		JEditorPane jp = new JEditorPane();
		jp.setContentType("text/html");
		jp.setText("<HTML><BODY><A HREF=\"" +
		  	"c:/java/Horosnew/" + snIndexFile  + "\">View Compatibility</A></BODY></HTML>");
         */ /*
		<A HREF="C:\java\HorosNew\snMatch\_Purusha_Stree.htm">
		Purusha with Stree</A>
         */
        //add(jp);

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
        if (ie.getSource() == snPlaceSelG) {
            int i = snPlaceSelG.getSelectedIndex();
            if (i > 0 && i <= nPlaces) {
                snLatDDG.setText(b_place.token[i - 1][1]);
                snLatMMG.setText(b_place.token[i - 1][2]);
                snLatNSG.select(b_place.token[i - 1][3].charAt(0) == 'N' ? 0 : 1);
                snLongDDG.setText(b_place.token[i - 1][4]);
                snLongMMG.setText(b_place.token[i - 1][5]);
                snLongEWG.select(b_place.token[i - 1][6].charAt(0) == 'E' ? 0 : 1);
            }
        } else if (ie.getSource() == snPlaceSelB) {
            int i = snPlaceSelB.getSelectedIndex();
            if (i > 0 && i <= nPlaces) {
                snLatDDB.setText(b_place.token[i - 1][1]);
                snLatMMB.setText(b_place.token[i - 1][2]);
                snLatNSB.select(b_place.token[i - 1][3].charAt(0) == 'N' ? 0 : 1);
                snLongDDB.setText(b_place.token[i - 1][4]);
                snLongMMB.setText(b_place.token[i - 1][5]);
                snLongEWB.select(b_place.token[i - 1][6].charAt(0) == 'E' ? 0 : 1);
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
        snPlaceSelG.addItem("-- Select Place --");
        snPlaceSelB.addItem("-- Select Place --");
        for (i = 0; i < nPlaces; i++) {
            snPlaceSelG.addItem(b_place.token[i][0].trim());
            snPlaceSelB.addItem(b_place.token[i][0].trim());
        }
        snPlaceSelG.select(0);
        snPlaceSelB.select(0);
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
            run_matching();
            //snJatak snJ = new snJatak(Args);
            lMesg.setText(" Done !!... ");

            //snApp snA = new snApp();
            //System.out.println("Applet Initiated");
            snShowDocument(snIndexFile);
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
        } else if (ae.getSource() == snView) {
            snShowDocument(snIndexFile);
        }
    }

    /*----------------------------------------------------*/
    public void run_matching() {
        //System.out.println(" Gone thru run_matching()");
        snMatch snM = new snMatch(ArgsB, 1, ArgsG, snPoruthaCutOff, "FH");
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
        int i, cnt;

        for (cnt = 0, i = 0; i < n_args; i++) {
            args[i] = new String();
        }
        str = snNameG.getText().trim();
        snFnameG = removeWhiteSpaces(str);
        args[cnt++] = "FH " + snFnameG;
        args[cnt++] = str;
        args[cnt++] = snSexG.getSelectedItem().trim();
        args[cnt++] = snDDG.getText().trim();
        args[cnt++] = snMMG.getText().trim();
        args[cnt++] = snYYG.getText().trim();
        args[cnt++] = snHHG.getText().trim();
        args[cnt++] = snMtG.getText().trim();
        args[cnt++] = snSSG.getText().trim();
        args[cnt++] = timeZone[snTimeZoneG.getSelectedIndex()][0];
        i = snPlaceSelG.getSelectedIndex();
        str = (i > 0) ? " " + b_place.token[i - 1][0] : "";
        args[cnt++] = snPlaceG.getText().trim() + str;
        args[cnt++] = snLatDDG.getText().trim();
        args[cnt++] = snLatMMG.getText().trim();
        //args[cnt++] = snLatSS.getText().trim();
        args[cnt++] = snLatNSG.getSelectedItem().trim();
        args[cnt++] = snLongDDG.getText().trim();
        args[cnt++] = snLongMMG.getText().trim();
        //args[cnt++] = snLongSS.getText().trim();
        args[cnt++] = snLongEWG.getSelectedItem().trim();
        args[cnt++] = "" + ((snBasicDetlG.getSelectedCheckbox() == snBasicG) ? 0 : 1);
        args[cnt++] = "" + snAyanamsa.getSelectedIndex();
        args[cnt++] = snAyaDD.getText().trim();
        args[cnt++] = snAyaMM.getText().trim();
        args[cnt++] = snAyaSS.getText().trim();

        ArgsG = new String[cnt];
        System.arraycopy(args, 0, ArgsG, 0, cnt);

        cnt = 0;
        str = snNameB.getText().trim();
        snFnameB = removeWhiteSpaces(str);
        args[cnt++] = "FH " + snFnameB;
        args[cnt++] = str;
        args[cnt++] = snSexB.getSelectedItem().trim();
        args[cnt++] = snDDB.getText().trim();
        args[cnt++] = snMMB.getText().trim();
        args[cnt++] = snYYB.getText().trim();
        args[cnt++] = snHHB.getText().trim();
        args[cnt++] = snMtB.getText().trim();
        args[cnt++] = snSSB.getText().trim();
        args[cnt++] = timeZone[snTimeZoneB.getSelectedIndex()][0];
        i = snPlaceSelB.getSelectedIndex();
        str = (i > 0) ? " " + b_place.token[i - 1][0] : "";
        args[cnt++] = snPlaceB.getText().trim() + str;
        args[cnt++] = snLatDDB.getText().trim();
        args[cnt++] = snLatMMB.getText().trim();
        //args[cnt++] = snLatSS.getText().trim();
        args[cnt++] = snLatNSB.getSelectedItem().trim();
        args[cnt++] = snLongDDB.getText().trim();
        args[cnt++] = snLongMMB.getText().trim();
        //args[cnt++] = snLongSS.getText().trim();
        args[cnt++] = snLongEWB.getSelectedItem().trim();
        args[cnt++] = "" + ((snBasicDetlB.getSelectedCheckbox() == snBasicB) ? 0 : 1);
        args[cnt++] = "" + snAyanamsa.getSelectedIndex();
        args[cnt++] = snAyaDD.getText().trim();
        args[cnt++] = snAyaMM.getText().trim();
        args[cnt++] = snAyaSS.getText().trim();

        snPoruthaCutOff = Double.parseDouble(snCutOff.getText().trim());
        ArgsB = new String[cnt];
        System.arraycopy(args, 0, ArgsB, 0, cnt);

        /*for (i = 0; i < cnt; i++)
			System.out.print("  Arg " + i + " = " + args[i]);
         */
    }

    /*----------------------------------------------------*/
    public static void main(String args[]) {
        snJMatch snA = new snJMatch();
        //snA.setSize(600,650 + mnuBarHeight);
        snA.setSize(600, 565 + mnuBarHeight);
        snA.setTitle(snJTitle);

        snA.setVisible(true);
    }

    /*----------------------------------------------------*/
    class snWin extends WindowAdapter {

        snJMatch snA;

        snWin(snJMatch snA) {
            this.snA = snA;
        }

        public void windowClosing(WindowEvent we) {
            System.out.println(we);
            snA.dispose();
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
