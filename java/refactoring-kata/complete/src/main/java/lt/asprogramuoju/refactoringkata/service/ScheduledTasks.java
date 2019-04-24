package lt.asprogramuoju.refactoringkata.service;

import lt.asprogramuoju.refactoringkata.controller.ItemController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");

    private LocalDate localDate = LocalDate.now();
    private int dayCount;

    @Autowired
    ItemController controller;

    @Scheduled(fixedRate = 5000)  // every 5 seconds
    public void makeDayPast() {
        controller.updateAllItemQuality();
        log.info("The date is now {}", localDate.plusDays(++dayCount));
    }
}