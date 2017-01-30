package com.scalaTest.berlinClock

import com.scalaTest.berlinClock.service.BerlinClockService

class TestMain {

  def test(): Unit = {
    val berlinClockService = BerlinClockService()

    val hourLights = berlinClockService.getHourLights(24)

    System.out.println("hour lights")
    System.out.println(hourLights.top)
    System.out.println(hourLights.bottom)
  }

}

object TestMain{
  def main(args: Array[String]): Unit = {
    TestMain().test
  }

  def apply(): TestMain = new TestMain
}
