package net.rottmar.ai.mcpserver.profilesgenerator;

import net.rottmar.ai.mcpserver.profilesgenerator.tool.ProfileTools;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProfilesGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilesGeneratorApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider profileToolCallbackProvider(ProfileTools profileTools) {
		return MethodToolCallbackProvider.builder()
				.toolObjects(profileTools)
				.build();
	}

}
