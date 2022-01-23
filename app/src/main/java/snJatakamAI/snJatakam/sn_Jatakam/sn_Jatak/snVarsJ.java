
/*---------------------------------------------------------------*/
//package snJatakam;
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak;

/*---------------------------------------------------------------*/
//import java.io.*;
//import java.util.*;
/*---------------------------------------------------------------*/

 /*---------------------------------------------------
        Suresh's Horoscope Variables
-----------------------------------------------------*/
public class snVarsJ {

  public static final String drvName = "C:"; // Default Drive
  //static final double PI = 3.14159265359d;
  public static final double PI = 3.1415926535897932384626433832795d;
  public static final String day[] = {"Sunday", "Monday", "Tuesday", "Wednesday",
    "Thursday", "Friday", "Saturday"};
  public static final String mth[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
  public static final String ras[] = {"Mesha   ", "Vrisha  ", "Mithuna ",
    "Karkata ", "Simha   ", "Kanya   ", "Tula    ", "Vriscika",
    "Dhanus  ", "Makara  ", "Kumbha  ", "Meena   "};
  public static final String tit[] = {"Pratipad", "Dvitiya", "Tritiya",
    "Chaturthi", "Panchami", "Sashti", "Saptami", "Ashtami", "Navami",
    "Dasami", "Ekadasi", "Dvadasi", "Trayodasi", "Chaturdasi",
    "Purnima", "Pratipad", "Dvitiya", "Tritiya", "Chaturthi",
    "Panchami", "Sashti", "Saptami", "Ashtami", "Navami", "Dasami",
    "Ekadasi", "Dvadasi", "Trayodasi", "Chaturdasi", "Amavasya"};
  /*
 public static final String nak[] = {"Asvini     ", "Bharani    ", "Krittika   ",
         "Rohini     ", "Mrigasiras ", "Ardra      ", "Punarvasu  ",
         "Pushya     ", "Aslesha    ", "Magha      ", "Purvaphal  ",
         "Uttaraphal ", "Hasta      ", "Chitra     ", "Svati      ",
         "Visakha    ", "Anuradha   ", "Jyestha    ", "Moola      ",
         "Purvasada  ", "Uttarasada ", "Sravana    ", "Dhanistha  ",
         "Satabhisaj ", "Purvabadra ", "Uttarabadra", "Revati     " };
   */
  public static final String nak[] = {"Aswati     ", "Bharani    ", "Kaartika   ",
    "Rohini     ", "Makayiryam ", "Tiruvatira ", "Punartam   ",
    "Pooyam     ", "Aayilyam   ", "Makam      ", "Pooram     ",
    "Uttram     ", "Attam      ", "Chitra     ", "Choti      ",
    "Visakham   ", "Anizham    ", "Trikketta  ", "Moolam     ",
    "Pooraadam  ", "Utraadam   ", "Tiruvonam  ", "Avittom    ",
    "Chatayam   ", "Puroruttati", "Uttrattati ", "Revati     "};
  public static final String yog[] = {"Viskumbha", "Priti", "Ayusman", "Saubhagya",
    "Sobhana", "Atiganda", "Sukarma", "Dhriti", "Sula", "Ganda",
    "Vriddhi", "Dhruva", "Vyaghata", "Harshana", "Vajra", "Siddhi",
    "Vyatipata", "Variyan", "Parigha", "Siva", "Siddha", "Sadhya",
    "Subha", "Sukla", "Brahma", "Indra", "Vaidhriti"};
  public static final String dL[] = {"Ketu    ", "Sukra   ", "Soorya  ",
    "Chandra ", "Kuja    ", "Rahu    ", "Guru    ", "Sani    ",
    "Budha   "};
  public static final double dY[] = {7, 20, 6, 10, 7, 18, 16, 19, 17};
  public static final String graha[] = {"Lagn", "Ravi", "Budh", "Sukr", "Kuja",
    "Guru", "Sani", "Chan", "Rahu", "Ketu", "Uran", "Nept",
    "Plut", "Maan"};
  public static final String grahalong[] = {"Lagna  ", "Soorya ", "Budha  ",
    "Sukra  ", "Kuja   ", "Guru   ", "Sani   ", "Chandra",
    "Rahu   ", "Ketu   ", "Uranus ", "Neptune", "Pluto  ", "Maandi "};
  public static final String vrg[] = {"   Rasi   ", " Drekkana ", " Saptaamsa",
    " Navaamsa  ", " Dasaamsa ", "Dwadasaamsa", "Shodasaamsa",
    " 30 amsa  ", " 60 amsa  ", "Kundaamsa "};
  public static final String ganam[] = {"Deva", "Maanusha", "Aasura"};
  public static final int gnmId[] = {0, 1, 2, 1, 0, 1, 0, 0, 2, 2, 1, 1, 0,
    2, 0, 2, 0, 2, 2, 1, 1, 0, 2, 2, 1, 1, 0};
  public static final String devata[] = {"Aswinis", "Yama", "Agni", "Brahma",
    "Chandra", "Shiva", "Aditi", "Brhaspati", "Sarpas", "Pitrkkal",
    "Aaryamaav", "Bhagan", "Aaditya", "Twashtav", "Vaayu",
    "Indragni", "Maitran", "Indra", "Nir-rti", "Jalam", "Viswadevas",
    "Vishnu", "Vasus", "Varuna", "Ajaykapaat", "Ahirbudhni",
    "Pooshav"};
  public static final String vriksha[] = {"Kaanjiram", "Nelli", "Atthi", "Njaval",
    "Karingali", "Karimaram", "Bamboo", "Arayaal", "Naakam",
    "Peraal", "Plaasu", "Itthi", "Ambazham", "Koovalam",
    "Nirmarutu", "Vayyankatavu", "Ilanji", "Vetti", "Payina",
    "Vanji", "Pilaavu", "Erukku", "Vanni", "Kadambu",
    "Tenmaavu", "Karimbana", "Irippa"};
  public static final String yoni[] = {"Stree", "Purusha"};
  public static final int yonId[] = {1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0,
    0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0};
  public static final String bhootam[] = {"Bhoomi", "Jalam", "Agni",
    "Vayu", "Aakasam"};
  public static final String mrigam[] = {"Kutira", "Aana", "Aadu",
    "Paambu", "Paambu", "Naaya", "Poocha", "Aadu", "Karimpoocha",
    "Eli", "Chundeli", "Ottakam", "Pothu", "Aalpuli", "Mahisham",
    "Simham", "Maan", "Kezha", "Swaavu", "Kapi", "Kaala",
    "Vaanaram", "Nallal", "Kutira", "Naran", "Pasu", "Aana"};
  public static final String pakshi[] = {"Pullu", "Chakoram", "Kaakka",
    "Kozhi", "Mayil"};
  public static final String paksham[] = {"Krishna", "Shukla ", "       "};
  public static final String karanam[] = {"Pullu    ", "Naalkkali", "Paambu   ",
    "Puzhu    ", "Simham   ", "Vyaghram ", "Varaaham ",
    "Kazhuta  ", "Aana     ", "Surabhi  ", "Vishti   "};
  public static final int karId[] = {2, 3,
    4, 5, 6, 7, 8, 9, 10, 4, 5, 6, 7, 8, 9, 10,
    4, 5, 6, 7, 8, 9, 10, 4, 5, 6, 7, 8, 9, 10,
    4, 5, 6, 7, 8, 9, 10, 4, 5, 6, 7, 8, 9, 10,
    4, 5, 6, 7, 8, 9, 10, 4, 5, 6, 7, 8, 9, 10, 0, 1};

}

/*---------------------------------------------------------------*/
