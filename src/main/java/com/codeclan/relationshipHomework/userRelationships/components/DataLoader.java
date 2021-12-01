package com.codeclan.relationshipHomework.userRelationships.components;

import com.codeclan.relationshipHomework.userRelationships.models.File;
import com.codeclan.relationshipHomework.userRelationships.models.Folder;
import com.codeclan.relationshipHomework.userRelationships.models.User;
import com.codeclan.relationshipHomework.userRelationships.repositories.FileRepository;
import com.codeclan.relationshipHomework.userRelationships.repositories.FolderRepository;
import com.codeclan.relationshipHomework.userRelationships.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {

        User drew = new User("Drew");
        userRepository.save(drew);

        User gemma = new User("Gemma");
        userRepository.save(gemma);

        Folder documents = new Folder("Documents", drew);
        folderRepository.save(documents);

        Folder photos = new Folder("Photos", drew);
        folderRepository.save(photos);

        Folder downloads = new Folder("Downloads", drew);
        folderRepository.save(downloads);

        Folder documents2 = new Folder("Documents", gemma);
        folderRepository.save(documents2);

        File cat = new File("iCanHazCheezBurgir", "jpg", 256, photos);
        fileRepository.save(cat);

        File dog = new File("GivChimken", "png", 918, photos);
        fileRepository.save(dog);

        File cv = new File("CV", "pdf", 1028, documents);
        fileRepository.save(cv);

        File video = new File("Holiday2021", "mp4", 987099, downloads);
        fileRepository.save(video);

        File readMe = new File("README", "txt", 56, documents2);
        fileRepository.save(readMe);


        drew.addFolder(documents);
        drew.addFolder(photos);
        drew.addFolder(downloads);
        userRepository.save(drew);

        gemma.addFolder(documents2);
        userRepository.save(gemma);

        documents.addFile(cv);
        folderRepository.save(documents);
        photos.addFile(cat);
        photos.addFile(dog);
        folderRepository.save(photos);
        downloads.addFile(video);
        folderRepository.save(downloads);

        documents2.addFile(readMe);
        folderRepository.save(documents2);

    }
}
