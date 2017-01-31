package com.scalaTest.berlinClock.utility

import com.scalaTest.berlinClock.models.BerlinClock

trait BerlinClockWriter {
  def berlinClockWriter: berlinClockWriter

  trait berlinClockWriter {
    def getStringForClock(clock: BerlinClock): String
  }

}
