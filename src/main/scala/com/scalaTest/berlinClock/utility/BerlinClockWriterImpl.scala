package com.scalaTest.berlinClock.utility

import com.scalaTest.berlinClock.models.BerlinClock

trait BerlinClockWriterImpl extends BerlinClockWriter {
  val berlinClockWriter = new BerlinClockWriterImpl()

  class BerlinClockWriterImpl{
    def getStringForClock(clock: BerlinClock): String = {
      "+===========+\n"+
      "|     " + getSecondsString(clock.secondLight.isSecondEven) + "     |"
    }

    private def getSecondsString(isSecondsLit: Boolean): String = {
      val color = if(isSecondsLit)
        Console.YELLOW
        else
        Console.BLUE

      color + "\u9724" + Console.BLACK
    }
  }

}
