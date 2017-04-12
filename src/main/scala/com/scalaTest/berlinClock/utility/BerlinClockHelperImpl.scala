package com.scalaTest.berlinClock.utility

import java.time.LocalTime

import com.scalaTest.berlinClock.exceptions.{HourOutOfBoundsException, MinuteOutOfBoundsException, SecondOutOfBoundsException}
import com.scalaTest.berlinClock.models.{BerlinClock, HourLights, MinuteLights, SecondLight}

trait BerlinClockHelperImpl extends BerlinClockHelper {
  override val berlinClockHelper = new BerlinClockHelperImpl()

  class BerlinClockHelperImpl extends berlinClockHelper {
    def getBerlinClockLights(hour: Int,
                             minitue: Int,
                             second: Int): BerlinClock = {
      BerlinClock(
        hourLights = getHourLights(hour),
        minuteLights = getMinuteLights(minitue),
        secondLight = getSecondLight(second)
      )
    }

    def getBerlinClockLights(time: LocalTime): BerlinClock = {
      BerlinClock(
        hourLights = getHourLights(time.getHour),
        minuteLights = getMinuteLights(time.getMinute),
        secondLight = getSecondLight(time.getSecond)
      )
    }

    def getHourLights(hour: Int): HourLights = {
      if (hour < 0 || hour > 23)
        throw new HourOutOfBoundsException

      HourLights(
        top = hour / 5,
        bottom = hour % 5
      )
    }

    def getMinuteLights(minute: Int): MinuteLights = {
      if (minute < 0 || minute > 59)
        throw new MinuteOutOfBoundsException

      MinuteLights(
        top = minute / 5,
        bottom = minute % 5
      )
    }

    def getSecondLight(second: Int): SecondLight = {
      if (second < 0 || second > 59)
        throw new SecondOutOfBoundsException

      SecondLight(
        isSecondEven = second % 2 == 0
      )
    }
  }

}
