package com.scalaTest.berlinClock

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

    it("should return all lights for hour 24") {
      val lights = target.berlinClockHelper.getHourLights(24)

      lights.top should equal(4)
      lights.bottom should equal(4)
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
  }

  describe("Minitue Light Tests"){

  }

}
