package estevezcristian.todowithspring.dao;

import estevezcristian.todowithspring.models.Folder;
import java.util.List;

public interface FolderDao {

    List<Folder> getFolders();

    void deleteFolder(Long id);

    void createFolder(Folder folder);
}
