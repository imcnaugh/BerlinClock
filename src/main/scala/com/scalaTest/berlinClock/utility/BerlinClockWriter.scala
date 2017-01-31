package com.scalaTest.berlinClock.utility

import com.scalaTest.berlinClock.models.{MinuteLights, HourLights, SecondLight, BerlinClock}

trait BerlinClockWriter {
  def berlinClockWriter: berlinClockWriter

  trait berlinClockWriter {
    def getStringForClock(clock: BerlinClock): String
    def getSecondsString(secondLight: SecondLight): String
    def getHoursTopString(hourLights: HourLights): String
    def getHoursBottomString(hourLights: HourLights): String
    def getMinituesTopString(minuteLights: MinuteLights): String
    def getMinituesBottomString(minituesLights: MinuteLights): String
  }

}
