
1) Suppose we want to maintain a history of the hardware checkouts. Describe thoroughly the
modifications to the Team Project Code in order to track the history of hardware checkouts,
referencing both the front-end and the back-end changes.
	
- To maintain a history of hardware checkouts, we would add a checkout_history array to the hardware schema in models/hardware.py, where each entry stores details such as userId, projectId, hardwareId, and checkout_time. In routes/hardware.py, the checkout_hardware() function would be updated to append a new history entry after decrementing availability, and the checkin_hardware() function would optionally add a corresponding checkin_time for completeness. These changes would be persisted in MongoDB using an update_one with $push on the hardware document. On the frontend, in HardwareOverview.js, we would extend the data fetch (for example, GET /hardware/:id) to include the checkout_history field and render it in a table with columns for User, Project, and Time. We would also add loading and error states and ensure the table updates after checkout or check‑in by refetching or invalidating the cache, giving users a clear and persistent log of all hardware checkout events.

	
(2) Suppose we would like to track the duration of time for which hardware is checked out.
Describe thoroughly the modifications to the Team Project Code to do this, referencing both
the front-end and the back-end changes.
	
(3) Suppose now we would like to (a) charge users for checking out hardware for a duration of
time and (b) automatically check in all checked out hardware after a certain duration of time.
Describe thoroughly the modifications to the Team Project Code to do this, referencing both
the front-end and the back-end changes.

