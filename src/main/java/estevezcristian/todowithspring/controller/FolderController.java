package estevezcristian.todowithspring.controller;

import estevezcristian.todowithspring.dao.FolderDao;
import estevezcristian.todowithspring.models.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FolderController {

    @Autowired
    private FolderDao folderDao;

    @RequestMapping(value = "api/folder-list/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Folder> getFolders(){
        return folderDao.getFolders();
    }

    @RequestMapping(value = "/api/folder-create", method = RequestMethod.POST)
    public void createFolder(@RequestBody Folder folder) {
        folderDao.createFolder(folder);
    }

    @RequestMapping(value = "api/folder-delete/{id}", method = RequestMethod.DELETE)
    public void deleteFolder(@PathVariable Long id){
        folderDao.deleteFolder(id);
    }
}
