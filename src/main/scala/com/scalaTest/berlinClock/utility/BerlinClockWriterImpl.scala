package com.scalaTest.berlinClock.utility

import com.scalaTest.berlinClock.models.{MinuteLights, HourLights, SecondLight, BerlinClock}

trait BerlinClockWriterImpl extends BerlinClockWriter {
  val berlinClockWriter = new BerlinClockWriterImpl()

  val litLight = "\u25AE"
  val dimLight = "\u25AF"

  class BerlinClockWriterImpl extends berlinClockWriter{

    def getStringForClock(clock: BerlinClock): String = {
      Console.BLACK +
      "+-----------+\n"+
      "|     " + getSecondsString(clock.secondLight) + "     |\n" +
      "|" + getHoursTopString(clock.hourLights) + "|\n" +
      "|" + getHoursBottomString(clock.hourLights) + "|\n" +
      "|" + getMinutesTopString(clock.minuteLights) + "|\n" +
      "|" + getMinutesBottomString(clock.minuteLights) + "|\n" +
      "+-----------+"+
      Console.RESET
    }

    def getSecondsString(secondLight: SecondLight): String = {
      val light = if(secondLight.isSecondEven)
        litLight
        else
        dimLight
      Console.YELLOW + light + Console.BLACK
    }

    def getHoursTopString(hourLights: HourLights): String = {
      Console.RED +
        (if(hourLights.top >= 1) litLight + litLight
        else dimLight+ dimLight) + " " +
        (if(hourLights.top >= 2) litLight + litLight
        else dimLight+ dimLight) + " " +
        (if(hourLights.top >= 3) litLight + litLight
        else dimLight+ dimLight) + " " +
        (if(hourLights.top >= 4) litLight + litLight
        else dimLight+ dimLight) +
      Console.BLACK
    }

    def getHoursBottomString(hourLights: HourLights): String = {
      Console.RED +
        (if(hourLights.bottom >= 1) litLight + litLight
        else dimLight+ dimLight) + " " +
        (if(hourLights.bottom >= 2) litLight + litLight
        else dimLight+ dimLight) + " " +
        (if(hourLights.bottom >= 3) litLight + litLight
        else dimLight+ dimLight) + " " +
        (if(hourLights.bottom >= 4) litLight + litLight
        else dimLight+ dimLight) +
        Console.BLACK
    }

    def getMinutesTopString(minuteLights: MinuteLights): String = {
      Console.YELLOW +
        (if(minuteLights.top >= 1) litLight
        else dimLight) +
        (if(minuteLights.top >= 2) litLight
        else dimLight) +
      Console.RED +
        (if(minuteLights.top >= 3) litLight
        else dimLight) +
      Console.YELLOW +
        (if(minuteLights.top >= 4) litLight
        else dimLight) +
        (if(minuteLights.top >= 5) litLight
        else dimLight) +
      Console.RED +
        (if(minuteLights.top >= 6) litLight
        else dimLight) +
      Console.YELLOW +
        (if(minuteLights.top >= 7) litLight
        else dimLight) +
        (if(minuteLights.top >= 8) litLight
        else dimLight) +
      Console.RED +
        (if(minuteLights.top >= 9) litLight
        else dimLight) +
      Console.YELLOW +
        (if(minuteLights.top >= 10) litLight
        else dimLight) +
        (if(minuteLights.top >= 11) litLight
        else dimLight) +
      Console.BLACK
    }

    def getMinutesBottomString(minutesLights: MinuteLights): String = {
      Console.YELLOW +
        (if(minutesLights.bottom >= 1) litLight + litLight
        else dimLight+ dimLight) + " " +
        (if(minutesLights.bottom >= 2) litLight + litLight
        else dimLight+ dimLight) + " " +
        (if(minutesLights.bottom >= 3) litLight + litLight
        else dimLight+ dimLight) + " " +
        (if(minutesLights.bottom >= 4) litLight + litLight
        else dimLight+ dimLight) +
        Console.BLACK
    }
  }

}
