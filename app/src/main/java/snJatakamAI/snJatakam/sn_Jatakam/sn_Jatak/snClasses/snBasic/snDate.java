
/*--------------------------------------------------------*/
/*               Suresh's  Jatakam - classes              */
/*--------------------------------------------------------*/
//package sn_Jatak.snClasses.snBasic;
package snJatakamAI.snJatakam.sn_Jatakam.sn_Jatak.snClasses.snBasic;
//package snBasic;
/*--------------------------------------------------------*/
public class snDate {
  short CC;
  short YY;
  short yy;
  short mm;
  short dd;
  short hh;
  short mt;
  double ss;

  /*------------------------------------------------------------------*/
  /*
  snDate(short y1, short m1, short d1) {
    yy = y1; mm = m1; dd = d1;
    YY = (short)((int)yy % 100);
    CC = (short)((int)yy - (int)YY);
  }
  */
  /*------------------------------------------------------------------*/
  public snDate(int y1, int m1, int d1, int h1, int mt1, double s1) {
    yy = (short)y1; mm = (short)m1; dd = (short)d1;
    YY = (short)((int)yy % 100);
    CC = (short)((int)yy - (int)YY);
    hh = (short)h1; mt = (short)mt1; ss = s1;
  }
  /*------------------------------------------------------------------*/
  public snDate(int y1, int m1, int d1) {
    yy = (short)y1; mm = (short)m1; dd = (short)d1;
    YY = (short)((int)yy % 100);
    CC = (short)((int)yy - (int)YY);
  }
  /*------------------------------------------------------------------*/
  public snDate(snDate d) {
    yy = d.yy; mm = d.mm; dd = d.dd;
    YY = (short)((int)yy % 100);
    CC = (short)((int)yy - (int)YY);
  }
  /*------------------------------------------------------------------*/
  public snDate (long jd) {
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
  public snDate (double JD) {
    snDate sD = JD2CAL(JD);
    yy = sD.yy; mm = sD.mm; dd = sD.dd;
    YY = sD.YY; CC = sD.CC;
    hh = sD.hh; mt = sD.mt; ss = sD.ss;
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
	/*
    long ld1, ld2;
    ld1 = jd(d1.dd, d1.mm, d1.yy);
    ld2 = jd(d2.dd, d2.mm, d2.yy);
    */
    double ld1, ld2;
    ld1 = JD(d1.yy, d1.mm, d1.dd,12,0,0);
    ld2 = JD(d2.yy, d2.mm, d2.dd,12,0,0);
    return (long)(ld1 - ld2);
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
	// (greg = 1) or Julian calendar (greg = 0)
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
                      (hour + month/60.0 + sec/3600.0) / 24.0);
  }
  /*------------------------------------------------------------------*/
  public static double JD(long y, long m, long d, long h, long mn, double s)
  {
	// Provide y = negative y  if Era is Before Common Era (BCE)
	long jy, ja, jm;		//scratch
	String era = "CE";      // Common Era

	if( y == 0 ) {
		System.out.println("There is no year 0 in the Julian system!");
        return -1;
    } else if (y < 0) {
		era = "BCE";    // Before Common Era
		y = -y;
    };
    if( y == 1582 && m == 10 && d > 4 && d < 15 ) {
		System.out.println(
		  "The dates 5 through 14 October, 1582, do not exist in the Gregorian system!");
        return -2;
    }

//	if( y < 0 )  ++y;
    if( era == "BCE" ) y = -y + 1;
	if( m > 2 ) {
		jy = y;
		jm = m + 1;
	} else {
		jy = y - 1;
		jm = m + 13;
	}

	long intgr = (long)Math.floor(Math.floor(365.25*jy) + Math.floor(30.6001*jm) + d + 1720995);

	//check for switch to Gregorian calendar
    long gregcal = 15 + 31*( 10 + 12*1582 );
	if( d + 31*(m + 12*y) >= gregcal ) {
		ja = (long)Math.floor(0.01*jy);
		intgr += 2 - ja + (long)Math.floor(0.25*ja);
	}

	//correct for half-day offset
	double dayfrac = (double)h/24.0 - 0.5;
	if( dayfrac < 0.0 ) {
		dayfrac += 1.0;
		--intgr;
	}

	//now set the fraction of a day
	double frac = dayfrac + ((double)mn + s/60.0)/60.0/24.0;

    //round to nearest second
    double jd0 = (intgr + frac)*100000;
    long jd  = (long)Math.floor(jd0);
    if( jd0 - jd > 0.5 ) ++jd;
    return (jd/100000);
  }

  //-----------------------------------------------------------------------------
  // convert Julian date to calendar date
  // (algorithm adopted from Press et al.)
  //-----------------------------------------------------------------------------
  public static snDate JD2CAL(double jd)
  {
	long j1, j2, j3, j4, j5;			//scratch

	//
	// get the date from the Julian day number
	//
    long intgr   = (long)Math.floor(jd);
    double frac    = jd - intgr;
    long gregjd  = 2299161;
	if( intgr >= gregjd ) {				//Gregorian calendar correction
		long tmp = (long)Math.floor(((intgr - 1867216) - 0.25 ) / 36524.25);
		j1 = intgr + 1 + tmp - (long)Math.floor(0.25*tmp);
	} else
		j1 = intgr;

	//correction for half day offset
	double dayfrac = frac + 0.5;
	if( dayfrac >= 1.0 ) {
		dayfrac -= 1.0;
		++j1;
	}

	j2 = j1 + 1524;
	j3 = (long)Math.floor( 6680.0 + ( (j2 - 2439870) - 122.1 )/365.25 );
	j4 = (long)Math.floor(j3*365.25);
	j5 = (long)Math.floor( (j2 - j4)/30.6001 );

	int d = (int)Math.floor(j2 - j4 - Math.floor(j5*30.6001));
	int m = (int)Math.floor(j5 - 1);
	if( m > 12 ) m -= 12;
	int y = (int)Math.floor(j3 - 4715);
	if( m > 2 )   --y;
	if( y <= 0 )  --y;

	//
	// get time of day from day fraction
	//
	int hr  = (int)Math.floor(dayfrac * 24.0);
	int mn  = (int)Math.floor((dayfrac*24.0 - hr)*60.0);
	double f  = ((dayfrac*24.0 - hr)*60.0 - mn)*60.0;
	double sc  = Math.floor(f);
	f -= sc;
    if( f > 0.5 ) ++sc;

    return (new snDate(y, m, d, hr, mn, sc));

	/*
    if( y < 0 ) {
     	y = -y;
        form.era[1].checked = true;
    } else
        form.era[0].checked = true;

    form.year.value          = y;
    form.month[m-1].selected = true;
    form.day[d-1].selected   = d;
    form.hour.value          = hr;
    form.minute.value        = mn;
    form.second.value        = sc;
    */
  }
  /*------------------------------------------------------------------*/
  }
  /*-------------------------- For Horoscope -----------------------*/
