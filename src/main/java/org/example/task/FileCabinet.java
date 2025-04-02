package org.example.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*
W odpowiedzi na zainteresowanie naszą ofertą pracy chcielibyśmy zaprosić do pierwszego etapu rekrutacji na stanowisko Junior Java Developer w firmie Horus.
Poniżej przekazujemy zadanie z prośbą o analizę poniższego kodu i samodzielne zaimplementowanie metod findFolderByName,
findFolderBySize, count w klasie FolderCabinet - najchętniej unikając powielania kodu i umieszczając całą logikę w klasie FolderCabinet.
Z uwzględnieniem w analizie i implementacji interfejsu MultiFolder!
 */



public class FileCabinet implements Cabinet {
    private List<Folder> folders;

    public FileCabinet(List<Folder> folders){
        this.folders = folders;
    }


    @Override
    public Optional<Folder> findFolderByName(String name) {

        for(Folder folder : getAllFolders(folders)){
            if(folder.getName().equals(name)){
                return Optional.of(folder);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        List<Folder> results = new ArrayList<>();
        for(Folder folder : getAllFolders(folders)){
            if(folder.getSize().equals(size.toUpperCase())){
                results.add(folder);
            }
        }
        return results;
    }
    @Override
    public int count() {
        return getAllFolders(folders).size();
    }

    public List<Folder> getAllFolders(List<Folder> folders){

        List<Folder> allFolders = new ArrayList<>();

        for(Folder folder : folders){

            allFolders.add(folder);

            if(folder instanceof MultiFolder){
                allFolders.addAll(getAllFolders(((MultiFolder) folder).getFolders()));
            }
        }

        return allFolders;

    }



}
