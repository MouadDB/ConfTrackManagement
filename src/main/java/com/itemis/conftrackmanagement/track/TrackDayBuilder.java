package com.itemis.conftrackmanagement.track;

import com.itemis.conftrackmanagement.session.Session;
import com.itemis.conftrackmanagement.talk.Talk;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mouad Douieb
 */
public class TrackDayBuilder {
    
    /**
     * Build the track
     * 
     * @param talks
     * @return 
     */
    public List<TrackDay> build(List<Talk> talks) {

        List<TrackDay> trackDays = new ArrayList<>();

        // Sort talks descending by duration
        List<Talk> orderedTalks = talks.stream().sorted(Comparator.comparing(s -> s.getDuration(), Comparator.reverseOrder())).collect(Collectors.toList());

        int trackNumber = 0;

        while (!orderedTalks.isEmpty()) {

            trackNumber++;

            TrackDay day = new TrackDay("" + trackNumber);

            boolean morning = true;

            do {
                Session session;

                session = (morning == true) ? (Session) day.getMorning() : (Session) day.getAfternoon();

                this.fillSlots(orderedTalks, session, false);

                morning = !morning;
            } while (!morning);
            trackDays.add(day);

            int durationSum = 0;
            int trackDaysMinutes = 0;

            durationSum = orderedTalks.stream().map((orderedTalk) -> orderedTalk.getDuration()).reduce(durationSum, Integer::sum);

            // 
            trackDaysMinutes = trackDays.stream().map((trackDay) -> trackDay.getAfternoon().calculatedAvailableMinutes(true)).reduce(trackDaysMinutes, Integer::sum);

            if (durationSum <= trackDaysMinutes) {
                trackDays.forEach((trackDay) -> {
                    this.fillSlots(orderedTalks, trackDay.getAfternoon(), true);
                });
            }
        }

        return trackDays;
    }
    
    /**
     * Fill slots with a specific session
     * 
     * @param orderedTalks
     * @param session
     * @param extended 
     */
    private void fillSlots(List<Talk> orderedTalks, Session session, boolean extended) {

        while ((orderedTalks.size() > 0) && session.addTalk(orderedTalks.get(0), extended)) {
            orderedTalks.remove(0);
        }

        while (session.calculatedAvailableMinutes(extended) > 0) {

            List<Talk> equalLessTime = orderedTalks.stream().filter(t -> t.getDuration() == session.calculatedAvailableMinutes(extended)).collect(Collectors.toList());
            if (equalLessTime.isEmpty()) {
                equalLessTime = orderedTalks.stream().filter(x -> x.getDuration() < session.calculatedAvailableMinutes(extended)).collect(Collectors.toList());
            }

            if (!equalLessTime.isEmpty()) {
                session.addTalk(equalLessTime.get(0), extended);
                orderedTalks.remove(equalLessTime.get(0));
            } else {
                break;
            }
        }
    }
}
