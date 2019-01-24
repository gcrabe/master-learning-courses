package ru.batyrev.musicstorageimpl.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.batyrev.musicstorageimpl.data.model.SystemResponse;
import ru.batyrev.musicstorageimpl.data.repository.FullDataRepository;

import java.util.List;

@RestController
@RequestMapping("/clear-all")
public class ClearController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClearController.class);

    @Autowired
    List<FullDataRepository> fullDataRepositoryList;

    @RequestMapping
    public SystemResponse index() {
        LOGGER.info("ClearController run.");
        fullDataRepositoryList.forEach(FullDataRepository::deleteAll);
        return new SystemResponse("Database was cleared!");
    }
}
