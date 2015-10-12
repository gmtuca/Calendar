public class Month
{
  public int monthNumber;
  public int positionFirstDay;
  public static int positionLastDay;
  public int lastDayNumber;
  public static String monthAccumulator = "";

  public Month(int givenMonthNumber, int givenPositionFirstDay, int givenLastD)
  {
    monthNumber = givenMonthNumber;
    positionFirstDay = givenPositionFirstDay;
    lastDayNumber = givenLastD;
  }//constructor

  public void resetMonth()
  {
    monthAccumulator = "";
  }//resetMonth

  private String monthName()
  {
    switch(monthNumber)
    {
      case 1: return  "                  January"; 
      case 2: return  "                 February";
      case 3: return  "                   March";
      case 4: return  "                    April";
      case 5: return  "                      May";
      case 6: return  "                      June";
      case 7: return  "                      July";
      case 8: return  "                  August";
      case 9: return  "                September";
      case 10: return "                 October";
      case 11: return "                 November";
      case 12: return "                 December";
      default: return "";
    }//switch

  }//monthName

  public String toString()
  {
    positionLastDay = positionFirstDay;

    monthAccumulator += monthName() + "\n Su   Mo   Tu   We   Th   Fr   Sa  \n";

    int lastDayOfTheWeek = 8 - positionFirstDay;

    for(int week = 1; week <= 6; week++)
    {
      int day;
      for(day = (2 - positionFirstDay + (week - 1) * 7);
                     day <= lastDayOfTheWeek; day++)
      {
        PrintDate(day, lastDayNumber);

        if(day != lastDayOfTheWeek)
          monthAccumulator += " ";
        //if

      }//for day

      monthAccumulator += " \n";

     if(lastDayOfTheWeek <= lastDayNumber - 7)
       lastDayOfTheWeek += 7;
     else
       if(day < lastDayNumber)
         lastDayOfTheWeek = 36 - positionFirstDay; 
       else
         lastDayOfTheWeek = 43 - positionFirstDay; 

    }//for week
  
    positionLastDay--;

    monthAccumulator += "%";

    return monthAccumulator;
  }//toString

  public void PrintDate(int day, int maxDay)
  {
    if((day <= 0) || (day > maxDay))
      monthAccumulator += "      ";
    else
    {
      positionLastDay++;

      if(positionLastDay == 8)
        positionLastDay = 1; 

      monthAccumulator += String.format(" %02d ", day);
    }//else

  }//PrintDate

}//class
