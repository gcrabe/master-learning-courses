package ru.batyrev.musicstorageimpl.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.batyrev.musicstorageimpl.data.model.Song;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "songs", path = "songs")
public interface SongRepository extends CrudRepository<Song, Long>, PagingAndSortingRepository<Song, Long>, FullDataRepository {

    @RestResource(path = "/title")
    List<Song> findAllByTitleLike(@Param("title") String title);

    @RestResource(path = "/albumId")
    List<Song> findAllByAlbum_Id(@Param("albumId") Long albumId);

    @RestResource(path = "/albumTitle")
    List<Song> findAllByAlbum_Title(@Param("albumTitle") String albumTitle);
}
