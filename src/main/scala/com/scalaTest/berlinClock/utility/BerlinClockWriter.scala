package com.scalaTest.berlinClock.utility

import com.scalaTest.berlinClock.models.{MinuteLights, HourLights, SecondLight, BerlinClock}

trait BerlinClockWriter {
  def berlinClockWriter: berlinClockWriter

  trait berlinClockWriter {
    def getStringForClock(clock: BerlinClock): String
    def getSecondsString(secondLight: SecondLight): String
    def getHoursTopString(hourLights: HourLights): String
    def getHoursBottomString(hourLights: HourLights): String
    def getMinutesTopString(minuteLights: MinuteLights): String
    def getMinutesBottomString(minutesLights: MinuteLights): String
  }

}
