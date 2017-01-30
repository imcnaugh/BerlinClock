package com.scalaTest.berlinClock.utility

import com.scalaTest.berlinClock.models.{BerlinClock, HourLights, MinuteLights, SecondLight}

trait BerlinClockHelper {
  def berlinClockHelper: berlinClockHelper

  trait berlinClockHelper {
    def getBerlinClockLights(time: String): BerlinClock
    def getHourLights(hour: Int): HourLights
    def getMinitueLights(minitue: Int): MinuteLights
    def getSecondLight(second: Int): SecondLight
  }

}
