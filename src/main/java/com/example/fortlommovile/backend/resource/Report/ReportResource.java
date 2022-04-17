package com.example.fortlommovile.backend.resource.Report;
import com.example.fortlommovile.backend.resource.Person.PersonResource;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReportResource {
    private Long id;

    private String reportDescription;

    private PersonResource userMain;


    private PersonResource userReported;
}
