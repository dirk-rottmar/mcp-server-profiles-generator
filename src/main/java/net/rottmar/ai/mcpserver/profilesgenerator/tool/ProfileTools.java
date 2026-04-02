package net.rottmar.ai.mcpserver.profilesgenerator.tool;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import net.rottmar.ai.mcpserver.profilesgenerator.model.Profile;
import net.rottmar.ai.mcpserver.profilesgenerator.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProfileTools {

    private static final Logger log = LoggerFactory.getLogger(ProfileTools.class);
    private ProfileService profileService;

    public ProfileTools(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Tool(name="mcp-profiles-generator", description = "Load profiles")
    public List<Profile> loadProfiles() {
        return profileService.getProfiles();
    }

}
