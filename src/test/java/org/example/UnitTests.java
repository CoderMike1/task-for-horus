package org.example;

import org.example.task.FileCabinet;
import static org.junit.jupiter.api.Assertions.*;

import org.example.task.Folder;
import org.example.task.SingleFolder;
import org.example.task.SingleMultiFolder;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class UnitTests {

    @Test
    public void shouldReturnFolderByName(){
        FileCabinet cabinet = new FileCabinet(List.of(
                new SingleFolder("Docs", "SMALL"),
                new SingleMultiFolder("Projects", "MEDIUM", List.of(
                        new SingleFolder("Java", "SMALL"),
                        new SingleMultiFolder("Spring", "LARGE", List.of(
                                new SingleFolder("REST", "SMALL"),
                                new SingleFolder("Security", "MEDIUM")
                        ))
                )),
                new SingleFolder("Pictures", "LARGE")
        ));

        String folder_name_1 = "REST";
        String folder_name_2 = "Spring";
        String folder_name_3 = "Security";

        Optional<Folder> score_1 = cabinet.findFolderByName(folder_name_1);
        Optional<Folder> score_2 = cabinet.findFolderByName(folder_name_2);
        Optional<Folder> score_3 = cabinet.findFolderByName(folder_name_3);

        assertTrue(score_1.isPresent());
        assertTrue(score_2.isPresent());
        assertTrue(score_3.isPresent());
    }
    @Test
    public void shouldReturnEmptyFolderByName(){
        FileCabinet cabinet = new FileCabinet(List.of(
                new SingleFolder("Invoices", "MEDIUM"),
                new SingleMultiFolder("Clients", "LARGE", List.of(
                        new SingleFolder("ClientA", "SMALL"),
                        new SingleMultiFolder("ClientB", "MEDIUM", List.of(
                                new SingleFolder("Contracts", "MEDIUM"),
                                new SingleFolder("Reports", "LARGE")
                        )),
                        new SingleFolder("ClientC", "SMALL")
                )),
                new SingleMultiFolder("Archives", "SMALL", List.of(
                        new SingleMultiFolder("2023", "MEDIUM", List.of(
                                new SingleFolder("Q1", "SMALL"),
                                new SingleFolder("Q2", "SMALL")
                        )),
                        new SingleMultiFolder("2022", "LARGE", List.of(
                                new SingleFolder("Q1", "SMALL"),
                                new SingleFolder("Q2", "MEDIUM"),
                                new SingleFolder("Q3", "LARGE")
                        ))
                )),
                new SingleFolder("HR", "LARGE")
        ));

        Optional<Folder> result = cabinet.findFolderByName("ClientXYZ");

        assertTrue(result.isEmpty());


    }

    @Test
    public void shouldReturnFoldersListBySize(){
        FileCabinet cabinet = new FileCabinet(List.of(
                new SingleFolder("Invoices", "MEDIUM"),
                new SingleMultiFolder("Clients", "LARGE", List.of(
                        new SingleFolder("ClientA", "SMALL"),
                        new SingleMultiFolder("ClientB", "MEDIUM", List.of(
                                new SingleFolder("Contracts", "MEDIUM"),
                                new SingleFolder("Reports", "LARGE")
                        )),
                        new SingleFolder("ClientC", "SMALL")
                )),
                new SingleMultiFolder("Archives", "SMALL", List.of(
                        new SingleMultiFolder("2023", "MEDIUM", List.of(
                                new SingleFolder("Q1", "SMALL"),
                                new SingleFolder("Q2", "SMALL")
                        )),
                        new SingleMultiFolder("2022", "LARGE", List.of(
                                new SingleFolder("Q1", "SMALL"),
                                new SingleFolder("Q2", "MEDIUM"),
                                new SingleFolder("Q3", "LARGE")
                        ))
                )),
                new SingleFolder("HR", "LARGE")
        ));
        String size = "LARGE";
        List<Folder> results = cabinet.findFoldersBySize(size);
        assertEquals(5,results.size());

    }

    @Test
    public void shouldReturnEmptyListFoldersBySize(){
        FileCabinet cabinet = new FileCabinet(List.of(
                new SingleFolder("Finance", "MEDIUM"),
                new SingleMultiFolder("Departments", "LARGE", List.of(
                        new SingleFolder("Marketing", "MEDIUM"),
                        new SingleMultiFolder("Sales", "LARGE", List.of(
                                new SingleFolder("Q1", "MEDIUM"),
                                new SingleFolder("Q2", "LARGE")
                        )),
                        new SingleFolder("Development", "LARGE")
                )),
                new SingleMultiFolder("Archive", "MEDIUM", List.of(
                        new SingleMultiFolder("2023", "LARGE", List.of(
                                new SingleFolder("January", "LARGE"),
                                new SingleFolder("May", "LARGE")
                        )),
                        new SingleMultiFolder("2022", "MEDIUM", List.of(
                                new SingleFolder("March", "MEDIUM"),
                                new SingleFolder("October", "LARGE")
                        ))
                )),
                new SingleFolder("Docs", "LARGE")
        ));
        String size = "SMALL";
        List<Folder> results = cabinet.findFoldersBySize(size);

        assertTrue(results.isEmpty());
    }




    @Test
    public void shouldReturnCorrectAmount(){

        FileCabinet cabinet = new FileCabinet(List.of(
                new SingleFolder("Docs", "SMALL"),
                new SingleMultiFolder("Projects", "MEDIUM", List.of(
                        new SingleFolder("Java", "SMALL"),
                        new SingleMultiFolder("Spring", "LARGE", List.of(
                                new SingleFolder("REST", "SMALL"),
                                new SingleFolder("Security", "MEDIUM")
                        ))
                )),
                new SingleFolder("Pictures", "LARGE")
        ));
        int score = cabinet.count();
        assertEquals(7,score);
    }
    @Test
    public void shouldReturnEmptyAmount(){
        FileCabinet f = new FileCabinet(List.of());

        int score = f.count();

        assertEquals(0,score);
    }




}
