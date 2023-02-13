package com.customerarchive.service.Impl;

import com.customerarchive.exception.ResourceNotFoundExeption;
import com.customerarchive.model.File;
import com.customerarchive.repository.FileRepository;
import com.customerarchive.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceımpl implements FileService {

    private FileRepository fileRepository;

    @Autowired
    public FileServiceımpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    @Override
    public File saveFile(File file) {
        return fileRepository.save(file);
    }

    @Override
    public File updateFile(File file, Long id) {
        File existFile =fileRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundExeption("File","id","id",id));

        existFile.setFileName(file.getFileName());
        fileRepository.save(existFile);

        return existFile;
    }

    @Override
    public void deleteFile(Long id) {
        fileRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundExeption("File","id","id",id));

        fileRepository.deleteById(id);
    }
}
