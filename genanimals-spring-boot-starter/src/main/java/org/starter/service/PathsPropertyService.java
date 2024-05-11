package org.starter.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class PathsPropertyService {
    @Value("${secret-store.path}")
    private String secretPath;
}
