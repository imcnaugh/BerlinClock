package com.scalaTest.berlinClock.service

import com.scalaTest.berlinClock.models.{BerlinClock, HourLights, MinuteLights, SecondLight}

class BerlinClockService {


  def getBerlinClockLights(time: String): BerlinClock = {
    val hour = 1 // parse hour
    val minitue = 1 //parse minitue
    val second = 1 // parse second


    BerlinClock(
      hourLights = getHourLights(hour),
      minuteLights = getMinitueLights(minitue),
      secondLight = getSecondLight(second)
    )
  }

  def getHourLights(hour: Int): HourLights = {
    HourLights(
      top = hour / 5,
      bottom = hour % 5
    )
  }

  def getMinitueLights(minitue: Int): MinuteLights = {
    MinuteLights(
      top = minitue / 5,
      bottom = minitue % 5
    )
  }

  def getSecondLight(second: Int): SecondLight = {
    SecondLight(
      isSecondEven = second % 2 == 0
    )
  }
}

object BerlinClockService {
  def apply(): BerlinClockService = new BerlinClockService
}