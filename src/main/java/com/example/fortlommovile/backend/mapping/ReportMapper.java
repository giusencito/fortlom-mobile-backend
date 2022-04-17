package com.example.fortlommovile.backend.mapping;
import com.example.fortlommovile.backend.domain.model.entity.Report;
import com.example.fortlommovile.backend.resource.Report.CreateReportResource;
import com.example.fortlommovile.backend.resource.Report.ReportResource;
import com.example.fortlommovile.backend.resource.Report.UpdateReportResource;
import com.example.fortlommovile.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class ReportMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public ReportResource toResource(Report model) {
        return mapper.map(model, ReportResource.class);
    }

    public Page<ReportResource> modelListToPage(List<Report> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ReportResource.class), pageable, modelList.size());
    }
    public Report toModel(CreateReportResource resource) {
        return mapper.map(resource, Report.class);
    }

    public Report toModel(UpdateReportResource resource) {
        return mapper.map(resource, Report.class);
    }
}
