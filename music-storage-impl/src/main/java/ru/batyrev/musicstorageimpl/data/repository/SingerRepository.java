package ru.batyrev.musicstorageimpl.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.batyrev.musicstorageimpl.data.model.Album;
import ru.batyrev.musicstorageimpl.data.model.Singer;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "singers", path = "singers")
public interface SingerRepository extends CrudRepository<Singer, Long>, PagingAndSortingRepository<Singer, Long>,FullDataRepository {

    @RestResource(path = "/alias")
    List<Singer> findAllByAliasLike(@Param("alias") String alias);
}
