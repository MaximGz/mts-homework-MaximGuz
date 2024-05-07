package org.starter.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Data
public class NamesListService {
    @Value("#{'${animal.cat.names}'.split(';')}")
    private List<String> catNames;
    @Value("#{'${animal.dog.names}'.split(';')}")
    private List<String> dogNames;
    @Value("#{'${animal.cow.names}'.split(';')}")
    private List<String> cowNames;
    @Value("#{'${animal.shark.names}'.split(';')}")
    private List<String> sharkNames;
    @Value("#{'${animal.wolf.names}'.split(';')}")
    private List<String> wolfNames;
    @Value("#{'${animal.lion.names}'.split(';')}")
    private List<String> lionNames;
}
