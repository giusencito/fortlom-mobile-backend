package com.example.fortlommovile.backend.api;
import com.example.fortlommovile.backend.domain.model.entity.Report;
import com.example.fortlommovile.backend.domain.service.ReportService;
import com.example.fortlommovile.backend.mapping.ReportMapper;
import com.example.fortlommovile.backend.resource.Report.CreateReportResource;
import com.example.fortlommovile.backend.resource.Report.ReportResource;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;







@RestController
@RequestMapping("/api/v1")
public class ReportController {

    @Autowired
    private ReportService reportservice;

    @Autowired
    private ReportMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @ApiOperation(value="getAllReports",notes = "Esta consulta nos retorna todos los reportes existentes")
    @GetMapping("/reports")
    public Page<ReportResource> getAllRates(Pageable pageable) {
        return mapper.modelListToPage(reportservice.getAll(), pageable);
    }
    @ApiOperation(value="getReportById",notes = "Esta consulta nos ayuda a retorna un reporte segun su id")
    @GetMapping("/reports/{reportId}")
    public ReportResource getRateById(@PathVariable("reportId") Long followId) {
        return mapper.toResource(reportservice.getById(followId));
    }
    @ApiOperation(value="createReport",notes = "Esta consulta nos ayuda a crear un reporte segun el id del usuario principal y del usuario a reportar")
    @PostMapping("/usersmains/{UserMainId}/usersreports/{UserReportedId}/reports")
    public ReportResource createRate(@PathVariable Long UserMainId, @PathVariable Long UserReportedId, @RequestBody CreateReportResource request) {
        Report comment = mapping.map(request, Report.class);
        return mapping.map(reportservice.create(UserMainId, UserReportedId, comment), ReportResource.class);
    }
    @ApiOperation(value="getAllReportsByMainId",notes = "Esta consulta nos retorna todos los reportes segun el id del usuario que va a reportar")
    @GetMapping("/usersmains/{UserMainId}/reports")
    public Page<ReportResource> getAllRatesByFanaticId(@PathVariable Long UserMainId,Pageable pageable) {
        return mapper.modelListToPage(reportservice.findByUserMainId(UserMainId), pageable);
    }
    @ApiOperation(value="getAllReportsByReportedId",notes = "Esta consulta nos retorna todos los reportes segun el id del usuario que es reportado")
    @GetMapping("/usersreports/{UserReportedId}/reports")
    public Page<ReportResource> getAllRateByArtistId(@PathVariable Long UserReportedId,Pageable pageable) {
        return mapper.modelListToPage(reportservice.findByUserReportedId(UserReportedId), pageable);
    }
    @ApiOperation(value="deleteReport",notes = "Esta consulta nos elimina un reporte segun su id")
    @DeleteMapping("/reports/{reportId}")
    public ResponseEntity<?> deleteFollow(@PathVariable Long rateId) {
        return reportservice.delete(rateId);
    }


}
