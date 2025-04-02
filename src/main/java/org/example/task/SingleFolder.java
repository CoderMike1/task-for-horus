package org.example.task;

public class SingleFolder implements Folder{

    private String name;
    private String size;

    public SingleFolder(String name, String size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSize() {
        return this.size;
    }
}
