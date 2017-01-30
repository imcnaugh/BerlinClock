package com.scalaTest.berlinClock

import com.scalaTest.berlinClock.exceptions.{SecondOutOfBoundsException, MinuteOutOfBoundsException, HourOutOfBoundsException}
import com.scalaTest.berlinClock.utility.BerlinClockHelperImpl
import org.scalatest.{FunSpec, Matchers}

class BerlinClockHelperImplTest extends FunSpec with Matchers {

  private class BerlinClockHelperImplTest {
    self: BerlinClockHelperImpl =>
  }

  private val target = new BerlinClockHelperImplTest with BerlinClockHelperImpl

  describe("Hour Light tests") {
    it("should return no lights for hour 0") {
      val lights = target.berlinClockHelper.getHourLights(0)
      lights.top should equal(0)
      lights.bottom should equal(0)
    }
    it("should return correct lights for hour 23") {
      val lights = target.berlinClockHelper.getHourLights(23)
      lights.top should equal(4)
      lights.bottom should equal(3)
    }
    it("should return 3 lights on top for hour 15"){
      val lights = target.berlinClockHelper.getHourLights(15)
      lights.top should equal (3)
      lights.bottom should equal (0)
    }
    it("should return 3 lights on bottom for hour 3"){
      val lights = target.berlinClockHelper.getHourLights(3)
      lights.top should equal (0)
      lights.bottom should equal (3)
    }
    it("should throw exception if a negetive hour is given"){
      an [HourOutOfBoundsException] should be thrownBy target.berlinClockHelper.getHourLights(-5)
    }
    it("should throw exception if hour over 24 is given"){
      an [HourOutOfBoundsException] should be thrownBy target.berlinClockHelper.getHourLights(24)
    }
  }

  describe("Minitue Light Tests"){
    it("should return no lights for minitue 0"){
      val lights = target.berlinClockHelper.getMinitueLights(0)
      lights.top should equal (0)
      lights.bottom should equal (0)
    }
    it("should return all lights for minitue 59"){
      val lights = target.berlinClockHelper.getMinitueLights(59)
      lights.top should equal (11)
      lights.bottom should equal (4)
    }
    it("should only return top lights for minitue 55"){
      val lights = target.berlinClockHelper.getMinitueLights(55)
      lights.top should equal (11)
      lights.bottom should equal (0)
    }
    it("should only return bottom lights for minitue 4"){
      val lights = target.berlinClockHelper.getMinitueLights(4)
      lights.top should equal (0)
      lights.bottom should equal (4)
    }
    it("should return proper lights for minitue 33"){
      val lights = target.berlinClockHelper.getMinitueLights(33)
      lights.top should equal (6)
      lights.bottom should equal (3)
    }
    it("should throw an exception if negetive minitues are given"){
      an [MinuteOutOfBoundsException] should be thrownBy target.berlinClockHelper.getMinitueLights(-1)
    }
    it("should throw an exception if minitue over 59 is given"){
      an [MinuteOutOfBoundsException] should be thrownBy target.berlinClockHelper.getMinitueLights(60)
    }
  }

  describe("Second light tests"){
    it("should return true when second is even"){
      val light = target.berlinClockHelper.getSecondLight(2)
      light.isSecondEven should equal (true)
    }
    it("should return false when second is odd"){
      val light = target.berlinClockHelper.getSecondLight(55)
      light.isSecondEven should be (false)
    }
    it("should throw an exception if negetive second is given"){
      an [SecondOutOfBoundsException] should be thrownBy target.berlinClockHelper.getSecondLight(-1)
    }
    it("should throw an exception if second over 59 is given"){
      an [SecondOutOfBoundsException] should be thrownBy target.berlinClockHelper.getSecondLight(60)
    }
  }
}
