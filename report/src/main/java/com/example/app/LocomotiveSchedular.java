package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.model.LocomotiveSummary;
import com.example.repository.mongodb.LocomotiveRepository;
import com.example.repository.postgres.LocomotiveSummaryRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LocomotiveSchedular {

        @Autowired
        private LocomotiveRepository locomotiveRepository;

        @Autowired
        private LocomotiveSummaryRepository locomotiveSummaryRepository;

        @Autowired
        private TelegramBot telegramBot;

        @Scheduled(fixedDelay = 10000)
        public void scheduler() {
                locomotiveSummaryRepository.deleteAll();

                int totalLocomotif = (int) locomotiveRepository.count();
                int totalPoorLocomotif = (int) locomotiveRepository.countByStatus("Poor");
                int totalGoodLocomotif = (int) locomotiveRepository.countByStatus("Good");
                int totalExcellentLocomotif = (int) locomotiveRepository.countByStatus("Excellent");

                LocomotiveSummary locomotifSummary = LocomotiveSummary.builder()
                                .totalLocomotif(totalLocomotif)
                                .totalLocomotifPoor(totalPoorLocomotif)
                                .totalLocomotifGood(totalGoodLocomotif)
                                .totalLocomotifExcellent(totalExcellentLocomotif)
                                .build();

                locomotiveSummaryRepository.save(locomotifSummary);

                log.info("Update Summary");
                telegramBot.sendTextMessage("5767986311",
                                String.format("""
                                                <====> Locomtif Summary <====>

                                                Total Locomotif = %d
                                                Total Poor Locomotif = %d
                                                Total Good Locomotif = %d
                                                Total Excellent Locomotif = %d
                                                """, totalLocomotif, totalPoorLocomotif, totalGoodLocomotif,
                                                totalExcellentLocomotif));
        }
}