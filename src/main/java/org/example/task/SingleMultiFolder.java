package org.example.task;

import java.util.List;

public class SingleMultiFolder implements MultiFolder{

    private String name;
    private String size;
    private List<Folder> folders;

    public SingleMultiFolder(String name, String size, List<Folder> folders) {
        this.name = name;
        this.size = size;
        this.folders = folders;
    }

    @Override
    public List<Folder> getFolders() {
        return folders;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }
}
