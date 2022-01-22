
/*---------------------------------------------------------------*/
//package snJatakam;
//package sn_Jatak;
/*---------------------------------------------------------------*/
//import java.io.*;
//import java.util.*;
/*---------------------------------------------------------------*/

/*---------------------------------------------------
        Suresh's Horoscope Variables
-----------------------------------------------------*/

class snVarsJ {
     //static final double PI = 3.14159265359d;
     static final double PI = 3.1415926535897932384626433832795d;
     static final String day[] = {"Sunday", "Monday", "Tuesday", "Wednesday",
         "Thursday", "Friday", "Saturday"};
     static final String ras[] = {"Mesha   ", "Vrisha  ", "Mithuna ",
         "Karkata ", "Simha   ", "Kanya   ", "Tula    ", "Vriscika",
         "Dhanus  ", "Makara  ", "Kumbha  ", "Meena   "};
     static final String tit[] = {"Pratipad", "Dvitiya", "Tritiya",
         "Chaturthi", "Panchami", "Sashti", "Saptami", "Ashtami", "Navami",
         "Dasami", "Ekadasi", "Dvadasi", "Trayodasi", "Chaturdasi",
         "Purnima", "Pratipad", "Dvitiya", "Tritiya", "Chaturthi",
         "Panchami", "Sashti", "Saptami", "Ashtami", "Navami", "Dasami",
         "Ekadasi", "Dvadasi", "Trayodasi", "Chaturdasi", "Amavasya"};
         /*
     static final String nak[] = {"Asvini     ", "Bharani    ", "Krittika   ",
         "Rohini     ", "Mrigasiras ", "Ardra      ", "Punarvasu  ",
         "Pushya     ", "Aslesha    ", "Magha      ", "Purvaphal  ",
         "Uttaraphal ", "Hasta      ", "Chitra     ", "Svati      ",
         "Visakha    ", "Anuradha   ", "Jyestha    ", "Moola      ",
         "Purvasada  ", "Uttarasada ", "Sravana    ", "Dhanistha  ",
         "Satabhisaj ", "Purvabadra ", "Uttarabadra", "Revati     " };
         */
     static final String nak[] = {"Aswati     ", "Bharani    ", "Kaartika   ",
         "Rohini     ", "Makayiryam ", "Tiruvatira ", "Punartam   ",
         "Pooyam     ", "Aayilyam   ", "Makam      ", "Pooram     ",
         "Uttram     ", "Attam      ", "Chitra     ", "Choti      ",
         "Visakham   ", "Anizham    ", "Trikketta  ", "Moolam     ",
         "Pooraadam  ", "Utraadam   ", "Tiruvonam  ", "Avittom    ",
         "Chatayam   ", "Puroruttati", "Uttrattati ", "Revati     " };
     static final String yog[] = {"Viskumbha", "Priti", "Ayusman", "Saubhagya",
         "Sobhana", "Atiganda", "Sukarma", "Dhriti", "Sula", "Ganda",
         "Vriddhi", "Dhruva", "Vyaghata", "Harshana", "Vajra", "Siddhi",
         "Vyatipata", "Variyan", "Parigha", "Siva", "Siddha", "Sadhya",
         "Subha", "Sukla", "Brahma", "Indra", "Vaidhriti"};
     static final String dL[] = {"Ketu    ", "Sukra   ", "Soorya  ",
         "Chandra ", "Kuja    ", "Rahu    ", "Guru    ", "Sani    ",
         "Budha   "};
     static final double dY[] = { 7, 20, 6, 10, 7, 18, 16, 19, 17 };
     static final String graha[] = {"Lagn", "Ravi", "Budh", "Sukr", "Kuja",
         "Guru", "Sani", "Chan", "Rahu", "Ketu", "Uran", "Nept",
         "Plut", "Maan" };
     static final String grahalong[] = {"Lagna  ", "Soorya ", "Budha  ",
         "Sukra  ", "Kuja   ", "Guru   ", "Sani   ", "Chandra",
         "Rahu   ", "Ketu   ", "Uranus ", "Neptune", "Pluto  ", "Maandi " };
     static final String div[] = {"   Rasi   ", " Drekkana ", " Sapthamsa",
         " Navamsa  ", " Dasamsa  ", "Dwadasamsa", "Shodasamsa" };
     static final String ganam[] = {"Deva", "Maanusha", "Aasura"};
     static final int gnmId[] = {0,1,2,1,0,1,0,0,2,2,1,1,0,
                           2,0,2,0,2,2,1,1,0,2,2,1,1,0};
     static final String devata[] = {"Aswinis", "Yama", "Agni", "Brahma",
         "Chandra", "Shiva", "Aditi", "Brhaspati", "Sarpas", "Pitrkkal",
         "Aaryamaav", "Bhagan", "Aaditya", "Twashtav", "Vaayu",
         "Indragni", "Maitran", "Indra", "Nir-rti", "Jalam", "Viswadevas",
         "Vishnu", "Vasus", "Varuna", "Ajaykapaat", "Ahirbudhni",
         "Pooshav" };
     static final String vriksha[] = {"Kaanjiram", "Nelli", "Atthi", "Njaval",
         "Karingali", "Karimaram", "Bamboo", "Arayaal", "Naakam",
         "Peraal", "Plaasu", "Itthi", "Ambazham", "Koovalam",
         "Nirmarutu", "Vayyankatavu", "Ilanji", "Vetti", "Payina",
         "Vanji", "Pilaavu", "Erukku", "Vanni", "Kadambu",
         "Tenmaavu", "Karimbana", "Irippa" };
     static final String yoni[] = {"Stree", "Purusha"};
     static final int yonId[] = {1,1,0,0,0,0,0,1,1,1,0,1,0,
                           0,1,1,0,1,1,1,1,1,0,0,1,0,0};
     static final String bhootam[] = {"Bhoomi", "Jalam", "Agni",
         "Vayu", "Aakasam"};
     static final String mrigam[] = {"Kutira", "Aana", "Aadu",
         "Paambu", "Paambu", "Naaya", "Poocha", "Aadu", "Karimpoocha",
         "Eli", "Chundeli", "Ottakam", "Pothu", "Aalpuli", "Mahisham",
         "Simham", "Maan", "Kezha", "Swaavu", "Kapi", "Kaala",
         "Vaanaram", "Nallal", "Kutira", "Naran", "Pasu", "Aana"};
     static final String pakshi[] = {"Pullu","Chakoram","Kaakka",
         "Kozhi","Mayil"};
     static final String paksham[] = {"Krishna", "Shukla ", "       "};
     static final String karanam[] = {"Pullu    ", "Naalkkali", "Paambu   ",
         "Puzhu    ", "Simham   ", "Vyaghram ", "Varaaham ",
         "Kazhuta  ", "Aana     ", "Surabhi  ", "Vishti   "};
     static final int karId[] = { 2, 3,
         4, 5, 6, 7, 8, 9, 10, 4, 5, 6, 7, 8, 9, 10,
         4, 5, 6, 7, 8, 9, 10, 4, 5, 6, 7, 8, 9, 10,
         4, 5, 6, 7, 8, 9, 10, 4, 5, 6, 7, 8, 9, 10,
         4, 5, 6, 7, 8, 9, 10, 4, 5, 6, 7, 8, 9, 10, 0, 1 };

}

/*---------------------------------------------------------------*/
class snVarsM {
     static final short NONE = -1;

     static final short NAKSHATRAS = 27;
     static final short ASWATHI = 1;
     static final short BHARANI = 2;
     static final short KARTHIKA = 3;
     static final short ROHINI = 4;
     static final short MAKEERYAM = 5;
     static final short THIRUVATHIRA = 6;
     static final short PUNARTHAM = 7;
     static final short POOYAM = 8;
     static final short AYILYAM = 9;
     static final short MAKAM = 10;
     static final short POORAM = 11;
     static final short UTHRAM = 12;
     static final short ATHAM = 13;
     static final short CHITRA = 14;
     static final short CHOTI = 15;
     static final short VISAKHAM = 16;
     static final short ANIZHAM = 17;
     static final short TRIKKETA = 18;
     static final short MOOLAM = 19;
     static final short POORADAM = 20;
     static final short UTHRADAM = 21;
     static final short THIRUVONAM = 22;
     static final short AVITTOM = 23;
     static final short CHATAYAM = 24;
     static final short POORORUTTATHI = 25;
     static final short UTHRATTATHI = 26;
     static final short REVATHI = 27;
     //static final short REVATHI_27 = 27;

     static final short MRIGAMS = 23;
     static final short KUTHIRA = 1;
     static final short AANA = 2;
     static final short AADU = 3;
     static final short PAAMBU = 4;
     static final short NAAYA = 5;
     static final short POOCHA = 6;
     static final short KARIMPOOCHA = 7;
     static final short ELI = 8;
     static final short CHUNDELI = 9;
     static final short OTTAKAM = 10;
     static final short POTHU = 11;
     static final short AALPULI = 12;
     static final short MAHISHAM = 13;
     static final short SIMHAM = 14;
     static final short MAAN = 15;
     static final short KEZHA = 16;
     static final short SWAAVU = 17;
     static final short KAPI = 18;
     static final short KAALA = 19;
     static final short VAANARAM = 20;
     static final short NALLAL = 21;
     static final short NARAN = 22;
     static final short PASU = 23;

     static final short VRIKSHAMS = 27;
     static final short KAANJIRAM = 1;
     static final short NELLI = 2;
     static final short ATHI = 3;
     static final short NJAAVAL = 4;
     static final short KARINGALI = 5;
     static final short KARIMARAM = 6;
     static final short MULA = 7;
     static final short ARAYAAL = 8;
     static final short NAAKAM = 9;
     static final short PERAAL = 10;
     static final short PLAASU = 11;
     static final short ITHI = 12;
     static final short AMBAZHAM = 13;
     static final short KOOVALAM = 14;
     static final short NEERMARUTU = 15;
     static final short VAYYANKATAVU = 16;
     static final short ILANJI = 17;
     static final short VETTI = 18;
     static final short PAYINA = 19;
     static final short VANJI = 20;
     static final short PILAAVU = 21;
     static final short ERUKKU = 22;
     static final short VANNI = 23;
     static final short KADAMBU = 24;
     static final short TENMAAVU = 25;
     static final short KARIMPANA = 26;
     static final short IRIPPA = 27;

     static final short GANAMS = 3;
     static final short DEVAM = 1;
     static final short MAANUSHAM = 2;
     static final short AASURAM = 3;

     static final short YONIS = 2;
     static final short PURUSHA = 1;
     static final short STREE = 2;

     static final short PAKSHIS = 5;
     static final short PULLU = 1;
     static final short CHAKORAM = 2;
     static final short KAAKKA = 3;
     static final short KOZHI = 4;
     static final short MAYIL = 5;

     static final short BHOOTAS = 5;
     static final short BHOOMI = 1;
     static final short JALAM = 2;
     static final short AGNI = 3;
     static final short VAAYU = 4;
     static final short AAKAASAM = 5;

     static final short DEVATAAS = 27;
     static final short ASWINIS = 1;
     static final short YAMAN = 2;
     static final short AGNI_D = 3;
     static final short BRAHMA = 4;
     static final short CHANDRA = 5;
     static final short SHIVA = 6;
     static final short ADITI = 7;
     static final short BRUHASPATI_D = 8;
     static final short SARPPAAS = 9;
     static final short PITRUKKAL = 10;
     static final short AARYAMAAVU = 11;
     static final short BHAGAN = 12;
     static final short AADITYA_D = 13;
     static final short TWASHTAAVU = 14;
     static final short VAAYU_D = 15;
     static final short INDRAAGNI = 16;
     static final short MAITRAAN = 17;
     static final short INDRA = 18;
     static final short NIRURTI = 19;
     static final short JALAM_D = 20;
     static final short VISWADEVAS = 21;
     static final short VISHNU = 22;
     static final short VASUKKAL = 23;
     static final short VARUNAN = 24;
     static final short AJAIKAPAAT = 25;
     static final short AHIRBUDHNI = 26;
     static final short POOSHAAV = 27;

     static final short DASAS = 120;
     static final short AADITYA_DASA = 6;
     static final short SASI_DASA = 10;
     static final short KUJA_DASA = 7;
     static final short RAAHU_DASA = 18;
     static final short BRUHASPATI_DASA = 16;
     static final short SANI_DASA = 19;
     static final short BUDHA_DASA = 17;
     static final short KETU_DASA = 7;
     static final short SUKRA_DASA = 20;

     static final short GRAHAS = 13;
     static final short LAGNA = 0;
     static final short AADITYA = 1;
     static final short BUDHA = 2;
     static final short SUKRA = 3;
     static final short KUJA = 4;
     static final short BRUHASPATI = 5;
     static final short SANI = 6;
     static final short SASI = 7;
     static final short RAAHU = 8;
     static final short KETU = 9;
     static final short URANUS = 10;
     static final short NEPTUNE = 11;
     static final short PLUTO = 12;
     static final short MAANDI = 13;
     /* 0-Lagn 1-Ravi 2-Budh 3-Sukr 4-Kuja 5-Guru 6-Sani 7-Moon
          8-Rahu 9-Ketu 13-Maandi   */

     static final short dasa_grh[] = { KETU, SUKRA, AADITYA,
         SASI, KUJA, RAAHU, BRUHASPATI, SANI, BUDHA };

     static final short LAGNA_P = 0;
     static final short SASI_P = 1;
     static final short SUKRA_P = 2;
     static final short AADITYA_PAP = 0;
     static final short KUJA_PAP = 1;
     static final short KETU_PAP = 2;
     static final short TOTAL_PAP = 3;
     static final short SANI_PAP = 4;
     static final short RAAHU_PAP = 5;
     static final short GRANDTOTAL_PAP = 6;

     static final short RAASIS = 12;
     static final short MEDAM = 1;
     static final short EDAVAM = 2;
     static final short MITHUNAM = 3;
     static final short KARKKIDAKAM = 4;
     static final short CHINGAM = 5;
     static final short KANNI = 6;
     static final short TULAAM = 7;
     static final short VRISCHIKAM = 8;
     static final short DHANU = 9;
     static final short MAKARAM = 10;
     static final short KUMBHAM = 11;
     static final short MEENAM = 0;

     static final short RAJJU = 3;
     static final short AADI = 1;
     static final short MADHYA = 2;
     static final short ANTYA = 3;

     static final short CHALANAM = 3;
     static final short CHARAM = 1;
     static final short STHIRAM = 2;
     static final short UBHAYAM = 3;

     static final short SZ_MRIGAMS = 20;
     static final short SZ_20 = 20;
     static final short SZ_15 = 15;
     static final short SZ_10 = 10;
     static final short SZ_VRIKSHAMS = 20;
     static final short SZ_GANAMS = 20;
     static final short SZ_YONIS = 10;
     static final short SZ_PAKSHIS = 15;
     static final short SZ_BHOOTAS = 15;
     static final short SZ_DEVATAAS = 15;
     static final short SZ_DASAS = 20;
     static final short SZ_GRAHAS = 15;

     static final short NODOSHAM        = 0x0000;
     static final short ATIUTHAMAM      = 0x0001;
     static final short UTHAMAM         = 0x0002;
     static final short MADHYAMAM       = 0x0004;
     static final short SAAMANYADOSHAM  = 0x0008;
     static final short DOSHAM          = 0x0010;
     static final short ATIDOSHAM       = 0x0020;
     static final short ATYANTADOSHAM   = 0x0040;
     static final short ADHAMAM         = 0x0080;
     static final short ADHAMAADHAMAM   = 0x0100;
     static final short NISHIDHAM       = 0x0200;
     static final short NOPARIHAARAM    = 0x0400;
     static final short PARIHAARAM      = 0x0800;

     static final short PORUTHAMS = 25;
     static final short P_PAAPAS = 0;
     static final short P_PAAPAS_SPOUSE = 1;
     static final short P_PAAPAPORUTHAM = 2;
     static final short P_RAASIPORUTHAM = 3;
     static final short P_RAASYADHIPAPORUTHAM = 4;
     static final short P_VASYAPORUTHAM = 5;
     static final short P_MAHENDRAPORUTHAM = 6;
     static final short P_GANAPORUTHAM = 7;
     static final short P_STREEDEERGHAPORUTHAM = 8;
     static final short P_YONIPORUTHAM = 9;
     static final short P_DINAPORUTHAM = 10;
     static final short P_RAJJUPORUTHAM = 11;
     static final short P_AAYAVYAYAPORUTHAM = 12;
     static final short P_VAYAPORUTHAM = 13;
     static final short P_VEDHAPORUTHAM = 14;
     static final short P_PANCHAVARGAVEDHAM = 15;
     static final short P_KANTAVEDHAM = 16;
     static final short P_KATIVEDHAM = 17;
     static final short P_PAADAVEDHAM = 18;
     static final short P_KUKSHIVEDHAM = 19;
     static final short P_SIROVEDHAM = 20;
     static final short P_DASASANDHI = 21;
     static final short P_GRAHAMAITRI = 22;
     static final short P_SPOUSE_GRAHAMAITRI = 23;

     //static final short
     static String[] mrigam = new String[MRIGAMS+1],
                     vriksham = new String[VRIKSHAMS+1],
                     ganam = new String[GANAMS+1],
                     yoni = new String[YONIS+1],
                     pakshi = new String[PAKSHIS+1],
                     bhootam = new String[BHOOTAS+1],
                     devata = new String[DEVATAAS+1],
                     dasa = new String[GRAHAS+1],
                     graham = new String[GRAHAS+1];
/*------------------------------------------------------------------*/
     private static class raasi {
       String name;
       short mukha;             /* Oordhwa, Adho, Tiryat        */
       short chalana;           /* Sthira, Chara, Ubhaya        */
       short yoni;              /* Purusha, Stree               */
       short bhoota;            /* Prithvi, Jala, Aakaasa       */
       short adhipa[];          /* Adhipa Graha(s)              */
       short uchagraha[];       /* Ucham sthana of .. Graha(s)  */
       short neechagraha[];     /* Neecha sthana of .. Graha(s) */
       short vasya[];           /* Vassya Raasi(s)              */
       public void raasi(String nm, short mka, short chln, short yni,
         short bht, short adh[], short uc[], short nc[], short vsy[]) {
         name = nm;  mukha = mka;  chalana = chln;
         yoni = yni; bhoota = bht;
         adhipa = new short[adh.length];
         System.arraycopy(adh,0,adhipa,0,adh.length);
         uchagraha = new short[uc.length];
         System.arraycopy(uc,0,uchagraha,0,uc.length);
         neechagraha = new short[nc.length];
         System.arraycopy(nc,0,neechagraha,0,nc.length);
         vasya = new short[vsy.length];
         System.arraycopy(vsy,0,vasya,0,vsy.length);
       }
     }
/*------------------------------------------------------------------*/
     static raasi[] rasi = new raasi[RAASIS];
/*------------------------------------------------------------------*/
     public static void initRaasis() {
       short rs, mka, chln, yni, bhoo;  String nm;
       for (int i=0; i < RAASIS; i++) {
          rasi[i] = new raasi();
       }
       {
         rs = MEENAM;         nm = "Meenam";
         mka = NONE;
         chln = UBHAYAM;
         yni = STREE;
         bhoo = AAKAASAM;
         short adh[] = { BRUHASPATI };
         short uch[] = { SUKRA };
         short nch[] = { BUDHA };
         short vsya[] = { MAKARAM };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = MEDAM;         nm = "Medam";
         mka = NONE;
         chln = CHARAM;
         yni = PURUSHA;
         bhoo = AGNI;
         short adh[] = { KUJA };
         short uch[] = { AADITYA };
         short nch[] = { SANI };
         short vsya[] = { CHINGAM, VRISCHIKAM };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = EDAVAM;         nm = "Edavam";
         mka = NONE;
         chln = STHIRAM;
         yni = STREE;
         bhoo = JALAM;
         short adh[] = { SUKRA };
         short uch[] = { SASI, RAAHU };
         short nch[] = { KETU };
         short vsya[] = { KARKKIDAKAM, TULAAM };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = MITHUNAM;         nm = "Mithunam";
         mka = NONE;
         chln = UBHAYAM;
         yni = PURUSHA;
         bhoo = BHOOMI;
         short adh[] = { BUDHA };
         short uch[] = { NONE };
         short nch[] = { NONE };
         short vsya[] = { KANNI };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = KARKKIDAKAM;         nm = "Karkkadakam";
         mka = NONE;
         chln = CHARAM;
         yni = STREE;
         bhoo = JALAM;
         short adh[] = { SASI };
         short uch[] = { BRUHASPATI };
         short nch[] = { KUJA };
         short vsya[] = { VRISCHIKAM, DHANU };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = CHINGAM;         nm = "Chingom";
         mka = NONE;
         chln = STHIRAM;
         yni = PURUSHA;
         bhoo = AGNI;
         short adh[] = { AADITYA };
         short uch[] = { NONE };
         short nch[] = { NONE };
         short vsya[] = { TULAAM };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = KANNI;         nm = "Kanya";
         mka = NONE;
         chln = UBHAYAM;
         yni = STREE;
         bhoo = BHOOMI;
         short adh[] = { BUDHA };
         short uch[] = { BUDHA };
         short nch[] = { SUKRA };
         short vsya[] = { MITHUNAM, MEENAM };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = TULAAM;         nm = "Tulaam";
         mka = NONE;
         chln = CHARAM;
         yni = PURUSHA;
         bhoo = JALAM;
         short adh[] = { SUKRA };
         short uch[] = { SANI };
         short nch[] = { AADITYA };
         short vsya[] = { MAKARAM, KANNI };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = VRISCHIKAM;         nm = "Vrischikam";
         mka = NONE;
         chln = STHIRAM;
         yni = STREE;
         bhoo = AGNI;
         short adh[] = { KUJA };
         short uch[] = { KETU };
         short nch[] = { SASI, RAAHU };
         short vsya[] = { KARKKIDAKAM };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = DHANU;         nm = "Dhanu";
         mka = NONE;
         chln = UBHAYAM;
         yni = PURUSHA;
         bhoo = AAKAASAM;
         short adh[] = { BRUHASPATI };
         short uch[] = { NONE };
         short nch[] = { NONE };
         short vsya[] = { MEENAM };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = MAKARAM;         nm = "Makaram";
         mka = NONE;
         chln = CHARAM;
         yni = STREE;
         bhoo = VAAYU;
         short adh[] = { SANI };
         short uch[] = { KUJA };
         short nch[] = { BRUHASPATI };
         short vsya[] = { MEDAM, KUMBHAM };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
       {
         rs = KUMBHAM;         nm = "Kumbham";
         mka = NONE;
         chln = STHIRAM;
         yni = PURUSHA;
         bhoo = VAAYU;
         short adh[] = { SANI };
         short uch[] = { NONE };
         short nch[] = { NONE };
         short vsya[] = { MEDAM };
         rasi[rs].raasi(nm, mka, chln, yni, bhoo, adh, uch, nch, vsya);
       }
     }
/*------------------------------------------------------------------*/
     private static class graha {
       short dasa;
       short[] bandhu;
       short[] satru;
       short[] sama;
       short[] ucham;
       short[] neecham;
       short[] swakshetra;
       short[] poruthabandhu;
       String symbol;
       String name;
       public void graha(short ds, short bd[], short su[],
         short sa[], short uc[], short nc[], short sw[],
         short pb[], String sy, String nm) {
         dasa = ds;
         bandhu = new short[bd.length];
         System.arraycopy(bd,0,bandhu,0,bd.length);
         satru = new short[su.length];
         System.arraycopy(su,0,satru,0,su.length);
         sama = new short[sa.length];
         System.arraycopy(sa,0,sama,0,sa.length);
         ucham = new short[uc.length];
         System.arraycopy(uc,0,ucham,0,uc.length);
         neecham = new short[nc.length];
         System.arraycopy(nc,0,neecham,0,nc.length);
         swakshetra = new short[sw.length];
         System.arraycopy(sw,0,swakshetra,0,sw.length);
         poruthabandhu = new short[pb.length];
         System.arraycopy(pb,0,poruthabandhu,0,pb.length);
         symbol = sy; name = nm;
       }
     }
/*------------------------------------------------------------------*/
     static graha[] grah = new graha[GRAHAS+1];
/*------------------------------------------------------------------*/
     public static void initGrahas() {
       short gh, das; String sy; String nm;
       for (int i=0; i <= GRAHAS; i++) {
          grah[i] = new graha();
       }
       {
         gh = LAGNA; das = 0; sy = "L"; nm = "Lagna";
         short bnd[] = { 0 };      short satr[] = { 0 };
         short smn[] = { 0 };      short uch[] = { 0 };
         short nch[] = { 0 };      short swks[] = { 0 };
         short pbnd[] = { 0 };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = AADITYA; das = AADITYA_DASA; sy = "A"; nm = "Aaditya";
         short bnd[] = { CHANDRA, KUJA, BRUHASPATI };
         short satr[] = { SUKRA, SANI };
         short smn[] = { BUDHA };
         short uch[] = { MEDAM };
         short swks[] = { CHINGAM };
         short nch[] = { TULAAM };
         short pbnd[] = { AADITYA, BUDHA, BRUHASPATI };
         grah[gh].graha(das,bnd,satr,smn,uch,nch,swks,pbnd,sy,nm);
       }
       {
         gh = SASI; das = SASI_DASA; sy = "C"; nm = "Chandra";
         short bnd[] = { AADITYA, BUDHA };
         short satr[] = { NONE };
         short smn[] = { KUJA, BRUHASPATI, SUKRA, SANI };
         short uch[] = { EDAVAM };
         short swks[] = { KARKKIDAKAM };
         short nch[] = { VRISCHIKAM };
         short pbnd[] = { SASI, BUDHA, BRUHASPATI };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = KUJA; das = KUJA_DASA; sy = "M"; nm = "Kuja";
         short bnd[] = { SASI, AADITYA, BRUHASPATI };
         short satr[] = { BUDHA };
         short smn[] = { SUKRA, SANI };
         short uch[] = { MAKARAM };
         short swks[] = { MEDAM, VRISCHIKAM };
         short nch[] = { KARKKIDAKAM };
         short pbnd[] = { BUDHA, SUKRA };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = RAAHU; das = RAAHU_DASA; sy = "R"; nm = "Raahu";
         short bnd[] = { NONE };
         short satr[] = { NONE };
         short smn[] = { NONE };
         short uch[] = { EDAVAM, VRISCHIKAM };
         short swks[] = { NONE };
         short nch[] = { NONE };
         short pbnd[] = { RAAHU };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = BRUHASPATI; das = BRUHASPATI_DASA; sy = "J"; nm = "Guru";
         short bnd[] = { AADITYA, SASI, KUJA };
         short satr[] = { BUDHA, SUKRA };
         short smn[] = { SANI };
         short uch[] = { KARKKIDAKAM };
         short swks[] = { MEENAM, DHANU };
         short nch[] = { MAKARAM };
         short pbnd[] = { BRUHASPATI, AADITYA, SASI, BUDHA, SUKRA, SANI };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = SANI; das = SANI_DASA; sy = "S"; nm = "Sani";
         short bnd[] = { SUKRA, BUDHA };
         short satr[] = { AADITYA, SASI, KUJA };
         short smn[] = { BRUHASPATI };
         short uch[] = { TULAAM };
         short swks[] = { MAKARAM, KUMBHAM };
         short nch[] = { MEDAM };
         short pbnd[] = { SANI, BUDHA, BRUHASPATI, SUKRA };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = BUDHA; das = BUDHA_DASA; sy = "B"; nm = "Budha";
         short bnd[] = { AADITYA, SUKRA };
         short satr[] = { SASI };
         short smn[] = { KUJA, BRUHASPATI, SANI };
         short uch[] = { KANNI };
         short swks[] = { MITHUNAM, KANNI };
         short nch[] = { MEENAM };
         short pbnd[] = { BUDHA, SASI, SUKRA, KUJA, BRUHASPATI, SANI };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = KETU; das = KETU_DASA; sy = "K"; nm = "Ketu";
         short bnd[] = { NONE };
         short satr[] = { NONE };
         short smn[] = { NONE };
         short uch[] = { EDAVAM, VRISCHIKAM };
         short swks[] = { NONE };
         short nch[] = { NONE };
         short pbnd[] = { KETU };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = SUKRA; das = SUKRA_DASA; sy = "V"; nm = "Sukra";
         short bnd[] = { BUDHA, SANI };
         short satr[] = { AADITYA, SASI };
         short smn[] = { KUJA, BRUHASPATI };
         short uch[] = { MEENAM };
         short swks[] = { EDAVAM, TULAAM };
         short nch[] = { KANNI };
         short pbnd[] = { SUKRA, KUJA, BUDHA, BRUHASPATI, SANI };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = URANUS; das = 0; sy = "U"; nm = "Uranus";
         short bnd[] = { 0 };      short satr[] = { 0 };
         short smn[] = { 0 };      short uch[] = { 0 };
         short nch[] = { 0 };      short swks[] = { -1 };
         short pbnd[] = { 0 };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = NEPTUNE; das = 0; sy = "N"; nm = "Neptune";
         short bnd[] = { 0 };      short satr[] = { 0 };
         short smn[] = { 0 };      short uch[] = { 0 };
         short nch[] = { 0 };      short swks[] = { -1 };
         short pbnd[] = { 0 };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = PLUTO; das = 0; sy = "P"; nm = "Pluto";
         short bnd[] = { 0 };      short satr[] = { 0 };
         short smn[] = { 0 };      short uch[] = { 0 };
         short nch[] = { 0 };      short swks[] = { -1 };
         short pbnd[] = { 0 };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
       {
         gh = MAANDI; das = 0; sy = "I"; nm = "Maandi";
         short bnd[] = { 0 };      short satr[] = { 0 };
         short smn[] = { 0 };      short uch[] = { 0 };
         short nch[] = { 0 };      short swks[] = { -1 };
         short pbnd[] = { 0 };
         grah[gh].graha(das, bnd, satr, smn, uch, nch, swks, pbnd, sy, nm);
       }
     }
/*------------------------------------------------------------------*/
     private static void init_grahas() {
       for (int i=0; i <= GRAHAS; i++) {
         graham[i] = (i==AADITYA)         ? "Aaditya"        :
                     (i==SASI)            ? "Chandra"        :
                     (i==KUJA)            ? "Kuja"           :
                     (i==RAAHU)           ? "Raahu"          :
                     (i==BRUHASPATI)      ? "Bruhaspati"     :
                     (i==SANI)            ? "Sani"           :
                     (i==BUDHA)           ? "Budha"          :
                     (i==KETU)            ? "Ketu"           :
                     (i==SUKRA)           ? "Sukra"          :
                     (i==MAANDI)          ? "Maandi"         :
                     (i==LAGNA)           ? "Lagna"          : "*";
       }
     }
/*------------------------------------------------------------------*/
     private static class nakshatra {
       String name;
       short mrigam;
       short vriksham;
       short ganam;
       short yoni;
       short pakshi;
       short bhootam;
       short devata;
       short rajju;
       short vedha[] = {NONE, NONE};
       short aadidasa;
       public void nakshatra(String nm, short mg, short vk,
         short gn, short yn, short pk, short bh, short dv, short rj,
         short vd0, short vd1, short ds) {
         name = nm; mrigam = mg; vriksham = vk;
         ganam = gn; yoni = yn; pakshi = pk;
         bhootam = bh; devata = dv; rajju = rj;
         vedha[0] = vd0; vedha[1] = vd1;
         aadidasa = ds;
       }
     }
/*------------------------------------------------------------------*/
     static nakshatra[] naksha = new nakshatra[NAKSHATRAS+1];
/*------------------------------------------------------------------*/
     public static void initNakshatras() {
       for (int i=0; i <= NAKSHATRAS; i++) {
         naksha[i] = new nakshatra();
       }
     naksha[0].nakshatra("Nakshatra", (short)0, (short)0, (short)0,
       (short)0, (short)0, (short)0, (short)0,
       (short)0, (short)0,(short)0, (short)0 );  /* Dummy */
     naksha[ASWATHI].nakshatra("Aswathi",KUTHIRA,KAANJIRAM,DEVAM,
       PURUSHA,PULLU,BHOOMI,ASWINIS,AADI, TRIKKETA,NONE, KETU);
     naksha[BHARANI].nakshatra("Bharani",AANA,NELLI,MAANUSHAM,
       PURUSHA,PULLU,BHOOMI,YAMAN,MADHYA, ANIZHAM,NONE ,SUKRA);
     naksha[KARTHIKA].nakshatra("Kaarthika",AADU,ATHI,AASURAM,
       STREE,PULLU,BHOOMI,AGNI_D,ANTYA, VISAKHAM,NONE ,AADITYA);
     naksha[ROHINI].nakshatra("Rohini",PAAMBU,NJAAVAL,MAANUSHAM,
       STREE,PULLU,BHOOMI,BRAHMA,ANTYA, CHOTI,NONE ,SASI);
     naksha[MAKEERYAM].nakshatra("Makeeryam",PAAMBU,KARINGALI,
       DEVAM,STREE,PULLU,BHOOMI,CHANDRA,MADHYA, CHITRA,AVITTOM ,KUJA);
     naksha[THIRUVATHIRA].nakshatra("Thiruvaathira",NAAYA,KARIMARAM,
       MAANUSHAM,STREE,CHAKORAM,JALAM,SHIVA,AADI, THIRUVONAM,NONE ,RAAHU);
     naksha[PUNARTHAM].nakshatra("Punartham",POOCHA,MULA,DEVAM,
       STREE,CHAKORAM,JALAM,ADITI,AADI, UTHRADAM,NONE , BRUHASPATI);
     naksha[POOYAM].nakshatra("Pooyam",AADU,ARAYAAL,DEVAM,
       PURUSHA,CHAKORAM,JALAM,BRUHASPATI_D,MADHYA, POORADAM,NONE ,SANI);
     naksha[AYILYAM].nakshatra("Aayilyam",KARIMPOOCHA,NAAKAM,AASURAM,
       PURUSHA,CHAKORAM,JALAM,SARPPAAS,ANTYA, MOOLAM,NONE ,BUDHA);
     naksha[MAKAM].nakshatra("Makam",ELI,PERAAL,AASURAM,
       PURUSHA,CHAKORAM,JALAM,PITRUKKAL,ANTYA, REVATHI,NONE ,KETU);
     naksha[POORAM].nakshatra("Pooram",CHUNDELI,PLAASU,MAANUSHAM,
       STREE,CHAKORAM,JALAM,AARYAMAAVU,MADHYA, UTHRATTATHI,NONE ,SUKRA);
     naksha[UTHRAM].nakshatra("Uthram",OTTAKAM,ITHI,MAANUSHAM,
       PURUSHA,KAAKKA,AGNI,BHAGAN,AADI, POORORUTTATHI,NONE ,AADITYA);
     naksha[ATHAM].nakshatra("Atham",POTHU,AMBAZHAM,DEVAM,
       STREE,KAAKKA,AGNI,AADITYA_D,AADI, CHATAYAM,NONE ,SASI);
     naksha[CHITRA].nakshatra("Chitra",AALPULI,KOOVALAM,AASURAM,
       STREE,KAAKKA,AGNI,TWASHTAAVU,MADHYA, MAKEERYAM,AVITTOM ,KUJA);
     naksha[CHOTI].nakshatra("Choti",MAHISHAM,NEERMARUTU,DEVAM,
       PURUSHA,KAAKKA,AGNI,VAAYU_D,ANTYA, ROHINI,NONE ,RAAHU);
     naksha[VISAKHAM].nakshatra("Visakham",SIMHAM,VAYYANKATAVU,AASURAM,
       PURUSHA,KAAKKA,AGNI,INDRAAGNI,ANTYA, KARTHIKA,NONE ,BRUHASPATI);
     naksha[ANIZHAM].nakshatra("Anizham",MAAN,ILANJI,DEVAM,
       STREE,KAAKKA,VAAYU,MAITRAAN,MADHYA, BHARANI,NONE, SANI);
     naksha[TRIKKETA].nakshatra("Triketta",KEZHA,VETTI,AASURAM,
       PURUSHA,KOZHI,VAAYU,INDRA,AADI, ASWATHI,NONE ,BUDHA);
     naksha[MOOLAM].nakshatra("Moolam",SWAAVU,PAYINA,AASURAM,
       PURUSHA,KOZHI,VAAYU,NIRURTI,AADI, AYILYAM,NONE ,KETU);
     naksha[POORADAM].nakshatra("Pooradam",KAPI,VANNI,MAANUSHAM,
       PURUSHA,KOZHI,VAAYU,JALAM_D,MADHYA, UTHRATTATHI,NONE ,SUKRA);
     naksha[UTHRADAM].nakshatra("Uthradam",KAALA,PILAAVU,MAANUSHAM,
       PURUSHA,KOZHI,VAAYU,VISWADEVAS,ANTYA, PUNARTHAM,NONE ,AADITYA);
     naksha[THIRUVONAM].nakshatra("Thiruvonam",VAANARAM,ERUKKU,DEVAM,
       PURUSHA,KOZHI,VAAYU,VISHNU,ANTYA, THIRUVATHIRA,NONE ,SASI);
     naksha[AVITTOM].nakshatra("Avittom",NALLAL,VANNI,AASURAM,
       STREE,MAYIL,AAKAASAM,VASUKKAL,MADHYA, MAKEERYAM,CHITRA ,KUJA);
     naksha[CHATAYAM].nakshatra("Chatayam",KUTHIRA,KADAMBU,AASURAM,
       STREE,MAYIL,AAKAASAM,VARUNAN,AADI, ATHAM,NONE ,RAAHU);
     naksha[POORORUTTATHI].nakshatra("Poororuttathi",NARAN,TENMAAVU,MAANUSHAM,
       PURUSHA,MAYIL,AAKAASAM,AJAIKAPAAT,AADI, UTHRAM,NONE ,BRUHASPATI);
     naksha[UTHRATTATHI].nakshatra("Uthrattathi",PASU,KARIMPANA,MAANUSHAM,
       STREE,MAYIL,AAKAASAM,AHIRBUDHNI,MADHYA, POORAM,NONE ,SANI);
     naksha[REVATHI].nakshatra("Revathi",AANA,IRIPPA,DEVAM,
       STREE,MAYIL,AAKAASAM,POOSHAAV,ANTYA, MAKAM,NONE ,BUDHA);
     }
/*------------------------------------------------------------------*/
     private static void init_dasas() {
       for (int i=0; i <= GRAHAS; i++) {
         dasa[i] = (i==AADITYA)         ? "Aaditya dasa"        :
                   (i==SASI)            ? "Sasi dasa"           :
                   (i==KUJA)            ? "Kuja dasa"           :
                   (i==RAAHU)           ? "Raahu dasa"          :
                   (i==BRUHASPATI)      ? "Bruhaspati dasa"     :
                   (i==SANI)            ? "Sani dasa"           :
                   (i==BUDHA)           ? "Budha dasa"          :
                   (i==KETU)            ? "Ketu dasa"           :
                   (i==SUKRA)           ? "Sukra dasa"          : "*";
       }
     }
/*------------------------------------------------------------------*/
     private static void init_devataas() {
       for (int i=0; i <= DEVATAAS; i++) {
         devata[i] = (i==ASWINIS)       ? "Aswinis"     :
                     (i==YAMAN)         ? "Yaman"       :
                     (i==AGNI_D)        ? "Agni"        :
                     (i==BRAHMA)        ? "Brahma"      :
                     (i==CHANDRA)       ? "Chandra"     :
                     (i==SHIVA)         ? "Shiva"       :
                     (i==ADITI)         ? "Aditi"       :
                     (i==BRUHASPATI_D)  ? "Bruhaspati"  :
                     (i==SARPPAAS)      ? "Sarppaas"    :
                     (i==PITRUKKAL)     ? "Pitrukkal"   :
                     (i==AARYAMAAVU)    ? "Aaryamaavu"  :
                     (i==BHAGAN)        ? "Bhagan"      :
                     (i==AADITYA_D)     ? "Aaditya"     :
                     (i==TWASHTAAVU)    ? "Twashtaavu"  :
                     (i==VAAYU_D)       ? "Vaayu"       :
                     (i==INDRAAGNI)     ? "Indraagni"   :
                     (i==MAITRAAN)      ? "Maitraan"    :
                     (i==INDRA)         ? "Indra"       :
                     (i==NIRURTI)       ? "Nirruti"     :
                     (i==JALAM_D)       ? "Jalam"       :
                     (i==VISWADEVAS)    ? "Viswadevas"  :
                     (i==VISHNU)        ? "Vishnu"      :
                     (i==VASUKKAL)      ? "Vasukkal"    :
                     (i==VARUNAN)       ? "Varunan"     :
                     (i==AJAIKAPAAT)    ? "Ajaikapaat"  :
                     (i==AHIRBUDHNI)    ? "Ahirbudhni"  :
                     (i==POOSHAAV)      ? "Pooshaav"    : "*";
       }
     }
/*------------------------------------------------------------------*/
     private static void init_bhootas() {
       for (int i=0; i <= BHOOTAS; i++) {
         bhootam[i] = (i==BHOOMI)       ? "Bhoomi"      :
                      (i==JALAM)        ? "Jalam"       :
                      (i==AGNI)         ? "Agni"        :
                      (i==VAAYU)        ? "Vaayu"       :
                      (i==AAKAASAM)     ? "Aakaasam"    : "*";
       }
     }
/*------------------------------------------------------------------*/
     private static void init_pakshis() {
       for (int i=0; i <= PAKSHIS; i++) {
         pakshi[i] = (i==PULLU)         ? "Pullu"       :
                     (i==CHAKORAM)      ? "Chakoram"    :
                     (i==KAAKKA)        ? "Kaakka"      :
                     (i==KOZHI)         ? "Kozhi"       :
                     (i==MAYIL)         ? "Mayil"       : "*";
       }
     }
/*------------------------------------------------------------------*/
     private static void init_yonis() {
       for (int i=0; i <= YONIS; i++) {
         yoni[i] = (i==PURUSHA) ? "Purusha"     :
                   (i==STREE)   ? "Stree"       : "*";
       }
     }
/*------------------------------------------------------------------*/
     private static void init_ganams() {
       for (int i=0; i <= GANAMS; i++) {
         ganam[i] = (i==DEVAM)          ? "Devam"       :
                    (i==MAANUSHAM)      ? "Maanusham"   :
                    (i==AASURAM)        ? "Aasuram"     : "*";
       }
     }
/*------------------------------------------------------------------*/
     private static void init_vrikshams() {
       for (int i=0; i <= VRIKSHAMS; i++) {
         vriksham[i] = (i==KAANJIRAM)   ? "Kaanjiram"   :
                       (i==NELLI)       ? "Nelli"       :
                       (i==ATHI)        ? "Athi"        :
                       (i==NJAAVAL)     ? "Njaaval"     :
                       (i==KARINGALI)   ? "Karingali"   :
                       (i==KARIMARAM)   ? "Karimaram"   :
                       (i==MULA)        ? "Mula"        :
                       (i==ARAYAAL)     ? "Arayaal"     :
                       (i==NAAKAM)      ? "Naakam"      :
                       (i==PERAAL)      ? "Peraal"      :
                       (i==PLAASU)      ? "Plaasu"      :
                       (i==ITHI)        ? "Ithi"        :
                       (i==AMBAZHAM)    ? "Ambazham"    :
                       (i==KOOVALAM)    ? "Koovalam"    :
                       (i==NEERMARUTU)  ? "Neermarutu"  :
                       (i==VAYYANKATAVU)? "Vayyankatavu":
                       (i==ILANJI)      ? "Ilanji"      :
                       (i==VETTI)       ? "Vetti"       :
                       (i==PAYINA)      ? "Payina"      :
                       (i==VANJI)       ? "Vanji"       :
                       (i==PILAAVU)     ? "Pilaavu"     :
                       (i==ERUKKU)      ? "Erukku"      :
                       (i==VANNI)       ? "Vanni"       :
                       (i==KADAMBU)     ? "Kadambu"     :
                       (i==TENMAAVU)    ? "Tenmaavu"    :
                       (i==KARIMPANA)   ? "Karimpana"   :
                       (i==IRIPPA)      ? "Irippa"      : "*";
       }
     }
/*------------------------------------------------------------------*/
     private static void init_mrigams() {
       for (int i=0; i <= MRIGAMS; i++) {
         mrigam[i] = (i==KUTHIRA)       ? "Kuthira"     :
                     (i==AANA)          ? "Aana"        :
                     (i==AADU)          ? "Aadu"        :
                     (i==PAAMBU)        ? "Paambu"      :
                     (i==NAAYA)         ? "Naaya"       :
                     (i==POOCHA)        ? "Poocha"      :
                     (i==KARIMPOOCHA)   ? "Karimpoocha" :
                     (i==ELI)           ? "Eli"         :
                     (i==CHUNDELI)      ? "Chundeli"    :
                     (i==OTTAKAM)       ? "Ottakam"     :
                     (i==POTHU)         ? "Pothu"       :
                     (i==AALPULI)       ? "Aalpuli"     :
                     (i==MAHISHAM)      ? "Mahisham"    :
                     (i==SIMHAM)        ? "Simham"      :
                     (i==MAAN)          ? "Maan"        :
                     (i==KEZHA)         ? "Kezha"       :
                     (i==SWAAVU)        ? "Swaavu"      :
                     (i==KAPI)          ? "Kapi"        :
                     (i==KAALA)         ? "Kaala"       :
                     (i==VAANARAM)      ? "Vaanaram"    :
                     (i==NALLAL)        ? "Nallal"      :
                     (i==NARAN)         ? "Naran"       :
                     (i==PASU)          ? "Pasu"        : "*";
          //mrigam[i] = str;
          //System.out.println(i + " [" + mrigam[i] + "] "+str);
       }
     }
/*------------------------------------------------------------------*/
     private String MKSTR_U(String str) {
       return (str+"</TD><TD></TD><TD></TD><TD>");
     }
/*------------------------------------------------------------------*/
     private String MKSTR_M(String str) {
       return ("</TD><TD>"+str+"</TD><TD></TD><TD>");
     }
/*------------------------------------------------------------------*/
     private String MKSTR_A(String str) {
       return ("</TD><TD></TD><TD>"+str+"</TD><TD>");
     }
/*------------------------------------------------------------------*/
     public String getMatchStr(int value) {
       String matchstr = "";
       int i, ch;
       boolean defa = false;
       for (i = 0; i < 16; i++) {
         if ( ((value << i) & 0x8000) > 0) {
           defa = false;
           ch = (value & (0x0001 << (15 - i)));
           switch (ch) {
             default :  defa = true;   break;
             case ATIUTHAMAM : matchstr = MKSTR_U("Ati Uthamam");  break;
             case UTHAMAM    : matchstr = MKSTR_U("Uthamam"); break;
             case MADHYAMAM  : matchstr = MKSTR_M("Madhyamam"); break;
             case SAAMANYADOSHAM :
                      matchstr = MKSTR_M("Saamaanya Dosham"); break;
             case DOSHAM     : matchstr = MKSTR_A("Dosham"); break;
             case ATIDOSHAM  : matchstr = MKSTR_A("Ati Dosham"); break;
             case ATYANTADOSHAM : matchstr = MKSTR_A("Atyanta Dosham"); break;
             case ADHAMAM    : matchstr = MKSTR_A("Adhamam"); break;
             case ADHAMAADHAMAM : matchstr = MKSTR_A("Adhamaadhamam"); break;
             case NISHIDHAM  : matchstr = MKSTR_A("Nishidham"); break;
             case NOPARIHAARAM : matchstr = MKSTR_A("No Parihaaram"); break;
             //case NODOSHAM   : matchstr = MKSTR_U("No Dosham"); break;
           }
           /*
           matchstr = ( ch==M.ATIUTHAMAM   ? MKSTR_U("Ati Uthamam") :
             ch==M.UTHAMAM    ? MKSTR_U("Uthamam") :
             ch==M.MADHYAMAM  ? MKSTR_M("Madhyamam") :
             ch==M.SAAMANYADOSHAM ? MKSTR_M("Saamaanya Dosham") :
             ch==M.DOSHAM     ? MKSTR_A("Dosham"); break;
             ch==M.ATIDOSHAM  ? MKSTR_A("Ati Dosham") :
             ch==M.ATYANTADOSHAM ? MKSTR_A("Atyanta Dosham") :
             ch==M.ADHAMAM    ? MKSTR_A("Adhamam") :
             ch==M.ADHAMAADHAMAM ? MKSTR_A("Adhamaadhamam") :
             ch==M.NISHIDHAM  ? MKSTR_A("Nishidham") :
             ch==NOPARIHAARAM ? MKSTR_A("No Parihaaram") :
             / /ch==NODOSHAM   ? MKSTR_U("No Dosham") :
             default :  defa = true;   break;
           }
           */
           if (!defa) break;
         }
       }
       if ((value & PARIHAARAM)> 0)  {
         if (!((value & (ATIUTHAMAM | UTHAMAM)) > 0))
           matchstr +=  " Parihaaramundu";
       }
       return (matchstr);
     }
/*------------------------------------------------------------------*/
     static boolean initialized = false;
     static String htmlStyle;
/*------------------------------------------------------------------*/
     private void initialize (String font1, String font2) {
         htmlStyle = "<STYLE><!-- BODY {margin-left:1.00in;" +
           // "background:#FFFFFF;color:#FFFFCC;" +
           "}" +
           "H2{text-align:left;} A{color:#FF0000; font:" + font1 + "}" +
           "H4{text-align:center;color:#FF0000; font:" + font2 + "}" +
           "--> </STYLE>";
         initNakshatras();
         initGrahas();
         initRaasis();
         init_mrigams();
         init_vrikshams();
         init_ganams();
         init_yonis();
         init_pakshis();
         init_bhootas();
         init_devataas();
         init_dasas();
         init_grahas();
     }
/*------------------------------------------------------------------*/

     snVarsM () {

       if (!initialized) initialize("13pt verdana", "14pt times");
     }
/*---------------------------------------------------------------*/
    static final String sWITH = " with ";
    static final String sPOR_VALUE = " Porutha Value = ";
    static final String sHOROSCOPE_COMPATIBILITY = "\n\n                Horoscope Compatibility ";
    static final String sNAME = "Name           : ";
    static final String sAGE = "Age  : ";
    static final String sSEX = "Sex  : ";
    static final String sNAKSHATRA = "Nakshatra :";
    static final String sDOB = "Date of Birth  : ";
    static final String sHINDU = " (Hindu:-";
    static final String sTOB = "Time of Birth  : ";
    static final String sIST = " IST";
    static final String sGMT = " GMT";
    static final String sPOB = "Place of Birth : ";
    static final String sLATI = "Latitude       : ";
    static final String sLNGT = "Longitude      : ";
    static final String sSISTA = "Sishta Dasa : ";
    static final String sCOMPATIBILITY = " Compatibility :-";
    static final String sTOT_PORUTH = " Total Porutha Value :- ";
    static final String sPAAP_VAL = "1. Paapa Value";
    //static final String sNO_OF_PAAPAS = "1. No.of Paapas";
    static final String sPAAPA_SAAMYA = " - Paapa Saamyam";
    static final String sRAASI_POR = "2. Raasi Porutham";
    static final String sRAASYADHIPA = "3. Raasyadhipam";
    static final String sVASYA_POR = "4. Vasya Porutham";
    static final String sMAHEN_POR = "5. Mahendra Porutham";
    static final String sGANA_POR = "6. Gana Porutham";
    static final String sSTRDEER = "7. Stree Deergham";
    static final String sYONI_POR = "8. Yoni Porutham";
    static final String sDINA_POR = "9. Dina Porutham";
    static final String sRAJJU_POR = "10. Rajju Porutham";
    static final String sAAYA_POR = "11. Aaya .. Vyayam";
    static final String sVAYA_POR = "12. Vaya Porutham";
    static final String sVED_POR = "13. Vedha Porutham";
    static final String sPANCHVED_POR = "14. Panchavarga Vedham";
    static final String sKANTA_VED = "-(i) Kanta Vedham";
    static final String sKATI_VED = "-(ii) Kati Vedham";
    static final String sPAADA_VED = "-(iii) Paada Vedham";
    static final String sKUKSHI_VED = "-(iv) Kukshi Vedham";
    static final String sSIRO_VED = "-(v) Siro Vedham";
    static final String sPAADA_88 = "15. Paada Dosha-88th";
    static final String sDOSHAM = "Dosham";
    static final String sNA = "Not Applicable";
    static final String sPAADA_108 = "16. Paada Dosha-108th";
    static final String s6_8_DOSHAM = "17. ShashtaAshtamam";
    static final String s8_6_DOSHAM = "18. AshtamaShashtamam";
    static final String sGRAH_MAITRI_P = "19. Graha Maitri (Purusha)";
    static final String sGRAH_MAITRI_S = "20. Graha Maitri (Stree)";
    static final String sCOUNT_OF_PAAPS =
       "    Count of Paapans for Horoscope Compatibility  (for houses :-";
    static final String sGRAHA = "Graha  ";
    static final String sTOTAL = "<-- Total -->";
    static final String sGRAND_TOT = "<- Grand-Total ->";
    static final String sSTREE = "Stree : - ";
    static final String sGRAHA_AL = "al";
    static final String sPURUSHA = "Purusha : - ";
    static final String sDASASANDHI = "Dasa Sandhi :- ";
    static final String sDEVATA = "Devata :";
    static final String sBHOOTAM = "Bhootam :";
    static final String sPAKSHI = "Pakshi :";
    static final String sYONI = "Yoni :";
    static final String sMRIGAM = "Mrigam :";
    static final String sVRIKSHAM = "Vriksham :";
    static final String sGANAM = "Ganam :";
    static final String sMORE_DETLS = "More Details :- ";
/*---------------------------------------------------------------*/
}
/*---------------------------------------------------------------*/
