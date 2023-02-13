package com.customerarchive.service;

import com.customerarchive.model.File;

import java.util.List;

public interface FileService {

    List<File> getAllFiles();
    File saveFile(File file);
    File updateFile(File file,Long id);
    void deleteFile(Long id);
}
