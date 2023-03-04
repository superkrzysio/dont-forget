# Don't forget

This application shows a big tiles about incoming deadlines. It's meant to be displayed constantly on some screen at home to have a quick glance on incoming important dates - simply an information radiator to make you not forget.

Take your time, fulfill the task whenever you want, but the big red button will remind you in your home's corridor, so that you don't forget.

It may duplicate with your google calendar or work calendar, but it's not a 1000th notification on your phone that you can ignore when in uncomfortable moment or just accidentaly. You won't forget.

### Features:

- one-time events
- recurring rules - events will be created from a recurring template
- recurring rules can additionally create a forecast event (useful for anniversaries)
- forecast events - will show as neutral (white) boxes to acknowledge you of incoming event much earlier
  (e.g. incoming friend's birthday to let you start thinking of a gift)  
- events will show as a green tile if the deadline is away
- tile will turn red when it's the deadline
- you can postpone the event by few days
- one-click to mark as completed
- host in your LAN and open on your wall screen as web page
- create events on your computer or tablet
- no integration with other calendars - input your most important events, anniversaries, 
  payments, other deadlines manually
- it makes you not forget of these important deadlines

### Requirements

- Tablet view allows you to check the tasks on the tablet (or other wall screen) and do simplest task management.
- Full management available on computer view
- Avoid using screen keyboard completely

#### Tablet view - event grid

- Shows tiles sorted by due date
- Every event has its due date
- Colors: white (forecast), green, yellow (~2 days left), red (due date already!). Optional: sound alerts
- Forecast will always remain white, even if you hit the deadline. It just shows and stays. 
  Tick it to acknowledge.
- Can mark event as completed
- There are recurring event rules, not recurring events!  Technically the events are created based on the recurring rule, e.g. cronjob.
- Page refreshes once a day (in the early morning, but after executing the cronjob), plus on every interaction, manual refresh possible.
- Can view history and revert task completion - the event instance is restored.
- View can be filtered to several days only (so that you don't see event instances a year away). 
  Filter can be configurable on the tablet view using logarithmic scrollbar (no keyboard!)
  or on edit view.
- The above filter does not affect forecast events.

#### Tablet view - single event

- More info visible (description)
- Option to postpone by a few days (use clickable icons, e.g. +1, +2, +3, not keyboard input)

#### Computer view - management

- Can add/edit one-time events
  - Can also create forecast event n days before
- Can add/edit recurring rules
    - Every n days
    - On n-th day of the month (multiple days)
    - On n-th day of the year (multiple days)
    - Notification rules (when to create event (default: 7 days before deadline), when yellow (default: 2 days before deadline) when red (default: 0 days before deadline))
    - Can additionally create a forecast event n days before
- Editing a recurring rule does not impact existing event instances (rule = template, event = instance with deadline), instances must be edited on their own
