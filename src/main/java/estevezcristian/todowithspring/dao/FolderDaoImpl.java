package estevezcristian.todowithspring.dao;

import estevezcristian.todowithspring.models.Folder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class FolderDaoImpl implements FolderDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Folder> getFolders() {
        String query = "FROM Folder";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteFolder(Long id) {
        Folder folder = entityManager.find(Folder.class, id);
        entityManager.remove(folder);
    }

    @Override
    public void createFolder(Folder folder) {
        entityManager.merge(folder);
    }
}
