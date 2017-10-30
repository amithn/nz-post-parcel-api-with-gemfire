import random
import datetime

tracking_reference = 1000000000
start_sqref = 1001897613

name = "John Owen"
signature = "/zwxQS1EK0YpSChMJU4jMUQvRS1IKkonTCROIVAeUxtUGVYWWBNZEFsOWxBZElcVVRdUGlEeTyJNJUspSS1HMUU1RDhDO0E9QEBAQj9DQUFDPkU7RzhJNko3SDpGPEU/Q0JBRUBIPks8TjtSOVQ3VzZZNls1XTVfNV43YDdjNmgzajNsMm8xcTBzMHYveC94MXczdjV5Nns2fTaANoI4hDiGN4g2ijWMNI8zkjKWMJouniyjKqgorSayJLciuyDAH8Qexx3KHcwdyx/IIcUiwCS7JrUoryqoLKAumDCRMok0gTV6N3I3bDhmOGE4XTdZN1c2VTRWMlgyWzFeMWEyZTNpNWw3cDl0PHc+ekF9RH9GgkmDS4ROhVCHUohUiVM="

num_events = 1000
event_desc = "event description"


code_list = list(range(2,100, 7))
source = ['CME', 'Navigator', 'IPS', 'ParcelStore', 'PSG']
status_description = ["Your item is currently with our courier for delivery.",
                      "Item has been sorted to a location in the depot",
                      "Item was identified as high value.",
                      "Your item was processed for delivery."]

# For num events to generate
# For each Tracking Ref
#    Generate Events based on a random number between 3 to 7
# 2015-06-24T10:05:13
start_date = "2017-10-01"
start_date = datetime.datetime.strptime(start_date, "%Y-%m-%d")

total_events = 0


for i in range(1, num_events):
    next_date = start_date
    tracking_reference += 1
    num_events_for_event = random.randint(3, 10)
    for j in range(1, num_events_for_event + 1):

        rand_hours = random.randint(1,24)
        rand_days = random.randint(1,5)
        rand_mins = random.randint(1,60)

        next_date = next_date + datetime.timedelta(days=rand_days, hours=rand_hours, minutes=rand_mins)

        code_idx = random.randint(1, len(code_list) -1)
        source_idx = random.randint(1, len(source) - 1)
        status_idx = random.randint(1, len(status_description) -1)

        start_sqref += 1

        if j == num_events_for_event -1:
            status_desc = "Out for Delivery"
        elif j == num_events_for_event:
            status_desc = 'Delivered'
        else:
            status_desc = status_description[status_idx]

        source_desc = source[source_idx]
        code = code_list[code_idx]

        total_events += 1

        print str(next_date) + "," + str(tracking_reference) + "," + str(start_sqref) + "," + source_desc + "," + str(code) + "," + event_desc + "," + status_desc + ", " + ", "







