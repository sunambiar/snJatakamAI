
package snJatakamAI.snJatakam.sn_Jatakam;
/*---------------------------------------------------------------*/
import java.io.*;
//import java.util.*;

import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snExchange; 
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snVarsJ;
import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snVarsM;
//import snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.*;
/*---------------------------------------------------------------*/

/*---------------------------------------------------
        Suresh's Horoscope (Prediction Program)
-----------------------------------------------------*/

class snPhal {
  static snVarsM M = new snVarsM();
  static snVarsJ J = new snVarsJ();
  static PrintStream pS;
  static final String phal_vaara[] = {
    "Aatma sudhi", "Hrudaya sudhi", "Anger, Cruelty",
    "Intelligent", "Punyavaan", "Handsome/Beautiful",
    "Laziness" };
  static final String phal_nakshatra[] = {
    "Budhi, Courage, Beauty - (Lord : Ketu)",
    "Shaantata, StreeSakti, Courageous - (Lord : Sukra)",
    "BhakshanaPriyan, Less Brothers, ParaStreeSakti - (Lord : Ravi)",
    "Speak Satyam, Has Beauty, Eye ailment - (Lord : Chandra)",
    "Utsaaham, Saamarthyam - (Lord : Kuja)",
    "Garv, Asooya, Deerghayuss - (Lord : Raahu)",
    "DaanaSeelam, Sukham, Leaves house of birth - (Lord : Guru)",
    "SantoshaSeelam, Vidwan, Dhanavaan, Without Lajja - (Lord : Sani)",
    "HridayaKaattinyam, Vanchana, Chapalata - (Lord : Budha)",
    "Arivu, Dhanam, Saundaryam, Has many Satrus & Asooyakkar - (Lord : Ketu)",
    "Good Samsaaram, Saamarthyam, Servant ManoBhaavam, Acts like Brave - (Lord : Sukra)",
    "Gets Sukham, Dhanam, JanaSammati, Pramaani, Has less hunger - (Lord : Ravi)",
    "Kusalatha, VaakSaamarthyam, OrmaSakti, No Lajja - (Lord : Chandra)",
    "Utsaahi, Has Beauty, Leaves own house, Likes bad Strees - (Lord : Kuja)",
    "VaakSaamarthyam, DaanaSeelam, Likes fine arts, Likes good food, Taskaratwam - (Lord : Raahu)",
    "No Wasteful expenditure, Dhanam, Prasidhi - (Lord : Guru)",
    "Has more Hunger & Thirst, Has some disease, Likes travel - (Lord : Sani)",
    "KopaSeelam, Thinks Crookedly, DharmaNiratan, Intelligent - (Lord : Budha)",
    "Respectability, Leadership, Frequent diseases - (Lord : Ketu)",
    "Budhi Saamarthyam, Garv, Well Behaved wife - (Lord : Sukra)",
    "BandhuBalam, Travellor, Live abroad - (Lord : Ravi)",
    "Leaves own House, Good Wife, Pious - (Lord : Chandra)",
    "Professor of Untruth, Stinchy, Wealthy, Live abroad, Always Aiswaryam - (Lord : Kuja)",
    "Talks without looking the face, Conqueror of foes, Without blind beliefs, Lots of Good virtues - (Lord : Raahu)",
    "Servant to Spouse, Frequently Increasing Sukha-Dukha, Treachery for Ganining Wealth, TarkkaSeelam, Long Life - (Lord : Guru)",
    "Talks acceptingly, Studies Science, Devoid of Enemies, Dharmavaan - (Lord : Sani)",
    "Dhanam, Budhi, Good Body Features, Servant to Spouse - (Lord : Budha)"
  };
  static final String phal_tithi[] = {
    "Tyaaga Behaviour, Diseases, Duritam",
    "Liking for Architecture, God Fearing, Believer in MantraVaada",
    "Wealthy, Pride",
    "SatSwabhaavam, Garv, BandhuSneham",
    "Finds obstacles in all endeavours, SaattyaPrakriti",
    "Sawbhaagyam, Wealth, Vijnaanam",
    "Kopi, Health, Kshemam",
    "Rude Speaker, Bad Friendship",
    "Good Body Features, Adventurous, Sreshtata, Independent habits",
    "Selfishness, Administrative qualities, Thieving nature",
    "Peaceful Behaviour, Wealth",
    "Wealth, Vidwattwam, Good Behaviour",
    "Vishnu Bhaktan, Wealth, Vidya",
    "Weakness, Poor",
    "Bad Habits, Saattyata",
    "Vidya, Vinayam, Yashas, Knowledge of science",
  };
  static final String phal_karanam[] = {
    "Fame, Long Life",
    "BandhuHeenata, Short Life",
    "Bad Keerti, Changing phases of Happiness and Sorrow",
    "No stable Opinion, Doesn't remain at one station for long",
    "Great liking for Food, Strong-man",
    "Diseased, Fear",
    "Angry Nature, Has to Strive Hard",
    "Budhi, Utsaaham",
    "Vidwaan, Intelligent, Owner of Cows",
    "Intelligent, Independent",
    "Short Life, Struggles without any Result"
  };
  static final String phal_nityaYoga[] = {
    "Slight koonu in Body, DeerghaDarshi",
    "KarmaKushalata, BandhuBalam",
    "Long Life, Keerti, Pandit",
    "<--- Not known --->",
    "Wealth, Happiness, BandhuBalam",
    "Knowledge of Arts, SattaPrakrutam, Quarrelsome",
    "Guanam, Sukham, Good Wife",
    "Pandit, Subhagata",
    "Quarrelsome, Wealth, Pride",
    "Tall Body, Bad Habits",
    "Pandit, SatBudhi, Good Wife",
    "Constant Utsaaham, Stable Words, Patience",
    "MunKopam, Chapalata, Vikalata of Eye",
    "KulaMukhyan, SatyaVaadi",
    "Creator of Bad actions, Sees Bad in Others",
    "Pure Body, Aiswaryam, Intelligence",
    "Perpetuator of Bad actions, Moorkhata(Foolishness)",
    "Good Wife, Pride, Courage",
    "KrishaGaatran, NirDhanata",
    "Devotion to God, Wealth",
    "Pure Heart, SadaAchaaraNirata, Wealth",
    "Dharmishtan, Vidwaan, SangetaPriyam",
    "SudhaGati, Good Wife, Wealth, Happiness, Handsome",
    "Proud, Wealth, Vidwatwam, Moorkhata(foolish)",
    "BrahmaJnaanam, Pandit, Tyaagam, SukhaBhogam",
    "ParopaKaari, Jnaani, Intelligent, KhispraKopi",
    "Beauty, Pleasure Loving, Satyavaan"
  };
  static final String phal_raviAsraya[] = {
    "",
    "Less Hair, Lazy, Angry, Tall, Proud, Staring looks, Slim, Soorata, No kindness",
    "No Vidya, No Vinayam, Wealth would be taken by Govt., Hair on Face",
    "Sakti, Sauryam, Aiswaryam, DaanaSeelam, Conqueror of Foes, Intelligent",
    "No Sukham, No Relatives, No Land, Two Houses, Govt. Servant, Spends Inherited wealth",
    "No Sukham, No Wealth, No Long life, No Sons, Intelligent, Travels in Forest",
    "Keertimaan, Gunam, Wealth, Winning Habit, Kinglike, Without Foes, diseases or Sorrow",
    "Dislike towards King, Untidy Body, Insult from Women, Lose Spouse",
    "No Long Life, No Relatives, No Wealth, VikalaDrishti, Less Sons, Less PitruSukham",
    "Sons, Relatives, Interested in God & Godly matters, Separated from Father",
    "Sons, Vehicles, Intellect, Aiswaryam, Strength, Yashass",
    "Wealth, Long Life, No Sorrow",
    "Dislike of Father, Eyes Vikalam, Less Wealth, Less Sons",
  };
  static final String phal_chandraAsraya[] = {
    "",
    "Unintelligent, No Eyesight, Dumb, Deaf However, if Chandra is strong," +
      " then, healthy body, Long life, Courageous",
    "Wealth, Vidwatwam, Material Pleasure, Broken speech",
    "Brothers/Sisters, Pride, Muscle, Sauryam, Miser",
    "Intelligent, DaanaSeelan, Vehicles, Yashass",
    "Good Children, Intelligent, Saamarthyam, Slow Walker, Minister",
    "Short Life, Unintelligence, Stomach diseases",
    "Dushtata, Saumyata, Good Spouse, Beautiful",
    "Disease, Short Life - However, if Chandra is strong, Healthy, Long Life",
    "Aiswaryam, Dharmam, Children, Consistently victorious, Victorious in whatever he starts",
    "Doer of Good things, Doer of things of others liking",
    "Vidwatham, Long life, Wealth, Lots of Sons, Wives",
    "Angry, Dukhitan, Speaker of Untruth, Ninditan, Lazy"
  };
  static final String phal_kujaAsraya[] = {
    "",
    "Wickedness, Short life, Adventurous",
    "Without Vidya or Wealth, Bad Company",
    "SatGunas, Wealth, Valour, Sukham, Without younger brothers, Sooran",
    "Without any of Relatives, Mother, Land, Sukham, House or Vehicles",
    "Without any of Sukham, Sons, Wealth, Budhi; Teller of Untruth",
    "Aiswaryam, Overpowers Enemies, Become king",
    "Disease, Dukham, Loss of Wife; Doer of Heena Jobs",
    "Ugly body, No wealth, Short life, Ninditan",
    "Relative of King, Angry, Without father's love, Doer of wrong to People",
    "Wickedness, Equivalent to King, DaanaSeelan, Praised by prominent people",
    "Wealth, Happiness, Gunam, Sooratwam",
    "Ugly eyes, Wickedness, Without wife, Liar, Worst character"
  };
  static final String phal_budhaAsraya[] = {
	"",
	"Long life, Pleasant talk, SamsaaraChaaturyam, SaastraJnaanam, dual personality",
	"Poet, Sayer of Good(Nirmala) Words, Good eater, Wealth earned of Intelligence",
	"Sooratwam, Good Brothers, Speaks Saamarthyam",
	"Happiness, Relatives, Land, Grains, Enjoyment",
	"Vidya, Happiness, Sons; Magician",
	"Angry(Kopi), Controversial, Destroyer of enemies, Lazy, Utters Strong words",
	"Vidwatwam, Extravagantly dressed, Wealthy wife, All Sreshtatas, More than one Wives",
	"Popularity, Long life, Leader of Kulam, Vidwatwam",
	"Vidya, Wealth, Religious(VrataAnushttaanamgal)",
	"Performs all things beautifully, Good Vidya, Strength, Intelligence, Habit of doing Good",
	"Long life, Truthfulness, Lots of Wealth, Many Sons",
	"Many Servants, Without thanksgiving, Lazy"
  };
  static final String phal_guruAsraya[] = {
    "",
    "With Shobha, Doer of Good, Long Life, Unafraid, With Sons",
    "Vaagmi, Lover of food, Good Face, Wealthy, Vidwaan",
    "Nindaa habit, Greedy, Popular Younger Brothers, Dushtatha, Dushta Budhi",
    "Relatives, Motherly affection, Lots of friends, StreeSukhaLabdhi",
    "PutraDukham, Mininster to King, Intelligent",
    "Lazy, Victorious over enemies, Always Complaining habit, Knower of Mantraas & Tantraas",
    "Good wife, sons and beauty; More benevolent than his father",
    "Deenata, Service job, Doer of Sin, Long life, Loved by people",
    "Keertimaan, Mantri, Wealth, Sons, Dharmishtan",
    "Yashass, Wealthy, Liked by King",
    "Wealthy, Courageous, Antassu, Lesser no of eyes for Children, Miser",
    "Lazy, Service Job Worker, Paapi, Does not go-together with sons, Vikala-Samsaaram due to Anger",
  };
  static final String phal_sukraAsraya[] = {
    "",
    "Liked by females, Sukham, Long life",
    "Kavitwam, Wealth, VaakChaaturyam",
    "Without BhaaryaaSukham or Wealth; Miser",
    "With many vehicles, house, ornaments, clothes, perfumes",
    "Extraordinarily Wealthy, Intelligence, Sons, Kingly nature",
    "Without enemies or wealth, Ill-fated due to Females",
    "Loss of spouse, Shreshtata",
    "Long life, Wealth",
    "Good Wife, sons and relatives; Fortunate thanks to King",
    "Keerti, Relatives, Wealth, KarmaGunam",
    "Wealth, KaaryaAnukoolyam, Happiness",
    "StreeSukhaLabdhi, Beauty, Begetter of Wealth",
  };
  static final String phal_saniAsraya[] = {
    "",
    "If Sani in Ucham/Swakshetram, King, DesaAadhipatyam else Dukham, Poverty",
    "Poverty, Videsavaasam",
    "Very Intelligent, DaanaSeelan, BhaaryaSukham, Lazy, Paravasan(Tired)",
    "Dukham, Disease at tender age itself, Without any of house, mother, vehicle",
    "Vikalata of Intelligence; Without Sons, Happiness or Wealth; PutraDukham",
    "Destroyer of enemies, Poud nature, Wealthy",
    "Without wealth; Afraid, Interest in bad females",
    "ArsoRogam, Without wealth; Excess hunger; Insult from Friends, Long Life",
    "Destruction to Bhaagyam, Dhanam, Sons, Father; Company of bad people",
    "Interest in Farming, Minister or King, Lots of Wealth",
    "Long life, Permanent Wealth, Soorata, No diseases",
    "Without Shame, Wealth or Sons; SamsaaraDukham, SatruBhayam",
  };
  static final String phal_raahuAsraya[] = {
    "",
    "Short Life, Disease of Head, Wealthy",
    "Liar, Disease of Face, Gainer of Wealth from King, MunKopi (Suden anger)",
    "Doer of ill to Brothers, Strong Intelligence, Long Life, Wealth",
    "Mooddata, Many friends, Unhappiness at House, Short life",
    "Talks thru the nose, Without sons; Strong Heart, Stomach diseases",
    "Bear with troubles from enemies, Aiswaryam, Long life, ArsoRogam",
    "Independent nature, Short Intelligence, Expenditure & Unhappiness due to Females",
    "No Aayuss, Ugly nature, Rheumatism, Less Children",
    "Opposer, Leader, Punyavaan, Kerrtimaan",
    "Less sons, Courageous, Doer of Good things",
    "Less sons, Ear diseases, Long life, Aiswaryam",
    "Nirdosham, Doer of PaapaKarmas in Secrecy, Extravagant",
  };
  static final String phal_ketuAsraya[] = {
    "",
    "Without thanksgiving, Without health, Incomplete body parts, Bad Company",
    "Without Vidya, Worse talk, Ugly eyes, Paapi, Interested in other's food",
    "AayurBalam, Wealth, Yashass, StreeSukham, SukhaBhakshanam, Sahordaras will get destroyed",
    "Stay in other House after destruction of Land, House, Vehicle, Mother, Native place",
    "Destruction to sons, Diseases of Stomach, PisaachPeeda, DurBudhi",
    "Giver, UthamaGunaas, Keerti, Increased enemies, Prabhutwam, IshtaSaadhyam",
    "Bear with Insult, Divorce; Indulge in females who are non-PatiVrataas",
    "Short life, stay away from liked ones, Always fights, Cuts due to Weapons",
    "Without Father or Bhaagyam, Doer of good things",
    "Does not do good Karmas, Do Karmas in bad ways, Do Paapam; Soorata, Popularity",
    "Wealth, Different Gunas,  MukhaShobha, Household articles, KarryaSidhi",
    "Hides Paapas, Destroyer of Wealth, Eye diseases"
  };
  static final String phal_maandiAsraya[] = {
    "",
    "Thief, Cruel, Unkind, Without Jnaanam, Vikruta Policies, Unintelligence, No sons, Great eater, "+
      "Without Sukham, MunKopam, Fighting nature",
    "Fighting nature, Without Wealth or Food, Lives abroad, Unfruitful Arguement",
    "Proud, Madam, Anger, Wanderer, Courageous, Happy, Destruction to Brothers",
    "Without relatives or vehicles",
    "Wavering mind, Heena Budhi, Without sons",
    "Winner over enemies, Entertaining in Magic, Sooran, Sreshta(Good) sons",
    "Fighting nature, polygamist, Angry with the whole world, Without thanksgiving, Less Jnaanam",
    "Ugly eyes & face; Dwarf/Short",
    "Without Preceptor or sons",
    "Indulge in karmaas which gives Bad Results, Does not do Daanam",
    "Happiness, Sons, Intelligence, Tejas, Kaanti(Beauty)",
    "Pleasure disliking, Deenata, Extra-expenditure"
  };
/*---------------------------------------------------------------*/
/*---------------------------------------------------------------*/
  snPhal (String[] args) {
    final short XCHG_ARGS = 19;
    //try {
    if (args.length < XCHG_ARGS) {
      snJatak snJ = new snJatak(args);
      snPhal snP = new snPhal(snJ.snE);
    }
  }
  snPhal (snExchange snE) {
    //snVarsJ J = new snVarsJ();
    String phalFname, str;
    int tit, bhaav, sNo = 1;
    double tithiRnd;
    //DataInputStream dis = new DataInputStream(System.in);

    phalFname = "snIndex/snPhalam.htm";
    File pSFD = new File(phalFname);
    phalFname = pSFD.getAbsolutePath();

    try {
    /*
    System.out.println("Enter Filename with Longitude/Latitude data : ");
    System.out.flush();
    boyFname = dis.readLine();
    System.out.println("Enter Filename having Sun-rise data : ");
    System.out.flush();
    sunRiseFname = dis.readLine();
    */
    String sTDTR = "</TD></TR><TR><TD>";

    pS = new PrintStream(new FileOutputStream(phalFname));
    pS.println("<HTML><TITLE>");
    pS.println("Phalam / Effects :- "+snE.gn());
    pS.println("</TITLE><BODY>");
    pS.println("<STRONG>");
    pS.println("Phalam / Effect of Horoscope   Author :-"+snE.gn());
    pS.println("</STRONG><BR><BR><BR>");
    pS.println("<TABLE border=1><TR><TD>");
    pS.println("Name : </TD><TD>" + snE.name + sTDTR);
    pS.println("Date of Birth :</TD><TD>"+snE.dob.dmy() + sTDTR);
    pS.println("</TD></TR></TABLE>");
    pS.println("<TABLE border=1>");
    /*
    pS.println("<TR><TD>" + "Vaara Phalam" +"</TD><TD>");
    pS.println(snE.dowHindu + "</TD><TD>"+ phal_vaara[snE.dowHindu_No]);
    pS.println("</TD></TR>");
    pS.println("<TR><TD>" + "Nakshatra Phalam" +"</TD><TD>");
    pS.println(snE.naksha + "</TD><TD>"+ phal_nakshatra[snE.naksha]);
    pS.println("</TD><TR>");
    */
    System.out.println(sNo+"."+"Vaara Phalam "+ snE.dowHindu +
                                          " " + phal_vaara[snE.dowHindu_No]);
    pStable(sNo++,"Vaara Phalam", snE.dowHindu, phal_vaara[snE.dowHindu_No]);
    System.out.println(sNo+"."+"Nakshatra = "+
    					(snE.naksha+1)+"("+J.nak[snE.naksha].trim()+")");
    pStable(sNo++,"Nakshatra Phalam",
    					""+(snE.naksha+1)+"("+J.nak[snE.naksha].trim()+")",
                                    phal_nakshatra[snE.naksha]);
    tit = (int)snE.tithi;
    if (tit > 14) {
      if (tit != 15 && tit != 30) tit -= 14;
      else if (tit == 30) tit = 0;
    }
    tithiRnd = ((int)(Math.round(snE.tithi * 100)))/100.0;
    System.out.println(sNo+"."+"Tithi = "+tithiRnd+"("+J.tit[(int)snE.tithi].trim()+")");
    pStable(sNo++,"Tithi Phalam", ""+tithiRnd+"("+J.tit[(int)snE.tithi].trim()+")",
                                                       phal_tithi[tit]);
    System.out.println(sNo+"."+"Karanam="+
    				snE.karanam+"("+J.karanam[J.karId[snE.karanam]].trim()+")");
    pStable(sNo++,"Karana Phalam", ""+
    				snE.karanam+"("+J.karanam[J.karId[snE.karanam]].trim()+")",
                                phal_karanam[J.karId[snE.karanam]]);
    System.out.println(sNo+"."+"Yogam = "+snE.yogam+"("+J.yog[snE.yogam]+")");
    pStable(sNo++,"Nitya Yoga Phalam", ""+snE.yogam+"("+J.yog[snE.yogam]+")",
                 								phal_nityaYoga[snE.yogam]);

    str = getUchaGrahas(snE);
    System.out.println(sNo+"."+"Ucha Grahas = " + str);
    pStable(sNo++,"Ucha Grahas ", "", str);
    str = getSwakshetraGrahas(snE);
    System.out.println(sNo+"."+"Swakshetra Grahas = " + str);
    pStable(sNo++,"Swakshetra Grahas ", "", str);
    str = getVargothamaGrahas(snE);
    System.out.println(sNo+"."+"Vargothama Grahas = " + str);
    pStable(sNo++,"Vargothama Grahas ", "", str);
    str = getNeechaGrahas(snE);
    System.out.println(sNo+"."+"Neecha Grahas = " + str);
    pStable(sNo++,"Neecha Grahas ", "", str);

    str = getUchaAmsa(snE);
    System.out.println(sNo+"."+"Ucha Amsa = " + str);
    pStable(sNo++,"Ucha Amsa ", "", str);
    str = getSwakshetraAmsa(snE);
    System.out.println(sNo+"."+"Swakshetra Amsa = " + str);
    pStable(sNo++,"Swakshetra Amsa ", "", str);
    str = getNeechaAmsa(snE);
    System.out.println(sNo+"."+"Neecha Amsa = " + str);
    pStable(sNo++,"Neecha Amsa ", "", str);

	str = J.grahalong[M.rasi[snE.vrg_1[0]%12].adhipa[0]].trim();
    System.out.println(sNo+"."+"Lagna Adhipa = " + str);
    pStable(sNo++,"Lagna Adhipa", "", str);
    str = getTrikonaGrahas(snE, snE.vrg_1[M.LAGNA]);
    System.out.println(sNo+"."+"Trikona Grahas = " + str);
    pStable(sNo++,"Trikona Grahas", "", str);
    str = getTrikonaGrahas(snE, snE.vrg_1[M.SASI]);
    System.out.println(sNo+"."+"Trikona Grahas (Chandraal) = " + str);
    pStable(sNo++,"Trikona Grahas", "Chandraal", str);
    str = getTrikonaGrahas(snE, snE.vrg_1[M.BRUHASPATI]);
    System.out.println(sNo+"."+"Trikona Grahas (Guruvaal) = " + str);
    pStable(sNo++,"Trikona Grahas", "Guruvaal", str);

    str = getKendraGrahas(snE, snE.vrg_1[M.LAGNA]);
    System.out.println(sNo+"."+"Kendra Grahas = " + str);
    pStable(sNo++,"Kendra Grahas", "", str);
    str = getKendraGrahas(snE, snE.vrg_1[M.SASI]);
    System.out.println(sNo+"."+"Kendra Grahas (Chandraal) = " + str);
    pStable(sNo++,"Kendra Grahas", "Chandraal", str);
    str = getKendraGrahas(snE, snE.vrg_1[M.BRUHASPATI]);
    System.out.println(sNo+"."+"Kendra Grahas (Guruvaal) = " + str);
    pStable(sNo++,"Kendra Grahas", "Guruvaal", str);

    str = getTrikonaAadhipatya(snE.vrg_1[M.LAGNA]);
    System.out.println(sNo+"."+"Trikona Aadhipatyam = " + str);
    pStable(sNo++,"Trikona Aadhipatyam", "", str);
    str = getTrikonaAadhipatya(snE.vrg_1[M.SASI]);
    System.out.println(sNo+"."+"Trikona Aadhipatyam (Chandraal)= " + str);
    pStable(sNo++,"Trikona Aadhipatyam", "Chandraal", str);
    str = getTrikonaAadhipatya(snE.vrg_1[M.BRUHASPATI]);
    System.out.println(sNo+"."+"Trikona Aadhipatyam (Guruvaal)= " + str);
    pStable(sNo++,"Trikona Aadhipatyam", "Guruvaal", str);

    str = getKendraAadhipatya(snE.vrg_1[M.LAGNA]);
    System.out.println(sNo+"."+"Kendra Aadhipatya Dosham = " + str);
    pStable(sNo++,"Kendra Aadhipatya Dosham", "", str);
    str = getKendraAadhipatya(snE.vrg_1[M.SASI]);
    System.out.println(sNo+"."+"Kendra Aadhipatya Dosham (Chandraal)= " + str);
    pStable(sNo++,"Kendra Aadhipatya Dosham", "Chandraal", str);
    str = getKendraAadhipatya(snE.vrg_1[M.BRUHASPATI]);
    System.out.println(sNo+"."+"Kendra Aadhipatya Dosham (Guruvaal)= " + str);
    pStable(sNo++,"Kendra Aadhipatya Dosham", "Guruvaal", str);

    bhaav = snE.bhaavaDiff(snE.vrg_1[1], snE.vrg_1[0]);
    System.out.println(sNo+"."+"Ravi = " + bhaav);
    pStable(sNo++,"Ravi Asraya Phalam", ""+bhaav, phal_raviAsraya[bhaav]);
    bhaav = snE.bhaavaDiff(snE.vrg_1[2], snE.vrg_1[0]);
    System.out.println(sNo+"."+"Budha = " + bhaav);
    pStable(sNo++,"Budha Asraya Phalam", ""+bhaav, phal_budhaAsraya[bhaav]);
    bhaav = snE.bhaavaDiff(snE.vrg_1[3], snE.vrg_1[0]);
    System.out.println(sNo+"."+"Sukra = " + bhaav);
    pStable(sNo++,"Sukra Asraya Phalam", ""+bhaav, phal_sukraAsraya[bhaav]);
    bhaav = snE.bhaavaDiff(snE.vrg_1[4], snE.vrg_1[0]);
    System.out.println(sNo+"."+"Kuja = " + bhaav);
    pStable(sNo++,"Kuja Asraya Phalam", ""+bhaav, phal_kujaAsraya[bhaav]);
    bhaav = snE.bhaavaDiff(snE.vrg_1[5], snE.vrg_1[0]);
    System.out.println(sNo+"."+"Guru = " + bhaav);
    pStable(sNo++,"Guru Asraya Phalam", ""+bhaav, phal_guruAsraya[bhaav]);
    bhaav = snE.bhaavaDiff(snE.vrg_1[6], snE.vrg_1[0]);
    System.out.println(sNo+"."+"Sani = " + bhaav);
    pStable(sNo++,"Sani Asraya Phalam", ""+bhaav, phal_saniAsraya[bhaav]);
    bhaav = snE.bhaavaDiff(snE.vrg_1[7], snE.vrg_1[0]);
    System.out.println(sNo+"."+"Chandra = " + bhaav);
    pStable(sNo++,"Chandra Asraya Phalam", ""+bhaav, phal_chandraAsraya[bhaav]);
    bhaav = snE.bhaavaDiff(snE.vrg_1[8], snE.vrg_1[0]);
    System.out.println(sNo+"."+"Rahu = " + bhaav);
    pStable(sNo++,"Rahu Asraya Phalam", ""+bhaav, phal_raahuAsraya[bhaav]);
    bhaav = snE.bhaavaDiff(snE.vrg_1[9], snE.vrg_1[0]);
    System.out.println(sNo+"."+"Ketu = " + bhaav);
    pStable(sNo++,"Ketu Asraya Phalam", ""+bhaav, phal_ketuAsraya[bhaav]);
    bhaav = snE.bhaavaDiff(snE.vrg_1[13], snE.vrg_1[0]);
    System.out.println(sNo+"."+"Maandi = " + bhaav);
    pStable(sNo++,"Maandi Asraya Phalam", ""+bhaav, phal_maandiAsraya[bhaav]);
    pS.println("</TABLE>");
    pS.println("</BODY></HTML>");
    } catch (Exception e) { System.out.println("Error .. "); };
  }
/*---------------------------------------------------------------*/
  private static String getUchaGrahas (snExchange snE) {
	String str = "", delim = "";
	int i, k, rsi, grh_i;
	// Maandi doesn't have any UchaSthaanam hence not M.GRAHAS+1
	for (i = 1; i < M.GRAHAS; i++) {
	  rsi = snE.vrg_1[i] % 12;
	  for (k = 0; k < M.rasi[rsi].uchagraha.length; k++) {
		grh_i = M.rasi[rsi].uchagraha[k];
  	    if (i == grh_i) {
		  str += delim + J.grahalong[grh_i].trim();
		  delim = ", ";
		}
	  }
    }
    if (str.length() == 0) str = "-*None*-";
    return (str);
  }
/*---------------------------------------------------------------*/
  private static String getNeechaGrahas (snExchange snE) {
	String str = "", delim = "";
	int i, k, rsi, grh_i;
	// Maandi doesn't have any NeechaSthaanam hence not M.GRAHAS+1
	for (i = 1; i < M.GRAHAS; i++) {
	  rsi = snE.vrg_1[i] % 12;
	  for (k = 0; k < M.rasi[rsi].neechagraha.length; k++) {
		grh_i = M.rasi[rsi].neechagraha[k];
  	    if (i == grh_i) {
		  str += delim + J.grahalong[grh_i].trim();
		  delim = ", ";
		}
	  }
    }
    if (str.length() == 0) str = "-*None*-";
    return (str);
  }
/*---------------------------------------------------------------*/
  private static String getSwakshetraGrahas (snExchange snE) {
	String str = "", delim = "";
	int i, k, ksh;
	// Maandi doesn't have any SwakshetraSthaanam hence not M.GRAHAS+1
	for (i = 1; i < M.GRAHAS; i++) {
	  for (k = 0; k < M.grah[i].swakshetra.length; k++) {
		ksh = M.grah[i].swakshetra[k];
		if (ksh >= 0 && snE.vrg_1[i] == ksh) {
	      str += delim + J.grahalong[i];
  	      delim = ", ";
	    }
	  }
	}
    if (str.length() == 0) str = "-*None*-";
    return (str);
  }
/*---------------------------------------------------------------*/
  private static String getVargothamaGrahas (snExchange snE) {
	String str = "", delim = "";
	int i;
	for (i = 1; i < M.GRAHAS+1; i++) {
	  if (snE.vrg_1[i] == snE.vrg_9[i]) {
	    str += delim + J.grahalong[i];
	    delim = ", ";
	  }
    }
    if (str.length() == 0) str = "-*None*-";
	return (str);
  }
/*---------------------------------------------------------------*/
  private static String getUchaAmsa (snExchange snE) {
	String str = "", delim = "";
	int i, k, rsi, grh_i;
	// Maandi doesn't have any UchaSthaanam hence not M.GRAHAS+1
	for (i = 1; i < M.GRAHAS; i++) {
	  rsi = snE.vrg_9[i] % 12;
	  for (k = 0; k < M.rasi[rsi].uchagraha.length; k++) {
		grh_i = M.rasi[rsi].uchagraha[k];
  	    if (i == grh_i) {
		  str += delim + J.grahalong[grh_i].trim();
		  delim = ", ";
		}
	  }
    }
    if (str.length() == 0) str = "-*None*-";
    return (str);
  }
/*---------------------------------------------------------------*/
  private static String getNeechaAmsa (snExchange snE) {
	String str = "", delim = "";
	int i, k, rsi, grh_i;
	// Maandi doesn't have any NeechaSthaanam hence not M.GRAHAS+1
	for (i = 1; i < M.GRAHAS; i++) {
	  rsi = snE.vrg_9[i] % 12;
	  for (k = 0; k < M.rasi[rsi].neechagraha.length; k++) {
		grh_i = M.rasi[rsi].neechagraha[k];
  	    if (i == grh_i) {
		  str += delim + J.grahalong[grh_i].trim();
		  delim = ", ";
		}
	  }
    }
    if (str.length() == 0) str = "-*None*-";
    return (str);
  }
/*---------------------------------------------------------------*/
  private static String getSwakshetraAmsa (snExchange snE) {
	String str = "", delim = "";
	int i, k, ksh;
	// Maandi doesn't have any SwakshetraSthaanam hence not M.GRAHAS+1
	for (i = 1; i < M.GRAHAS; i++) {
	  for (k = 0; k < M.grah[i].swakshetra.length; k++) {
		ksh = M.grah[i].swakshetra[k];
		if (ksh >= 0 && snE.vrg_9[i] == ksh) {
	      str += delim + J.grahalong[i];  //  M.rasi[ksh].name.trim();
  	      delim = ", ";
	    }
	  }
	}
    if (str.length() == 0) str = "-*None*-";
    return (str);
  }
/*---------------------------------------------------------------*/
  private static String getKendraGrahas (snExchange snE, int vrg_1_0) {
	String delim = "", str = "";
	int i, k=0;
	int[] kendra = new int[M.GRAHAS+1];
	for (i=1; i < M.GRAHAS+1; i++) {
	  switch (snE.bhaavaDiff(snE.vrg_1[i],vrg_1_0)) {
		case 1 : case 4 : case 7 : case 10 :
		  kendra[k++] = i;  break;
	  }
	}
	for (i=0; i < k; i++) {
	  str += delim + J.grahalong[kendra[i]].trim();
	  delim = ", ";
	}
	return (str);
  }
/*---------------------------------------------------------------*/
  private static String getKendraAadhipatya (int snE_vrg_1_0) {
	int kendraPos[] = { 1, 4, 7, 10};
	int i;
	String str = "", delim = "";
    for (i = 0; i < kendraPos.length; i++) {
	  kendraPos[i] = ((kendraPos[i] + snE_vrg_1_0 - 1) % 12);
	  str +=delim + J.grahalong[M.rasi[kendraPos[i]].adhipa[0]].trim();
	  delim = ", ";
    }
    return (str);
  }
/*---------------------------------------------------------------*/
  private static String getTrikonaGrahas (snExchange snE, int vrg_1_0) {
	String delim = "", str = "";
	int i, t=0;
	int[] trikona = new int[M.GRAHAS+1];
	for (i=1; i < M.GRAHAS+1; i++) {
	  switch (snE.bhaavaDiff(snE.vrg_1[i],vrg_1_0)) {
		case 1 : case 5 : case 9 :
	      trikona[t++] = i; break;
	  }
	}
	for (i=0; i < t; i++) {
	  str += delim + J.grahalong[trikona[i]].trim();
	  delim = ", ";
	}
	return (str);
  }
/*---------------------------------------------------------------*/
  private static String getTrikonaAadhipatya (int snE_vrg_1_0 ) {
	int trikonaPos[] = { 1, 5, 9};
	int i;
	String str = "", delim = "";
    for (i = 0; i < trikonaPos.length; i++) {
	  trikonaPos[i] = ((trikonaPos[i] + snE_vrg_1_0 - 1) % 12);
	  str +=delim + J.grahalong[M.rasi[trikonaPos[i]].adhipa[0]].trim();
	  delim = ", ";
    }
    return (str);
  }
/*---------------------------------------------------------------*/
  private void pStable (int i, String s1) {
    pS.println(i + s1);
  }
  private void pStable (int i, String s1, String s2, String s3) {
    pS.println("<TR><TD>"+i+"</TD><TD>"+s1+"</TD><TD>"+s2+
     								"</TD><TD>"+s3+"</TD></TR>");
  }
  private void pStable (int i, String s1, long s2, String s3) {
    pStable(i, s1, ""+s2, s3);
  }
  private void pStable (int i, String s1, String s2) {
	pStable(i, s1, s2, "");
  }
/*---------------------------------------------------------------*/
}
/*------------------------------------End of Program ----*SuN*----*/
