package lt.asprogramuoju.refactoringkata.service;

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
    InventoryService inventoryService;

    @Scheduled(fixedRate = 10000)  // every 10 seconds
    public void makeDayPast() {
        this.jobUpdateQuality();
        log.info("The date is now {}", localDate.plusDays(++dayCount));
    }

    private void jobUpdateQuality() {
        inventoryService.updateQuality();
    }
}