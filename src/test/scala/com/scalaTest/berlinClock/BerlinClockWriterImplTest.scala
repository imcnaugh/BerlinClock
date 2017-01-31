package com.scalaTest.berlinClock

import com.scalaTest.berlinClock.models.{BerlinClock, HourLights, MinuteLights, SecondLight}
import com.scalaTest.berlinClock.utility.BerlinClockWriterImpl
import org.scalatest.{FunSpec, Matchers}

class BerlinClockWriterImplTest extends FunSpec with Matchers {

  private class BerlinClockWriterImplTest {
    self: BerlinClockWriterImpl =>
  }

  private val target = new BerlinClockWriterImplTest with BerlinClockWriterImpl

  val litLight = "\u25AE"
  val dimLight = "\u25AF"

  val yellow = Console.YELLOW
  val red = Console.RED
  val black = Console.BLACK

  private val defaultClock = BerlinClock(hourLights = HourLights(
      top = 0,
      bottom = 0
    ), minuteLights = MinuteLights(
      top = 0,
      bottom = 0
    ), secondLight = SecondLight(
      isSecondEven = true))

  describe("Second light tests"){
    it("Should return a lit light when second is even"){
      val secondLight = SecondLight(isSecondEven = true)
      val s = target.berlinClockWriter.getSecondsString(secondLight)
      s should equal (yellow + litLight + black)
    }
    it("Should return a dim light when second is odd"){
      val secondLight = SecondLight(isSecondEven = false)
      val s = target.berlinClockWriter.getSecondsString(secondLight)
      s should equal (yellow + dimLight + black)
    }
  }

  describe("Hour top lights test"){
    it("Should return all dim lights when top hour is 0"){
      val hourLights = HourLights(top = 0, bottom = 0)
      val s = target.berlinClockWriter.getHoursTopString(hourLights)
      s should equal (red + dimLight + dimLight + " " +
                            dimLight + dimLight + " " +
                            dimLight + dimLight + " " +
                            dimLight + dimLight + black)
    }

    it("Should return all lit lights when top hour is 4"){
      val hourLights = HourLights(top = 4, bottom = 0)
      val s = target.berlinClockWriter.getHoursTopString(hourLights)
      s should equal (red + litLight + litLight + " " +
                            litLight + litLight + " " +
                            litLight + litLight + " " +
                            litLight + litLight + black)
    }

    it("Should return 2 lit lights when top hour is 2"){
      val hourLights = HourLights(top = 2, bottom = 0)
      val s = target.berlinClockWriter.getHoursTopString(hourLights)
      s should equal (red + litLight + litLight + " " +
                            litLight + litLight + " " +
                            dimLight + dimLight + " " +
                            dimLight + dimLight + black)
    }
  }

  describe("Hour bottom lights test"){
    it("Should return all dim lights when bottom hour is 0"){
      val hourLights = HourLights(top = 0, bottom = 0)
      val s = target.berlinClockWriter.getHoursBottomString(hourLights)
      s should equal (red + dimLight + dimLight + " " +
        dimLight + dimLight + " " +
        dimLight + dimLight + " " +
        dimLight + dimLight + black)
    }

    it("Should return all lit lights when bottom hour is 4"){
      val hourLights = HourLights(top = 0, bottom = 4)
      val s = target.berlinClockWriter.getHoursBottomString(hourLights)
      s should equal (red + litLight + litLight + " " +
        litLight + litLight + " " +
        litLight + litLight + " " +
        litLight + litLight + black)
    }

    it("Should return 2 lit lights when bottom hour is 2"){
      val hourLights = HourLights(top = 0, bottom = 2)
      val s = target.berlinClockWriter.getHoursBottomString(hourLights)
      s should equal (red + litLight + litLight + " " +
        litLight + litLight + " " +
        dimLight + dimLight + " " +
        dimLight + dimLight + black)
    }
  }

  describe("Minute top lights test"){
    it("Should return all dim lights when top minute is 0"){
      val minuteLights = MinuteLights(top = 0, bottom = 0)
      val s = target.berlinClockWriter.getMinutesTopString(minuteLights)
      s should equal (yellow + dimLight + dimLight +
        red + dimLight +
        yellow + dimLight+ dimLight +
        red + dimLight +
        yellow + dimLight + dimLight +
        red + dimLight +
        yellow + dimLight + dimLight + black)
    }
    it("Should return all lit lights when top minute is 11"){
      val minuteLights = MinuteLights(top = 11, bottom = 0)
      val s = target.berlinClockWriter.getMinutesTopString(minuteLights)
      s should equal (yellow + litLight + litLight +
        red + litLight +
        yellow + litLight + litLight +
        red + litLight +
        yellow + litLight + litLight +
        red + litLight +
        yellow + litLight + litLight + black)
    }
    it("Should return 6 lit lights when top minute is 6"){
      val minuteLights = MinuteLights(top = 6, bottom = 0)
      val s = target.berlinClockWriter.getMinutesTopString(minuteLights)
      s should equal (yellow + litLight + litLight +
        red + litLight +
        yellow + litLight + litLight +
        red + litLight +
        yellow + dimLight + dimLight +
        red + dimLight +
        yellow + dimLight + dimLight + black)
    }
  }

  describe("Minute bottom lights test"){
    it("Should return all dim lights when bottom minute is 0"){
      val minuteLights = MinuteLights(top = 0, bottom = 0)
      val s = target.berlinClockWriter.getMinutesBottomString(minuteLights)
      s should equal (yellow + dimLight + dimLight + " " +
        dimLight + dimLight + " " +
        dimLight + dimLight + " " +
        dimLight + dimLight + black)
    }

    it("Should return all lit lights when bottom minute is 4"){
      val minuteLights = MinuteLights(top = 0, bottom = 4)
      val s = target.berlinClockWriter.getMinutesBottomString(minuteLights)
      s should equal (yellow + litLight + litLight + " " +
        litLight + litLight + " " +
        litLight + litLight + " " +
        litLight + litLight + black)
    }

    it("Should return 2 lit lights when bottom minute is 2"){
      val minuteLights = MinuteLights(top = 0, bottom = 2)
      val s = target.berlinClockWriter.getMinutesBottomString(minuteLights)
      s should equal (yellow + litLight + litLight + " " +
        litLight + litLight + " " +
        dimLight + dimLight + " " +
        dimLight + dimLight + black)
    }
  }
}
