/**
  * Created by jduan on 6/12/16.
  */
trait Event

trait UserEvent extends Event
trait SystemEvent extends Event
trait ApplicationEvent extends SystemEvent
trait ErrorEvent extends SystemEvent

trait Source[+Out] {
  def get(): Out
}

trait UserEventSource extends Source[UserEvent]
trait SystemEventSource extends Source[SystemEvent]

val ues = new UserEventSource {
  override def get(): UserEvent = ???
}

val ses = new SystemEventSource {
  override def get(): SystemEvent = ???
}

def forwardEventsComingFrom(source: Source[Event]): Unit = {
  source.get()
}

// covariance
forwardEventsComingFrom(ues)
forwardEventsComingFrom(ses)
