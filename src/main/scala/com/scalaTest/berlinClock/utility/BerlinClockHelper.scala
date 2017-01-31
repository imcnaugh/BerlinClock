package com.scalaTest.berlinClock.utility

import java.time.LocalTime

import com.scalaTest.berlinClock.models.{BerlinClock, HourLights, MinuteLights, SecondLight}

trait BerlinClockHelper {
  def berlinClockHelper: berlinClockHelper

  trait berlinClockHelper {
    def getBerlinClockLights(hour: Int = 0, minitue: Int = 0, second: Int = 0): BerlinClock
    def getBerlinClockLights(time: LocalTime): BerlinClock
    def getHourLights(hour: Int): HourLights
    def getMinitueLights(minitue: Int): MinuteLights
    def getSecondLight(second: Int): SecondLight
  }

}
