package net.rottmar.ai.mcpserver.profilesgenerator.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import net.rottmar.ai.mcpserver.profilesgenerator.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {

    private static final Logger log = LoggerFactory.getLogger(ProfileService.class);
    private final ObjectMapper objectMapper;
    private List<Profile> profiles = new ArrayList<>();

    public ProfileService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    @PostConstruct
    public void init() throws IOException {
        log.info("Loading profiles");
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        this.profiles = objectMapper.readValue(
                getClass().getResourceAsStream("/profiles.json"),
                new TypeReference<List<Profile>>() {}
        );
    }
}
