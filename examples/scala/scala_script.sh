#!/bin/sh
exec scala "$0" "$@"
!#
object HiScript extends App {
  println("Hi Scala script")
}
HelloWorld.main(args)