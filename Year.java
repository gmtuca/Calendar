public class Year
{
  public final int year;
  public final Month[] month = new Month[12];
  public final int[] howManyDays = {31,28,31,30,31,30,31,31,30,31,30,31};
  public String accumulatorYear = "";  

  public Year(int yearNumber)
  {
    year = yearNumber;
  }//constructor

  public boolean isLeapYear()
  {
    return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
  }//isLeapYear

  public int weekdayOffset()
  {
    int century = year / 100;
    int centuryOffset = 6;
   
    if((century - 3) % 4 == 0)
      centuryOffset = 0;
    else if((century - 2) % 4 == 0)
      centuryOffset = 2;
    else if((century - 1) % 4 == 0)
      centuryOffset = 4;

    int twoDigitsYear = (year - (year / 100) * 100);
    int twoDigitsYearOffset;

    if (isLeapYear())
      twoDigitsYearOffset = (twoDigitsYear + twoDigitsYear / 4 - 1) % 7;
    else
      twoDigitsYearOffset = (twoDigitsYear + twoDigitsYear / 4) % 7;

    int totalOffset = centuryOffset + twoDigitsYearOffset + 2;

    if(totalOffset > 7)
      totalOffset -= 7;
    
    return totalOffset;
  }//weekdayOffset

  public String toString()
  {

    if(isLeapYear())
      howManyDays[1] = 29;

    for(int index = 0; index <= 11; index++)
    {
      if(index != 0)
        month[index] = new Month(index + 1,
                                 month[index - 1].positionLastDay + 1,
                                 howManyDays[index]);
      else
        month[0] = new Month(1, weekdayOffset(), howManyDays[index]);
      //year offset

      accumulatorYear += month[index];
      month[index].resetMonth();
    }//for

    return accumulatorYear;
  }//toString

}//class


