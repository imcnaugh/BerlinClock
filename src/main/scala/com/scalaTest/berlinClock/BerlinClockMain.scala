package com.scalaTest.berlinClock

import java.time.LocalTime

import com.scalaTest.berlinClock.exceptions.{SecondOutOfBoundsException, MinuteOutOfBoundsException, HourOutOfBoundsException}
import com.scalaTest.berlinClock.utility.{BerlinClockWriterImpl, BerlinClockHelperImpl, BerlinClockWriter, BerlinClockHelper}

class BerlinClockMain{
  this: BerlinClockHelper with BerlinClockWriter =>

  def start(): Unit = {
    System.out.println("Welcome to the scala skills test, Berlin clock")
    System.out.println("You will be asked for 3 inputs, an hour, minute, and second (as integers)")
    System.out.println("Or you can simply type 'now' to use the current time")
    System.out.println()
    System.out.println("Hour (or type 'now'): ")
    val hour = Console.readLine()
    hour match{
      case "now" => System.out.println(printCurrentTime())
      case _ => System.out.println(createClockFromMinuteAndSecond(hour))
    }

  }

  private def printCurrentTime(): String = {
    val clock = berlinClockHelper.getBerlinClockLights(LocalTime.now())
    "Here the the Berlin clock for the current time\n" +
    berlinClockWriter.getStringForClock(clock)
  }

  private def createClockFromMinuteAndSecond(hourString: String): String ={
    val hour = hourString.toInt
    System.out.println("Minute: ")
    val minute = Console.readInt()
    System.out.println("Second: ")
    val second = Console.readInt()

    try{
      val clock = berlinClockHelper.getBerlinClockLights(hour, minute,second)

      "For the time " + hour + ":" + minute + ":" + second + " the Berlin clock looks like this\n" +
        berlinClockWriter.getStringForClock(clock)
    }catch {
      case e: HourOutOfBoundsException => {
        "Hour must be within the range 0-23"
      }
      case e: MinuteOutOfBoundsException => {
        "Minute must be within range 0-59"
      }
      case e: SecondOutOfBoundsException => {
        "Second bust be within range 0-59"
      }
      case e: Exception => {
        "an exception has occured, this should never happen"
      }
    }
  }
}

object BerlinClockMain{
  def main(args: Array[String]): Unit = {
    BerlinClockMain().start()
  }

  def apply(): BerlinClockMain = new BerlinClockMain with BerlinClockHelperImpl with BerlinClockWriterImpl
}
