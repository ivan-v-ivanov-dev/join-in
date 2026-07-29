package com.joinin.post.mapper;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class PostedAgoFormatter {

    public String calculatePostedAgo(LocalDateTime createdAt) {
        if (createdAt == null) {
            return null;
        }

        LocalDateTime now = LocalDateTime.now();

        // Protect against timestamps accidentally stored in the future.
        if (createdAt.isAfter(now)) {
            return "just now";
        }

        Duration elapsed = Duration.between(createdAt, now);

        if (elapsed.compareTo(Duration.ofMinutes(1)) < 0) {
            return "just now";
        }

        if (elapsed.compareTo(Duration.ofMinutes(5)) < 0) {
            return "1 min";
        }

        if (elapsed.compareTo(Duration.ofMinutes(15)) < 0) {
            return "5 min";
        }

        if (elapsed.compareTo(Duration.ofMinutes(30)) < 0) {
            return "15 min";
        }

        if (elapsed.compareTo(Duration.ofHours(1)) < 0) {
            return "30 min";
        }

        if (elapsed.compareTo(Duration.ofHours(3)) < 0) {
            return "1 h";
        }

        if (elapsed.compareTo(Duration.ofHours(5)) < 0) {
            return "3 h";
        }

        if (elapsed.compareTo(Duration.ofHours(10)) < 0) {
            return "5 h";
        }

        if (elapsed.compareTo(Duration.ofDays(1)) < 0) {
            return "10 h";
        }

        if (elapsed.compareTo(Duration.ofDays(2)) < 0) {
            return "1 day";
        }

        if (elapsed.compareTo(Duration.ofDays(3)) < 0) {
            return "2 days";
        }

        if (elapsed.compareTo(Duration.ofDays(5)) < 0) {
            return "3 days";
        }

        if (elapsed.compareTo(Duration.ofDays(7)) < 0) {
            return "5 days";
        }

        if (elapsed.compareTo(Duration.ofDays(10)) < 0) {
            return "1 week";
        }

        if (elapsed.compareTo(Duration.ofDays(14)) < 0) {
            return "10 days";
        }

        if (elapsed.compareTo(Duration.ofDays(21)) < 0) {
            return "2 weeks";
        }

        if (createdAt.isAfter(now.minusMonths(1))) {
            return "3 weeks";
        }

        if (createdAt.isAfter(now.minusMonths(2))) {
            return "1 month";
        }

        if (createdAt.isAfter(now.minusMonths(3))) {
            return "2 months";
        }

        if (createdAt.isAfter(now.minusMonths(4))) {
            return "3 months";
        }

        if (createdAt.isAfter(now.minusMonths(5))) {
            return "4 months";
        }

        return "5 months";
    }
}
