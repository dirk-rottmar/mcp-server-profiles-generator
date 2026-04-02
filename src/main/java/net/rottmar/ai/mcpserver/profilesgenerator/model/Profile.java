package net.rottmar.ai.mcpserver.profilesgenerator.model;

import java.util.List;

public record Profile (String lastName, String firstName, String birthDate, String position, Double hourlyRate, String entryDate, boolean isAvailable, List<String> specialities, List<String> techStack, String teaser) {
}
