package com.vich.chatitc.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ConfigurationProperties(prefix = "chatitc")
@Data
public class AppConfiguration {

    String uploadPath;

    String profileImagesFolder = "profile";

    String attachmentsFolder = "attachments";

    public String getFullProfileImagesPath() {
        return this.uploadPath + "/" + this.profileImagesFolder;
    }

    public String getFullAttachmentsPath() {
        return this.uploadPath + "/" + this.attachmentsFolder;
    }
}
